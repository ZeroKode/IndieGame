package com.github.zerokode.coreengine.objects.room.layers;

import com.github.zerokode.coreengine.exceptions.PointOutOfBoundsException;
import com.github.zerokode.coreengine.objects.GameObject;
import com.github.zerokode.coreengine.objects.metrics.Point2D;
import com.google.common.collect.Multimap;
import lombok.extern.slf4j.Slf4j;

/**
 * A grid is a container of GameObjects. It represents a 2D area with a number of cells.
 * Each room will have multiple layers, and each layer is a grid with additional features.
 * <p>
 * The grid has logic that prevents placing or moving objects outside of it's boundaries. However
 * it doesn't prevent adding objects outside of a walkable path or to prevent collisions.
 * It's the Room the one that calculates that based on the information it has about all the layers.
 * <p>
 * Hierarchy: Room > Layers > Grid
 */
@Slf4j
public class Grid {

    Multimap<Point2D, GameObject> objects;
    private int cellsWide;
    private int cellsTall;
    private int cellSizeInPixels;

    /**
     * A grid is a 2D plane that is certain cells wide/tall, where each cell is a square of a given size (in pixels).
     *
     * @param cellsWide        - number of squares in the x axis
     * @param cellsTall        - number of squares in the y axis
     * @param cellSizeInPixels - number of pixels in both width and height for each cell in the grid.
     */
    public Grid(int cellsWide, int cellsTall, int cellSizeInPixels) {
        this.cellsWide = cellsWide;
        this.cellsTall = cellsTall;
        this.cellSizeInPixels = cellSizeInPixels;
    }

    /**
     * Places a single object in a cell of the grid. Only one object can be added to each cell.
     * If you want to place an object on top of another then try placing it in a different layer.
     *
     * @param gameObject - the object to be placed
     * @param position   - the position in which it will be located (an x,y coordinate, not in pixels)
     */
    public void place(GameObject gameObject, GridPosition position) throws PointOutOfBoundsException {
        if (isWithinBoundaries(position, gameObject.getWidth(), gameObject.getHeight())) {
            Point2D point = position.asPoint(cellSizeInPixels);
            objects.put(point, gameObject);
        } else {
            throw new PointOutOfBoundsException(position.asPoint(cellSizeInPixels));
        }
    }

    /**
     * Places a single object in a cell of the grid. Only one object can be added to each cell.
     * If you want to place an object on top of another then try placing it in a different layer.
     *
     * @param gameObject - the object to be placed
     * @param position   - the position in which it will be located (an x,y coordinate, not in pixels)
     */
    public void place(GameObject gameObject, Point2D position) throws PointOutOfBoundsException {
        if (isWithinBoundaries(position, gameObject.getWidth(), gameObject.getHeight())) {
            objects.put(position, gameObject);
        } else {
            throw new PointOutOfBoundsException(position);
        }
    }

    /**
     * Calculates if an object that has certain size fits within the grid when placed at certain grid cell.
     *
     * @param position     - an (x, y) coordinate where (0,0) is the cell at the origin.
     * @param objectWidth  - the object's width in pixels.
     * @param objectHeight - the object's height in pixels.
     * @return true when the object fits, false otherwise
     */
    public boolean isWithinBoundaries(GridPosition position, int objectWidth, int objectHeight) throws PointOutOfBoundsException {
        Point2D point = position.asPoint(cellSizeInPixels);
        return isWithinBoundaries(point, objectWidth, objectHeight);
    }

    /**
     * Calculates if an object that has certain size fits within the grid when placed at certain position (in pixels).
     *
     * @param position     - in pixels
     * @param objectWidth  - the object's width in pixels.
     * @param objectHeight - the object's height in pixels.
     * @return true when the object fits, false otherwise
     */
    public boolean isWithinBoundaries(Point2D position, int objectWidth, int objectHeight) {
        return (position.getX() + objectWidth) <= getMaxWidthInPixels()
                && (position.getY() + objectHeight) <= getMaxHeightInPixels();
    }

    public int getMaxWidthInPixels() {
        return (this.cellsWide * cellSizeInPixels) + cellSizeInPixels;
    }

    public int getMaxHeightInPixels() {
        return (this.cellsTall * cellSizeInPixels) + cellSizeInPixels;
    }

}
