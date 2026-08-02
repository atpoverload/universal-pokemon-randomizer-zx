package com.dabomstew.pkrandom.paradox;

import java.util.Arrays;
import java.util.EnumMap;

/**
 * Components for gen 3.
 */
public final class Gen3SpriteComponents {
    public static final SpriteComponents bulbasaur = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29}
    );
    public static final SpriteComponents ivysaur = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 14, 15, 20, 21, 24, 25},
            SpriteComponent.PRIMARY_DETAIL, new int[]{6, 7, 8, 9, 10, 11, 30, 31, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 4, 5}
    );
    public static final SpriteComponents venusaur = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{18, 19, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 28, 29, 26, 27},
            SpriteComponent.SECONDARY_DETAIL, new int[]{24, 25, 22, 23}
    );
    public static final SpriteComponents charmander = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{18, 19, 20, 21, 22, 23, 24, 25},
            SpriteComponent.PRIMARY_DETAIL, new int[]{16, 17, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{8, 9, 10, 11, 12, 13},
            SpriteComponent.SECONDARY_DETAIL, new int[]{30, 31, 28, 29, 26, 27}
    );
    public static final SpriteComponents charmeleon = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 22, 23, 24, 25, 26, 27},
            SpriteComponent.PRIMARY_DETAIL, new int[]{18, 19, 16, 17, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{8, 9, 10, 11, 12, 13},
            SpriteComponent.SECONDARY_DETAIL, new int[]{6, 7}
    );
    public static final SpriteComponents charizard = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 22, 23, 24, 25, 26, 27},
            SpriteComponent.PRIMARY_DETAIL, new int[]{16, 17, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 4, 5},
            SpriteComponent.SECONDARY_DETAIL, new int[]{6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents squirtle = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_DETAIL, new int[]{4, 5, 6, 7, 8, 9}
    );
    public static final SpriteComponents wartortle = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{4, 5, 6, 7},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21},
            SpriteComponent.SECONDARY_DETAIL, new int[]{10, 11, 12, 13, 14, 15}
    );
    public static final SpriteComponents blastoise = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 12, 13},
            SpriteComponent.SECONDARY_DETAIL, new int[]{18, 19, 20, 21, 8, 9}
    );
    public static final SpriteComponents caterpie = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{18, 19, 20, 21, 22, 23, 24, 25},
            SpriteComponent.PRIMARY_DETAIL, new int[]{8, 9, 10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7, 8, 9, 16, 17}
    );
    public static final SpriteComponents metapod = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 20, 21}
    );
    public static final SpriteComponents butterfree = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 10, 11, 12, 13, 14, 15},
            SpriteComponent.PRIMARY_DETAIL, new int[]{28, 29, 30, 31},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 24, 25, 26, 27},
            SpriteComponent.SECONDARY_DETAIL, new int[]{16, 17, 18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents weedle = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 10, 11, 12, 13, 14, 15},
            SpriteComponent.PRIMARY_DETAIL, new int[]{25, 26},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents kakuna = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 20, 21, 22, 23}
    );
    public static final SpriteComponents beedrill = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{20, 21, 22, 23, 24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 12, 13, 14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents pidgey = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{18, 19, 20, 21, 22, 23, 24, 25},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents pidgeotto = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{18, 19, 20, 21, 22, 23, 24, 25},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents pidgeot = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_DETAIL, new int[]{20, 21}
    );
    public static final SpriteComponents rattata = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11, 12, 13},
//            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_DETAIL, new int[]{6, 7, 8, 9}
    );
    public static final SpriteComponents raticate = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{16, 17, 18, 19, 20, 21, 22, 23},
            SpriteComponent.PRIMARY_DETAIL, new int[]{4, 5, 6, 7},
            SpriteComponent.SECONDARY_BODY, new int[]{8, 9, 10, 11, 12, 13, 14, 15}
    );
    public static final SpriteComponents spearow = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 22, 23, 24, 25, 26, 27},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7, 8, 9}
    );
    public static final SpriteComponents fearow = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{18, 19, 20, 21, 22, 23, 24, 25, 26, 27},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15, 28, 29, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9}
    );
    public static final SpriteComponents ekans = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents arbok = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{18, 19, 20, 21, 22, 23, 24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 4, 5, 6, 7},
            SpriteComponent.SECONDARY_DETAIL, new int[]{10, 11, 12, 13, 14, 15}
    );
    public static final SpriteComponents pikachu = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 22, 23, 24, 25}
    );
    public static final SpriteComponents raichu = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17},
            SpriteComponent.SECONDARY_DETAIL, new int[]{18, 19, 20, 21, 22, 23, 24, 25}
    );
    public static final SpriteComponents sandshrew = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{6, 7, 8, 9, 10, 11, 14, 15, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25, 22, 23, 20, 21}
    );
    public static final SpriteComponents sandslash = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 14, 15},
            SpriteComponent.SECONDARY_DETAIL, new int[]{20, 21, 22, 23, 24, 25, 26, 27}
    );
    public static final SpriteComponents nidoranFemale = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 20, 21}
    );
    public static final SpriteComponents nidorina = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{8, 9, 10, 11, 12, 13}
    );
    public static final SpriteComponents nidoqueen = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7, 8, 9, 10, 11, 12, 13}
    );
    public static final SpriteComponents nidoranMale = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 22, 23, 24, 25, 26, 27},
            SpriteComponent.SECONDARY_DETAIL, new int[]{14, 15, 16, 17}
    );
    public static final SpriteComponents nidorino = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 22, 23, 24, 25, 26, 27},
            SpriteComponent.SECONDARY_DETAIL, new int[]{12, 13, 14, 15}
    );
    public static final SpriteComponents nidoking = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{14, 15, 14, 15, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_DETAIL, new int[]{16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents clefairy = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents clefable = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 8, 9, 12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25, 26, 27, 28, 29}
    );
    public static final SpriteComponents vulpix = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7},
            SpriteComponent.SECONDARY_DETAIL, new int[]{16, 17, 18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents ninetales = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 18, 19, 26, 27, 20, 21, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 8, 9}
    );
    public static final SpriteComponents jigglypuff = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents wigglytuff = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 8, 9, 10, 11}
    );
    public static final SpriteComponents zubat = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 22, 23, 24, 25, 26, 27}
    );
    public static final SpriteComponents golbat = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23, 24, 25}
    );
    public static final SpriteComponents oddish = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{8, 9, 10, 11, 12, 13, 14, 15}
    );
    public static final SpriteComponents gloom = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{14, 15, 16, 17, 18, 19, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_DETAIL, new int[]{2, 3, 12, 13}
    );
    public static final SpriteComponents vileplume = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11, 12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_DETAIL, new int[]{18, 19, 20, 21}
    );
    public static final SpriteComponents paras = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 14, 15, 16, 17},
            SpriteComponent.PRIMARY_DETAIL, new int[]{8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 22, 23, 24, 25, 26, 27}
    );
    public static final SpriteComponents parasect = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.PRIMARY_DETAIL, new int[]{8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29}
    );
    public static final SpriteComponents venonat = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents venomoth = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.SECONDARY_BODY, new int[]{8, 9, 10, 11, 12, 13, 14, 15}
    );
    public static final SpriteComponents diglett = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents dugtrio = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents meowth = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.PRIMARY_DETAIL, new int[]{18, 19, 20, 21, 22, 23},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_DETAIL, new int[]{10, 11, 12, 13}
    );
    public static final SpriteComponents persian = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.SECONDARY_BODY, new int[]{8, 9, 10, 11, 12, 13},
            SpriteComponent.SECONDARY_DETAIL, new int[]{14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents psyduck = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9}
    );
    public static final SpriteComponents golduck = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents mankey = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.PRIMARY_DETAIL, new int[]{6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents primeape = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents growlithe = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents arcanine = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents poliwag = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{16, 17, 18, 19, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9}
    );
    public static final SpriteComponents poliwhirl = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 16, 17, 16, 17, 18, 19}
    );
    public static final SpriteComponents poliwrath = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 16, 17, 18, 19}
    );
    public static final SpriteComponents abra = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents kadabra = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_DETAIL, new int[]{6, 7, 8, 9}
    );
    public static final SpriteComponents alakazam = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents machop = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents machoke = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents machamp = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents bellsprout = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 12, 13, 14, 15, 16, 17},
            SpriteComponent.PRIMARY_DETAIL, new int[]{6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23, 4, 5}
    );
    public static final SpriteComponents weepinbell = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 4, 5},
            SpriteComponent.PRIMARY_DETAIL, new int[]{6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23, 24, 25}
    );
    public static final SpriteComponents victreebel = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 4, 5},
            SpriteComponent.PRIMARY_DETAIL, new int[]{8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23, 24, 25}
    );
    public static final SpriteComponents tentacool = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents tentacruel = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents geodude = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7}
    );
    public static final SpriteComponents graveler = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.SECONDARY_DETAIL, new int[]{10, 11, 12, 13}
    );
    public static final SpriteComponents golem = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23, 24, 25},
            SpriteComponent.SECONDARY_DETAIL, new int[]{6, 7, 8, 9}
    );
    public static final SpriteComponents ponyta = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23, 24, 25}
    );
    public static final SpriteComponents rapidash = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23, 24, 25}
    );
    public static final SpriteComponents slowpoke = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7, 8, 9, 10, 11, 12, 13}
    );
    public static final SpriteComponents slowbro = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents magnemite = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{6, 7, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21},
            SpriteComponent.SECONDARY_DETAIL, new int[]{10, 11, 12, 13}
    );
    public static final SpriteComponents magneton = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{6, 7, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21},
            SpriteComponent.SECONDARY_DETAIL, new int[]{10, 11, 12, 13}
    );
    public static final SpriteComponents farfetchd = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7, 8, 9},
            SpriteComponent.SECONDARY_DETAIL, new int[]{16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents doduo = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents dodrio = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{16, 17, 18, 19, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_DETAIL, new int[]{26, 27}
    );
    public static final SpriteComponents seel = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents dewgong = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13}
    );
    public static final SpriteComponents grimer = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9}
    );
    public static final SpriteComponents muk = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents shellder = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents cloyster = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 22, 23, 24, 25, 26, 27}
    );
    public static final SpriteComponents gastly = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{14, 15, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_DETAIL, new int[]{20, 21, 20, 21, 22, 23, 24, 25}
    );
    public static final SpriteComponents haunter = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents gengar = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13}
    );
    public static final SpriteComponents onix = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7}
    );
    public static final SpriteComponents drowzee = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents hypno = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 10, 11, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 24, 25, 14, 15, 26, 27}
    );
    public static final SpriteComponents krabby = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{8, 9, 10, 11, 12, 13, 14, 15}
    );
    public static final SpriteComponents kingler = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 18, 19, 14, 15, 16, 17}
    );
    public static final SpriteComponents voltorb = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{18, 19, 16, 17, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9}
    );
    public static final SpriteComponents electrode = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 22, 23, 24, 25, 26, 27, 28, 29}
    );
    public static final SpriteComponents exeggcute = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7, 8, 9}
    );
    public static final SpriteComponents exeggutor = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents cubone = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents marowak = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.PRIMARY_DETAIL, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents hitmonlee = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23, 24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents hitmonchan = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents lickitung = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 10, 11, 22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9}
    );
    public static final SpriteComponents koffing = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{18, 19, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7, 8, 9}
    );
    public static final SpriteComponents weezing = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{8, 9, 6, 7},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17}
    );
    public static final SpriteComponents rhyhorn = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_DETAIL, new int[]{12, 13, 14, 15}
    );
    public static final SpriteComponents rhydon = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_DETAIL, new int[]{12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents chansey = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.PRIMARY_DETAIL, new int[]{4, 5},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents tangela = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15}
    );
    public static final SpriteComponents kangaskhan = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.PRIMARY_DETAIL, new int[]{14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7, 8, 9},
            SpriteComponent.SECONDARY_DETAIL, new int[]{18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents horsea = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23, 24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21}
    );
    public static final SpriteComponents seadra = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.PRIMARY_DETAIL, new int[]{2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents goldeen = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 18, 19}
    );
    public static final SpriteComponents seaking = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{26, 27},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23, 24, 25}
    );
    public static final SpriteComponents staryu = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 14, 15, 28, 29, 16, 17, 18, 19},
            SpriteComponent.PRIMARY_DETAIL, new int[]{20, 21, 22, 23, 24, 25, 26, 27},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents starmie = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{20, 21, 22, 23, 24, 25, 26, 27},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents mrMime = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9}
    );
    public static final SpriteComponents scyther = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 10, 11, 12, 13, 21, 20}
    );
    public static final SpriteComponents jynx = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 22, 23, 24, 25, 26, 27}
    );
    public static final SpriteComponents electabuzz = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11}
    );
    public static final SpriteComponents magmar = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents pinsir = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 20, 21, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents tauros = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents magikarp = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.PRIMARY_DETAIL, new int[]{4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents gyarados = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 8, 9, 10, 11, 12, 13, 14, 15},
            SpriteComponent.PRIMARY_DETAIL, new int[]{2, 3, 6, 7},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents lapras = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{14, 15, 16, 17, 18, 19, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{8, 9, 10, 11, 12, 13}
    );
    public static final SpriteComponents ditto = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7}
    );
    public static final SpriteComponents eevee = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents vaporeon = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{14, 15, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{8, 9, 10, 11, 12, 13}
    );
    public static final SpriteComponents jolteon = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 30, 31}
    );
    public static final SpriteComponents flareon = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents porygon = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9}
    );
    public static final SpriteComponents omanyte = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents omastar = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 26, 27, 28, 29, 30, 31},
//            SpriteComponent.PRIMARY_DETAIL, new int[]{2, 3, 4, 5, 6, 7},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents kabuto = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents kabutops = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents aerodactyl = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{8, 9, 10, 11, 12, 13, 14, 15}
    );
    public static final SpriteComponents snorlax = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
//            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17}
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21}
    );
    public static final SpriteComponents articuno = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents zapdos = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents moltres = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{8, 9, 10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_DETAIL, new int[]{16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents dratini = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 18, 19, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9}
    );
    public static final SpriteComponents dragonair = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_DETAIL, new int[]{10, 11, 12, 13, 14, 15}
    );
    public static final SpriteComponents dragonite = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 2, 3, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23},
            SpriteComponent.SECONDARY_DETAIL, new int[]{12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents mewtwo = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{30, 31, 2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents mew = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 22, 23, 24, 25, 18, 19, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{8, 9, 6, 7}
    );
    public static final SpriteComponents chikorita = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{28, 29, 30, 31},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents bayleef = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.PRIMARY_DETAIL, new int[]{28, 29, 30, 31},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents meganium = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{28, 29, 30, 31, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents cyndaquil = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{20, 21, 22, 23, 24, 25, 26, 27},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents quilava = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{20, 21, 22, 23, 24, 25, 26, 27},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents typhlosion = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{20, 21, 22, 23, 24, 25, 26, 27},
            SpriteComponent.SECONDARY_BODY, new int[]{30, 31, 12, 13, 14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents totodile = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23, 24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{26, 27, 28, 29},
            SpriteComponent.SECONDARY_DETAIL, new int[]{16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents croconaw = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_DETAIL, new int[]{16, 17, 18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents feraligatr = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_DETAIL, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents sentret = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents furret = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents hoothoot = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23, 24, 25, 26, 27},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents noctowl = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 28, 29, 6, 7, 8, 9, 10, 11, 18, 19},
            SpriteComponent.PRIMARY_DETAIL, new int[]{20, 21, 22, 23},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents ledyba = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents ledian = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
//            SpriteComponent.PRIMARY_DETAIL, new int[]{20, 21, 22, 23},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19}
//            SpriteComponent.SECONDARY_DETAIL, new int[]{24, 25, 26, 27, 28, 29, 30, 31}
    );
    public static final SpriteComponents spinarak = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.PRIMARY_DETAIL, new int[]{20, 21, 22, 23, 24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents ariados = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.PRIMARY_DETAIL, new int[]{20, 21, 22, 23, 24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents crobat = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23, 24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents chinchou = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27}
    );
    public static final SpriteComponents lanturn = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21, 22, 23, 24, 25}
    );
    public static final SpriteComponents pichu = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents cleffa = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents igglybuff = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23, 26, 27}
    );
    public static final SpriteComponents togepi = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19, 20, 21},
            SpriteComponent.PRIMARY_DETAIL, new int[]{2, 3, 30, 31, 6, 7},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 24, 25},
            SpriteComponent.SECONDARY_DETAIL, new int[]{26, 27, 28, 29}
    );
    public static final SpriteComponents togetic = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{30, 31, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 24, 25},
            SpriteComponent.SECONDARY_DETAIL, new int[]{26, 27, 28, 29}
    );
    public static final SpriteComponents natu = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents xatu = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23},
            SpriteComponent.SECONDARY_DETAIL, new int[]{24, 25, 26, 27, 28, 29}
    );
    public static final SpriteComponents mareep = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.PRIMARY_DETAIL, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 22, 23, 24, 25}
    );
    public static final SpriteComponents flaaffy = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15, 16, 17, 18, 19, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 24, 25}
    );
    public static final SpriteComponents ampharos = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29}
    );
    public static final SpriteComponents bellossom = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23, 24, 25, 26, 27},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_DETAIL, new int[]{16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents marill = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_DETAIL, new int[]{24, 25, 26, 27, 28, 29}
    );
    public static final SpriteComponents azumarill = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_DETAIL, new int[]{24, 25, 26, 27, 28, 29}
    );
    public static final SpriteComponents sudowoodo = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21},
            SpriteComponent.SECONDARY_DETAIL, new int[]{22, 23, 24, 25, 26, 27}
    );
    public static final SpriteComponents politoed = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_DETAIL, new int[]{20, 21, 22, 23, 24, 25}
    );
    public static final SpriteComponents hoppip = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21},
            SpriteComponent.SECONDARY_DETAIL, new int[]{24, 25, 26, 27}
    );
    public static final SpriteComponents skiploom = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21},
            SpriteComponent.SECONDARY_DETAIL, new int[]{2, 3, 26, 27, 28, 29}
    );
    public static final SpriteComponents jumpluff = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{24, 25, 26, 27},
            SpriteComponent.SECONDARY_BODY, new int[]{28, 29, 30, 31},
            SpriteComponent.SECONDARY_DETAIL, new int[]{14, 15, 16, 17, 18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents aipom = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents sunkern = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{14, 15, 12, 13, 10, 11, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{24, 25, 22, 23, 20, 21, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7, 4, 5, 2, 3}
    );
    public static final SpriteComponents sunflora = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{18, 19, 12, 13, 10, 11, 8, 9, 6, 7},
            SpriteComponent.PRIMARY_DETAIL, new int[]{30, 31, 28, 29, 26, 27, 24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 14, 15}
    );
    public static final SpriteComponents yanma = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 8, 9, 6, 7, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 16, 17, 14, 15}
    );
    public static final SpriteComponents wooper = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 10, 11, 8, 9, 6, 7, 4, 5},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents quagsire = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{16, 17, 14, 15, 12, 13, 10, 11, 6, 7, 4, 5, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 24, 25}
    );
    public static final SpriteComponents espeon = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 20, 21, 18, 19, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 10, 11},
            SpriteComponent.SECONDARY_DETAIL, new int[]{28, 29}
    );
    public static final SpriteComponents umbreon = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{14, 15, 12, 13, 10, 11, 8, 9, 6, 7},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 20, 21, 18, 19, 16, 17},
            SpriteComponent.SECONDARY_DETAIL, new int[]{28, 29}
    );
    public static final SpriteComponents murkrow = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{14, 15, 12, 13, 10, 11, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25, 24, 25, 22, 23, 20, 21, 18, 19},
            SpriteComponent.SECONDARY_DETAIL, new int[]{6, 7, 4, 5, 2, 3}
    );
    public static final SpriteComponents slowking = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{14, 15, 12, 13, 10, 11, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{28, 29, 26, 27, 24, 25, 22, 23},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 18, 19, 16, 17},
            SpriteComponent.SECONDARY_DETAIL, new int[]{4, 5, 4, 5, 6, 7}
    );
    public static final SpriteComponents misdreavus = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 8, 9, 6, 7, 4, 5},
            SpriteComponent.PRIMARY_DETAIL, new int[]{26, 27, 24, 25, 22, 23},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 28, 29, 18, 19, 16, 17},
            SpriteComponent.SECONDARY_DETAIL, new int[]{14, 15}
    );
    public static final SpriteComponents unown = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11}
    );
    public static final SpriteComponents wobbuffet = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{28, 29, 26, 27},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11, 8, 9, 6, 7, 4, 5},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 18, 19, 16, 17, 14, 15, 12, 13}
    );
    public static final SpriteComponents girafarig = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 18, 19, 16, 17, 14, 15},
            SpriteComponent.PRIMARY_DETAIL, new int[]{26, 27, 24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 10, 11, 8, 9, 6, 7, 4, 5},
            SpriteComponent.SECONDARY_DETAIL, new int[]{28, 29}
    );
    public static final SpriteComponents pineco = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 18, 19, 16, 17, 14, 15, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25}
    );
    public static final SpriteComponents forretress = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{14, 15, 12, 13, 10, 11, 8, 9, 6, 7},
            SpriteComponent.SECONDARY_BODY, new int[]{26, 27, 24, 25, 22, 23, 20, 21}
    );
    public static final SpriteComponents dunsparce = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{28, 29, 26, 27, 24, 25},
            SpriteComponent.PRIMARY_DETAIL, new int[]{30, 31, 18, 19, 16, 17, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 10, 11, 8, 9, 6, 7}
    );
    public static final SpriteComponents gligar = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{14, 15, 12, 13, 10, 11, 8, 9, 6, 7},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 20, 21, 18, 19, 16, 17},
            SpriteComponent.SECONDARY_DETAIL, new int[]{26, 27, 24, 25}
    );
    public static final SpriteComponents steelix = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{16, 17, 14, 15, 12, 13, 10, 11, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{26, 27}
    );
    public static final SpriteComponents snubbull = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 10, 11, 8, 9, 6, 7},
            SpriteComponent.SECONDARY_BODY, new int[]{26, 27}
    );
    public static final SpriteComponents granbull = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{14, 15, 12, 13, 10, 11, 8, 9, 6, 7},
            SpriteComponent.SECONDARY_BODY, new int[]{28, 29, 26, 27, 24, 25}
    );
    public static final SpriteComponents qwilfish = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{16, 17, 14, 15, 12, 13, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25, 22, 23, 20, 21, 18, 19}
    );
    public static final SpriteComponents scizor = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents shuckle = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 10, 11, 8, 9, 6, 7},
            SpriteComponent.SECONDARY_BODY, new int[]{28, 29, 26, 27, 24, 25, 22, 23},
            SpriteComponent.SECONDARY_DETAIL, new int[]{18, 19, 16, 17}
    );
    public static final SpriteComponents heracross = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents sneasel = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_DETAIL, new int[]{26, 27, 28, 29}
    );
    public static final SpriteComponents teddiursa = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents ursaring = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents slugma = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents magcargo = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_DETAIL, new int[]{22, 23, 24, 25, 26, 27, 28, 29}
    );
    public static final SpriteComponents swinub = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents piloswine = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents corsola = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents remoraid = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15}
    );
    public static final SpriteComponents octillery = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents delibird = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{14, 15, 16, 17, 18, 19, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 22, 23, 24, 25, 26, 27, 28, 29}
    );
    public static final SpriteComponents mantine = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 22, 23, 24, 25, 26, 27, 28, 29}
    );
    public static final SpriteComponents skarmory = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23, 24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents houndour = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents houndoom = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_DETAIL, new int[]{20, 21, 22, 23}
    );
    public static final SpriteComponents kingdra = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23, 24, 25}
    );
    public static final SpriteComponents phanpy = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents donphan = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents porygon2 = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents stantler = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents smeargle = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{6, 7, 8, 9, 10, 11, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 20, 21, 22, 23, 24, 25},
            SpriteComponent.SECONDARY_DETAIL, new int[]{12, 13, 14, 15}
    );
    public static final SpriteComponents tyrogue = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents hitmontop = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents smoochum = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{20, 21, 22, 23, 24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 4, 5, 16, 17}
    );
    public static final SpriteComponents elekid = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents magby = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents miltank = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents blissey = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9}
    );
    public static final SpriteComponents raikou = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_DETAIL, new int[]{20, 21}
    );
    public static final SpriteComponents entei = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{18, 19, 20, 21, 22, 23},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_DETAIL, new int[]{14, 15, 16, 17, 12, 13}
    );
    public static final SpriteComponents suicune = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_DETAIL, new int[]{20, 21}
    );
    public static final SpriteComponents larvitar = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents pupitar = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 14, 15, 14, 15}
    );
    public static final SpriteComponents tyranitar = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents lugia = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents hoOh = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{20, 21, 22, 23, 24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents celebi = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents treecko = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{8, 9, 18, 19, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_DETAIL, new int[]{2, 3, 4, 5, 6, 7}
    );
    public static final SpriteComponents grovyle = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{26, 27, 20, 21, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 14, 15, 22, 23, 12, 13},
            SpriteComponent.SECONDARY_DETAIL, new int[]{18, 19, 24, 25}
    );
    public static final SpriteComponents sceptile = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_DETAIL, new int[]{2, 3, 4, 5, 6, 7, 8, 9}
    );
    public static final SpriteComponents torchic = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{2, 3, 4, 5, 6, 7},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents combusken = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 10, 11, 12, 13, 14, 15, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{4, 5, 6, 7},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29, 18, 19}
    );
    public static final SpriteComponents blaziken = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 10, 11, 12, 13, 14, 15, 16, 17},
            SpriteComponent.PRIMARY_DETAIL, new int[]{4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{26, 27, 28, 29, 22, 23},
            SpriteComponent.SECONDARY_DETAIL, new int[]{24, 25, 18, 19, 20, 21}
    );
    public static final SpriteComponents mudkip = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11, 12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 2, 3, 4, 5, 6, 7, 8, 9}
    );
    public static final SpriteComponents marshtomp = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 22, 23, 24, 25, 26, 27},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 4, 5, 6, 7},
            SpriteComponent.SECONDARY_DETAIL, new int[]{8, 9, 8, 9, 8, 9, 28, 29}
    );
    public static final SpriteComponents swampert = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 24, 25, 26, 27},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11, 12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 4, 5},
            SpriteComponent.SECONDARY_DETAIL, new int[]{6, 7, 6, 7, 28, 29, 20, 21, 8, 9}
    );
    public static final SpriteComponents poochyena = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 18, 19, 10, 11, 12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 20, 21, 22, 23},
            SpriteComponent.SECONDARY_DETAIL, new int[]{6, 7, 24, 25, 26, 27}
    );
    public static final SpriteComponents mightyena = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{16, 17, 18, 19, 6, 7, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25, 26, 27},
            SpriteComponent.SECONDARY_DETAIL, new int[]{20, 21}
    );
    public static final SpriteComponents zigzagoon = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 28, 29, 14, 15, 2, 3, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 18, 19, 16, 17, 26, 27}
    );
    public static final SpriteComponents linoone = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 18, 19, 16, 17, 14, 15},
            SpriteComponent.PRIMARY_DETAIL, new int[]{8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25, 22, 23}
    );
    public static final SpriteComponents wurmple = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{14, 15, 12, 13, 10, 11, 4, 5, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 18, 19}
    );
    public static final SpriteComponents silcoon = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{16, 17, 14, 15, 12, 13, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{6, 7, 6, 7, 4, 5, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 20, 21, 22, 23}
    );
    public static final SpriteComponents beautifly = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 18, 19, 16, 17, 4, 5, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 10, 11, 8, 9},
            SpriteComponent.SECONDARY_DETAIL, new int[]{26, 27}
    );
    public static final SpriteComponents cascoon = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{16, 17, 14, 15, 12, 13, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{6, 7, 6, 7, 4, 5, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 24, 25, 18, 19, 20, 21}
    );
    public static final SpriteComponents dustox = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{14, 15, 12, 13, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{24, 25, 22, 23, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 16, 17, 6, 7, 4, 5, 2, 3},
            SpriteComponent.SECONDARY_DETAIL, new int[]{28, 29, 26, 27}
    );
    public static final SpriteComponents lotad = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23, 24, 25, 26, 27, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 4, 5, 6, 7}
    );
    public static final SpriteComponents lombre = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 20, 21, 18, 19, 16, 17, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 10, 11, 8, 9, 4, 5},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 14, 15, 6, 7}
    );
    public static final SpriteComponents ludicolo = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25, 22, 23, 26, 27},
            SpriteComponent.SECONDARY_DETAIL, new int[]{28, 29}
    );
    public static final SpriteComponents seedot = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 20, 21},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 10, 11, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7, 18, 19, 16, 17, 14, 15, 2, 3}
    );
    public static final SpriteComponents nuzleaf = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{18, 19, 18, 19, 15, 16, 14, 15, 26, 27, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23, 20, 21, 24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 10, 11, 8, 9}
    );
    public static final SpriteComponents shiftry = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 10, 11, 8, 9, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{26, 27, 24, 25, 22, 23},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7, 16, 17, 18, 19, 4, 5},
            SpriteComponent.SECONDARY_DETAIL, new int[]{28, 29}
    );
    public static final SpriteComponents taillow = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23, 20, 21, 18, 19, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 12, 13, 10, 11},
            SpriteComponent.SECONDARY_DETAIL, new int[]{26, 27, 24, 25}
    );
    public static final SpriteComponents swellow = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23, 20, 21, 18, 19, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 12, 13, 10, 11},
            SpriteComponent.SECONDARY_DETAIL, new int[]{26, 27, 24, 25}
    );
    public static final SpriteComponents wingull = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 6, 7, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23, 20, 21, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{30, 31, 16, 17, 14, 15, 18, 19}
    );
    public static final SpriteComponents pelipper = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 18, 19, 28, 29, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 16, 17, 14, 15, 30, 31},
            SpriteComponent.SECONDARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 24, 25, 2, 3}
    );
    public static final SpriteComponents ralts = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 10, 11}
    );
    public static final SpriteComponents kirlia = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 18, 19},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 10, 11}
    );
    public static final SpriteComponents gardevoir = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 10, 11}
    );
    public static final SpriteComponents surskit = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 4, 5, 6, 7, 24, 25, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11, 12, 13, 22, 23, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21}
    );
    public static final SpriteComponents masquerain = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{28, 29, 8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{14, 15, 12, 13, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25, 26, 27},
            SpriteComponent.SECONDARY_DETAIL, new int[]{22, 23, 20, 21}
    );
    public static final SpriteComponents shroomish = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 10, 11, 8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25, 20, 21, 18, 19, 16, 17, 14, 15, 22, 23}
    );
    public static final SpriteComponents breloom = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 16, 17, 12, 13},
            SpriteComponent.PRIMARY_DETAIL, new int[]{24, 25, 26, 27, 30, 31, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21, 22, 23, 14, 15}
    );
    public static final SpriteComponents slakoth = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{30, 31, 28, 29, 26, 27},
            SpriteComponent.PRIMARY_DETAIL, new int[]{24, 25, 22, 23, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{8, 9, 8, 9, 8, 9, 6, 7, 4, 5, 2, 3}
    );
    public static final SpriteComponents vigoroth = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 14, 15, 12, 13, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{26, 27, 8, 9, 6, 7, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 20, 21, 18, 19, 4, 5}
    );
    public static final SpriteComponents slaking = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 10, 11, 8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 18, 19, 16, 17, 14, 15}
    );
    public static final SpriteComponents nincada = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{16, 17, 2, 3, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{4, 5, 6, 7, 8, 9, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 18, 19}
    );
    public static final SpriteComponents ninjask = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents shedinja = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 2, 3, 4, 5, 6, 7, 8, 9, 18, 19, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29}
    );
    public static final SpriteComponents whismur = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents loudred = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents exploud = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{26, 27, 4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents makuhita = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 10, 11, 12, 13, 14, 15, 26, 27},
            SpriteComponent.PRIMARY_DETAIL, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents hariyama = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11, 12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 20, 21},
            SpriteComponent.SECONDARY_DETAIL, new int[]{22, 23, 24, 25, 26, 27}
    );
    public static final SpriteComponents azurill = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 8, 9, 4, 5, 22, 23, 6, 7, 16, 17, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 18, 19, 14, 15}
    );
    public static final SpriteComponents nosepass = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 24, 25, 10, 11, 8, 9, 6, 7, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 18, 19, 16, 17, 14, 15}
    );
    public static final SpriteComponents skitty = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{16, 17, 24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.PRIMARY_DETAIL, new int[]{20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11}
    );
    public static final SpriteComponents delcatty = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{14, 15, 24, 25, 26, 27, 28, 29, 30, 31, 12, 13},
            SpriteComponent.PRIMARY_DETAIL, new int[]{18, 19, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 15, 16, 10, 11}
    );
    public static final SpriteComponents sableye = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 26, 27, 4, 5, 18, 19, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{30, 31, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 20, 21, 10, 11}
    );
    public static final SpriteComponents mawile = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25, 26, 27, 28, 29, 30, 31}
    );
    public static final SpriteComponents aron = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 18, 19, 16, 17, 14, 15},
            SpriteComponent.PRIMARY_DETAIL, new int[]{28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{6, 7, 4, 5, 2, 3, 10, 11}
    );
    public static final SpriteComponents lairon = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 18, 19, 16, 17, 14, 15},
            SpriteComponent.PRIMARY_DETAIL, new int[]{28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 2, 3, 10, 11}
    );
    public static final SpriteComponents aggron = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 18, 19, 16, 17, 14, 15},
            SpriteComponent.PRIMARY_DETAIL, new int[]{28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 2, 3, 10, 11}
    );
    public static final SpriteComponents meditite = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23},
            SpriteComponent.SECONDARY_DETAIL, new int[]{12, 13}
    );
    public static final SpriteComponents medicham = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 26, 27, 28, 29, 30, 31},
            SpriteComponent.PRIMARY_DETAIL, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 22, 23, 14, 15}
    );
    public static final SpriteComponents electrike = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15}
    );
    public static final SpriteComponents manectric = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents plusle = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents minun = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents volbeat = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{30, 31, 2, 3, 4, 5, 6, 7},
            SpriteComponent.PRIMARY_DETAIL, new int[]{24, 25, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_DETAIL, new int[]{18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents illumise = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7},
            SpriteComponent.PRIMARY_DETAIL, new int[]{24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_DETAIL, new int[]{18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents roselia = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 18, 19, 12, 13, 6, 7},
            SpriteComponent.PRIMARY_DETAIL, new int[]{24, 25, 22, 23, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 16, 17, 14, 15, 10, 11},
            SpriteComponent.SECONDARY_DETAIL, new int[]{30, 31, 28, 29, 26, 27}
    );
    public static final SpriteComponents gulpin = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 10, 11, 4, 5, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25, 22, 23, 20, 21, 18, 19}
    );
    public static final SpriteComponents swalot = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 2, 3, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{26, 27, 22, 23, 20, 21}
    );
    public static final SpriteComponents carvanha = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 10, 11, 8, 9, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{18, 19, 16, 17, 14, 15, 26, 27},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25, 22, 23, 20, 21, 6, 7}
    );
    public static final SpriteComponents sharpedo = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 12, 13}
    );
    public static final SpriteComponents wailmer = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 8, 9, 6, 7, 4, 5, 22, 23, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 18, 19, 24, 25}
    );
    public static final SpriteComponents wailord = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19, 30, 31, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 24, 25}
    );
    public static final SpriteComponents numel = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 8, 9, 14, 15, 4, 5, 6, 7, 24, 25, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23},
            SpriteComponent.SECONDARY_BODY, new int[]{18, 19, 16, 17, 20, 21},
            SpriteComponent.SECONDARY_DETAIL, new int[]{10, 11, 12, 13}
    );
    public static final SpriteComponents camerupt = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 8, 9, 6, 7, 4, 5},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_DETAIL, new int[]{20, 21, 14, 15}
    );
    public static final SpriteComponents torkoal = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 10, 11, 12, 13, 14, 15, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{2, 3, 4, 5, 6, 7},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents spoink = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 24, 25, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 18, 19, 16, 17}
    );
    public static final SpriteComponents grumpig = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{26, 27, 16, 17, 18, 19, 20, 21, 22, 23},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 24, 25}
    );
    public static final SpriteComponents spinda = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents trapinch = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 12, 13, 16, 17}
    );
    public static final SpriteComponents vibrava = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 10, 11, 12, 13, 20, 21},
            SpriteComponent.PRIMARY_DETAIL, new int[]{16, 17, 18, 19, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 4, 5, 6, 7}
    );
    public static final SpriteComponents flygon = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 6, 7, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{16, 17, 18, 19, 20, 21, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 4, 5}
    );
    public static final SpriteComponents cacnea = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15, 16, 17, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{28, 29, 24, 25, 26, 27}
    );
    public static final SpriteComponents cacturne = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 2, 3, 4, 5, 6, 7, 8, 9, 18, 19},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11, 12, 13, 14, 15, 16, 17, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25}
    );
    public static final SpriteComponents swablu = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{26, 27, 16, 17, 18, 19, 20, 21, 8, 9},
            SpriteComponent.SECONDARY_BODY, new int[]{28, 29, 10, 11, 2, 3, 14, 15}
    );
    public static final SpriteComponents altaria = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{14, 15, 16, 17, 18, 19, 20, 21, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25, 6, 7, 26, 27, 4, 5}
    );
    public static final SpriteComponents zangoose = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 24, 25, 6, 7, 8, 9, 22, 23, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 20, 21, 28, 29, 30, 31},
            SpriteComponent.SECONDARY_DETAIL, new int[]{18, 19, 12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents seviper = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 22, 23, 24, 25, 4, 5},
            SpriteComponent.PRIMARY_DETAIL, new int[]{6, 7, 8, 9, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{28, 29, 10, 11, 30, 31},
            SpriteComponent.SECONDARY_DETAIL, new int[]{14, 15, 16, 17}
    );
    public static final SpriteComponents lunatone = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 24, 25, 26, 27, 28, 29}
    );
    public static final SpriteComponents solrock = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 10, 11, 12, 13, 14, 15, 16, 17},
            SpriteComponent.PRIMARY_DETAIL, new int[]{24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 18, 19}
    );
    public static final SpriteComponents barboach = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 10, 11, 8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 28, 29, 26, 27, 24, 25, 22, 23, 20, 21}
    );
    public static final SpriteComponents whiscash = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 8, 9, 6, 7, 4, 5, 18, 19},
            SpriteComponent.PRIMARY_DETAIL, new int[]{16, 17, 28, 29, 26, 27, 24, 25, 22, 23},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 12, 13, 20, 21}
    );
    public static final SpriteComponents corphish = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 22, 23, 4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents crawdaunt = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{18, 19, 20, 21, 4, 5, 6, 7, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{26, 27, 22, 23, 24, 25, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents baltoy = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 10, 11, 8, 9, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{4, 5},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 14, 15}
    );
    public static final SpriteComponents claydol = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{6, 7, 4, 5, 8, 9, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23, 24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents lileep = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{18, 19, 20, 21, 22, 23},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents cradily = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{18, 19, 20, 21, 22, 23},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 28, 29}
    );
    public static final SpriteComponents anorith = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 22, 23, 18, 19}
    );
    public static final SpriteComponents armaldo = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 18, 19, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_DETAIL, new int[]{20, 21, 20, 21}
    );
    public static final SpriteComponents feebas = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7},
            SpriteComponent.PRIMARY_DETAIL, new int[]{4, 5, 14, 15, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25, 22, 23, 20, 21}
    );
    public static final SpriteComponents milotic = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23, 24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 12, 13, 26, 27},
            SpriteComponent.SECONDARY_DETAIL, new int[]{18, 19, 16, 17, 20, 21}
    );
    public static final SpriteComponents castform = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 24, 25, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 14, 15}
    );
    public static final SpriteComponents kecleon = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 8, 9, 28, 29, 6, 7, 4, 5, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25, 22, 23, 20, 21, 26, 27},
            SpriteComponent.SECONDARY_DETAIL, new int[]{18, 19, 16, 17, 14, 15}
    );
    public static final SpriteComponents shuppet = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 8, 9, 6, 7, 4, 5, 10, 11, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{20, 21, 22, 23},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19},
            SpriteComponent.SECONDARY_DETAIL, new int[]{12, 13, 14, 15}
    );
    public static final SpriteComponents banette = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9, 12, 13, 14, 15, 16, 17}
    );
    public static final SpriteComponents duskull = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 22, 23, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{20, 21, 28, 29, 26, 27},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 10, 11, 12, 13, 18, 19}
    );
    public static final SpriteComponents dusclops = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 10, 11, 8, 9, 4, 5, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 14, 15}
    );
    public static final SpriteComponents tropius = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 30, 31, 4, 5, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{16, 17, 14, 15, 12, 13, 10, 11},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 18, 19}
    );
    public static final SpriteComponents chimecho = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 10, 11, 20, 21},
            SpriteComponent.PRIMARY_DETAIL, new int[]{16, 17, 18, 19, 28, 29, 30, 31},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 5, 26, 27, 22, 23, 24, 25}
    );
    public static final SpriteComponents absol = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{24, 25, 26, 27, 28, 29, 22, 23}
    );
    public static final SpriteComponents wynaut = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 20, 21, 14, 15, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 24, 25, 2, 3}
    );
    public static final SpriteComponents snorunt = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 12, 13, 14, 15},
            SpriteComponent.PRIMARY_DETAIL, new int[]{16, 17, 20, 21},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9}
    );
    public static final SpriteComponents glalie = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 16, 17, 18, 19}
    );
    public static final SpriteComponents spheal = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 10, 11, 8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{22, 23, 20, 21, 18, 19, 16, 17, 14, 15}
    );
    public static final SpriteComponents sealeo = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{26, 27, 8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{30, 31, 16, 17, 14, 15, 12, 13, 24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{28, 29, 22, 23, 20, 21, 18, 19}
    );
    public static final SpriteComponents walrein = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{30, 31, 28, 29, 24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 14, 15, 12, 13, 10, 11}
    );
    public static final SpriteComponents clamperl = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{26, 27, 28, 29, 30, 31},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 18, 19, 20, 21}
    );
    public static final SpriteComponents huntail = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{12, 13, 14, 15, 16, 17, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9}
    );
    public static final SpriteComponents gorebyss = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 10, 11, 12, 13, 14, 15, 16, 17},
            SpriteComponent.PRIMARY_DETAIL, new int[]{4, 5},
            SpriteComponent.SECONDARY_BODY, new int[]{26, 27, 28, 29, 30, 31, 20, 21}
    );
    public static final SpriteComponents relicanth = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{28, 29, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11},
            SpriteComponent.PRIMARY_DETAIL, new int[]{24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 16, 17, 18, 19, 20, 21, 22, 23}
    );
    public static final SpriteComponents luvdisc = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{16, 17, 14, 15, 12, 13, 10, 11, 4, 5, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 18, 19}
    );
    public static final SpriteComponents bagon = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{20, 21, 18, 19, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{14, 15, 12, 13, 10, 11}
    );
    public static final SpriteComponents shelgon = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{6, 7, 4, 5, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23, 20, 21, 28, 29, 18, 19, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{12, 13, 10, 11, 8, 9},
            SpriteComponent.SECONDARY_DETAIL, new int[]{24, 25, 26, 27}
    );
    public static final SpriteComponents salamence = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{24, 25, 22, 23, 20, 21, 18, 19},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 14, 15, 12, 13, 10, 11}
    );
    public static final SpriteComponents beldum = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{18, 19, 22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{16, 17, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 2, 3, 4, 5, 6, 7, 8, 9}
    );
    public static final SpriteComponents metang = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{18, 19, 22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{16, 17, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 2, 3, 4, 5, 6, 7, 8, 9}
    );
    public static final SpriteComponents metagross = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{20, 21, 18, 19, 22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{16, 17, 14, 15},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 2, 3, 4, 5, 6, 7, 8, 9}
    );
    public static final SpriteComponents regirock = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 8, 9, 6, 7, 12, 13, 4, 5, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{28, 29, 26, 27},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 18, 19, 16, 17, 14, 15}
    );
    public static final SpriteComponents regice = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{14, 15, 10, 11, 8, 9, 6, 7, 12, 13, 4, 5, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{26, 27, 28, 29, 24, 25}
    );
    public static final SpriteComponents registeel = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{22, 23, 10, 11, 8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{26, 27, 28, 29, 24, 25},
            SpriteComponent.SECONDARY_BODY, new int[]{16, 17, 14, 15, 12, 13}
    );
    public static final SpriteComponents latias = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{18, 19, 22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{10, 11, 12, 13},
            SpriteComponent.SECONDARY_BODY, new int[]{2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_DETAIL, new int[]{14, 15, 16, 17}
    );
    public static final SpriteComponents latios = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{18, 19, 22, 23, 24, 25, 26, 27, 28, 29},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 2, 3, 4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_DETAIL, new int[]{14, 15, 16, 17, 12, 13}
    );
    public static final SpriteComponents kyogre = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{18, 19, 18, 19, 22, 23, 24, 25, 26, 27, 10, 11, 28, 29},
            SpriteComponent.PRIMARY_DETAIL, new int[]{14, 15, 14, 15, 16, 17},
            SpriteComponent.SECONDARY_BODY, new int[]{20, 21, 4, 5, 6, 7, 8, 9},
            SpriteComponent.SECONDARY_DETAIL, new int[]{2, 3}
    );
    public static final SpriteComponents groudon = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{24, 25, 10, 11, 14, 15, 2, 3, 16, 17, 12, 13},
            SpriteComponent.PRIMARY_DETAIL, new int[]{18, 19, 26, 27},
            SpriteComponent.SECONDARY_BODY, new int[]{4, 5, 6, 7, 8, 9}
    );
    public static final SpriteComponents rayquaza = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{10, 11, 10, 11, 8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.SECONDARY_BODY, new int[]{26, 27, 28, 29},
            SpriteComponent.SECONDARY_DETAIL, new int[]{18, 19, 20, 21}
    );
    public static final SpriteComponents jirachi = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 2, 3, 4, 5, 14, 15},
            SpriteComponent.PRIMARY_DETAIL, new int[]{12, 13, 10, 11, 6, 7},
            SpriteComponent.SECONDARY_BODY, new int[]{26, 27, 24, 25, 22, 23}
    );
    public static final SpriteComponents deoxys = SpriteComponents.of(
            SpriteComponent.PRIMARY_BODY, new int[]{8, 9, 6, 7, 4, 5, 2, 3},
            SpriteComponent.PRIMARY_DETAIL, new int[]{22, 23},
            SpriteComponent.SECONDARY_BODY, new int[]{10, 11, 12, 13, 14, 15},
            SpriteComponent.SECONDARY_DETAIL, new int[]{20, 21}
    );

    public static final SpriteComponents[] POKEMON_COMPONENTS = new SpriteComponents[]{
            bulbasaur,
            ivysaur,
            venusaur,
            charmander,
            charmeleon,
            charizard,
            squirtle,
            wartortle,
            blastoise,
            caterpie,
            metapod,
            butterfree,
            weedle,
            kakuna,
            beedrill,
            pidgey,
            pidgeotto,
            pidgeot,
            rattata,
            raticate,
            spearow,
            fearow,
            ekans,
            arbok,
            pikachu,
            raichu,
            sandshrew,
            sandslash,
            nidoranFemale,
            nidorina,
            nidoqueen,
            nidoranMale,
            nidorino,
            nidoking,
            clefairy,
            clefable,
            vulpix,
            ninetales,
            jigglypuff,
            wigglytuff,
            zubat,
            golbat,
            oddish,
            gloom,
            vileplume,
            paras,
            parasect,
            venonat,
            venomoth,
            diglett,
            dugtrio,
            meowth,
            persian,
            psyduck,
            golduck,
            mankey,
            primeape,
            growlithe,
            arcanine,
            poliwag,
            poliwhirl,
            poliwrath,
            abra,
            kadabra,
            alakazam,
            machop,
            machoke,
            machamp,
            bellsprout,
            weepinbell,
            victreebel,
            tentacool,
            tentacruel,
            geodude,
            graveler,
            golem,
            ponyta,
            rapidash,
            slowpoke,
            slowbro,
            magnemite,
            magneton,
            farfetchd,
            doduo,
            dodrio,
            seel,
            dewgong,
            grimer,
            muk,
            shellder,
            cloyster,
            gastly,
            haunter,
            gengar,
            onix,
            drowzee,
            hypno,
            krabby,
            kingler,
            voltorb,
            electrode,
            exeggcute,
            exeggutor,
            cubone,
            marowak,
            hitmonlee,
            hitmonchan,
            lickitung,
            koffing,
            weezing,
            rhyhorn,
            rhydon,
            chansey,
            tangela,
            kangaskhan,
            horsea,
            seadra,
            goldeen,
            seaking,
            staryu,
            starmie,
            mrMime,
            scyther,
            jynx,
            electabuzz,
            magmar,
            pinsir,
            tauros,
            magikarp,
            gyarados,
            lapras,
            ditto,
            eevee,
            vaporeon,
            jolteon,
            flareon,
            porygon,
            omanyte,
            omastar,
            kabuto,
            kabutops,
            aerodactyl,
            snorlax,
            articuno,
            zapdos,
            moltres,
            dratini,
            dragonair,
            dragonite,
            mewtwo,
            mew,
            chikorita,
            bayleef,
            meganium,
            cyndaquil,
            quilava,
            typhlosion,
            totodile,
            croconaw,
            feraligatr,
            sentret,
            furret,
            hoothoot,
            noctowl,
            ledyba,
            ledian,
            spinarak,
            ariados,
            crobat,
            chinchou,
            lanturn,
            pichu,
            cleffa,
            igglybuff,
            togepi,
            togetic,
            natu,
            xatu,
            mareep,
            flaaffy,
            ampharos,
            bellossom,
            marill,
            azumarill,
            sudowoodo,
            politoed,
            hoppip,
            skiploom,
            jumpluff,
            aipom,
            sunkern,
            sunflora,
            yanma,
            wooper,
            quagsire,
            espeon,
            umbreon,
            murkrow,
            slowking,
            misdreavus,
            unown,
            wobbuffet,
            girafarig,
            pineco,
            forretress,
            dunsparce,
            gligar,
            steelix,
            snubbull,
            granbull,
            qwilfish,
            scizor,
            shuckle,
            heracross,
            sneasel,
            teddiursa,
            ursaring,
            slugma,
            magcargo,
            swinub,
            piloswine,
            corsola,
            remoraid,
            octillery,
            delibird,
            mantine,
            skarmory,
            houndour,
            houndoom,
            kingdra,
            phanpy,
            donphan,
            porygon2,
            stantler,
            smeargle,
            tyrogue,
            hitmontop,
            smoochum,
            elekid,
            magby,
            miltank,
            blissey,
            raikou,
            entei,
            suicune,
            larvitar,
            pupitar,
            tyranitar,
            lugia,
            hoOh,
            celebi,
            treecko,
            grovyle,
            sceptile,
            torchic,
            combusken,
            blaziken,
            mudkip,
            marshtomp,
            swampert,
            poochyena,
            mightyena,
            zigzagoon,
            linoone,
            wurmple,
            silcoon,
            beautifly,
            cascoon,
            dustox,
            lotad,
            lombre,
            ludicolo,
            seedot,
            nuzleaf,
            shiftry,
            taillow,
            swellow,
            wingull,
            pelipper,
            ralts,
            kirlia,
            gardevoir,
            surskit,
            masquerain,
            shroomish,
            breloom,
            slakoth,
            vigoroth,
            slaking,
            nincada,
            ninjask,
            shedinja,
            whismur,
            loudred,
            exploud,
            makuhita,
            hariyama,
            azurill,
            nosepass,
            skitty,
            delcatty,
            sableye,
            mawile,
            aron,
            lairon,
            aggron,
            meditite,
            medicham,
            electrike,
            manectric,
            plusle,
            minun,
            volbeat,
            illumise,
            roselia,
            gulpin,
            swalot,
            carvanha,
            sharpedo,
            wailmer,
            wailord,
            numel,
            camerupt,
            torkoal,
            spoink,
            grumpig,
            spinda,
            trapinch,
            vibrava,
            flygon,
            cacnea,
            cacturne,
            swablu,
            altaria,
            zangoose,
            seviper,
            lunatone,
            solrock,
            barboach,
            whiscash,
            corphish,
            crawdaunt,
            baltoy,
            claydol,
            lileep,
            cradily,
            anorith,
            armaldo,
            feebas,
            milotic,
            castform,
            kecleon,
            shuppet,
            banette,
            duskull,
            dusclops,
            tropius,
            chimecho,
            absol,
            wynaut,
            snorunt,
            glalie,
            spheal,
            sealeo,
            walrein,
            clamperl,
            huntail,
            gorebyss,
            relicanth,
            luvdisc,
            bagon,
            shelgon,
            salamence,
            beldum,
            metang,
            metagross,
            regirock,
            regice,
            registeel,
            latias,
            latios,
            kyogre,
            groudon,
            rayquaza,
            jirachi,
            deoxys,
    };

    private Gen3SpriteComponents() {
    }
}
