package connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class MaConnexion {
    public String URL="jdbc:mysql://localhost:3306/maslag_db";
    public String User ="root";
    public String Password ="";
    Connection cnx;
public static MaConnexion ct;
    public MaConnexion() {
        try {
        cnx = DriverManager.getConnection(URL, User,Password);
        System.out.println("connexion etablie)");
        }catch (SQLException ex) {
            System.out.println(ex.getMessage());
             System.out.println("aaaa");
    }
        
}
    
    
public Connection getconnection(){
    return cnx;
}
public static MaConnexion getInstance(){
    if (ct == null){
        ct = new MaConnexion();
    }    
        return ct;
    
}
    }
    
