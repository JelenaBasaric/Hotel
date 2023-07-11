package repositoryImpl;

import db.connection.DatabaseConnection;
import domain.City;
import domain.Country;
import domain.Hotel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import repository.GenericRepository;

/**
 *
 * @author Jelena Basaric
 */
public class HotelRepositoryImpl implements GenericRepository<Hotel, Integer> {

    @Override
    public List<Hotel> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Hotel> findByQuery(String query) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Hotel enity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    public Hotel find() {
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT `HotelId`,`HotelName`,`HotelAddress`,`NumRoom`,`email`,`PhoneNo`,`StarRating`,`CityZipCode`,`CityName`,city.CountryId,`CountryName` FROM hotel JOIN city ON hotel.cityZipCode=city.ZipCode JOIN country ON city.countryId=country.countryId";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                //kreiraj objekat klase City
                int hotelId = rs.getInt("HotelId");
                String hotelName = rs.getString("HotelName");
                String hotelAddress = rs.getString("HotelAddress");
                int numRoom = rs.getInt("NumRoom");
                String email = rs.getString("email");
                String phoneNo = rs.getString("PhoneNo");
                String starRating = rs.getString("StarRating");
                Long zipCode = rs.getLong("CityZipCode");
                String cityName = rs.getString("cityName");
                String countryName = rs.getString("countryName");
                int countryId = rs.getInt("countryId");
                Country country = new Country();
                country.setCountryId(countryId);
                country.setCountryName(countryName);
                // Integer countryId = rs.getInt("id");
                City city = new City(zipCode, cityName, country);
                Hotel hotel=Hotel.getIstance();
                hotel.getIstance().setName(hotelName);
                hotel.getIstance().setAddress(hotelAddress);
                hotel.getIstance().setEmail(email);
                hotel.getIstance().setCity(city);
                hotel.getIstance().setId(hotelId);
                hotel.getIstance().setEmail(email);
                hotel.getIstance().setPhoneNumber(phoneNo);
                hotel.getIstance().setNumRoom(numRoom);
                hotel.getIstance().setStarRating(starRating);
                hotel.getIstance();
                return hotel.getIstance();
                
            } else {
                return null;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

        @Override
        public void update
        (Hotel T) throws Exception {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

    @Override
    public Hotel findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 

    }
