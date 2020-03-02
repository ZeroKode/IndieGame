package com.github.zerokode.coreengine.objects.characters;

import com.github.zerokode.coreengine.objects.attributes.Attribute;
import com.github.zerokode.coreengine.objects.metrics.Point2D;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class Enemy extends Character {

    Point2D position;
    int health;
    int touchDamage;
    Set<HitBox> hitBoxes;
    Set<Attack> attacks;
    Set<Attribute> attributes;

}
