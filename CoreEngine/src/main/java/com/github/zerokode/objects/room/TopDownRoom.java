package com.github.zerokode.objects.room;

import com.github.zerokode.objects.room.layers.Layer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopDownRoom extends Room {

    public static final String FLOOR = "floor";
    public static final String FLOOR_MARKS = "floorMarks";
    public static final String WALLS = "walls";
    public static final String ROOM_OBJECTS = "roomObjects";
    public static final String CHARACTERS = "characters";
    public static final String PARTICLES = "particles";
    public static final String SKY = "sky";

    private static final List<String> layerNames = Arrays.asList(FLOOR, FLOOR_MARKS, WALLS,
            ROOM_OBJECTS, CHARACTERS, PARTICLES, SKY);

    private TopDownRoom(List<Layer> layers) {
        super(layers);
    }

    public static TopDownRoom create(int cellsWidth, int cellsHeight) {
        List<Layer> layers = new ArrayList<>();
        for (String layerName : layerNames) {
            layers.add(new Layer(layerName, cellsWidth, cellsHeight));
        }
        return new TopDownRoom(layers);
    }

}
