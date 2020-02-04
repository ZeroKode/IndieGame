package com.github.zerokode.objects.room;

import com.github.zerokode.objects.room.layers.Layer;

/**
 * A room seen in top-down perspective. The list of layers are predefined for this type of room, that way we can
 * implement some the possible interactions between the elements present in each layer.
 */
public class Room {

    private Layer floor;
    private Layer floorMarks;
    private Layer walls;
    private Layer roomObjects;
    private Layer characters;
    private Layer particles;
    private Layer sky;

}
