package mx.itson.navidad.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConnection {
    
   String usuario ="u4iwcrzxmsk8g";
    String clave="camaronesITSON";
   // String url ="jdbc:mysql://localhost/tiketsdb?serverTimezone=UTC";
    String url ="jdbc:mysql://arturog58.sg-host.com:3306/dbaswox04bsrqh?serverTimezone=UTC";
    Connection con; 
    Statement stmt;
    ResultSet rs;
    
    public MySQLConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            con = DriverManager.getConnection(url,usuario,clave);
            stmt = con.createStatement(); 
        
        
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
  
    
    public  ResultSet   select(String consulta){
        try {
            rs = stmt.executeQuery(consulta);
           
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  rs;
    }
 
      public  void    insert(String consulta){
        try {
            stmt.executeUpdate(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    public  void    update(String consulta){
        try {
            stmt.executeUpdate(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
      
    public  void    delete(String consulta){
        try {
            stmt.executeUpdate(consulta);
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
  
     
  public static void main(String[] args){  
     
            MySQLConnection test = new MySQLConnection();
            
          //  test.select("INSERT INTO tecnicos (nombre, apellido, telefono,correo, contrasena) VALUES ('test 5', 't', '677776767', '3sds43@4d77', '123');");
       
            ResultSet rs = test.select( "select * from usuarios; ");
      
            
        try {
            
            while(rs.next()){
                System.out.println(rs.getString("nombre")+" "+rs.getString("telefono") );
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MySQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
  
  } 
}
