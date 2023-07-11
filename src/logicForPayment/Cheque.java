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
public class Cheque extends PaymentMethod{

    @Override
    protected boolean autorizacijaPlacanja() {
        System.out.println("Vrsi se proces autorizacije placanja proverom licne karte i cekovne kartice.");
        return true;
    }

    @Override
    protected boolean proveraSpecificnihPreduslovaZaPlacanje() {
        System.out.println("Proverava se datum dospeca ceka i broj rata i sl.");
        return true;
    }

    @Override
    protected void izvrsenjePlacanja() {
        System.out.println("Vrsi se proces placanja!");
    }


    
}
