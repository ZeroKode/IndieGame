package com.github.zerokode.coreengine.objects.metrics;

import com.github.zerokode.coreengine.exceptions.PointOutOfBoundsException;
import lombok.Getter;

@Getter
public class Point2D {

    private int x;
    private int y;

    /**
     * The Pivot Point is the lower left corner of a 2D plane.
     * Use a factory method to create a new instance.
     *
     * @param x - number of pixels in the horizontal plane, should be positive.
     * @param y - number of pixels in the vertical plane, should be positive.
     */
    public Point2D(int x, int y) throws PointOutOfBoundsException {
        validate(x, y);
        this.x = x;
        this.y = y;
    }

    /**
     * Adds the number of pixels to the X-axis.
     *
     * @param amount - positive or negative integer
     * @return the current object modified
     */
    public Point2D addX(int amount) {
        x += amount;
        return this;
    }

    /**
     * Adds the number of pixels to the Y-axis.
     *
     * @param amount - positive or negative integer
     * @return the current object modified
     */
    public Point2D addY(int amount) {
        y += amount;
        return this;
    }

    private static void validate(int x, int y) throws PointOutOfBoundsException {
        if (x < 0 || y < 0) {
            throw new PointOutOfBoundsException(x, y);
        }
    }

    /**
     * Used to avoid modifying the original point when using the addX and addY methods.
     *
     * @return a new instance using the same x and y values, as well as the same precision.
     */
    public Point2D copy() throws PointOutOfBoundsException {
        return new Point2D(x, y);
    }
}
