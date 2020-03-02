package com.github.zerokode.coreengine.objects.room.layers;

import com.github.zerokode.coreengine.exceptions.PointOutOfBoundsException;
import com.github.zerokode.coreengine.objects.metrics.Point2D;
import lombok.Getter;

@Getter
public class GridPosition {

    private int x;
    private int y;

    public GridPosition(int x, int y) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Both x and y should be positive numbers.");
        }
        this.x = x;
        this.y = y;
    }

    public int getXInPixels(int cellSizeInPixels) {
        return x * cellSizeInPixels;
    }

    public int getYInPixels(int cellSizeInPixels) {
        return y * cellSizeInPixels;
    }

    public Point2D asPoint(int cellSizeInPixels) throws PointOutOfBoundsException {
        return new Point2D(x * cellSizeInPixels, y * cellSizeInPixels);
    }
}
