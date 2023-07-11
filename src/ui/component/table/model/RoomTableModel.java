package ui.component.table.model;

import domain.Country;
import domain.Hotel;
import domain.Room;
import domain.RoomType;
import domain.RoomTypeEnum;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Jelena Basaric
 */
public class RoomTableModel extends AbstractTableModel{
    private final List<Room> rooms;

        public RoomTableModel(List<Room> rooms) {
            this.rooms=rooms;
    }


    @Override
    public int getRowCount() {
     /*if (rooms == null) {
            return 0;
        } else {*/
            return rooms.size();
        //}
    }

 
    @Override
    public int getColumnCount() {
       return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Room room = rooms.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return room.getRoomNo();
            case 1:
                return room.getRoomType().getRoomTypeName();
            case 2:
                return  room.isOccupancy();
            case 3:
                return room.getRoomType().getRoomPrice();
            case 4:
                return room.getRoomType().getDefaultRoomPrice();
            case 5:
                return room.getRoomType().getRoomDesc();
            default:
                break;
        }
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
       switch (column) {
            case 0:
                return "Broj sobe";
            case 1:
                return "Tip sobe";
            case 2:
                return "Raspolozivost";
            case 3:
                return "Cena soba";
            case 4:
                return "Pocetna cena sobe";
            case 5:
                return "Opis sobe";
            default:
                break;
        }
        return "n/a";
    }   
    
     public Room getRoom(int index){
        if (rooms == null) return null;
        return rooms.get(index);
    }
    
}
