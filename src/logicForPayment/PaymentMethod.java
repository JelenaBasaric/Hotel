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
public abstract class PaymentMethod {
    BigDecimal iznos;
    
    protected void prikaziPotrebnePodatkeZaUplatu(){
        System.out.println("Iznos za uplatu: "+iznos);
    }
    protected abstract boolean autorizacijaPlacanja();
    protected abstract boolean proveraSpecificnihPreduslovaZaPlacanje();
    protected abstract void izvrsenjePlacanja();
    protected void izvestajOUspesnostiPlacanja(){
        System.out.println("Uspesno placanje!");
    }
    protected void stampanjeRacuna(){
        System.out.println("Stampanje racuna!");
    }
    
    public final void izvrsiPlacanje(BigDecimal iznos){
        this.iznos=iznos;
        prikaziPotrebnePodatkeZaUplatu();
        if(autorizacijaPlacanja()){
            if(proveraSpecificnihPreduslovaZaPlacanje()){
                izvrsenjePlacanja();
                izvestajOUspesnostiPlacanja();
                stampanjeRacuna();
            }
        }
    }
    
//    public void izvrsiPlacanje(String nacinPlacanja, BigDecimal iznos){
//        if(nacinPlacanja.equals("Viza")){
//            System.out.println("Iznos za uplatu: "+iznos);
//            if(true){
//                System.out.println("Vrsi se proces autorizacije placanja preko Visa servisa.");
//                if(true){
//                    System.out.println("Vrsi se provera stanja na racunu.");
//                    if(true){
//                        System.out.println("Vrsi se proces placanja!");
//                        System.out.println("Uspesno placanje!");
//                        System.out.println("Stampanje racuna!");
//                    }
//                }
//            }  
//        }
//        
//        if(nacinPlacanja.equals("Cekovi")){
//            System.out.println("Iznos za uplatu: "+iznos);
//            if(true){
//                System.out.println("Vrsi se proces autorizacije placanja proverom licne karte i cekovne kartice.");
//                if(true){
//                    System.out.println("Proverava se datum dospeca ceka i broj rata i sl.");
//                    if(true){
//                         System.out.println("Vrsi se proces placanja!");
//                        System.out.println("Uspesno placanje!");
//                        System.out.println("Stampanje racuna!");
//                    }
//                }
//            }
//        }
//    }
}
