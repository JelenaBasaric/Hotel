package serviceImpl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import domain.City;
import domain.Employee;
import domain.UserProfile;
import repository.GenericRepository;
import repositoryImpl.CityRepositoryImpl;
import repositoryImpl.EmployeeRepositoryImpl;
import genericService.GenericService;

/**
 *
  @author Jelena Basaric
 */
public class EmployeeServiceImpl implements genericService.GenericService<Employee,Integer> {
    
    private GenericRepository<Employee, Integer> employeeRepository;
    private GenericRepository<City, Long> cityRepository;
    
    public EmployeeServiceImpl() {
        employeeRepository = new EmployeeRepositoryImpl();
        cityRepository = new CityRepositoryImpl();
        
    }
    
    @Override
    public List<Employee> getAll() {
        try {
            
            List<Employee> employees = employeeRepository.getAll();
           /*for (Employee e : employees) {
                Long zipCode = e.getBirthplace().getZipCode();
                // daj mi sve podatke o gradu na osnovu zip koda
                City city = cityRepository.findById(zipCode);
                //e.setBirthplace(city);
            }*/
            return employees;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }        
    }

    @Override
    public void saveOrUpdate(Employee employee) throws Exception {
        if(employee.getEmployeeId()==0){        
        employeeRepository.add(employee);
        }
        else {
            employeeRepository.update(employee);
        }
    }

   

    @Override
    public void add(Employee entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Employee findById(Integer id) {
       return employeeRepository.findById(id);
    }

    @Override
    public void update(Employee entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}