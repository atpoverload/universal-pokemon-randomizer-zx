package com.dabomstew.pkrandom.paradox;

import java.util.Arrays;
import java.util.EnumMap;

/** Represents */
public final class ComponentColorPalette extends EnumMap<SpriteComponent, byte[]> {
    static ComponentColorPalette of(SpriteComponent component, byte[] indices, Object... others) {
        ComponentColorPalette components = new ComponentColorPalette();
        components.put(component, Arrays.copyOf(indices, indices.length));
        if (others != null && others.length > 0 && others.length % 2 == 0) {
            for (int i = 0; i < others.length; i += 2) {
                byte[] nextIndices = (byte[]) others[i + 1];
                components.put((SpriteComponent) others[i], Arrays.copyOf(nextIndices, nextIndices.length));
            }
        }
        return components;
    }

    private ComponentColorPalette() {
        super(SpriteComponent.class);
    }
}
