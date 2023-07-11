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
public class AmericanExpressCard extends PaymentMethod{

    @Override
    public boolean autorizacijaPlacanja() {
        System.out.println("Vrsi se proces autorizacije placanja preko American_Express servisa.");
        return true;
    }

    @Override
    public boolean proveraSpecificnihPreduslovaZaPlacanje() {
        System.out.println("Vrsi se provera stanja na racunu.");
        return true;
    }

    @Override
    public void izvrsenjePlacanja() {
        System.out.println("Vrsi se proces placanja!");
    }
    
}
