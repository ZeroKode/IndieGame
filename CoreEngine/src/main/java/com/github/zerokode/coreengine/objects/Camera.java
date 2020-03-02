package com.github.zerokode.coreengine.objects;

import lombok.Data;

@Data
public class Camera {

    Display targetDisplay;
    ViewPort viewPort;
    int fieldOfView = 100;

}
