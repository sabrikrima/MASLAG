/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFxProjectMaslagVente;

import Entité.Produit;
import Entité.command;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javaFxProjectMaslagVente.FXMLpannierVenteController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import service.CommandService;
/**
 * FXML Controller class
 *
 * @author saidi
 */
public class FXMLVenteController implements Initializable {
ObservableList<Produit>  list  = getProduitList();
    @FXML
    private TextField searchInputV;
    @FXML
    private Button searchButtonPV;
    @FXML
    private VBox chosirProduitVente;
    @FXML
    private Button btnAjouterPannierV;
    @FXML
    private Button ConfirmerButtonV;
    @FXML
    private TableView<Produit> tableViewPv;
    @FXML
    private TableColumn<Produit, String> colNproduitV;
    @FXML
    private TableColumn<Produit, String> colMarquePv;
    @FXML
    private TableColumn<Produit, String> colCategoriePv;
    @FXML
    private TableColumn<Produit, Double> colpricePV;
    
     @FXML
    private TableColumn<Produit, Integer> colquantitéPv;
    @FXML
    private ComboBox<String> comboBoxVenteQte;
    
   private String[] xx= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29"};
   

   
   
    @FXML
    private void searchInputV(ActionEvent event) {
  
    }
    @FXML
    private void searchButtonPV(ActionEvent event) {
        
        
        
    }


    @FXML
    private void AjouterPannierV(ActionEvent event) throws IOException {
        
        ConfirmerButtonV.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLpannierVente.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
        
        
        
        
        
    }

    @FXML
    private void ConfirmerButtonV(ActionEvent event) {
    
        
    }
    
    ObservableList<Produit> items;
        private  ObservableList<Produit> dataListP = FXCollections.observableArrayList();
        

     /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboBoxVenteQte.getItems().addAll(xx);
      /*  selectAllVenteCheck.selectedProperty().addListener(new ChangeListener<Boolean>(){
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println("Select all ");
                items = tableViewPv.getItems();
                
                for(Produit item : items){
                    
                    if(selectAllVenteCheck.isSelected())
                        item.getSelect().setSelected(true);
                    else 
                        item.getSelect().setSelected(false);
                }
                
            }
        
        
        
        });
    
        //methode recherche
          // Wrap the ObservableList in a FilteredList (initially display all data).
       
     
        
        
 
        
     
        */
        
        
        
        
        
        
        showProduit();
    }    
    
    
    
    
    
    
    
    

    
    public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/maslag_db", "root","");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }
    
    public ObservableList<Produit> getProduitList(){
        ObservableList<Produit> prdouitList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM produit";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Produit produit;
            while(rs.next()){
                produit = new Produit(rs.getInt("id_Produit"),rs.getString("Nom_Produit"),rs.getString("Marque_Produit"),rs.getString("Categorie_Produit"),rs.getDouble("Prix_Produit"),rs.getInt("quantite"));
          
                prdouitList.add(produit);
            }
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return prdouitList;
    }
     public void showProduit(){
        
         
      
        colNproduitV.setCellValueFactory(new PropertyValueFactory<Produit, String>("Nom_Produit"));
        colMarquePv.setCellValueFactory(new PropertyValueFactory<Produit, String>("Marque_Produit"));
        colCategoriePv.setCellValueFactory(new PropertyValueFactory<Produit, String>("Categorie_Produit"));
        colpricePV.setCellValueFactory(new PropertyValueFactory<Produit, Double>("Prix_Produit"));
        colquantitéPv.setCellValueFactory(new PropertyValueFactory<Produit, Integer>("quantite"));
     
         System.out.println(list);
        
         //System.out.println(colcheckbox.getUserData());
        tableViewPv.setItems(list);
        
         FilteredList<Produit> filteredData = new FilteredList<>(list, b -> true);
		
		// 2. Set the filter Predicate whenever the filter changes.
		searchInputV.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(produit -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (produit.getNom_Produit().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (produit.getMarque_Produit().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (String.valueOf(produit.getPrix_Produit()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Produit> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableViewPv.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableViewPv.setItems(sortedData);
               
        
        
       
    }

    @FXML
    private void mousebtn_panier_v(MouseEvent event) {
        command m = new command();
        Produit p = tableViewPv.getSelectionModel().getSelectedItem();
         // FXMLpannierVenteController.prdouitList.add(p);
       System.out.println(p);
        m.setNom_Produit(p.getNom_Produit());
        m.setMarque_Produit(p.getMarque_Produit());
        m.setPrix_Produit(p.getPrix_Produit());
        m.setCategorie_Produit(p.getCategorie_Produit());
        m.setQuantite(Integer.parseInt(comboBoxVenteQte.getValue()));
        m.setId_User(1);
        m.setDate_Com("aaaa");
        m.setId_Produit(p.getId_Produit());
        
        CommandService u = new CommandService();
        u.AjouterCommand(m);
        System.out.println(m);
    }

    @FXML
    private void comboBoxVenteQte(MouseEvent event) {
        
        
    }
    
     
     
    
    
}
