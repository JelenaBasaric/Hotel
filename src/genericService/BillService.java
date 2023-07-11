/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package genericService;

import domain.Bill;
import java.util.List;

/**
 *
 * @author jbasa
 */
public interface BillService {
    void add(Bill bill) throws Exception;
    List<Bill> getAll() throws Exception;
    
}
