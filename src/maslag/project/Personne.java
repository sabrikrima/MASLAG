/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maslag.project;

/**
 *
 * @author lenovo
 */

public class Personne {
        private int Id;
    private String nom;
    private String prenom;
    public Personne () {}
    public Personne(int Id, String nom, String prenom) {
        this.Id = Id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId() {
        return Id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Personne{" + "Id=" + Id + ", nom=" + nom + ", prenom=" + prenom + '}';
    }
  
    
}
