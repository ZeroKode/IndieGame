package com.github.zerokode.coreengine.objects.room.layers;

import lombok.Getter;

@Getter
public class Layer extends Grid {

    private String layerName;

    public Layer(String layerName, int cellsWide, int cellsTall, int cellsSizeInPixels) {
        super(cellsWide, cellsTall, cellsSizeInPixels);
        this.layerName = layerName;
    }

}
