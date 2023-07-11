package main;

import javax.swing.JFrame;
import ui.form.guest.GuestAddForm;
import ui.main.form.MainForm;
import userLogIn.LoginForm;

/**
 *
 * @author Jelena Basaric
 */
public class Start {
    public static void main(String[] args)throws Exception {
       
        JFrame mainForm = new LoginForm();
        mainForm.setVisible(true);
    
    }
    
}
