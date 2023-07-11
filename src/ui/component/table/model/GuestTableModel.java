/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.component.table.model;

import domain.Employee;
import domain.Guest;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kruna2
 */
public class GuestTableModel extends AbstractTableModel {

    private final List<Guest> guests;

    public GuestTableModel(List<Guest> guests) {
        this.guests = guests;
        
    }

    @Override
    public int getRowCount() {
        if (guests == null) {
            return 0;
        } else {
            return guests.size();
        }
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Guest guest = guests.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return guest.getGuestId();
            case 1:
                return guest.getFirstName();
            case 2:
                return guest.getLastName();
            case 3:
                return guest.getAddress();
            case 4:
                return guest.getCity();
            case 5:
                return guest.getCity().getCountry();
            case 6:
                return guest.getPassportNo();
            case 7:
                return guest.getEmail();
            case 8:
                return guest.getPhoneNumber();
            case 9:
                return guest.getGender();

            default:
                break;
        }
        return "n/a";
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
               
                return "Gost id";
            case 1:
                return "Ime";
            case 2:
                return "Prezime";
            case 3:
                return "Adresa";
            case 4:
                return "Grad";
            case 5:
                return "Drzava";
            case 6:
                return "Broj pasoša";
            case 7:
                return "Email";
            case 8:
                return "Broj telefona";
            case 9:
                return "Pol";
            default:
                break;
        }
        return "n/a";
    }
    /* public double setColumnSize(int column) {
        switch (column) {
            case 0:
               
                column.
            case 1:
                return "Ime";
            case 2:
                return "Prezime";
            case 3:
                return "Adresa";
            case 4:
                return "Grad";
            case 5:
                return "Drzava";
            case 6:
                return "Broj pasoša";
            case 7:
                return "Email";
            case 8:
                return "Broj telefona";
            case 9:
                return "Pol";
            default:
                break;
        }
        return "n/a";
    }*/
    
   }
