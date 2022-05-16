package Controllers;

import Models.EmployeeModel;
import Models.ProjectManagerModel;
import Models.Task;
import Views.InternalFrames.PM_Project;
import Views.InternalFrames.PM_ReportEmployee;
import Views.Frames.ProjectManagerView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ProjectManagerController {

    private ProjectManagerView ProjectManagerView;
    private ProjectManagerModel ManagerModel;
    private PM_Project PM_Project;
    private PM_ReportEmployee PM_ReportEmployee;

    public ProjectManagerController(ProjectManagerView ProjectManagerView, ProjectManagerModel Model) {
        this.ProjectManagerView = ProjectManagerView;
        this.ManagerModel = Model;

        this.ProjectManagerView.AddReportEmployeeListener(new ReportEmployeeViewListener());
        this.ProjectManagerView.AddViewProjectListener(new ViewProjectListener());
    }

    private void initializeViewProject() {
        PM_Project = new PM_Project();
        fillProjectsTable();
    }

    private void initializeReportEmployee() {
        PM_ReportEmployee = new PM_ReportEmployee();
        fillEmployeeTable();

        PM_ReportEmployee.AddReportActionListener(new ReportEmployeeActionListener());
        PM_ReportEmployee.AddSelectEmployeeListener(new SelectEmployeeListener());
    }

    private void fillProjectsTable() {
        JTable TaskTable = PM_Project.getTaskTable();

        DefaultTableModel tableModel = (DefaultTableModel) TaskTable.getModel();

        PM_Project.setProjectName(ManagerModel.getProject().getName());

        List<Task> tasks = ManagerModel.getTasksForProject();
        PM_Project.setCompletionBar((int) ManagerModel.getCompelationRate());
        PM_Project.setCompletionPercent("" + new DecimalFormat("#.##").format(ManagerModel.getCompelationRate()));

        Object rowData[] = new Object[8];
        tasks.stream().map(task -> {
            rowData[0] = task.getTask_id();
            return task;
        }).map(task -> {
            rowData[1] = task.getTask_name();
            return task;
        }).map(task -> {
            rowData[2] = task.getTask_info();
            return task;
        }).map(task -> {
            rowData[3] = task.isTask_completed();
            return task;
        }).map(task -> {
            rowData[4] = ManagerModel.findEmployeeById(task.getEmployee_id()).getName();
            return task;
        }).map(task -> {
            rowData[5] = ManagerModel.findEmployeeById(task.getEmployee_id()).getID();
            return task;
        }).map(task -> {
            rowData[6] = ManagerModel.findEmployeeById(ManagerModel.findEmployeeById(task.getEmployee_id()).getManagerid()).getName();
            return task;
        }).map(task -> {
            rowData[7] = ManagerModel.findEmployeeById(ManagerModel.findEmployeeById(task.getEmployee_id()).getManagerid()).getID();
            return task;
        }).forEachOrdered(_item -> {
            tableModel.addRow(rowData);
        });

        PM_Project.setTaskTable(TaskTable);
    }

    private void fillEmployeeTable() {
        JTable EmployeeTable = PM_ReportEmployee.getEmployeeTable();

        DefaultTableModel tableModel = (DefaultTableModel) EmployeeTable.getModel();
        List<EmployeeModel> employees = ManagerModel.getEmployees();
        Object rowDate[] = new Object[4];
        employees.stream().map(employee -> {
            rowDate[0] = employee.getID();
            return employee;
        }).map(employee -> {
            rowDate[1] = employee.getName();
            return employee;
        }).map(employee -> {
            rowDate[2] = employee.getAge();
            return employee;
        }).map(employee -> {
            rowDate[3] = employee.getManagerid();
            return employee;
        }).forEachOrdered(_item -> {
            tableModel.addRow(rowDate);
        });

        PM_ReportEmployee.setEmployeeTable(EmployeeTable);
    }
    
    //MainFrames Listeners
    class ViewProjectListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            initializeViewProject();
            ProjectManagerView.setViewProject(PM_Project);
            ProjectManagerView.AddToDesktop(ProjectManagerView.getViewProject());
            ProjectManagerView.getViewProject().setVisible(true);
        }

    }

    class ReportEmployeeViewListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            initializeReportEmployee();

            ProjectManagerView.setReportEmployee(PM_ReportEmployee);
            ProjectManagerView.AddToDesktop(ProjectManagerView.getReportEmployee());
            ProjectManagerView.getReportEmployee().setVisible(true);

        }

    }
    
    //InternalFrames Listeners
    class ReportEmployeeActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (!PM_ReportEmployee.getReportDetails().equals("") && !PM_ReportEmployee.getReportName().equals("")) {
                ManagerModel.ReportEmployee(Integer.parseInt(PM_ReportEmployee.getEmployeeID()), PM_ReportEmployee.getReportDetails(), PM_ReportEmployee.getReportName());
                resetPanelData();
                JOptionPane.showMessageDialog(null, "This report has been added successfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Please,fill all the fields", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        protected void resetPanelData() {
            PM_ReportEmployee.setReportName("");
            PM_ReportEmployee.setEmployeeName("");
            PM_ReportEmployee.setEmployeeID("");
            PM_ReportEmployee.setTMID("");
            PM_ReportEmployee.setTMName("");
            PM_ReportEmployee.setReportDetails("");
        }

    }

    class SelectEmployeeListener extends MouseAdapter {

        public void mouseClicked(MouseEvent evt) {
            JTable EmployeeTable = PM_ReportEmployee.getEmployeeTable();

            int selectedIndex = EmployeeTable.getSelectedRow();
            TableModel tableModel = EmployeeTable.getModel();
            PM_ReportEmployee.setEmployeeID(tableModel.getValueAt(selectedIndex, 0).toString());
            PM_ReportEmployee.setEmployeeName(tableModel.getValueAt(selectedIndex, 1).toString());
            PM_ReportEmployee.setTMID(tableModel.getValueAt(selectedIndex, 3).toString());
            PM_ReportEmployee.setTMName(ManagerModel.findEmployeeById(Integer.parseInt(PM_ReportEmployee.getTMID())).getName());

            PM_ReportEmployee.setEmployeeTable(EmployeeTable);

        }
    }
}
