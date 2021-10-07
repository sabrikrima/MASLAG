/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maslag.project;

import connexion.MaConnexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import service.EventService;
import Entité.evenement;
/**
 *
 * @author Acer
 */
public class MASLAGProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        // TODO code application logic here
     

        
        MaConnexion mc = MaConnexion.getInstance() ; 
        evenement p1 = new evenement(5,"jour d sport", "jerba", 8, 5, 3, "15-12-2021","15-12-2021");
        EventService ps = new EventService();
        ps.ajouterEvent(p1);
        
        
        

    
    }
    
}
