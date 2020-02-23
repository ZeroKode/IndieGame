package com.github.zerokode.objects.room.layers;

import lombok.Getter;

@Getter
public class Layer extends Grid {

    private String layerName;

    public Layer(String layerName, int cellsWide, int cellsTall) {
        super(cellsWide, cellsTall);
        this.layerName = layerName;
    }

}
