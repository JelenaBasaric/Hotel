/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceImpl;

import domain.Bill;
import genericService.BillService;
import java.util.List;
import repository.GenericRepository;
import repositoryImpl.BillRepositoryImpl;

/**
 *
 * @author jbasa
 */
public class BillServiceImpl implements BillService {
    private final GenericRepository billRepository;

    public BillServiceImpl() {
        billRepository=new BillRepositoryImpl();
    }

    
    
    

    @Override
    public void add(Bill bill) throws Exception {
       billRepository.add(bill);
    }

    @Override
    public List<Bill> getAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
