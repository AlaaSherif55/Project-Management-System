package Models;

import java.util.*;
import java.sql.Date;
import java.sql.Timestamp;

public class Attendance {

  private Timestamp entry;
    private Timestamp exit;
    int employeeID;

    public Attendance(int employeeID) {
        this.employeeID = employeeID;
    }

    public void setEntry(Timestamp entry) {
        this.entry = entry;
    }

    public void setExit(Timestamp exit) {
        this.exit = exit;
    }

    public double getWorkingHours(Timestamp from, Timestamp to) {
        double fromHours = (double) (from.getTime() / (1000.0 * 60 * 60));
        double toHours = (double) (to.getTime() / (1000.0 * 60 * 60));
        return toHours-fromHours;
    }

    public Timestamp getEntry() {
        return entry;
    }

    public Timestamp getExit() {
        return exit;
    }

}
