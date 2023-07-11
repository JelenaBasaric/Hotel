package repositoryImpl;

import db.connection.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import repository.GenericRepository;
import domain.City;
import domain.Country;

/**
 *
 * @author Jelena Basaric
 */
public class CityRepositoryImpl implements GenericRepository<City, Long> {

    @Override
    public List<City> getAll() throws Exception {
        try {
            List<City> cities = new ArrayList<>();

            //uzmi connection objekat
            Connection connection = DatabaseConnection.getInstance().getConnection();
            //uzmi iz baze sve gradove
            String query = "SELECT city.zipCode AS zipCode, cityName AS cityName, city.countryId AS countryId, countryName AS countryName, countryShortName AS shortName FROM City city INNER JOIN Country country ON city.countryId =country.countryId ORDER BY countryId";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Long zipcode = resultSet.getLong("zipCode");
                String cityName = resultSet.getString("cityName");

                Integer countryId = resultSet.getInt("countryId");
                String countryName = resultSet.getString("countryName");
                String shortName = resultSet.getString("shortName");

                Country country = new Country(countryId, countryName, shortName);
                City city = new City(zipcode, cityName, country);
                cities.add(city);
            }
            resultSet.close();
            statement.close();

            //vrati listu gradova koji se nalaze u bazi
            return cities;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

            throw new Exception("Greska u izvrsenju metode getAll() klase CityRepository ->" + ex.getMessage());
        }
    }

  

    @Override
    public List<City> findByQuery(String query) throws Exception {
        try {
            List<City> cities = new ArrayList<>();
            Connection connection = DatabaseConnection.getInstance().getConnection();

            //uzmi iz baze sve zemlje
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                //uzmi id;
                Long zipcode = resultSet.getLong("zip_code");
                String name = resultSet.getString("city_name");
                //country
                Country country = new Country();
                Integer country_id = resultSet.getInt("country_id");
                country.setCountryId(country_id);
                country.setCountryName("country_name");
                country.setShortName("short_name");

                City city = new City(zipcode, name, country);
                cities.add(city);
            }
            resultSet.close();
            statement.close();

            return cities;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

            throw new Exception("Greska u izvrsenju metode findByQuery() klase CityRepository ->" + ex.getMessage());
        }
    }

    @Override
    public City findById(Long id) {
        try {
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT city.zipcode, city.cityName AS city_name, countryName AS country_name, country.Countryshortname as short_name, Country.countryId AS Id FROM city JOIN country ON city.countryid=country.countryid WHERE city.zipcode='" + id+"'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if (rs.next()) {
                //kreiraj objekat klase City
                Long zipCode = rs.getLong("zipcode");
                String cityName = rs.getString("city_name");
                String countryName = rs.getString("country_name");
                String shortName = rs.getString("short_name");
                Integer countryId = rs.getInt("id");
                Country country = new Country(countryId, countryName, shortName);
                City city = new City(zipCode, cityName, country);
                return city;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }

   
    @Override
    public void add(City city) throws Exception {
        
            try {
                //uzmi connection objekat
                Connection connection = DatabaseConnection.getInstance().getConnection();

                String query = "INSERT INTO city VALUES (?,?,?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setLong(1, city.getZipCode());
                preparedStatement.setString(2, city.getCityName());
                preparedStatement.setInt(3, city.getCountry().getCountryId());

                preparedStatement.executeUpdate();

                preparedStatement.close();
            } catch (Exception ex) {
                throw new Exception("Greska u izvrsenju metode add() klase CityRepository ->" + ex.getMessage());

            }

        
    }

    @Override
    public void update(City T) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

 
}
