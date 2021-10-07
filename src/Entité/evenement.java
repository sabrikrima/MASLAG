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
    private int Id_Event;
    private String Nom_Event;
    private String Adresse_Event;
    private int Num_Event ;

    public evenement(int Id_Event, String Nom_Event, String Adresse_Event, int Num_Event, int Id_User, double Prix_P, String Date_Debut, String Date_Fin) {
        this.Id_Event = Id_Event;
        this.Nom_Event = Nom_Event;
        this.Adresse_Event = Adresse_Event;
        this.Num_Event = Num_Event;
        this.Id_User = Id_User;
        this.Prix_P = Prix_P;
        this.Date_Debut = Date_Debut;
        this.Date_Fin = Date_Fin;
    }

    public evenement() {
    }

    @Override
    public String toString() {
        return "evenement{" + "Id_Event=" + Id_Event + ", Nom_Event=" + Nom_Event + ", Adresse_Event=" + Adresse_Event + ", Num_Event=" + Num_Event + ", Id_User=" + Id_User + ", Prix_P=" + Prix_P + ", Date_Debut=" + Date_Debut + ", Date_Fin=" + Date_Fin + '}';
    }
    private int Id_User ;

    public int getId_Event() {
        return Id_Event;
    }

    public void setId_Event(int Id_Event) {
        this.Id_Event = Id_Event;
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

    public int getId_User() {
        return Id_User;
    }

    public void setId_User(int Id_User) {
        this.Id_User = Id_User;
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
    private double Prix_P;
    private String Date_Debut;
    private String Date_Fin;

    public void setAdresse_event(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDate_F(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
