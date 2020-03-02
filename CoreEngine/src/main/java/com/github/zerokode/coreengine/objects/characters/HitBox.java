package com.github.zerokode.coreengine.objects.characters;

import com.github.zerokode.coreengine.objects.metrics.Dimension;
import com.github.zerokode.coreengine.objects.metrics.Point2D;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HitBox {

    private Dimension dimension;
    private Point2D position;
    private boolean active; // can become false for a short time after being hit, for example.

}
