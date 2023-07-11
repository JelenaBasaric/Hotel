package genericService;

import domain.Guest;
import domain.Registration;
import java.util.List;

/**
 *
 * @author Jelena Basaric
 */
public interface RegistrationService {
     void saveOrUpdate(Registration registration) throws Exception;
    List<Registration> getAll() throws Exception;
    
}
