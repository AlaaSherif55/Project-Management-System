package Repositories;

import Models.Attendance;
import Models.EmployeeModel;
import Models.Penality;
import Models.Task;
import Models.TeamLeaderModel;
import Models.Vacation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeRepository {
    static int ID;
    public static void addAttendance(Timestamp from, int ID) {
        String insertSql = "INSERT INTO Attendances (entryTime,employeeID) VALUES ('"+from+"',"+ID+");";
        try{
            DatabaseQuery.executeInsert(insertSql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void submitAttendance(Timestamp to) {
        ID = EmployeeRepository.lastAttendID();
        String query = "UPDATE Attendances SET exitTime='"+to+"' WHERE id_attend="+ID+"";
        try{
            DatabaseQuery.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public static List<Task> getNotCompletedTasksForEmployee(int id_employee) {
        List<Task> taskList = new ArrayList<Task>();
        ResultSet resultSet = null;
        String selectSql = "SELECT * FROM task WHERE id_employee="+id_employee+" AND completed_task=0";
        try{
            resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int id_t = resultSet.getInt("id_task");
                String info = resultSet.getString("explanation");
                int id_e = resultSet.getInt("id_employee");
                String name = resultSet.getString("task_name");
                boolean isCompleted = resultSet.getBoolean("completed_task");

                Task task = new Task(id_t, name, info, id_e, isCompleted);
                taskList.add(task);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return taskList;
    }

    public static List<Task> getCompletedTasksForEmployee(int id_employee) {
        List<Task> taskList = new ArrayList<>();
        ResultSet resultSet = null;
        String selectSql = "SELECT * FROM task WHERE id_employee="+id_employee+" AND completed_task=1";
        try{
            resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int id_t = resultSet.getInt("id_task");
                String info = resultSet.getString("explanation");
                int id_e = resultSet.getInt("id_employee");
                String name = resultSet.getString("task_name");
                boolean isCompleted = resultSet.getBoolean("completed_task");

                Task task = new Task(id_t, name, info, id_e, isCompleted);
                taskList.add(task);
            }

            //  statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return taskList;
    }

    public static List<Penality> getPenalities(int id) {
        List<Penality> penality = new ArrayList<>();
        ResultSet resultSet = null;
        try{
            String selectSql = "SELECT * FROM penalities where employee_id=" + id;
            resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                //System.out.println(resultSet.getString(1)+" "+ resultSet.getString(2)+" "+resultSet.getString(3)+" "+resultSet.getString(4)+" "+resultSet.getString(5)+" "+resultSet.getString(6));
                int id_e = resultSet.getInt("employee_id");
                String reason = resultSet.getString("reason");
                int id_penality = resultSet.getInt("id_penality");
                String pen = resultSet.getString("penality");
                Penality p = new Penality(reason, pen, id_penality, id_e);
                penality.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return penality;

    }

    public static void submitCompletedTask(int id_task) {
        String query = "update Task set completed_task="+id_task+" WHERE id_task=" + id_task;
        try ( Connection connection = DriverManager.getConnection(DatabaseQuery.CONNECTIONURL);  Statement statement = connection.createStatement();) {
            DatabaseQuery.executeUpdate(query);
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

    @SuppressWarnings("empty-statement")
    public static double getWorkingHrsPerMonth(int id_employee, int month) {
        Attendance attendance = new Attendance(id_employee);
        double sum = 0;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        Date monthStart = new Date(year - 1900, month - 1, 1);
        Date monthEnd = new Date(year - 1900, (month), 1);
        ResultSet resultSet = null;
        String selectSql = "SELECT * FROM Attendances WHERE employeeID=" + id_employee
                         + " AND  entryTime between ' " + monthStart + " ' and '" + monthEnd + "'";
        try{
            resultSet = DatabaseQuery.executeSelect(selectSql);
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
        int ID = 0;
        ResultSet resultSet = null;
        String selectSql = "select TOP 1 id_attend from Attendances order by id_attend DESC";
        try{
            resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                ID = resultSet.getInt("id_attend");
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ID;
    }

}
