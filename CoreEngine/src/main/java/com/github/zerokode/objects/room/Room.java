package com.github.zerokode.objects.room;

import com.github.zerokode.exceptions.LayerNotFoundException;
import com.github.zerokode.objects.room.layers.Layer;
import lombok.Getter;

import java.util.List;

/**
 * A room has multiple layers, each one containing multiple objects.
 * <p>
 * The layer with the lower index zero will be the background while layers with a greater index
 * will be closer to the foreground.
 */
@Getter
public abstract class Room {

    private List<Layer> layers;

    public Room(List<Layer> layers) {
        this.layers = layers;
    }

    /**
     * Finds a layer by name.
     * @param layerName - case sensitive
     * @return the layer that has the given name.
     * @throws LayerNotFoundException when none has been found.
     */
    public Layer getByName(String layerName) throws LayerNotFoundException {
        return layers.stream().filter(l -> l.getLayerName().equals(layerName)).findFirst()
                .orElseThrow(() -> new LayerNotFoundException(layerName));
    }

}
