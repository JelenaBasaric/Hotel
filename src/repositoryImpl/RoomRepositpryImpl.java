package repositoryImpl;

//import db.connection.DatabaseConnection;
import domain.City;
import domain.Country;
import domain.GenderEnum;
import domain.Guest;
import domain.Hotel;
import domain.Room;
import domain.RoomType;
import domain.RoomTypeEnum;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import repository.GenericRepository;
import dbConn.*;

/**
 *
 * @author Jelena Basaric
 */
public class RoomRepositpryImpl implements GenericRepository<Room,Integer> {

    @Override
    public List getAll() throws Exception {
        //  uzmi konekciju:
        Connection connection = DatabaseConnection.getInstance().getConnection();
        // kreiraj upit:
        String query = "SELECT roomNo,roomTypeName,occupancy,roomprice, roomdefaultprice, roomdesc FROM ROOM JOIN roomtype ON room.roomtypeId=roomtype.roomtypeId ORDER BY room.roomTypeId";

        // izvrsi upit:
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);
        List<Room> rooms = new ArrayList<>();
        // procitaj rezultat i upisi u listu

        while (rs.next()) {
            //procitaj vrednost iz tabele
            int roomNo = rs.getInt("RoomNo");
            //String sroomTypeName = rs.getString("roomTypeName");
            RoomTypeEnum roomTypeName=RoomTypeEnum.valueOf(rs.getString("roomTypeName"));
            boolean occupancy = rs.getBoolean("occupancy");
            BigDecimal roomPrice=rs.getBigDecimal("roomprice");
            BigDecimal roomDefaultPrice=rs.getBigDecimal("roomdefaultprice");
            String roomdesc=rs.getString("roomdesc");
            Hotel hotel=Hotel.getIstance();
            RoomType rt=new RoomType(roomTypeName, roomPrice, roomDefaultPrice, roomdesc);
            Room room=new Room(roomNo, hotel, occupancy, rt);
            rooms.add(room);
        }
        rs.close();
        statement.close();
        // vrati listu
        return rooms;

    }

    @Override
    public List findByQuery(String query) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void add(Room room) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Room room) throws Exception {
           Connection connection = DatabaseConnection.getInstance().getConnection();
           String query="UPDATE room SET occupancy=? WHERE roomNo=?";
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(query);
             preparedStatement.setBoolean(1, room.isOccupancy());
             preparedStatement.setInt(2, room.getRoomNo());
             preparedStatement.executeUpdate();
             preparedStatement.close();
             System.out.println("Promenjena je raspolozivost sobe");
        
    }

    

    @Override
    public Room findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Room> getAll() throws Exception {
        List<Room> rooms=new ArrayList<>();  
        try{
        Connection connection = DbConnection.getInstance().getConnection();
        String query="";
        }catch(Exception ex){
         //   ex.printStackTrace();  
        }

    
}
