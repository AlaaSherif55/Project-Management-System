package Controllers;

import Views.Frames.EmployeeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Models.EmployeeModel;
import Models.Penality;
import Models.Task;
import Models.Vacation;
import Views.InternalFrames.EM_ManageTasks;
import Views.InternalFrames.EM_RequestVacation;
import Views.InternalFrames.EM_ViewPenalities;
import Views.InternalFrames.EM_WorkingHours;
import com.toedter.calendar.JCalendar;
import java.sql.Timestamp;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class EmployeeController {

    private EmployeeView employeeView;
    private EmployeeModel employeeModel;
    EM_ManageTasks manageTasksView;
    EM_RequestVacation requestVacation;
    EM_ViewPenalities viewPenalities;
    EM_WorkingHours workingHours;

    public EmployeeController(EmployeeView EmployeeView, EmployeeModel EmployeeModel) {
        this.employeeView = EmployeeView;
        this.employeeModel = EmployeeModel;

        addAllEmployeeViewFrameListeners();
    }

    private void addAllEmployeeViewFrameListeners() {
        this.employeeView.AddExitListener(new ExitButtonListener());
        this.employeeView.AddManageTasksListener(new ManageTaskListener());
        this.employeeView.AddRequestVacationsListener(new RequestVacationsListener());
        this.employeeView.AddViewPenalitiesListener(new ViewPenalitiesListener());
        this.employeeView.AddWorkingHoursListener(new WorkingHoursListener());
    }

    //MainFrames Listeners
    class ManageTaskListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            initializeManageTask();

            employeeView.setManageTasksView(manageTasksView);
            employeeView.AddToDesktop(employeeView.getManageTasksView());
            employeeView.getManageTasksView().setVisible(true);

        }

        private void initializeManageTask() {
            manageTasksView = new EM_ManageTasks();
            fillAssignedTasks();
            fillCompletedTasks();
            manageTasksView.AddUpdateTaskListener(new UpdateTaskListener());
        }

        private void fillAssignedTasks() {
            JTable AssignedTasks = manageTasksView.getAssignedTasks();
            List<Task> notCompletedTasks = employeeModel.getNotCompletedTasksForEmployee(employeeModel.getID());

            DefaultTableModel assignedTableModel = (DefaultTableModel) AssignedTasks.getModel();

            Object[] rowDataAssigned = new Object[4];
            notCompletedTasks.stream().map(task -> {
                rowDataAssigned[0] = task.getTask_id();
                return task;
            }).map(task -> {
                rowDataAssigned[1] = task.getTask_name();
                return task;
            }).map(task -> {
                rowDataAssigned[2] = task.getTask_info();
                return task;
            }).forEachOrdered(_item -> {
                assignedTableModel.addRow(rowDataAssigned);
            });

            manageTasksView.setAssignedTasks(AssignedTasks);
        }

        private void fillCompletedTasks() {

            JTable CompletedTasks = manageTasksView.getCompletedTasks();

            List<Task> completedTask = employeeModel.getCompletedTasksForEmployee(employeeModel.getID());

            DefaultTableModel completedTableodel = (DefaultTableModel) CompletedTasks.getModel();

            Object rowDataCompleted[] = new Object[4];
            completedTask.stream().map(task -> {
                rowDataCompleted[0] = task.getTask_id();
                return task;
            }).map(task -> {
                rowDataCompleted[1] = task.getTask_name();
                return task;
            }).map(task -> {
                rowDataCompleted[2] = task.getTask_info();
                return task;
            }).forEachOrdered(_item -> {
                completedTableodel.addRow(rowDataCompleted);
            });

            manageTasksView.setCompletedTasks(CompletedTasks);
        }
    }

    class RequestVacationsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            initializeRequestVacation();

            employeeView.setRequestVacationsView(requestVacation);
            employeeView.AddToDesktop(employeeView.getRequestVacationsView());
            employeeView.getRequestVacationsView().setVisible(true);
        }

        private void initializeRequestVacation() {
            requestVacation = new EM_RequestVacation();
            requestVacation.AddRequestVacationListener(new RequestVacationListener());
        }
    }

    class ViewPenalitiesListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            initializeViewPenalities();

            employeeView.setViewPenalitiesView(viewPenalities);
            employeeView.AddToDesktop(employeeView.getViewPenalitiesView());
            employeeView.getViewPenalitiesView().setVisible(true);
        }

        private void initializeViewPenalities() {
            viewPenalities = new EM_ViewPenalities();
            fillPenalityTable();
        }

        private void fillPenalityTable() {
            JTable penalitiesTable = viewPenalities.getViewPenalitiesButton();

            DefaultTableModel tableModel = (DefaultTableModel) penalitiesTable.getModel();

            Object rowData[] = new Object[5];
            List<Penality> penalities = employeeModel.getPenalities();
            penalities.stream().map(penality -> {
                rowData[0] = penality.getPenalityID();
                return penality;
            }).map(penality -> {
                rowData[1] = penality.getReason();
                return penality;
            }).map(penality -> {
                rowData[2] = penality.getPenality();
                return penality;
            }).forEachOrdered(_item -> {
                tableModel.addRow(rowData);
            });

            viewPenalities.setViewPenalitiesButton(penalitiesTable);
        }
    }

    class WorkingHoursListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            initializeWorkingHours();

            employeeView.setWorkingHoursView(workingHours);
            employeeView.AddToDesktop(employeeView.getWorkingHoursView());
            employeeView.getWorkingHoursView().setVisible(true);
        }

        private void initializeWorkingHours() {
            workingHours = new EM_WorkingHours();
            workingHours.AddIdentifyWorkingHoursListener(new WorkingHoursActionListener());
        }

    }

    class ExitButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            employeeModel.submitAttendance(timestamp);
            System.exit(0);
        }

    }

    //InternalFrames Listeners
    class UpdateTaskListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            updateCompletedTasksTable();
            updateAssignedTasksTable();
        }

        private void updateAssignedTasksTable() {
            JTable AssignedTasks = manageTasksView.getAssignedTasks();

            TableModel tableModel = AssignedTasks.getModel();
            int selectedIndex = AssignedTasks.getSelectedRow();

            DefaultTableModel assignedModel = (DefaultTableModel) AssignedTasks.getModel();
            Object rowDate[] = new Object[4];
            rowDate[0] = Integer.parseInt(tableModel.getValueAt(selectedIndex, 0).toString());
            rowDate[1] = tableModel.getValueAt(selectedIndex, 1).toString();
            rowDate[2] = tableModel.getValueAt(selectedIndex, 2).toString();
            if (AssignedTasks.getSelectedRowCount() == 1) {
                assignedModel.removeRow(AssignedTasks.getSelectedRow());
            }

            manageTasksView.setAssignedTasks(AssignedTasks);
        }

        private void updateCompletedTasksTable() {
            JTable AssignedTasks = manageTasksView.getAssignedTasks();
            JTable CompletedTasks = manageTasksView.getCompletedTasks();

            TableModel tableModel = AssignedTasks.getModel();

            int i = AssignedTasks.getSelectedRow();

            employeeModel.submitCompletedTask(Integer.parseInt(tableModel.getValueAt(i, 0).toString()));
            DefaultTableModel completedModel = (DefaultTableModel) CompletedTasks.getModel();

            Object rowDate1[] = new Object[3];
            rowDate1[0] = Integer.parseInt(tableModel.getValueAt(i, 0).toString());
            rowDate1[1] = tableModel.getValueAt(i, 1).toString();
            rowDate1[2] = tableModel.getValueAt(i, 2).toString();
            completedModel.addRow(rowDate1);

            manageTasksView.setCompletedTasks(CompletedTasks);
        }

    }

    class RequestVacationListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JCalendar fromCalender = requestVacation.getFromCalendar();
            JCalendar toCalender = requestVacation.getToCalendar();

            java.util.Date utilDate1 = new java.util.Date(fromCalender.getYearChooser().getValue() - 1900, fromCalender.getMonthChooser().getMonth(), fromCalender.getDayChooser().getDay());
            java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
            java.util.Date utilDate = new java.util.Date(toCalender.getYearChooser().getValue() - 1900, toCalender.getMonthChooser().getMonth(), toCalender.getDayChooser().getDay());
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            int vacationStatus = employeeModel.requestVacation(sqlDate1, sqlDate);
            Vacation vacation = employeeModel.getVacation();
            if(vacationStatus == -1)
                JOptionPane.showMessageDialog(null, "This vacation has been requested successfully from "+vacation.getVacationStart()+" to "+ vacation.getVacationEnd(), "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
            if(vacationStatus == 1)
                JOptionPane.showMessageDialog(null, "You already have a vacation request accepted from "+vacation.getVacationStart()+" to "+ vacation.getVacationEnd(), "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
            if(vacationStatus == 0)
                JOptionPane.showMessageDialog(null, "You already have a vacation request on hold from "+vacation.getVacationStart()+" to "+ vacation.getVacationEnd(), "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    class WorkingHoursActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JComboBox<String> Month = workingHours.getMonthComboBox();
            JTextField workingHoursText = workingHours.getWorkingHours();
            String month = Month.getSelectedItem().toString();
            int monthValue = 0;
            switch (month) {
                case "January":
                    monthValue = 1;
                    break;
                case "February":
                    monthValue = 2;
                    break;
                case "March":
                    monthValue = 3;
                    break;
                case "April":
                    monthValue = 4;
                    break;
                case "May":
                    monthValue = 5;
                    break;
                case "June":
                    monthValue = 6;
                    break;
                case "July":
                    monthValue = 7;
                    break;
                case "August":
                    monthValue = 8;
                    break;
                case "September":
                    monthValue = 9;
                    break;
                case "October":
                    monthValue = 10;
                    break;
                case "November":
                    monthValue = 11;
                    break;
                case "December":
                    monthValue = 12;
                    break;

            }

            double Hours = employeeModel.getWorkingHrsPerMonth(employeeModel.getID(), monthValue);
            workingHoursText.setText("" + Hours);
            workingHours.setWorkingHours(workingHoursText);
        }

    }
}
