package com.github.zerokode.coreengine.objects;

import com.github.zerokode.objects.location.Position;
import lombok.Data;

@Data
public class Camera {

    Display targetDisplay;
    Position position;
    ViewPort viewPort;
    int fieldOfView = 100;

}
