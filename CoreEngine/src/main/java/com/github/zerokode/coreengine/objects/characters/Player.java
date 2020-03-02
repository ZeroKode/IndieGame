package com.github.zerokode.coreengine.objects.characters;

import com.github.zerokode.coreengine.objects.attributes.Attribute;
import com.github.zerokode.coreengine.objects.metrics.Point2D;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class Player extends Character {

    int number = 1; // default is 1
    Point2D position;
    int health;
    HitBox hitBox;
    Set<Attack> attacks;
    Set<Attribute> attributes;

}
