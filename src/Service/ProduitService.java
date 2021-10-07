/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entité.Produit;
import connexion.MaConnexion;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


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
  /*public void ajouterProduit(Produit p)  {
      try {
      String sql = "insert into produit (Id_Produit,Nom_Produit,Marque_Produit,Categorie_Produit,Prix_Produit)" + "values(?,?,?,?,?)";
      ste=cnx.prepareStatement(sql);
      ste.setInt(1, p.getId_Produit());
      ste.setString(2, p.getNom_Produit());
      ste.setString(3, p.getMarque_Produit());
      ste.setString(4, p.getCategorie_Produit());
      ste.setDouble(5, p.getPrix_Produit());
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}*/
  public void ajouterProduit()  {
         
         System.out.println("Id");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("Nom");
        Scanner sc1 = new Scanner(System.in);
        String b = sc1.nextLine();
        System.out.println("Marque");
        Scanner sc2 = new Scanner(System.in);
        String c = sc2.nextLine();
        System.out.println("Categorie");
        Scanner sc3 = new Scanner(System.in);
        String d = sc3.nextLine();
        System.out.println("Prix");
        Scanner sc4 = new Scanner(System.in);
        double e = sc4.nextDouble();
        System.out.println("Adresse");
        
        Produit p = new Produit(a,b,c,d,e);
       try {
      String sql = "insert into produit (Id_Produit,Nom_Produit,Marque_Produit,Categorie_Produit,Prix_Produit)" + "values(?,?,?,?,?)";
      ste=cnx.prepareStatement(sql);
      ste.setInt(1, p.getId_Produit());
      ste.setString(2, p.getNom_Produit());
      ste.setString(3, p.getMarque_Produit());
      ste.setString(4, p.getCategorie_Produit());
      ste.setDouble(5, p.getPrix_Produit());
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
    public void modifierProduit()  {
      try {
      String sql = "update produit set Nom_Produit = 'tn' where Id_Produit =1";
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
    
      public void supprimerProduit()  {
      try {
      String sql = "delete from produit where Id_Produit=2 ";
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
 
public void afficherProduit() throws SQLException 
{ 
    List<Produit> pr = new ArrayList<>();
        try {

String sql = "Select * from produit ";
ResultSet rs;
ste=cnx.prepareStatement(sql);
rs = ste.executeQuery();

while (rs.next()){
    Produit p = new Produit ();
    p.setId_Produit(rs.getInt(1));
    p.setNom_Produit(rs.getString(2));
    p.setMarque_Produit(rs.getString(3));
    p.setCategorie_Produit(rs.getString(4));
    p.setPrix_Produit(rs.getDouble(5));
    pr.add(p);
}}
catch (SQLException ex) {Logger.getLogger(ProduitService.class.getName()).log(Level.SEVERE, null, ex);

}System.out.println(pr);
}

    
}