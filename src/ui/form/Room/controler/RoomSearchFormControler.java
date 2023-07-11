/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.Room.controler;

import applicationSession.ApplicationSession;
import domain.Room;
import genericService.RoomService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import serviceImpl.RoomServiceImpl;
import ui.component.table.model.RoomTableModel;
import ui.form.Bill.BillAddForm;
import ui.form.Room.RoomSearchForm;
import ui.form.registration.RegistrationAddForm;


/**
 *
 * @author jbasa
 */
public class RoomSearchFormControler {

    public static void populatetable(JTable tblRoom) {
         try { 
          RoomService roomService = new RoomServiceImpl();
            List<Room> rooms;
            rooms = roomService.getAll();
            tblRoom.setModel(new RoomTableModel(rooms));
        } catch (Exception ex) {
            Logger.getLogger(RoomSearchFormControler.class.getName()).log(Level.SEVERE, null, ex);
        }          
       
    }

    public static void openRegistrationOrBill(JTable tblRoom, RoomSearchForm roomSearchForm) {
      int selectedRow=tblRoom.getSelectedRow();
        RoomTableModel roomTableModel = (RoomTableModel) tblRoom.getModel();
           roomSearchForm.dispose();
            ApplicationSession as=ApplicationSession.getInstance();
            as.setRoom(roomTableModel.getRoom(selectedRow));
             if(as.getRoom().isOccupancy())
                 new RegistrationAddForm(null, true).setVisible(true);
             else{
                 new BillAddForm(null, true).setVisible(true);
             }
    }
}
