package Models;

public class Penality {
   private String reason;
    private String penality;
    private int penalityID;
    private int employeeID;

    public Penality(String reason, String penality, int employeeID) {
        this.reason = reason;
        this.penality = penality;
        this.employeeID = employeeID;
    }

    public Penality(String reason, String penality, int penalityID, int employeeID) {
        this.reason = reason;
        this.penality = penality;
        this.penalityID = penalityID;
        this.employeeID = employeeID;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPenality() {
        return penality;
    }

    public void setPenality(String penality) {
        this.penality = penality;
    }

    public int getPenalityID() {
        return penalityID;
    }

    public void setPenalityID(int penalityID) {
        this.penalityID = penalityID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    @Override
    public String toString() {
        return "Penality{" + "reason=" + reason + ", penality=" + penality + ", penalityID=" + penalityID + ", employeeID=" + employeeID + '}';
    }
    

}
    
