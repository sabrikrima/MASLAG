/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maslag.project;

import Entité.Produit;
import connexion.MaConnexion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import service.ProduitService;

/**
 *
 * @author lenovo
 */
public class MASLAGProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        List<Produit> Produit = new ArrayList<>();
        
        MaConnexion mc = MaConnexion.getInstance() ; 
        Produit p1 = new Produit(1,"valvo","smn","xtx",4);
        Produit p2 = new Produit(2,"valvo","smn","xtx",4);
        Produit p3 = new Produit(3,"valvo","smn","xtx",4);
        Produit p4 = new Produit(4,"valvo","smn","xtx",4);
        Produit p5 = new Produit(5,"valvo","smn","xtx",4);
        ProduitService ps = new ProduitService();
        
        ps.ajouterProduit();
        
        
        
        ps.modifierProduit();
        ps.afficherProduit();
        ps.supprimerProduit();
    }   

    
    
}
