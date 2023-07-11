package domain;

import java.math.BigDecimal;

/**
 *
 * @author Jelena Basaric
 */
public class RoomType {
    private RoomTypeEnum roomTypeName;
    private BigDecimal roomPrice;
    private BigDecimal defaultRoomPrice;
    private String roomDesc;
    private boolean klima;

    public RoomType(RoomTypeEnum roomTypeName, BigDecimal roomPrice, BigDecimal defaultRoomPrice, String roomDesc) {
        this.roomTypeName = roomTypeName;
        this.roomPrice = roomPrice;
        this.defaultRoomPrice = defaultRoomPrice;
        this.roomDesc = roomDesc;
    }
   
    public RoomType(RoomTypeEnum roomTypeName, BigDecimal roomPrice, BigDecimal defaultRoomPrice, String roomDesc, boolean klima) {
        this.roomTypeName = roomTypeName;
        this.roomPrice = roomPrice;
        this.defaultRoomPrice = defaultRoomPrice;
        this.roomDesc = roomDesc;
        this.klima = klima;
    }

    public RoomType() {
    }

    public RoomTypeEnum getRoomTypeName() {
        return roomTypeName;
    }

    public void setRoomTypeName(RoomTypeEnum roomTypeName) {
        this.roomTypeName = roomTypeName;
    }

    public BigDecimal getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(BigDecimal roomPrice) {
        this.roomPrice = roomPrice;
    }

    public BigDecimal getDefaultRoomPrice() {
        return defaultRoomPrice;
    }

    public void setDefaultRoomPrice(BigDecimal defaultRoomPrice) {
        this.defaultRoomPrice = defaultRoomPrice;
    }

    public String getRoomDesc() {
        return roomDesc;
    }

    public void setRoomDesc(String roomDesc) {
        this.roomDesc = roomDesc;
    }

    public boolean isKlima() {
        return klima;
    }

    public void setKlima(boolean klima) {
        this.klima = klima;
    }

    @Override
    public String toString() {
        return "RoomType{" + "roomType=" + roomTypeName + ", RoomPrice=" + roomPrice + ", defaultRoomPrice=" + defaultRoomPrice + ", roomDesc=" + roomDesc + ", klima=" + klima + '}';
    }
    
    
}
