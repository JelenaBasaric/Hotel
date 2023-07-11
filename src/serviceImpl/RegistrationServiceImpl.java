package serviceImpl;

import domain.Registration;
import genericService.RegistrationService;
import java.util.List;
import repository.GenericRepository;
import repositoryImpl.RegistrationRepositoryImpl;

/**
 *
 * @author Jelena Basaric
 */
public class RegistrationServiceImpl implements RegistrationService {
    private GenericRepository registrationRepository;

    public RegistrationServiceImpl() {
        registrationRepository =new RegistrationRepositoryImpl();
    }
    

    @Override
    public void saveOrUpdate(Registration registration) throws Exception {
        registrationRepository.add(registration);
        //registration.getRoom().setOccupancy(false);
        
        
    }

    @Override
    public List<Registration> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
