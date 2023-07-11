package repositoryImpl;

import domain.Bill;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import repository.GenericRepository;
import db.connection.DatabaseConnection;
import domain.City;
import domain.Country;
import domain.Guest;
import domain.PaymentMode;
import domain.Registration;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jelena Basaric
 */
public class BillRepositoryImpl implements GenericRepository<Bill, Long> {

    ;

    @Override
    public List getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List findByQuery(String query) throws Exception {
        try {
            List<Bill> bills = new ArrayList<>();
            Connection connection = DatabaseConnection.getInstance().getConnection();

            //uzmi iz baze sve zemlje
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                //uzmi id;
                Long registrationId = resultSet.getLong("RegistrationId");
                Long guestId = resultSet.getLong("GuestId");
                int roomNo = resultSet.getInt("RoomNo");
                Date registrationDate=resultSet.getDate("RegistrationDate");
                LocalDate departureDate;
                LocalDate estDepartureDate;
                int numAdults = resultSet.getInt("NumAdults");
                int numChildren = resultSet.getInt("numChildren");
                String SpecReq = resultSet.getString("SpecReq");
               Bill bill;//=new Bill(0, registration, guest, BigDecimal.ONE, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO, true, BigDecimal.ZERO, departureDate, PaymentMode.CASHMONEY)

               // bills.add(bill);
            }
            resultSet.close();
            statement.close();

            return bills;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

            throw new Exception("Greska u izvrsenju metode findByQuery() klase CityRepository ->" + ex.getMessage());
        }
    }

    @Override
    public Bill findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Bill b) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void add(Bill bill) throws Exception {
       
          try {
                //uzmi connection objekat
                Connection connection = DatabaseConnection.getInstance().getConnection();

                  String query="INSERT INTO bill (`RegistrationId`,`GuestId`) VALUES(?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setLong(1, bill.getRegistration().getRegistrationId());
                preparedStatement.setLong(2, bill.getGuest().getGuestId());
                               

                preparedStatement.executeUpdate();

                preparedStatement.close();
            } catch (Exception ex) {
                throw new Exception("Greska u izvrsenju metode add() klase BillRepository ->" + ex.getMessage());

            }

    }

   

}
