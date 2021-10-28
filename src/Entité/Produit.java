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
    private int quantite;
     private String image;

    public Produit(String Nom_Produit, String Marque_Produit, double Prix_Produit, int quantite) {
        this.Nom_Produit = Nom_Produit;
        this.Marque_Produit = Marque_Produit;
        this.Prix_Produit = Prix_Produit;
        this.quantite = quantite;
    }

    public Produit(int Id_Produit, String Nom_Produit, String Marque_Produit, String Categorie_Produit, double Prix_Produit, int quantite) {
        this.Id_Produit = Id_Produit;
        this.Nom_Produit = Nom_Produit;
        this.Marque_Produit = Marque_Produit;
        this.Categorie_Produit = Categorie_Produit;
        this.Prix_Produit = Prix_Produit;
        this.quantite = quantite;
    }

    public Produit(String Nom_Produit, String Marque_Produit, double Prix_Produit, int quantite, String img) {
        this.Nom_Produit = Nom_Produit;
        this.Marque_Produit = Marque_Produit;
        this.Prix_Produit = Prix_Produit;
        this.quantite = quantite;
        this.image = img;
    }

    public Produit(String Nom_Produit, String Marque_Produit, String Categorie_Produit, double Prix_Produit, int quantite, String img) {
        this.Nom_Produit = Nom_Produit;
        this.Marque_Produit = Marque_Produit;
        this.Categorie_Produit = Categorie_Produit;
        this.Prix_Produit = Prix_Produit;
        this.quantite = quantite;
        this.image = img;
    }

    public Produit(int Id_Produit, String Nom_Produit, String Marque_Produit, String Categorie_Produit, double Prix_Produit, int quantite, String img) {
        this.Id_Produit = Id_Produit;
        this.Nom_Produit = Nom_Produit;
        this.Marque_Produit = Marque_Produit;
        this.Categorie_Produit = Categorie_Produit;
        this.Prix_Produit = Prix_Produit;
        this.quantite = quantite;
        this.image = img;
    }

    public void setImg(String img) {
        this.image = img;
    }

    public String getImg() {
        return image;
    }

    public Produit(String Nom_Produit, String Marque_Produit, String Categorie_Produit, double Prix_Produit, int quantite) {
        this.Nom_Produit = Nom_Produit;
        this.Marque_Produit = Marque_Produit;
        this.Categorie_Produit = Categorie_Produit;
        this.Prix_Produit = Prix_Produit;
        this.quantite = quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public int getQuantite() {
        return quantite;
    }

    public Produit() {
    }

    public Produit(int Id_Produit, String Nom_Produit, String Marque_Produit, String Categorie_Produit, double Prix_Produit) {
        this.Id_Produit = Id_Produit;
        this.Nom_Produit = Nom_Produit;
        this.Marque_Produit = Marque_Produit;
        this.Categorie_Produit = Categorie_Produit;
        this.Prix_Produit = Prix_Produit;
    }

    public Produit(String Nom_Produit, String Marque_Produit, double Prix_Produit) {
        this.Nom_Produit = Nom_Produit;
        this.Marque_Produit = Marque_Produit;
        this.Prix_Produit = Prix_Produit;
    }

    public Produit(String Nom_Produit, String Marque_Produit, String Categorie_Produit, double Prix_Produit) {
        this.Nom_Produit = Nom_Produit;
        this.Marque_Produit = Marque_Produit;
        this.Categorie_Produit = Categorie_Produit;
        this.Prix_Produit = Prix_Produit;
    }

    public Produit(String a, String b, String c, String d, String e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return "Produit{" + "Id_Produit=" + Id_Produit + ", Nom_Produit=" + Nom_Produit + ", Marque_Produit=" + Marque_Produit + ", Categorie_Produit=" + Categorie_Produit + ", Prix_Produit=" + Prix_Produit + ", quantite=" + quantite + ", img=" + image + '}';
    }

    

   


    }




