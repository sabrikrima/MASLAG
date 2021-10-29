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
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author saidi
 */
public class FXMLpannierVenteController implements Initializable {

      /*  this.Date_Com = Date_Com;
        this.Nom_Produit = Nom_Produit;
        this.Marque_Produit = Marque_Produit;
        this.Categorie_Produit = Categorie_Produit;
        this.Prix_Produit = Prix_Produit;
        this.quantite = quantite;*/
    
    
    
    @FXML
    private Pane PaneVente;
    @FXML
    private TableColumn<command, String> colIdProduitV;
    @FXML
    private TableColumn<command, String> colNproduitV;
    @FXML
    private TableColumn<command, String> colMarquePv;
    @FXML
    private TableColumn<command, String> colCategoriePv;
    @FXML
    private TableColumn<command, Double> colpricePV;
    @FXML
    private TableColumn<command, Integer> colquantitéPv;
    @FXML
    private Button Valider_Vente;
    @FXML
    private Button RetourVente;

    
    
    
    static ObservableList<command> commandList = FXCollections.observableArrayList();
    ObservableList<command>  list1  = getCommandList();
    @FXML
    private TableView<command> tableview2;
    @FXML
    private Button suprimerCom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
commandProduit();
        
        
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
      
      
      
       
/* private int Id_Com;
    private int Id_User;
    private int id_Produit;
    private String Date_Com;
    private String Nom_Produit;
     private String Marque_Produit;
    private String Categorie_Produit;
    private Double Prix_Produit;
    private int quantite;*/
      
      public ObservableList<command> getCommandList(){
        
        
          
       Connection conn = getConnection();
      String query = "SELECT * FROM command";
       Statement st;
       ResultSet rs;
             try{
            st = conn.createStatement();
           rs = st.executeQuery(query);
           command Comm;
           while(rs.next()){
                Comm = new command(rs.getString("Date_Com"),rs.getString("Nom_Produit"),rs.getString("Marque_Produit"),rs.getString("Categorie_Produit"),rs.getDouble("Prix_Produit"),rs.getInt("quantite"));
         
               commandList.add(Comm);
               
          }
              
      }catch(Exception ex){
           ex.printStackTrace();
        }
        return commandList;
    }
       
         
       public void commandProduit(){
        
       
     
        colNproduitV.setCellValueFactory(new PropertyValueFactory<command, String>("Nom_Produit"));
        colMarquePv.setCellValueFactory(new PropertyValueFactory<command, String>("Marque_Produit"));
        colCategoriePv.setCellValueFactory(new PropertyValueFactory<command, String>("Categorie_Produit"));
        colpricePV.setCellValueFactory(new PropertyValueFactory<command, Double>("Prix_Produit"));
        colquantitéPv.setCellValueFactory(new PropertyValueFactory<command, Integer>("quantite"));
     
         System.out.println(list1);
        
         //System.out.println(colcheckbox.getUserData());
        tableview2.setItems(list1);
      
      
    
    
}

    @FXML
    private void validerCom(ActionEvent event) throws IOException {
        Valider_Vente.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLConfirmComV.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
        
    }

     @FXML
    private void suprimerComBtn(ActionEvent event) {
        tableview2.getItems().removeAll(tableview2.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void RetourVente(ActionEvent event) throws IOException {
        
          RetourVente.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLVenteP.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
        
        
        
    }
    
    
    
}