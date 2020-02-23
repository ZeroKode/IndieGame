package com.github.zerokode.coreengine.objects.room.doors;

import com.github.zerokode.coreengine.objects.GameObject;
import com.github.zerokode.coreengine.objects.room.Room;
import lombok.Data;

/**
 * A door connects two different rooms together.
 */
@Data
public abstract class Door extends GameObject {
    final Room roomA;
    final Room roomB;

    boolean closed; // defines whether or not the player can go thru and how the door is drawn as well.
    boolean locked; // it requires a key or an event to be unlocked.
}
