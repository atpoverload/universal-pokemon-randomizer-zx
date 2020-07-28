package com.dabomstew.pkrandom.romhandlers;

/*----------------------------------------------------------------------------*/
/*--  Gen4RomHandler.java - randomizer handler for D/P/Pt/HG/SS.            --*/
/*--                                                                        --*/
/*--  Part of "Universal Pokemon Randomizer" by Dabomstew                   --*/
/*--  Pokemon and any associated names and the like are                     --*/
/*--  trademark and (C) Nintendo 1996-2012.                                 --*/
/*--                                                                        --*/
/*--  The custom code written here is licensed under the terms of the GPL:  --*/
/*--                                                                        --*/
/*--  This program is free software: you can redistribute it and/or modify  --*/
/*--  it under the terms of the GNU General Public License as published by  --*/
/*--  the Free Software Foundation, either version 3 of the License, or     --*/
/*--  (at your option) any later version.                                   --*/
/*--                                                                        --*/
/*--  This program is distributed in the hope that it will be useful,       --*/
/*--  but WITHOUT ANY WARRANTY; without even the implied warranty of        --*/
/*--  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the          --*/
/*--  GNU General Public License for more details.                          --*/
/*--                                                                        --*/
/*--  You should have received a copy of the GNU General Public License     --*/
/*--  along with this program. If not, see <http://www.gnu.org/licenses/>.  --*/
/*----------------------------------------------------------------------------*/

import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import com.dabomstew.pkrandom.pokemon.*;
import thenewpoketext.PokeTextData;
import thenewpoketext.TextToPoke;

import com.dabomstew.pkrandom.FileFunctions;
import com.dabomstew.pkrandom.GFXFunctions;
import com.dabomstew.pkrandom.MiscTweak;
import com.dabomstew.pkrandom.RomFunctions;
import com.dabomstew.pkrandom.constants.Gen4Constants;
import com.dabomstew.pkrandom.constants.GlobalConstants;
import com.dabomstew.pkrandom.exceptions.RandomizerIOException;
import com.dabomstew.pkrandom.newnds.NARCArchive;

public class Gen4RomHandler extends AbstractDSRomHandler {

    public static class Factory extends RomHandler.Factory {

        @Override
        public Gen4RomHandler create(Random random, PrintStream logStream) {
            return new Gen4RomHandler(random, logStream);
        }

        public boolean isLoadable(String filename) {
            return detectNDSRomInner(getROMCodeFromFile(filename));
        }
    }

    public Gen4RomHandler(Random random) {
        super(random, null);
    }

    public Gen4RomHandler(Random random, PrintStream logStream) {
        super(random, logStream);
    }

    private static class RomEntry {
        private String name;
        private String romCode;
        private int romType;
        private boolean staticPokemonSupport = false, copyStaticPokemon = false;
        private Map<String, String> strings = new HashMap<>();
        private Map<String, String> tweakFiles = new HashMap<>();
        private Map<String, Integer> numbers = new HashMap<>();
        private Map<String, int[]> arrayEntries = new HashMap<>();
        private List<StaticPokemon> staticPokemon = new ArrayList<>();

        private int getInt(String key) {
            if (!numbers.containsKey(key)) {
                numbers.put(key, 0);
            }
            return numbers.get(key);
        }

        private String getString(String key) {
            if (!strings.containsKey(key)) {
                strings.put(key, "");
            }
            return strings.get(key);
        }
    }

    private static List<RomEntry> roms;

    static {
        loadROMInfo();

    }

    private static void loadROMInfo() {
        roms = new ArrayList<>();
        RomEntry current = null;
        try {
            Scanner sc = new Scanner(FileFunctions.openConfig("gen4_offsets.ini"), "UTF-8");
            while (sc.hasNextLine()) {
                String q = sc.nextLine().trim();
                if (q.contains("//")) {
                    q = q.substring(0, q.indexOf("//")).trim();
                }
                if (!q.isEmpty()) {
                    if (q.startsWith("[") && q.endsWith("]")) {
                        // New rom
                        current = new RomEntry();
                        current.name = q.substring(1, q.length() - 1);
                        roms.add(current);
                    } else {
                        String[] r = q.split("=", 2);
                        if (r.length == 1) {
                            System.err.println("invalid entry " + q);
                            continue;
                        }
                        if (r[1].endsWith("\r\n")) {
                            r[1] = r[1].substring(0, r[1].length() - 2);
                        }
                        r[1] = r[1].trim();
                        if (r[0].equals("Game")) {
                            current.romCode = r[1];
                        } else if (r[0].equals("Type")) {
                            if (r[1].equalsIgnoreCase("DP")) {
                                current.romType = Gen4Constants.Type_DP;
                            } else if (r[1].equalsIgnoreCase("Plat")) {
                                current.romType = Gen4Constants.Type_Plat;
                            } else if (r[1].equalsIgnoreCase("HGSS")) {
                                current.romType = Gen4Constants.Type_HGSS;
                            } else {
                                System.err.println("unrecognised rom type: " + r[1]);
                            }
                        } else if (r[0].equals("CopyFrom")) {
                            for (RomEntry otherEntry : roms) {
                                if (r[1].equalsIgnoreCase(otherEntry.romCode)) {
                                    // copy from here
                                    current.arrayEntries.putAll(otherEntry.arrayEntries);
                                    current.numbers.putAll(otherEntry.numbers);
                                    current.strings.putAll(otherEntry.strings);
                                    if (current.copyStaticPokemon) {
                                        current.staticPokemon.addAll(otherEntry.staticPokemon);
                                        current.staticPokemonSupport = true;
                                    } else {
                                        current.staticPokemonSupport = false;
                                    }
                                }
                            }
                        } else if (r[0].equals("StaticPokemon[]")) {
                            if (r[1].startsWith("[") && r[1].endsWith("]")) {
                                String[] offsets = r[1].substring(1, r[1].length() - 1).split(",");
                                int[] offs = new int[offsets.length];
                                int[] files = new int[offsets.length];
                                int c = 0;
                                for (String off : offsets) {
                                    String[] parts = off.split(":");
                                    files[c] = parseRIInt(parts[0]);
                                    offs[c++] = parseRIInt(parts[1]);
                                }
                                StaticPokemon sp = new StaticPokemon();
                                sp.files = files;
                                sp.offsets = offs;
                                current.staticPokemon.add(sp);
                            } else {
                                String[] parts = r[1].split(":");
                                int files = parseRIInt(parts[0]);
                                int offs = parseRIInt(parts[1]);
                                StaticPokemon sp = new StaticPokemon();
                                sp.files = new int[] { files };
                                sp.offsets = new int[] { offs };
                            }
                        } else if (r[0].equals("StaticPokemonSupport")) {
                            int spsupport = parseRIInt(r[1]);
                            current.staticPokemonSupport = (spsupport > 0);
                        } else if (r[0].equals("CopyStaticPokemon")) {
                            int csp = parseRIInt(r[1]);
                            current.copyStaticPokemon = (csp > 0);
                        } else if (r[0].endsWith("Tweak")) {
                            current.tweakFiles.put(r[0], r[1]);
                        } else {
                            if (r[1].startsWith("[") && r[1].endsWith("]")) {
                                String[] offsets = r[1].substring(1, r[1].length() - 1).split(",");
                                if (offsets.length == 1 && offsets[0].trim().isEmpty()) {
                                    current.arrayEntries.put(r[0], new int[0]);
                                } else {
                                    int[] offs = new int[offsets.length];
                                    int c = 0;
                                    for (String off : offsets) {
                                        offs[c++] = parseRIInt(off);
                                    }
                                    current.arrayEntries.put(r[0], offs);
                                }
                            } else if (r[0].endsWith("Offset") || r[0].endsWith("Count") || r[0].endsWith("Number")
                                    || r[0].endsWith("Size")) {
                                int offs = parseRIInt(r[1]);
                                current.numbers.put(r[0], offs);
                            } else {
                                current.strings.put(r[0], r[1]);
                            }
                        }
                    }
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
        }

    }

    private static int parseRIInt(String off) {
        int radix = 10;
        off = off.trim().toLowerCase();
        if (off.startsWith("0x") || off.startsWith("&h")) {
            radix = 16;
            off = off.substring(2);
        }
        try {
            return Integer.parseInt(off, radix);
        } catch (NumberFormatException ex) {
            System.err.println("invalid base " + radix + "number " + off);
            return 0;
        }
    }

    // This rom
    private Pokemon[] pokes;
    private List<Pokemon> pokemonListInclFormes;
    private List<Pokemon> pokemonList;
    private Move[] moves;
    private NARCArchive pokeNarc, moveNarc;
    private NARCArchive msgNarc;
    private NARCArchive scriptNarc;
    private NARCArchive eventNarc;
    private byte[] arm9;
    private List<String> abilityNames;
    private List<String> itemNames;
    private boolean loadedWildMapNames;
    private Map<Integer, String> wildMapNames, headbuttMapNames;
    private ItemList allowedItems, nonBadItems;

    private RomEntry romEntry;

    @Override
    protected boolean detectNDSRom(String ndsCode) {
        return detectNDSRomInner(ndsCode);
    }

    private static boolean detectNDSRomInner(String ndsCode) {
        return entryFor(ndsCode) != null;
    }

    private static RomEntry entryFor(String ndsCode) {
        for (RomEntry re : roms) {
            if (ndsCode.equals(re.romCode)) {
                return re;
            }
        }
        return null;
    }

    @Override
    protected void loadedROM(String romCode) {
        this.romEntry = entryFor(romCode);
        try {
            arm9 = readARM9();
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
        try {
            msgNarc = readNARC(romEntry.getString("Text"));
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
        try {
            scriptNarc = readNARC(romEntry.getString("Scripts"));
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
        try {
            eventNarc = readNARC(romEntry.getString("Events"));
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
        loadPokemonStats();
        pokemonListInclFormes = Arrays.asList(pokes);
        pokemonList = Arrays.asList(Arrays.copyOfRange(pokes,0,Gen4Constants.pokemonCount + 1));
        loadMoves();
        abilityNames = getStrings(romEntry.getInt("AbilityNamesTextOffset"));
        itemNames = getStrings(romEntry.getInt("ItemNamesTextOffset"));
        loadedWildMapNames = false;

        allowedItems = Gen4Constants.allowedItems.copy();
        nonBadItems = Gen4Constants.nonBadItems.copy();
        if (romEntry.romType == Gen4Constants.Type_Plat) {
            ptGiratina = true;
        }
    }

    private void loadMoves() {
        try {
            moveNarc = this.readNARC(romEntry.getString("MoveData"));
            moves = new Move[Gen4Constants.moveCount + 1];
            List<String> moveNames = getStrings(romEntry.getInt("MoveNamesTextOffset"));
            for (int i = 1; i <= Gen4Constants.moveCount; i++) {
                byte[] moveData = moveNarc.files.get(i);
                moves[i] = new Move();
                moves[i].name = moveNames.get(i);
                moves[i].number = i;
                moves[i].internalId = i;
                moves[i].effectIndex = readWord(moveData, 0);
                moves[i].hitratio = (moveData[5] & 0xFF);
                moves[i].power = moveData[3] & 0xFF;
                moves[i].pp = moveData[6] & 0xFF;
                moves[i].type = Gen4Constants.typeTable[moveData[4] & 0xFF];
                moves[i].category = Gen4Constants.moveCategoryIndices[moveData[2] & 0xFF];

                if (i == GlobalConstants.SWIFT_INDEX) {
                    perfectAccuracy = (int)moves[i].hitratio;
                }

                if (GlobalConstants.normalMultihitMoves.contains(i)) {
                    moves[i].hitCount = 3;
                } else if (GlobalConstants.doubleHitMoves.contains(i)) {
                    moves[i].hitCount = 2;
                } else if (i == GlobalConstants.TRIPLE_KICK_INDEX) {
                    moves[i].hitCount = 2.71; // this assumes the first hit
                                              // lands
                }
            }
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }

    }

    private void loadPokemonStats() {
        try {
            String pstatsnarc = romEntry.getString("PokemonStats");
            pokeNarc = this.readNARC(pstatsnarc);
            String[] pokeNames = readPokemonNames();
            int formeCount = Gen4Constants.getFormeCount(romEntry.romType);
            pokes = new Pokemon[Gen4Constants.pokemonCount + formeCount + 1];
            for (int i = 1; i <= Gen4Constants.pokemonCount; i++) {
                pokes[i] = new Pokemon();
                pokes[i].number = i;
                loadBasicPokeStats(pokes[i], pokeNarc.files.get(i));
                // Name?
                pokes[i].name = pokeNames[i];
            }

            int i = Gen4Constants.pokemonCount + 1;
            for (int k: Gen4Constants.formeMappings.keySet()) {
                if (i >= pokes.length) {
                    break;
                }
                pokes[i] = new Pokemon();
                pokes[i].number = i;
                loadBasicPokeStats(pokes[i], pokeNarc.files.get(k));
                pokes[i].name = pokeNames[Gen4Constants.formeMappings.get(k).baseForme];
                pokes[i].baseForme = pokes[Gen4Constants.formeMappings.get(k).baseForme];
                pokes[i].formeNumber = Gen4Constants.formeMappings.get(k).formeNumber;
                pokes[i].formeSuffix = Gen4Constants.formeSuffixes.get(k);
                i = i + 1;
            }

            populateEvolutions();
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }

    }

    private void loadBasicPokeStats(Pokemon pkmn, byte[] stats) {
        pkmn.hp = stats[Gen4Constants.bsHPOffset] & 0xFF;
        pkmn.attack = stats[Gen4Constants.bsAttackOffset] & 0xFF;
        pkmn.defense = stats[Gen4Constants.bsDefenseOffset] & 0xFF;
        pkmn.speed = stats[Gen4Constants.bsSpeedOffset] & 0xFF;
        pkmn.spatk = stats[Gen4Constants.bsSpAtkOffset] & 0xFF;
        pkmn.spdef = stats[Gen4Constants.bsSpDefOffset] & 0xFF;
        // Type
        pkmn.primaryType = Gen4Constants.typeTable[stats[Gen4Constants.bsPrimaryTypeOffset] & 0xFF];
        pkmn.secondaryType = Gen4Constants.typeTable[stats[Gen4Constants.bsSecondaryTypeOffset] & 0xFF];
        // Only one type?
        if (pkmn.secondaryType == pkmn.primaryType) {
            pkmn.secondaryType = null;
        }
        pkmn.catchRate = stats[Gen4Constants.bsCatchRateOffset] & 0xFF;
        pkmn.growthCurve = ExpCurve.fromByte(stats[Gen4Constants.bsGrowthCurveOffset]);

        // Abilities
        pkmn.ability1 = stats[Gen4Constants.bsAbility1Offset] & 0xFF;
        pkmn.ability2 = stats[Gen4Constants.bsAbility2Offset] & 0xFF;

        // Held Items?
        int item1 = readWord(stats, Gen4Constants.bsCommonHeldItemOffset);
        int item2 = readWord(stats, Gen4Constants.bsRareHeldItemOffset);

        if (item1 == item2) {
            // guaranteed
            pkmn.guaranteedHeldItem = item1;
            pkmn.commonHeldItem = 0;
            pkmn.rareHeldItem = 0;
        } else {
            pkmn.guaranteedHeldItem = 0;
            pkmn.commonHeldItem = item1;
            pkmn.rareHeldItem = item2;
        }
        pkmn.darkGrassHeldItem = -1;

        int cosmeticForms = Gen4Constants.cosmeticForms.getOrDefault(pkmn.number,0);
        if (cosmeticForms > 0) {
            pkmn.cosmeticForms = cosmeticForms;
        }
    }

    private String[] readPokemonNames() {
        String[] pokeNames = new String[Gen4Constants.pokemonCount + 1];
        List<String> nameList = getStrings(romEntry.getInt("PokemonNamesTextOffset"));
        for (int i = 1; i <= Gen4Constants.pokemonCount; i++) {
            pokeNames[i] = nameList.get(i);
        }
        return pokeNames;
    }

    @Override
    protected void savingROM() {
        savePokemonStats();
        saveMoves();
        try {
            writeARM9(arm9);
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
        try {
            writeNARC(romEntry.getString("Text"), msgNarc);
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
        try {
            writeNARC(romEntry.getString("Scripts"), scriptNarc);
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
        try {
            writeNARC(romEntry.getString("Events"), eventNarc);
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
    }

    private void saveMoves() {
        for (int i = 1; i <= Gen4Constants.moveCount; i++) {
            byte[] data = moveNarc.files.get(i);
            writeWord(data, 0, moves[i].effectIndex);
            data[2] = Gen4Constants.moveCategoryToByte(moves[i].category);
            data[3] = (byte) moves[i].power;
            data[4] = Gen4Constants.typeToByte(moves[i].type);
            int hitratio = (int) Math.round(moves[i].hitratio);
            if (hitratio < 0) {
                hitratio = 0;
            }
            if (hitratio > 100) {
                hitratio = 100;
            }
            data[5] = (byte) hitratio;
            data[6] = (byte) moves[i].pp;
        }

        try {
            this.writeNARC(romEntry.getString("MoveData"), moveNarc);
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }

    }

    private void savePokemonStats() {
        // Update the "a/an X" list too, if it exists
        List<String> namesList = getStrings(romEntry.getInt("PokemonNamesTextOffset"));
        int formeCount = Gen4Constants.getFormeCount(romEntry.romType);
        if (romEntry.getString("HasExtraPokemonNames").equalsIgnoreCase("Yes")) {
            List<String> namesList2 = getStrings(romEntry.getInt("PokemonNamesTextOffset") + 1);
            for (int i = 1; i <= Gen4Constants.pokemonCount + formeCount; i++) {
                if (i > Gen4Constants.pokemonCount) {
                    saveBasicPokeStats(pokes[i], pokeNarc.files.get(i + Gen4Constants.formeOffset));
                    continue;
                }
                saveBasicPokeStats(pokes[i], pokeNarc.files.get(i));
                String oldName = namesList.get(i);
                namesList.set(i, pokes[i].name);
                namesList2.set(i, namesList2.get(i).replace(oldName, pokes[i].name));
            }
            setStrings(romEntry.getInt("PokemonNamesTextOffset") + 1, namesList2, false);
        } else {
            for (int i = 1; i <= Gen4Constants.pokemonCount + formeCount; i++) {
                if (i > Gen4Constants.pokemonCount) {
                    saveBasicPokeStats(pokes[i], pokeNarc.files.get(i + Gen4Constants.formeOffset));
                    continue;
                }
                saveBasicPokeStats(pokes[i], pokeNarc.files.get(i));
                namesList.set(i, pokes[i].name);
            }
        }
        setStrings(romEntry.getInt("PokemonNamesTextOffset"), namesList, false);

        try {
            String pstatsnarc = romEntry.getString("PokemonStats");
            this.writeNARC(pstatsnarc, pokeNarc);
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }

        writeEvolutions();

    }

    private void saveBasicPokeStats(Pokemon pkmn, byte[] stats) {
        stats[Gen4Constants.bsHPOffset] = (byte) pkmn.hp;
        stats[Gen4Constants.bsAttackOffset] = (byte) pkmn.attack;
        stats[Gen4Constants.bsDefenseOffset] = (byte) pkmn.defense;
        stats[Gen4Constants.bsSpeedOffset] = (byte) pkmn.speed;
        stats[Gen4Constants.bsSpAtkOffset] = (byte) pkmn.spatk;
        stats[Gen4Constants.bsSpDefOffset] = (byte) pkmn.spdef;
        stats[Gen4Constants.bsPrimaryTypeOffset] = Gen4Constants.typeToByte(pkmn.primaryType);
        if (pkmn.secondaryType == null) {
            stats[Gen4Constants.bsSecondaryTypeOffset] = stats[Gen4Constants.bsPrimaryTypeOffset];
        } else {
            stats[Gen4Constants.bsSecondaryTypeOffset] = Gen4Constants.typeToByte(pkmn.secondaryType);
        }
        stats[Gen4Constants.bsCatchRateOffset] = (byte) pkmn.catchRate;
        stats[Gen4Constants.bsGrowthCurveOffset] = pkmn.growthCurve.toByte();

        stats[Gen4Constants.bsAbility1Offset] = (byte) pkmn.ability1;
        stats[Gen4Constants.bsAbility2Offset] = (byte) pkmn.ability2;

        // Held items
        if (pkmn.guaranteedHeldItem > 0) {
            writeWord(stats, Gen4Constants.bsCommonHeldItemOffset, pkmn.guaranteedHeldItem);
            writeWord(stats, Gen4Constants.bsRareHeldItemOffset, pkmn.guaranteedHeldItem);
        } else {
            writeWord(stats, Gen4Constants.bsCommonHeldItemOffset, pkmn.commonHeldItem);
            writeWord(stats, Gen4Constants.bsRareHeldItemOffset, pkmn.rareHeldItem);
        }
    }

    @Override
    public List<Pokemon> getPokemon() {
        return pokemonList;
    }

    @Override
    public List<Pokemon> getPokemonInclFormes() {
        return pokemonListInclFormes; // No formes for now
    }

    @Override
    public List<Pokemon> getAltFormes() {
        int formeCount = Gen4Constants.getFormeCount(romEntry.romType);
        return pokemonListInclFormes.subList(Gen4Constants.pokemonCount + 1, Gen4Constants.pokemonCount + formeCount + 1);
    }

    @Override
    public List<MegaEvolution> getMegaEvolutions() {
        return new ArrayList<>();
    }

    @Override
    public Pokemon getAltFormeOfPokemon(Pokemon pk, int forme) {
        int pokeNum = Gen4Constants.getAbsolutePokeNumByBaseForme(pk.number,forme);
        return pokeNum != 0 ? pokes[pokeNum] : pk;
    }

    @Override
    public List<Pokemon> getStarters() {
        if (romEntry.romType == Gen4Constants.Type_HGSS) {
            List<Integer> tailOffsets = RomFunctions.search(arm9, Gen4Constants.hgssStarterCodeSuffix);
            if (tailOffsets.size() == 1) {
                // Found starters
                int starterOffset = tailOffsets.get(0) - 13;
                int poke1 = readWord(arm9, starterOffset);
                int poke2 = readWord(arm9, starterOffset + 4);
                int poke3 = readWord(arm9, starterOffset + 8);
                return Arrays.asList(pokes[poke1], pokes[poke2], pokes[poke3]);
            } else {
                return Arrays.asList(pokes[Gen4Constants.chikoritaIndex], pokes[Gen4Constants.cyndaquilIndex],
                        pokes[Gen4Constants.totodileIndex]);
            }
        } else {
            try {
                byte[] starterData = readOverlay(romEntry.getInt("StarterPokemonOvlNumber"));
                int poke1 = readWord(starterData, romEntry.getInt("StarterPokemonOffset"));
                int poke2 = readWord(starterData, romEntry.getInt("StarterPokemonOffset") + 4);
                int poke3 = readWord(starterData, romEntry.getInt("StarterPokemonOffset") + 8);
                return Arrays.asList(pokes[poke1], pokes[poke2], pokes[poke3]);
            } catch (IOException e) {
                throw new RandomizerIOException(e);
            }
        }
    }

    @Override
    public boolean setStarters(List<Pokemon> newStarters) {
        if (newStarters.size() != 3) {
            return false;
        }

        if (romEntry.romType == Gen4Constants.Type_HGSS) {
            List<Integer> tailOffsets = RomFunctions.search(arm9, Gen4Constants.hgssStarterCodeSuffix);
            if (tailOffsets.size() == 1) {
                // Found starters
                int starterOffset = tailOffsets.get(0) - 13;
                writeWord(arm9, starterOffset, newStarters.get(0).number);
                writeWord(arm9, starterOffset + 4, newStarters.get(1).number);
                writeWord(arm9, starterOffset + 8, newStarters.get(2).number);
                // Go fix the rival scripts, which rely on fixed pokemon numbers
                // The logic to be changed each time is roughly:
                // Set 0x800C = player starter
                // If(0x800C==152) { trainerbattle rival w/ cynda }
                // ElseIf(0x800C==155) { trainerbattle rival w/ totodile }
                // Else { trainerbattle rival w/ chiko }
                // So we basically have to adjust the 152 and the 155.
                int[] filesWithRivalScript = Gen4Constants.hgssFilesWithRivalScript;
                // below code represents a rival script for sure
                // it means: StoreStarter2 0x800C; If 0x800C 152; CheckLR B_!=
                // <offset to follow>
                byte[] magic = Gen4Constants.hgssRivalScriptMagic;
                NARCArchive scriptNARC = scriptNarc;
                for (int fileCheck : filesWithRivalScript) {
                    byte[] file = scriptNARC.files.get(fileCheck);
                    List<Integer> rivalOffsets = RomFunctions.search(file, magic);
                    if (rivalOffsets.size() == 1) {
                        // found, adjust
                        int baseOffset = rivalOffsets.get(0);
                        // Replace 152 (chiko) with first starter
                        writeWord(file, baseOffset + 8, newStarters.get(0).number);
                        int jumpAmount = readLong(file, baseOffset + 13);
                        int secondBase = jumpAmount + baseOffset + 17;
                        // TODO find out what this constant 0x11 is and remove
                        // it
                        if (file[secondBase] != 0x11 || (file[secondBase + 4] & 0xFF) != Gen4Constants.cyndaquilIndex) {
                            // This isn't what we were expecting...
                        } else {
                            // Replace 155 (cynda) with 2nd starter
                            writeWord(file, secondBase + 4, newStarters.get(1).number);
                        }
                    }
                }
                // Fix starter text
                List<String> spStrings = getStrings(romEntry.getInt("StarterScreenTextOffset"));
                String[] intros = new String[] { "So, you like", "You’ll take", "Do you want" };
                for (int i = 0; i < 3; i++) {
                    Pokemon newStarter = newStarters.get(i);
                    int color = (i == 0) ? 3 : i;
                    String newStarterDesc = "Professor Elm: " + intros[i] + " \\vFF00\\z000" + color + newStarter.name
                            + "\\vFF00\\z0000,\\nthe " + newStarter.primaryType.camelCase() + "-type Pokémon?";
                    spStrings.set(i + 1, newStarterDesc);
                    String altStarterDesc = "\\vFF00\\z000" + color + newStarter.name + "\\vFF00\\z0000, the "
                            + newStarter.primaryType.camelCase() + "-type Pokémon, is\\nin this Poké Ball!";
                    spStrings.set(i + 4, altStarterDesc);
                }
                setStrings(romEntry.getInt("StarterScreenTextOffset"), spStrings);
                return true;
            } else {
                return false;
            }
        } else {
            try {
                byte[] starterData = readOverlay(romEntry.getInt("StarterPokemonOvlNumber"));
                writeWord(starterData, romEntry.getInt("StarterPokemonOffset"), newStarters.get(0).number);
                writeWord(starterData, romEntry.getInt("StarterPokemonOffset") + 4, newStarters.get(1).number);
                writeWord(starterData, romEntry.getInt("StarterPokemonOffset") + 8, newStarters.get(2).number);
                writeOverlay(romEntry.getInt("StarterPokemonOvlNumber"), starterData);
                // Patch DPPt-style rival scripts
                // these have a series of IfJump commands
                // following pokemon IDs
                // the jumps either go to trainer battles, or a HoF times
                // checker, or the StarterBattle command (Pt only)
                // the HoF times checker case is for the Fight Area or Survival
                // Area (depending on version).
                // the StarterBattle case is for Route 201 in Pt.
                int[] filesWithRivalScript = (romEntry.romType == Gen4Constants.Type_Plat) ? Gen4Constants.ptFilesWithRivalScript
                        : Gen4Constants.dpFilesWithRivalScript;
                byte[] magic = Gen4Constants.dpptRivalScriptMagic;
                NARCArchive scriptNARC = scriptNarc;
                for (int fileCheck : filesWithRivalScript) {
                    byte[] file = scriptNARC.files.get(fileCheck);
                    List<Integer> rivalOffsets = RomFunctions.search(file, magic);
                    if (rivalOffsets.size() > 0) {
                        for (int baseOffset : rivalOffsets) {
                            // found, check for trainer battle or HoF
                            // check at jump
                            int jumpLoc = baseOffset + magic.length;
                            int jumpTo = readLong(file, jumpLoc) + jumpLoc + 4;
                            // TODO find out what these constants are and remove
                            // them
                            if (readWord(file, jumpTo) != 0xE5 && readWord(file, jumpTo) != 0x28F
                                    && (readWord(file, jumpTo) != 0x125 || romEntry.romType != Gen4Constants.Type_Plat)) {
                                continue; // not a rival script
                            }
                            // Replace the two starter-words 387 and 390
                            writeWord(file, baseOffset + 0x8, newStarters.get(0).number);
                            writeWord(file, baseOffset + 0x15, newStarters.get(1).number);
                        }
                    }
                }
                // Tag battles with rival or friend
                // Have their own script magic
                // 2 for Lucas/Dawn (=4 occurrences), 1 or 2 for Barry
                byte[] tagBattleMagic = Gen4Constants.dpptTagBattleScriptMagic1;
                byte[] tagBattleMagic2 = Gen4Constants.dpptTagBattleScriptMagic2;
                int[] filesWithTagBattleScript = (romEntry.romType == Gen4Constants.Type_Plat) ? Gen4Constants.ptFilesWithTagScript
                        : Gen4Constants.dpFilesWithTagScript;
                for (int fileCheck : filesWithTagBattleScript) {
                    byte[] file = scriptNARC.files.get(fileCheck);
                    List<Integer> tbOffsets = RomFunctions.search(file, tagBattleMagic);
                    if (tbOffsets.size() > 0) {
                        for (int baseOffset : tbOffsets) {
                            // found, check for second part
                            int secondPartStart = baseOffset + tagBattleMagic.length + 2;
                            if (secondPartStart + tagBattleMagic2.length > file.length) {
                                continue; // match failed
                            }
                            boolean valid = true;
                            for (int spo = 0; spo < tagBattleMagic2.length; spo++) {
                                if (file[secondPartStart + spo] != tagBattleMagic2[spo]) {
                                    valid = false;
                                    break;
                                }
                            }
                            if (!valid) {
                                continue;
                            }
                            // Make sure the jump following the second
                            // part jumps to a <return> command
                            int jumpLoc = secondPartStart + tagBattleMagic2.length;
                            int jumpTo = readLong(file, jumpLoc) + jumpLoc + 4;
                            // TODO find out what this constant is and remove it
                            if (readWord(file, jumpTo) != 0x1B) {
                                continue; // not a tag battle script
                            }
                            // Replace the two starter-words
                            if (readWord(file, baseOffset + 0x21) == Gen4Constants.turtwigIndex) {
                                // first starter
                                writeWord(file, baseOffset + 0x21, newStarters.get(0).number);
                            } else {
                                // third starter
                                writeWord(file, baseOffset + 0x21, newStarters.get(2).number);
                            }
                            // second starter
                            writeWord(file, baseOffset + 0xE, newStarters.get(1).number);
                        }
                    }
                }
                // Fix starter script text
                // The starter picking screen
                List<String> spStrings = getStrings(romEntry.getInt("StarterScreenTextOffset"));
                // Get pokedex info
                List<String> pokedexSpeciesStrings = getStrings(romEntry.getInt("PokedexSpeciesTextOffset"));
                for (int i = 0; i < 3; i++) {
                    Pokemon newStarter = newStarters.get(i);
                    int color = (i == 0) ? 3 : i;
                    String newStarterDesc = "\\vFF00\\z000" + color + pokedexSpeciesStrings.get(newStarter.number)
                            + " " + newStarter.name + "\\vFF00\\z0000!\\nWill you take this Pokémon?";
                    spStrings.set(i + 1, newStarterDesc);
                }
                // rewrite starter picking screen
                setStrings(romEntry.getInt("StarterScreenTextOffset"), spStrings);
                if (romEntry.romType == Gen4Constants.Type_DP) {
                    // what rival says after we get the Pokemon
                    List<String> lakeStrings = getStrings(romEntry.getInt("StarterLocationTextOffset"));
                    lakeStrings
                            .set(Gen4Constants.dpStarterStringIndex,
                                    "\\v0103\\z0000: Fwaaah!\\nYour Pokémon totally rocked!\\pBut mine was way tougher\\nthan yours!\\p...They were other people’s\\nPokémon, though...\\pBut we had to use them...\\nThey won’t mind, will they?\\p");
                    setStrings(romEntry.getInt("StarterLocationTextOffset"), lakeStrings);
                } else {
                    // what rival says after we get the Pokemon
                    List<String> r201Strings = getStrings(romEntry.getInt("StarterLocationTextOffset"));
                    r201Strings.set(Gen4Constants.ptStarterStringIndex,
                            "\\v0103\\z0000\\z0000: Then, I choose you!\\nI’m picking this one!\\p");
                    setStrings(romEntry.getInt("StarterLocationTextOffset"), r201Strings);
                }
            } catch (IOException e) {
                throw new RandomizerIOException(e);
            }
            return true;
        }
    }

    @Override
    public List<Integer> getStarterHeldItems() {
        // do nothing
        return new ArrayList<>();
    }

    @Override
    public void setStarterHeldItems(List<Integer> items) {
        // do nothing
    }

    @Override
    public List<Move> getMoves() {
        return Arrays.asList(moves);
    }

    @Override
    public List<EncounterSet> getEncounters(boolean useTimeOfDay) {
        if (!loadedWildMapNames) {
            loadWildMapNames();
        }

        try {
            if (romEntry.romType == Gen4Constants.Type_HGSS) {
                return getEncountersHGSS(useTimeOfDay);
            } else {
                return getEncountersDPPt(useTimeOfDay);
            }
        } catch (IOException ex) {
            throw new RandomizerIOException(ex);
        }
    }

    private List<EncounterSet> getEncountersDPPt(boolean useTimeOfDay) throws IOException {
        // Determine file to use
        String encountersFile = romEntry.getString("WildPokemon");

        NARCArchive encounterData = readNARC(encountersFile);
        List<EncounterSet> encounters = new ArrayList<>();
        // Credit for
        // https://github.com/magical/pokemon-encounters/blob/master/nds/encounters-gen4-sinnoh.py
        // for the structure for this.
        int c = -1;
        for (byte[] b : encounterData.files) {
            c++;
            if (!wildMapNames.containsKey(c)) {
                wildMapNames.put(c, "? Unknown ?");
            }
            String mapName = wildMapNames.get(c);
            int grassRate = readLong(b, 0);
            if (grassRate != 0) {
                // up to 4
                List<Encounter> grassEncounters = readEncountersDPPt(b, 4, 12);
                EncounterSet grass = new EncounterSet();
                grass.displayName = mapName + " Grass/Cave";
                grass.encounters = grassEncounters;
                grass.rate = grassRate;
                grass.offset = c;
                encounters.add(grass);

                // Time of day replacements?
                if (useTimeOfDay) {
                    for (int i = 0; i < 4; i++) {
                        int pknum = readLong(b, 108 + 4 * i);
                        if (pknum >= 1 && pknum <= Gen4Constants.pokemonCount) {
                            Pokemon pk = pokes[pknum];
                            Encounter enc = new Encounter();
                            enc.level = grassEncounters.get(Gen4Constants.dpptAlternateSlots[i + 2]).level;
                            enc.pokemon = pk;
                            grassEncounters.add(enc);
                        }
                    }
                }
                // (if useTimeOfDay is off, just override them later)

                // Other conditional replacements (swarm, radar, GBA)
                EncounterSet conds = new EncounterSet();
                conds.displayName = mapName + " Swarm/Radar/GBA";
                conds.rate = grassRate;
                conds.offset = c;
                for (int i = 0; i < 20; i++) {
                    if (i >= 2 && i <= 5) {
                        // Time of day slot, handled already
                        continue;
                    }
                    int offs = 100 + i * 4 + (i >= 10 ? 24 : 0);
                    int pknum = readLong(b, offs);
                    if (pknum >= 1 && pknum <= Gen4Constants.pokemonCount) {
                        Pokemon pk = pokes[pknum];
                        Encounter enc = new Encounter();
                        enc.level = grassEncounters.get(Gen4Constants.dpptAlternateSlots[i]).level;
                        enc.pokemon = pk;
                        conds.encounters.add(enc);
                    }
                }
                if (conds.encounters.size() > 0) {
                    encounters.add(conds);
                }
            }

            // up to 204, 5 sets of "sea" encounters to go
            int offset = 204;
            for (int i = 0; i < 5; i++) {
                int rate = readLong(b, offset);
                offset += 4;
                List<Encounter> encountersHere = readSeaEncountersDPPt(b, offset, 5);
                offset += 40;
                if (rate == 0 || i == 1) {
                    continue;
                }
                EncounterSet other = new EncounterSet();
                other.displayName = mapName + " " + Gen4Constants.dpptWaterSlotSetNames[i];
                other.offset = c;
                other.encounters = encountersHere;
                other.rate = rate;
                encounters.add(other);
            }
        }

        // Now do the extra encounters (Feebas tiles, honey trees, Great Marsh rotating Pokemon, etc.)
        String extraEncountersFile = romEntry.getString("ExtraEncounters");
        NARCArchive extraEncounterData = readNARC(extraEncountersFile);

        // Feebas tiles
        byte[] feebasData = extraEncounterData.files.get(0);
        EncounterSet feebasEncounters = readExtraEncountersDPPt(feebasData, 0, 1);
        feebasEncounters.displayName = "Mt. Coronet Feebas Tiles";
        encounters.add(feebasEncounters);

        // Honey trees
        int[] honeyTreeOffsets = romEntry.arrayEntries.get("HoneyTreeOffsets");
        for (int i = 0; i < honeyTreeOffsets.length; i++) {
            byte[] honeyTreeData = extraEncounterData.files.get(honeyTreeOffsets[i]);
            EncounterSet honeyTreeEncounters = readExtraEncountersDPPt(honeyTreeData, 0, 6);
            honeyTreeEncounters.displayName = "Honey Tree Group " + (i + 1);
            encounters.add(honeyTreeEncounters);
        }

        // Great Marsh rotating Pokemon
        int[] greatMarshOffsets = new int[]{9, 10};
        for (int i = 0; i < greatMarshOffsets.length; i++) {
            byte[] greatMarshData = extraEncounterData.files.get(greatMarshOffsets[i]);
            EncounterSet greatMarshEncounters = readExtraEncountersDPPt(greatMarshData, 0, 32);
            String pokedexStatus = i == 0 ? "(Post-National Dex)" : "(Pre-National Dex)";
            greatMarshEncounters.displayName = "Great Marsh Rotating Pokemon " + pokedexStatus;
            encounters.add(greatMarshEncounters);
        }
        return encounters;
    }

    private List<Encounter> readEncountersDPPt(byte[] data, int offset, int amount) {
        List<Encounter> encounters = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            int level = readLong(data, offset + i * 8);
            int pokemon = readLong(data, offset + 4 + i * 8);
            Encounter enc = new Encounter();
            enc.level = level;
            enc.pokemon = pokes[pokemon];
            encounters.add(enc);
        }
        return encounters;
    }

    private List<Encounter> readSeaEncountersDPPt(byte[] data, int offset, int amount) {
        List<Encounter> encounters = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            int level = readLong(data, offset + i * 8);
            int pokemon = readLong(data, offset + 4 + i * 8);
            Encounter enc = new Encounter();
            enc.level = level >> 8;
            enc.maxLevel = level & 0xFF;
            enc.pokemon = pokes[pokemon];
            encounters.add(enc);
        }
        return encounters;
    }

    private EncounterSet readExtraEncountersDPPt(byte[] data, int offset, int amount) {
        EncounterSet es = new EncounterSet();
        es.rate = 1;
        for (int i = 0; i < amount; i++) {
            int pokemon = readLong(data, offset + i * 4);
            Encounter e = new Encounter();
            e.level = 1;
            e.pokemon = pokes[pokemon];
            es.encounters.add(e);
        }
        return es;
    }

    private List<EncounterSet> getEncountersHGSS(boolean useTimeOfDay) throws IOException {
        String encountersFile = romEntry.getString("WildPokemon");
        NARCArchive encounterData = readNARC(encountersFile);
        List<EncounterSet> encounters = new ArrayList<>();
        // Credit for
        // https://github.com/magical/pokemon-encounters/blob/master/nds/encounters-gen4-johto.py
        // for the structure for this.
        int[] amounts = new int[] { 0, 5, 2, 5, 5, 5 };
        int c = -1;
        for (byte[] b : encounterData.files) {
            c++;
            if (!wildMapNames.containsKey(c)) {
                wildMapNames.put(c, "? Unknown ?");
            }
            String mapName = wildMapNames.get(c);
            int[] rates = new int[6];
            rates[0] = b[0] & 0xFF;
            rates[1] = b[1] & 0xFF;
            rates[2] = b[2] & 0xFF;
            rates[3] = b[3] & 0xFF;
            rates[4] = b[4] & 0xFF;
            rates[5] = b[5] & 0xFF;
            // Up to 8 after the rates
            // Grass has to be handled on its own because the levels
            // are reused for every time of day
            int[] grassLevels = new int[12];
            for (int i = 0; i < 12; i++) {
                grassLevels[i] = b[8 + i] & 0xFF;
            }
            // Up to 20 now (12 for levels)
            Pokemon[][] grassPokes = new Pokemon[3][12];
            grassPokes[0] = readPokemonHGSS(b, 20, 12);
            grassPokes[1] = readPokemonHGSS(b, 44, 12);
            grassPokes[2] = readPokemonHGSS(b, 68, 12);
            // Up to 92 now (12*2*3 for pokemon)
            if (rates[0] != 0) {
                if (!useTimeOfDay) {
                    // Just write "day" encounters
                    List<Encounter> grassEncounters = stitchEncsToLevels(grassPokes[1], grassLevels);
                    EncounterSet grass = new EncounterSet();
                    grass.encounters = grassEncounters;
                    grass.rate = rates[0];
                    grass.displayName = mapName + " Grass/Cave";
                    encounters.add(grass);
                } else {
                    for (int i = 0; i < 3; i++) {
                        EncounterSet grass = new EncounterSet();
                        grass.encounters = stitchEncsToLevels(grassPokes[i], grassLevels);
                        grass.rate = rates[0];
                        grass.displayName = mapName + " " + Gen4Constants.hgssTimeOfDayNames[i] + " Grass/Cave";
                        encounters.add(grass);
                    }
                }
            }

            // Hoenn/Sinnoh Radio
            EncounterSet radio = readOptionalEncountersHGSS(b, 92, 4);
            radio.displayName = mapName + " Hoenn/Sinnoh Radio";
            if (radio.encounters.size() > 0) {
                encounters.add(radio);
            }

            // Up to 100 now... 2*2*2 for radio pokemon
            int offset = 100;
            for (int i = 1; i < 6; i++) {
                List<Encounter> encountersHere = readSeaEncountersHGSS(b, offset, amounts[i]);
                offset += 4 * amounts[i];
                if (rates[i] != 0) {
                    // Valid area.
                    EncounterSet other = new EncounterSet();
                    other.encounters = encountersHere;
                    other.displayName = mapName + " " + Gen4Constants.hgssNonGrassSetNames[i];
                    other.rate = rates[i];
                    encounters.add(other);
                }
            }

            // Swarms
            EncounterSet swarms = readOptionalEncountersHGSS(b, offset, 4);
            swarms.displayName = mapName + " Swarms";
            if (swarms.encounters.size() > 0) {
                encounters.add(swarms);
            }
        }

        // Headbutt Encounters
        String headbuttEncountersFile = romEntry.getString("HeadbuttPokemon");
        NARCArchive headbuttEncounterData = readNARC(headbuttEncountersFile);
        c = -1;
        for (byte[] b : headbuttEncounterData.files) {
            c++;

            // Each headbutt encounter file starts with four bytes, which I believe are used
            // to indicate the number of "normal" and "special" trees that are available in
            // this area. For areas that don't contain any headbutt encounters, these four
            // bytes constitute the only four bytes in the file, so we can stop looking at
            // this file in this case.
            if (b.length == 4) {
                continue;
            }

            String mapName = headbuttMapNames.get(c);
            EncounterSet headbuttEncounters = readHeadbuttEncountersHGSS(b, 4, 18);
            headbuttEncounters.displayName = mapName + " Headbutt";

            // Map 24 is an unused version of Route 16, but it still has valid headbutt encounter data.
            // Avoid adding it to the list of encounters to prevent confusion.
            if (headbuttEncounters.encounters.size() > 0 && c != 24) {
                encounters.add(headbuttEncounters);
            }
        }
        return encounters;
    }

    private EncounterSet readOptionalEncountersHGSS(byte[] data, int offset, int amount) {
        EncounterSet es = new EncounterSet();
        es.rate = 1;
        for (int i = 0; i < amount; i++) {
            int pokemon = readWord(data, offset + i * 2);
            if (pokemon != 0) {
                Encounter e = new Encounter();
                e.level = 1;
                e.pokemon = pokes[pokemon];
                es.encounters.add(e);
            }
        }
        return es;
    }

    private Pokemon[] readPokemonHGSS(byte[] data, int offset, int amount) {
        Pokemon[] pokesHere = new Pokemon[amount];
        for (int i = 0; i < amount; i++) {
            pokesHere[i] = pokes[readWord(data, offset + i * 2)];
        }
        return pokesHere;
    }

    private List<Encounter> readSeaEncountersHGSS(byte[] data, int offset, int amount) {
        List<Encounter> encounters = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            int level = readWord(data, offset + i * 4);
            int pokemon = readWord(data, offset + 2 + i * 4);
            Encounter enc = new Encounter();
            enc.level = level & 0xFF;
            enc.maxLevel = level >> 8;
            enc.pokemon = pokes[pokemon];
            encounters.add(enc);
        }
        return encounters;
    }

    private EncounterSet readHeadbuttEncountersHGSS(byte[] data, int offset, int amount) {
        EncounterSet es = new EncounterSet();
        es.rate = 1;
        for (int i = 0; i < amount; i++) {
            int pokemon = readWord(data, offset + i * 4);
            if (pokemon != 0) {
                Encounter enc = new Encounter();
                enc.level = data[offset + 2 + i * 4];
                enc.maxLevel = data[offset + 3 + i * 4];
                enc.pokemon = pokes[pokemon];
                es.encounters.add(enc);
            }
        }
        return es;
    }

    @Override
    public void setEncounters(boolean useTimeOfDay, List<EncounterSet> encounters) {
        try {
            if (romEntry.romType == Gen4Constants.Type_HGSS) {
                setEncountersHGSS(useTimeOfDay, encounters);
            } else {
                setEncountersDPPt(useTimeOfDay, encounters);
            }
        } catch (IOException ex) {
            throw new RandomizerIOException(ex);
        }
    }

    private void setEncountersDPPt(boolean useTimeOfDay, List<EncounterSet> encounterList) throws IOException {
        // Determine file to use
        String encountersFile = romEntry.getString("WildPokemon");
        NARCArchive encounterData = readNARC(encountersFile);
        Iterator<EncounterSet> encounters = encounterList.iterator();
        // Credit for
        // https://github.com/magical/pokemon-encounters/blob/master/nds/encounters-gen4-sinnoh.py
        // for the structure for this.
        for (byte[] b : encounterData.files) {
            int grassRate = readLong(b, 0);
            if (grassRate != 0) {
                // grass encounters are a-go
                EncounterSet grass = encounters.next();
                writeEncountersDPPt(b, 4, grass.encounters, 12);

                // Time of day encounters?
                int todEncounterSlot = 12;
                for (int i = 0; i < 4; i++) {
                    int pknum = readLong(b, 108 + 4 * i);
                    if (pknum >= 1 && pknum <= Gen4Constants.pokemonCount) {
                        // Valid time of day slot
                        if (useTimeOfDay) {
                            // Get custom randomized encounter
                            Pokemon pk = grass.encounters.get(todEncounterSlot++).pokemon;
                            writeLong(b, 108 + 4 * i, pk.number);
                        } else {
                            // Copy the original slot's randomized encounter
                            Pokemon pk = grass.encounters.get(Gen4Constants.dpptAlternateSlots[i + 2]).pokemon;
                            writeLong(b, 108 + 4 * i, pk.number);
                        }
                    }
                }

                // Other conditional encounters?
                Iterator<Encounter> condEncounters = null;
                for (int i = 0; i < 20; i++) {
                    if (i >= 2 && i <= 5) {
                        // Time of day slot, handled already
                        continue;
                    }
                    int offs = 100 + i * 4 + (i >= 10 ? 24 : 0);
                    int pknum = readLong(b, offs);
                    if (pknum >= 1 && pknum <= Gen4Constants.pokemonCount) {
                        // This slot is used, grab a replacement.
                        if (condEncounters == null) {
                            // Fetch the set of conditional encounters for this
                            // area now that we know it's necessary and exists.
                            condEncounters = encounters.next().encounters.iterator();
                        }
                        Pokemon pk = condEncounters.next().pokemon;
                        writeLong(b, offs, pk.number);
                    }
                }
            }
            // up to 204, 5 special ones to go
            // This is for surf, filler, old rod, good rod, super rod
            // so we skip index 1 (filler)
            int offset = 204;
            for (int i = 0; i < 5; i++) {
                int rate = readLong(b, offset);
                offset += 4;
                if (rate == 0 || i == 1) {
                    offset += 40;
                    continue;
                }

                EncounterSet other = encounters.next();
                writeSeaEncountersDPPt(b, offset, other.encounters);
                offset += 40;
            }
        }

        // Save
        writeNARC(encountersFile, encounterData);

        // Now do the extra encounters (Feebas tiles, honey trees, Great Marsh rotating Pokemon, etc.)
        String extraEncountersFile = romEntry.getString("ExtraEncounters");
        NARCArchive extraEncounterData = readNARC(extraEncountersFile);

        // Feebas tiles
        byte[] feebasData = extraEncounterData.files.get(0);
        EncounterSet feebasEncounters = encounters.next();
        writeExtraEncountersDPPt(feebasData, 0, feebasEncounters.encounters);

        // Honey trees
        int[] honeyTreeOffsets = romEntry.arrayEntries.get("HoneyTreeOffsets");
        for (int i = 0; i < honeyTreeOffsets.length; i++) {
            byte[] honeyTreeData = extraEncounterData.files.get(honeyTreeOffsets[i]);
            EncounterSet honeyTreeEncounters = encounters.next();
            writeExtraEncountersDPPt(honeyTreeData, 0, honeyTreeEncounters.encounters);
        }

        // Great Marsh rotating Pokemon
        int[] greatMarshOffsets = new int[]{9, 10};
        for (int i = 0; i < greatMarshOffsets.length; i++) {
            byte[] greatMarshData = extraEncounterData.files.get(greatMarshOffsets[i]);
            EncounterSet greatMarshEncounters = encounters.next();
            writeExtraEncountersDPPt(greatMarshData, 0, greatMarshEncounters.encounters);
        }

        // Save
        writeNARC(extraEncountersFile, extraEncounterData);

    }

    private void writeEncountersDPPt(byte[] data, int offset, List<Encounter> encounters, int enclength) {
        for (int i = 0; i < enclength; i++) {
            Encounter enc = encounters.get(i);
            writeLong(data, offset + i * 8, enc.level);
            writeLong(data, offset + i * 8 + 4, enc.pokemon.number);
        }
    }

    private void writeSeaEncountersDPPt(byte[] data, int offset, List<Encounter> encounters) {
        int enclength = encounters.size();
        for (int i = 0; i < enclength; i++) {
            Encounter enc = encounters.get(i);
            writeLong(data, offset + i * 8, (enc.level << 8) + enc.maxLevel);
            writeLong(data, offset + i * 8 + 4, enc.pokemon.number);
        }
    }

    private void writeExtraEncountersDPPt(byte[] data, int offset, List<Encounter> encounters) {
        int enclength = encounters.size();
        for (int i = 0; i < enclength; i++) {
            Encounter enc = encounters.get(i);
            writeLong(data, offset + i * 4, enc.pokemon.number);
        }
    }

    private void setEncountersHGSS(boolean useTimeOfDay, List<EncounterSet> encounterList) throws IOException {
        String encountersFile = romEntry.getString("WildPokemon");
        NARCArchive encounterData = readNARC(encountersFile);
        Iterator<EncounterSet> encounters = encounterList.iterator();
        // Credit for
        // https://github.com/magical/pokemon-encounters/blob/master/nds/encounters-gen4-johto.py
        // for the structure for this.
        int[] amounts = new int[] { 0, 5, 2, 5, 5, 5 };
        for (byte[] b : encounterData.files) {
            int[] rates = new int[6];
            rates[0] = b[0] & 0xFF;
            rates[1] = b[1] & 0xFF;
            rates[2] = b[2] & 0xFF;
            rates[3] = b[3] & 0xFF;
            rates[4] = b[4] & 0xFF;
            rates[5] = b[5] & 0xFF;
            // Up to 20 after the rates & levels
            // Grass has to be handled on its own because the levels
            // are reused for every time of day
            if (rates[0] != 0) {
                if (!useTimeOfDay) {
                    // Get a single set of encounters...
                    // Write the encounters we get 3x for morning, day, night
                    EncounterSet grass = encounters.next();
                    writeGrassEncounterLevelsHGSS(b, 8, grass.encounters);
                    writePokemonHGSS(b, 20, grass.encounters);
                    writePokemonHGSS(b, 44, grass.encounters);
                    writePokemonHGSS(b, 68, grass.encounters);
                } else {
                    EncounterSet grass = encounters.next();
                    writeGrassEncounterLevelsHGSS(b, 8, grass.encounters);
                    writePokemonHGSS(b, 20, grass.encounters);
                    for (int i = 1; i < 3; i++) {
                        grass = encounters.next();
                        writePokemonHGSS(b, 20 + i * 24, grass.encounters);
                    }
                }
            }

            // Write radio pokemon
            writeOptionalEncountersHGSS(b, 92, 4, encounters);

            // Up to 100 now... 2*2*2 for radio pokemon
            // Write rock smash, surf, et al
            int offset = 100;
            for (int i = 1; i < 6; i++) {
                if (rates[i] != 0) {
                    // Valid area.
                    EncounterSet other = encounters.next();
                    writeSeaEncountersHGSS(b, offset, other.encounters);
                }
                offset += 4 * amounts[i];
            }

            // Write swarm pokemon
            writeOptionalEncountersHGSS(b, offset, 4, encounters);
        }

        // Save
        writeNARC(encountersFile, encounterData);

        // Write Headbutt encounters
        String headbuttEncountersFile = romEntry.getString("HeadbuttPokemon");
        NARCArchive headbuttEncounterData = readNARC(headbuttEncountersFile);
        int c = -1;
        for (byte[] b : headbuttEncounterData.files) {
            c++;

            // In getEncountersHGSS, we ignored maps with no headbutt encounter data,
            // and we also ignored map 24 for being unused. We need to ignore them
            // here as well to keep encounters.next() in sync with the correct file.
            if (b.length == 4 || c == 24) {
                continue;
            }

            EncounterSet headbutt = encounters.next();
            writeHeadbuttEncountersHGSS(b, 4, headbutt.encounters);
        }

        // Save
        writeNARC(headbuttEncountersFile, headbuttEncounterData);
        
    }

    private void writeOptionalEncountersHGSS(byte[] data, int offset, int amount, Iterator<EncounterSet> encounters) {
        Iterator<Encounter> eIter = null;
        for (int i = 0; i < amount; i++) {
            int origPokemon = readWord(data, offset + i * 2);
            if (origPokemon != 0) {
                // Need an encounter set, yes.
                if (eIter == null) {
                    eIter = encounters.next().encounters.iterator();
                }
                Encounter here = eIter.next();
                writeWord(data, offset + i * 2, here.pokemon.number);
            }
        }

    }

    private void writeGrassEncounterLevelsHGSS(byte[] data, int offset, List<Encounter> encounters) {
        int enclength = encounters.size();
        for (int i = 0; i < enclength; i++) {
            data[offset + i] = (byte) encounters.get(i).level;
        }

    }

    private void writePokemonHGSS(byte[] data, int offset, List<Encounter> encounters) {
        int enclength = encounters.size();
        for (int i = 0; i < enclength; i++) {
            writeWord(data, offset + i * 2, encounters.get(i).pokemon.number);
        }

    }

    private void writeSeaEncountersHGSS(byte[] data, int offset, List<Encounter> encounters) {
        int enclength = encounters.size();
        for (int i = 0; i < enclength; i++) {
            Encounter enc = encounters.get(i);
            data[offset + i * 4] = (byte) enc.level;
            data[offset + i * 4 + 1] = (byte) enc.maxLevel;
            writeWord(data, offset + i * 4 + 2, enc.pokemon.number);
        }

    }

    private void writeHeadbuttEncountersHGSS(byte[] data, int offset, List<Encounter> encounters) {
        int enclength = encounters.size();
        for (int i = 0; i < enclength; i++) {
            Encounter enc = encounters.get(i);
            writeWord(data, offset + i * 4, enc.pokemon.number);
            data[offset + 2 + i * 4] = (byte) enc.level;
            data[offset + 3 + i * 4] = (byte) enc.maxLevel;
        }
    }

    private List<Encounter> stitchEncsToLevels(Pokemon[] pokemon, int[] levels) {
        List<Encounter> encounters = new ArrayList<>();
        for (int i = 0; i < pokemon.length; i++) {
            Encounter enc = new Encounter();
            enc.level = levels[i];
            enc.pokemon = pokemon[i];
            encounters.add(enc);
        }
        return encounters;
    }

    private void loadWildMapNames() {
        try {
            wildMapNames = new HashMap<>();
            headbuttMapNames = new HashMap<>();
            byte[] internalNames = this.readFile(romEntry.getString("MapTableFile"));
            int numMapHeaders = internalNames.length / 16;
            int baseMHOffset = romEntry.getInt("MapTableARM9Offset");
            List<String> allMapNames = getStrings(romEntry.getInt("MapNamesTextOffset"));
            int mapNameIndexSize = romEntry.getInt("MapTableNameIndexSize");
            for (int map = 0; map < numMapHeaders; map++) {
                int baseOffset = baseMHOffset + map * 24;
                int mapNameIndex = (mapNameIndexSize == 2) ? readWord(arm9, baseOffset + 18)
                        : (arm9[baseOffset + 18] & 0xFF);
                String mapName = allMapNames.get(mapNameIndex);
                if (romEntry.romType == Gen4Constants.Type_HGSS) {
                    int wildSet = arm9[baseOffset] & 0xFF;
                    if (wildSet != 255) {
                        wildMapNames.put(wildSet, mapName);
                    }
                    headbuttMapNames.put(map, mapName);
                } else {
                    int wildSet = readWord(arm9, baseOffset + 14);
                    if (wildSet != 65535) {
                        wildMapNames.put(wildSet, mapName);
                    }
                }
            }
            loadedWildMapNames = true;
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }

    }

    @Override
    public List<Trainer> getTrainers() {
        List<Trainer> allTrainers = new ArrayList<>();
        try {
            NARCArchive trainers = this.readNARC(romEntry.getString("TrainerData"));
            NARCArchive trpokes = this.readNARC(romEntry.getString("TrainerPokemon"));
            List<String> tclasses = this.getTrainerClassNames();
            List<String> tnames = this.getTrainerNames();
            int trainernum = trainers.files.size();
            for (int i = 1; i < trainernum; i++) {
                byte[] trainer = trainers.files.get(i);
                byte[] trpoke = trpokes.files.get(i);
                Trainer tr = new Trainer();
                tr.poketype = trainer[0] & 0xFF;
                tr.trainerclass = trainer[1] & 0xFF;
                tr.offset = i;
                int numPokes = trainer[3] & 0xFF;
                int pokeOffs = 0;
                tr.fullDisplayName = tclasses.get(tr.trainerclass) + " " + tnames.get(i - 1);
                // printBA(trpoke);
                for (int poke = 0; poke < numPokes; poke++) {
                    int ailevel = trpoke[pokeOffs] & 0xFF;
                    int level = trpoke[pokeOffs + 2] & 0xFF;
                    int species = (trpoke[pokeOffs + 4] & 0xFF) + ((trpoke[pokeOffs + 5] & 0x01) << 8);
                    int formnum = (trpoke[pokeOffs + 5] >> 2);
                    TrainerPokemon tpk = new TrainerPokemon();
                    tpk.level = level;
                    tpk.pokemon = pokes[species];
                    tpk.AILevel = ailevel;
                    tpk.ability = trpoke[pokeOffs + 1] & 0xFF;
                    tpk.forme = formnum;
                    tpk.formeSuffix = Gen4Constants.getFormeSuffixByBaseForme(species,formnum);
                    tpk.absolutePokeNumber = Gen4Constants.getAbsolutePokeNumByBaseForme(species,formnum);
                    pokeOffs += 6;
                    if ((tr.poketype & 2) == 2) {
                        tpk.heldItem = readWord(trpoke, pokeOffs);
                        pokeOffs += 2;
                    }
                    if ((tr.poketype & 1) == 1) {
                        int attack1 = readWord(trpoke, pokeOffs);
                        int attack2 = readWord(trpoke, pokeOffs + 2);
                        int attack3 = readWord(trpoke, pokeOffs + 4);
                        int attack4 = readWord(trpoke, pokeOffs + 6);
                        tpk.move1 = attack1;
                        tpk.move2 = attack2;
                        tpk.move3 = attack3;
                        tpk.move4 = attack4;
                        pokeOffs += 8;
                    }
                    // Plat/HGSS have another random pokeOffs +=2 here.
                    if (romEntry.romType != Gen4Constants.Type_DP) {
                        pokeOffs += 2;
                    }
                    tr.pokemon.add(tpk);
                }
                allTrainers.add(tr);
            }
            if (romEntry.romType == Gen4Constants.Type_DP) {
                Gen4Constants.tagTrainersDP(allTrainers);
            } else if (romEntry.romType == Gen4Constants.Type_Plat) {
                Gen4Constants.tagTrainersPt(allTrainers);
            } else {
                Gen4Constants.tagTrainersHGSS(allTrainers);
            }
        } catch (IOException ex) {
            throw new RandomizerIOException(ex);
        }
        return allTrainers;
    }

    @Override
    public List<Integer> getMainPlaythroughTrainers() {
        return new ArrayList<>(); // Not implemented
    }

    @Override
    public String[] getShopNames() {
        return null;
    }
    @Override
    public List<Integer> getEvolutionItems() {
        return null;
    }
    @Override
    public void setTrainers(List<Trainer> trainerData, boolean doubleBattleMode) {
        Iterator<Trainer> allTrainers = trainerData.iterator();
        try {
            NARCArchive trainers = this.readNARC(romEntry.getString("TrainerData"));
            NARCArchive trpokes = new NARCArchive();

            // Get current movesets in case we need to reset them for certain
            // trainer mons.
            Map<Integer, List<MoveLearnt>> movesets = this.getMovesLearnt();

            // empty entry
            trpokes.files.add(new byte[] { 0, 0, 0, 0, 0, 0, 0, 0 });
            int trainernum = trainers.files.size();
            for (int i = 1; i < trainernum; i++) {
                byte[] trainer = trainers.files.get(i);
                Trainer tr = allTrainers.next();
                // preserve original poketype
                trainer[0] = (byte) tr.poketype;
                int numPokes = tr.pokemon.size();
                trainer[3] = (byte) numPokes;

                if (doubleBattleMode) {
                    if (tr.isBoss() || tr.isImportant()) {
                        if (!tr.skipImportant()) {
                            if (trainer[2] == 0) {
                                trainer[16] |= 2;
                            }
                        }
                    }
                }

                int bytesNeeded = 6 * numPokes;
                if (romEntry.romType != Gen4Constants.Type_DP) {
                    bytesNeeded += 2 * numPokes;
                }
                if ((tr.poketype & 1) == 1) {
                    bytesNeeded += 8 * numPokes;
                }
                if ((tr.poketype & 2) == 2) {
                    bytesNeeded += 2 * numPokes;
                }
                byte[] trpoke = new byte[bytesNeeded];
                int pokeOffs = 0;
                Iterator<TrainerPokemon> tpokes = tr.pokemon.iterator();
                for (int poke = 0; poke < numPokes; poke++) {
                    TrainerPokemon tp = tpokes.next();
                    writeWord(trpoke, pokeOffs, tp.AILevel);
                    writeWord(trpoke, pokeOffs + 2, tp.level);
                    writeWord(trpoke, pokeOffs + 4, tp.pokemon.number);
                    trpoke[pokeOffs + 5] |= (tp.forme << 2);
                    pokeOffs += 6;
                    if ((tr.poketype & 2) == 2) {
                        writeWord(trpoke, pokeOffs, tp.heldItem);
                        pokeOffs += 2;
                    }
                    if ((tr.poketype & 1) == 1) {
                        if (tp.resetMoves) {
                            int[] pokeMoves = RomFunctions.getMovesAtLevel(tp.absolutePokeNumber, movesets, tp.level);
                            for (int m = 0; m < 4; m++) {
                                writeWord(trpoke, pokeOffs + m * 2, pokeMoves[m]);
                            }
                        } else {
                            writeWord(trpoke, pokeOffs, tp.move1);
                            writeWord(trpoke, pokeOffs + 2, tp.move2);
                            writeWord(trpoke, pokeOffs + 4, tp.move3);
                            writeWord(trpoke, pokeOffs + 6, tp.move4);
                        }
                        pokeOffs += 8;
                    }
                    // Plat/HGSS have another random pokeOffs +=2 here.
                    if (romEntry.romType != Gen4Constants.Type_DP) {
                        pokeOffs += 2;
                    }
                }
                trpokes.files.add(trpoke);
            }
            this.writeNARC(romEntry.getString("TrainerData"), trainers);
            this.writeNARC(romEntry.getString("TrainerPokemon"), trpokes);
        } catch (IOException ex) {
            throw new RandomizerIOException(ex);
        }

    }

    @Override
    public Map<Integer, List<MoveLearnt>> getMovesLearnt() {
        Map<Integer, List<MoveLearnt>> movesets = new TreeMap<>();
        try {
            NARCArchive movesLearnt = this.readNARC(romEntry.getString("PokemonMovesets"));
            int formeCount = Gen4Constants.getFormeCount(romEntry.romType);
            for (int i = 1; i <= Gen4Constants.pokemonCount + formeCount; i++) {
                Pokemon pkmn = pokes[i];
                byte[] rom;
                if (i > Gen4Constants.pokemonCount) {
                    rom = movesLearnt.files.get(i + Gen4Constants.formeOffset);
                } else {
                    rom = movesLearnt.files.get(i);
                }
                int moveDataLoc = 0;
                List<MoveLearnt> learnt = new ArrayList<>();
                while ((rom[moveDataLoc] & 0xFF) != 0xFF || (rom[moveDataLoc + 1] & 0xFF) != 0xFF) {
                    int move = (rom[moveDataLoc] & 0xFF);
                    int level = (rom[moveDataLoc + 1] & 0xFE) >> 1;
                    if ((rom[moveDataLoc + 1] & 0x01) == 0x01) {
                        move += 256;
                    }
                    MoveLearnt ml = new MoveLearnt();
                    ml.level = level;
                    ml.move = move;
                    learnt.add(ml);
                    moveDataLoc += 2;
                }
                movesets.put(pkmn.number, learnt);
            }
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
        return movesets;
    }

    @Override
    public void setMovesLearnt(Map<Integer, List<MoveLearnt>> movesets) {
        // int[] extraLearnSets = new int[] { 7, 13, 13 };
        // Build up a new NARC
        NARCArchive movesLearnt = new NARCArchive();
        // The blank moveset
        byte[] blankSet = new byte[] { (byte) 0xFF, (byte) 0xFF, 0, 0 };
        movesLearnt.files.add(blankSet);
        int formeCount = Gen4Constants.getFormeCount(romEntry.romType);
        for (int i = 1; i <= Gen4Constants.pokemonCount + formeCount; i++) {
            if (i == Gen4Constants.pokemonCount + 1) {
                for (int j = 0; j < Gen4Constants.formeOffset; j++) {
                    movesLearnt.files.add(blankSet);
                }
            }
            Pokemon pkmn = pokes[i];
            List<MoveLearnt> learnt = movesets.get(pkmn.number);
            int sizeNeeded = learnt.size() * 2 + 2;
            if ((sizeNeeded % 4) != 0) {
                sizeNeeded += 2;
            }
            byte[] moveset = new byte[sizeNeeded];
            int j = 0;
            for (; j < learnt.size(); j++) {
                MoveLearnt ml = learnt.get(j);
                moveset[j * 2] = (byte) (ml.move & 0xFF);
                int levelPart = (ml.level << 1) & 0xFE;
                if (ml.move > 255) {
                    levelPart++;
                }
                moveset[j * 2 + 1] = (byte) levelPart;
            }
            moveset[j * 2] = (byte) 0xFF;
            moveset[j * 2 + 1] = (byte) 0xFF;
            movesLearnt.files.add(moveset);
        }
        //for (int j = 0; j < extraLearnSets[romEntry.romType]; j++) {
        //    movesLearnt.files.add(blankSet);
        //}
        // Save
        try {
            this.writeNARC(romEntry.getString("PokemonMovesets"), movesLearnt);
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }

    }

    private static class StaticPokemon {
        private int[] files;
        private int[] offsets;

        public Pokemon getPokemon(Gen4RomHandler parent, NARCArchive scriptNARC) {
            return parent.pokes[parent.readWord(scriptNARC.files.get(files[0]), offsets[0])];
        }

        public void setPokemon(Gen4RomHandler parent, NARCArchive scriptNARC, Pokemon pkmn) {
            int value = pkmn.number;
            for (int i = 0; i < offsets.length; i++) {
                byte[] file = scriptNARC.files.get(files[i]);
                parent.writeWord(file, offsets[i], value);
            }
        }
    }

    @Override
    public List<StaticEncounter> getStaticPokemon() {
        List<StaticEncounter> sp = new ArrayList<>();
        if (!romEntry.staticPokemonSupport) {
            return sp;
        }
        try {
            NARCArchive scriptNARC = scriptNarc;
            for (StaticPokemon statP : romEntry.staticPokemon) {
                sp.add(new StaticEncounter(statP.getPokemon(this, scriptNARC)));
            }
            if (romEntry.arrayEntries.containsKey("StaticPokemonTrades")) {
                NARCArchive tradeNARC = this.readNARC(romEntry.getString("InGameTrades"));
                int[] trades = romEntry.arrayEntries.get("StaticPokemonTrades");
                for (int tradeNum : trades) {
                    sp.add(new StaticEncounter(pokes[readLong(tradeNARC.files.get(tradeNum), 0)]));
                }
            }
            if (romEntry.getInt("MysteryEggOffset") > 0) {
                byte[] ovOverlay = readOverlay(romEntry.getInt("MoveTutorMovesOvlNumber"));
                sp.add(new StaticEncounter(pokes[ovOverlay[romEntry.getInt("MysteryEggOffset")] & 0xFF]));
            }
            if (romEntry.getInt("FossilTableOffset") > 0) {
                byte[] ftData = arm9;
                int baseOffset = romEntry.getInt("FossilTableOffset");
                if (romEntry.romType == Gen4Constants.Type_HGSS) {
                    ftData = readOverlay(romEntry.getInt("FossilTableOvlNumber"));
                }
                // read the 7 Fossil Pokemon
                for (int f = 0; f < Gen4Constants.fossilCount; f++) {
                    sp.add(new StaticEncounter(pokes[readWord(ftData, baseOffset + 2 + f * 4)]));
                }
            }
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
        return sp;
    }

    @Override
    public boolean setStaticPokemon(List<StaticEncounter> staticPokemon) {
        if (!romEntry.staticPokemonSupport) {
            return false;
        }
        int sptsize = romEntry.arrayEntries.containsKey("StaticPokemonTrades") ? romEntry.arrayEntries
                .get("StaticPokemonTrades").length : 0;
        int meggsize = romEntry.getInt("MysteryEggOffset") > 0 ? 1 : 0;
        int fossilsize = romEntry.getInt("FossilTableOffset") > 0 ? 7 : 0;
        if (staticPokemon.size() != romEntry.staticPokemon.size() + sptsize + meggsize + fossilsize) {
            return false;
        }
        try {
            Iterator<StaticEncounter> statics = staticPokemon.iterator();
            NARCArchive scriptNARC = scriptNarc;
            for (StaticPokemon statP : romEntry.staticPokemon) {
                statP.setPokemon(this, scriptNARC, statics.next().pkmn);
            }
            if (romEntry.arrayEntries.containsKey("StaticPokemonTrades")) {
                NARCArchive tradeNARC = this.readNARC(romEntry.getString("InGameTrades"));
                int[] trades = romEntry.arrayEntries.get("StaticPokemonTrades");
                for (int tradeNum : trades) {
                    Pokemon thisTrade = statics.next().pkmn;
                    List<Integer> possibleAbilities = new ArrayList<>();
                    possibleAbilities.add(thisTrade.ability1);
                    if (thisTrade.ability2 > 0) {
                        possibleAbilities.add(thisTrade.ability2);
                    }
                    if (thisTrade.ability3 > 0) {
                        possibleAbilities.add(thisTrade.ability3);
                    }
                    // Write species and ability
                    writeLong(tradeNARC.files.get(tradeNum), 0, thisTrade.number);
                    writeLong(tradeNARC.files.get(tradeNum), 0x1C,
                            possibleAbilities.get(this.random.nextInt(possibleAbilities.size())));
                }
                writeNARC(romEntry.getString("InGameTrades"), tradeNARC);
            }
            if (romEntry.getInt("MysteryEggOffset") > 0) {
                // Same overlay as MT moves
                // Truncate the pokemon# to 1byte, unless it's 0
                int pokenum = statics.next().pkmn.number;
                if (pokenum > 255) {
                    pokenum = this.random.nextInt(255) + 1;
                }
                byte[] ovOverlay = readOverlay(romEntry.getInt("MoveTutorMovesOvlNumber"));
                ovOverlay[romEntry.getInt("MysteryEggOffset")] = (byte) pokenum;
                writeOverlay(romEntry.getInt("MoveTutorMovesOvlNumber"), ovOverlay);
            }
            if (romEntry.getInt("FossilTableOffset") > 0) {
                int baseOffset = romEntry.getInt("FossilTableOffset");
                if (romEntry.romType == Gen4Constants.Type_HGSS) {
                    byte[] ftData = readOverlay(romEntry.getInt("FossilTableOvlNumber"));
                    for (int f = 0; f < Gen4Constants.fossilCount; f++) {
                        int pokenum = statics.next().pkmn.number;
                        writeWord(ftData, baseOffset + 2 + f * 4, pokenum);
                    }
                    writeOverlay(romEntry.getInt("FossilTableOvlNumber"), ftData);
                } else {
                    // write to arm9
                    for (int f = 0; f < Gen4Constants.fossilCount; f++) {
                        int pokenum = statics.next().pkmn.number;
                        writeWord(arm9, baseOffset + 2 + f * 4, pokenum);
                    }
                }
            }
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
        return true;
    }

    @Override
    public List<Integer> getTMMoves() {
        String tmDataPrefix;
        if (romEntry.romType == Gen4Constants.Type_DP || romEntry.romType == Gen4Constants.Type_Plat) {
            tmDataPrefix = Gen4Constants.dpptTMDataPrefix;
        } else {
            tmDataPrefix = Gen4Constants.hgssTMDataPrefix;
        }
        int offset = find(arm9, tmDataPrefix);
        if (offset > 0) {
            offset += tmDataPrefix.length() / 2; // because it was a prefix
            List<Integer> tms = new ArrayList<>();
            for (int i = 0; i < Gen4Constants.tmCount; i++) {
                tms.add(readWord(arm9, offset + i * 2));
            }
            return tms;
        } else {
            return null;
        }
    }

    @Override
    public List<Integer> getHMMoves() {
        String tmDataPrefix;
        if (romEntry.romType == Gen4Constants.Type_DP || romEntry.romType == Gen4Constants.Type_Plat) {
            tmDataPrefix = Gen4Constants.dpptTMDataPrefix;
        } else {
            tmDataPrefix = Gen4Constants.hgssTMDataPrefix;
        }
        int offset = find(arm9, tmDataPrefix);
        if (offset > 0) {
            offset += tmDataPrefix.length() / 2; // because it was a prefix
            offset += Gen4Constants.tmCount * 2; // TM data
            List<Integer> hms = new ArrayList<>();
            for (int i = 0; i < Gen4Constants.hmCount; i++) {
                hms.add(readWord(arm9, offset + i * 2));
            }
            return hms;
        } else {
            return null;
        }
    }

    @Override
    public void setTMMoves(List<Integer> moveIndexes) {
        String tmDataPrefix;
        if (romEntry.romType == Gen4Constants.Type_DP || romEntry.romType == Gen4Constants.Type_Plat) {
            tmDataPrefix = Gen4Constants.dpptTMDataPrefix;
        } else {
            tmDataPrefix = Gen4Constants.hgssTMDataPrefix;
        }
        int offset = find(arm9, tmDataPrefix);
        if (offset > 0) {
            offset += tmDataPrefix.length() / 2; // because it was a prefix
            for (int i = 0; i < Gen4Constants.tmCount; i++) {
                writeWord(arm9, offset + i * 2, moveIndexes.get(i));
            }

            // Update TM item descriptions
            List<String> itemDescriptions = getStrings(romEntry.getInt("ItemDescriptionsTextOffset"));
            List<String> moveDescriptions = getStrings(romEntry.getInt("MoveDescriptionsTextOffset"));
            // TM01 is item 328 and so on
            for (int i = 0; i < Gen4Constants.tmCount; i++) {
                // Rewrite 5-line move descs into 3-line item descs
                itemDescriptions.set(i + Gen4Constants.tmItemOffset, RomFunctions.rewriteDescriptionForNewLineSize(
                        moveDescriptions.get(moveIndexes.get(i)), "\\n", Gen4Constants.textCharsPerLine, ssd));
            }
            // Save the new item descriptions
            setStrings(romEntry.getInt("ItemDescriptionsTextOffset"), itemDescriptions);
            // Palettes update
            String baseOfPalettes = Gen4Constants.pthgssItemPalettesPrefix;
            if (romEntry.romType == Gen4Constants.Type_DP) {
                baseOfPalettes = Gen4Constants.dpItemPalettesPrefix;
            }
            int offsPals = find(arm9, baseOfPalettes);
            if (offsPals > 0) {
                // Write pals
                for (int i = 0; i < Gen4Constants.tmCount; i++) {
                    Move m = this.moves[moveIndexes.get(i)];
                    int pal = this.typeTMPaletteNumber(m.type);
                    writeWord(arm9, offsPals + i * 8 + 2, pal);
                }
            }
            // if we can't update the palettes its not a big deal...
        }
    }

    private static RomFunctions.StringSizeDeterminer ssd = new RomFunctions.StringLengthSD();

    @Override
    public int getTMCount() {
        return Gen4Constants.tmCount;
    }

    @Override
    public int getHMCount() {
        return Gen4Constants.hmCount;
    }

    @Override
    public Map<Pokemon, boolean[]> getTMHMCompatibility() {
        Map<Pokemon, boolean[]> compat = new TreeMap<>();
        int formeCount = Gen4Constants.getFormeCount(romEntry.romType);
        for (int i = 1; i <= Gen4Constants.pokemonCount + formeCount; i++) {
            byte[] data;
            if (i > Gen4Constants.pokemonCount) {
                data = pokeNarc.files.get(i + Gen4Constants.formeOffset);
            } else {
                data = pokeNarc.files.get(i);
            }
            Pokemon pkmn = pokes[i];
            boolean[] flags = new boolean[Gen4Constants.tmCount + Gen4Constants.hmCount + 1];
            for (int j = 0; j < 13; j++) {
                readByteIntoFlags(data, flags, j * 8 + 1, Gen4Constants.bsTMHMCompatOffset + j);
            }
            compat.put(pkmn, flags);
        }
        return compat;
    }

    @Override
    public void setTMHMCompatibility(Map<Pokemon, boolean[]> compatData) {
        for (Map.Entry<Pokemon, boolean[]> compatEntry : compatData.entrySet()) {
            Pokemon pkmn = compatEntry.getKey();
            boolean[] flags = compatEntry.getValue();
            byte[] data = pokeNarc.files.get(pkmn.number);
            for (int j = 0; j < 13; j++) {
                data[Gen4Constants.bsTMHMCompatOffset + j] = getByteFromFlags(flags, j * 8 + 1);
            }
        }
    }

    @Override
    public boolean hasMoveTutors() {
        return romEntry.romType != Gen4Constants.Type_DP;
    }

    @Override
    public List<Integer> getMoveTutorMoves() {
        if (!hasMoveTutors()) {
            return new ArrayList<>();
        }
        int baseOffset = romEntry.getInt("MoveTutorMovesOffset");
        int amount = romEntry.getInt("MoveTutorCount");
        int bytesPer = romEntry.getInt("MoveTutorBytesCount");
        List<Integer> mtMoves = new ArrayList<>();
        try {
            byte[] mtFile = readOverlay(romEntry.getInt("MoveTutorMovesOvlNumber"));
            for (int i = 0; i < amount; i++) {
                mtMoves.add(readWord(mtFile, baseOffset + i * bytesPer));
            }
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
        return mtMoves;
    }

    @Override
    public void setMoveTutorMoves(List<Integer> moves) {
        if (!hasMoveTutors()) {
            return;
        }
        int baseOffset = romEntry.getInt("MoveTutorMovesOffset");
        int amount = romEntry.getInt("MoveTutorCount");
        int bytesPer = romEntry.getInt("MoveTutorBytesCount");
        if (moves.size() != amount) {
            return;
        }
        try {
            byte[] mtFile = readOverlay(romEntry.getInt("MoveTutorMovesOvlNumber"));
            for (int i = 0; i < amount; i++) {
                writeWord(mtFile, baseOffset + i * bytesPer, moves.get(i));
            }
            writeOverlay(romEntry.getInt("MoveTutorMovesOvlNumber"), mtFile);
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
    }

    @Override
    public Map<Pokemon, boolean[]> getMoveTutorCompatibility() {
        if (!hasMoveTutors()) {
            return new TreeMap<>();
        }
        Map<Pokemon, boolean[]> compat = new TreeMap<>();
        int amount = romEntry.getInt("MoveTutorCount");
        int baseOffset = romEntry.getInt("MoveTutorCompatOffset");
        int bytesPer = romEntry.getInt("MoveTutorCompatBytesCount");
        try {
            byte[] mtcFile;
            if (romEntry.romType == Gen4Constants.Type_HGSS) {
                mtcFile = readFile(romEntry.getString("MoveTutorCompat"));
            } else {
                mtcFile = readOverlay(romEntry.getInt("MoveTutorCompatOvlNumber"));
            }
            int formeCount = Gen4Constants.getFormeCount(romEntry.romType);
            for (int i = 1; i <= Gen4Constants.pokemonCount + formeCount; i++) {
                Pokemon pkmn = pokes[i];
                boolean[] flags = new boolean[amount + 1];
                for (int j = 0; j < bytesPer; j++) {
                    if (i > Gen4Constants.pokemonCount) {
                        readByteIntoFlags(mtcFile, flags, j * 8 + 1, baseOffset + (i - 1) * bytesPer + j);
                    } else {
                        readByteIntoFlags(mtcFile, flags, j * 8 + 1, baseOffset + (i - 1) * bytesPer + j);
                    }
                }
                compat.put(pkmn, flags);
            }
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
        return compat;
    }

    @Override
    public void setMoveTutorCompatibility(Map<Pokemon, boolean[]> compatData) {
        if (!hasMoveTutors()) {
            return;
        }
        int amount = romEntry.getInt("MoveTutorCount");
        int baseOffset = romEntry.getInt("MoveTutorCompatOffset");
        int bytesPer = romEntry.getInt("MoveTutorCompatBytesCount");
        try {
            byte[] mtcFile;
            if (romEntry.romType == Gen4Constants.Type_HGSS) {
                mtcFile = readFile(romEntry.getString("MoveTutorCompat"));
            } else {
                mtcFile = readOverlay(romEntry.getInt("MoveTutorCompatOvlNumber"));
            }
            for (Map.Entry<Pokemon, boolean[]> compatEntry : compatData.entrySet()) {
                Pokemon pkmn = compatEntry.getKey();
                boolean[] flags = compatEntry.getValue();
                for (int j = 0; j < bytesPer; j++) {
                    int offsHere = baseOffset + (pkmn.number - 1) * bytesPer + j;
                    if (j * 8 + 8 <= amount) {
                        // entirely new byte
                        mtcFile[offsHere] = getByteFromFlags(flags, j * 8 + 1);
                    } else if (j * 8 < amount) {
                        // need some of the original byte
                        int newByte = getByteFromFlags(flags, j * 8 + 1) & 0xFF;
                        int oldByteParts = (mtcFile[offsHere] >>> (8 - amount + j * 8)) << (8 - amount + j * 8);
                        mtcFile[offsHere] = (byte) (newByte | oldByteParts);
                    }
                    // else do nothing to the byte
                }
            }
            if (romEntry.romType == Gen4Constants.Type_HGSS) {
                writeFile(romEntry.getString("MoveTutorCompat"), mtcFile);
            } else {
                writeOverlay(romEntry.getInt("MoveTutorCompatOvlNumber"), mtcFile);
            }
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
    }

    private int find(byte[] data, String hexString) {
        if (hexString.length() % 2 != 0) {
            return -3; // error
        }
        byte[] searchFor = new byte[hexString.length() / 2];
        for (int i = 0; i < searchFor.length; i++) {
            searchFor[i] = (byte) Integer.parseInt(hexString.substring(i * 2, i * 2 + 2), 16);
        }
        List<Integer> found = RomFunctions.search(data, searchFor);
        if (found.size() == 0) {
            return -1; // not found
        } else if (found.size() > 1) {
            return -2; // not unique
        } else {
            return found.get(0);
        }
    }

    private boolean lastStringsCompressed = false;

    private List<String> getStrings(int index) {
        PokeTextData pt = new PokeTextData(msgNarc.files.get(index));
        pt.decrypt();
        lastStringsCompressed = pt.compressFlag;
        return new ArrayList<>(pt.strlist);
    }

    private void setStrings(int index, List<String> newStrings) {
        setStrings(index, newStrings, false);
    }

    private void setStrings(int index, List<String> newStrings, boolean compressed) {
        byte[] rawUnencrypted = TextToPoke.MakeFile(newStrings, compressed);

        // make new encrypted name set
        PokeTextData encrypt = new PokeTextData(rawUnencrypted);
        encrypt.SetKey(0xD00E);
        encrypt.encrypt();

        // rewrite
        msgNarc.files.set(index, encrypt.get());
    }

    @Override
    public String getROMName() {
        return "Pokemon " + romEntry.name;
    }

    @Override
    public String getROMCode() {
        return romEntry.romCode;
    }

    @Override
    public String getSupportLevel() {
        return romEntry.staticPokemonSupport ? "Complete" : "No Static Pokemon";
    }

    @Override
    public boolean hasTimeBasedEncounters() {
        // dppt technically do but we ignore them completely
        return romEntry.romType == Gen4Constants.Type_HGSS;
    }

    @Override
    public boolean hasWildAltFormes() {
        return false;
    }

    @Override
    public boolean canChangeStaticPokemon() {
        return romEntry.staticPokemonSupport;
    }

    @Override
    public boolean hasStaticAltFormes() {
        return false;
    }

    @Override
    public List<TotemPokemon> getTotemPokemon() {
        return new ArrayList<>();
    }

    @Override
    public void setTotemPokemon(List<TotemPokemon> totemPokemon) {

    }

    @Override
    public boolean canChangeStarters() {
        return true;
    }

    @Override
    public boolean hasStarterAltFormes() {
        return false;
    }

    @Override
    public int starterCount() {
        return 3;
    }

    @Override
    public Map<Integer, StatChange> getUpdatedPokemonStats(int generation) {
        return GlobalConstants.getStatChanges(generation);
    }

    private void populateEvolutions() {
        for (Pokemon pkmn : pokes) {
            if (pkmn != null) {
                pkmn.evolutionsFrom.clear();
                pkmn.evolutionsTo.clear();
            }
        }

        // Read NARC
        try {
            NARCArchive evoNARC = readNARC(romEntry.getString("PokemonEvolutions"));
            for (int i = 1; i <= Gen4Constants.pokemonCount; i++) {
                Pokemon pk = pokes[i];
                byte[] evoEntry = evoNARC.files.get(i);
                for (int evo = 0; evo < 7; evo++) {
                    int method = readWord(evoEntry, evo * 6);
                    int species = readWord(evoEntry, evo * 6 + 4);
                    if (method >= 1 && method <= Gen4Constants.evolutionMethodCount && species >= 1) {
                        EvolutionType et = EvolutionType.fromIndex(4, method);
                        int extraInfo = readWord(evoEntry, evo * 6 + 2);
                        Evolution evol = new Evolution(pokes[i], pokes[species], true, et, extraInfo);
                        if (!pk.evolutionsFrom.contains(evol)) {
                            pk.evolutionsFrom.add(evol);
                            pokes[species].evolutionsTo.add(evol);
                        }
                    }
                }
                // split evos don't carry stats
                if (pk.evolutionsFrom.size() > 1) {
                    for (Evolution e : pk.evolutionsFrom) {
                        e.carryStats = false;
                    }
                }
            }
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
    }

    private void writeEvolutions() {
        try {
            NARCArchive evoNARC = readNARC(romEntry.getString("PokemonEvolutions"));
            for (int i = 1; i <= Gen4Constants.pokemonCount; i++) {
                byte[] evoEntry = evoNARC.files.get(i);
                int evosWritten = 0;
                Pokemon pk = pokes[i];
                for (Evolution evo : pk.evolutionsFrom) {
                    writeWord(evoEntry, evosWritten * 6, evo.type.toIndex(4));
                    writeWord(evoEntry, evosWritten * 6 + 2, evo.extraInfo);
                    writeWord(evoEntry, evosWritten * 6 + 4, evo.to.number);
                    evosWritten++;
                    if (evosWritten == 7) {
                        break;
                    }
                }
                while (evosWritten < 7) {
                    writeWord(evoEntry, evosWritten * 6, 0);
                    writeWord(evoEntry, evosWritten * 6 + 2, 0);
                    writeWord(evoEntry, evosWritten * 6 + 4, 0);
                    evosWritten++;
                }
            }
            writeNARC(romEntry.getString("PokemonEvolutions"), evoNARC);
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
    }

    @Override
    public void removeTradeEvolutions(boolean changeMoveEvos) {
        Map<Integer, List<MoveLearnt>> movesets = this.getMovesLearnt();
        log("--Removing Trade Evolutions--");
        Set<Evolution> extraEvolutions = new HashSet<>();
        for (Pokemon pkmn : pokes) {
            if (pkmn != null) {
                extraEvolutions.clear();
                for (Evolution evo : pkmn.evolutionsFrom) {
                    // new 160 other impossible evolutions:
                    if (romEntry.romType == Gen4Constants.Type_HGSS) {
                        // beauty milotic
                        if (evo.type == EvolutionType.LEVEL_HIGH_BEAUTY) {
                            // Replace w/ level 35
                            evo.type = EvolutionType.LEVEL;
                            evo.extraInfo = 35;
                            logEvoChangeLevel(evo.from.name, evo.to.name, 35);
                        }
                        // mt.coronet (magnezone/probopass)
                        if (evo.type == EvolutionType.LEVEL_ELECTRIFIED_AREA) {
                            // Replace w/ level 40
                            evo.type = EvolutionType.LEVEL;
                            evo.extraInfo = 40;
                            logEvoChangeLevel(evo.from.name, evo.to.name, 40);
                        }
                        // moss rock (leafeon)
                        if (evo.type == EvolutionType.LEVEL_MOSS_ROCK) {
                            // Replace w/ leaf stone
                            evo.type = EvolutionType.STONE;
                            evo.extraInfo = Gen4Constants.leafStoneIndex; // leaf
                                                                          // stone
                            logEvoChangeStone(evo.from.name, evo.to.name, itemNames.get(Gen4Constants.leafStoneIndex));
                        }
                        // icy rock (glaceon)
                        if (evo.type == EvolutionType.LEVEL_ICY_ROCK) {
                            // Replace w/ dawn stone
                            evo.type = EvolutionType.STONE;
                            evo.extraInfo = Gen4Constants.dawnStoneIndex; // dawn
                                                                          // stone
                            logEvoChangeStone(evo.from.name, evo.to.name, itemNames.get(Gen4Constants.dawnStoneIndex));
                        }
                    }
                    if (changeMoveEvos && evo.type == EvolutionType.LEVEL_WITH_MOVE) {
                        // read move
                        int move = evo.extraInfo;
                        int levelLearntAt = 1;
                        for (MoveLearnt ml : movesets.get(evo.from.number)) {
                            if (ml.move == move) {
                                levelLearntAt = ml.level;
                                break;
                            }
                        }
                        if (levelLearntAt == 1) {
                            // override for piloswine
                            levelLearntAt = 45;
                        }
                        // change to pure level evo
                        evo.type = EvolutionType.LEVEL;
                        evo.extraInfo = levelLearntAt;
                        logEvoChangeLevel(evo.from.name, evo.to.name, levelLearntAt);
                    }
                    // Pure Trade
                    if (evo.type == EvolutionType.TRADE) {
                        // Replace w/ level 37
                        evo.type = EvolutionType.LEVEL;
                        evo.extraInfo = 37;
                        logEvoChangeLevel(evo.from.name, evo.to.name, 37);
                    }
                    // Trade w/ Item
                    if (evo.type == EvolutionType.TRADE_ITEM) {
                        // Get the current item & evolution
                        int item = evo.extraInfo;
                        if (evo.from.number == Gen4Constants.slowpokeIndex) {
                            // Slowpoke is awkward - he already has a level evo
                            // So we can't do Level up w/ Held Item for him
                            // Put Water Stone instead
                            evo.type = EvolutionType.STONE;
                            evo.extraInfo = Gen4Constants.waterStoneIndex; // water
                                                                           // stone
                            logEvoChangeStone(evo.from.name, evo.to.name, itemNames.get(Gen4Constants.waterStoneIndex));
                        } else {
                            logEvoChangeLevelWithItem(evo.from.name, evo.to.name, itemNames.get(item));
                            // Replace, for this entry, w/
                            // Level up w/ Held Item at Day
                            evo.type = EvolutionType.LEVEL_ITEM_DAY;
                            // now add an extra evo for
                            // Level up w/ Held Item at Night
                            Evolution extraEntry = new Evolution(evo.from, evo.to, true,
                                    EvolutionType.LEVEL_ITEM_NIGHT, item);
                            extraEvolutions.add(extraEntry);
                        }
                    }
                }
                pkmn.evolutionsFrom.addAll(extraEvolutions);
                for (Evolution ev : extraEvolutions) {
                    ev.to.evolutionsTo.add(ev);
                }
            }
        }
        logBlankLine();

    }

    @Override
    public void makeEvolutionsEasier(boolean wildsRandomized) {
        if (wildsRandomized) {
            for (Pokemon pkmn : pokes) {
                if (pkmn != null) {
                    for (Evolution evo : pkmn.evolutionsFrom) {
                        if (evo.type == EvolutionType.LEVEL_WITH_OTHER) {
                            // Replace w/ level 35
                            evo.type = EvolutionType.LEVEL;
                            evo.extraInfo = 35;
                            log(String.format("%s now evolves into %s at minimum level %d", evo.from.name, evo.to.name,
                                    evo.extraInfo));
                        }
                    }
                }
            }
            logBlankLine();
        }
    }

    @Override
    public boolean hasShopRandomization() {
        return false;
    }

    @Override
    public Map<Integer, List<Integer>> getShopItems() {
        return null; // Not implemented
    }

    @Override
    public void setShopItems(Map<Integer, List<Integer>> shopItems) {
        // Not available
    }

    @Override
    public void setShopPrices() {
        // Not implemented
    }

    @Override
    public List<Integer> getMainGameShops() {
        return new ArrayList<>();
    }

    @Override
    public int randomHeldItem() {
        return 0;
    }

    @Override
    public boolean canChangeTrainerText() {
        return true;
    }

    @Override
    public List<String> getTrainerNames() {
        List<String> tnames = new ArrayList<>(getStrings(romEntry.getInt("TrainerNamesTextOffset")));
        tnames.remove(0); // blank one
        for (int i = 0; i < tnames.size(); i++) {
            if (tnames.get(i).contains("\\and")) {
                tnames.set(i, tnames.get(i).replace("\\and", "&"));
            }
        }
        return tnames;
    }

    @Override
    public int maxTrainerNameLength() {
        return 10;// based off the english ROMs fixed
    }

    @Override
    public void setTrainerNames(List<String> trainerNames) {
        List<String> oldTNames = getStrings(romEntry.getInt("TrainerNamesTextOffset"));
        List<String> newTNames = new ArrayList<>(trainerNames);
        for (int i = 0; i < newTNames.size(); i++) {
            if (newTNames.get(i).contains("&")) {
                newTNames.set(i, newTNames.get(i).replace("&", "\\and"));
            }
        }
        newTNames.add(0, oldTNames.get(0)); // the 0-entry, preserve it

        // rewrite, only compressed if they were compressed before
        setStrings(romEntry.getInt("TrainerNamesTextOffset"), newTNames, lastStringsCompressed);

    }

    @Override
    public TrainerNameMode trainerNameMode() {
        return TrainerNameMode.MAX_LENGTH;
    }

    @Override
    public List<Integer> getTCNameLengthsByTrainer() {
        // not needed
        return new ArrayList<>();
    }

    @Override
    public List<String> getTrainerClassNames() {
        return getStrings(romEntry.getInt("TrainerClassesTextOffset"));
    }

    @Override
    public void setTrainerClassNames(List<String> trainerClassNames) {
        setStrings(romEntry.getInt("TrainerClassesTextOffset"), trainerClassNames);
    }

    @Override
    public int maxTrainerClassNameLength() {
        return 12;// based off the english ROMs
    }

    @Override
    public boolean fixedTrainerClassNamesLength() {
        return false;
    }

    @Override
    public List<Integer> getDoublesTrainerClasses() {
        int[] doublesClasses = romEntry.arrayEntries.get("DoublesTrainerClasses");
        List<Integer> doubles = new ArrayList<>();
        for (int tClass : doublesClasses) {
            doubles.add(tClass);
        }
        return doubles;
    }

    @Override
    public String getDefaultExtension() {
        return "nds";
    }

    @Override
    public int abilitiesPerPokemon() {
        return 2;
    }

    @Override
    public int highestAbilityIndex() {
        return Gen4Constants.highestAbilityIndex;
    }

    @Override
    public int internalStringLength(String string) {
        return string.length();
    }

    @Override
    public void applySignature() {
        // For now, do nothing.

    }

    @Override
    public ItemList getAllowedItems() {
        return allowedItems;
    }

    @Override
    public ItemList getNonBadItems() {
        return nonBadItems;
    }

    @Override
    public List<Integer> getRegularShopItems() {
        return null; // Not implemented
    }

    @Override
    public List<Integer> getOPShopItems() {
        return null; // Not implemented
    }

    @Override
    public String[] getItemNames() {
        return itemNames.toArray(new String[0]);
    }

    @Override
    public String abilityName(int number) {
        return abilityNames.get(number);
    }

    @Override
    public boolean hasMegaEvolutions() {
        return false;
    }

    private List<Integer> getFieldItems() {
        List<Integer> fieldItems = new ArrayList<>();
        // normal items
        int scriptFile = romEntry.getInt("ItemBallsScriptOffset");
        byte[] itemScripts = scriptNarc.files.get(scriptFile);
        int offset = 0;
        int skipTableOffset = 0;
        int[] skipTable = romEntry.arrayEntries.get("ItemBallsSkip");
        int setVar = romEntry.romType == Gen4Constants.Type_HGSS ? Gen4Constants.hgssSetVarScript
                : Gen4Constants.dpptSetVarScript;
        while (true) {
            int part1 = readWord(itemScripts, offset);
            if (part1 == Gen4Constants.scriptListTerminator) {
                // done
                break;
            }
            int offsetInFile = readRelativePointer(itemScripts, offset);
            offset += 4;
            if (skipTableOffset < skipTable.length && (skipTable[skipTableOffset] == (offset / 4) - 1)) {
                skipTableOffset++;
                continue;
            }
            int command = readWord(itemScripts, offsetInFile);
            int variable = readWord(itemScripts, offsetInFile + 2);
            if (command == setVar && variable == Gen4Constants.itemScriptVariable) {
                int item = readWord(itemScripts, offsetInFile + 4);
                fieldItems.add(item);
            }

        }

        // hidden items
        int hiTableOffset = romEntry.getInt("HiddenItemTableOffset");
        int hiTableLimit = romEntry.getInt("HiddenItemCount");
        for (int i = 0; i < hiTableLimit; i++) {
            int item = readWord(arm9, hiTableOffset + i * 8);
            fieldItems.add(item);
        }

        return fieldItems;
    }

    private void setFieldItems(List<Integer> fieldItems) {
        Iterator<Integer> iterItems = fieldItems.iterator();

        // normal items
        int scriptFile = romEntry.getInt("ItemBallsScriptOffset");
        byte[] itemScripts = scriptNarc.files.get(scriptFile);
        int offset = 0;
        int skipTableOffset = 0;
        int[] skipTable = romEntry.arrayEntries.get("ItemBallsSkip");
        int setVar = romEntry.romType == Gen4Constants.Type_HGSS ? Gen4Constants.hgssSetVarScript
                : Gen4Constants.dpptSetVarScript;
        while (true) {
            int part1 = readWord(itemScripts, offset);
            if (part1 == Gen4Constants.scriptListTerminator) {
                // done
                break;
            }
            int offsetInFile = readRelativePointer(itemScripts, offset);
            offset += 4;
            if (skipTableOffset < skipTable.length && (skipTable[skipTableOffset] == (offset / 4) - 1)) {
                skipTableOffset++;
                continue;
            }
            int command = readWord(itemScripts, offsetInFile);
            int variable = readWord(itemScripts, offsetInFile + 2);
            if (command == setVar && variable == Gen4Constants.itemScriptVariable) {
                int item = iterItems.next();
                writeWord(itemScripts, offsetInFile + 4, item);
            }
        }

        // hidden items
        int hiTableOffset = romEntry.getInt("HiddenItemTableOffset");
        int hiTableLimit = romEntry.getInt("HiddenItemCount");
        for (int i = 0; i < hiTableLimit; i++) {
            int item = iterItems.next();
            writeWord(arm9, hiTableOffset + i * 8, item);
        }
    }

    @Override
    public List<Integer> getRequiredFieldTMs() {
        if (romEntry.romType == Gen4Constants.Type_DP) {
            return Gen4Constants.dpRequiredFieldTMs;
        } else if (romEntry.romType == Gen4Constants.Type_Plat) {
            // same as DP just we have to keep the weather TMs
            return Gen4Constants.ptRequiredFieldTMs;
        }
        return new ArrayList<>();
    }

    @Override
    public List<Integer> getCurrentFieldTMs() {
        List<Integer> fieldItems = this.getFieldItems();
        List<Integer> fieldTMs = new ArrayList<>();

        for (int item : fieldItems) {
            if (Gen4Constants.allowedItems.isTM(item)) {
                fieldTMs.add(item - Gen4Constants.tmItemOffset + 1);
            }
        }

        return fieldTMs;
    }

    @Override
    public void setFieldTMs(List<Integer> fieldTMs) {
        List<Integer> fieldItems = this.getFieldItems();
        int fiLength = fieldItems.size();
        Iterator<Integer> iterTMs = fieldTMs.iterator();

        for (int i = 0; i < fiLength; i++) {
            int oldItem = fieldItems.get(i);
            if (Gen4Constants.allowedItems.isTM(oldItem)) {
                int newItem = iterTMs.next() + Gen4Constants.tmItemOffset - 1;
                fieldItems.set(i, newItem);
            }
        }

        this.setFieldItems(fieldItems);
    }

    @Override
    public List<Integer> getRegularFieldItems() {
        List<Integer> fieldItems = this.getFieldItems();
        List<Integer> fieldRegItems = new ArrayList<>();

        for (int item : fieldItems) {
            if (Gen4Constants.allowedItems.isAllowed(item) && !(Gen4Constants.allowedItems.isTM(item))) {
                fieldRegItems.add(item);
            }
        }

        return fieldRegItems;
    }

    @Override
    public void setRegularFieldItems(List<Integer> items) {
        List<Integer> fieldItems = this.getFieldItems();
        int fiLength = fieldItems.size();
        Iterator<Integer> iterNewItems = items.iterator();

        for (int i = 0; i < fiLength; i++) {
            int oldItem = fieldItems.get(i);
            if (!(Gen4Constants.allowedItems.isTM(oldItem)) && Gen4Constants.allowedItems.isAllowed(oldItem)) {
                int newItem = iterNewItems.next();
                fieldItems.set(i, newItem);
            }
        }

        this.setFieldItems(fieldItems);
    }

    @Override
    public List<IngameTrade> getIngameTrades() {
        List<IngameTrade> trades = new ArrayList<>();
        try {
            NARCArchive tradeNARC = this.readNARC(romEntry.getString("InGameTrades"));
            int[] spTrades = new int[0];
            if (romEntry.arrayEntries.containsKey("StaticPokemonTrades")) {
                spTrades = romEntry.arrayEntries.get("StaticPokemonTrades");
            }
            List<String> tradeStrings = getStrings(romEntry.getInt("IngameTradesTextOffset"));
            int tradeCount = tradeNARC.files.size();
            for (int i = 0; i < tradeCount; i++) {
                boolean isSP = false;
                for (int spTrade : spTrades) {
                    if (spTrade == i) {
                        isSP = true;
                        break;
                    }
                }
                if (isSP) {
                    continue;
                }
                byte[] tfile = tradeNARC.files.get(i);
                IngameTrade trade = new IngameTrade();
                trade.nickname = tradeStrings.get(i);
                trade.givenPokemon = pokes[readLong(tfile, 0)];
                trade.ivs = new int[6];
                for (int iv = 0; iv < 6; iv++) {
                    trade.ivs[iv] = readLong(tfile, 4 + iv * 4);
                }
                trade.otId = readWord(tfile, 0x20);
                trade.otName = tradeStrings.get(i + tradeCount);
                trade.item = readLong(tfile, 0x3C);
                trade.requestedPokemon = pokes[readLong(tfile, 0x4C)];
                trades.add(trade);
            }
        } catch (IOException ex) {
            throw new RandomizerIOException(ex);
        }
        return trades;
    }

    @Override
    public void setIngameTrades(List<IngameTrade> trades) {
        int tradeOffset = 0;
        List<IngameTrade> oldTrades = this.getIngameTrades();
        try {
            NARCArchive tradeNARC = this.readNARC(romEntry.getString("InGameTrades"));
            int[] spTrades = new int[0];
            if (romEntry.arrayEntries.containsKey("StaticPokemonTrades")) {
                spTrades = romEntry.arrayEntries.get("StaticPokemonTrades");
            }
            List<String> tradeStrings = getStrings(romEntry.getInt("IngameTradesTextOffset"));
            int tradeCount = tradeNARC.files.size();
            for (int i = 0; i < tradeCount; i++) {
                boolean isSP = false;
                for (int spTrade : spTrades) {
                    if (spTrade == i) {
                        isSP = true;
                        break;
                    }
                }
                if (isSP) {
                    continue;
                }
                byte[] tfile = tradeNARC.files.get(i);
                IngameTrade trade = trades.get(tradeOffset++);
                tradeStrings.set(i, trade.nickname);
                tradeStrings.set(i + tradeCount, trade.otName);
                writeLong(tfile, 0, trade.givenPokemon.number);
                for (int iv = 0; iv < 6; iv++) {
                    writeLong(tfile, 4 + iv * 4, trade.ivs[iv]);
                }
                writeWord(tfile, 0x20, trade.otId);
                writeLong(tfile, 0x3C, trade.item);
                writeLong(tfile, 0x4C, trade.requestedPokemon.number);
                if (tfile.length > 0x50) {
                    writeLong(tfile, 0x50, 0); // disable gender
                }
            }
            this.writeNARC(romEntry.getString("InGameTrades"), tradeNARC);
            this.setStrings(romEntry.getInt("IngameTradesTextOffset"), tradeStrings);
            // update what the people say when they talk to you
            if (romEntry.arrayEntries.containsKey("IngameTradePersonTextOffsets")) {
                int[] textOffsets = romEntry.arrayEntries.get("IngameTradePersonTextOffsets");
                for (int trade = 0; trade < textOffsets.length; trade++) {
                    if (textOffsets[trade] > 0) {
                        if (trade >= oldTrades.size() || trade >= trades.size()) {
                            break;
                        }
                        IngameTrade oldTrade = oldTrades.get(trade);
                        IngameTrade newTrade = trades.get(trade);
                        Map<String, String> replacements = new TreeMap<>();
                        replacements.put(oldTrade.givenPokemon.name.toUpperCase(), newTrade.givenPokemon.name);
                        if (oldTrade.requestedPokemon != newTrade.requestedPokemon) {
                            replacements.put(oldTrade.requestedPokemon.name.toUpperCase(), newTrade.requestedPokemon.name);
                        }
                        replaceAllStringsInEntry(textOffsets[trade], replacements, Gen4Constants.textCharsPerLine);
                        // hgss override for one set of strings that appears 2x
                        if (romEntry.romType == Gen4Constants.Type_HGSS && trade == 6) {
                            replaceAllStringsInEntry(textOffsets[trade] + 1, replacements,
                                    Gen4Constants.textCharsPerLine);
                        }
                    }
                }
            }
        } catch (IOException ex) {
            throw new RandomizerIOException(ex);
        }
    }

    private void replaceAllStringsInEntry(int entry, Map<String, String> replacements, int lineLength) {
        List<String> thisTradeStrings = this.getStrings(entry);
        int ttsCount = thisTradeStrings.size();
        for (int strNum = 0; strNum < ttsCount; strNum++) {
            String oldString = thisTradeStrings.get(strNum);
            String newString = RomFunctions.formatTextWithReplacements(oldString, replacements, "\\n", "\\l", "\\p",
                    lineLength, ssd);
            thisTradeStrings.set(strNum, newString);
        }
        this.setStrings(entry, thisTradeStrings);
    }

    @Override
    public boolean hasDVs() {
        return false;
    }

    @Override
    public int generationOfPokemon() {
        return 4;
    }

    @Override
    public void removeEvosForPokemonPool() {
        // slightly more complicated than gen2/3
        // we have to update a "baby table" too
        List<Pokemon> pokemonIncluded = this.mainPokemonList;
        Set<Evolution> keepEvos = new HashSet<>();
        for (Pokemon pk : pokes) {
            if (pk != null) {
                keepEvos.clear();
                for (Evolution evol : pk.evolutionsFrom) {
                    if (pokemonIncluded.contains(evol.from) && pokemonIncluded.contains(evol.to)) {
                        keepEvos.add(evol);
                    } else {
                        evol.to.evolutionsTo.remove(evol);
                    }
                }
                pk.evolutionsFrom.retainAll(keepEvos);
            }
        }

        try {
            byte[] babyPokes = readFile(romEntry.getString("BabyPokemon"));
            // baby pokemon
            for (int i = 1; i <= Gen4Constants.pokemonCount; i++) {
                Pokemon baby = pokes[i];
                while (baby.evolutionsTo.size() > 0) {
                    // Grab the first "to evolution" even if there are multiple
                    baby = baby.evolutionsTo.get(0).from;
                }
                writeWord(babyPokes, i * 2, baby.number);
            }
            // finish up
            writeFile(romEntry.getString("BabyPokemon"), babyPokes);
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
    }

    @Override
    public boolean supportsFourStartingMoves() {
        return true;
    }

    @Override
    public List<Integer> getFieldMoves() {
        if (romEntry.romType == Gen4Constants.Type_HGSS) {
            return Gen4Constants.hgssFieldMoves;
        } else {
            return Gen4Constants.dpptFieldMoves;
        }
    }

    @Override
    public List<Integer> getEarlyRequiredHMMoves() {
        if (romEntry.romType == Gen4Constants.Type_HGSS) {
            return Gen4Constants.hgssEarlyRequiredHMMoves;
        } else {
            return Gen4Constants.dpptEarlyRequiredHMMoves;
        }
    }

    @Override
    public int miscTweaksAvailable() {
        int available = MiscTweak.LOWER_CASE_POKEMON_NAMES.getValue();
        available |= MiscTweak.RANDOMIZE_CATCHING_TUTORIAL.getValue();
        if (romEntry.tweakFiles.get("FastestTextTweak") != null) {
            available |= MiscTweak.FASTEST_TEXT.getValue();
        }
        available |= MiscTweak.BAN_LUCKY_EGG.getValue();
        return available;
    }

    @Override
    public void applyMiscTweak(MiscTweak tweak) {
        if (tweak == MiscTweak.LOWER_CASE_POKEMON_NAMES) {
            applyCamelCaseNames();
        } else if (tweak == MiscTweak.RANDOMIZE_CATCHING_TUTORIAL) {
            randomizeCatchingTutorial();
        } else if (tweak == MiscTweak.FASTEST_TEXT) {
            applyFastestText();
        } else if (tweak == MiscTweak.BAN_LUCKY_EGG) {
            allowedItems.banSingles(Gen4Constants.luckyEggIndex);
            nonBadItems.banSingles(Gen4Constants.luckyEggIndex);
        }
    }

    private void randomizeCatchingTutorial() {
        int opponentOffset = romEntry.getInt("CatchingTutorialOpponentMonOffset");

        if (romEntry.romType == Gen4Constants.Type_HGSS) {
            // Can randomize player mon too, but both limited to 1-255
            int playerOffset = romEntry.getInt("CatchingTutorialPlayerMonOffset");

            Pokemon opponent = randomPokemonLimited(255, false);
            Pokemon player = randomPokemonLimited(255, false);

            if (opponent != null && player != null) {
                arm9[opponentOffset] = (byte) opponent.number;
                arm9[playerOffset] = (byte) player.number;
            }
        } else {
            // Only opponent, but enough space for any mon
            Pokemon opponent = randomPokemonLimited(Integer.MAX_VALUE, false);

            if (opponent != null) {
                writeLong(arm9, opponentOffset, opponent.number);
            }
        }

    }

    private void applyFastestText() {
        genericIPSPatch(arm9, "FastestTextTweak");
    }

    private boolean genericIPSPatch(byte[] data, String ctName) {
        String patchName = romEntry.tweakFiles.get(ctName);
        if (patchName == null) {
            return false;
        }

        try {
            FileFunctions.applyPatch(data, patchName);
            return true;
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
    }

    private Pokemon randomPokemonLimited(int maxValue, boolean blockNonMales) {
        checkPokemonRestrictions();
        List<Pokemon> validPokemon = new ArrayList<>();
        for (Pokemon pk : this.mainPokemonList) {
            if (pk.number <= maxValue && (!blockNonMales || pk.genderRatio <= 0xFD)) {
                validPokemon.add(pk);
            }
        }
        if (validPokemon.size() == 0) {
            return null;
        } else {
            return validPokemon.get(random.nextInt(validPokemon.size()));
        }
    }

    @Override
    public BufferedImage getMascotImage() {
        try {
            Pokemon pk = randomPokemon();
            NARCArchive pokespritesNARC = this.readNARC(romEntry.getString("PokemonGraphics"));
            int spriteIndex = pk.number * 6 + 2 + random.nextInt(2);
            int palIndex = pk.number * 6 + 4;
            if (random.nextInt(10) == 0) {
                // shiny
                palIndex++;
            }

            // read sprite
            byte[] rawSprite = pokespritesNARC.files.get(spriteIndex);
            if (rawSprite.length == 0) {
                // Must use other gender form
                rawSprite = pokespritesNARC.files.get(spriteIndex ^ 1);
            }
            int[] spriteData = new int[3200];
            for (int i = 0; i < 3200; i++) {
                spriteData[i] = readWord(rawSprite, i * 2 + 48);
            }

            // Decrypt sprite (why does EVERYTHING use the RNG formula geez)
            if (romEntry.romType != Gen4Constants.Type_DP) {
                int key = spriteData[0];
                for (int i = 0; i < 3200; i++) {
                    spriteData[i] ^= (key & 0xFFFF);
                    key = key * 0x41C64E6D + 0x6073;
                }
            } else {
                // D/P sprites are encrypted *backwards*. Wut.
                int key = spriteData[3199];
                for (int i = 3199; i >= 0; i--) {
                    spriteData[i] ^= (key & 0xFFFF);
                    key = key * 0x41C64E6D + 0x6073;
                }
            }

            byte[] rawPalette = pokespritesNARC.files.get(palIndex);

            int[] palette = new int[16];
            for (int i = 1; i < 16; i++) {
                palette[i] = GFXFunctions.conv16BitColorToARGB(readWord(rawPalette, 40 + i * 2));
            }

            // Deliberately chop off the right half of the image while still
            // correctly indexing the array.
            BufferedImage bim = new BufferedImage(80, 80, BufferedImage.TYPE_INT_ARGB);
            for (int y = 0; y < 80; y++) {
                for (int x = 0; x < 80; x++) {
                    int value = ((spriteData[y * 40 + x / 4]) >> (x % 4) * 4) & 0x0F;
                    bim.setRGB(x, y, palette[value]);
                }
            }
            return bim;
        } catch (IOException e) {
            throw new RandomizerIOException(e);
        }
    }
}
