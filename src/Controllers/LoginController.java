package Controllers;

import Models.*;
import Models.PersonModel;
import Views.Frames.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

public class LoginController {

    private LoginView view;
    private PersonModel model;

    public LoginController(LoginView view, PersonModel model) {
        this.view = view;
        this.model = model;

        this.view.addLoginButtonActionListener(new LoginButtonActionListener());
    }

    class LoginButtonActionListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            if (!view.getPasswordInput().equals("") && !view.getUsernameInput().equals("")) {

                try {
                    model = PersonModel.login(view.getPasswordInput(), view.getUsernameInput());

                    if ("Admin".equals(model.getRole())) {
                        view.setVisible(false);
                        AdminModel adminModel = AdminModel.createFromPerson(model);
                        AdminView adminView = new AdminView();
                        AdminController adminController = new AdminController(adminView, adminModel);
                        
                        adminView.setVisible(true);
                    } else if ("Employee".equals(model.getRole())) {
                        view.setVisible(false);
                        
                        EmployeeModel employeeModel= EmployeeModel.createFromPerson(model);
                        
                        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                        employeeModel.addAttendance(timestamp);
                        
                        EmployeeView employeeView = new EmployeeView();
                        EmployeeController employeeController = new EmployeeController(employeeView, employeeModel);
                        
                        employeeView.setVisible(true);
                    } else if ("Team Leader".equals(model.getRole())) {
                        view.setVisible(false);
                        
                        TeamLeaderModel teamLeaderModel= TeamLeaderModel.createFromPerson(model);
                        TeamLeaderView teamLeaderView = new TeamLeaderView();
                        TeamLeaderController teamLeaderController = new TeamLeaderController(teamLeaderView, teamLeaderModel);
                        
                        teamLeaderView.setVisible(true);
                    } else if ("Project Manager".equals(model.getRole())) {
                        view.setVisible(false);
                        
                        ProjectManagerModel projectManagerModel= ProjectManagerModel.createFromPerson(model);
                        ProjectManagerView projectManagerView = new ProjectManagerView();
                        ProjectManagerController projectManagerController = new ProjectManagerController(projectManagerView, projectManagerModel);
                        
                        projectManagerView.setVisible(true);
                    }
                } catch (Exception e) {
                    view.displayErrorMessage("Invalid Username and Password");
                }
            } else {
                view.displayErrorMessage("Please,fill all the field");
            }
        }
    }
}
