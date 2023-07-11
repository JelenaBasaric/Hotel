package genericService;

import java.util.List;
import domain.Employee;

/**
 *
 * @author Marko Dunda
 */
public interface EmployeeService {
     List<Employee> getAll();
     void saveOrUpdate(Employee employee) throws Exception;

     Employee findById(Long idEmployee);
    
}
