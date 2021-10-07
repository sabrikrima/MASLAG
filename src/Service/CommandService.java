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
  public void AjouterCommand()  {
      System.out.println("entrer Id_com");
      Scanner sc = new Scanner(System.in);
      int a = sc.nextInt();
      System.out.println("entrer Id_Produit");
      Scanner sc1 = new Scanner(System.in);
      int b = sc1.nextInt();
      System.out.println("entrer Id_User");
      Scanner sc2 = new Scanner(System.in);
      int d = sc2.nextInt();
      System.out.println("entrer Prix_Produit");
      Scanner sc3 = new Scanner(System.in);
      double f = sc3.nextDouble();
      System.out.println("entrer Date_com");
      Scanner sc7 = new Scanner(System.in);
      String H = sc7.nextLine();
      
      
      
     
      command c = new command(a, b, d, f, H);
      try {
      String sql = "insert into command (Id_Com ,Id_Produit ,Id_User, Prix_Produit,  Date_com)" + "values(?,?,?,?,?)";
      ste=cnx.prepareStatement(sql);
     //  ste.setInt(1,p.getId());
     ste.setInt(1, c.getId_Com() );
     ste.setInt(2,c.getId_Produit());
     ste.setInt(3,c.getId_User());
      ste.setDouble(4, c.getPrix_Produit());
       ste.setString(5, c.getDate_com());
     
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
  //
    public void Modifiercommand()  {
        
        System.out.println("entrer id_com a modifier: ");
        Scanner sc = new Scanner(System.in);
        String b = sc.nextLine();
      try {
      String sql = "update command set Id_Com = '11' where Id =1";
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);

  }}
    
      public void supprimercommand()  {
          
      try {
          System.out.println("entrer id que vous voulez le supprimer : ");
          Scanner Sup =new Scanner (System.in);
          int f = Sup.nextInt();
          
      String sql = "delete from command where Id_Com=2 ";
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
         c.setDate_com(rs.getString(5));
    commands.add(c);
}}
catch (SQLException ex) {Logger.getLogger(CommandService.class.getName()).log(Level.SEVERE, null, ex);

}System.out.println(commands);
}
}