package com.github.zerokode.coreengine.exceptions;

import com.github.zerokode.coreengine.objects.metrics.Orientation;

public class OrientationNotAllowedException extends Exception {

    public OrientationNotAllowedException(Orientation orientation) {
        super("Screen orientation not allowed: " + orientation.getName());
    }

}
