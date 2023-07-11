/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicForPayment;

/**
 *
 * @author Cartman
 */
public class PaymentMethodFactory {
    public static PaymentMethod getNacinPlacanja(String nacinPlacanja){
        PaymentMethod placanje=null;
        if(nacinPlacanja.equals("Visa")){
            placanje=new VisaCard();
        }
        if(nacinPlacanja.equals("Maestro")){
            placanje=new MaestroCard();
        }
        if(nacinPlacanja.equals("Dina")){
            placanje=new DinaCard();
        }
        if(nacinPlacanja.equals("American_Express")){
            placanje=new AmericanExpressCard();
        }
        if(nacinPlacanja.equals("Cekovi")){
            placanje=new Cheque();
        }
        if(nacinPlacanja.equals("IPS")){
            placanje=new IPS();
        }
        if(nacinPlacanja.equals("Kes")){
            placanje=new Cache();
        }
        return placanje;
    }
}
