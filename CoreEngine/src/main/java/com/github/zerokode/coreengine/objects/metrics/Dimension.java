package com.github.zerokode.coreengine.objects.metrics;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class Dimension {

    private int width; // in pixels
    private int height; // in pixels

    public Dimension(int width, int height) {
        validate(width, height);
        this.width = width;
        this.height = height;
    }

    private void validate(int width, int height){
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Both width and height should be greater than zero.");
        }
    }

    /**
     * Verifies if the given point fits into the 2D plane's boundaries.
     *
     * @param point - a point in a 2D plane
     * @return false when the point falls outside of the boundaries of this 2D plane.
     */
    public boolean canContain(@NonNull Point2D point) {
        return point.getX() <= (getWidth() - 1) && point.getY() <= (getHeight() - 1);
    }
}
