package com.dabomstew.pkrandom.paradox;

import com.dabomstew.pkrandom.pokemon.Type;

import java.util.EnumMap;

/**
 * Provides color palettes based on existing mon palettes in gen 3. Most palettes are incomplete and only go up to 4 - 6 colors per component.
 */
public final class Gen3PaletteGenerator implements PaletteGenerator {
    public static Gen3PaletteGenerator getInstance() {
        return instance;
    }

    private static final Gen3PaletteGenerator instance = new Gen3PaletteGenerator();

    private Gen3PaletteGenerator() {
    }

    @Override
    public ComponentColorPalette getPaletteForSingleType(Type type) {
        if (PALETTE_BY_TYPE.isEmpty()) {
            getPaletteByType();
        }
        return PALETTE_BY_TYPE.get(type);
    }

    @Override
    public ComponentColorPalette getPaletteForDualType(Type type1, Type type2) {
        ComponentColorPalette palette1 = getPaletteForSingleType(type1);
        ComponentColorPalette palette2 = getPaletteForSingleType(type2);
        return ComponentColorPalette.of(
                SpriteComponent.PRIMARY_BODY, palette1.get(SpriteComponent.PRIMARY_BODY),
                SpriteComponent.PRIMARY_DETAIL, palette1.get(SpriteComponent.PRIMARY_DETAIL),
                SpriteComponent.SECONDARY_BODY, palette2.get(SpriteComponent.SECONDARY_BODY),
                SpriteComponent.SECONDARY_DETAIL, palette2.get(SpriteComponent.SECONDARY_DETAIL)
        );
    }

    private static final EnumMap<Type, ComponentColorPalette> PALETTE_BY_TYPE = new EnumMap<>(Type.class);

    private static void getPaletteByType() {
        for (Type type : Type.values()) {
            PALETTE_BY_TYPE.put(type, createPaletteForType(type));
        }
    }

    private static ComponentColorPalette createPaletteForType(Type type) {
        switch (type) {
            case NORMAL:
                return ComponentColorPalette.of(
                        SpriteComponent.PRIMARY_BODY, NORMAL_BODY,
                        SpriteComponent.PRIMARY_DETAIL, NORMAL_DETAIL,
                        SpriteComponent.SECONDARY_BODY, NORMAL_BODY,
                        SpriteComponent.SECONDARY_DETAIL, NORMAL_DETAIL
                );
            case FIGHTING:
                return ComponentColorPalette.of(
                        SpriteComponent.PRIMARY_BODY, FIGHTING_BODY,
                        SpriteComponent.PRIMARY_DETAIL, FIGHTING_DETAIL,
                        SpriteComponent.SECONDARY_BODY, FIGHTING_BODY,
                        SpriteComponent.SECONDARY_DETAIL, FIGHTING_DETAIL
                );
            case FLYING:
                return ComponentColorPalette.of(
                        SpriteComponent.PRIMARY_BODY, FLYING_BODY,
                        SpriteComponent.PRIMARY_DETAIL, FLYING_DETAIL,
                        SpriteComponent.SECONDARY_BODY, FLYING_BODY,
                        SpriteComponent.SECONDARY_DETAIL, FLYING_DETAIL
                );
            case GRASS:
                return ComponentColorPalette.of(
                        SpriteComponent.PRIMARY_BODY, GRASS_BODY,
                        SpriteComponent.PRIMARY_DETAIL, GRASS_DETAIL,
                        SpriteComponent.SECONDARY_BODY, GRASS_BODY,
                        SpriteComponent.SECONDARY_DETAIL, GRASS_DETAIL
                );
            case WATER:
                return ComponentColorPalette.of(
                        SpriteComponent.PRIMARY_BODY, WATER_BODY,
                        SpriteComponent.PRIMARY_DETAIL, WATER_DETAIL,
                        SpriteComponent.SECONDARY_BODY, WATER_BODY,
                        SpriteComponent.SECONDARY_DETAIL, WATER_DETAIL
                );
            case FIRE:
                return ComponentColorPalette.of(
                        SpriteComponent.PRIMARY_BODY, FIRE_BODY,
                        SpriteComponent.PRIMARY_DETAIL, FIRE_DETAIL,
                        SpriteComponent.SECONDARY_BODY, FIRE_BODY,
                        SpriteComponent.SECONDARY_DETAIL, FIRE_DETAIL
                );
            case ROCK:
                return ComponentColorPalette.of(
                        SpriteComponent.PRIMARY_BODY, ROCK_BODY,
                        SpriteComponent.PRIMARY_DETAIL, ROCK_DETAIL,
                        SpriteComponent.SECONDARY_BODY, ROCK_BODY,
                        SpriteComponent.SECONDARY_DETAIL, ROCK_DETAIL
                );
            case GROUND:
                return ComponentColorPalette.of(
                        SpriteComponent.PRIMARY_BODY, GROUND_BODY,
                        SpriteComponent.PRIMARY_DETAIL, GROUND_DETAIL,
                        SpriteComponent.SECONDARY_BODY, GROUND_BODY,
                        SpriteComponent.SECONDARY_DETAIL, GROUND_DETAIL
                );
            case PSYCHIC:
                return ComponentColorPalette.of(
                        SpriteComponent.PRIMARY_BODY, PSYCHIC_BODY,
                        SpriteComponent.PRIMARY_DETAIL, PSYCHIC_DETAIL,
                        SpriteComponent.SECONDARY_BODY, PSYCHIC_BODY,
                        SpriteComponent.SECONDARY_DETAIL, PSYCHIC_DETAIL
                );
            case BUG:
                return ComponentColorPalette.of(
                        SpriteComponent.PRIMARY_BODY, BUG_BODY,
                        SpriteComponent.PRIMARY_DETAIL, BUG_DETAIL,
                        SpriteComponent.SECONDARY_BODY, BUG_BODY,
                        SpriteComponent.SECONDARY_DETAIL, BUG_DETAIL
                );
            case DRAGON:
                return ComponentColorPalette.of(
                        SpriteComponent.PRIMARY_BODY, DRAGON_BODY,
                        SpriteComponent.PRIMARY_DETAIL, DRAGON_DETAIL,
                        SpriteComponent.SECONDARY_BODY, DRAGON_BODY,
                        SpriteComponent.SECONDARY_DETAIL, DRAGON_DETAIL
                );
            case ELECTRIC:
                return ComponentColorPalette.of(
                        SpriteComponent.PRIMARY_BODY, ELECTRIC_BODY,
                        SpriteComponent.PRIMARY_DETAIL, ELECTRIC_DETAIL,
                        SpriteComponent.SECONDARY_BODY, ELECTRIC_BODY,
                        SpriteComponent.SECONDARY_DETAIL, ELECTRIC_DETAIL
                );
            case GHOST:
                return ComponentColorPalette.of(
                        SpriteComponent.PRIMARY_BODY, GHOST_BODY,
                        SpriteComponent.PRIMARY_DETAIL, GHOST_DETAIL,
                        SpriteComponent.SECONDARY_BODY, GHOST_BODY,
                        SpriteComponent.SECONDARY_DETAIL, GHOST_DETAIL
                );
            case POISON:
                return ComponentColorPalette.of(
                        SpriteComponent.PRIMARY_BODY, POISON_BODY,
                        SpriteComponent.PRIMARY_DETAIL, POISON_DETAIL,
                        SpriteComponent.SECONDARY_BODY, POISON_BODY,
                        SpriteComponent.SECONDARY_DETAIL, POISON_DETAIL
                );
            case ICE:
                return ComponentColorPalette.of(
                        SpriteComponent.PRIMARY_BODY, ICE_BODY,
                        SpriteComponent.PRIMARY_DETAIL, ICE_DETAIL,
                        SpriteComponent.SECONDARY_BODY, ICE_BODY,
                        SpriteComponent.SECONDARY_DETAIL, ICE_DETAIL
                );
            case STEEL:
                return ComponentColorPalette.of(
                        SpriteComponent.PRIMARY_BODY, STEEL_BODY,
                        SpriteComponent.PRIMARY_DETAIL, STEEL_DETAIL,
                        SpriteComponent.SECONDARY_BODY, STEEL_BODY,
                        SpriteComponent.SECONDARY_DETAIL, STEEL_DETAIL
                );
            case DARK:
                return ComponentColorPalette.of(
                        SpriteComponent.PRIMARY_BODY, DARK_BODY,
                        SpriteComponent.PRIMARY_DETAIL, DARK_DETAIL,
                        SpriteComponent.SECONDARY_BODY, DARK_BODY,
                        SpriteComponent.SECONDARY_DETAIL, DARK_DETAIL
                );
            case FAIRY:
            default:
                return ComponentColorPalette.of(SpriteComponent.PRIMARY_BODY, NORMAL_BODY);
        }
    }

    private static final byte[] NORMAL_BODY = new byte[]{31, 91, -65, 86, 93, 74, -101, 49, 115, 45, 115, 45, 115, 45, 115, 45};
    private static final byte[] NORMAL_DETAIL = new byte[]{-66, 107, 58, 91, -72, 74, 53, 54, -79, 41, 11, 25};
    private static final byte[] FIGHTING_BODY = new byte[]{-98, 99, 92, 83, -72, 58, -79, 41, -79, 41, -79, 41, -79, 41, -79, 41};
    private static final byte[] FIGHTING_DETAIL = new byte[]{-99, 54, 26, 46, -107, 33, 48, 25, 48, 25, 48, 25, 48, 25, 48, 25};
    private static final byte[] FLYING_BODY = new byte[]{-33, 86, -4, 57, 54, 33, 54, 33, 54, 33, 54, 33, 54, 33, 54, 33};
    private static final byte[] FLYING_DETAIL = new byte[]{57, 50, -107, 29, 111, 37, -21, 20, -21, 20, -21, 20, -21, 20, -21, 20};
    private static final byte[] GRASS_BODY = new byte[]{-9, 59, 83, 39, -81, 34, -53, 33, -53, 33, -53, 33, -53, 33, -53, 33};
    private static final byte[] GRASS_DETAIL = new byte[]{-80, 99, 76, 83, 76, 78, 101, 49, 101, 49, 101, 49, 101, 49, 101, 49};
    private static final byte[] WATER_BODY = new byte[]{118, 119, 17, 107, 80, 86, 80, 86, 80, 86, 80, 86, 80, 86, 80, 86};
    private static final byte[] WATER_DETAIL = new byte[]{-15, 126, 110, 114, 15, 82, -25, 48, -25, 48, -25, 48, -25, 48, -25, 48};
    private static final byte[] FIRE_BODY = new byte[]{31, 51, 95, 34, 59, 37, 19, 13, 19, 13, 19, 13, 19, 13, 19, 13};
    private static final byte[] FIRE_DETAIL = new byte[]{-97, 79, 95, 55, -68, 46, -97, 6, -98, 1, -98, 1, -98, 1, -98, 1};
    private static final byte[] ROCK_BODY = new byte[]{123, 107, 24, 95, 49, 74, 107, 49, 107, 49, 107, 49, 107, 49, 107, 49};
    private static final byte[] ROCK_DETAIL = new byte[]{89, 67, -43, 50, 15, 46, 40, 9, 40, 9, 40, 9, 40, 9, 40, 9};
    private static final byte[] GROUND_BODY = new byte[]{123, 46, -8, 33, 116, 33, -115, 0, -115, 0, -115, 0, -115, 0, -115, 0};
    private static final byte[] GROUND_DETAIL = new byte[]{-100, 91, -74, 58, -16, 37, 75, 17, 75, 17, 75, 17, 75, 17, 75, 17};
    private static final byte[] PSYCHIC_BODY = new byte[]{-33, 74, 31, 50, 124, 53, -45, 24, -45, 24, -45, 24, -45, 24, -45, 24};
    private static final byte[] PSYCHIC_DETAIL = new byte[]{-70, 65, -68, 118, 57, 106, -42, 93, -42, 93, -42, 93, -42, 93, -42, 93};
    private static final byte[] BUG_BODY = new byte[]{-9, 59, 83, 39, 111, 50, -118, 21, -118, 21, -118, 21, -118, 21, -118, 21};
    private static final byte[] BUG_DETAIL = new byte[]{63, 59, -67, 34, 58, 54, -79, 8, -79, 8, -79, 8, -79, 8, -79, 8};
    private static final byte[] DRAGON_BODY = new byte[]{-104, 114, 20, 98, 78, 73, 103, 44, 103, 44, 103, 44, 103, 44, 103, 44};
    private static final byte[] DRAGON_DETAIL = new byte[]{-75, 126, -17, 109, -118, 73, 7, 49, 7, 49, 7, 49, 7, 49, 7, 49};
    private static final byte[] ELECTRIC_BODY = new byte[]{-1, 63, -65, 3, -3, 2, 56, 2, 80, 1, 80, 1, 80, 1, 80, 1};
    private static final byte[] ELECTRIC_DETAIL = new byte[]{23, 34, -110, 25, 81, 25, 12, 13, 12, 13, 12, 13, 12, 13, 12, 13};
    private static final byte[] GHOST_BODY = new byte[]{87, 90, -111, 65, 46, 53, -54, 44, -54, 44, -54, 44, -54, 44, -54, 44};
    private static final byte[] GHOST_DETAIL = new byte[]{-70, 102, 87, 90, -111, 65, 46, 53, 46, 53, 46, 53, 46, 53, 46, 53};
    private static final byte[] POISON_BODY = new byte[]{-4, 110, 120, 90, -78, 77, -53, 56, -53, 56, -53, 56, -53, 56, -53, 56};
    private static final byte[] POISON_DETAIL = new byte[]{-70, 126, 55, 126, -77, 105, 110, 73, 110, 73, 110, 73, 110, 73, 110, 73};
    private static final byte[] ICE_BODY = new byte[]{51, 123, -50, 114, 46, 98, 38, 53, 38, 53, 38, 53, 38, 53, 38, 53};
    private static final byte[] ICE_DETAIL = new byte[]{52, 127, -113, 114, 41, 98, 41, 98, 41, 98, 41, 98, 41, 98, 41, 98};
    private static final byte[] STEEL_BODY = new byte[]{-101, 111, 55, 99, 112, 86, 105, 61, -25, 40, -25, 40, -25, 40, -25, 40};
    private static final byte[] STEEL_DETAIL = new byte[]{-1, 127, 59, 103, -73, 86, 51, 70, -81, 53, -81, 53, -81, 53, -81, 53};
    private static final byte[] DARK_BODY = new byte[]{-106, 82, 18, 66, 75, 41, -24, 28, -90, 20, -90, 20, -90, 20, -90, 20};
    private static final byte[] DARK_DETAIL = new byte[]{-75, 90, 50, 78, 73, 53, -58, 32, -58, 32, -58, 32, -58, 32, -58, 32};
}
