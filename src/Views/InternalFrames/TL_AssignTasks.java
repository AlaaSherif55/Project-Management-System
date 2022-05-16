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

public class TL_AssignTasks extends javax.swing.JInternalFrame {
    public TL_AssignTasks() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        EmployeeTable = new javax.swing.JTable();
        TaskNameLabel = new javax.swing.JLabel();
        TaskNameInput = new javax.swing.JTextField();
        EmployeeIDLabel = new javax.swing.JLabel();
        EmployeeIDInput = new javax.swing.JTextField();
        AssignTaskButton = new javax.swing.JButton();
        TaskInfoLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TaskInfoInput = new javax.swing.JTextArea();

        setClosable(true);

        EmployeeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee Name", "Employee ID", "Salary", "Age"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        EmployeeTable.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(EmployeeTable);
        EmployeeTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        TaskNameLabel.setText("Task Name");

        EmployeeIDLabel.setText("Employee ID");

        EmployeeIDInput.setEditable(false);

        AssignTaskButton.setText("Assign");

        TaskInfoLabel.setText("Task Information");

        TaskInfoInput.setColumns(20);
        TaskInfoInput.setRows(5);
        TaskInfoInput.setWrapStyleWord(true);
        jScrollPane2.setViewportView(TaskInfoInput);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TaskInfoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TaskNameLabel)
                        .addGap(239, 239, 239))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmployeeIDLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(EmployeeIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(AssignTaskButton))
                            .addComponent(TaskNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TaskInfoLabel)
                    .addComponent(TaskNameLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TaskNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(EmployeeIDLabel)
                                .addGap(18, 18, 18)
                                .addComponent(EmployeeIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(AssignTaskButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(37, Short.MAX_VALUE))
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

    public String getTaskInfoInput() {
        return TaskInfoInput.getText();
    }

    public String getTaskNameInput() {
        return TaskNameInput.getText();
    }
    
    public void displaySuccessMessage(String successMessage) {
        JOptionPane.showMessageDialog(this, successMessage, "SUCCESS", JOptionPane.INFORMATION_MESSAGE);
    }
     
    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
    
    public void resetPanelData(){
        EmployeeIDInput.setText("");
        TaskNameInput.setText("");
        TaskInfoInput.setText("");
    }
    
    public void addAssignTaskButtonActionListener(ActionListener listener){
        AssignTaskButton.addActionListener(listener);
    }
    
    public void addEmployeeTableMouseAdapter(MouseAdapter adapter){
        EmployeeTable.addMouseListener(adapter);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AssignTaskButton;
    private javax.swing.JTextField EmployeeIDInput;
    private javax.swing.JLabel EmployeeIDLabel;
    private javax.swing.JTable EmployeeTable;
    private javax.swing.JTextArea TaskInfoInput;
    private javax.swing.JLabel TaskInfoLabel;
    private javax.swing.JTextField TaskNameInput;
    private javax.swing.JLabel TaskNameLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
