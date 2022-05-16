package Models;
import Repositories.AdminRepository;
import java.util.List;

public class AdminModel extends PersonModel {

    public AdminModel(int id, String name, int age, String username, String password, String role, double salary, int managerid) {
        super(id, name, age, username, password, role, salary, managerid);
    }
    
    public static AdminModel createFromPerson(PersonModel person) {
        return new AdminModel(person.getID(), person.getName(), person.getAge(), person.getUsername(), person.getPassword(), person.getRole(), person.getSalary(), person.getManagerid());
    }
    
    public static void createProject(int managerID,String projectName){
        AdminRepository.createProject(managerID, projectName);
    }
    
    public static void updateProject(int managerID, String projectName){
        AdminRepository.updateProject(managerID, projectName);
    }

    public static double getCompelationRateByProjectName(String name) {
        double tasks = getTaskToOneProject(name).size();
        if(tasks == 0) tasks = 1;
        double completedTasks = getCompletedTaskToOneProject(name).size();
        return (completedTasks / tasks) * 100;
    }

    public static List<PersonModel> getUsers() {
        return AdminRepository.getUsers();
    }

    public static List<PersonModel> getUserByRole(String role) {
        return AdminRepository.getPersonByRole(role);
    }

    public static List<Project> getProjects() {
        return AdminRepository.getProjects();
    }

    public static Project getProjectByName(String name) {
        return AdminRepository.getProjectByName(name);
    }

    public static void addUser(PersonModel user) {
        AdminRepository.addUser(user);
    }

    public static List<Task> getTasks() {
        return AdminRepository.getTasks();
    }

    public static List<Task> getTaskToOneProject(String projectName) {
        return AdminRepository.getTaskToOneProject(projectName);
    }

    public static List<Task> getCompletedTaskToOneProject(String projectName) {
        return AdminRepository.getCompletedTaskToOneProject(projectName);
    }

    public static List<Task> getCompletedTasks() {
        return AdminRepository.getCompletedTasks();
    }

    public static PersonModel findUserById(int id) {
        return AdminRepository.findUserById(id);
    }

    public static void deleteUser(int id){
        AdminRepository.deleteUser(id);
    }

    public static void UpdateUser(PersonModel person) {
        AdminRepository.UpdateUser(person);
    }

    public static PersonModel findUserByName(String Name) {
        return AdminRepository.findUserByName(Name);
    }

    public static void addProjectManager(String name, int age, String username, String password, String role, double salary) {
        AdminRepository.addProjectManager(name, age, username, password, role, salary);
    }

}
