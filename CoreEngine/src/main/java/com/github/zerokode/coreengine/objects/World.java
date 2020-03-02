package com.github.zerokode.coreengine.objects;

import com.github.zerokode.coreengine.objects.room.Room;
import lombok.Data;

import java.util.Set;

@Data
public class World {

    private String id;
    private Set<Room> rooms;

}
