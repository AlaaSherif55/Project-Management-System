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

public class TL_ManagePenalities extends javax.swing.JInternalFrame {

    public TL_ManagePenalities() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        EmployeeTable = new javax.swing.JTable();
        PenalityReasonLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PenalityReasonInput = new javax.swing.JTextArea();
        PenalityLabel = new javax.swing.JLabel();
        PenalityInput = new javax.swing.JTextField();
        EmployeeIDLabel = new javax.swing.JLabel();
        EmployeeIDInput = new javax.swing.JTextField();
        AssignPenalityButton = new javax.swing.JButton();

        setClosable(true);

        EmployeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee ID", "Employee Name", "Current Tasks", "Completed Tasks", "Penality"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EmployeeTable.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(EmployeeTable);
        EmployeeTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        PenalityReasonLabel.setText("Penality Reason");

        PenalityReasonInput.setColumns(20);
        PenalityReasonInput.setRows(5);
        jScrollPane2.setViewportView(PenalityReasonInput);

        PenalityLabel.setText("Penality ");

        EmployeeIDLabel.setText("Employee ID");

        EmployeeIDInput.setEditable(false);

        AssignPenalityButton.setText("Assign");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PenalityReasonLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PenalityLabel)
                    .addComponent(EmployeeIDLabel)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(EmployeeIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AssignPenalityButton))
                    .addComponent(PenalityInput, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PenalityReasonLabel)
                    .addComponent(PenalityLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PenalityInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EmployeeIDLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EmployeeIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AssignPenalityButton)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public JTable getEmployeeTable() {
        return EmployeeTable;
    }

    public void setEmployeeTable(JTable TaskTable) {
        this.EmployeeTable = TaskTable;
    }

    public String getEmployeeIDInput() {
        return EmployeeIDInput.getText();
    }
    
    public void setEmployeeIDInput(String id) {
        EmployeeIDInput.setText(id);
    }

    public String getPenalityReasonInput() {
        return PenalityReasonInput.getText();
    }

    public String getPenalityInput() {
        return PenalityInput.getText();
    }
    
    public void displaySuccessMessage(String successMessage) {
        JOptionPane.showMessageDialog(this, successMessage, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
    }
     
    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    public void resetPanelData() {
        PenalityInput.setText("");
        EmployeeIDInput.setText("");
        PenalityReasonInput.setText("");
    }
    
    public void addAssignPenalityButtonActionListener(ActionListener listener){
        AssignPenalityButton.addActionListener(listener);
    }
    
    public void addEmployeeTableMouseAdapter(MouseAdapter adapter){
        EmployeeTable.addMouseListener(adapter);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AssignPenalityButton;
    private javax.swing.JTextField EmployeeIDInput;
    private javax.swing.JLabel EmployeeIDLabel;
    private javax.swing.JTable EmployeeTable;
    private javax.swing.JTextField PenalityInput;
    private javax.swing.JLabel PenalityLabel;
    private javax.swing.JTextArea PenalityReasonInput;
    private javax.swing.JLabel PenalityReasonLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
