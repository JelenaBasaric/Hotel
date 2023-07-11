package serviceImpl;

import domain.City;
import domain.UserProfile;
import java.util.List;
import repositoryImpl.CityRepositoryImpl;

/**
 *
 * @author Jelena Basaric
 */
public class CityServiceImpl implements genericService.GenericService<City,Long>{

    private final CityRepositoryImpl cityRepository;

    public CityServiceImpl() {
        cityRepository = new CityRepositoryImpl();
    }
    
    @Override
    public List<City> getAll() throws Exception {
        return cityRepository.getAll();
    }

    @Override
    public void add(City city) throws Exception {
        //ToDo validacija: NE MOGU DA IMAM DVA GRADA SA ISTM PTT BROJEM U JEDNOJ DRZAVI
        String query ="SELECT city.zipcode, cityName AS city_name, city.countryId, countryName AS country_name, countryShortName AS shortName FROM city INNER JOIN country ON city.countryId = country.countryId WHERE zipCode = " + city.getZipCode() +" AND country.countryId = " + city.getCountry().getCountryId();
        
        System.out.println(query);
        List<City> cities = cityRepository.findByQuery(query);
        if (!cities.isEmpty()) throw new Exception("Grad sa tim PTTbrojem vec postoji u DRZAVI!");
        
        cityRepository.add(city);
    }

    @Override
    public void saveOrUpdate(City t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public City findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(City entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
