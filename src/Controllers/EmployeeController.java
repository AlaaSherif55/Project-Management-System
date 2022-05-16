package Controllers;

import Models.PersonModel;
import Views.Frames.EmployeeView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Models.EmployeeModel;
import Models.Penality;
import Models.Task;
import Views.InternalFrames.EM_ManageTasks;
import Views.InternalFrames.EM_RequestVacation;
import Views.InternalFrames.EM_ViewPenalities;
import Views.InternalFrames.EM_WorkingHours;
import Views.Frames.LoginView;
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

    private EmployeeView view;
    private EmployeeModel model;
    EM_ManageTasks ManageTasksView;
    EM_RequestVacation RequestVacation;
    EM_ViewPenalities ViewPenalities;
    EM_WorkingHours WorkingHours;

    public EmployeeController(EmployeeView EmployeeView, EmployeeModel EmployeeModel) {
        this.view = EmployeeView;
        this.model = EmployeeModel;

        this.view.AddExitListener(new ExitButtonListener());
        this.view.AddManageTasksListener(new ManageTaskListener());
        this.view.AddRequestVacationsListener(new RequestVacationsListener());
        this.view.AddViewPenalitiesListener(new ViewPenalitiesListener());
        this.view.AddWorkingHoursListener(new WorkingHoursListener());

    }

    private void initializeManageTask() {
        ManageTasksView = new EM_ManageTasks();
        fillTaskTables();
        ManageTasksView.AddUpdateTaskListener(new UpdateTaskListener());
    }

    private void initializeRequestVacation() {
        RequestVacation = new EM_RequestVacation();
        RequestVacation.AddRequestVacationListener(new RequestVacationListener());
    }
    
    private void initializeViewPenalities(){
        ViewPenalities = new EM_ViewPenalities();
        fillPenalityTable();
    }
    
    private void initializeWorkingHours(){
        WorkingHours = new EM_WorkingHours();
        WorkingHours.AddIdentifyWorkingHoursListener(new WorkingHoursActionListener());
    }
    
    private void fillTaskTables() {
        JTable AssignedTasks = ManageTasksView.getAssignedTasks();
        JTable CompletedTasks = ManageTasksView.getCompletedTasks();

        List<Task> notCompletedTask = model.getNotCompletedTasksForEmployee(model.getID());
        List<Task> completedTask = model.getCompletedTasksForEmployee(model.getID());

        DefaultTableModel assignedTableodel = (DefaultTableModel) AssignedTasks.getModel();

        Object[] rowDataAssigned = new Object[4];
        notCompletedTask.stream().map(task -> {
            rowDataAssigned[0] = task.getTask_id();
            return task;
        }).map(task -> {
            rowDataAssigned[1] = task.getTask_name();
            return task;
        }).map(task -> {
            rowDataAssigned[2] = task.getTask_info();
            return task;
        }).forEachOrdered(_item -> {
            assignedTableodel.addRow(rowDataAssigned);
        });

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

        ManageTasksView.setAssignedTasks(AssignedTasks);
        ManageTasksView.setCompletedTasks(CompletedTasks);
    }

    private void fillPenalityTable() {
        JTable ViewPenalitiesTable = ViewPenalities.getViewPenalitiesButton();

        DefaultTableModel tableModel = (DefaultTableModel) ViewPenalitiesTable.getModel();

        Object rowData[] = new Object[5];
        List<Penality> penalities = model.getPenalities();
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

        ViewPenalities.setViewPenalitiesButton(ViewPenalitiesTable);
    }

    //MainFrames Listeners
    class ManageTaskListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            initializeManageTask();

            view.setManageTasksView(ManageTasksView);
            view.AddToDesktop(view.getManageTasksView());
            view.getManageTasksView().setVisible(true);

        }

    }

    class RequestVacationsListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            initializeRequestVacation();

            view.setRequestVacationsView(RequestVacation);
            view.AddToDesktop(view.getRequestVacationsView());
            view.getRequestVacationsView().setVisible(true);
        }

    }

    class ViewPenalitiesListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            initializeViewPenalities();
            
            view.setViewPenalitiesView(ViewPenalities);
            view.AddToDesktop(view.getViewPenalitiesView());
            view.getViewPenalitiesView().setVisible(true);
        }

    }

    class WorkingHoursListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            initializeWorkingHours();
            
            view.setWorkingHoursView(WorkingHours);
            view.AddToDesktop(view.getWorkingHoursView());
            view.getWorkingHoursView().setVisible(true);
        }

    }

    class ExitButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            model.submitAttendance(timestamp);
            System.exit(0);
        }

    }

    //InternalFrames Listeners
    class UpdateTaskListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JTable AssignedTasks = ManageTasksView.getAssignedTasks();
            JTable CompletedTasks = ManageTasksView.getCompletedTasks();

            TableModel tableModel = AssignedTasks.getModel();

            int i = AssignedTasks.getSelectedRow();

            model.submitCompletedTask(Integer.parseInt(tableModel.getValueAt(i, 0).toString()));
            DefaultTableModel model1 = (DefaultTableModel) CompletedTasks.getModel();

            Object rowDate1[] = new Object[3];
            rowDate1[0] = Integer.parseInt(tableModel.getValueAt(i, 0).toString());
            rowDate1[1] = tableModel.getValueAt(i, 1).toString();
            rowDate1[2] = tableModel.getValueAt(i, 2).toString();
            model1.addRow(rowDate1);

            DefaultTableModel model2 = (DefaultTableModel) AssignedTasks.getModel();
            Object rowDate[] = new Object[4];
            rowDate[0] = Integer.parseInt(tableModel.getValueAt(i, 0).toString());
            rowDate[1] = tableModel.getValueAt(i, 1).toString();
            rowDate[2] = tableModel.getValueAt(i, 2).toString();
            if (AssignedTasks.getSelectedRowCount() == 1) {
                model2.removeRow(AssignedTasks.getSelectedRow());
            }

            ManageTasksView.setAssignedTasks(AssignedTasks);
            ManageTasksView.setCompletedTasks(CompletedTasks);
        }

    }

    class RequestVacationListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JCalendar jCalendar1 = RequestVacation.getjCalendar1();
            JCalendar jCalendar2 = RequestVacation.getjCalendar2();

            java.util.Date utilDate1 = new java.util.Date(jCalendar1.getYearChooser().getValue() - 1900, jCalendar1.getMonthChooser().getMonth(), jCalendar1.getDayChooser().getDay());
            java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
            java.util.Date utilDate = new java.util.Date(jCalendar2.getYearChooser().getValue() - 1900, jCalendar2.getMonthChooser().getMonth(), jCalendar2.getDayChooser().getDay());
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            model.requestVacation(sqlDate1, sqlDate);
            JOptionPane.showMessageDialog(null, "This vacation has been requested successfully", "SUCCESS", JOptionPane.INFORMATION_MESSAGE);

        }

    }

    class WorkingHoursActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JComboBox<String> Month = WorkingHours.getMonthComboBox();
            JTextField workingHoursText = WorkingHours.getjWorkingHours();
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

            double Hours = model.getWorkingHrsPerMonth(model.getID(), monthValue);
            workingHoursText.setText("" + Hours);
            WorkingHours.setjWorkingHours(workingHoursText);
        }

    }
}
