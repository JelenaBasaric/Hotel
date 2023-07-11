/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package genericService;

import domain.UserProfile;

/**
 *
 * @author korisnik
 */
public interface UserProfileService {
    UserProfile login(String email, String password) throws Exception;
}
