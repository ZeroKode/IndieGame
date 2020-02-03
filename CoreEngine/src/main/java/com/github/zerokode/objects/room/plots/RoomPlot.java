package com.github.zerokode.objects.room.plots;

import com.github.zerokode.objects.room.RoomObject;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

/**
 * A 2D grid in which each cell/block is 1 meter by 1 meter.
 * The plot doesn't contain anything breakable, any characters, items, traps, lights or sounds. All
 * this things are added in the Room itself. This is just the foundations of the room, the blueprints.
 * <p>
 * Must contain walls (W), floors (F), pits (H) and doors (D).
 * <p>
 * WWWWWWWWWWW
 * WHFFFFFFFFW
 * DFFFFHHFFFD
 * WHFFFFFFFHW
 * WWWWDWWWWWW
 * <p>
 * Room's can also have irregular shapes, to do that just keep some cells null (-).
 * <p>
 * --WDWW---
 * --WFFW---
 * --WFFWWWW
 * --WFFFFFD
 * --WWWWWWW
 * <p>
 * <p>
 * The width of a room is defined by the number of columns in the grid, while the height
 * is defined by the number of rows. All plots should be rectangular, which means that all
 * rows should be the same length.
 */
@Getter
@Slf4j
public class RoomPlot {

    private final RoomObject[][] roomObjects;
    private final int width;
    private final int height;
    private final String uuid; // A random unique identifier generated at runtime

    /**
     * This method should remain package-protected.
     *
     * @param roomObjects
     * @param width
     * @param height
     */
    RoomPlot(RoomObject[][] roomObjects, int width, int height) {
        this.roomObjects = roomObjects;
        this.width = width;
        this.height = height;
        this.uuid = UUID.randomUUID().toString();
    }

}