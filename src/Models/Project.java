package Models;
import java.util.*;

public class Project {
    private List<Task> taskList;
    private String name;
    private int ID_task;
    private List<Integer> employeeList;
    private int pmId;
    private int id_project;

    public Project() {
    }

    public Project(String name, int id_p, int pm) {
        this.name = name;
        this.id_project= id_p;
        this.pmId = pm;
    }

    public Project(String name, int ID_task, List<Integer> employeeList) {
        this.name = name;
        this.ID_task = ID_task;
        this.employeeList = employeeList;
    }

    public String getName() {
        return name;
    }

    public int getPmId() {
        return pmId;
    }


    public int getId_project() {
        return id_project;
    }
    
    
    @Override
    public String toString() {
        return "Project2{" + "name=" + name + ",  projectManagerID=" + pmId + ", id_project=" + id_project + '}';
    }

}
