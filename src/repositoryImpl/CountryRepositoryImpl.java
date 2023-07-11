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
import domain.Country;

/**
 *
 * @author Jelena Basaric
 */
public class CountryRepositoryImpl implements GenericRepository<Country, Integer>{

    @Override
    public List<Country> getAll() throws Exception {
        try {
            List<Country> countries = new ArrayList<>();
             Connection connection =  DatabaseConnection.getInstance().getConnection();
            //uzmi iz baze sve zemlje
            String query = "SELECT CountryId, CountryName,CountryShortName FROM Country ORDER BY countryName";
            
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {                
                //uzmi id;
                int id = resultSet.getInt("CountryId");
                String name = resultSet.getString("CountryName");
                String shortname = resultSet.getString("CountryShortName");
                
                Country country = new Country(id, name, shortname);
                countries.add(country);
            }
            resultSet.close();
            statement.close();
            
            //vrati listu zemlja koji se nalaze u bazi
            return countries;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
            throw new Exception("Greska u izvrsenju metode getAll(0 klase CountryRepository ->" + ex.getMessage());
        }
    }

    @Override
    public void add(Country country) throws Exception {
        try {
            Connection connection =  DatabaseConnection.getInstance().getConnection();
            String query = "INSERT INTO Country (countryName, CountryShortName) VALUES (?,?)";
            
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, country.getCountryName());
            preparedStatement.setString(2, country.getShortName());
            
            preparedStatement.executeUpdate();
            
            preparedStatement.close();
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
            throw new Exception("Greska u izvrsenju metode add() klase CountryRepository ->" + ex.getMessage());
        }
    }

    @Override
    public List<Country> findByQuery(String query) throws Exception {
        try {
            List<Country> countries = new ArrayList<>();
            
            Connection connection =  DatabaseConnection.getInstance().getConnection();

            //uzmi iz baze sve zemlje
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {                
                //uzmi id;
                int id = resultSet.getInt("countryId");
                String name = resultSet.getString("countryName");
                String shortname = resultSet.getString("countryShortName");
                
                Country country = new Country(id, name, shortname);
                countries.add(country);
            }
            resultSet.close();
            statement.close();
            //vrati listu zemlja koji se nalaze u bazi
            return countries;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
            throw new Exception("Greska u izvrsenju metode findByQuery() klase CountryRepository ->" + ex.getMessage());
        }
    }

    @Override
    public Country findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Country T)throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
    
}
