package com.dabomstew.pkrandom.pokemon;

/*----------------------------------------------------------------------------*/
/*--  GBConstants.java - constants that are relevant for all of the GB      --*/
/*--                     games                                              --*/
/*--                                                                        --*/
/*--  Part of "Universal Pokemon Randomizer ZX" by the UPR-ZX team          --*/
/*--  Originally part of "Universal Pokemon Randomizer" by Dabomstew        --*/
/*--  Pokemon and any associated names and the like are                     --*/
/*--  trademark and (C) Nintendo 1996-2020.                                 --*/
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

import com.dabomstew.pkrandom.constants.Species;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public enum EggGroup {
    monster(1),
    water1(2),
    bug(3),
    flying(4),
    field(5),
    fairy(6),
    grass(7),
    humanLike(8),
    water3(9),
    mineral(10),
    amorphous(11),
    water2(12),
    ditto(13),
    dragon(14),
    noEggsDiscovered(15),
    genderUnknown(16);

    public static final Map<Integer, EggGroup[]> NON_LEGENDARY_NO_EGG_GROUP = getNonLegendaryNoEggGroup();
    public static final Map<Integer, EggGroup[]> EEVEELUTION_EGG_GROUP = getEeveeEggGroups();

    public final int offset;

    private EggGroup(int offset) {
        this.offset = offset & 0xFF;
    }

    /** Collection of pokemon that belong to the "no egg group" normally, so we place
     * them into the group their family is in. */
    private static Map<Integer, EggGroup[]> getNonLegendaryNoEggGroup() {
        Map<Integer, EggGroup[]> mons = new HashMap<>();
        mons.put(Species.nidorina, new EggGroup[] {EggGroup.monster, EggGroup.field});
        mons.put(Species.nidoqueen, new EggGroup[] {EggGroup.monster, EggGroup.field});
        mons.put(Species.pichu, new EggGroup[] {EggGroup.field, EggGroup.fairy});
        mons.put(Species.cleffa, new EggGroup[] {EggGroup.fairy, EggGroup.fairy});
        mons.put(Species.igglybuff, new EggGroup[] {EggGroup.fairy, EggGroup.fairy});
        mons.put(Species.togepi, new EggGroup[] {EggGroup.flying, EggGroup.fairy});
        mons.put(Species.unown, new EggGroup[] {EggGroup.amorphous, EggGroup.amorphous});
        mons.put(Species.tyrogue, new EggGroup[] {EggGroup.humanLike, EggGroup.humanLike});
        mons.put(Species.smoochum, new EggGroup[] {EggGroup.humanLike, EggGroup.humanLike});
        mons.put(Species.elekid, new EggGroup[] {EggGroup.humanLike, EggGroup.humanLike});
        mons.put(Species.magby, new EggGroup[] {EggGroup.humanLike, EggGroup.humanLike});
        mons.put(Species.azurill, new EggGroup[] {EggGroup.water1, EggGroup.fairy});
        mons.put(Species.wynaut, new EggGroup[] {EggGroup.amorphous, EggGroup.amorphous});
        mons.put(Species.budew, new EggGroup[]{EggGroup.fairy, EggGroup.grass});
        mons.put(Species.chingling, new EggGroup[]{EggGroup.amorphous, EggGroup.amorphous});
        mons.put(Species.bonsly, new EggGroup[]{EggGroup.mineral, EggGroup.mineral});
        mons.put(Species.mimeJr, new EggGroup[]{EggGroup.humanLike, EggGroup.humanLike});
        mons.put(Species.happiny, new EggGroup[]{EggGroup.fairy, EggGroup.fairy});
        mons.put(Species.munchlax, new EggGroup[]{EggGroup.monster, EggGroup.monster});
        mons.put(Species.riolu, new EggGroup[]{EggGroup.field, EggGroup.humanLike});
        mons.put(Species.mantyke, new EggGroup[]{EggGroup.water1, EggGroup.water1});
        mons.put(Species.toxel, new EggGroup[]{EggGroup.humanLike, EggGroup.humanLike});
        return Collections.unmodifiableMap(mons);
    }

    /** Egg group mapping for eeveelutions to make randomization more interesting. */
    private static Map<Integer, EggGroup[]> getEeveeEggGroups() {
        Map<Integer, EggGroup[]> mons = new HashMap<>();
        mons.put(Species.vaporeon, new EggGroup[] {EggGroup.water3, EggGroup.water3});
        mons.put(Species.jolteon, new EggGroup[] {EggGroup.flying, EggGroup.flying});
        mons.put(Species.flareon, new EggGroup[] {EggGroup.humanLike, EggGroup.humanLike});
        mons.put(Species.espeon, new EggGroup[] {EggGroup.amorphous, EggGroup.amorphous});
        mons.put(Species.umbreon, new EggGroup[] {EggGroup.monster, EggGroup.monster});
        mons.put(Species.leafeon, new EggGroup[] {EggGroup.grass, EggGroup.grass});
        mons.put(Species.glaceon, new EggGroup[] {EggGroup.mineral, EggGroup.mineral});
        mons.put(Species.sylveon, new EggGroup[] {EggGroup.fairy, EggGroup.fairy});
        return Collections.unmodifiableMap(mons);
    }
}
