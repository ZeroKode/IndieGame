package com.github.zerokode.coreengine.objects.room;

import com.github.zerokode.coreengine.objects.room.layers.Layer;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DungeonRoom extends Room {

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
    private DungeonRoom(String id, List<Layer> layers) {
        super(id, layers);
    }

    /**
     * A room with all 7 layers. All layers are the indicated size and will be empty.
     * @param id - unique id for this room (it could be a random UUID or any other value)
     * @param cellsTall - height in cells (each cell is 1 x 1 meters)
     * @param cellsWide - width in cells (each cell is 1 x 1 meters)
     */
    public static DungeonRoom createEmptyRoom(String id, int cellsWide, int cellsTall, int cellSizeInPixels) {
        List<Layer> layers = Stream.of(FLOOR, FLOOR_MARKS, WALLS, ROOM_OBJECTS, CHARACTERS, PARTICLES, SKY)
                .map(layerName -> new Layer(layerName, cellsWide, cellsTall, cellSizeInPixels))
                .collect(Collectors.toList());
        return new DungeonRoom(id, layers);
    }

}
