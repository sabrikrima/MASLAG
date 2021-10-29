/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connexion.MaConnexion;
import java.awt.Event;
import java.sql.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entité.evenement;


/**
 *
 * @author lenovo
 */
public class EventService {
    public Connection cnx;
     public PreparedStatement ste;
    public EventService() {
    cnx = MaConnexion.getInstance().getconnection();
}
  public void ajouterEvent(evenement E)  {
      try {
      String sql = "insert into evenement (Nom_Event,Adresse_Event,Num_Event,Prix_P,Date_Debut,Date_Fin)" + "values(?,?,?,?,?,?)";
      ste=cnx.prepareStatement(sql);
     
      ste.setString(2, E.getNom_Event());
      ste.setString(3, E.getAdresse_Event());
      ste.setInt(4,E.getNum_Event());
     
      ste.setDouble(6,E.getPrix_P());
      ste.setString(7,E.getDate_Debut());
      ste.setString(8,E.getDate_Fin());
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
  
    public void modifierEvent()  {
      try {
      String sql = "update evenement set Nom = 'achref' where Id_Event =1";
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
    
      public void supprimerEvent()  {
      try {
      String sql = "delete from evenement where Id_Event=2 ";
      ste=cnx.prepareStatement(sql);
      ste.executeUpdate();
  }catch (SQLException ex) { System.out.println(ex);
}}
 
public void afficherEvent() throws SQLException 
{ 
    List<evenement> evenements = new ArrayList<>();
        try {

String sql = "Select * from evenement ";
ResultSet rs;
ste=cnx.prepareStatement(sql);
rs = ste.executeQuery();

while (rs.next()){
    evenement E = new evenement ();
  
   E.setNom_Event(rs.getString(1));
    E.setAdresse_Event(rs.getString(2));
    E.setNum_Event(rs.getInt(3));
   
    E.setPrix_P(rs.getDouble(4));
    E.setDate_Debut(rs.getString(5));
    E.setDate_Fin(rs.getString(6));
    evenements.add(E);
}}
catch (SQLException ex) {Logger.getLogger(EventService.class.getName()).log(Level.SEVERE, null, ex);

}System.out.println(evenements);
}
}
