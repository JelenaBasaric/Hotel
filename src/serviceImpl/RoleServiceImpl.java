/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serviceImpl;

import domain.Role;
import genericService.RoleService;
import java.util.List;
import repository.GenericRepository;
import repositoryImpl.RoleRepositoryImpl;

/**
 *
 * @author jbasa
 */
public class RoleServiceImpl implements RoleService{
    private GenericRepository roleRepository;

    public RoleServiceImpl() {
        roleRepository=new RoleRepositoryImpl();
    }
    

    @Override
    public List<Role> getAll() throws Exception {
      return roleRepository.getAll();
    }
    
    
}
