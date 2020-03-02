package com.github.zerokode.coreengine.objects;

import com.github.zerokode.coreengine.exceptions.OrientationNotAllowedException;
import com.github.zerokode.coreengine.objects.metrics.Orientation;
import com.github.zerokode.coreengine.objects.metrics.Resolution;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class Display {

    private Orientation orientation;
    private List<Orientation> allowedOrientations;
    private Resolution resolution;

    /**
     * Creates a display instance with 720p resolution and landscape orientation.
     */
    public Display(){
        super();
        this.orientation = Orientation.LANDSCAPE;
        this.allowedOrientations = Collections.singletonList(Orientation.LANDSCAPE);
        this.resolution = new Resolution(1280, 720);
    }

    /**
     * Creates a custom display instance.
     * @param width - device width in pixels
     * @param height - device height in pixels
     * @param defaultOrientation -
     */
    public Display(int width, int height, Orientation defaultOrientation){
        super();
        this.orientation = defaultOrientation;
        this.allowedOrientations = Collections.singletonList(defaultOrientation);
        this.resolution = new Resolution(1280, 720);
    }

    /**
     *
     * @param orientation - will be added to the white list
     */
    public void enable(Orientation orientation) {
        if (!allowedOrientations.contains(orientation)){
            allowedOrientations.add(orientation);
        }
    }

    /**
     *
     * @param orientation - will be removed from the white list
     */
    public void disable(Orientation orientation) {
        if (!allowedOrientations.isEmpty()){
            allowedOrientations.remove(orientation);
        }
    }

    /**
     * Flips the screen from the current orientation to the given one.
     * @param orientation - the new desired screen orientation
     * @throws OrientationNotAllowedException when not present in the list of allowed orientations
     */
    public synchronized void flip(Orientation orientation) throws OrientationNotAllowedException {
        if (this.orientation == orientation) {
            return; // nothing to do
        }
        if (!this.allowedOrientations.contains(orientation)){
            throw new OrientationNotAllowedException(orientation);
        }
        if (this.orientation.isInvertedOf(orientation)){
            this.orientation = orientation; // no need to modify the resolution values
        } else {
            this.orientation = orientation;
            this.resolution.toggle(); // switches the width and height values
        }
    }

}