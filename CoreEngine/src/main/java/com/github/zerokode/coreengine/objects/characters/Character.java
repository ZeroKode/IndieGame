package com.github.zerokode.coreengine.objects.characters;

import lombok.Getter;

import java.util.UUID;

/**
 * This is the class that all players, foes and NPCs have in common.
 */
@Getter
public abstract class Character {

    String id;

    public Character() {
        this.id = UUID.randomUUID().toString();
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Character) {
            return this.id.equals(((Character)obj).getId());
        }
        return false;
    }
}
