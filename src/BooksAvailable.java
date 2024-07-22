/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Paule
 */

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class BooksAvailable extends javax.swing.JFrame {

    /**
     * Creates new form BooksAvailable
     */
    public BooksAvailable() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BOOK_ID", "CATEGORY", "NAME", "AUTHOR", "COPIES"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("FETCH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fetchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void fetchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fetchActionPerformed

        /**
        * Retrieves the DefaultTableModel associated with the jTable1 component.
        * 
        * This model is used to manage and manipulate the data displayed in the table.
        */
        DefaultTableModel model= (DefaultTableModel)jTable1.getModel();
        /**
        * Specifies the database connection details.
        * 
        * - `url`: The JDBC URL for connecting to the MySQL database. It includes the hostname (localhost) and 
        database name (library).
        * - `user`: The username used to authenticate with the database (root account).
        * - `pwd`: The password for the database user.
        */
        String url="jdbc:mysql://localhost/library";
        String user="root"; // Database username
        String pwd="Ezennolim123!"; // Database password
        /**
        * SQL query to retrieve all records from the `books` table.
        * 
        * This query fetches all columns for each row in the `books` table from the database.
        */
        String query="select * from books;";
        
        try {
            // Establish a connection to the MySQL database using the provided URL, username, and password.
            Connection conn = DriverManager.getConnection(url, user, pwd); 
            Statement stm = conn.createStatement();
            /*Execute the SQL query to retrieve all records from the `books` table.
            The result is stored in a ResultSet object for further processing.
            */
            ResultSet rs = stm.executeQuery(query); 
            
            /**
            * Iterates over each row in the ResultSet.
            * 
            * The loop continues as long as there are more rows to process. For each row, it retrieves the values of all columns
            from the `books` table. The loop exits when there are no more rows in the ResultSet.
            */
            while(rs.next()) {
                /**
                * Retrieves values from the current row in the ResultSet and stores them in corresponding variables.
                * 
                * - `bookid`: Value from the "BOOK_ID" column.
                * - `category`: Value from the "CATEGORY" column.
                * - `name`: Value from the "NAME" column.
                * - `author`: Value from the "AUTHOR" column.
                * - `copies`: Value from the "COPIES" column (retrieved as an integer).
                */
                String bookid = rs.getString("BOOK_ID"); // column names
                String category = rs.getString("CATEGORY");
                String name = rs.getString("NAME");
                String author = rs.getString("AUTHOR");
                int copies = rs.getInt("COPIES");
                /**
                * Adds a new row to the table model with the fetched values from the current row of the ResultSet.
                * 
                * The `addRow` method of the `DefaultTableModel` is used to insert the values for "BOOK_ID", "CATEGORY", 
                * "NAME", "AUTHOR", and "COPIES" into a new row of the table.
                */
                model.addRow(new Object[] {bookid, category, name, author, copies});
                }
            /**
            * Closes the ResultSet and Statement objects after all rows have been processed.
            * 
            * Once all rows have been fetched and added to the table model, the ResultSet (`rs`) and Statement (`stm`) 
            * are closed to release database resources.
            */
            rs.close();
            stm.close();
            } catch(Exception e) { // Catch block to handle any errors
                // Display an error message if an exception occurs during database operations
                JOptionPane.showMessageDialog(this, e.getMessage()); 
            }
    }//GEN-LAST:event_fetchActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed

        // This will dispose the books available window and the user will move back to the dashboard window
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(BooksAvailable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BooksAvailable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BooksAvailable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BooksAvailable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BooksAvailable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
