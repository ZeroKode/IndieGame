package com.github.zerokode.coreengine.objects.attributes;

import com.github.zerokode.coreengine.objects.GameObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Spawner extends Attribute {

    private GameObject spawnedObject;

}
