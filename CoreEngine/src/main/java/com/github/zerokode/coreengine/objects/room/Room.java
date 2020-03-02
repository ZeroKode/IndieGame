package com.github.zerokode.coreengine.objects.room;

import com.github.zerokode.coreengine.exceptions.LayerNotFoundException;
import com.github.zerokode.coreengine.objects.room.doors.Door;
import com.github.zerokode.coreengine.objects.room.layers.Layer;
import lombok.Getter;

import java.util.List;
import java.util.Set;

/**
 * A room has multiple layers, each one containing multiple objects.
 * <p>
 * The layer with the lower index zero will be the background while layers with a greater index
 * will be closer to the foreground.
 */
@Getter
public abstract class Room {

    private String id;
    private List<Layer> layers;
    private Set<Door> doors;

    public Room(String roomId, List<Layer> layers) {
        this.layers = layers;
        this.id = roomId;
    }

    /**
     * Finds a layer by name.
     *
     * @param layerName - case sensitive
     * @return the layer that has the given name.
     * @throws LayerNotFoundException when none has been found.
     */
    public Layer getByName(String layerName) throws LayerNotFoundException {
        return layers.stream().filter(l -> l.getLayerName().equals(layerName)).findFirst()
                .orElseThrow(() -> new LayerNotFoundException(layerName));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Room) {
            return this.getId().equalsIgnoreCase(((Room) obj).getId());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
