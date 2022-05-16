package Models;
import Repositories.EmployeeRepository;
import java.util.*;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDateTime;

public class EmployeeModel extends PersonModel {

    public EmployeeModel(int id, String name, int age, String username, String password,
            String role, double salary, int managerid) {
        super(id, name, age, username, password, role, salary, managerid);
    }
    
    public static EmployeeModel createFromPerson(PersonModel person){
        return new EmployeeModel(person.getID(), person.getName(), person.getAge(),
                person.getUsername(), person.getPassword(), person.getRole(),
                person.getSalary(), person.getManagerid());
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

