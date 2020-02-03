package com.github.zerokode.objects.room.plots;

import com.github.zerokode.objects.room.RoomObject;

public class RoomPlotFactory {

    /**
     * Creates a RoomPlan that represents a room's blueprints from a grid of Room Objects.
     *
     * @param roomObjects
     * @return - a room plan instance
     */
    public static RoomPlot create(RoomObject[][] roomObjects) {
        if (roomObjects == null) {
            throw new IllegalArgumentException("Room objects matrix cannot be null.");
        }

        int width = calculateWidth(roomObjects);
        int height = calculateHeight(roomObjects);
        verifyPlotDimensions(width, height);
        return new RoomPlot(roomObjects, width, height);
    }

    private static int calculateWidth(RoomObject[][] roomObjects) {
        return roomObjects.length;
    }

    private static int calculateHeight(RoomObject[][] roomObjects) {
        verifyRowsLengthIsTheSame(roomObjects);
        return roomObjects[0].length;
    }

    /**
     * Throws an IllegalArgumentException when the plot is not at least 3x3.
     * The simplest playable map has 2 blocks for doors, 1 block of floor and walls around:
     * <p>
     * WDW
     * WFW
     * WDW
     * <p>
     * WWW
     * DFD
     * WWW
     *
     * @param width
     * @param height
     */
    private static void verifyPlotDimensions(int width, int height) {
        if (height < 3) {
            throw new IllegalArgumentException("Room objects matrix should be at least 3 blocks tall.");
        }
        if (width < 3) {
            throw new IllegalArgumentException("Room objects matrix should be at least 3 blocks wide.");
        }
    }

    /**
     * All rows must have the same length even if the room has an irregular shape.
     *
     * @param roomObjects
     */
    private static void verifyRowsLengthIsTheSame(RoomObject[][] roomObjects) {
        int pivotWidth = roomObjects[0].length;
        for (RoomObject[] row : roomObjects) {
            if (row == null) {
                throw new IllegalArgumentException("Found an entirely null row in plot.");
            }
            if (pivotWidth != row.length) {
                throw new IllegalArgumentException("Found a row in the plot with length " + row.length + " but " + pivotWidth + " was expected.");
            }
        }
    }

}

