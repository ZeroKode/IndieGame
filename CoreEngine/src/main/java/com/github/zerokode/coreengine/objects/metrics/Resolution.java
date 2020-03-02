package com.github.zerokode.coreengine.objects.metrics;

public class Resolution extends Dimension {

    /**
     * A resolution is a 2D dimension defined in pixels.
     * @param width - in pixels
     * @param height - in pixels
     */
    public Resolution(int width, int height){
        super(width, height);
    }

    public void toggle() {
        final int height = this.getHeight();
        this.setHeight(this.getWidth());
        this.setWidth(height);
    }
}
