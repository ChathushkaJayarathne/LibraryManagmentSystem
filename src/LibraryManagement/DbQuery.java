/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibraryManagement;

import java.sql.*;
import net.proteanit.sql.DbUtils;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author U S E R
 */
public class DbQuery {
        
    /**
     *
     * @param bookName
     * @param author
     * @param year
     * @throws SQLException
     */
    
    //method for query of insert & retrieve user given data from book table of library database
    public static void insertBook(String bookName , String author , String year) throws SQLException{       
    //query of insert user given data to book table of library database for store
    String sql = "INSERT INTO book (book_name,author,pub_year) VALUES ("+"'"+bookName+"'"+","+"'"+author+"'"+","+"'"+year+"'"+");";
    //query of retrieve user given data from book table of library database for display those data & to see book id
    String sql1 = "SELECT book_id,book_name FROM book WHERE book_name="+"'"+bookName+"'"+" AND author="+"'"+author+"'"+" AND pub_year="+"'"+year+"'"+"  ";        
    try {   
        //execute insert data query
        DatabaseConnector.getCon().createStatement().executeUpdate(sql);
        PreparedStatement ps = DatabaseConnector.getCon().prepareStatement(sql1);
        //execute retrieve data query
        ResultSet rs = ps.executeQuery();
        if(rs.first()){
            //display book_id and notification of success   
            String message=" Successfully Add the book. \n The Book ID of " +rs.getString(2)+ " is " +rs.getString(1) ;
            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,message);
            //clear & reset input fields from previous entered data by user 
            AddBooks.BookName.setText("");
            AddBooks.Author.setText("");
            AddBooks.PubYear.setText("");                               
        }     
    } 
    catch (Exception ex) {
        //Showing warnning if sql query won't work
        String message="Error, Something is wrong \n Recheck detalis you enter and try again" ;
        JFrame f=new JFrame();
        JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);         
    } 
    finally {
    }
}
      
    /**
     *
     * @param Name
     * @param NIC
     * @param Contact
     * @throws SQLException
     */
    //method for query of insert & retrieve user given data from member table of library database
    public static void insertMember(String Name,String NIC,String Contact) throws SQLException{
    //query of insert user given data to member table of library database for store
    String sql = "INSERT INTO member (name,nic,contact) VALUES ("+"'"+Name+"'"+","+"'"+NIC+"'"+","+"'"+Contact+"'"+");";
    //query of retrieve user given data from member table of library database for displaythose data & to see member id
    String sql1 = "SELECT mem_id,name FROM member WHERE name="+"'"+Name+"'"+" AND nic="+"'"+NIC+"'"+" AND contact="+"'"+Contact+"'"+"";
    try {
        //execute insert data query
        DatabaseConnector.getCon().createStatement().executeUpdate(sql);
        PreparedStatement ps = DatabaseConnector.getCon().prepareStatement(sql1);
        //execute retrieve data query
        ResultSet rs = ps.executeQuery();			
        if(rs.first())
        {           	
            //display mem_id and notification of success   
            String message=" Successfully Add the member. \n The Member ID of " +rs.getString(2)+ " is " +rs.getString(1) ;
            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,message);
            //clear & reset input fields from previous entered data by user
            AddMembers.Name.setText("");
            AddMembers.Contact.setText("");
            AddMembers.NIC.setText("");            
        }
    } 
    catch (Exception ex) {
        //Showing warnning if sql query won't work
        String message="Error, Something is wrong \n Recheck detalis you enter and try again" ;
        JFrame f=new JFrame();
        JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);       
    } 
    finally {   
    }
}
        
    /**
     *
     * @param MemberID
     * @param BookID
     * @param strLendDate
     * @param strDateToSubmit
     * @throws SQLException
     */
    //method for query of lending a book 
    public static void insertLend(String MemberID,String BookID,String strLendDate,String strDateToSubmit) throws SQLException{
        //query of insert user given data to lend table of library database for store
        String sql = "INSERT INTO lend (mem_id,book_id,len_date,sub_date) VALUES ("+"'"+MemberID+"'"+","+"'"+BookID+"'"+","+"'"+strLendDate+"'"+","+"'"+strDateToSubmit+"'"+");";
        //query of retrieve user given data from lend table of library database for display those data & to see lend_id
        String sql1 = "SELECT lend_id,sub_date FROM lend WHERE mem_id="+"'"+MemberID+"'"+" AND book_id="+"'"+BookID+"'"+" AND  len_date="+"'"+strLendDate+"'"+" AND sub_date="+"'"+strDateToSubmit+"'"+"   ";
        //query of retrive records if given book id is already lended and not sumbitted yet
        String sql2 = "SELECT lend_id,mem_id,len_date,sub_date FROM lend WHERE book_id="+"'"+BookID+"'"+" AND sub_status=0 ";
        //query to get number of records of not yet submitted books lend under given member id        
        String sql3 = "SELECT COUNT(*) as row FROM lend WHERE mem_id="+"'"+MemberID+"'"+" AND sub_status=0 ";
        try{ 
            PreparedStatement ps1 = DatabaseConnector.getCon().prepareStatement(sql3);
            //execute query to get number of records of not yet submitted books lend under given member id
            ResultSet rs1 = ps1.executeQuery();
            //initializing a variable for value of number of rows
            int Nrow = -1;
            while(rs1.next()){
                Nrow=rs1.getInt("row");
            }
            //check is maximum amount of lend allowed at a time(3) is exceeded
            if(Nrow<3){
                PreparedStatement ps2 = DatabaseConnector.getCon().prepareStatement(sql2);
                //execute retrieve data query for check is given book already lended and not sumbitted yet
                ResultSet rs2 = ps2.executeQuery();	
                if(rs2.first()){
                    //showing warnning if given book already lended and not sumbitted yet
                    String message=" Error, Something is wrong \n The book under Book ID " +BookID+ " is currently unavailable \n And already lended under Lend ID " +rs2.getString(1)+ " by member " +rs2.getString(2)+ " "
                            + "on " +rs2.getString(3)+ " \n Date To Sumbit is " +rs2.getString(4)+ " and have not submitted yet " ;
                    JFrame f=new JFrame();
                    JOptionPane.showMessageDialog(f,message);                
                }
                else{
                    //execute insert data query if given book uvailable
                    DatabaseConnector.getCon().createStatement().executeUpdate(sql);
                    PreparedStatement ps = DatabaseConnector.getCon().prepareStatement(sql1);
                    //execute retrieve data query
                    ResultSet rs = ps.executeQuery();
                    if(rs.first())
                    {           	
                        //display lend_id and notification of success
                        String message=" Successfully add the lending record. \n The Lend ID is " +rs.getString(1)+ " and Date To Sumbit is " +rs.getString(2) ;
                        JFrame f=new JFrame();
                        JOptionPane.showMessageDialog(f,message);
                        Lending.MemberID.setText("");
                        Lending.BookID.setText("");
                    }
                }
            }
            else{
                //showing a warnning if maximum amount of lend allowed at a time(3) is exceeded                
                String message="Sorry, \n Maximum amount of lend allowed at a time(3) is exceeded for this Member ID" ;
                JFrame f=new JFrame();
                JOptionPane.showMessageDialog(f,message);                
            }
        } 
        catch (Exception ex) {
            //Showing warnning if sql query won't work
            String message="Error, Something is wrong \n Such a Member ID or Book ID doesn't exist \n Recheck detalis you enter and try again" ;
            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE); 
        } 
        finally {   
        }
    }
    //method for query of sumbit a book       
    public static void Submit(String LendID) throws SQLException{
        String message;
        //query of update user given data of lend table of library database for store
        String sql = "UPDATE lend SET sub_status = 1 WHERE lend_id ="+"'"+LendID+"'"+";";
        //query of retrieve user given data from lend table of library database for display those data & to see lend_id &
        //chech sumbition status before submition attempt to make sure sumbition isn't already done
        String sql1 = "SELECT lend_id,mem_id,book_id,sub_date,sub_status FROM lend WHERE lend_id="+"'"+LendID+"'"+" ";
        try {
            PreparedStatement ps = DatabaseConnector.getCon().prepareStatement(sql1);
            //execute retrieve data query 
            ResultSet rs = ps.executeQuery();	            
            if(rs.first())
            {
                //check submition status before submittion attempt
                if((rs.getString(5)).equals("1")){
                    //showing warnning if submittion of given lend id is already done
                    message="Error, Something is wrong \n Submittion of this Lend ID already done" ; 
                    JFrame f=new JFrame();
                    JOptionPane.showMessageDialog(f,message);
                }
                else{
                    //execute update data query if not already submitted
                    DatabaseConnector.getCon().createStatement().executeUpdate(sql);
                    //display a notification of success
                    message=" Successfully updated the submittion status to submited of \n Lend ID " +rs.getString(1)+ " with  Member ID " +rs.getString(2)+ " and Book ID " +rs.getString(3)+""
                        + "\n the Date to Submit was  "+rs.getString(4) ; 
                    JFrame f=new JFrame();
                    JOptionPane.showMessageDialog(f,message);
                    //cleare previous entered data
                    Submit.LendID.setText("");
                    Submit.SubStatus.setSelected(false);
                }
            } 
            else{
                //showing warnning if such a lend id is does not exist
                message=" Error, Something is wrong \n Such a Lend ID does not exist" ;
                JFrame f=new JFrame();
                JOptionPane.showMessageDialog(f,message);
           }         
        } 
        catch (Exception ex) {
            //Showing warnning if sql query won't work
            message="Error, Something is wrong \n Recheck detalis you enter and try again" ;
            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);            
        } 
        finally {   
        }
    } 
    //method of query of search books by name          
    public static void SBookName(String BookName) throws SQLException{ 
        //query of selecting data as user given data
        String sql= "SELECT * FROM book WHERE book_name like "+"'%"+BookName+"%'"+" ";
        try {
            //same query was has to run twise,otherwise if retreive data has only one row it will not display and
            //if retreive data set have more than one row it will miss the first row when it display
            //execute retrieve data query for 1st time to check search result is not null
            PreparedStatement ps = DatabaseConnector.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            //execute retrieve data query for 2nd time to use it for display data in table
            PreparedStatement ps1 = DatabaseConnector.getCon().prepareStatement(sql);
            ResultSet rs1 = ps1.executeQuery();            
            if(rs.first()){
                //set retreived data in to the table if there are search results
                Search.Table.setModel(DbUtils.resultSetToTableModel(rs1));               
            }
            else{
                Search.Table.setModel(DbUtils.resultSetToTableModel(rs1));
                //display notification if no searh results
                String message=" No search result" ;
                JFrame f=new JFrame();
                JOptionPane.showMessageDialog(f,message);
            }
        } 
        catch (Exception ex) {
            //display notification if no searh results
            String message=" No search result" ;
            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);             
        } 
        finally {   
        }
    }
    //method of query of search books by name of author       
    public static void SAuthor(String Author) throws SQLException{
        //query of selecting data as user given data
        String sql= "SELECT * FROM book WHERE author like "+"'%"+Author+"%'"+" ";
        try {
            //same query was has to run twise,otherwise if retreive data has only one row it will not display and
            //if retreive data set have more than one row it will miss the first row when it display
            //execute retrieve data query for 1st time to check search result is not null
            PreparedStatement ps = DatabaseConnector.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           //execute retrieve data query for 2nd time to use it for display data in table            
            PreparedStatement ps1 = DatabaseConnector.getCon().prepareStatement(sql);
            ResultSet rs1 = ps1.executeQuery();
            if(rs.first()){
                //set retreived data in to the table if there are search results
                Search.Table.setModel(DbUtils.resultSetToTableModel(rs1)); 
            }
            else{
                Search.Table.setModel(DbUtils.resultSetToTableModel(rs1));                
                //display notification if no searh results
                String message=" No search result" ;
                JFrame f=new JFrame();
                JOptionPane.showMessageDialog(f,message);
            }
        } 
        catch (Exception ex) {
            //display notification if no searh results
            String message=" No search result" ;
            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);            
        } 
        finally {   
        }
   }

    /**
     *
     * @param MinYear
     * @param MaxYear
     * @throws SQLException
     */
    //method of query of search books by biplished year
    public static void SPubYear(String MinYear,String MaxYear) throws SQLException{
        //setting value of MaxYear=9999 if max year was not given by user
        if(MaxYear.length()==0){
            MaxYear="9999";
        }
        //query of selecting data as user given data
        String sql= "SELECT * FROM book WHERE pub_year>="+"'"+MinYear+"'"+" AND pub_year<="+"'"+MaxYear+"'"+" ";
        try {
            //same query was has to run twise,otherwise if retreive data has only one row it will not display and
            //if retreive data set have more than one row it will miss the first row when it display
            //execute retrieve data query for 1st time to check search result is not null
            PreparedStatement ps = DatabaseConnector.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           //execute retrieve data query for 2nd time to use it for display data in table             
            PreparedStatement ps1 = DatabaseConnector.getCon().prepareStatement(sql);
            ResultSet rs1 = ps1.executeQuery();            
            if(rs.first()){
                //set retreived data in to the table if there are search results
                Search.Table.setModel(DbUtils.resultSetToTableModel(rs1));                 
            }
            else{
                Search.Table.setModel(DbUtils.resultSetToTableModel(rs1));
                //display notification if no searh results
                String message=" No search result" ;
                JFrame f=new JFrame();
                JOptionPane.showMessageDialog(f,message);
            }
        } 
        catch (Exception ex) {
            //display notification if no searh results
            String message=" No search result" ;
            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);            
        } 
        finally {   
        }
    }

    /**
     *
     * @param strSSubDelay
     * @throws SQLException
     */
    //method of query of search books by delayed submittion    
    public static void SSubDelay(String strSSubDelay) throws SQLException{
        //query of selecting data as user given data
        String sql= "SELECT lend.lend_id , lend.len_date , lend.sub_date , book.book_id , book.book_name , book.author , member.mem_id , member.name , member.nic , member.contact  \n" +
                    "FROM lend\n" +
                    "JOIN member on member.mem_id = lend.mem_id\n" +
                    "JOIN book on book.book_id = lend.book_id\n" +
                    "WHERE lend.sub_date <= "+"'"+strSSubDelay+"'"+" AND lend.sub_status=0;" ;        
        try {
            //same query was has to run twise,otherwise if retreive data has only one row it will not display and
            //if retreive data set have more than one row it will miss the first row when it display
            //execute retrieve data query for 1st time to check search result is not null
            PreparedStatement ps = DatabaseConnector.getCon().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           //execute retrieve data query for 2nd time to use it for display data in table            
            PreparedStatement ps1 = DatabaseConnector.getCon().prepareStatement(sql);
            ResultSet rs1 = ps1.executeQuery();             
            if(rs.first()){
                //set retreived data in to the table if there are search results
                Search.Table.setModel(DbUtils.resultSetToTableModel(rs1));
            }
            else{
                Search.Table.setModel(DbUtils.resultSetToTableModel(rs1));                
                //display notification if no searh results
                String message=" There is no Delayed Submittion to Date" ;
                JFrame f=new JFrame();
                JOptionPane.showMessageDialog(f,message);                
            }
        } 
        catch (Exception ex) {
            //display notification if no searh results
            String message=" No search result" ;
            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);            
        } 
        finally {   
        }
    }
    //method of query for delete book       
    public static void Delete(String ID) throws SQLException{
        //query of delete a record as id of selected row in book table of library database
        String sql = "DELETE FROM book WHERE book_id ="+"'"+ID+"'"+";";
        //query of check is bokk currently available in library
        String sql1="SELECT lend_id,mem_id,len_date,sub_date FROM lend WHERE book_id="+"'"+ID+"'"+" AND sub_status=0 ;";
        //query of delete record as id of selected row in lend table of library database to occur delete procedure properly
        String sql2 ="DELETE FROM lend WHERE book_id="+"'"+ID+"'"+";";
        try {
            PreparedStatement ps = DatabaseConnector.getCon().prepareStatement(sql1);
            //execute retrieve data query
            ResultSet rs = ps.executeQuery();	            
            if(rs.first()){
                //showing notificaton if book is not available in library and lend it and haven't submitted yet
                String message=" Book curruntly unavailable \n This book is Lend under Lend ID  " +rs.getString(1)+ " by member " +rs.getString(2)+ " at " +rs.getString(3)+ " "
                        + "\n And the Date To Submit is " +rs.getString(4)+ " and have not sumbitted yet \n Do you still want do delete it anyway?" ;
                JFrame f1=new JFrame();
                int a=JOptionPane.showConfirmDialog(f1,message);                    
                //confirmation of deleting record from database anyway
                if(a==JOptionPane.YES_OPTION){
                    //deleting record in lend table of library database prior to book id
                    DatabaseConnector.getCon().createStatement().executeUpdate(sql2);
                    //deleting record in book table in library database prior to book id
                    DatabaseConnector.getCon().createStatement().executeUpdate(sql);
                    //display notification of success
                    message=" Succefully deleted the record " ;
                    JFrame f=new JFrame();
                    JOptionPane.showMessageDialog(f,message);
                    DefaultTableModel model = (DefaultTableModel)Search.Table.getModel();
                    model.removeRow(Search.Table.getSelectedRow());
                }
            }
            else{
                //deleting record in lend table of library database prior to book id
                DatabaseConnector.getCon().createStatement().executeUpdate(sql2);
                //deleting record in book table in library database prior to book id
                DatabaseConnector.getCon().createStatement().executeUpdate(sql);
                //display notification of success
                String message=" Succefully deleted the record " ;
                JFrame f=new JFrame();
                JOptionPane.showMessageDialog(f,message);
                DefaultTableModel model = (DefaultTableModel)Search.Table.getModel();
                model.removeRow(Search.Table.getSelectedRow()); 
            }            
        }
        catch (Exception ex) {
            //display notification of unsuccess
            String message=" Unable to Delete \n Try again after selecting a raw again " ;
            JFrame f=new JFrame();
            JOptionPane.showMessageDialog(f,message,"Alert",JOptionPane.WARNING_MESSAGE);           
        }
        finally {   
        }
    }
}