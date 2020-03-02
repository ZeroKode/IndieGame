package com.github.zerokode.coreengine.objects.room.doors;

import com.github.zerokode.coreengine.objects.GameObject;
import com.github.zerokode.coreengine.objects.room.Room;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * A door connects two different rooms together.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Door extends GameObject {

    private Room roomA;
    private Room roomB;

    boolean closed; // defines whether or not the player can go thru and how the door is drawn as well.
    boolean locked; // it requires a key or an event to be unlocked.

    /**
     * @param fromRoom - the current room
     * @return the room at the other side of the door.
     */
    public Room getNextRoom(Room fromRoom) {
        if (!roomA.equals(fromRoom) && !roomB.equals(fromRoom)) {
            throw new IllegalArgumentException("The given room is not a room connected by this door.");
        }
        return roomA.equals(fromRoom) ? roomB : roomA;
    }

    /**
     * @param fromRoomId - the id current room
     * @return the room at the other side of the door.
     */
    public Room getNextRoom(String fromRoomId) {
        if (!roomA.getId().equals(fromRoomId) && !roomB.getId().equals(fromRoomId)) {
            throw new IllegalArgumentException("The given room is not a room connected by this door.");
        }
        return roomA.getId().equals(fromRoomId) ? roomB : roomA;
    }
}
