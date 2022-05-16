package Models;

import Controllers.LoginController;
import java.sql.SQLException;
//import java.util.*;
//import java.time.*;
//import java.sql.Date;
//import java.sql.Timestamp;
import Views.Frames.LoginView;


public class ProjectManagementSystem {

    public static void main(String[] args) throws SQLException {
        LoginView view = new LoginView();
        PersonModel model = new PersonModel();
        LoginController controller = new LoginController(view, model);
        view.setVisible(true);
    }
    
  
}
