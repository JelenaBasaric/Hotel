/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package genericService;

import domain.Role;
import java.util.List;

/**
 *
 * @author jbasa
 */
public interface RoleService {
    List<Role> getAll() throws Exception;
}
