package roomTypeSelection;

import domain.Room;
import domain.RoomType;

/**
 *
 * @author Jelena Basaric
 */
public interface RoomTypeSelection {
    void addBed(RoomType roomType);
    void returnDefault(RoomType roomType);
    void returnRoomType(RoomType roomType);
}
