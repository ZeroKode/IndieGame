package com.github.zerokode.coreengine.objects.attributes;

import lombok.Data;

/**
 * Weight is represented in kilograms.
 * Every other form of measure in the game will be in metric system as well.
 * <p>
 * The weight of objects will affect how the physics system will behave.
 */
@Data
public class Weighted extends Attribute {

    float weight;
    float gravityModifier = 1.0f;

}
