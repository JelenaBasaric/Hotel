/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicForPayment;

/**
 *
 * @author Cartman
 */
public class Cache extends PaymentMethod{

    @Override
    protected boolean autorizacijaPlacanja() {
        return true;
    }

    @Override
    protected boolean proveraSpecificnihPreduslovaZaPlacanje() {
        return true;
    }

    @Override
    protected void izvrsenjePlacanja() {
        System.out.println("Prebroj novac i vrati kusur");
    }
    
}
