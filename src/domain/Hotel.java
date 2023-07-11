package domain;

import java.util.List;
import repositoryImpl.RoomRepositpryImpl;

/**
 *
 * @author Jelena Basaric
 */
public class Hotel {

    private int id;
    private String name;
    private int numRooms;
    private String phoneNumber;
    private String email;
    private City city;
    private String address;
    private String starRating;
    private static Hotel istance;
    private List<Room> rooms;

    private Hotel() {
    }

    private Hotel(int id, String name, int numRooms, String phoneNumber, String email, City city, String address, String starRating) {
        this.id = id;
        this.name = name;
        this.numRooms = rooms.size();
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city = city;
        this.address = address;
        this.starRating = starRating;
           }

    public List<Room> getRooms() {

       repositoryImpl.RoomRepositpryImpl roomRepository = new RoomRepositpryImpl();
        try {
            this.rooms = roomRepository.getAll();
        } catch (Exception e) {
            System.out.println("Greska u listi rooms, u konstuktoru hotela");
        }
        return rooms;
    }

     

    

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public void setNumRoom(int numRoom) {
        this.numRooms = numRoom;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStarRating() {
        return starRating;
    }

    public void setStarRating(String starRating) {
        this.starRating = starRating;
    }

    public static Hotel getIstance() {
        if (istance == null) {
            istance = new Hotel();
        }
        return istance;
    }

}
