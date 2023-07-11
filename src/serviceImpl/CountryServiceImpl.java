package serviceImpl;

import domain.Country;
import domain.UserProfile;
import java.util.List;
import repositoryImpl.CountryRepositoryImpl;

/**
 *
 * @author Jelena Basaric
 */
public class CountryServiceImpl implements genericService.GenericService<Country,Integer>{

    private final CountryRepositoryImpl countryRepository;

    public CountryServiceImpl() {
        countryRepository = new CountryRepositoryImpl();
    }
    
    @Override
    public List<Country> getAll() throws Exception {
        return countryRepository.getAll();
    }

    @Override
    public void add(Country country) throws Exception {
        String query = "SELECT * FROM Country WHERE countryId = '" + country.getCountryId()+"'";
        List<Country> countries = countryRepository.findByQuery(query);
        if (countries.isEmpty()){
            countryRepository.add(country);
        }else{
            throw new Exception("Drzava sa tim imenom vec postoji!");
        }
        /*
        List<Country> countries = countryRepository.getAll();
        for (Country c : countries) {
            if (c.getName().equals(country.getName())){
                throw new Exception("Drzava sa tim imenom postoji!");
            }
        }*/
        
        
        
    }

    @Override
    public void saveOrUpdate(Country t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Country findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Country entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
