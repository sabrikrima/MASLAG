/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connexion.MaConnexion;
import java.sql.*;
import maslag.project.Personne;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author lenovo
 */
public class PersonneService {
    public Connection cnx;
     public PreparedStatement ste;
    public PersonneService() {
    cnx = MaConnexion.getInstance().getconnection();
}
  public void ajouterPersonne(Personne p)  {
      try {
      String sql = "insert into 4se2 (Id,Nom,Prenom)" + "values(?,?,?)";
      ste=cnx.prepareStatement(sql);
       ste.setInt(1,p.getId());
      ste.setString(2, p.getNom());
      ste.setString(3, p.getPrenom());
     
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
 
public void afficherPersonne() throws SQLException 
{ 
    List<Personne> personnes = new ArrayList<>();
        try {

String sql = "Select * from 4se2 ";
ResultSet rs;
ste=cnx.prepareStatement(sql);
rs = ste.executeQuery();

while (rs.next()){
    Personne p = new Personne ();
    p.setId(rs.getInt(1));
   p.setNom(rs.getString(2));
    p.setPrenom(rs.getString(3));
    personnes.add(p);
}}
catch (SQLException ex) {Logger.getLogger(PersonneService.class.getName()).log(Level.SEVERE, null, ex);

}System.out.println(personnes);
}
}
