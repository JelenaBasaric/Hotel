package domain;

import java.util.List;

/**
 *
 * @author Jelena Basaric
 */
public class Room {
   private int roomNo;
   private Hotel hotel;
   private boolean occupancy;
   private RoomType roomType;
   private List<Guest> guests;

   
   

    public Room(int roomNo, Hotel hotel, boolean occupancy, RoomType roomType) {
        this.roomNo = roomNo;
        this.hotel = Hotel.getIstance();
        this.occupancy = occupancy;
        this.roomType = roomType;
    }

    public Room() {
    }

    public int getRoomNo() {
        return roomNo;
    }
     public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) throws Exception {
       if(getRoomType().getRoomTypeName()==RoomTypeEnum.JEDNOKREVETNA)
            if(guests.size()==1){
                this.guests=guests;}
            else
                throw new Exception ("U sobi moze biti samo jedan gost");
        else if(getRoomType().getRoomTypeName()==RoomTypeEnum.DVOKREVETNA)
            if(guests.size()<2)
                this.guests=guests;
            else
                throw new Exception ("U sobi moze biti do dva gosta");
        else  if(getRoomType().getRoomTypeName()==RoomTypeEnum.TROKREVETNA)
            if(guests.size()<3)
                this.guests=guests;
            else
                throw new Exception ("U sobi moze biti do tri gosta");
        else  if(getRoomType().getRoomTypeName()==RoomTypeEnum.CETVOROKREVETNA)   
            if(guests.size()<4)
                this.guests=guests;
            else
                throw new Exception ("U sobi moze biti do četiri  gosta");
        else  if(getRoomType().getRoomTypeName()==RoomTypeEnum.APARTMAN)
            if(guests.size()<2)
                this.guests=guests;
        else
                throw new Exception ("U sobi moze biti do dva gosta");
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public boolean isOccupancy() {
        return occupancy;
    }

    public void setOccupancy(boolean occupancy) {
        this.occupancy = occupancy;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    @Override
    public String toString() {
        return roomNo+","+roomType.getRoomTypeName()+", raspoloziva:"+ occupancy ;
    }
    
   
    
}
