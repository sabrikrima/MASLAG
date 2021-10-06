/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité;
import java.util.*;
import java.sql.Date;

/**
 *
 * @author lenovo
 */

public class User {
    
        private int Id_User;
    private String Nom_User;
    private String Prenom_User;
    private int Cin_User;
    private int Num_User;
    private String Adresse_User;
    Date Date_N_User ;

    public User() {
    }

    public User(int Id_User, String Nom_User, String Prenom_User, int Cin_User, int Num_User, String Adresse_User, Date Date_N_User) {
        this.Id_User = Id_User;
        this.Nom_User = Nom_User;
        this.Prenom_User = Prenom_User;
        this.Cin_User = Cin_User;
        this.Num_User = Num_User;
        this.Adresse_User = Adresse_User;
        this.Date_N_User = Date_N_User;
    }

    public int getId_User() {
        return Id_User;
    }

    public String getNom_User() {
        return Nom_User;
    }

    public String getPrenom_User() {
        return Prenom_User;
    }

    public int getCin_User() {
        return Cin_User;
    }

    public int getNum_User() {
        return Num_User;
    }

    public String getAdresse_User() {
        return Adresse_User;
    }

    public Date getDate_N_User() {
        return Date_N_User;
    }

    public void setId_User(int Id_User) {
        this.Id_User = Id_User;
    }

    public void setNom_User(String Nom_User) {
        this.Nom_User = Nom_User;
    }

    public void setPrenom_User(String Prenom_User) {
        this.Prenom_User = Prenom_User;
    }

    public void setCin_User(int Cin_User) {
        this.Cin_User = Cin_User;
    }

    public void setNum_User(int Num_User) {
        this.Num_User = Num_User;
    }

    public void setAdresse_User(String Adresse_User) {
        this.Adresse_User = Adresse_User;
    }

    public void setDate_N_User(Date Date_N_User) {
        this.Date_N_User = Date_N_User;
    }

    @Override
    public String toString() {
        return "User{" + "Id_User=" + Id_User + ", Nom_User=" + Nom_User + ", Prenom_User=" + Prenom_User + ", Cin_User=" + Cin_User + ", Num_User=" + Num_User + ", Adresse_User=" + Adresse_User + ", Date_N_User=" + Date_N_User + '}';
    }
    
}
