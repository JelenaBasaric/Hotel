package serviceImpl;

import domain.Employee;
import domain.Role;
import domain.UserProfile;
import java.util.List;
import repository.GenericRepository;
import repositoryImpl.EmployeeRepositoryImpl;
import repositoryImpl.RoleRepositoryImpl;
import repositoryImpl.UserProfileRepositoryImpl;
import genericService.UserProfileService;

/**
 *
 * @author Jelena Basaric
 */
public class UserProfileServiceImpl implements UserProfileService{

   /*@Override
    public List getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Object entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/
     private final GenericRepository<UserProfile, String> userProfileRepository;
    private final GenericRepository<Employee,Integer> employeeRepository;
    private final GenericRepository<Role,Integer> roleRepository;

    public UserProfileServiceImpl() {
        userProfileRepository = new UserProfileRepositoryImpl();
        employeeRepository = new EmployeeRepositoryImpl();
        roleRepository = new RoleRepositoryImpl();
    }
    
   // @Override
    public UserProfile login(String email, String password) throws Exception {
        String query = "SELECT * FROM userProfile WHERE email ='" + email+"' AND password = '" + password+"'";
        List<UserProfile> profiles =  userProfileRepository.findByQuery(query);
        if (profiles.isEmpty()) throw new Exception("Korisnik ne postoji u sistemu!");
        UserProfile userProfile = profiles.get(0);
        Employee employee = employeeRepository.findById(userProfile.getEmployee().getEmployeeId());
        if (employee == null){
            throw  new Exception("Profil ne mogu da povezem sa Zaposlenim!!!");
        }
        userProfile.setEmployee(employee);
        
        //za profil mi vrati sve role koje ima taj korisnicki profil
        query = "SELECT r.RoleId as RoleId, r.RoleTitle as RoleTitle FROM Role r JOIN userProfileRole upr ON r.RoleId = upr.RoleId WHERE upr.email = '" + userProfile.getEmail()+"'";
        try{
            List<Role> roles = roleRepository.findByQuery(query);
        
           userProfile.setRoles(roles);
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }
        return userProfile;
    }

   
}
    

