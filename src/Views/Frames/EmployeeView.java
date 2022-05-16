/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Frames;

import Models.PersonModel;
import Models.EmployeeModel;
import Views.InternalFrames.EM_ManageTasks;
import Views.InternalFrames.EM_ManageTasks;
import Views.InternalFrames.EM_RequestVacation;
import Views.InternalFrames.EM_RequestVacation;
import Views.InternalFrames.EM_ViewPenalities;
import Views.InternalFrames.EM_ViewPenalities;
import Views.InternalFrames.EM_WorkingHours;
import Views.InternalFrames.EM_WorkingHours;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenuItem;


/**
 *
 * @author soma
 */
public class EmployeeView extends javax.swing.JFrame {

    private EM_ManageTasks ManageTasksView;
    private EM_RequestVacation RequestVacationsView;
    private EM_ViewPenalities ViewPenalitiesView;
    private EM_WorkingHours WorkingHoursView;

    public EM_ManageTasks getManageTasksView() {
        return ManageTasksView;
    }

    public EM_RequestVacation getRequestVacationsView() {
        return RequestVacationsView;
    }

    public EM_ViewPenalities getViewPenalitiesView() {
        return ViewPenalitiesView;
    }

    public EM_WorkingHours getWorkingHoursView() {
        return WorkingHoursView;
    }

    public void setManageTasksView(EM_ManageTasks ManageTasksView) {
        this.ManageTasksView = ManageTasksView;
    }

    public void setRequestVacationsView(EM_RequestVacation RequestVacationsView) {
        this.RequestVacationsView = RequestVacationsView;
    }

    public void setViewPenalitiesView(EM_ViewPenalities ViewPenalitiesView) {
        this.ViewPenalitiesView = ViewPenalitiesView;
    }

    public void setWorkingHoursView(EM_WorkingHours WorkingHoursView) {
        this.WorkingHoursView = WorkingHoursView;
    }

    public void AddToDesktop(JInternalFrame frame ) {
       Desktop.add(frame);
    }
    public void setDesktop(JDesktopPane Desktop) {
        this.Desktop = Desktop;
    }

    public JMenuItem getExitButton() {
        return ExitButton;
    }

    public void setExitButton(JMenuItem ExitButton) {
        this.ExitButton = ExitButton;
    }

    public JMenuItem getManageTask() {
        return ManageTask;
    }

    public void setManageTask(JMenuItem ManageTask) {
        this.ManageTask = ManageTask;
    }

    public JMenuItem getRequestVacations() {
        return RequestVacations;
    }

    public void setRequestVacations(JMenuItem RequestVacations) {
        this.RequestVacations = RequestVacations;
    }

    public JMenuItem getViewPenalities() {
        return ViewPenalities;
    }

    public void setViewPenalities(JMenuItem ViewPenalities) {
        this.ViewPenalities = ViewPenalities;
    }

    public JMenuItem getWorkingHours() {
        return WorkingHours;
    }

    public void setWorkingHours(JMenuItem WorkingHours) {
        this.WorkingHours = WorkingHours;
    }
   
   
    public EmployeeView() {
        initComponents();
        
    }

   public void AddManageTasksListener(ActionListener ActionManageTasks){
       ManageTask.addActionListener(ActionManageTasks);
   }
   public void AddRequestVacationsListener(ActionListener ActionRequestVacations){
       RequestVacations.addActionListener(ActionRequestVacations);
   }
   public void AddViewPenalitiesListener(ActionListener ActionViewPenalities){
       ViewPenalities.addActionListener(ActionViewPenalities);
   }
   public void AddWorkingHoursListener(ActionListener ActionWorkingHours){
       WorkingHours.addActionListener(ActionWorkingHours);
   }
   public void AddExitListener(ActionListener ActionExit){
       ExitButton.addActionListener(ActionExit);
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        ExitButton = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        ManageTask = new javax.swing.JMenuItem();
        RequestVacations = new javax.swing.JMenuItem();
        ViewPenalities = new javax.swing.JMenuItem();
        WorkingHours = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Employee Dashboard");

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 473, Short.MAX_VALUE)
        );

        jMenu3.setText("File");

        ExitButton.setText("Exit");
        jMenu3.add(ExitButton);

        jMenuBar1.add(jMenu3);

        jMenu5.setText("Manage");

        ManageTask.setText("Manage Tasks");
        jMenu5.add(ManageTask);

        RequestVacations.setText("Request Vacation");
        jMenu5.add(RequestVacations);

        ViewPenalities.setText("View Penalities");
        jMenu5.add(ViewPenalities);

        WorkingHours.setText("Working Hours");
        jMenu5.add(WorkingHours);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeView().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuItem ExitButton;
    private javax.swing.JMenuItem ManageTask;
    private javax.swing.JMenuItem RequestVacations;
    private javax.swing.JMenuItem ViewPenalities;
    private javax.swing.JMenuItem WorkingHours;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables

    private void exitActionPerformed(ActionEvent evt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
