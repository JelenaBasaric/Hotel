package repositoryImpl;

import db.connection.DatabaseConnection;
import domain.Employee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import repository.GenericRepository;
import domain.UserProfile;


/**
 *
 * @author Jelena Basaric
 */
public class UserProfileRepositoryImpl implements  GenericRepository<UserProfile, String>{

    @Override
    public List<UserProfile> findByQuery(String query) throws Exception {
        try {
            List<UserProfile> userProfiles = new ArrayList<>();
            
            Connection connection =  DatabaseConnection.getInstance().getConnection();

            //uzmi iz baze sve zemlje
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {                
                //uzmi id;
                String email = resultSet.getString("email");
                
                UserProfile userProfile = new UserProfile();
                userProfile.setEmail(email);
                userProfile.setPassword(null);
                
                //posatavi za Empolyee samo id
                userProfile.setEmployee(new Employee(resultSet.getInt("employeeId")));
                userProfile.setRoles(null);
                
                userProfiles.add(userProfile);
            }
            resultSet.close();
            statement.close();
            
            //vrati listu zemlja koji se nalaze u bazi
            return userProfiles;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
            throw new Exception("Greska u izvrsenju metode findByQuery() klase UserProfileRepository ->" + ex.getMessage());
        }
    }

    @Override
    public List<UserProfile> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(UserProfile enity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UserProfile findById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(UserProfile T)throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}