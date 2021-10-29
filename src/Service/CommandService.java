/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Entité.command;
import connexion.MaConnexion;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lenovo
 */
public class CommandService {
    public Connection cnx;
     public PreparedStatement ste;
    public CommandService() {
    cnx = MaConnexion.getInstance().getconnection();
}
  public void AjouterCommand(command c)  {
   /*   private int id_Produit;
    private String Nom_Produit;
    private String Marque_Produit;
    private String Categorie_Produit;
    private Double Prix_Produit;
    private int quantite;*/
   
      
      try {
      String sql = "INSERT INTO `command`(`Id_Com`, `Id_Produit`, `Id_User`, `Prix_Produit`, `Date_Com`, `quantite`, `Categorie_Produit`, `Marque_Produit`, `Nom_Produit`)" + "values(?,?,?,?,?,?,?,?,?)";
      ste=cnx.prepareStatement(sql);
     //  ste.setInt(1,p.getId());
     
     ste.setInt(1,c.getId_Com());
     ste.setInt(2,c.getId_Produit());
     ste.setInt(3,c.getId_User());
     ste.setDouble(4,c.getPrix_Produit());
     ste.setString(5,c.getDate_Com());
     ste.setInt(6,c.getQuantite());
       ste.setString(7,c.getCategorie_Produit());
           
                         
              ste.setString(8,c.getMarque_Produit());
              ste.setString(9,c.getNom_Produit());

              

          
     
     
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}
      
 }
  //
    public void Modifiercommand()  {
        
        System.out.println("entre Id de comm a Modifier");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.println("entre l id_Produit a Modifier");
        Scanner sc1 = new Scanner(System.in);
        String b = sc1.nextLine();
       System.out.println("entrer Id_User a Modifier");
      Scanner sc2 = new Scanner(System.in);
      int d = sc2.nextInt();
      System.out.println("entrer Prix_Produit a Modifier");
      Scanner sc3 = new Scanner(System.in);
      double f = sc3.nextDouble();
      System.out.println("entrer Date_com a Modifier");
      Scanner sc7 = new Scanner(System.in);
      String H = sc7.nextLine();
      try {
     
     String sql = "UPDATE `command` SET `Id_Produit` ='"+b+"' WHERE `command`.`Id_Com` ="+a;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
           sql = "UPDATE `command` SET `Id_User` ='"+d+"' WHERE `command`.`Id_Com` ="+a;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
          sql = "UPDATE `command` SET `Prix_Produit` ='"+f+"' WHERE `command`.`Id_Com` ="+a;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
           sql = "UPDATE `command` SET `Date_com` ='"+H+"' WHERE `command`.`Id_Com` ="+a;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
  
}}
    
     public void supprimercommand()  {
          
      try {
          System.out.println("entrer id que vous voulez le supprimer : ");
          Scanner Sup =new Scanner (System.in);
          int f = Sup.nextInt();
          
      String sql = "DELETE FROM `command` WHERE `Id_Com`="+f;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
 
public void affichercommand() throws SQLException 
{ 
    List<command> commands = new ArrayList<>();
        try {

String sql = "Select * from command ";
ResultSet rs;
ste=cnx.prepareStatement(sql);
rs = ste.executeQuery();

while (rs.next()){
    command c = new command ();
   // p.setId(rs.getInt(1));
    c.setId_Com(rs.getInt(1));
   c.setId_Produit(rs.getInt(2));
     c.setId_User(rs.getInt(3));
       c.setPrix_Produit(rs.getDouble(4));
 
    commands.add(c);
}}
catch (SQLException ex) {Logger.getLogger(CommandService.class.getName()).log(Level.SEVERE, null, ex);

}System.out.println(commands);
}
}