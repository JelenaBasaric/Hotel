/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package domain;

/**
 *
 * @author jbasa
 */
public enum CardEnum {
    VISA,DINA,MAESTRO,AMERICAN_EXPRESS,OSTALO;

    @Override
    public String toString() {
       return this.name();
    }
    
    
    
}
