package Repositories;

import Models.Attendance;
import Models.EmployeeModel;
import Models.Penality;
import Models.Task;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeRepository {
    static int latestEmployeeID;
    public static void addAttendance(Timestamp from, int ID) {
        String insertSql = "INSERT INTO Attendances (entryTime,employeeID) VALUES ('"+from+"',"+ID+");";
        try{
            DatabaseQuery.executeInsert(insertSql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static void submitAttendance(Timestamp to) {
        latestEmployeeID = EmployeeRepository.lastAttendID();
        String updateSQL = "UPDATE Attendances SET exitTime='"+to+"' WHERE id_attend="+latestEmployeeID+"";
        try{
            DatabaseQuery.executeUpdate(updateSQL);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    
    public static double getWorkingHrsPerMonth(int id_employee, int month) {
        Attendance attendance = new Attendance(id_employee);
        double sum = 0;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        Date monthStart = new Date(year - 1900, month - 1, 1);
        Date monthEnd = new Date(year - 1900, (month), 1);
        String selectSql = "SELECT * FROM Attendances WHERE employeeID=" + id_employee
                         + " AND  entryTime between ' " + monthStart + " ' and '" + monthEnd + "'";
        try{
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                Timestamp from = resultSet.getTimestamp("entryTime");
                Timestamp to = resultSet.getTimestamp("exitTime");
                if(to != null && from != null)
                    sum = sum + attendance.getWorkingHours(from, to);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return  Double.parseDouble(new DecimalFormat("#.##").format(sum));
    }

    public static int lastAttendID() {
        int attendanceID = 0;
        String selectSql = "select TOP 1 id_attend from Attendances order by id_attend DESC";
        try{
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                attendanceID = resultSet.getInt("id_attend");
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return attendanceID;
    }
    
    public static List<Task> getNotCompletedTasksForEmployee(int id_employee) {
        List<Task> tasks = new ArrayList<>();
        String selectSql = "SELECT * FROM task WHERE id_employee="+ id_employee +" AND completed_task=0";
        try{
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int taskID = resultSet.getInt("id_task");
                String taskInfo = resultSet.getString("explanation");
                int employeeID = resultSet.getInt("id_employee");
                String taskName = resultSet.getString("task_name");
                boolean isCompleted = resultSet.getBoolean("completed_task");

                Task task = new Task(taskID, taskName, taskInfo, employeeID, isCompleted);
                tasks.add(task);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return tasks;
    }

    public static List<Task> getCompletedTasksForEmployee(int id_employee) {
        List<Task> tasks = new ArrayList<>();
        
        String selectSql = "SELECT * FROM task WHERE id_employee="+id_employee+" AND completed_task=1";
        try{
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int taskID = resultSet.getInt("id_task");
                String taskInfo = resultSet.getString("explanation");
                int employeeID = resultSet.getInt("id_employee");
                String taskName = resultSet.getString("task_name");
                boolean isCompleted = resultSet.getBoolean("completed_task");

                Task task = new Task(taskID, taskName, taskInfo, employeeID, isCompleted);
                tasks.add(task);
            }

            //  statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return tasks;
    }

    public static List<Penality> getPenalities(int id) {
        List<Penality> penalities = new ArrayList<>();
        try{
            String selectSql = "SELECT * FROM penalities where employee_id=" + id;
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                //System.out.println(resultSet.getString(1)+" "+ resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getString(6));
                int employeeID = resultSet.getInt("employee_id");
                String penalityReason = resultSet.getString("reason");
                int penalityID = resultSet.getInt("id_penality");
                String penalityAmount = resultSet.getString("penality");
                Penality penality = new Penality(penalityReason, penalityAmount, penalityID, employeeID);
                penalities.add(penality);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return penalities;

    }

    public static void submitCompletedTask(int id_task) {
        String updateSQL = "update Task set completed_task="+id_task+" WHERE id_task=" + id_task;
        try{
            DatabaseQuery.executeUpdate(updateSQL);
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void requestVacation(Date from, Date to, int id_employee) {
        String insertSql = "INSERT INTO vacation ([from], [to], employee_id) VALUES ('"+ from +"','"+ to +"',"+ id_employee +")";
        //String insertSql = "INSERT INTO vacation ('from', 'to' , id_employee,0 )";
        try{
            DatabaseQuery.executeInsert(insertSql);
        } // Handle any errors that may have occurred.
        catch (SQLException ex) {
            Logger.getLogger(EmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
