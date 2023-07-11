package serviceImpl;

import domain.City;
import domain.Room;
import genericService.RoomService;
import java.util.List;
import repositoryImpl.RoomRepositpryImpl;

/**
 *
 * @author Jelena Basaric
 */
public class RoomServiceImpl implements RoomService {

     private final RoomRepositpryImpl roomRepositpry;
    public RoomServiceImpl() {
        this.roomRepositpry =new RoomRepositpryImpl();
    }
   

    @Override
    public List<Room> getAll() throws Exception {
        return roomRepositpry.getAll();
           }

    @Override
    public void update(Room room) throws Exception {
        this.roomRepositpry.update(room);
    }    
       
}
