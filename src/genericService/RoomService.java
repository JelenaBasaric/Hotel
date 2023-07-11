package genericService;

import domain.Employee;
import domain.Guest;
import domain.Room;
import java.util.List;

/**
 *
 * @author Jelena Basaric
 */
public interface RoomService {
    List<Room> getAll() throws Exception;
   void update(Room room) throws Exception;
}
