package Controllers;

import Models.*;
import Models.PersonModel;
import Views.Frames.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

public class LoginController {

    private LoginView loginView;
    private PersonModel loginModel;

    public LoginController(LoginView view, PersonModel model) {
        this.loginView = view;
        this.loginModel = model;

        this.loginView.addLoginButtonActionListener(new LoginButtonActionListener());
    }

    class LoginButtonActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (!loginView.getPasswordInput().equals("") && !loginView.getUsernameInput().equals("")) {

                try {
                    loginModel = PersonModel.login(loginView.getPasswordInput(), loginView.getUsernameInput());

                    if ("Admin".equals(loginModel.getRole())) {
                        loginView.setVisible(false);
                        AdminModel adminModel = AdminModel.createFromPerson(loginModel);
                        AdminView adminView = new AdminView();
                        AdminController adminController = new AdminController(adminView, adminModel);
                        
                        adminView.setVisible(true);
                    } else if ("Employee".equals(loginModel.getRole())) {
                        loginView.setVisible(false);
                        
                        EmployeeModel employeeModel= EmployeeModel.createFromPerson(loginModel);
                        
                        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                        employeeModel.addAttendance(timestamp);
                        
                        EmployeeView employeeView = new EmployeeView();
                        EmployeeController employeeController = new EmployeeController(employeeView, employeeModel);
                        
                        employeeView.setVisible(true);
                    } else if ("Team Leader".equals(loginModel.getRole())) {
                        loginView.setVisible(false);
                        
                        TeamLeaderModel teamLeaderModel= TeamLeaderModel.createFromPerson(loginModel);
                        TeamLeaderView teamLeaderView = new TeamLeaderView();
                        TeamLeaderController teamLeaderController = new TeamLeaderController(teamLeaderView, teamLeaderModel);
                        
                        teamLeaderView.setVisible(true);
                    } else if ("Project Manager".equals(loginModel.getRole())) {
                        loginView.setVisible(false);
                        
                        ProjectManagerModel projectManagerModel= ProjectManagerModel.createFromPerson(loginModel);
                        ProjectManagerView projectManagerView = new ProjectManagerView();
                        ProjectManagerController projectManagerController = new ProjectManagerController(projectManagerView, projectManagerModel);
                        
                        projectManagerView.setVisible(true);
                    }
                } catch (Exception e) {
                    loginView.displayErrorMessage("Invalid Username and Password");
                }
            } else {
                loginView.displayErrorMessage("Please,fill all the field");
            }
        }
    }
}
