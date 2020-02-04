package com.github.zerokode.exceptions;

public class LayerNotFoundException extends Exception {

    public LayerNotFoundException(String layerName){
        super("Layer with name '"+layerName+"' not found.");
    }

}
