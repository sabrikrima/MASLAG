/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guii;

import Entité.Produit;
import connexion.MaConnexion;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class ClienProduuitController implements Initializable {
   public Connection cnx;
     public PreparedStatement ste;
    @FXML
    private TableView<Produit> tab;
    @FXML
   private TableColumn<Produit, String> nomb;
    @FXML
     private TableColumn<Produit, String> marqb;
    @FXML
     private TableColumn<Produit, String> catb;
    @FXML
     private TableColumn<Produit, String> prixb;
     private TableColumn<Produit, String> quanb;
     private TableColumn<Produit, String> imbb;
    @FXML
    private TextField liensearch;
    @FXML
    private Button search;
    
     ObservableList<Produit>  ProduitList = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
        cnx = MaConnexion.getInstance().getconnection();
        ResultSet rs = cnx.createStatement().executeQuery("SELECT * FROM produit");
        while (rs.next()){
        Produit p = new Produit ();
        ProduitList.add(new Produit(
                rs.getString("Nom_Produit"),
        rs.getString("Marque_Produit"),
        rs.getString("Categorie_Produit"),
        rs.getDouble("Prix_Produit")
       // rs.getInt("quantite"),
       // rs.getString("image")
        ));
        }
        tab.setItems(ProduitList);
        } catch (SQLException ex) {
        Logger.getLogger(AjouterProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
       // imbb.setCellValueFactory(new PropertyValueFactory<>("image"));
        nomb.setCellValueFactory(new PropertyValueFactory<>("Nom_Produit"));
        marqb.setCellValueFactory(new PropertyValueFactory<>("Marque_Produit"));
        catb.setCellValueFactory(new PropertyValueFactory<>("Categorie_Produit"));
        prixb.setCellValueFactory(new PropertyValueFactory<>("Prix_Produit"));
        //quanb.setCellValueFactory(new PropertyValueFactory<>("quantite"));
    }    

    @FXML
    private void lsaction(ActionEvent event) {
    }

    @FXML
    private void searchab(ActionEvent event) {
        Produit p = new Produit();
      
        ObservableList<Produit> ProduitList1 = this.ProduitList;
        
       
            nomb.setCellValueFactory(new PropertyValueFactory<>("Nom_Produit"));
        marqb.setCellValueFactory(new PropertyValueFactory<>("Marque_Produit"));
        catb.setCellValueFactory(new PropertyValueFactory<>("Categorie_Produit"));
        prixb.setCellValueFactory(new PropertyValueFactory<>("Prix_Produit"));
        //quanb.setCellValueFactory(new PropertyValueFactory<>("quantite"));

        tab.setItems(ProduitList1);
        FilteredList<Produit> filteredData = new FilteredList<>(ProduitList1, b -> true);
        liensearch.textProperty().addListener((observable, oldValue, newValue) -> {
        
        filteredData.setPredicate((Produit art) -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (art.getNom_Produit().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				} else if (art.getMarque_Produit().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; 
				}
                                else if (art.getCategorie_Produit().toLowerCase().indexOf(lowerCaseFilter)!=-1){
				     return true;
                                }
                                else if (String.valueOf(art.getPrix_Produit()).indexOf(lowerCaseFilter)!=-1){
				     return true;
                                }
                               
				     else  
				    	 return false; 
			});
		});
        SortedList<Produit> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tab.comparatorProperty());
        tab.setItems(sortedData);
    }
    
}
