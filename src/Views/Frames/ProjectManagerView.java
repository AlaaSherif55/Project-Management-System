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
        jViewTasks.addActionListener(ActiondViewPorject);
    }
    
    public void AddReportEmployeeListener(ActionListener ActionRequestVacations) {
        jReportEmployee.addActionListener(ActionRequestVacations);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        Tasks = new javax.swing.JMenu();
        jViewTasks = new javax.swing.JMenuItem();
        Report = new javax.swing.JMenu();
        jReportEmployee = new javax.swing.JMenuItem();

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

        jViewTasks.setText("View");
        Tasks.add(jViewTasks);

        jMenuBar1.add(Tasks);

        Report.setText("Report");

        jReportEmployee.setText("Employee");
        Report.add(jReportEmployee);

        jMenuBar1.add(Report);

        setJMenuBar(jMenuBar1);

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
    private javax.swing.JMenu Report;
    private javax.swing.JMenu Tasks;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jReportEmployee;
    private javax.swing.JMenuItem jViewTasks;
    // End of variables declaration//GEN-END:variables
}
