/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryManagement;

import java.awt.event.KeyEvent;
import java.sql.SQLException;  
import java.text.SimpleDateFormat;  
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.time.LocalDate;

/**
 *
 * @author U S E R
 */
public class Lending extends javax.swing.JFrame {

    /**
     * Creates new form Lending
     */
    public Lending() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        MemberID = new javax.swing.JTextField();
        BookID = new javax.swing.JTextField();
        Lend = new javax.swing.JButton();
        Home = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Lending Books");

        jLabel2.setText("Member ID");

        jLabel3.setText("Book ID");

        MemberID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MemberIDActionPerformed(evt);
            }
        });
        MemberID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                MemberIDKeyTyped(evt);
            }
        });

        BookID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookIDActionPerformed(evt);
            }
        });
        BookID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BookIDKeyTyped(evt);
            }
        });

        Lend.setText("Lend");
        Lend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LendActionPerformed(evt);
            }
        });

        Home.setText(" Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(453, 453, 453)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(317, 317, 317)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Lend)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(77, 77, 77)
                                    .addComponent(BookID, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(57, 57, 57)
                                    .addComponent(MemberID, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(Home))))
                .addContainerGap(317, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(178, 178, 178)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2))
                    .addComponent(MemberID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(BookID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(Lend)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(Home)
                .addGap(140, 140, 140))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BookIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookIDActionPerformed

    }//GEN-LAST:event_BookIDActionPerformed

    private void MemberIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MemberIDActionPerformed

    }//GEN-LAST:event_MemberIDActionPerformed

    private void LendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LendActionPerformed
        //Lend button performenece

        SimpleDateFormat DateFormat=new SimpleDateFormat("yyy-MM-dd");
        //taking current date as lending date
        Date LendDate = new Date();
        //taking 14 days after current date as date to submit
        LocalDate DateToSubmit =  LocalDate.now().plusDays(14);
        //converting both dates to string
        String strLendDate=DateFormat.format(LendDate);
        String strDateToSubmit=DateToSubmit.toString();
        //checking is there any empty text field
        if( MemberID.getText().isEmpty() || BookID.getText().isEmpty() ){
            //showing warnning if text fields ara empty
            String message=" Unsuccessful \n Please fill every field of informaion correct" ;
            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);    
         }
        else{
            JFrame f1=new JFrame();
            int a=JOptionPane.showConfirmDialog(f1,"Are you sure you want to create \n a record of lending with above details?");
            //confirmation of adiing details in to database
            if(a==JOptionPane.YES_OPTION){
                //passing values to inserLend method in DbQuery class to insert to lend table of library database and retrieve data from lend table of library database
                try{
                    DbQuery.insertLend( MemberID.getText(),BookID.getText(),strLendDate,strDateToSubmit);            
                }
                catch (SQLException ex) {
                }
            }
        }
    }//GEN-LAST:event_LendActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        // close Add books window
        this.setVisible(false);
        //open Home window
        new Home().setVisible(true);
    }//GEN-LAST:event_HomeActionPerformed

    private void MemberIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MemberIDKeyTyped
        //member id text field validation
        //getting character type input by user
        char c=evt.getKeyChar();
        //getting length of entered text
        int n=MemberID.getText().length();
        //checking if maximum allowed number of characters exceed(10)
        if(n<=9){                
                //cheking is user typing other than numbers
                if((Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
                }
                else{
                   //prevent user typing other than numbers
                   evt.consume();
                   //showing warnning if user trying to type other than numbers
                   String message="Only numbers allowed" ;
                   JFrame f=new JFrame();
                   JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);            
                }
        }
        else{ 
           //prevent user from typing in the text field after reaching number of maximum characters allowed
           evt.consume();
           //showing warnning if user trying to type more than number of characters allowed
           String message="Maximum number of characters allowed(10) have reached" ;
           JFrame f=new JFrame();
           JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_MemberIDKeyTyped

    private void BookIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BookIDKeyTyped
        //book id text field data validation
        //getting character type input by user
        char c=evt.getKeyChar();
        //getting length of entered text
        int n=BookID.getText().length();
        //checking if maximum allowed number of characters exceed(10)
        if(n<=9){                
                //cheking is user typing other than numbers
                if((Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
                }
                else{
                   //prevent user typing other than numbers
                   evt.consume();
                   //showing warnning if user trying to type other than numbers
                   String message="Only numbers allowed" ;
                   JFrame f=new JFrame();
                   JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);            
                }
        }
        else{ 
           //prevent user from typing in the text field after reaching number of maximum characters allowed
           evt.consume();
           //showing warnning if user trying to type more than number of characters allowed(10)
           String message="Maximum number of characters allowed(10) have reached" ;
           JFrame f=new JFrame();
           JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_BookIDKeyTyped

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
            java.util.logging.Logger.getLogger(Lending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lending.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Lending().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField BookID;
    private javax.swing.JButton Home;
    private javax.swing.JButton Lend;
    public static javax.swing.JTextField MemberID;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
