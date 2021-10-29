/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maslag.project;

import Entité.command;
import connexion.MaConnexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import service.CommandService;



import java.sql.Date;
import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class MASLAGProject {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        
               List<command> aaa = new ArrayList<>();
       

                
        MaConnexion mc = MaConnexion.getInstance() ; 
//        command c1 = new command();
        
                command c2 = new command();
      
       
        CommandService Com = new CommandService();
    
    // Com.AjouterCommand();
       
      
    //  Com.Modifiercommand();
              
       // Com.AjouterCommand();
       Com.supprimercommand();
        
        
          
       
        
        
    
    
}
}