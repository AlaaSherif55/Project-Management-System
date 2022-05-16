/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Frames;

import Views.InternalFrames.PM_Project;
import Views.InternalFrames.PM_Project;
import Views.InternalFrames.PM_ReportEmployee;
import Views.InternalFrames.PM_ReportEmployee;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class ProjectManagerView extends javax.swing.JFrame {

    public ProjectManagerView() {
        initComponents();
    }
    private PM_Project ViewProject;
    private PM_ReportEmployee ReportEmployee;

    public PM_Project getViewProject() {
        return ViewProject;
    }

    public PM_ReportEmployee getReportEmployee() {
        return ReportEmployee;
    }

    public void setReportEmployee(PM_ReportEmployee ReportEmployee) {
        this.ReportEmployee = ReportEmployee;
    }

    public void setViewProject(PM_Project ViewProject) {
        this.ViewProject = ViewProject;
    }

    public void AddToDesktop(JInternalFrame frame) {
        Desktop.add(frame);
    }

    public void setDesktop(JDesktopPane Desktop) {
        this.Desktop = Desktop;
    }

    public void AddViewProjectListener(ActionListener ActiondViewPorject) {
        ViewTasks.addActionListener(ActiondViewPorject);
    }
    
    public void AddReportEmployeeListener(ActionListener ActionRequestVacations) {
        reportEmployee.addActionListener(ActionRequestVacations);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desktop = new javax.swing.JDesktopPane();
        MenuBar = new javax.swing.JMenuBar();
        Tasks = new javax.swing.JMenu();
        ViewTasks = new javax.swing.JMenuItem();
        Report = new javax.swing.JMenu();
        reportEmployee = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Project Manager Dashboard");

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
        );

        Tasks.setText("Tasks");

        ViewTasks.setText("View");
        Tasks.add(ViewTasks);

        MenuBar.add(Tasks);

        Report.setText("Report");

        reportEmployee.setText("Employee");
        Report.add(reportEmployee);

        MenuBar.add(Report);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop, javax.swing.GroupLayout.Alignment.TRAILING)
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
            java.util.logging.Logger.getLogger(ProjectManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjectManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjectManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectManagerView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjectManagerView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu Report;
    private javax.swing.JMenu Tasks;
    private javax.swing.JMenuItem ViewTasks;
    private javax.swing.JMenuItem reportEmployee;
    // End of variables declaration//GEN-END:variables
}
