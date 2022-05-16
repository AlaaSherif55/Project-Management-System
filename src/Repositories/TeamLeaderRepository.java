package Repositories;

import Models.EmployeeModel;
import Models.Penality;
import Models.Report;
import Models.Task;
import Models.TeamLeaderModel;
import Models.Vacation;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeamLeaderRepository {

    public static Report getReportByName(String name) {
        Report report = null;
        String selectSql = "SELECT * FROM report where reportName= '"+name+"'";
        try{
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int id_report = resultSet.getInt("report_id");
                String details = resultSet.getString("details");
                int id_e = resultSet.getInt("employee_id");
                String report_name = resultSet.getString("reportName");
                report = new Report(details, id_report, id_e, report_name);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return report;

    }

    public static void assignTask(String name, String info, int id_employee, int id_project) {
        String insertSql = "INSERT INTO task (task_name,explanation,id_employee,id_project) VALUES ('" + name + "','" + info + "'," + id_employee + "," + id_project + ");";
        try{
            DatabaseQuery.executeInsert(insertSql);
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void assignPenality(String penality, String reason, int id_employee) {
        String insertSql = "INSERT INTO penalities(penality,reason,employee_id) VALUES ('" + penality + "','" + reason + "'," + id_employee + ");";
        try{
            DatabaseQuery.executeInsert(insertSql);
        } // Handle any errors that may have occurred.
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static List<Penality> getPenalities(int teamLeaderID) {
        List<Penality> penalities = new ArrayList<>();
        String selectSql = "SELECT dbo.penalities.employee_id , dbo.penalities.reason , dbo.penalities.penality , dbo.penalities.id_penality \n"
                + "FROM     dbo.person AS person_1 INNER JOIN\n"
                + "                  dbo.person ON person_1.manager_ID = dbo.person.id INNER JOIN\n"
                + "                  dbo.penalities ON person_1.id = dbo.penalities.employee_id\n"
                + "WHERE  (person_1.manager_ID = "+teamLeaderID+")";
        try{
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int employeeID = resultSet.getInt("employee_id");
                String penalityReason = resultSet.getString("reason");
                int penalityID = resultSet.getInt("id_penality");
                String penalityAmount = resultSet.getString("penality");
                Penality penality = new Penality(penalityReason, penalityAmount, penalityID, employeeID);
                penalities.add(penality);
            }

            //  statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return penalities;

    }

    public static List<Vacation> getVacationRequests(int teamLeaderID) {
        List<Vacation> vacations = new ArrayList<>();
        String selectSql = "SELECT dbo.person.id, person_1.manager_ID, person_1.fname, dbo.vacation.vac_id, dbo.vacation.[from], dbo.vacation.[to], dbo.vacation.employee_id, dbo.vacation.confirmed\n"
                + "FROM     dbo.person INNER JOIN\n"
                + "                  dbo.person AS person_1 ON dbo.person.id = person_1.manager_ID INNER JOIN\n"
                + "                  dbo.vacation ON person_1.id = dbo.vacation.employee_id\n"
                + "WHERE  (person_1.manager_ID = "+teamLeaderID+")";
        try{
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                Date from = resultSet.getDate("from");
                Date to = resultSet.getDate("to");
                int employeeID = resultSet.getInt("employee_id");
                int vacationID = resultSet.getInt("vac_id");
                boolean confirmed = resultSet.getBoolean("confirmed");
                Vacation vacation = new Vacation(vacationID, from, to, employeeID);
                if (confirmed) {
                    vacations.add(vacation);
                }
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return vacations;

    }

    public static void acceptVacation(int employeeID) {
        String updateSQL = "update vacation set confirmed='"+true+"' where  employee_id="+employeeID;
        try{
            DatabaseQuery.executeUpdate(updateSQL);
        } catch (SQLException ex) {
            Logger.getLogger(TeamLeaderModel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void denyVacation(int employeeID) {

        String updateSQL = "update vacation set confirmed='"+false+"' where  employee_id="+employeeID;
        try{
            DatabaseQuery.executeUpdate(updateSQL);
        } catch (SQLException ex) {
            Logger.getLogger(TeamLeaderModel.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public static List<Report> getReportsForLeader(int teamLeaderID) {
        List<Report> Reports = new ArrayList<>();
        String selectSql = "SELECT dbo.report.employee_id, dbo.person.id, dbo.report.details, dbo.report.reportName, dbo.report.report_id, dbo.report.id_ProjectManager, person_1.manager_ID\n"
                + "FROM     dbo.person AS person_1 INNER JOIN\n"
                + "                  dbo.report ON person_1.id = dbo.report.employee_id INNER JOIN\n"
                + "                  dbo.person ON person_1.manager_ID = dbo.person.id\n"
                + "WHERE  (person_1.manager_ID = "+teamLeaderID+")";
        try{
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int reportID = resultSet.getInt("report_id");
                String reportDetails = resultSet.getString("details");
                int employeeID = resultSet.getInt("employee_id");
                String reportName = resultSet.getString("reportName");
                Report report = new Report(reportDetails, reportID, employeeID, reportName);
                Reports.add(report);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Reports;

    }

    public static List<Task> getTasksForItsEmployees(int teamLeaderID) {
        List<Task> tasks = new ArrayList<>();
        String selectSql = "SELECT dbo.task.task_name, dbo.task.completed_task, dbo.task.explanation, dbo.task.id_employee, person_1.fname,person_1.lname, dbo.task.id_task\n"
                + "FROM     dbo.person INNER JOIN\n"
                + "                  dbo.person AS person_1 ON dbo.person.id = person_1.manager_ID INNER JOIN\n"
                + "                  dbo.task ON person_1.id = dbo.task.id_employee\n"
                + "WHERE  (person_1.manager_ID = "+teamLeaderID+")  ";
        try{
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {
                int taskID = resultSet.getInt("id_task");
                String taskExplanation = resultSet.getString("explanation");
                int employeeID = resultSet.getInt("id_employee");
                String taskName = resultSet.getString("task_name");
                boolean isCompleted = resultSet.getBoolean("completed_task");

                Task task = new Task(taskID, taskName, taskExplanation, employeeID, isCompleted);
                tasks.add(task);
            }

            //  statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return tasks;
    }

    public static EmployeeModel findEmployeeById(int employeeID) {
        EmployeeModel person = null;
        String selectSql = "SELECT * FROM person WHERE id="+employeeID+" AND role='Employee'";
        try{
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                double salary = resultSet.getDouble("salary");
                String fname = resultSet.getString("fname");
                int age = resultSet.getInt("age");
                String lname = resultSet.getString("lname");
                String password = resultSet.getString("password");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                int mangerid = resultSet.getInt("manager_ID");
                String name = fname + " " + lname;
                person = new EmployeeModel(id, name, age, username, password, role, salary, mangerid);

            }
        } catch (SQLException ex) {
        }
        return person;

    }

    public static List<EmployeeModel> getEmployees(int idManager) {
        List<EmployeeModel> employees = new ArrayList<>();
        String selectSql = "SELECT * FROM person WHERE  manager_ID="+idManager+" AND role='Employee' ";
        try{
            ResultSet resultSet = DatabaseQuery.executeSelect(selectSql);
            while (resultSet.next()) {

                int employeeID = resultSet.getInt("id");
                double salary = resultSet.getDouble("salary");
                String fname = resultSet.getString("fname");
                int age = resultSet.getInt("age");
                String lname = resultSet.getString("lname");
                String password = resultSet.getString("password");
                String username = resultSet.getString("username");
                String role = resultSet.getString("role");
                int mangerid = resultSet.getInt("manager_ID");
                String name = fname + " " + lname;
                EmployeeModel employee = new EmployeeModel(employeeID, name, age, username, password, role, salary, mangerid);
                employees.add(employee);

            }
        } catch (SQLException ex) {
            
        }
        return employees;

    }
}
