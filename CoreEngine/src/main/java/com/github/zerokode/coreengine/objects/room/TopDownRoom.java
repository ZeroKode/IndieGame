package com.github.zerokode.coreengine.objects.room;

import com.github.zerokode.coreengine.objects.room.layers.Layer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TopDownRoom extends Room {

    public static final String FLOOR = "floor";
    public static final String FLOOR_MARKS = "floorMarks";
    public static final String WALLS = "walls";
    public static final String ROOM_OBJECTS = "roomObjects";
    public static final String CHARACTERS = "characters";
    public static final String PARTICLES = "particles";
    public static final String SKY = "sky";

    /**
     * Represents a room with a top-down perspective.
     * Use one of the factory methods available to create a new instance.
     * @param layers
     */
    private TopDownRoom(List<Layer> layers) {
        super(layers);
    }

    /**
     * A room with all 7 layers. All layers are the indicated size and will be empty.
     * @param cellsTall
     * @param cellsWide
     */
    public static TopDownRoom createEmptyRoom(int cellsWide, int cellsTall) {
        List<Layer> layers = Stream.of(FLOOR, FLOOR_MARKS, WALLS, ROOM_OBJECTS, CHARACTERS, PARTICLES, SKY)
                .map(layerName -> new Layer(layerName, cellsWide, cellsTall))
                .collect(Collectors.toList());
        return new TopDownRoom(layers);
    }

}
