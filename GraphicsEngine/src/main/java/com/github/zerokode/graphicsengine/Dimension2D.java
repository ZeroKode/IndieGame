package com.github.zerokode.graphicsengine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class Dimension2D {

    private final int width;
    private final int height;

    /**
     * Verifies if the given point fits into the 2D plane's boundaries.
     * @param point - a point in a 2D plane (in pixels)
     * @return false when the point falls outside of the boundaries of this 2D plane.
     */
    public boolean canContain(@NonNull Point2D point) {
        return point.getX() <= (width-1) && point.getY() <= (height-1);
    }
}
