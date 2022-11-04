
package based;


import java.sql.Statement;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;


/**
 *
 * @author Marlon gonzalez
 */
public class Conexion {

    
    String user="root",url="jdbc:mysql://localhost/pruebita",password="",baseDatos="pruebita",driver="com.mysql.jdbc.Driver";
    Connection c;
    
    public Conexion(){
        
    }
    public Connection conectar(){
     try{
         Class.forName(driver);
         // Establecemos la conexión con la base de datos.
          c = DriverManager.getConnection("jdbc:mysql://localhost/","root", "");
         JOptionPane.showMessageDialog(null,"hola");
     } catch (ClassNotFoundException | SQLException e){
     } 
     
        return null;
        
    }
    public Statement mostrar(){
        try{
            Statement s = c.createStatement();
         ResultSet rs = s.executeQuery("select * from persona");
         while(rs.next()){
             JOptionPane.showMessageDialog(null,rs.getInt ("id") + " " + rs.getString ("nombre")+ " " + rs.getDate("nacimiento"));
         }
        }catch(SQLException e){
            
        }
        
    return null;
}
    public Connection cerrar(){
        try{
        c.close();
        JOptionPane.showMessageDialog(null,"sesion finalizada");
          
     }catch (SQLException e){
        
    }
        return null;
        
}
}        