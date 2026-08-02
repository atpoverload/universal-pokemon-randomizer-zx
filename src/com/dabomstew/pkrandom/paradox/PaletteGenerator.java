package com.dabomstew.pkrandom.paradox;

import com.dabomstew.pkrandom.pokemon.Type;

public interface PaletteGenerator {
    ComponentColorPalette getPaletteForSingleType(Type type);

    ComponentColorPalette getPaletteForDualType(Type type1, Type type2);
}
