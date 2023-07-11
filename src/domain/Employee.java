package domain;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Jelena Basaric
 */
public class Employee extends Person {
    private Person person;
    private Integer employeeId;
    private BigDecimal salary;
    private Role role;

    public Employee() {
    }

    public Employee( Integer employeeId, BigDecimal salary, String firstName, String lastName, GenderEnum gender, String address, City city, String phoneNumber, String email, LocalDate dateOfBirth, Role role) {
        super(firstName, lastName, gender, address, city, phoneNumber, email, dateOfBirth);
        this.employeeId = employeeId;
        this.salary = salary;
        this.role=role;
    }

    public Employee(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    

   

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" + "person=" + person + ", employeeId=" + employeeId + ", salary=" + salary + '}';
    }
    

    
    
    
}
