package com.github.zerokode.coreengine.objects;

import com.github.zerokode.coreengine.objects.metrics.Point2D;
import com.github.zerokode.coreengine.objects.metrics.Resolution;
import lombok.Data;

@Data
public class ViewPort {

    private Resolution resolution; // at max it can be the same size as the display, but not larger
    private Point2D position; // position in the world

}
