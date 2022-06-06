/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryManagement;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author U S E R
 */
public class AddBooks extends javax.swing.JFrame {

    /**
     * Creates new form Add_Or_Delete_Books
     */
    public AddBooks() {
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BookName = new javax.swing.JTextField();
        Author = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        Add = new javax.swing.JButton();
        Home = new javax.swing.JButton();
        PubYear = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Book Name");

        jLabel3.setText("Author");

        jLabel4.setText("Published Year");

        BookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookNameActionPerformed(evt);
            }
        });
        BookName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                BookNameKeyTyped(evt);
            }
        });

        Author.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                AuthorKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Add Books");

        Add.setText("Add");
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        PubYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PubYearActionPerformed(evt);
            }
        });
        PubYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                PubYearKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(292, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(458, 458, 458))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Home)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(61, 61, 61)
                                    .addComponent(BookName, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(87, 87, 87)
                                    .addComponent(Author, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(PubYear, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(441, 441, 441)
                                    .addComponent(Add))))
                        .addGap(292, 292, 292))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel1))
                    .addComponent(BookName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel3))
                    .addComponent(Author, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PubYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(48, 48, 48)
                .addComponent(Add)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                .addComponent(Home)
                .addGap(140, 140, 140))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookNameActionPerformed

    }//GEN-LAST:event_BookNameActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        //add button performence
        //getting length of entered text
        int n=PubYear.getText().length();
        //checking is there are any empty or incorrect text field
        if(BookName.getText().isEmpty() || Author.getText().isEmpty() || n!=4 ){
            //showing a warnning if there any invalid data entered
            String message=" Unsuccessful \n Please fill every field of informaion correct" ;
            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);
        }
        else{
            JFrame f1=new JFrame();
            int a=JOptionPane.showConfirmDialog(f1,"Are you sure you want to create \n a record for a book with above details?");  
            //confirmation of adiing details in to database
            if(a==JOptionPane.YES_OPTION){
                //passing values to insertBook method in DbQuery class to insert to book table of library database & for retrieve data from book table of library database
                try {
                    DbQuery.insertBook(BookName.getText(), Author.getText() ,PubYear.getText());
                } 
                catch (SQLException ex) {
                }
            }    
        }
    }//GEN-LAST:event_AddActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        // close Add books window
        this.setVisible(false);
        //open Home window
        new Home().setVisible(true);
    }//GEN-LAST:event_HomeActionPerformed

    private void BookNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BookNameKeyTyped
        //Book Name text field data validation
        //getting length of entered text
        int n=BookName.getText().length();
        //checking if maximum allowed number of characters exceed(50)
        if(n<=49){
            //getting type of entered character
            char c=evt.getKeyChar();
            //cheking is user typing other than simple letters or numbers
            if((Character.isLowerCase(c)||Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_SPACE))){
            }
            else{
               //prevent user typing other than simple letters or numbers
               evt.consume();
               //showing warnning if user entered other than simple letter or number
               String message="Only simple letters and numbers allowed" ;
               JFrame f=new JFrame();
               JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);            
            }
        }
        else{  
          //prevent user from typing in the text field after reaching number of maximum characters allowed(50)
          evt.consume();
          //showin warnning if user trying to type more than limit of allowed number of characters
          String message="Maximum number of characters allowed(50) have reached" ;
          JFrame f=new JFrame();
          JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);
        }        
    }//GEN-LAST:event_BookNameKeyTyped

    private void AuthorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AuthorKeyTyped
        //Author text field data validation
        //getting length of entered text
        int n=Author.getText().length();
        //checking if maximum allowed number of characters exceed(50)
        if(n<=49){
            char c=evt.getKeyChar();
            //cheking is user typing other than simple letters
            if((Character.isLowerCase(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)||(c==KeyEvent.VK_SPACE))){
            }
            else{
               //prevent user typing other than simple letters
               evt.consume();
               String message="Only simple letters allowed" ;
               JFrame f=new JFrame();
               JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);            
            }
        }
        else{  
          //prevent user from typing in the text field after reaching number of maximum characters allowed(50)
          evt.consume();
          //showin warnning if user trying to type more than limit of allowed number of characters
          String message="Maximum number of characters allowed(50) have reached" ;
          JFrame f=new JFrame();
          JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_AuthorKeyTyped

    private void PubYearKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PubYearKeyTyped
        //Pub year text field data validation
        //getting character type input by user
        char c=evt.getKeyChar();
        //getting length of entered text
        int n=PubYear.getText().length();
        //increment the value of n if user typed anything other than back space or delete key for to run the programme properly in the way it needs to run
        if((c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE)){   
        }
        else{
            n++;            
        }
        //checking if maximum allowed number of characters exceed(4)
        if(n<=4){                
            //cheking is user typing other than numbers
            if((Character.isDigit(c)||(c==KeyEvent.VK_BACK_SPACE)||(c==KeyEvent.VK_DELETE))){
                //setting text color black if only there are 4 digits and red otherwise
                if(n==4){
                PubYear.setForeground(Color.BLACK);
                }
                else{
                PubYear.setForeground(Color.RED);
                }
            }
            else{
               //prevent user typing other than numbers
               evt.consume();
               //showing warnning if user trying to enter anything other than numbers
               String message="Only numbers allowed" ;
               JFrame f=new JFrame();
               JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);            
            }
        }
        else{ 
           //prevent user from typing in the text field after reaching number of maximum characters allowed(4)
           evt.consume();
           //showin warnning if user trying to type more than limit of allowed number of characters 
           String message="Maximum number of characters allowed(4) have reached" ;
           JFrame f=new JFrame();
           JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_PubYearKeyTyped

    private void PubYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PubYearActionPerformed

    }//GEN-LAST:event_PubYearActionPerformed

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
            java.util.logging.Logger.getLogger(AddBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new AddBooks().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    public static javax.swing.JTextField Author;
    public static javax.swing.JTextField BookName;
    private javax.swing.JButton Home;
    public static javax.swing.JTextField PubYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}