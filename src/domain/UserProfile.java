package domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jelena Basaric
 */
public class UserProfile {
     private String email;
    private String password;
    private Employee employee;
    private List<Role> roles;

    public UserProfile() {
        roles = new ArrayList<>();
    }

    public UserProfile(String email, String password, Employee employee, List<Role> roles) {
        this.email = email;
        this.password = password;
        this.employee = employee;
        this.roles = roles;
    }

    public UserProfile(Employee employee) {
        this.employee = employee;
    }
    

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean isAdmin() {
        for (Role r: getRoles()){
            if (r.getTitle().equals("administrator")) return true;
        }
        return false;
    }
    
}
