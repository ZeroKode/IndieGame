package com.github.zerokode.coreengine.objects.location;

public interface Position {

    /**
     * Returns the position in millimeters that represents the lower left corner of this grid cell.
     *
     * @return
     */
    MillimetricPosition getMillimetricPositionAtOrigin();

    /**
     * Returns the position in millimeters that represents the center of this grid cell.
     * This is the same as the X,Y values returned by getMillimetricPositionAtOrigin plus 500mm each.
     *
     * @return
     */
    MillimetricPosition getMillimetricPositionAtCenter();

    /**
     * Throws an IllegalArgumentException when any of the X or Y values are negative.
     *
     * @param x - positive integer
     * @param y - positive integer
     */
    static void validate(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Negative values are not allowed, given values: (" + x + ", " + y + ").");
        }
    }

}
