package applicationSession;

import domain.Room;
import domain.RoomTypeEnum;
import domain.UserProfile;

/**
 *
 * @author Jelena Basaric
 */
public class ApplicationSession {
   
    
    private static ApplicationSession instance;
    private UserProfile loginUser;
    //user koji je trenutno prijavljen na sistem
    private Integer idEmployee;
    private Room room;

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

   /* public RoomTypeEnum getRoomTypeEnum() {
        return roomTypeEnum;
    }

    public void setRoomTypeEnum(RoomTypeEnum roomTypeEnum) {
        this.roomTypeEnum = roomTypeEnum;
    }*/

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }
    
    private ApplicationSession(){
        System.out.println("Kreiran objekat klase ApplicationSession.");
    }
    
    public UserProfile getLoginUser() {
        return loginUser;
    }

    public void setLoginUser(UserProfile loginUser) {
        this.loginUser = loginUser;
    }
    
    public static ApplicationSession getInstance(){
        if (instance ==null) instance = new ApplicationSession();
        
        return instance;
    }
}
    

