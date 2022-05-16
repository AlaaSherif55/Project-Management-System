package Controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Views.InternalFrames.Admin_ManageUsers;
import Views.InternalFrames.Admin_Projects;
import Views.Frames.AdminView;
import Models.AdminModel;
import Models.PersonModel;
import Models.Project;
import Models.ProjectManagerModel;
import Models.Task;
import Models.TeamLeaderModel;
import Views.Panels.Add_User;
import Views.Panels.Update_Users;
import Views.Panels.View_Users;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AdminController {

    private AdminView adminView;
    private AdminModel adminModel;
    private Admin_ManageUsers admin_ManageUsers;
    private Admin_Projects admin_Projects;
    private Add_User add_User;
    private View_Users view_Users;
    private Update_Users update_Users;
    private JTable UsersTable;

    AdminController(AdminView view, AdminModel model) {
        this.adminView = view;
        this.adminModel = model;

        this.adminView.addViewProjectsActionListener(new ViewProjectsActionListener());
        this.adminView.addManageUsersActionListener(new ManageUsersActionListener());
    }

    private void setManageUsersPanels() {
        admin_ManageUsers.setP1(add_User);
        admin_ManageUsers.setP2(view_Users);
        admin_ManageUsers.setP3(update_Users);
    }

    private void showAddUserPanel() {
        add_User.setVisible(true);
        view_Users.setVisible(false);
        update_Users.setVisible(false);
    }

    //MainFrames Listeners
    class ViewProjectsActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            initializeViewProjects();

            adminView.setAdminProjectsView(admin_Projects);
            adminView.AddToDesktop(adminView.getAdminProjectsView());
            adminView.getAdminProjectsView().setVisible(true);
        }

        private void initializeViewProjects() {
            admin_Projects = new Admin_Projects();

            fillViewProjectsList();

            admin_Projects.AddSelectProjectListener(new ProjectListMouseListener());
        }

        @SuppressWarnings("unchecked")
        private void fillViewProjectsList() {
            JList<String> ProjectList = admin_Projects.getProjectList();

            List<Project> projects = AdminModel.getProjects();

            DefaultListModel listModel = new DefaultListModel();

            for (Project project : projects) {
                listModel.addElement(project.getName());
                ProjectList.setModel(listModel);
            }

            admin_Projects.setProjectList(ProjectList);
        }
    }

    class ManageUsersActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            initializeManageUsers();

            adminView.setAdminManageUsersView(admin_ManageUsers);
            adminView.AddToDesktop(adminView.getAdminManageUsersView());
            adminView.getAdminManageUsersView().setVisible(true);
        }

        private void initializeManageUsers() {
            admin_ManageUsers = new Admin_ManageUsers();

            add_User = new Add_User();
            view_Users = new View_Users();
            update_Users = new Update_Users();

            fillAddUserManagerNameCombobox();
            addListenersToManageUsersPanels();
            fillManageUsersDynamicPanel();

            addListenersToManageUsersFrame();
        }

        private void fillAddUserManagerNameCombobox() {
            JComboBox<String> ManagerName = add_User.getManagerName();

            List<PersonModel> manager = AdminModel.getUserByRole("Team Leader");
            System.out.println(manager.get(0).getManagerid());
            add_User.setProjectName(ProjectManagerModel.getProjectByID(manager.get(0).getManagerid()).getName());
            for (int i = 0; i < manager.size(); i++) {
                ManagerName.addItem(manager.get(i).getName());
            }

            add_User.setManagerName(ManagerName);
        }

        private void fillManageUsersDynamicPanel() {
            GridBagLayout layout = new GridBagLayout();

            JPanel DynamicPanel = admin_ManageUsers.getDynamicPanel();

            DynamicPanel.setLayout(layout);
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = 0;

            DynamicPanel.add(add_User, constraints);
            DynamicPanel.add(view_Users, constraints);
            DynamicPanel.add(update_Users, constraints);

            showAddUserPanel();
            setManageUsersPanels();

            admin_ManageUsers.setDynamicPanel(DynamicPanel);
        }

        private void addListenersToManageUsersPanels() {
            add_User.AddSelectManagerNameListener(new AddSelectManagerNameActionListener());
            add_User.AddEmployeeButtonListener(new AddUserButtonActionListener());
            add_User.AddSelectRoleListener(new AddSelectRoleActionListener());
            update_Users.AddSearchButtonListener(new SearchActionListener());
            update_Users.DeleteButtonListener(new DeleteActionListener());
            update_Users.UpdateButtonListener(new UpdateActionListener());
        }

        private void addListenersToManageUsersFrame() {
            admin_ManageUsers.AddAddUserListener(new AddUserActionListener());
            admin_ManageUsers.AddUpdateUserListener(new UpdateUserActionListener());
            admin_ManageUsers.AddViewUsersListener(new ViewUserActionListener());
        }

    }

    //InternalFrames && Panels Listeners
    class AddUserActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            showAddUserPanel();
            setManageUsersPanels();
        }
    }

    class ViewUserActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            fillViewUsersTable();
            initializeViewUsersDynamicPanel();
            showViewUserPanel();

            setManageUsersPanels();
        }

        private void fillViewUsersTable() {
            UsersTable = view_Users.getUsersTable();

            DefaultTableModel tableModel = (DefaultTableModel) UsersTable.getModel();
            List<PersonModel> users = AdminModel.getUsers();
            tableModel.setRowCount(0);
            Object[] rowData = new Object[7];
            users.stream().map(user -> {
                rowData[0] = user.getID();
                return user;
            }).map(user -> {
                rowData[1] = user.getName();
                return user;
            }).map(user -> {
                rowData[2] = user.getAge();
                return user;
            }).map(user -> {
                rowData[3] = user.getUsername();
                return user;
            }).map(user -> {
                rowData[4] = user.getPassword();
                return user;
            }).map(user -> {
                rowData[5] = user.getSalary();
                return user;
            }).map(user -> {
                rowData[6] = user.getRole();
                return user;
            }).forEachOrdered(_item -> {
                tableModel.addRow(rowData);
            });

            view_Users.setUsersTable(UsersTable);
        }

        private void initializeViewUsersDynamicPanel() {
            JPanel DynamicPanel = admin_ManageUsers.getDynamicPanel();

            GridBagConstraints constraints = new GridBagConstraints();
            constraints.gridx = 0;
            constraints.gridy = 0;

            DynamicPanel.add(view_Users, constraints);
            admin_ManageUsers.setDynamicPanel(DynamicPanel);
        }

        private void showViewUserPanel() {
            add_User.setVisible(false);
            view_Users.setVisible(true);
            update_Users.setVisible(false);
        }
    }

    class UpdateUserActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            showUpdateUserPanel();
            setManageUsersPanels();
        }

        private void showUpdateUserPanel() {
            add_User.setVisible(false);
            view_Users.setVisible(false);
            update_Users.setVisible(true);
        }
    }

    class ProjectListMouseListener extends MouseAdapter {

        public void mouseClicked(MouseEvent evt) {
            JList<String> ProjectList = admin_Projects.getProjectList();
            JTable TaskTable = admin_Projects.getTaskTable();

            String projectName = (String) ProjectList.getSelectedValue();
            Project project = AdminModel.getProjectByName(projectName);
            List<Task> tasks = AdminModel.getTaskToOneProject(project.getName());

            setProjectInfo(project);

            DefaultTableModel tableModel = (DefaultTableModel) TaskTable.getModel();
            tableModel.setRowCount(0);

            tasks.stream().map(task -> {
                Object rowData[] = new Object[7];
                rowData[0] = task.getTask_id();
                rowData[1] = task.getTask_name();
                rowData[2] = AdminModel.findUserById(task.getEmployee_id()).getName();
                rowData[3] = task.getEmployee_id();
                rowData[4] = task.isTask_completed();
                rowData[5] = AdminModel.findUserById(AdminModel.findUserById(task.getEmployee_id()).getManagerid()).getName();
                rowData[6] = AdminModel.findUserById(AdminModel.findUserById(task.getEmployee_id()).getManagerid()).getID();
                return rowData;
            }).forEachOrdered(rowDate1 -> {
                tableModel.addRow(rowDate1);
            });

            admin_Projects.setTaskTable(TaskTable);

        }
        
        private void setProjectInfo(Project project) {
            admin_Projects.setPMName(AdminModel.findUserById(project.getPmId()).getName());
            admin_Projects.setPMID("" + project.getPmId());
            admin_Projects.setProjectName(project.getName());
            admin_Projects.setCompletionBar((int) AdminModel.getCompelationRateByProjectName(project.getName()));
            admin_Projects.setjCompletionPercent(new DecimalFormat("#.##").format(AdminModel.getCompelationRateByProjectName(project.getName())) + "%");
        }
    }

    class AddUserButtonActionListener implements ActionListener {

        JComboBox<String> ManagerName = add_User.getManagerName();
        JComboBox<String> RoleBox = add_User.getRoleBox();

        public void actionPerformed(ActionEvent e) {
            if (!add_User.getFirstName().equals("") && !add_User.getLastName().equals("") && !add_User.getAge().equals("") && !add_User.getUsername().equals("") && !add_User.getPassword().equals("") && !add_User.getSalary().equals("") && !add_User.getProjectName().equals("")) {
                try {

                    PersonModel person = PersonModel.preparePersonForDatabase(add_User.getFirstName() + " " + add_User.getLastName(), Integer.parseInt(add_User.getAge()), add_User.getUsername(), add_User.getPassword(), RoleBox.getSelectedItem().toString(), Double.parseDouble(add_User.getSalary()));

                    if (RoleBox.getSelectedItem().equals("Project Manager")) {
                        AdminModel.addProjectManager(person.getName(), person.getAge(), person.getUsername(), "" + add_User.getPassword(), person.getRole(), person.getSalary());
                        for (PersonModel user : AdminModel.getUsers()) {
                            if (user.getUsername().equals(person.getUsername())) {
                                AdminModel.createProject(user.getID(), add_User.getProjectName());
                            }
                        }
                    } else {
                        PersonModel manager = AdminModel.findUserByName(ManagerName.getSelectedItem().toString());
                        person.setManagerid(manager.getID());
                        AdminModel.addUser(person);
                    }
                    resetPanelData();
                    JOptionPane.showMessageDialog(null, "This Person has been added successfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please,fill all the fields", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        protected void resetPanelData() {
            add_User.setFirstName("");
            add_User.setLastName("");
            add_User.setAge("");
            add_User.setUsername("");
            add_User.setPassword("");
            add_User.setSalary("");
            RoleBox.setSelectedIndex(0);
            ManagerName.setSelectedItem("");
            add_User.setManagerName(ManagerName);
            add_User.setRoleBox(RoleBox);
        }
    }

    class AddSelectRoleActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JComboBox<String> ManagerName = add_User.getManagerName();
            JComboBox<String> jRoleBox = add_User.getRoleBox();

            ManagerName.removeAllItems();
            if (jRoleBox.getSelectedItem().equals("Employee")) {
                List<PersonModel> manager = AdminModel.getUserByRole("Team Leader");
                for (int i = 0; i < manager.size(); i++) {
                    ManagerName.addItem(manager.get(i).getName());
                    ManagerName.setSelectedIndex(0);
                }
            } else if (jRoleBox.getSelectedItem().equals("Team Leader")) {
                List<PersonModel> manager = AdminModel.getUserByRole("Project Manager");
                for (int i = 0; i < manager.size(); i++) {
                    ManagerName.addItem(manager.get(i).getName());
                    ManagerName.setSelectedIndex(0);
                }
            }

            if (jRoleBox.getSelectedItem().equals("Project Manager")) {
                add_User.setProjectNameActive(true);
            } else {
                add_User.setProjectNameActive(false);
            }

            add_User.setManagerName(ManagerName);
            add_User.setRoleBox(jRoleBox);
        }

    }

    class AddSelectManagerNameActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JComboBox<String> ManagerName = add_User.getManagerName();
            JComboBox<String> jRoleBox = add_User.getRoleBox();
            if (ManagerName.getSelectedItem() == null) {
                return;
            }
            if (jRoleBox.getSelectedItem().equals("Employee")) {
                List<PersonModel> manager = AdminModel.getUserByRole("Team Leader");
                for (int i = 0; i < manager.size(); i++) {
                    if (ManagerName.getSelectedItem().equals(manager.get(i).getName())) {
                        add_User.setProjectName(ProjectManagerModel.getProjectByID(manager.get(i).getManagerid()).getName());
                    }
                }
            } else if (jRoleBox.getSelectedItem().equals("Team Leader")) {
                List<PersonModel> manager = AdminModel.getUserByRole("Project Manager");
                for (int i = 0; i < manager.size(); i++) {
                    if (ManagerName.getSelectedItem().equals(manager.get(i).getName())) {
                        add_User.setProjectName(ProjectManagerModel.getProjectByID(manager.get(i).getID()).getName());
                    }
                }

            }

            add_User.setManagerName(ManagerName);
            add_User.setRoleBox(jRoleBox);
        }

    }

    class SearchActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                update_Users.resetPanelData();
                if (!update_Users.getSearchField().equals("")) {

                    PersonModel returned = AdminModel.findUserById(Integer.parseInt(update_Users.getSearchField()));
                    if (returned.getID() > 0) {
                        setPanelDate(returned);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "please enter data..", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception a) {
                JOptionPane.showMessageDialog(null, "Wrong ID.." + a.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

            }
        }

        protected void setPanelDate(PersonModel person) {
            update_Users.setID("" + person.getID());
            update_Users.setFirstName(person.getName().split(" ")[0]);
            update_Users.setLastName(person.getName().split(" ")[1]);
            update_Users.setAge("" + person.getAge());
            update_Users.setUsername("" + person.getUsername());
            update_Users.setPassword("" + person.getPassword());
            update_Users.setSalary("" + person.getSalary());
            if (person.getRole().equals("Team Leader")) {
                update_Users.setProjectNameActive(false);
                update_Users.setProjectName(ProjectManagerModel.getProjectByID(person.getManagerid()).getName());
            } else if (person.getRole().equals("Project Manager")) {
                update_Users.setProjectNameActive(true);
                update_Users.setProjectName(ProjectManagerModel.getProjectByID(person.getID()).getName());
            } else {
                update_Users.setProjectNameActive(false);
                PersonModel leader = AdminModel.findUserById(person.getManagerid());
                update_Users.setProjectName(ProjectManagerModel.getProjectByID(leader.getManagerid()).getName());
            }
            update_Users.setRole(person.getRole());
        }

    }

    class UpdateActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (!update_Users.getID().equals("") && !update_Users.getFirstName().equals("") && !update_Users.getLastName().equals("")
                    && !update_Users.getAge().equals("") && !update_Users.getUsername().equals("") && !update_Users.getPassword().equals("")
                    && !update_Users.getSalary().equals("")) {
                try {
                    PersonModel person = PersonModel.preparePersonForDatabase(update_Users.getFirstName() + " " + update_Users.getLastName(),
                            Integer.parseInt(update_Users.getAge()), update_Users.getUsername(), update_Users.getPassword(), update_Users.getRole(),
                            Double.parseDouble(update_Users.getSalary()));

                    if (update_Users.getRole().equals("Project Manager")) {
                        AdminModel.updateProject(person.getID(), update_Users.getProjectName());
                    }
                    AdminModel.UpdateUser(person);
                    update_Users.resetPanelData();
                    JOptionPane.showMessageDialog(null, "This Employee has been updated successfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Please,fill all the fields", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    class DeleteActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (!update_Users.getID().equals("") && !update_Users.getFirstName().equals("") && !update_Users.getAge().equals("") && !update_Users.getUsername().equals("") && !update_Users.getPassword().equals("") && !update_Users.getSalary().equals("")) {
                AdminModel.deleteUser(Integer.parseInt(update_Users.getSearchField()));
                update_Users.resetPanelData();
                JOptionPane.showMessageDialog(null, "This user has been deleted successfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}
