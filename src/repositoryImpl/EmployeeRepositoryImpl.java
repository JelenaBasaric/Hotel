package repositoryImpl;

import db.connection.DatabaseConnection;
import java.sql.Statement;
import domain.City;
import domain.Country;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import repository.GenericRepository;
import domain.Employee;
import domain.GenderEnum;
import domain.Hotel;
import domain.Person;
import domain.Role;
import java.math.BigDecimal;
import java.sql.SQLException;

/**
 *
 * @author Jelena Basaric
 */
public class EmployeeRepositoryImpl implements GenericRepository<Employee, Integer> {

    @Override
    public Employee findById(Integer id) {
        try {

            Connection connection = DatabaseConnection.getInstance().getConnection();

            String query = "SELECT `EmployeeId`as id,`FirstName`,`LastName`,`RoleId`,`DateOfBirth`,`Gender`,`PhoneNo`,`Email`,`Salary`,`Address`,e.`CityZipCode` as zipcode,`CityName`,`CountryName`\n"
                    + "FROM employee AS e INNER JOIN city AS c ON e.cityzipcode=c.zipcode INNER JOIN country AS co ON c.countryid=co.countryId where EmployeeId=?";
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Integer emplId=rs.getInt("id");
                String firstname = rs.getString("FirstName");
                String lastname = rs.getString("LastName");
                int role = rs.getInt("roleId");
                Date dateofBirth = rs.getDate("DateOfBirth");
                LocalDate date = Instant.ofEpochMilli(dateofBirth.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                GenderEnum gender=GenderEnum.valueOf(rs.getString("Gender"));
                String phoneNo=rs.getString("PhoneNo");
                String email=rs.getString("email");
                BigDecimal salary=rs.getBigDecimal("salary");
                String address=rs.getString("Address");
                long zipCode=rs.getLong("zipcode");
                String cityName=rs.getString("CityName");
                String countryName=rs.getString("CountryName");
                
                City city = new City();
                city.setZipCode(zipCode);
                city.setCityName(cityName);
                Country country=new Country();
                country.setCountryName(countryName);
                Role r=new Role();
                r.setId(role);
                Employee e = new Employee(id, salary, firstname, lastname, gender, address, city, phoneNo, email, date,r);
               // employees.add(e);
                return e;
            } else {
                throw new Exception("Ne postoji zaposleni sa tim ID/jem!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Employee> getAll() throws Exception {
        try {
            List<Employee> employees = new ArrayList<>();
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT `EmployeeId`as id,`FirstName`,`LastName`,`RoleId`,`DateOfBirth`,`Gender`,`PhoneNo`,`Email`,`Salary`,`Address`,e.`CityZipCode` as zipcode,`CityName`,`CountryName`\n"
                    + "FROM employee AS e INNER JOIN city AS c ON e.cityzipcode=c.zipcode INNER JOIN country AS co ON c.countryid=co.countryId";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                //procitaj vrednost iz tabele
                Integer id = rs.getInt("id");
                String firstname = rs.getString("FirstName");
                String lastname = rs.getString("LastName");
                int role = rs.getInt("roleId");
                Date dateofBirth = rs.getDate("DateOfBirth");
                LocalDate date = Instant.ofEpochMilli(dateofBirth.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                GenderEnum gender=GenderEnum.valueOf(rs.getString("Gender"));
                String phoneNo=rs.getString("PhoneNo");
                String email=rs.getString("email");
                BigDecimal salary=rs.getBigDecimal("salary");
                String address=rs.getString("Address");
                long zipCode=rs.getLong("zipcode");
                String cityName=rs.getString("CityName");
                String countryName=rs.getString("CountryName");
                
                City city = new City();
                city.setZipCode(zipCode);
                city.setCityName(cityName);
                Country country=new Country();
                country.setCountryName(countryName);
                Role r=new Role();
                r.setId(role);
                Employee e = new Employee(id, salary, firstname, lastname, gender, address, city, phoneNo, email, date,r);
                employees.add(e);
            }
            rs.close();
            statement.close();
            // vrati listu
            return employees;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Greska u employee repository");
        }
    }

    @Override
    public List<Employee> findByQuery(String query) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Employee e) throws Exception {

        Connection connection = DatabaseConnection.getInstance().getConnection();
        String query = " INSERT INTO employee (`HotelId`,`RoleId`,`FirstName`,`Gender`,`LastName`,`PhoneNo`,`Email`,`Salary`,`Address`,`CityZipCode`,`DateOfBirth`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        Hotel h=Hotel.getIstance();
        preparedStatement.setInt(1, h.getId());
        preparedStatement.setInt(2, e.getRole().getId());
        preparedStatement.setString(3, e.getFirstName());
        preparedStatement.setString(4, e.getGender().toString());
        preparedStatement.setString(5, e.getLastName());
        preparedStatement.setString(6, e.getPhoneNumber());
        preparedStatement.setString(7, e.getEmail());
        preparedStatement.setBigDecimal(8, e.getSalary());
        preparedStatement.setString(9, e.getAddress());
        preparedStatement.setLong(10, e.getCity().getZipCode());        
        preparedStatement.setDate(11, java.sql.Date.valueOf(e.getDateOfBirth()));
        preparedStatement.executeUpdate();

        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            e.setEmployeeId(rs.getInt(1));

        }
        preparedStatement.close();

    }

    @Override
    public void update(Employee e) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String query = "UPDATE  employee SET firstname=?,lastname=?,birthdate=?,birthday_city_zip_code=? where id=?";

        java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, e.getFirstName());
        preparedStatement.setString(2, e.getLastName());
//        preparedStatement.setDate(3, java.sql.Date.valueOf(e.getBirthday()));
//        // preparedStatement.setString(4, e.getGender().toString());
//        preparedStatement.setLong(4, e.getBirthplace().getZipCode());
//        preparedStatement.setInt(5, e.getEmployeeId());

        preparedStatement.executeUpdate();

        preparedStatement.close();

    }

 

}
