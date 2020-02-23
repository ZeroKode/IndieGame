package com.github.zerokode.graphicsengine.exception;

import com.github.zerokode.graphicsengine.Dimension2D;
import com.github.zerokode.graphicsengine.Point2D;

public class PointOutOfBoundsException extends Exception {

    public PointOutOfBoundsException(int x, int y) {
        super(getMessage(x, y));
    }

    public PointOutOfBoundsException(Point2D point) {
        super(getMessage(point.getX(), point.getY()));
    }

    public PointOutOfBoundsException(Point2D point, Dimension2D dimension) {
        super("Point2D (" + point.getY() + ", " + point.getY() + ") falls outside of the 2D plane " +
                "defined as width=" + dimension.getWidth() + " and height=" + dimension.getHeight() + ".");
    }

    private static String getMessage(int x, int y) {
        return "Point2D (" + x + ", " + y + ") outside boundaries.";
    }
}
