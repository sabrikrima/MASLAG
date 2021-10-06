/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import connexion.MaConnexion;
import maslag.project.Personne;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import service.PersonneService;

/**
 *
 * @author lenovo
 */
public class main {
    public static void main(String[] args) throws SQLException {
        List<Personne> aaa = new ArrayList<>();
        
        MaConnexion mc = MaConnexion.getInstance() ; 
        Personne p1 = new Personne(1,"foulen","benfoulen");
        Personne p2 = new Personne(2,"aaaa","aaaa");
        Personne p3 = new Personne(3,"bbbbb","bbbbb");
        Personne p4 = new Personne(4,"cccccc","ccccc");
        PersonneService ps = new PersonneService();
      //  ps.ajouterPersonne(p1);
//        ps.ajouterPersonne(p2);
//        ps.ajouterPersonne(p3);
//        ps.ajouterPersonne(p4);
        
        
   ps.modifierPersonne();
      ps.afficherPersonne();
       ps.supprimerPersonne();
    }   

    
    
}
