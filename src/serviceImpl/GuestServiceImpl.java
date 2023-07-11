package serviceImpl;

import domain.City;
import domain.Country;
import domain.Employee;
import domain.Guest;
import genericService.GuestService;
import java.util.List;
import repository.GenericRepository;
import repositoryImpl.CityRepositoryImpl;
import repositoryImpl.CountryRepositoryImpl;
import repositoryImpl.GuestRepositoryImpl;

/**
 *
 * @author Jelena Basaric
 */
public class GuestServiceImpl implements GuestService {
    private GenericRepository<Guest, Integer> guestRepository;
    private GenericRepository<City, Long> cityRepository;
    private GenericRepository<Country,Integer> countryRepository;

    public GuestServiceImpl() {
        guestRepository = new GuestRepositoryImpl();
      cityRepository =new CityRepositoryImpl();
      countryRepository=new CountryRepositoryImpl();
    }
    

    @Override
    public void saveOrUpdate(Guest guest) throws Exception{
         if(guest.getGuestId()==0){        
        guestRepository.add(guest);
        }
        else {
            guestRepository.update(guest);
        }
    }

    @Override
    public List<Guest> getAll() throws Exception {
      try {
            
            List<Guest> guests = guestRepository.getAll();
            for (Guest g : guests) {
                Long zipCode = g.getCity().getZipCode();
                City city = cityRepository.findById(zipCode);
                g.setCity(city);
                
            }
            return guests;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }        
    }

    @Override
    public void update(Guest guest) throws Exception{
       guestRepository.update(guest);
    }

}
