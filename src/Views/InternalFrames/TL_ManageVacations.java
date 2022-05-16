/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.InternalFrames;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class TL_ManageVacations extends javax.swing.JInternalFrame {

    public TL_ManageVacations() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        RequestsTable = new javax.swing.JTable();
        EmployeeNameLabel = new javax.swing.JLabel();
        EmployeeNameInput = new javax.swing.JTextField();
        AcceptVacation = new javax.swing.JButton();
        DenyVacation = new javax.swing.JButton();
        RequestsLabel = new javax.swing.JLabel();
        EmployeeIDLabel = new javax.swing.JLabel();
        EmployeeIDInput = new javax.swing.JTextField();

        setClosable(true);

        RequestsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Employee Name", "Start Date", "End Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        RequestsTable.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(RequestsTable);
        RequestsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        EmployeeNameLabel.setText("Employee Name");

        EmployeeNameInput.setEditable(false);

        AcceptVacation.setText("Accept");

        DenyVacation.setText("Deny");

        RequestsLabel.setText("Employees Who Requested Vacation");

        EmployeeIDLabel.setText("Employee ID");

        EmployeeIDInput.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(RequestsLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(EmployeeIDLabel)
                            .addComponent(EmployeeNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(EmployeeIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AcceptVacation)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DenyVacation))
                            .addComponent(EmployeeNameInput))))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(RequestsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmployeeNameLabel)
                    .addComponent(EmployeeNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EmployeeIDLabel)
                    .addComponent(EmployeeIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AcceptVacation)
                    .addComponent(DenyVacation))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JTable getRequestsTable() {
        return RequestsTable;
    }

    public void setRequestsTable(JTable RequestsTable) {
        this.RequestsTable = RequestsTable;
    }

    public String getEmployeeIDInput() {
        return EmployeeIDInput.getText();
    }

    public void setEmployeeIDInput(String id) {
        this.EmployeeIDInput.setText(id);
    }

    public String getEmployeeNameInput() {
        return EmployeeNameInput.getText();
    }

    public void setEmployeeNameInput(String name) {
        this.EmployeeNameInput.setText(name);
    }
    
    public void displaySuccessMessage(String successMessage) {
        JOptionPane.showMessageDialog(this, successMessage, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
    }
     
    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    public void resetPanelData() {
        EmployeeIDInput.setText("");
        EmployeeNameInput.setText("");
    }
    
    public void addAcceptVacationButtonActionListener(ActionListener listener){
        AcceptVacation.addActionListener(listener);
    }
    
    public void addDenyVacationButtonActionListener(ActionListener listener){
        DenyVacation.addActionListener(listener);
    }
    
    public void addRequestsTableMouseListener(MouseAdapter listener){
        RequestsTable.addMouseListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AcceptVacation;
    private javax.swing.JButton DenyVacation;
    private javax.swing.JTextField EmployeeIDInput;
    private javax.swing.JLabel EmployeeIDLabel;
    private javax.swing.JTextField EmployeeNameInput;
    private javax.swing.JLabel EmployeeNameLabel;
    private javax.swing.JLabel RequestsLabel;
    private javax.swing.JTable RequestsTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    public JTable getReportList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
