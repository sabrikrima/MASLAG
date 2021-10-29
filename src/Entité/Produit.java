/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entité;

import javafx.scene.control.CheckBox;

/**
 *
 * @author saidi
 */
public class Produit {
    
    private int id_Produit;
    private String Nom_Produit;
    private String Marque_Produit;
    private String Categorie_Produit;
    private Double Prix_Produit;
    private int quantite;
   
   

    public Produit(int id_Produit, String Nom_Produit, String Marque_Produit, String Categorie_Produit, Double Prix_Produit, int quantite) {
        this.id_Produit = id_Produit;
        this.Nom_Produit = Nom_Produit;
        this.Marque_Produit = Marque_Produit;
        this.Categorie_Produit = Categorie_Produit;
        this.Prix_Produit = Prix_Produit;
        this.quantite = quantite;
    }
  

   

  

 
    
    

   

   
    
     public Produit() {
    }
    

    public int getId_Produit() {
        return id_Produit;
    }

    public void setId_Produit(int id_Produit) {
        this.id_Produit = id_Produit;
    }

    public String getNom_Produit() {
        return Nom_Produit;
    }

    public void setNom_Produit(String Nom_Produit) {
        this.Nom_Produit = Nom_Produit;
    }

    public String getMarque_Produit() {
        return Marque_Produit;
    }

    public void setMarque_Produit(String Marque_Produit) {
        this.Marque_Produit = Marque_Produit;
    }

    public String getCategorie_Produit() {
        return Categorie_Produit;
    }

    public void setCategorie_Produit(String Categorie_Produit) {
        this.Categorie_Produit = Categorie_Produit;
    }

    public Double getPrix_Produit() {
        return Prix_Produit;
    }

    public void setPrix_Produit(Double Prix_Produit) {
        this.Prix_Produit = Prix_Produit;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Produit{" + "id_Produit=" + id_Produit + ", Nom_Produit=" + Nom_Produit + ", Marque_Produit=" + Marque_Produit + ", Categorie_Produit=" + Categorie_Produit + ", Prix_Produit=" + Prix_Produit + ", quantite=" + quantite + '}';
    }

   
    
    

    

  
    
}
