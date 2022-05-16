package Models;
import Repositories.ProjectManagerRepository;
import java.util.List;

public class ProjectManagerModel extends PersonModel {

    public ProjectManagerModel(int id, String name, int age, String username, String password, String role, double salary, int managerid) {
        super(id, name, age, username, password, role, salary, managerid);
    }
    
    public static ProjectManagerModel createFromPerson(PersonModel person){
        return new ProjectManagerModel(person.getID(), person.getName(), person.getAge(), person.getUsername(), person.getPassword(), person.getRole(), person.getSalary(), person.getManagerid());
    }
    
    public double getCompelationRate() {
        double tasks = this.getTasksForProject().size();
        if(tasks == 0) tasks=1;
        double completedTasks = this.getCompletedTasksForProject().size();
        return (completedTasks / tasks) * 100;
    }
    
    public List<Task> getTasksForProject() {
        return ProjectManagerRepository.getTasksForProject(this.getID());
    }
    public List<Task> getCompletedTasksForProject() {
        return ProjectManagerRepository.getCompletedTasksForProject(this.getID());
    }
    public List<EmployeeModel> getEmployees(){
        return ProjectManagerRepository.getEmployees(this.getID());
    }
    public void ReportEmployee(int id_employee, String info, String name){
       ProjectManagerRepository.ReportEmployee(this.getID(), id_employee, info, name);
    }
    public EmployeeModel findEmployeeById(int id) {
        return ProjectManagerRepository.findEmployeeById(id);

    }
    public Project getProject() {
        return ProjectManagerRepository.getProjectByID(this.getID());
    }
    
    public static Project getProjectByID(int managerID) {
        return ProjectManagerRepository.getProjectByID(managerID);
    }
    
    public List<Project> getProjectsByID(int manager) {
        return ProjectManagerRepository.getProjectsByID(manager);
    }

}