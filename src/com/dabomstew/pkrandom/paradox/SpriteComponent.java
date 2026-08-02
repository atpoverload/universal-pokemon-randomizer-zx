package com.dabomstew.pkrandom.paradox;

/**
 * Components that make up a pokemon's sprite.
 */
public enum SpriteComponent {
    UNUSED, // isn't used in the sprite at all
    RESERVED, // transparency, outlines, mouths, eyes
    PRIMARY_BODY, // skin, head
    PRIMARY_DETAIL, // horns, fang, claws
    SECONDARY_BODY, // tummy, wings, shell
    SECONDARY_DETAIL; // spikes, fins, tails
}
