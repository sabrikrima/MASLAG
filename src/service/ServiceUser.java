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
     public void ajouterUser(User u)  {
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
  }catch (SQLException ex) { System.out.println(ex);
}}
  
    public void modifierPersonne()  {
      try {
      String sql = "update 4se2 set Nom = 'sabriiii' where Id =1";
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
    
      public void supprimerPersonne()  {
      try {
      String sql = "delete from 4se2 where Id=2 ";
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
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
}

