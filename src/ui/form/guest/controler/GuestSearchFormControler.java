/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.guest.controler;

import domain.Guest;
import genericService.GuestService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import serviceImpl.GuestServiceImpl;
import ui.component.table.model.GuestTableModel;
import ui.form.guest.GuestSearchForm;

/**
 *
 @author Jelena Basaric
 */
public class GuestSearchFormControler {

    public static void populateTable(JTable tblGuest) {
        try {
             GuestService guestService = new GuestServiceImpl();
            List<Guest> guests = guestService.getAll();
            
            tblGuest.setModel(new GuestTableModel(guests));
        } catch (Exception ex) {
            Logger.getLogger(GuestSearchForm.class.getName()).log(Level.SEVERE, null, ex);
        }
         tblGuest.doLayout();
         
        }
    
}
