package Models;
import java.util.Date;
public class Vacation {
    private Date to;
    private Date from;
    private boolean confirmed;
    private int id;
    private int employeeID;

    public Vacation(int id,Date from, Date to, int employeeID){
        this.to = to;
        this.from = from;
        this.employeeID = employeeID;
        this.id=id;
    }
    
    public boolean isConfirmed(){
        return confirmed;
    }
    
    public void accept(){
        this.confirmed = true;
    }
    
    public int getEmployeeID(){
        return employeeID;
    }
    
    public int getID(){
        return id;
    }
    
    public void setVacationStart(Date from){
        this.from = from;
    }
    
    public Date getVacationStart(){
        return from;
    }
    
    public void setVacationEnd(Date to){
        this.to = to;
    }
    
    public Date getVacationEnd(){
        return to;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Override
    public String toString() {
        return "Vacation{" + "to=" + to + ", from=" + from + ", confirmed=" + confirmed + ", id=" + id + ", employeeID=" + employeeID + '}';
    }
    
}

