/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.InternalFrames;

import javax.swing.JTable;

public class PM_Project extends javax.swing.JInternalFrame {

    public void setCompletionBar(int CompletionBar) {
        this.CompletionBar.setValue(CompletionBar);
    }

    public void setCompletionPercent(String CompletionPercent) {
        this.CompletionPercent.setText(CompletionPercent);
    }

    public void setProjectName(String ProjectName) {
        this.ProjectName.setText(ProjectName);
    }

    public JTable getTaskTable() {
        return TaskTable;
    }

    public void setTaskTable(JTable TaskTable) {
        this.TaskTable = TaskTable;
    }
    
    
    public PM_Project() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CompletionBar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        ProjectName = new javax.swing.JTextField();
        CompletionPercent = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TaskTable = new javax.swing.JTable();

        setClosable(true);

        jLabel4.setText("Current Tasks");

        jLabel2.setText("Completion Rate");

        CompletionBar.setBackground(new java.awt.Color(0, 51, 204));
        CompletionBar.setMinimumSize(new java.awt.Dimension(10, 16));
        CompletionBar.setName(""); // NOI18N

        jLabel1.setText("Project Name");

        ProjectName.setEditable(false);

        CompletionPercent.setText("0%");

        TaskTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Task ID", "Task Name", "Task Info", "Task Completed", "Employee Name", "Employee ID", "TeamLeader Name", "TeamLeader ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(TaskTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CompletionBar, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(CompletionPercent))
                    .addComponent(ProjectName))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(CompletionBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CompletionPercent))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar CompletionBar;
    private javax.swing.JLabel CompletionPercent;
    private javax.swing.JTextField ProjectName;
    private javax.swing.JTable TaskTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
