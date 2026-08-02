package com.dabomstew.pkrandom.paradox;

import java.util.Arrays;

public final class PokemonPalette {
    private final byte[] truePalette;
    private final SpriteComponents spriteComponents;

    public PokemonPalette(byte[] truePalette, SpriteComponents spriteComponents) {
        this.truePalette = Arrays.copyOf(truePalette, truePalette.length);
        this.spriteComponents = spriteComponents;
    }

    public PokemonPalette recolor(PokemonPalette newPalette) {
        byte[] recoloredPalette = Arrays.copyOf(truePalette, truePalette.length);
        for (SpriteComponent component : spriteComponents.keySet()) {
            switch (component) {
                case PRIMARY_BODY:
                case PRIMARY_DETAIL:
                case SECONDARY_BODY:
                case SECONDARY_DETAIL:
                    fillPalette(
                            this.spriteComponents.get(component),
                            newPalette.spriteComponents.get(component),
                            newPalette.truePalette,
                            recoloredPalette);
            }
        }
        return new PokemonPalette(recoloredPalette, this.spriteComponents);
    }

    public PokemonPalette recolor(ComponentColorPalette newPalette) {
        byte[] recoloredPalette = Arrays.copyOf(truePalette, truePalette.length);
        for (SpriteComponent component : spriteComponents.keySet()) {
            switch (component) {
                case PRIMARY_BODY:
                case PRIMARY_DETAIL:
                case SECONDARY_BODY:
                case SECONDARY_DETAIL:
                    fillPalette(
                            this.spriteComponents.get(component),
                            SpriteComponents.ALL_COMPONENTS.get(component),
                            newPalette.get(component),
                            recoloredPalette);
            }
        }
        return new PokemonPalette(recoloredPalette, this.spriteComponents);
    }

    public byte[] toTruePalette() {
        return Arrays.copyOf(truePalette, truePalette.length);
    }

    private static void fillPalette(int[] oldIndices, int[] newIndices, byte[] newPalette, byte[] recoloredPalette) {
        for (int i = 0; i < oldIndices.length; i+=2) {
            recoloredPalette[oldIndices[i]] = newPalette[newIndices[i]];
            recoloredPalette[oldIndices[i + 1]] = newPalette[newIndices[i + 1]];
        }
    }
}
