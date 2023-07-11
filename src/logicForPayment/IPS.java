/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicForPayment;

import java.math.BigDecimal;

/**
 *
 * @author Cartman
 */
public class IPS extends PaymentMethod{

    @Override
    protected void prikaziPotrebnePodatkeZaUplatu() {
        super.prikaziPotrebnePodatkeZaUplatu();
        System.out.println("QR kod");
    }    

    @Override
    protected boolean autorizacijaPlacanja() {
        System.out.println("Vrsi se proces autorizacije preko servisa banke.");
        return true;
    }

    @Override
    protected boolean proveraSpecificnihPreduslovaZaPlacanje() {
        System.out.println("Vrsi se provera stanja na racunu.");
        return true;
    }

    @Override
    protected void izvrsenjePlacanja() {
        System.out.println("Vrsi se proces placanja!");
    }
    
}
