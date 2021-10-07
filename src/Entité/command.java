/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité;

import java.sql.Date;

/**
 *
 * @author saidi
 */
public class command {
    private int Id_Com;
    private int Id_Produit;
    private int Id_User;
    private double Prix_Produit;
    private String Date_com;

    public command(int Id_Com, int Id_Produit, int Id_User, double Prix_Produit, String  Date_com) {
        this.Id_Com = Id_Com;
        this.Id_Produit = Id_Produit;
        this.Id_User = Id_User;
        this.Prix_Produit = Prix_Produit;
        this.Date_com = Date_com;
    }

    public command() {
    }



    public int getId_User() {
        return Id_User;
    }

    public void setId_User(int Id_User) {
        this.Id_User = Id_User;
    }

   
    

    public int getId_Com() {
        return Id_Com;
    }

    public void setId_Com(int Id_Com) {
        this.Id_Com = Id_Com;
    }

    public int getId_Produit() {
        return Id_Produit;
    }

    public void setId_Produit(int Id_Produit) {
        this.Id_Produit = Id_Produit;
    }

    public double getPrix_Produit() {
        return Prix_Produit;
    }

    public void setPrix_Produit(double Prix_Produit) {
        this.Prix_Produit = Prix_Produit;
    }

    public String getDate_com() {
        return Date_com;
    }

    public void setDate_com(String Date_com) {
        this.Date_com = Date_com;
    }

  

    @Override
    public String toString() {
        return "command{" + "Id_Com=" + Id_Com + ", Id_Produit=" + Id_Produit + ", Id_User=" + Id_User + ", Prix_Produit=" + Prix_Produit + ", Date_com=" + Date_com + '}';
    }

   

  
    
}
