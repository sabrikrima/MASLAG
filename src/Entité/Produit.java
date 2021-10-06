/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité;

/**
 *
 * @author ahmed
 */
public class Produit {
    private int Id_Produit ;
    private String Nom_Produit ;
    private String Marque_Produit ;
    private String Categorie_Produit ;
    private double Prix_Produit ;
 public Produit() {}

    public Produit(int Id_Produit, String Nom_Produit, String Marque_Produit, String Categorie_Produit, double Prix_Produit) {
        this.Id_Produit = Id_Produit;
        this.Nom_Produit = Nom_Produit;
        this.Marque_Produit = Marque_Produit;
        this.Categorie_Produit = Categorie_Produit;
        this.Prix_Produit = Prix_Produit;
    }

  

    public int getId_Produit() {
        return Id_Produit;
    }

    public String getNom_Produit() {
        return Nom_Produit;
    }

    public String getMarque_Produit() {
        return Marque_Produit;
    }

    public String getCategorie_Produit() {
        return Categorie_Produit;
    }

    public double getPrix_Produit() {
        return Prix_Produit;
    }

    public void setId_Produit(int Id_Produit) {
        this.Id_Produit = Id_Produit;
    }

    public void setNom_Produit(String Nom_Produit) {
        this.Nom_Produit = Nom_Produit;
    }

    public void setMarque_Produit(String Marque_Produit) {
        this.Marque_Produit = Marque_Produit;
    }

    public void setCategorie_Produit(String Categorie_Produit) {
        this.Categorie_Produit = Categorie_Produit;
    }

    public void setPrix_Produit(double Prix_Produit) {
        this.Prix_Produit = Prix_Produit;
    }

    @Override
    public String toString() {
        return "Produit{" + "Id_Produit=" + Id_Produit + ", Nom_Produit=" + Nom_Produit + ", Marque_Produit=" + Marque_Produit + ", Categorie_Produit=" + Categorie_Produit + ", Prix_Produit=" + Prix_Produit + '}';
    }
    
    
}

