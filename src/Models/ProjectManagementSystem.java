package Models;

import Controllers.LoginController;
import java.sql.SQLException;
import Views.Frames.LoginView;


public class ProjectManagementSystem {

    public static void main(String[] args) throws SQLException {
        LoginView view = new LoginView();
        PersonModel model = PersonModel.createEmptyForLogin();
        LoginController controller = new LoginController(view, model);
        view.setVisible(true);
    }
    
  
}
