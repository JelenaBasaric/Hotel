/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repositoryImpl;

import db.connection.DatabaseConnection;
import domain.Role;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import repository.GenericRepository;

/**
 *
 * @author Jelena Basaric
 */
public class RoleRepositoryImpl implements GenericRepository<Role, Integer> {

    @Override
    public List<Role> findByQuery(String query) throws Exception {
        try {
            List<Role> roles = new ArrayList<>();
            Connection connection = DatabaseConnection.getInstance().getConnection();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Role r = new Role(resultSet.getInt("RoleId"), resultSet.getString("RoleTitle"));
                roles.add(r);
            }
            resultSet.close();
            statement.close();

            return roles;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

            throw new Exception("Greska u izvrsenju metode findByQuery() klase UserProfileRepository ->" + ex.getMessage());
        }
    }

    @Override
    public List<Role> getAll() throws Exception {
        try {
            List<Role> roles = new ArrayList<>();
            Connection connection = DatabaseConnection.getInstance().getConnection();
            String query = "SELECT `RoleId`,`RoleTitle`,`RoleDesc` FROM ROLE";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int roleId = resultSet.getInt("RoleId");
                String roleTitle = resultSet.getString("RoleTitle");
                String roleDesc = resultSet.getString("RoleDesc");
                Role r = new Role(roleId, roleTitle, roleDesc);
                roles.add(r);
            }
            resultSet.close();
            statement.close();
            return roles;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

            throw new Exception("Greska u izvrsenju metode findByQuery() klase UserProfileRepository ->" + ex.getMessage());
        }
    }

    @Override
    public void add(Role enity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Role findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Role T) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   

}
