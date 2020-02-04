package com.github.zerokode.objects.attributes;

import com.github.zerokode.objects.GameObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Spawner extends Attribute {

    private GameObject spawnedObject;

}
