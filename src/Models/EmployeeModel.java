package Models;
import Repositories.EmployeeRepository;
import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDateTime;

public class EmployeeModel extends PersonModel {

    public EmployeeModel(int id, String name, int age, String username, String password, String role, double salary, int managerid) {
        super(id, name, age, username, password, role, salary, managerid);
    }
    
    public static EmployeeModel createFromPerson(PersonModel person){
        return new EmployeeModel(person.getID(), person.getName(), person.getAge(), person.getUsername(), person.getPassword(), person.getRole(), person.getSalary(), person.getManagerid());
    }
    
    public List<Penality> getPenalities() {
        return EmployeeRepository.getPenalities(getID());
    }
    
    public void addAttendance(Timestamp from) {
         EmployeeRepository.addAttendance(from, getID());
    }

    public void submitAttendance(Timestamp to) {
        EmployeeRepository.submitAttendance(to);    
    }

    public List<Task> getNotCompletedTasksForEmployee(int id_employee) {
       return  EmployeeRepository.getNotCompletedTasksForEmployee(id_employee);
    }

    public List<Task> getCompletedTasksForEmployee(int id_employee) {
        
        return  EmployeeRepository.getCompletedTasksForEmployee(id_employee);

    }

    public void submitCompletedTask(int id_task) {
         EmployeeRepository.submitCompletedTask(id_task);
    }

    public void requestVacation(Date from, Date to) {
           EmployeeRepository.requestVacation(from, to, getID());
    }

    @SuppressWarnings("empty-statement")
    public double getWorkingHrsPerMonth(int id_employee, int month) {
        return  EmployeeRepository.getWorkingHrsPerMonth(id_employee, month);
    }
}



/* public List<Vacation> getVacationRequests() {
        List<Vacation> vacationList = new ArrayList();
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=project;user=sa;password=1234567890";
        ResultSet resultSet = null;

        try (Connection connection = DriverManager.getConnection(connectionUrl); Statement statement = connection.createStatement();) {
            String selectSql = "SELECT * FROM vacation";
            resultSet = statement.executeQuery(selectSql);
            while (resultSet.next()) {

                java.util.Date from = resultSet.getDate("from");
                java.util.Date to = resultSet.getDate("to");
                int id_e = resultSet.getInt("employee_id");
                int id_vacation = resultSet.getInt("vac_id");
                boolean confirmed = resultSet.getBoolean("confirmed");
                Vacation v = new Vacation(from, to, id_e);
                vacationList.add(v);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vacationList;

    }
 */
// @SuppressWarnings("empty-statement")
/*public double getWorkingHrsPerMonth(int id_employee,Date f,Date t) {
        Attendance a = new Attendance(id_employee);
        double sum = 0;
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=project;user=sa;password=1234567890";
        ResultSet resultSet = null;
        String selectSql = "SELECT * FROM Attendances WHERE employeeID=" + id_employee + " and  entryTime between ? and ?";
        try ( Connection connection = DriverManager.getConnection(connectionUrl);   PreparedStatement prepsInsertProduct = connection.prepareStatement(selectSql);) {
           
            prepsInsertProduct.setDate(1, f);
            prepsInsertProduct.setDate(2, t);
            
            resultSet = prepsInsertProduct.executeQuery();
            while (resultSet.next()) {
                Timestamp from = resultSet.getTimestamp("entryTime");
                Timestamp to = resultSet.getTimestamp("exitTime");
                sum = sum + a.getWorkingHours(from, to);
              

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sum;
    }*/
