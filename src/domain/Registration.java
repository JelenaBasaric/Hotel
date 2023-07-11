package domain;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Jelena Basaric
 */
public class Registration {
    private long registrationId;
    private Hotel hotel;
    private Guest guest;
    //private List<Guest> guests;
    private Room room;
    private int numAdults;
    private int numChildren;
    private String SpecReq;
    private LocalDate departureDate;
    private LocalDate estDepartureDate;
    private LocalDate registrationDate;
    private String TypeOfService;

    public Registration() {
    }

    public Registration(long registrationId, Hotel hotel, Guest guest, Room room, int numAdults, int numChildren, String SpecReq, LocalDate departureDate, LocalDate estDepartureDate, LocalDate registrationDate, String TypeOfService) {
        this.registrationId = registrationId;
        this.hotel = hotel;
        this.guest = guest;
       // this.guests = guests;
        this.room = room;
        this.numAdults = numAdults;
        this.numChildren = numChildren;
        this.SpecReq = SpecReq;
        this.departureDate = departureDate;
        this.estDepartureDate = estDepartureDate;
        this.registrationDate = registrationDate;
        this.TypeOfService = TypeOfService;
    }

    public long getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(long registrationId) {
        this.registrationId = registrationId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    /*public List<Guest> getGuests() {
        
        return guests;
    }

    /*public void setGuests(List<Guest> guests) throws Exception {
        if(room.getRoomType().getRoomTypeName()==RoomTypeEnum.JEDNOKREVETNA)
            if(guests.size()==1){
                this.guests=guests;}
            else
                throw new Exception ("U sobi moze biti samo jedan gost");
        else if(room.getRoomType().getRoomTypeName()==RoomTypeEnum.DVOKREVETNA)
            if(guests.size()<=2)
                this.guests=guests;
            else
                throw new Exception ("U sobi moze biti do dva gosta");
        else  if(room.getRoomType().getRoomTypeName()==RoomTypeEnum.TROKREVETNA)
            if(guests.size()<=3)
                this.guests=guests;
            else
                throw new Exception ("U sobi moze biti do tri gosta");
        else  if(room.getRoomType().getRoomTypeName()==RoomTypeEnum.CETVOROKREVETNA)   
            if(guests.size()<=4)
                this.guests=guests;
            else
                throw new Exception ("U sobi moze biti do četiri  gosta");
        else  if(room.getRoomType().getRoomTypeName()==RoomTypeEnum.APARTMAN)
            if(guests.size()<=2)
                this.guests=guests;
        else
                throw new Exception ("U sobi moze biti do dva gosta");
    }*/

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getNumAdults() {
        return numAdults;
    }

    public void setNumAdults(int numAdults) {
        this.numAdults = numAdults;
    }

    public int getNumChildren() {
        return numChildren;
    }

    public void setNumChildren(int numChildren) {
        this.numChildren = numChildren;
    }

    public String getSpecReq() {
        return SpecReq;
    }

    public void setSpecReq(String SpecReq) {
        this.SpecReq = SpecReq;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalDate getEstDepartureDate() {
        return estDepartureDate;
    }

    public void setEstDepartureDate(LocalDate estDepartureDate) {
        this.estDepartureDate = estDepartureDate;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getTypeOfService() {
        return TypeOfService;
    }

    public void setTypeOfService(String TypeOfService) {
        this.TypeOfService = TypeOfService;
    }

    
    
    
    
}
