package Models;
import Repositories.ProjectManagerRepository;
import java.util.List;

public class ProjectManagerModel extends PersonModel {

    public ProjectManagerModel(int id, String name, int age, String username
            , String password, String role, double salary, int managerid) {
        super(id, name, age, username, password, role, salary, managerid);
    }
    
    public static ProjectManagerModel createFromPerson(PersonModel person){
        return new ProjectManagerModel(person.getID(), person.getName()
                , person.getAge(), person.getUsername(), person.getPassword()
                , person.getRole(), person.getSalary(), person.getManagerid());
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









/* public EmployeeModel findEmployeeById(int id,String role) {
       ArrayList<Employee> em = new ArrayList<>();
       EmployeeModel p=null;
        String ConnectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=project;user=sa;password=1234567890";
        ResultSet resultSet = null;
        String selectSql = "SELECT * FROM person WHERE  id=? AND role=? ";
        try ( Connection connection = DriverManager.getConnection(ConnectionUrl);  PreparedStatement prepsInsertProduct = connection.prepareStatement(selectSql);) {
   
            prepsInsertProduct.setInt(1, id);
            prepsInsertProduct.setString(2, role);
            resultSet = prepsInsertProduct.executeQuery();
            while (resultSet.next()) {

                int id1 = resultSet.getInt("id");
                int salary1 = resultSet.getInt("salary");
                String fname = resultSet.getString("fname");
                int age1 = resultSet.getInt("age");
                String lname = resultSet.getString("lname");
                String password1 = resultSet.getString("password");
                String username1 = resultSet.getString("username");
                String role1 = resultSet.getString("role");
                int mangerid = resultSet.getInt("manager_ID");
                String name1 = fname + " " + lname;
                 p = new EmployeeModel(id1, name1, age1, username1, password1, role1, salary1, mangerid);
                em.add(p);

            }
           
             prepsInsertProduct.close();
        } catch (SQLException e) {
        }
        return p;

    }
 public Project getProjectByID(int manager) {
        ArrayList<Project2> project = new ArrayList<Project2>();
         Project t=null;
        String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=project;user=sa;password=1234567890";
        ResultSet resultSet = null;
        String selectSql = "SELECT * FROM project where id_PM=?";
        try ( Connection connection = DriverManager.getConnection(connectionUrl);  PreparedStatement prepsInsertProduct = connection.prepareStatement(selectSql);) {

            prepsInsertProduct.setInt(1,manager);

            resultSet = prepsInsertProduct.executeQuery();
            while (resultSet.next()) {
                int id_p = resultSet.getInt("p_id");
                String n = resultSet.getString("p_name");
                int id_pm = resultSet.getInt("id_PM");
                t = new Project(n, id_p, id_pm);
                project.add(t);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;

    }*/









