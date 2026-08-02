package com.dabomstew.pkrandom.paradox;

import java.util.Arrays;
import java.util.EnumMap;

/**
 * Components for gen 3.
 */
public final class SpriteComponents extends EnumMap<SpriteComponent, int[]> {
    static SpriteComponents of(SpriteComponent component, int[] indices, Object... others) {
        SpriteComponents components = new SpriteComponents();
        components.put(component, Arrays.copyOf(indices, indices.length));
        if (others != null && others.length > 0 && others.length % 2 == 0) {
            for (int i = 0; i < others.length; i += 2) {
                int[] nextIndices = (int[]) others[i + 1];
                components.put((SpriteComponent) others[i], Arrays.copyOf(nextIndices, nextIndices.length));
            }
        }
        return components;
    }

    static final SpriteComponents ALL_COMPONENTS = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY,     new int[]{0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  10, 11, 12, 13, 14, 15},
            SpriteComponent.PRIMARY_DETAIL,   new int[]{0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_BODY,   new int[]{0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_DETAIL, new int[]{0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  10, 11, 12, 13, 14, 15}
    );

    private SpriteComponents() {
        super(SpriteComponent.class);
    }
}
