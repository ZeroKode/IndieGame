package com.github.zerokode.objects;

/**
 * Weight is represented in kilograms.
 * Every other form of measure in the game will be in metric system as well.
 * <p>
 * The weight of objects will affect how the physics system will behave.
 */
public interface Weighted {
    float getWeight();
}
