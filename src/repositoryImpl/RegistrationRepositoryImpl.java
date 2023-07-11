package repositoryImpl;

import db.connection.DatabaseConnection;
import domain.Hotel;
import domain.Registration;
import domain.Room;
import domain.RoomType;
import domain.RoomTypeEnum;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import repository.GenericRepository;

/**
 *
 * @author Jelena Basaric
 */
public class RegistrationRepositoryImpl implements GenericRepository<Registration, Long> {

    @Override
    public List<Registration> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Registration> findByQuery(String query) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void add(Registration r) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        String query = "INSERT INTO registration(`HotelId`,`GuestId`,`RoomNo`,`RegistrationDate`,`DepartureDate`,`EstDepartureDate`,`NumAdults`,`NumChildren`,`SpecReq`) VALUES (?,?,?,?,?,?,?,?,?)";

        java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setInt(1, r.getHotel().getId());
        preparedStatement.setInt(2, r.getGuest().getGuestId());
        preparedStatement.setInt(3, r.getRoom().getRoomNo());
        preparedStatement.setDate(4, java.sql.Date.valueOf(r.getRegistrationDate()));
        if (r.getDepartureDate() != null) {
            preparedStatement.setDate(5, java.sql.Date.valueOf(r.getDepartureDate()));
        } else {
            preparedStatement.setDate(5, null);
        }
        preparedStatement.setDate(6, java.sql.Date.valueOf(r.getEstDepartureDate()));
        preparedStatement.setInt(7, r.getNumAdults());
        preparedStatement.setInt(8, r.getNumChildren());
        preparedStatement.setString(9, r.getSpecReq());

        preparedStatement.executeUpdate();

        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            r.setRegistrationId(rs.getLong(1));

        }
        preparedStatement.close();

    }

    public Registration findByRoom(Room room) throws Exception {
        Connection connection = DatabaseConnection.getInstance().getConnection();
        
        String query = "Select (RegistrationId,`RoomNo`,`RegistrationDate`,`EstDepartureDate`) from REGISTRATION where roomNo='" + room.getRoomNo()+"'";

      
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        Registration registration = new Registration();

        while (rs.next()) {
            Long id = rs.getLong("RegistrationId");
            Date regiDate = rs.getDate("RegistrationDate");
            LocalDate registrationDate = Instant.ofEpochMilli(regiDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            Date depaDate = rs.getDate("EstDepartureDate");
            LocalDate estDepartureDate = Instant.ofEpochMilli(depaDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            registration.setRegistrationId(id);
            registration.setRegistrationDate(registrationDate);
            registration.setEstDepartureDate(estDepartureDate);
            rs.close();
            statement.close();

        }
        return registration;

    }

    @Override
    public Registration findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Registration T) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

}
