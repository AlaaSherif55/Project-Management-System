/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.InternalFrames;

import java.awt.event.MouseListener;
import javax.swing.*;

public class Admin_Projects extends javax.swing.JInternalFrame {

    public void setCompletionBar(int completionRate) {
        this.CompletionBar.setValue(completionRate);
    }

    public void setPMID(String PMID) {
        this.PMID.setText(PMID);
    }

    public void setPMName(String PMName) {
        this.PMName.setText(PMName);
    }

    public JList<String> getProjectList() {
        return ProjectList;
    }

    public void setProjectList(JList<String> ProjectList) {
        this.ProjectList = ProjectList;
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

    public JLabel getjCompletionPercent() {
        return CompletionPercent;
    }

    public void setjCompletionPercent(String jCompletionPercent) {
        this.CompletionPercent.setText(jCompletionPercent);
    }

    public Admin_Projects() {
        initComponents();

    }

    public void AddSelectProjectListener(MouseListener listener) {
        this.ProjectList.addMouseListener(listener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProjectList = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        Label1 = new javax.swing.JLabel();
        ProjectName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CompletionBar = new javax.swing.JProgressBar();
        CompletionPercent = new javax.swing.JLabel();
        Label6 = new javax.swing.JLabel();
        PMName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        PMID = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        TaskTable = new javax.swing.JTable();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        ProjectList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(ProjectList);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jLabel4.setText("Current Tasks");

        Label1.setText("Project Name");

        ProjectName.setEditable(false);

        jLabel2.setText("Completion Rate");

        CompletionBar.setBackground(new java.awt.Color(102, 102, 255));
        CompletionBar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CompletionBar.setName("sdfds"); // NOI18N
        CompletionBar.setOpaque(true);
        CompletionBar.setRequestFocusEnabled(false);
        CompletionBar.setString("");
        CompletionBar.setStringPainted(true);

        CompletionPercent.setText("0%");

        Label6.setText("Project Manager Name");

        PMName.setEditable(false);

        jLabel13.setText("Project Manager ID");

        PMID.setEditable(false);

        TaskTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Task ID", "Task Name", "Employee Name", "Employee ID", "CompletedTask", "TeamLeader Name", "TeamLeader ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(TaskTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(Label1))
                            .addComponent(Label6)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PMName)
                            .addComponent(ProjectName)
                            .addComponent(PMID))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(CompletionBar, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(CompletionPercent)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label1)
                    .addComponent(ProjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label6)
                    .addComponent(PMName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(PMID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(CompletionBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CompletionPercent)))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar CompletionBar;
    private javax.swing.JLabel CompletionPercent;
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label6;
    private javax.swing.JTextField PMID;
    private javax.swing.JTextField PMName;
    private javax.swing.JList<String> ProjectList;
    private javax.swing.JTextField ProjectName;
    private javax.swing.JTable TaskTable;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane7;
    // End of variables declaration//GEN-END:variables
}
