package Models;
public class Report {
    private String details;
    private int id;
    private int employeeID;
    private int projectManagerID;
    private String reportName;

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }
    
    public Report(String details, int id, int employeeID,String name) {
        this.details = details;
        this.id = id;
        this.employeeID = employeeID;
        this.reportName=name;
    }

    public Report( int employeeID,String details, int projectManagerID,String name) {
        this.details = details;
        this.employeeID = employeeID;
        this.projectManagerID = projectManagerID;
        this.reportName=name;
    }
    
    
    public String getDetails() {
        return details;
    }
    public String getReportName() {
        return reportName;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Report{" + "details=" + details + ", id=" + id + ", employeeID=" + employeeID + '}';
    }
    
}
    

