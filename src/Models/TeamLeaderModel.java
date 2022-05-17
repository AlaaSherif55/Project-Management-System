package Models;
import Repositories.TeamLeaderRepository;
import java.util.*;

public class TeamLeaderModel extends PersonModel {


    public TeamLeaderModel(int id, String name, int age, String username, String password, String role, double salary, int managerid) {
        super(id, name, age, username, password, role, salary, managerid);
    }
    
    public static TeamLeaderModel createFromPerson(PersonModel person){
        return new TeamLeaderModel(person.getID(), person.getName(), person.getAge(), person.getUsername(), person.getPassword(), person.getRole(), person.getSalary(), person.getManagerid());
    }
    
    public Report getReportByName(String name) {
        return TeamLeaderRepository.getReportByName(name);
    }
    
    public List<Report> getReportsForLeader() {
        return TeamLeaderRepository.getReportsForLeader(this.getID());
    }
    
    public void assignTask(String name, String info, int id_employee) {
       TeamLeaderRepository.assignTask(name, info, id_employee, ProjectManagerModel.getProjectByID(this.getManagerid()).getId_project());
    }
    
    public List<Task> getTasksForItsEmployees() {
        return TeamLeaderRepository.getTasksForItsEmployees(this.getID());
    }
    
    public void assignPenality(String penality, String reason, int id_employee) {
       TeamLeaderRepository.assignPenality(penality, reason, id_employee);
    }

    public List<Penality> getPenalities() {
        return TeamLeaderRepository.getPenalities(this.getID());
    }

    public List<Vacation> getVacationRequests() {
        return TeamLeaderRepository.getVacationRequests(this.getID());
    }
    
    public List<Vacation> getVacationsAccepted() {
        return TeamLeaderRepository.getVacationsAccepted(this.getID());
    }

    public void acceptVacation(int employeeID) {
        TeamLeaderRepository.acceptVacation(employeeID);
    }

    public void denyVacation(int employeeID) {
      TeamLeaderRepository.denyVacation(employeeID);
    }

    public EmployeeModel findEmployeeById(int id) {
        return TeamLeaderRepository.findEmployeeById(id);

    }

    public List< EmployeeModel> getEmployees(int idManager) {
        return TeamLeaderRepository.getEmployees(idManager);
    }

}
