package genericService;

import domain.Guest;
import java.util.List;

/**
 *
 * @author Jelena Basaric
 */
public interface GuestService {
    void saveOrUpdate(Guest guest) throws Exception;
    List<Guest> getAll() throws Exception;

    public void update(Guest guest)throws Exception;
    
}
