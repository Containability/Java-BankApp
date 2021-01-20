/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nypprojectbank;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author msi
 */

class user {
    String tcNo;
    String pass;
    String name;
    String surname;
    
    
    
    public void kayit(){
    
    };
}
  
class user_cust extends user{
int bakiye;
    int borc;
    int kredi_miktar;
              
   
@Override
public void kayit(){

 try {
    
                    Connection connection = DatabaseCon.createConnection();
                      connection.setSchema("APP");
                    String query = "INSERT INTO USER_CUSTOMER (AD,SOYAD,TC,SIFRE) VALUES ('" + this.name + "','" + this.surname + "','" + this.tcNo + "','" +
                        this.pass + "')";

                    Statement sta = connection.createStatement();
                    sta.execute(query);
                   /*if (!sta.execute(query)) {
                        System.out.println("This is alredy exist");
                    } 
                    else {
                    */
                       System.out.println(
                            "Welcome, " + this.name + "  Your account is sucessfully created");
                    
                    connection.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
}

public boolean check(){
    
    try {
 Connection connection = DatabaseCon.createConnection();
                      connection.setSchema("APP");
String query="SELECT * FROM USER_CUSTOMER where tc='"+this.tcNo+"' AND sifre='"+this.pass+"'";
       Statement sta = connection.createStatement();
                 ResultSet rs=sta.executeQuery(query);
        if(rs.next()==false){
            connection.close();
            return false;
        }
        else{
            this.name=rs.getString(1);
            this.surname=rs.getString(2);
            this.bakiye=rs.getInt(4);
            this.borc=rs.getInt(5);
            connection.close();
            
           
            return true;
        }
}
   catch (SQLException exception) {
                    exception.printStackTrace();
                }
return true;
}
public void kredi_basvur(String kredi){
    int thiskredi=Integer.parseInt(kredi);
 try {
                    Connection connection = DatabaseCon.createConnection();
                      connection.setSchema("APP");

                        String query = "INSERT INTO KREDILER_CUST(tc,miktar) values('" + this.tcNo + "'," + thiskredi + ")";

                    Statement sta = connection.createStatement();
               sta.executeUpdate(query);
                  
                       System.out.println(
                            "Welcome, " + this.name + "  kredi basvurunuz yapıldı");
                    
                    connection.close();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                   JFrame frame = new JFrame("JOptionPane showMessageDialog example");
    
    
    JOptionPane.showMessageDialog(frame,
        "Kredi başvurusu daha önce yapılmış.");
                }


}
public void para_gonder(String para,String gonderilen_tc){
int gonder=Integer.parseInt(para);



try {
                    Connection connection = DatabaseCon.createConnection();                      
                    connection.setSchema("APP");

                    String query = "UPDATE user_customer SET bakiye=bakiye+"+gonder+" where tc='"+gonderilen_tc+"'";

                    Statement sta = connection.createStatement();
                    int x = sta.executeUpdate(query);
                    if (x == 0) {
                        System.out.println("This is alredy exist");
                    } else {
                       System.out.println(
                            "Welcome, " + this.name + "  para gonderiildi");
                    }
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }



this.bakiye=this.bakiye-gonder;

}
public void para_yukle(String miktar){

    
    this.bakiye=this.bakiye+Integer.parseInt(miktar);
try {
                    Connection connection = DatabaseCon.createConnection();                      connection.setSchema("APP");

                    String query = "UPDATE user_customer SET bakiye="+this.bakiye+" where tc='"+this.tcNo+"'";

                    Statement sta = connection.createStatement();
                   sta.execute(query);
                    
                       System.out.println(
                            "Welcome, " + this.name + "  para yüklendi");
                    
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }



}
public void borc_ode(int odenen_tutar){
if(this.bakiye>=odenen_tutar && odenen_tutar<=this.borc){
    this.bakiye=this.bakiye-odenen_tutar;

this.borc=this.borc-odenen_tutar;
return;
}
if(this.bakiye>=odenen_tutar && this.borc<odenen_tutar)
{
      JFrame frame = new JFrame("JOptionPane showMessageDialog example");
    
    
    JOptionPane.showMessageDialog(frame,
        "Ödenen tutar borçtan fazla!");
    return;
}


JFrame frame = new JFrame("JOptionPane showMessageDialog example");
    
    
    JOptionPane.showMessageDialog(frame,
        "Bakiyeniz bu tutar için yeterli değil!");




}
}
class user_banker extends user{
String pass="root";
public boolean check(String tc){
    
    try {
Connection connection = DatabaseCon.createConnection();                      connection.setSchema("APP");
String query="SELECT * FROM user_bank where tc='"+tc+"'";
       Statement sta = connection.createStatement();
                  ResultSet rs=sta.executeQuery(query);
        if(rs.next()==false){
            System.out.println("Not exist");
     connection.close();
            return false;
        }
        else{
        this.name=rs.getString(1);
         this.surname=rs.getString(2);
         connection.close();
         return true;
        }

}
   catch (SQLException exception) {
                    exception.printStackTrace();
                    return false;
                }

}

public void kredi_onayı(String tc_cust,Boolean onay){

int borcu=0;
int istenen_kredi=0;
 try {
                    Connection connection = DatabaseCon.createConnection();                      connection.setSchema("APP");

                    String query = "UPDATE krediler_cust SET onay="+onay+" where tc='"+tc_cust+"'";

                    Statement sta = connection.createStatement();
                   sta.executeUpdate(query);
                    
                       System.out.println(
                            "Welcome, " + this.name + "  kredi basvusu onaylandı");
                    
                    connection.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }


if(onay){

try {
                    Connection connection = DatabaseCon.createConnection();                      connection.setSchema("APP");

                    String query = "Select borc from user_customer where tc='"+tc_cust+"'";

                    Statement sta = connection.createStatement();
                    ResultSet rs = sta.executeQuery(query);
                    if(rs.next()==false){
            System.out.println("Not exist");
     connection.close();
            
        }
        else{
       
        borcu=rs.getInt(1);
         connection.close();
         
        }
}catch (Exception exception) {
                    exception.printStackTrace();
                }
try {
                    Connection connection = DatabaseCon.createConnection();                      connection.setSchema("APP");

                    String query = "Select miktar from krediler_cust where tc='"+tc_cust+"'";

                    Statement sta = connection.createStatement();
                    ResultSet rs = sta.executeQuery(query);
                    if(rs.next()==false){
            System.out.println("Not exist");
     connection.close();
            
        }
        else{
        istenen_kredi=rs.getInt(1);
         connection.close();
         
        }
}
catch (Exception exception) {
                    exception.printStackTrace();
                }
borcu=borcu+istenen_kredi;
try {
                    Connection connection = DatabaseCon.createConnection();                      connection.setSchema("APP");

                    String query = "UPDATE user_customer SET borc="+borcu+" where tc='"+tc_cust+"'";

                    Statement sta = connection.createStatement();
                     sta.executeUpdate(query);
                   
                       
                   
                       System.out.println(
                            "Welcome, " + tc_cust + "  kredi borcu aktarıldı");
                    
                    connection.close();
    }
catch (Exception exception) {
                    exception.printStackTrace();
                }






}

 
 try {
                    Connection connection = DatabaseCon.createConnection();                      connection.setSchema("APP");

                    String query = "DELETE FROM krediler_cust WHERE tc='"+tc_cust+"'";

                    Statement sta = connection.createStatement();
                   sta.executeUpdate(query);
                  
                    
                       System.out.println("Welcome, kredin silindi");
                       connection.close();
                if(!onay){
                    try {
                   
 Connection connection2 = DatabaseCon.createConnection();                     
 connection2.setSchema("APP");

                    String query2 = "UPDATE OLD_CUST SET ONAY_OLD='ONAYLANMADI' where tc_old='"+tc_cust+"'";

                    Statement sta2 = connection2.createStatement();
                     sta2.executeUpdate(query2);
                   
                       
                   
                       System.out.println(
                            "Welcome, " + tc_cust + "  kredi onaylanmadı ve bu tabloda yazıldı");
                    
                    connection2.close();
    }
catch (Exception exception) {
                    exception.printStackTrace();
                }
                    
                    }
                   
                    
                } catch (SQLException exception) {
                    exception.printStackTrace();
                    System.out.println("Kredi yokmuş catchledm");
                }


 
}




}
class kredilerimm extends user{
String krediBekleyen3;
int miktar2;
Boolean onay1;
  

public Boolean kredimAct(){
    

try {
                    Connection connection = DatabaseCon.createConnection();                      connection.setSchema("APP");

                    String query = "Select * from krediler_cust where tc='"+this.krediBekleyen3+"'";

                    Statement sta = connection.createStatement();
                   ResultSet rs=sta.executeQuery(query);
                  
                    if (rs.next() == false) {
                        System.out.println("Kredi yok");
                        connection.close();
                        return false;
                    } else {
                       System.out.println("Welcome, this is your kredi");
                       this.miktar2=rs.getInt(1);
                       this.onay1=rs.getBoolean(2);
                       
                      
                       connection.close();
                       
                       return true;
                    }
                    
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }






return true;

}



} 




