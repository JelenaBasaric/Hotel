/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package repository;

import domain.Bill;
import domain.Registration;
import domain.Room;
import java.util.List;

/**
 *
 * @author jbasa
 */
public interface GenericRepository <T,ID>{
    void add(T entity)throws Exception;
    List<T> getAll()throws Exception;
    List<T> findByQuery(String query) throws Exception;
    T findById(ID id) ;
    void update(T entity) throws Exception;
  
}
