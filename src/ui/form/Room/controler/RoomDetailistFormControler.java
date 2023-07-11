/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.room.controler;

import applicationSession.ApplicationSession;
import domain.Room;
import genericService.RoomService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import serviceImpl.RoomServiceImpl;
import ui.component.table.model.RoomTableModel;
import ui.form.Bill.BillAddForm;
import ui.form.Room.RoomDetailsForm;
import ui.form.registration.RegistrationAddForm;

/**
 *
 * @author Jelena Basaric
 */
public class RoomDetailistFormControler {

    public static void populateTable(JTable tblRoom) {
        Room room=ApplicationSession.getInstance().getRoom();

          RoomService roomService = new RoomServiceImpl();
            List<Room> rooms;
        try {
            rooms = roomService.getAll();
        
            List<Room> rooms1=new ArrayList<>();
           
            for(Room room1:rooms){
                if(room.getRoomType()!=null){
                     if(room1.getRoomType().getRoomTypeName()==room.getRoomType().getRoomTypeName()&& room1.isOccupancy()==room.isOccupancy())
                         rooms1.add(room1);
                
            }
                else if(room1.isOccupancy()==room.isOccupancy())
                    rooms1.add(room1);
            }
            tblRoom.setModel(new RoomTableModel(rooms1));
            ApplicationSession.getInstance().setRoom(null);
            } catch (Exception ex) {
            Logger.getLogger(RoomDetailistFormControler.class.getName()).log(Level.SEVERE, null, ex);
        }     
     
        
        
    }

    public static void openRegistrationFormOrBillAddForm(JTable tblRoom, RoomDetailsForm roomDetailsForm) {
        int selectedRow=tblRoom.getSelectedRow();
        RoomTableModel roomTableModel = (RoomTableModel) tblRoom.getModel();
            roomDetailsForm.dispose();
            ApplicationSession as=ApplicationSession.getInstance();
            as.setRoom(roomTableModel.getRoom(selectedRow));
             if(as.getRoom().isOccupancy())
                 new RegistrationAddForm(null, true).setVisible(true);
             else{
                 new BillAddForm(null, true).setVisible(true);
             }        
    }

   
    
}
