/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Frames;
import Views.InternalFrames.TL_ViewPenalities;
import Views.InternalFrames.TL_AssignTasks;
import Views.InternalFrames.TL_ManagePenalities;
import Views.InternalFrames.TL_ViewReports;
import Views.InternalFrames.TL_ViewVacations;
import Views.InternalFrames.TL_ViewTasks;
import Views.InternalFrames.TL_ManageVacations;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class TeamLeaderView extends javax.swing.JFrame {
    TL_ViewTasks TeamLeaderViewTasks;
    TL_ViewReports TeamLeaderViewReports;
    TL_AssignTasks TeamLeaderAssignTasks;
    TL_ViewVacations TeamLeaderViewVacations;
    TL_ManageVacations TeamLeaderManageVacations;
    TL_ViewPenalities TeamLeaderViewPenalities;
    TL_ManagePenalities TeamLeaderManagePenalities;
    
    public TeamLeaderView() {
        initComponents();
    }

    public TL_ViewTasks getTeamLeaderViewTasks() {
        return TeamLeaderViewTasks;
    }

    public void setTeamLeaderViewTasks(TL_ViewTasks TeamLeaderViewTasks) {
        this.TeamLeaderViewTasks = TeamLeaderViewTasks;
    }

    public TL_ViewReports getTeamLeaderViewReports() {
        return TeamLeaderViewReports;
    }

    public void setTeamLeaderViewReports(TL_ViewReports TeamLeaderViewReports) {
        this.TeamLeaderViewReports = TeamLeaderViewReports;
    }

    public TL_AssignTasks getTeamLeaderAssignTasks() {
        return TeamLeaderAssignTasks;
    }

    public void setTeamLeaderAssignTasks(TL_AssignTasks TeamLeaderAssignTasks) {
        this.TeamLeaderAssignTasks = TeamLeaderAssignTasks;
    }

    public TL_ViewVacations getTeamLeaderViewVacations() {
        return TeamLeaderViewVacations;
    }

    public void setTeamLeaderViewVacations(TL_ViewVacations TeamLeaderViewVacations) {
        this.TeamLeaderViewVacations = TeamLeaderViewVacations;
    }

    public TL_ManageVacations getTeamLeaderManageVacations() {
        return TeamLeaderManageVacations;
    }

    public void setTeamLeaderManageVacations(TL_ManageVacations TeamLeaderManageVacations) {
        this.TeamLeaderManageVacations = TeamLeaderManageVacations;
    }

    public TL_ViewPenalities getTeamLeaderViewPenalities() {
        return TeamLeaderViewPenalities;
    }

    public void setTeamLeaderViewPenalities(TL_ViewPenalities TeamLeaderViewPenalities) {
        this.TeamLeaderViewPenalities = TeamLeaderViewPenalities;
    }

    public TL_ManagePenalities getTeamLeaderManagePenalities() {
        return TeamLeaderManagePenalities;
    }

    public void setTeamLeaderManagePenalities(TL_ManagePenalities TeamLeaderManagePenalities) {
        this.TeamLeaderManagePenalities = TeamLeaderManagePenalities;
    }

    public JDesktopPane getDesktop() {
        return Desktop;
    }

    public void AddToDesktop(JInternalFrame frame) {
        Desktop.add(frame);
    }
    
    public void addAssignTaskActionListener(ActionListener listener){
        jAssignTask.addActionListener(listener);
    }
    
    public void addManagePenalitiesActionListener(ActionListener listener){
        jManagePenalities.addActionListener(listener);
    }
    
    public void addManageVacationActionListener(ActionListener listener){
        jManageVacation.addActionListener(listener);
    }
    
    public void addViewPenalitiesActionListener(ActionListener listener){
        jViewPenalities.addActionListener(listener);
    }
    
    public void addViewReportsActionListener(ActionListener listener){
        jViewReports.addActionListener(listener);
    }
    
    public void addViewTasksActionListener(ActionListener listener){
        jViewTasks.addActionListener(listener);
    }
    
    public void addMViewVacationsActionListener(ActionListener listener){
        jViewVacations.addActionListener(listener);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desktop = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        Tasks = new javax.swing.JMenu();
        jViewTasks = new javax.swing.JMenuItem();
        jAssignTask = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jViewVacations = new javax.swing.JMenuItem();
        jManageVacation = new javax.swing.JMenuItem();
        jViewPenalities = new javax.swing.JMenuItem();
        jManagePenalities = new javax.swing.JMenuItem();
        jViewReports = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Team Leader Dashboard");

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
        );

        Tasks.setText("Tasks");

        jViewTasks.setText("View");
        Tasks.add(jViewTasks);

        jAssignTask.setText("Assign");
        Tasks.add(jAssignTask);

        jMenuBar1.add(Tasks);

        jMenu2.setText("Manage Employee");

        jViewVacations.setText("View Vacations");
        jViewVacations.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jViewVacationsActionPerformed(evt);
            }
        });
        jMenu2.add(jViewVacations);

        jManageVacation.setText("Manage Vacation Request");
        jMenu2.add(jManageVacation);

        jViewPenalities.setText("View Penalities");
        jMenu2.add(jViewPenalities);

        jManagePenalities.setText("Manage Penalities");
        jMenu2.add(jManagePenalities);

        jViewReports.setText("View Project Manager Reports");
        jMenu2.add(jViewReports);

        jMenuBar1.add(jMenu2);

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

    private void jViewVacationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jViewVacationsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jViewVacationsActionPerformed

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
            java.util.logging.Logger.getLogger(TeamLeaderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TeamLeaderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TeamLeaderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TeamLeaderView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TeamLeaderView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenu Tasks;
    private javax.swing.JMenuItem jAssignTask;
    private javax.swing.JMenuItem jManagePenalities;
    private javax.swing.JMenuItem jManageVacation;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jViewPenalities;
    private javax.swing.JMenuItem jViewReports;
    private javax.swing.JMenuItem jViewTasks;
    private javax.swing.JMenuItem jViewVacations;
    // End of variables declaration//GEN-END:variables
}
