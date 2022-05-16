/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.InternalFrames;

import Views.Panels.Update_Users;
import Views.Panels.Add_User;
import Views.Panels.View_Users;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 *
 * @author soma
 */
public class Admin_ManageUsers extends javax.swing.JInternalFrame {

    /**
     * Creates new form Admin_ManageUsers
     */
    Add_User p1;
    View_Users p2;
    Update_Users p3;
    GridBagLayout layout = new GridBagLayout();

    public Add_User getP1() {
        return p1;
    }

    public void setP1(Add_User p1) {
        this.p1 = p1;
    }

    public View_Users getP2() {
        return p2;
    }

    public void setP2(View_Users p2) {
        this.p2 = p2;
    }

    public Update_Users getP3() {
        return p3;
    }

    public void setP3(Update_Users p3) {
        this.p3 = p3;
    }

    public GridBagLayout getLayout() {
        return layout;
    }

    public void setLayout(GridBagLayout layout) {
        this.layout = layout;
    }

    public Admin_ManageUsers() {
        initComponents();
    }

    public JPanel getDynamicPanel() {
        return DynamicPanel;
    }

    public void setDynamicPanel(JPanel DynamicPanel) {
        this.DynamicPanel = DynamicPanel;
    }

    public void AddViewUsersListener(ActionListener listener) {
        this.ButtonViewUser.addActionListener(listener);
    }

    public void AddUpdateUserListener(ActionListener listener) {
        this.ButtonUpdateUser.addActionListener(listener);
    }

    public void AddAddUserListener(ActionListener listener) {
        this.ButtonAdd.addActionListener(listener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        ButtonAdd = new javax.swing.JButton();
        ButtonViewUser = new javax.swing.JButton();
        ButtonUpdateUser = new javax.swing.JButton();
        DynamicPanel = new javax.swing.JPanel();

        setClosable(true);

        Panel.setBackground(new java.awt.Color(204, 204, 204));

        ButtonAdd.setText("Add User");

        ButtonViewUser.setText("View Users");

        ButtonUpdateUser.setText("Update User");

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonUpdateUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonViewUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(ButtonAdd)
                .addGap(18, 18, 18)
                .addComponent(ButtonViewUser)
                .addGap(18, 18, 18)
                .addComponent(ButtonUpdateUser)
                .addContainerGap(194, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout DynamicPanelLayout = new javax.swing.GroupLayout(DynamicPanel);
        DynamicPanel.setLayout(DynamicPanelLayout);
        DynamicPanelLayout.setHorizontalGroup(
            DynamicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 465, Short.MAX_VALUE)
        );
        DynamicPanelLayout.setVerticalGroup(
            DynamicPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DynamicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(DynamicPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonAdd;
    private javax.swing.JButton ButtonUpdateUser;
    private javax.swing.JButton ButtonViewUser;
    private javax.swing.JPanel DynamicPanel;
    private javax.swing.JPanel Panel;
    // End of variables declaration//GEN-END:variables
}
