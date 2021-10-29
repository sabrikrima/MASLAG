/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité;

/**
 *
 * @author Advanceinfo
 */
public class evenement {
    private int ID_Event;
    private String Nom_Event;
    private String Adresse_Event;
    private int Num_Event ;
        private double Prix_P;
    private String Date_Debut;
    private String Date_Fin;

    public evenement(String Nom_Event, String Adresse_Event, int Num_Event, double Prix_P, String Date_Debut, String Date_Fin) {
        this.Nom_Event = Nom_Event;
        this.Adresse_Event = Adresse_Event;
        this.Num_Event = Num_Event;
        this.Prix_P = Prix_P;
        this.Date_Debut = Date_Debut;
        this.Date_Fin = Date_Fin;
    }

    public evenement() {
    }

    @Override
    public String toString() {
        return "evenement{" + "ID_Event=" + ID_Event + ", Nom_Event=" + Nom_Event + ", Adresse_Event=" + Adresse_Event + ", Num_Event=" + Num_Event + ", Prix_P=" + Prix_P + ", Date_Debut=" + Date_Debut + ", Date_Fin=" + Date_Fin + '}';
    }

    public int getID_Event() {
        return ID_Event;
    }

    public void setID_Event(int ID_Event) {
        this.ID_Event = ID_Event;
    }

    public String getNom_Event() {
        return Nom_Event;
    }

    public void setNom_Event(String Nom_Event) {
        this.Nom_Event = Nom_Event;
    }

    public String getAdresse_Event() {
        return Adresse_Event;
    }

    public void setAdresse_Event(String Adresse_Event) {
        this.Adresse_Event = Adresse_Event;
    }

    public int getNum_Event() {
        return Num_Event;
    }

    public void setNum_Event(int Num_Event) {
        this.Num_Event = Num_Event;
    }

    public double getPrix_P() {
        return Prix_P;
    }

    public void setPrix_P(double Prix_P) {
        this.Prix_P = Prix_P;
    }

    public String getDate_Debut() {
        return Date_Debut;
    }

    public void setDate_Debut(String Date_Debut) {
        this.Date_Debut = Date_Debut;
    }

    public String getDate_Fin() {
        return Date_Fin;
    }

    public void setDate_Fin(String Date_Fin) {
        this.Date_Fin = Date_Fin;
    }

    
    
    
}
