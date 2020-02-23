package com.github.zerokode.coreengine.objects.location;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * Each cell in the grid represents a 1 meter by 1 meter block, and within each block there
 * are 1000 steps in each direction. Thus, each step represents 1 millimeter.
 * <p>
 * If a room is 10 by 10 cells large, 10x10 meters, then lower left corner of this room is at (0mm,0mm)
 * and the top right corner is at (10,000mm, 10,000mm).
 * <p>
 * A millimetric position is intended to be used for objects that can freely move around a room.
 */
@Slf4j
@Getter
public class MillimetricPosition implements Position {

    int x;
    int y;

    private MillimetricPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MillimetricPosition addX(int millimeters) {
        int newXPosition = this.x + millimeters;
        if (newXPosition < 0) {
            log.warn("Attempting to move object behind X origin.");
            newXPosition = 0;
        }
        this.x = newXPosition;
        return this;
    }

    public MillimetricPosition addY(int millimeters) {
        int newYPosition = this.y + millimeters;
        if (newYPosition < 0) {
            log.warn("Attempting to move object behind Y origin.");
            newYPosition = 0;
        }
        this.y = newYPosition;
        return this;
    }

    /**
     * X and Y represent the point of origin (lower left corner).
     *
     * @param x - value in millimeters, positive number
     * @param y - value in millimeters, positive number
     * @return
     */
    public static MillimetricPosition create(int x, int y) {
        Position.validate(x, y);
        return new MillimetricPosition(x, y);
    }

    @Override
    public MillimetricPosition getMillimetricPositionAtOrigin() {
        return this;
    }

    @Override
    public MillimetricPosition getMillimetricPositionAtCenter() {
        return new MillimetricPosition(x+500, y+500);
    }
}
