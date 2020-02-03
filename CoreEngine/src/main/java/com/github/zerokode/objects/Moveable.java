package com.github.zerokode.objects;

/**
 * Speed is represented in meters per second.
 * Example: If a foe can walk 1 meter in 3 seconds, then: 1 / 3 = 0.33333334 m/s
 */
public interface Moveable {

    float getSpeed();
}
