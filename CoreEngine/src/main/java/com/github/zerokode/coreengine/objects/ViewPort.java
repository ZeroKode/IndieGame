package com.github.zerokode.coreengine.objects;

import lombok.Data;

@Data
public class ViewPort {

    private int width; // in pixels
    private int height; // in pixels

    private ViewPort() {
        super();
    }

    private ViewPort(int width, int height) {
        this();
        this.width = width;
        this.height = height;
    }

    /**
     * Creates a new camera view port.
     *
     * @param width  - in pixels
     * @param height - in pixels
     * @return a new instance with the dimensions provided
     */
    public static ViewPort create(int width, int height) {
        if (width < 1 || height < 1) {
            throw new IllegalArgumentException("Both width and height should be, at least, 1 pixel each.");
        }
        return new ViewPort(width, height);
    }

}
