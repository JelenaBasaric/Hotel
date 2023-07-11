/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.form.hotel.controler;

import domain.Hotel;
import javax.swing.JTextField;

/**
 *
 * @author jbasa
 */
public class HotelFormControler {

    public static void prepareform(JTextField txtName, JTextField txtCity, JTextField txtCountry, JTextField txtAddress, JTextField txtEmail, JTextField txtNumRoom, JTextField txtPhoneNo, JTextField txtStarRating) {
        Hotel hotel=Hotel.getIstance();
        txtName.setText(hotel.getName());
        txtCity.setText(hotel.getCity().toString());
        txtCountry.setText(hotel.getCity().getCountry().getCountryName());
        txtAddress.setText(hotel.getAddress());
        txtEmail.setText(hotel.getEmail());
        txtNumRoom.setText(hotel.getNumRooms()+"");
        txtPhoneNo.setText(hotel.getPhoneNumber());        
        txtStarRating.setText(hotel.getStarRating());
    }
    
}
