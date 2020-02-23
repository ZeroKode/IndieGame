package com.github.zerokode.coreengine.objects.attributes;

import com.github.zerokode.coreengine.objects.location.Direction;
import lombok.Getter;
import lombok.Setter;

/**
 * Objects with this attribute can be pushed within the limits of the room the belong to.
 * <p>
 * Speed is represented in meters per second.
 * Example: If a foe can walk 1 meter in 3 seconds, then: 1 / 3 = 0.33333334 m/s
 */
@Getter
@Setter
public class Movable extends Attribute {

    private float speed;

    /**
     * All movable objects can be pushed by other moving objects in the room.
     *
     * @param direction - in what direction
     * @param speed - at what speed (meters per second)
     */
    public void push(Direction direction, float speed) {

    }

}
