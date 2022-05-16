/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.Frames;

import Views.InternalFrames.Admin_ManageUsers;
import Views.InternalFrames.Admin_Projects;
import javax.swing.JDesktopPane;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;

public class AdminView extends javax.swing.JFrame {
    private Admin_Projects AdminProjectsView;
    private Admin_ManageUsers AdminManageUsersView;
    
    public AdminView() {
        initComponents();
    }

    public Admin_Projects getAdminProjectsView() {
        return AdminProjectsView;
    }

    public void setAdminProjectsView(Admin_Projects AdminProjectsView) {
        this.AdminProjectsView = AdminProjectsView;
    }

    public Admin_ManageUsers getAdminManageUsersView() {
        return AdminManageUsersView;
    }

    public void setAdminManageUsersView(Admin_ManageUsers AdminManageUsersView) {
        this.AdminManageUsersView = AdminManageUsersView;
    }

    public void AddToDesktop(JInternalFrame frame) {
        Desktop.add(frame);
    }

    public JMenuItem getManageUsers() {
        return ManageUsers;
    }

    public void setManageUsers(JMenuItem jManageUsers) {
        this.ManageUsers = jManageUsers;
    }

    public JMenuItem getViewProjects() {
        return ViewProjects;
    }

    public void setViewProjects(JMenuItem jViewProjects) {
        this.ViewProjects = jViewProjects;
    }
    
    public void addViewProjectsActionListener(ActionListener ActionViewProjects){
        ViewProjects.addActionListener(ActionViewProjects);
    }
    
    public void addManageUsersActionListener(ActionListener ActionManageUsers){
        ManageUsers.addActionListener(ActionManageUsers);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Desktop = new javax.swing.JDesktopPane();
        MenuBar = new javax.swing.JMenuBar();
        Projects = new javax.swing.JMenu();
        ViewProjects = new javax.swing.JMenuItem();
        MangeUsers = new javax.swing.JMenu();
        ManageUsers = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AdminDashboard");

        javax.swing.GroupLayout DesktopLayout = new javax.swing.GroupLayout(Desktop);
        Desktop.setLayout(DesktopLayout);
        DesktopLayout.setHorizontalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        DesktopLayout.setVerticalGroup(
            DesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );

        Projects.setText("Projects");

        ViewProjects.setText("View");
        Projects.add(ViewProjects);

        MenuBar.add(Projects);

        MangeUsers.setText("Manage");

        ManageUsers.setText("Manage Users");
        MangeUsers.add(ManageUsers);

        MenuBar.add(MangeUsers);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Desktop, javax.swing.GroupLayout.Alignment.TRAILING)
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
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane Desktop;
    private javax.swing.JMenuItem ManageUsers;
    private javax.swing.JMenu MangeUsers;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JMenu Projects;
    private javax.swing.JMenuItem ViewProjects;
    // End of variables declaration//GEN-END:variables
}
