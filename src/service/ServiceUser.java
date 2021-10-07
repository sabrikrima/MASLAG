package service;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import connexion.MaConnexion;
import java.sql.*;
import maslag.project.Personne;
import Entité.User;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;




/**
 *
 * @author lenovo
 */
public class ServiceUser {
    public Connection cnx;
     public PreparedStatement ste;
    public ServiceUser() {
    cnx = MaConnexion.getInstance().getconnection();
}
     public void ajouterUser()  {
         
         System.out.println("entre Id");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("entre Nom");
        Scanner sc1 = new Scanner(System.in);
        String b = sc1.nextLine();
        System.out.println("entre Prenom");
        Scanner sc2 = new Scanner(System.in);
        String c = sc2.nextLine();
        System.out.println("entre Cin");
        Scanner sc3 = new Scanner(System.in);
        int d = sc3.nextInt();
        System.out.println("entre Num");
        Scanner sc4 = new Scanner(System.in);
        int e = sc4.nextInt();
        System.out.println("entre Adresse");
        Scanner sc5 = new Scanner(System.in);
        String f = sc5.nextLine();
       int jj=31 ; int yy=1998 ; int mm=8;
        Date dd = new Date(yy-1900,mm-1,yy);
        User u = new User(a,b,c,d,e,f,dd);
      try {
      String sql = "insert into user (Id_User,Nom_User,Prenom_User,Cin_User,Num_User,Adresse_User,Date_N_User)" + "values(?,?,?,?,?,?,?)";
      ste=cnx.prepareStatement(sql);
       ste.setInt(1,u.getId_User());
      ste.setString(2, u.getNom_User());
      ste.setString(3, u.getPrenom_User());
      ste.setInt(4,u.getCin_User());
      ste.setInt(5,u.getNum_User());
      ste.setString(6,u.getAdresse_User());
      ste.setDate(7, u.getDate_N_User());
     
      ste.executeUpdate();
      
      System.out.println("******* User a Ajouter aves succeé *******");
  }catch (SQLException ex) { System.out.println(ex);
}}
  
    public void modifierUser_Nom()  {
        System.out.println("entre Id de user a Modifier");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.println("entre le Nom a Modifier");
        Scanner sc1 = new Scanner(System.in);
        String b = sc1.nextLine();
      try {
     // String sql = "update user set Nom_User ="+b+"where Id_User ="+a;
     String sql = "UPDATE `user` SET `Nom_User` ='"+b+"' WHERE `user`.`Id_User` ="+a;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
    public void modifierUser_Prenom()  {
        System.out.println("entre Id de user a Modifier");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.println("entre le Prenom a Modifier");
        Scanner sc1 = new Scanner(System.in);
        String b = sc1.nextLine();
      try {
     // String sql = "update user set Nom_User ="+b+"where Id_User ="+a;
     String sql = "UPDATE `user` SET `Prenom_User` ='"+b+"' WHERE `user`.`Id_User` ="+a;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
    public void modifierUser_Cin()  {
        System.out.println("entre Id de user a Modifier");
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.println("entre le Cin a Modifier");
        Scanner sc1 = new Scanner(System.in);
        String b = sc1.nextLine();
      try {
     // String sql = "update user set Nom_User ="+b+"where Id_User ="+a;
     String sql = "UPDATE `user` SET `Cin_User` ='"+b+"' WHERE `user`.`Id_User` ="+a;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
    
      public void supprimerUser()  {
        try {          System.out.println("entre l Id de User a supprimer");
        Scanner sc5 = new Scanner(System.in);
        String f = sc5.nextLine();
      
      String sql = "delete from user where Id_User="+f;
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
      
      System.out.println("User a supprimer aves succeé");
  }catch (SQLException ex) { System.out.println(ex);
}}
 
public void afficherUser() throws SQLException 
{ 
    List<User> Users = new ArrayList<>();
        try {

String sql = "Select * from user ";
ResultSet rs;
ste=cnx.prepareStatement(sql);
rs = ste.executeQuery();

while (rs.next()){
    User u = new User ();
    u.setId_User(rs.getInt(1));
   u.setNom_User(rs.getString(2));
    u.setPrenom_User(rs.getString(3));
    u.setCin_User(rs.getInt(4));
   u.setNum_User(rs.getInt(5));
    u.setAdresse_User(rs.getString(6));
     u.setDate_N_User(rs.getDate(7));
    Users.add(u);
}}
catch (SQLException ex) {Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);

}System.out.println(Users);
}
public void CercheerUser() throws SQLException 
{ System.out.println("entre l Id de User a Chercher");
        Scanner sc5 = new Scanner(System.in);
        String f = sc5.nextLine();
    List<User> Users = new ArrayList<>();
        try {

String sql = "Select * from user WHERE `user`.`Id_User` ="+f;
ResultSet rs;
ste=cnx.prepareStatement(sql);
rs = ste.executeQuery();

while (rs.next()){
    User u = new User ();
    u.setId_User(rs.getInt(1));
   u.setNom_User(rs.getString(2));
    u.setPrenom_User(rs.getString(3));
    u.setCin_User(rs.getInt(4));
   u.setNum_User(rs.getInt(5));
    u.setAdresse_User(rs.getString(6));
     u.setDate_N_User(rs.getDate(7));
    Users.add(u);
}}
catch (SQLException ex) {Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);

}System.out.println(Users);
}
}

