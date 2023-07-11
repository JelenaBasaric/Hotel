package repositoryImpl;

import db.connection.DatabaseConnection;
import domain.City;
import domain.Country;
import domain.GenderEnum;
import domain.Guest;
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

/**
 *
 * @author Jelena Basaric
 */
public class GuestRepositoryImpl implements GenericRepository<Guest, Integer> {

    @Override
    public List<Guest> getAll() throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String query = "SELECT guestId as id,firstName, lastName,Gender,phoneNo,Email, PassportNo, CityZipCode,Address,CountryId FROM Guest g join CITY c on g.cityzipcode=c.zipcode ORDER BY lastName";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        List<Guest> guests = new ArrayList<Guest>();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            GenderEnum gender = GenderEnum.valueOf(rs.getString("gender"));
            String phoneNo = rs.getString("phoneNo");
            String email = rs.getString("email");
            String passportNo = rs.getString("passportNo");
            long cityZipCode = rs.getLong("cityZipCode");
            int countryId = rs.getInt("countryId");
            String address = rs.getString("address");
            Country country = new Country();
            country.setCountryId(countryId);
           Date dateofBirth = rs.getDate("DateOfBirth");
                LocalDate dob = Instant.ofEpochMilli(dateofBirth.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            City city = new City();
            city.setZipCode(cityZipCode);
            Guest guest = new Guest(id, passportNo, null, firstname, lastname, gender, address, city, phoneNo, email, dob);
            guests.add(guest);
        }
        rs.close();
        statement.close();
        return guests;
    }

    @Override
    public List<Guest> findByQuery(String query) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Guest g) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String query = "INSERT  INTO Guest (firstName, lastName,Gender,phoneNo,Email, PassportNo, CityZipCode,Address,DateOfBirth) VALUES(?,?,?,?,?,?,?,?,?) ";
        java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, g.getFirstName());
        preparedStatement.setString(2, g.getLastName());
        preparedStatement.setString(3, g.getGender().toString());
        preparedStatement.setString(4, g.getPhoneNumber());
        preparedStatement.setString(5, g.getEmail());
        preparedStatement.setString(6, g.getPassportNo());
        preparedStatement.setLong(7, g.getCity().getZipCode());
        preparedStatement.setString(8, g.getAddress());
        preparedStatement.setDate(9, java.sql.Date.valueOf(g.getDateOfBirth()));
        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            g.setGuestId(rs.getInt(1));
        }
        preparedStatement.close();
    }

    @Override
    public Guest findById(Integer id) {
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT guestId as id,firstName, lastName,Gender,phoneNo,Email, PassportNo, CityZipCode,Address FROM Guest where guestId=?";
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                GenderEnum gender = GenderEnum.valueOf(rs.getString("gender"));
                String phoneNo = rs.getString("phoneNo");
                String email = rs.getString("email");
                String passportNo = rs.getString("passportNo");
                long cityZipCode = rs.getLong("cityZupCode");
                City city = new City();
                city.setZipCode(cityZipCode);
                String address = rs.getString("address");
                Date dateofBirth = rs.getDate("DateOfBirth");
                LocalDate dob = Instant.ofEpochMilli(dateofBirth.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                Guest guest = new Guest(0, passportNo, null, firstname, lastname, gender, address, city, phoneNo, email, dob);
                return guest;
            } else {
                throw new Exception("Ne postoji gost sa tim ID/jem!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Guest guest) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String query = "UPDATE guest g SET g.RegistrationId=(SELECT r.RegistrationId FROM registration r\n"
                + "  WHERE r.roomNo=?)";
        java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, guest.getRegistration().getRoom().getRoomNo());
        preparedStatement.executeUpdate();
        preparedStatement.close();
        System.out.println("Dodata je  registracija gostu");
    }

  

}
