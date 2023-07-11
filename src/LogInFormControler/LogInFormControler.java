package LogInFormControler;

import applicationSession.ApplicationSession;
import domain.Employee;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import serviceImpl.UserProfileServiceImpl;
import domain.UserProfile;
import domain.Role;
import genericService.UserProfileService;
import ui.main.form.MainForm;

/**
 *
 * @author Jelena Basaric
 */
public class LogInFormControler {

    public static void login(javax.swing.JTextField txtEmail, javax.swing.JPasswordField txtPassword, JFrame loginForm) {
        //proveri da li korisnik postoji u sistemu
        UserProfileService userProfileService = new UserProfileServiceImpl();

        String email = txtEmail.getText().trim();
        String password = String.valueOf(txtPassword.getPassword());
        try {
            UserProfile userProfile = userProfileService.login(email, password);

            System.out.println(userProfile.getEmployee().getFirstName() + ", " + userProfile.getEmployee().getLastName());
            System.out.println("Roles:");
            List<Role> roles = userProfile.getRoles();
            for (Role role : roles) {
                System.out.println(role);
            }

            //postavi trenutno prijavljenog korisnika u SESSION objekat
            ApplicationSession.getInstance().setLoginUser(userProfile);

            new MainForm().setVisible(true);
            loginForm.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

}
