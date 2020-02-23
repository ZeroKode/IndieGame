package com.github.zerokode.objects.location;

import lombok.Getter;

@Getter
public class Direction {

    int angle;
    float intensity;

    private Direction(int angle, float intensity) {
        this.angle = angle;
        this.intensity = intensity;
    }

    /**
     * Think of a direction as an arrow that points to one the 360 degrees of a circle.
     * This arrow has an intensity that ranges from 0 to 1, where 0 means not moving and 1 means at full speed.
     * The intensity can be used with analog sticks, but with keyboards the value will always be either 0 or 1.
     *
     * @param angle     - number between 0 and 360 (the degrees of a circle)
     * @param intensity - number between 0 and 1 (0=no speed, 1=full speed)
     * @return
     */
    public static Direction create(int angle, float intensity) {
        validateAngle(angle);
        validateIntensity(intensity);
        return new Direction(angle, intensity);
    }

    private static void validateAngle(int angle) {
        if (angle < 0 || angle > 360) {
            throw new IllegalArgumentException("The angle should be a positive number between 0 and 360 (degrees).");
        }
    }

    private static void validateIntensity(float intensity) {
        if (intensity < 0 || intensity > 1) {
            throw new IllegalArgumentException("The intensity should be a positive number between 0 and 1 (1=full speed).");
        }
    }
}
