package com.github.zerokode.objects.room.layers;

import com.github.zerokode.objects.GameObject;
import com.github.zerokode.objects.location.MillimetricPosition;
import com.github.zerokode.objects.location.Position;

import java.util.HashMap;

/**
 * A grid is a container of GameObjects. It represents a 2D area with a number of cells.
 * Each room will have multiple layers, and each layer is a grid with additional features.
 *
 * The grid has logic that prevents placing or moving objects outside of it's boundaries. However
 * it doesn't prevent adding objects outside of a walkable path or to prevent collisions.
 * It's the Room the one that calculates that based on the information it has about all the layers.
 *
 * Hierarchy: Room > Layers > Grid
 */
public class Grid {

    HashMap<String, GameObject> objects;
    private int cellsWide;
    private int cellsTall;

    /**
     * A grid is a 2D plane that is certain cells wide/tall, where each cell is 1x1 meters.
     * @param cellsWide - number of squares, not in millimeters
     * @param cellsTall - number of squares, not in millimeters
     */
    public Grid(int cellsWide, int cellsTall) {
        this.cellsWide = cellsWide;
        this.cellsTall = cellsTall;
    }

    /**
     *
     * @param gameObject
     * @param position
     */
    public void place(GameObject gameObject, Position position) {
        if (isWithinBoundaries(position, gameObject.getWidthInMm(), gameObject.getHeightInMm())){

        }
    }

    /**
     * Calculates if an object that has certain size fits within the grid when placed at certain position.
     * @param position - it could be a grid position or a position in millimeters.
     * @param objectWidthMm - the width of the object in millimeters.
     * @param objectHeightMm - the height in millimeters.
     * @return
     */
    public boolean isWithinBoundaries(Position position, int objectWidthMm, int objectHeightMm){
        final MillimetricPosition origin = position.getMillimetricPositionAtOrigin();
        return (origin.getX() + objectWidthMm) <= getMaxWidthInMillimeters()
                && (origin.getY() + objectHeightMm) <= getMaxHeightInMillimeters();
    }

    public int getMaxWidthInMillimeters(){
        return (this.cellsWide * 1000) + 1000;
    }

    public int getMaxHeightInMillimeters(){
        return (this.cellsTall * 1000) + 1000;
    }

}
