package Models;

public class Task {

    private int task_id;
    private String task_name;
    private String task_info;
    private boolean task_completed;
    private int employee_id;
  

    public Task(int task_id, String task_name, String task_info, int employee_id,boolean task_completed ) {
        this.task_id = task_id;
        this.task_name = task_name;
        this.task_info = task_info;
        this.employee_id = employee_id;
        this.task_completed=task_completed;
    }

    public void setTask_completed(boolean task_completed) {
        this.task_completed = task_completed;
    }

    public int getTask_id() {
        return task_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public String getTask_info() {
        return task_info;
    }

    public boolean isTask_completed() {
        
        return task_completed;
    }

    public int getEmployee_id() {
        return employee_id;
    }

   
  
    @Override
    public String toString() {
        return "Task{" + "task_id=" + task_id + ", task_name=" + task_name + ", task_info=" + task_info + ", task_completed=" + task_completed + ", employee_id=" + employee_id + '}';
    }

    
}
