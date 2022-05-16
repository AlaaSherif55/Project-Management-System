package Repositories;

import Models.EmployeeModel;
import Models.Project;
import Models.Report;
import Models.Task;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectManagerRepository{

    public static List<Task> getTasksForProject(int managerID) {
        List<Task> taskList = new ArrayList<>();
        ResultSet resultSet = null;
        String selectSql = "SELECT dbo.person.id, dbo.task.id_task,"
                + " dbo.task.id_project, dbo.task.completed_task, dbo.task.explanation,"
                + " dbo.task.id_employee, dbo.task.task_name\n"
                + "FROM     dbo.person INNER JOIN\n"
                + "                  dbo.project ON dbo.person.id = dbo.project.id_PM INNER JOIN\n"
                + "                  dbo.task ON dbo.project.p_id = dbo.task.id_project\n"
                + "WHERE  (dbo.person.id = "+managerID+")";
        try{
            resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int id_task = resultSet.getInt("id_task");
                String info = resultSet.getString("explanation");
                int id_employee = resultSet.getInt("id_employee");
                String task_name = resultSet.getString("task_name");
                boolean isCompleted = resultSet.getBoolean("completed_task");

                Task task = new Task(id_task, task_name, info, id_employee, isCompleted);
                taskList.add(task);
            }
            //  statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return taskList;
    }
    
    public static List<Task> getCompletedTasksForProject(int managerID) {
        List<Task> tasks = new ArrayList<>();
        ResultSet resultSet = null;
        String selectSql = "SELECT dbo.person.id, dbo.task.id_task, dbo.task.id_project,"
                + " dbo.task.completed_task, dbo.task.explanation,"
                + " dbo.task.task_name, dbo.task.id_employee\n"
                + "FROM     dbo.person INNER JOIN\n"
                + "                  dbo.project ON dbo.person.id = dbo.project.id_PM INNER JOIN\n"
                + "                  dbo.task ON dbo.project.p_id = dbo.task.id_project\n"
                + "WHERE  (dbo.person.id = "+managerID+") AND (dbo.task.completed_task = 1)";
        try{
            resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int id_task = resultSet.getInt("id_task");
                String info = resultSet.getString("explanation");
                int id_employee = resultSet.getInt("id_employee");
                String taskName = resultSet.getString("task_name");
                boolean isCompleted = resultSet.getBoolean("completed_task");

                Task task = new Task(id_task, taskName, info, id_employee, isCompleted);
                tasks.add(task);
            }

            //  statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return tasks;
    }

    public static List<EmployeeModel> getEmployees(int managerID) {
        List<EmployeeModel> employees = new ArrayList<>();
        ResultSet resultSet = null;
        String selectSql = "SELECT  DISTINCT person_1.id, person_1.fname, person_1.lname, person_1.age,"
                + " person_1.salary, person_1.password, person_1"
                + ".username, person_1.role, person_1.manager_ID\n"
                + "FROM     dbo.person INNER JOIN\n"
                + "                  dbo.project ON dbo.person.id = dbo.project.id_PM INNER JOIN\n"
                + "                  dbo.task ON dbo.project.p_id = dbo.task.id_project INNER JOIN\n"
                + "                  dbo.person AS person_1 ON dbo.task.id_employee = person_1.id\n"
                + "WHERE  (dbo.person.id = "+managerID+") ";
        try{
            resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int id_employee = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                double salary = resultSet.getDouble("salary");
                String fname = resultSet.getString("fname");
                String lname = resultSet.getString("lname");
                String password = resultSet.getString("password");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                int manager_id = resultSet.getInt("manager_id");
                String name = fname + " " + lname;

                EmployeeModel employee = new EmployeeModel(id_employee, name, age, username, password, role, salary, manager_id);
                employees.add(employee);
            }

            //  statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return employees;

    }

    public static void ReportEmployee(int id_projectManger, int id_employee, String info, String name) {
        String insertSql = "INSERT INTO report (id_projectManager,employee_id,details,reportName) VALUES ("
                + id_projectManger + "," + id_employee + ",'" + info + "','" + name + "');";
        try{
            DatabaseQuery.executeInsert(insertSql);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static EmployeeModel findEmployeeById(int employeeID) {
        EmployeeModel employee = null;
        String selectSql = "SELECT * FROM person WHERE  id="+employeeID;
        try{
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                int salary = resultSet.getInt("salary");
                String fname = resultSet.getString("fname");
                int age = resultSet.getInt("age");
                String lname = resultSet.getString("lname");
                String password = resultSet.getString("password");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                int manager_id = resultSet.getInt("manager_ID");
                String name = fname + " " + lname;
                employee = new EmployeeModel(id, name, age, username, password, role, salary, manager_id);

            }

        } catch (SQLException ex) {
            
        }
        return employee;

    }

    public static Project getProjectByID(int manager) {
        Project project = null;
        String selectSql = "SELECT * FROM project where id_PM = "+manager+"";
        try{
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int project_id = resultSet.getInt("p_id");
                String name = resultSet.getString("p_name");
                int manager_id = resultSet.getInt("id_PM");
                project = new Project(name, project_id, manager_id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return project;

    }

    public static List<Project> getProjectsByID(int manager) {
        List<Project> project = new ArrayList<>();
        String selectSql = "SELECT * FROM project where id_PM="+manager;
        try {
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int project_id = resultSet.getInt("p_id");
                String projectName = resultSet.getString("p_name");
                int projectManagerId = resultSet.getInt("id_PM");
                Project t = new Project(projectName, project_id, projectManagerId);
                project.add(t);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return project;

    }
}
