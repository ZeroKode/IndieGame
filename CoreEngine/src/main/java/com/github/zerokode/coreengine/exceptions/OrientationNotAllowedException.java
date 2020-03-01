package com.github.zerokode.coreengine.exceptions;

import com.github.zerokode.coreengine.objects.location.Orientation;

public class OrientationNotAllowedException extends Exception {

    public OrientationNotAllowedException(Orientation orientation) {
        super("Screen orientation not allowed: " + orientation.getName());
    }

}
