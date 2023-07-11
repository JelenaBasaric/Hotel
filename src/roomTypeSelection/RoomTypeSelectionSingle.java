package roomTypeSelection;

import domain.Guest;
import domain.Room;
import domain.RoomType;
import domain.RoomTypeEnum;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jelena Basaric
 */
public class RoomTypeSelectionSingle implements roomTypeSelection.RoomTypeSelection {

    @Override
    public void addBed(RoomType roomType) {
      //  roomType.setDefaultNumBad(2);
    }

    @Override
    public void returnDefault(RoomType roomType) {
        roomType.setRoomTypeName(RoomTypeEnum.JEDNOKREVETNA);
       // roomType.setDefaultNumBad(1);
        roomType.setRoomDesc("Jednokrevetna soba");
        if (roomType.isKlima()) {
            roomType.setRoomPrice(new BigDecimal(12000 + 1000));
        } else {
            roomType.setRoomPrice(new BigDecimal(12000));
        }
        roomType.setDefaultRoomPrice(new BigDecimal(12000));
       
       
                
    }

    @Override
    public void returnRoomType(RoomType roomType) {
        roomType.setRoomTypeName(RoomTypeEnum.JEDNOKREVETNA);
       // roomType.setDefaultNumBad(1);
        roomType.setRoomDesc("Jednokrevetna soba");
        if (roomType.isKlima()) {
            roomType.setRoomPrice(new BigDecimal(12000 + 1000));
        } else {
            roomType.setRoomPrice(new BigDecimal(12000));
        }
        roomType.setDefaultRoomPrice(new BigDecimal(12000));
    }

}
