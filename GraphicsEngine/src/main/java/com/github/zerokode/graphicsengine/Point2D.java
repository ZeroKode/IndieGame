package com.github.zerokode.graphicsengine;

import com.github.zerokode.graphicsengine.exception.PointOutOfBoundsException;
import lombok.Getter;

@Getter
public class Point2D {
    private int x, y;

    /**
     * The Pivot Point is the lower left corner of a 2D plane.
     * Use a factory method to create a new instance.
     *
     * @param x - number of pixels in the horizontal plane, should be positive.
     * @param y - number of pixels in the vertical plane, should be positive.
     */
    private Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * The Pivot Point is the lower left corner of a 2D plane.
     *
     * @param x - number of pixels in the horizontal plane, should be positive.
     * @param y - number of pixels in the vertical plane, should be positive.
     */
    public static Point2D create(int x, int y) throws PointOutOfBoundsException {
        validate(x, y);
        return new Point2D(x, y);
    }

    private static void validate(int x, int y) throws PointOutOfBoundsException {
        if (x < 0 || y < 0) {
            throw new PointOutOfBoundsException(x, y);
        }
    }
}
