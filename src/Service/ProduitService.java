/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entité.Produit;
import connexion.MaConnexion;
import java.sql.*;
import java.util.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author lenovo
 */
public class ProduitService {
    public Connection cnx;
     public PreparedStatement ste;
    public ProduitService() {
    cnx = MaConnexion.getInstance().getconnection();
}

  public void ajouterProduit(Produit p)  {
         
//        System.out.println("Nom");
//        Scanner sc1 = new Scanner(System.in);
//        String b = sc1.nextLine();
//        System.out.println("Marque");
//        Scanner sc2 = new Scanner(System.in);
//        String c = sc2.nextLine();
//        System.out.println("Categorie");
//        Scanner sc3 = new Scanner(System.in);
//        String d = sc3.nextLine();
//        System.out.println("Prix");
//        Scanner sc4 = new Scanner(System.in);
//        double e = sc4.nextDouble();
//        Produit p = new Produit(b,c,d,e);
       try {
      String sql = "insert into produit (Id_Produit,Nom_Produit,Marque_Produit,Categorie_Produit,Prix_Produit,quantite,image)" + "values(?,?,?,?,?,?,?)";
      ste=cnx.prepareStatement(sql);
      ste.setInt(1, p.getId_Produit());
      ste.setString(2, p.getNom_Produit());
      ste.setString(3, p.getMarque_Produit());
      ste.setString(4, p.getCategorie_Produit());
      ste.setDouble(5, p.getPrix_Produit());
      ste.setInt(6, p.getQuantite());
      ste.setString(7, p.getImg());
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}
  }
  
  
  public void modifierProduit(Produit art)  {
      
          try {
            String req = "UPDATE article SET Nom_Produit=?,Marque_Produit=?,Categorie_Produit=?,Prix_Produit=?,quantite=? WHERE Id_Produit =?";
            PreparedStatement pst2 = cnx.prepareStatement(req);
            pst2.setString(1, art.getNom_Produit());
            pst2.setString(2, art.getMarque_Produit());
            pst2.setString(3, art.getCategorie_Produit());
             pst2.setInt(4, art.getQuantite());
            pst2.setDouble(5, art.getPrix_Produit());
            pst2.executeUpdate();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

  }
    
      
    public void supprimerProduit()  {
        try {
        System.out.println("entre l Id de produit a supprimer");
        Scanner sc5 = new Scanner(System.in);
        String f = sc5.nextLine();
      
      String sql = "delete from produit where Id_Produit="+f;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
 
public void afficherProduit() throws SQLException 
{      
}
  
  public List<Produit> AffichierProduitt() {

      ObservableList<Produit> list = FXCollections.observableArrayList();
        try {
           String sql = "Select a.Nom_Produit, a.Marque_Produit, a.Prix_Produit,a.quantite,a.image from produit a ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(sql);
           
            while (rs.next()) {
               list.add(new Produit(rs.getString(1),rs.getString(2),rs.getDouble(3), rs.getInt(4),rs.getString(5)));
               }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
}