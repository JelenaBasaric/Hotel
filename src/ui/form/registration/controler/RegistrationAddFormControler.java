/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.registration.controler;

import com.toedter.calendar.JDateChooser;
import domain.Bill;
import domain.Guest;
import domain.Hotel;
import domain.Registration;
import domain.Room;
import domain.RoomTypeEnum;
import genericService.BillService;
import genericService.GuestService;
import genericService.RegistrationService;
import genericService.RoomService;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import serviceImpl.GuestServiceImpl;
import serviceImpl.RoomServiceImpl;
import ui.component.table.model.GuestTableModel;
import ui.form.registration.RegistrationAddForm;

/**
 *
 * @author jbasa
 */
public class RegistrationAddFormControler {

    public static void populateComboGuest(JComboBox<Guest> cmbGuests) {
        GuestService guestService = new GuestServiceImpl();
        try {
            cmbGuests.removeAllItems();
            List<Guest> guests = guestService.getAll();
            for (Guest guest : guests) {
                cmbGuests.addItem(guest);
            }
        } catch (Exception ex) {

        }
    }

    public static void populateCmbRoom(JComboBox<Room> cmbRoomNo, JTextField txtNumAdults, JTextField txtNumChildren, JRadioButton rbtnApartman, JRadioButton rbtnFourBad, JRadioButton rbtnThreeBad, JRadioButton rbtnTwobad, JRadioButton btnOnebad) {
        RoomService roomService = new RoomServiceImpl();
        try {
            cmbRoomNo.removeAllItems();
            RoomTypeEnum roomTypeEnum = null;
            if (rbtnApartman.isSelected()) {
                roomTypeEnum = RoomTypeEnum.valueOf(rbtnApartman.getText());
                txtNumAdults.setText("2");
                txtNumChildren.setText("0");
                txtNumAdults.setEditable(true);
                txtNumChildren.setEditable(true);
                //Room room;

            } else if (rbtnFourBad.isSelected()) {
                roomTypeEnum = RoomTypeEnum.valueOf(rbtnFourBad.getText());
                txtNumAdults.setText("");
                txtNumChildren.setText("0");
                txtNumAdults.setEditable(true);
                txtNumChildren.setEditable(true);
            } else if (rbtnThreeBad.isSelected()) {
                roomTypeEnum = RoomTypeEnum.valueOf(rbtnThreeBad.getText());
                txtNumAdults.setText("");
                txtNumChildren.setText("");
                txtNumAdults.setEditable(true);
                txtNumChildren.setEditable(true);
            } else if (rbtnTwobad.isSelected()) {
                roomTypeEnum = RoomTypeEnum.valueOf(rbtnTwobad.getText());
                txtNumAdults.setText("");
                txtNumChildren.setText("0");
                txtNumAdults.setEditable(true);
                txtNumChildren.setEditable(true);
            } else if (btnOnebad.isSelected()) {
                roomTypeEnum = RoomTypeEnum.valueOf(btnOnebad.getText());
                txtNumAdults.setText("1");
                txtNumChildren.setText("0");
                txtNumAdults.setEditable(false);
                txtNumChildren.setEditable(false);
            }
            List<Room> rooms = roomService.getAll();//.sort(roomTypeEnum.toString());
            //lisu zemalja postavi u combobox
            for (Room room : rooms) {
                if (room.getRoomType().getRoomTypeName() == roomTypeEnum) {
                    cmbRoomNo.addItem(room);
                } else if (roomTypeEnum == null) {
                    cmbRoomNo.addItem(room);
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void addGuestInRoom(JTable tblGuest, JTextField txtNumAdults, JComboBox<Room> cmbRoomNo, JComboBox<Guest> cmbGuests, RegistrationAddForm registrationAddForm) {

        Room room = (Room) cmbRoomNo.getSelectedItem();
        Guest guest = (Guest) cmbGuests.getSelectedItem();
        List<Guest> guests = new ArrayList<>();
        genericService.GuestService guestService = new GuestServiceImpl();
        guests.add(guest);
        try {
            if (room.getRoomType().getRoomTypeName() == RoomTypeEnum.JEDNOKREVETNA && (guests.size()) > 1) {
                JOptionPane.showMessageDialog(registrationAddForm, "Jednokrevetna soba moze imati samo 1 gosta");
                return;
            } else if (room.getRoomType().getRoomTypeName() == RoomTypeEnum.DVOKREVETNA && (guests.size()) > 2) {
                JOptionPane.showMessageDialog(registrationAddForm, "Dvokrevetna soba moze imati samo 2 gosta");
                return;
            } else if (room.getRoomType().getRoomTypeName() == RoomTypeEnum.TROKREVETNA && (guests.size()) > 3) {
                JOptionPane.showMessageDialog(registrationAddForm, "Trokrevetna soba moze imati samo 3 gosta");
                return;
            } else if (room.getRoomType().getRoomTypeName() == RoomTypeEnum.CETVOROKREVETNA && (guests.size()) > 4) {
                JOptionPane.showMessageDialog(registrationAddForm, "Cetvorokrevetna soba moze imati samo 4 gosta");
                return;
            } else if (room.getRoomType().getRoomTypeName() == RoomTypeEnum.APARTMAN && (guests.size()) > 2) {
                JOptionPane.showMessageDialog(registrationAddForm, "Apartman moze imati samo 2 gosta");
                return;
            }
            TableModel tblModel = new GuestTableModel(guests);
            tblGuest.setModel(tblModel);
            txtNumAdults.setText(guests.size() + "");
            // jDateEstDepartureDate.;
            System.out.println("Dodat gost u listu za sobu " + room.getRoomNo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void addRegistration(JDateChooser jDateDepartureDate, JDateChooser jDateRegistration, JDateChooser jDateEstDepartureDate, JLabel lblError, JComboBox<Guest> cmbGuests, JComboBox<Room> cmbRoomNo, JTextField txtNumAdults, JTextField txtNumChildren, JTextArea txtSpecReq, RegistrationService registrationService, GuestService guestService, BillService billService, RoomService roomService, RegistrationAddForm registrationAddForm) {
        String error = "";
        boolean valid = true;
        Hotel hotel = Hotel.getIstance();
        //`GuestId`,
        Room room = (Room) cmbRoomNo.getSelectedItem();
        room.setOccupancy(false);
        Guest guest = (Guest) cmbGuests.getSelectedItem();
        LocalDate registrationDate = Instant.ofEpochMilli(jDateRegistration.getDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        // LocalDate departureDate = Instant.ofEpochMilli(jDateDepartureDate.getDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDate estDepartureDate = Instant.ofEpochMilli(jDateEstDepartureDate.getDate().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
        if (estDepartureDate.isBefore(registrationDate)) {
            error += "Datum odjave mora biti nakon datuma registracije";
            valid = false;
        }
        int numAdults = Integer.parseInt(txtNumAdults.getText().trim());
        int numChildren = Integer.parseInt(txtNumChildren.getText().trim());
        String specReq = txtSpecReq.getText().trim();
        Registration regestration = new Registration(0, hotel, guest, room, numAdults, numChildren, specReq, null, estDepartureDate, registrationDate, specReq);
        guest.setRegistration(regestration);
        Bill bill = new Bill(0, regestration, guest);
        try {
            if (valid) {
                registrationService.saveOrUpdate(regestration);
                roomService.update(room);
                guestService.update(guest);
                billService.add(bill);
                JOptionPane.showMessageDialog(registrationAddForm, "Uspesno sacuvana registracija");
            } else {
                lblError.setText(error);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
