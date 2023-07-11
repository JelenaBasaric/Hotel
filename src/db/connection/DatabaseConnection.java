package db.connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jelena Basaric
 */
public class DatabaseConnection {
     private static DatabaseConnection instance;
    private final Connection connection;

   private DatabaseConnection() throws SQLException {
        //uspostavi vezu sa bazom, kreiraj Connection objekat
        String url = "jdbc:mysql://localhost:3306/hotel";
        String user = "root";
        String password = "RootRoot";
        connection = DriverManager.getConnection(url, user, password);
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public java.sql.Connection getConnection() throws SQLException {
        return connection;
    }
    
    public void closeConnection() throws SQLException{
        if (connection != null) connection.close();
    }
    public void ponistiTransakciju() throws Exception{
        try {
            connection.rollback();
            System.out.println("Uspesno ponistena tranakcija");
        } catch (SQLException ex) {
            System.out.println("Greska: Transakcija nije ponistena");
            ex.printStackTrace();
            throw new Exception("Dogodila se greska prilikom ponistavanja transakcije!\n" + ex.getMessage());
        }
    }
     public void potvrdiTransakciju() throws Exception{
        try {
            connection.commit();
            System.out.println("Uspesno potvrdjena tranakcija");
        } catch (SQLException ex) {
            System.out.println("Greska: Transakcija nije potvrdjena");
            ex.printStackTrace();
            throw new Exception("Dogodila se greska prilikom potvrdjivanja transakcije!\n" + ex.getMessage());
        }
    }
}
