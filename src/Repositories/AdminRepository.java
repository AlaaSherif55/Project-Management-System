/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repositories;

import Models.PersonModel;
import Models.Project;
import Models.Task;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminRepository {

    public static void createProject(int managerID, String projectName) {
        String insertSql = "INSERT INTO project (dbo.project.p_name, dbo.project.id_PM) VALUES ('" + projectName + "'," + managerID + ")";
        if (!hasProject(managerID)) {
            try {
                DatabaseQuery.executeInsert(insertSql);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void updateProject(int managerid, String projectName) {
        String updateSql = "UPDATE project SET p_name='" + projectName + "' WHERE id_PM=" + managerid;
        try {
            DatabaseQuery.executeUpdate(updateSql);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }

    public static boolean hasProject(int managerID) {
        String selectSql = "SELECT id_PM FROM project";
        try {
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int projectManagerID = resultSet.getInt("id_PM");
                if (projectManagerID == managerID) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public static List<PersonModel> getUsers() {
        List<PersonModel> users = new ArrayList<>();

        try {
            String selectSql = "SELECT * FROM person WHERE NOT role='admin' ";
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int userID = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                double salary = resultSet.getDouble("salary");
                String fname = resultSet.getString("fname");
                String lname = resultSet.getString("lname");
                String password = resultSet.getString("password");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                int managerID = resultSet.getInt("manager_id");
                String name = fname + " " + lname;

                PersonModel user = new PersonModel(userID, name, age, username, password,
                        role, salary, managerID);
                users.add(user);
            }

            //  statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return users;

    }

    public static List<PersonModel> getPersonByRole(String personRole) {
        List<PersonModel> users = new ArrayList<>();
        String selectSql = "SELECT * FROM person where role='" + personRole + "'";
        try {
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int user_id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                double salary = resultSet.getDouble("salary");
                String fname = resultSet.getString("fname");
                String lname = resultSet.getString("lname");
                String password = resultSet.getString("password");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                int managerID = resultSet.getInt("manager_id");
                String name = fname + " " + lname;

                PersonModel person = new PersonModel(user_id, name, age, username, password,
                        role, salary, managerID);
                users.add(person);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return users;

    }

    public static List<Project> getProjects() {
        List<Project> projects = new ArrayList<>();

        try {
            String selectSql = "SELECT * FROM project";
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int projectID = resultSet.getInt("p_id");
                String projectName = resultSet.getString("p_name");
                int managerID = resultSet.getInt("id_PM");
                Project project = new Project(projectName, projectID, managerID);
                projects.add(project);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return projects;

    }

    public static Project getProjectByName(String name) {
        Project project = null;
        String selectSql = "SELECT * FROM project where p_name='" + name + "'";
        try {
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int projectID = resultSet.getInt("p_id");
                int projectManagerID = resultSet.getInt("id_PM");
                project = new Project(name, projectID, projectManagerID);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return project;

    }

    public static void addUser(PersonModel user) {
        ResultSet resultSet = null;
        String[] names = user.getName().split(" ");
        String fname = names[0];
        String lname = names[1];
        String insertSql = "INSERT INTO person(fname,lname,age,salary,password,username,role,manager_ID) VALUES ('"
                + fname + "','" + lname + "'," + user.getAge() + "," + user.getSalary() + ",'" + user.getPassword() 
                + "','" + user.getUsername() + "','" + user.getRole() + "'," + user.getManagerid() + ");";
        try {
            DatabaseQuery.executeSelect(insertSql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }//add button

    public static List<Task> getTasks() {
        List<Task> tasks = new ArrayList<>();

        try {
            String selectSql = "SELECT * FROM task ";
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int taskID = resultSet.getInt("id_task");
                String info = resultSet.getString("explanation");
                int employeeID = resultSet.getInt("id_employee");
                String taskName = resultSet.getString("task_name");
                boolean isCompleted = resultSet.getBoolean("completed_task");

                Task task = new Task(taskID, taskName, info, employeeID, isCompleted);
                tasks.add(task);
            }

            //  statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return tasks;
    }

    public static List<Task> getTaskToOneProject(String projectName) {
        List<Task> tasks = new ArrayList<>();

        int projectID = getProjectByName(projectName).getId_project();

        try {
            String selectSql = "SELECT * FROM task where id_project= " + projectID;
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int taskID = resultSet.getInt("id_task");
                String info = resultSet.getString("explanation");
                int employeeID = resultSet.getInt("id_employee");
                String taskName = resultSet.getString("task_name");
                boolean isCompleted = resultSet.getBoolean("completed_task");

                Task task = new Task(taskID, taskName, info, employeeID, isCompleted);
                tasks.add(task);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return tasks;
    }

    public static List<Task> getCompletedTaskToOneProject(String projectName) {
        List<Task> tasks = new ArrayList<>();
        int projectID = getProjectByName(projectName).getId_project();
        String selectSql = "SELECT * FROM task where id_project=" + projectID + " and completed_task=1";
        try {
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int taskID = resultSet.getInt("id_task");
                String info = resultSet.getString("explanation");
                int employeeID = resultSet.getInt("id_employee");
                String taskName = resultSet.getString("task_name");
                boolean isCompleted = resultSet.getBoolean("completed_task");

                Task task = new Task(taskID, taskName, info, employeeID, isCompleted);
                tasks.add(task);
            }

            //  statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return tasks;
    }

    public static List<Task> getCompletedTasks() {
        List<Task> taskList = new ArrayList<>();

        try {
            String selectSql = "SELECT * FROM task WHERE completed_task=1";
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int taskID = resultSet.getInt("id_task");
                String info = resultSet.getString("explanation");
                int employeeID = resultSet.getInt("id_employee");
                String taskName = resultSet.getString("task_name");
                boolean isCompleted = resultSet.getBoolean("completed_task");

                Task task = new Task(taskID, taskName, info, employeeID, isCompleted);
                taskList.add(task);
            }

            //  statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return taskList;
    }

    public static PersonModel findUserById(int id) {

        PersonModel user = null;
        String selectSql = "SELECT * FROM person WHERE id=" + id;
        try {
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {

                int userID = resultSet.getInt("id");
                double salary = resultSet.getDouble("salary");
                String fname = resultSet.getString("fname");
                int age = resultSet.getInt("age");
                String lname = resultSet.getString("lname");
                String password = resultSet.getString("password");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                int managerID = resultSet.getInt("manager_ID");
                String name = fname + " " + lname;
                user = new PersonModel(userID, name, age, username, password, role, salary, managerID);

            }

            //  statement.close();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return user;

    }

    public static void deleteUser(int id) {
        String deleteSql = "DELETE FROM person WHERE id=" + id;
        try {
            DatabaseQuery.executeDelete(deleteSql);
        } // Handle any errors that may have occurred.
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static PersonModel findEmployeesUnderManagerByID(int managerid) {
        PersonModel user = null;
        String selectSql = "SELECT * FROM person WHERE manager_ID=" + managerid;// +pass+"AND username="+userName;
        try {
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {

                int userID = resultSet.getInt("id");
                double salary = resultSet.getDouble("salary");
                String fname = resultSet.getString("fname");
                int age = resultSet.getInt("age");
                String lname = resultSet.getString("lname");
                String password = resultSet.getString("password");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                int managerID = resultSet.getInt("manager_ID");
                String name = fname + " " + lname;
                user = new PersonModel(userID, name, age, username, password, role, salary, managerID);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;
    }

    public static void UpdateUser(PersonModel person) {
        String name = person.getName();
        String[] names = name.split(" ");
        String fname = names[0];
        String lname = names[1];
        String updateSql = "UPDATE person set fname='" + fname + "',lname='" + lname + "',age=" + person.getAge() + ",salary=" + person.getSalary() + ",password='" + person.getPassword() + "',username='" + person.getUsername() + "',role='" + person.getRole() + "' WHERE id=" + person.getID();

        try {

            DatabaseQuery.executeUpdate(updateSql);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static PersonModel findUserByName(String Name) {
        PersonModel user = null;
        String[] names = Name.split(" ");
        String fname = names[0];
        String lname = names[1];
        String selectSql = "SELECT * FROM person WHERE fname='" + fname + "' and lname='" + lname + "'";
        try {
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {

                int userID = resultSet.getInt("id");
                double salary = resultSet.getDouble("salary");
                int age = resultSet.getInt("age");
                String password = resultSet.getString("password");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                int managerID = resultSet.getInt("manager_ID");
                String name = fname + " " + lname;
                user = new PersonModel(userID, name, age, username, password, role, salary, managerID);
            }

            //  statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return user;

    }

    public static void addProjectManager(String name, int age, String username, String password, String role, double salary) {
        ResultSet resultSet = null;
        String[] names = name.split(" ");
        String fname = names[0];
        String lname = names[1];
        String insertSql = "INSERT INTO person(fname,lname,age,salary,password,username,role) VALUES ('" + fname + "','" + lname + "'," + age + "," + salary + ",'" + password + "','" + username + "','" + role + "');";

        try {
            DatabaseQuery.executeInsert(insertSql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
