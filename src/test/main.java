/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import Entité.User;
import connexion.MaConnexion;
import maslag.project.Personne;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import service.PersonneService;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Scanner;
import service.ServiceUser;

/**
 *
 * @author lenovo
 */
public class main {
    public static void main(String[] args) throws SQLException {
        List<User> aaa = new ArrayList<>();
        int jj=31 ; int yy=1998 ; int mm=8;
        Date d = new Date(yy-1900,mm-1,yy);
        MaConnexion mc = MaConnexion.getInstance() ; 
              ServiceUser us = new ServiceUser();
              
          us.afficherUser();
          us.modifierUser_Nom();  
              
              
 
//        Scanner sc = new Scanner(System.in);
//        int i = sc.nextInt();
//        User u1 = new User(8,"sabri","krima",14001808,94464323,"bekalta",d);
//        User u2 = new User(2,"lotfi","hmida",14015012,94464323,"bekalta",d);
//        User u3 = new User(3,"malek","saidi",14001111,94464323,"bekalta",d);
//        User u4 = new User(4,"ahmed","zarai",14001888,94464323,"bekalta",d);
//        User u5 = new User(5,"ghazi","toukebri",14001807,94464323,"bekalta",d);

        //us.ajouterUser();
//        us.ajouterUser(u2);
//        us.ajouterUser(u3);
//        us.ajouterUser(u4);
//          us.ajouterUser(u5);
//        us.ajouterPersonne(u3);
//        us.ajouterPersonne(u4);
        //us.supprimerUser();
        //System.out.println(u.getDate_N_User());

  
      

      
//         System.out.println("entre l Id de User a supprimer");
//        Scanner sc5 = new Scanner(System.in);
//        String f = sc5.nextLine();
//        
//      String sql = "delete from user where Id="+f;
//      System.out.println(sql);
    }   

    
    
}
