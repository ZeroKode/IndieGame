package com.github.zerokode.objects.location;

import lombok.Getter;

/**
 * A grid position uses integer numbers starting from (0,0) to (X-1, Y-1), where X is the numbers of blocks
 * in the horizontal axis and Y is the number of blocks in the vertical axis.
 * <p>
 * The Pivot Point is the lower left corner of a room.
 */
@Getter
public class GridPosition implements Position {

    private int x;
    private int y;

    private GridPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the position in millimeters that represents the lower left corner of this grid cell.
     *
     * @return
     */
    public MillimetricPosition getMillimetricPositionAtOrigin() {
        return MillimetricPosition.create(x * 1000, y * 1000);
    }

    /**
     * Returns the position in millimeters that represents the center of this grid cell.
     * This is the same as the X,Y values returned by getMillimetricPositionAtOrigin plus 500mm each.
     *
     * @return
     */
    public MillimetricPosition getMillimetricPositionAtCenter() {
        return getMillimetricPositionAtOrigin().addX(500).addY(500);
    }

    /**
     * Can be used to snap an object to one of the cells in the grid of a room.
     * Walking objects will use this as their spawn point while non-movable objects will remain in this position.
     *
     * @param x - horizontal position number, origin at the left border.
     * @param y - vertical position number, origin at the bottom.
     * @return
     */
    public static GridPosition create(int x, int y) {
        Position.validate(x, y);
        return new GridPosition(x, y);
    }

}
