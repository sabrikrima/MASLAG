/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFx;

import Entité.evenement;
import static java.awt.PageAttributes.MediaType.C;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import service.EventService;

/**
 * FXML Controller class
 *
 * @author Advanceinfo
 */
public class ClientEController implements Initializable {

    @FXML
    private Pane ClientE;
    @FXML
    private TableView<evenement> TableEC;
    @FXML
    private TableColumn<evenement,String> NomEC;
    @FXML
    private TableColumn<evenement,String> AdresseEC;
    @FXML
    private TableColumn<evenement, Integer> NumEC;
    @FXML
    private TableColumn<evenement,Double> PrixEC;
    @FXML
    private TableColumn<evenement,String> DdEC;
    @FXML
    private TableColumn<evenement,String> DfEC;
    @FXML
    private Button ValiderE;
    EventService Es = new EventService();
    ObservableList<evenement> data = FXCollections.observableArrayList();
    
  
    @FXML
    private TextField inputR;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EventService Es = new EventService();
        
        
        ObservableList<evenement> list = FXCollections.observableArrayList();
        afficherEvent();
         showEv();
        
        // TODO
    }    

    @FXML
    private void ValiderEC(ActionEvent event) {
        		
         
        }


    private void afficherEvent() {
       EventService Es = new EventService();
        
        ObservableList<evenement> list  = FXCollections.observableArrayList(); 
       NomEC.setCellValueFactory(new PropertyValueFactory<>("Nom_Event"));
        AdresseEC.setCellValueFactory(new PropertyValueFactory<>("Adresse_Event"));
        NumEC.setCellValueFactory(new PropertyValueFactory<>("Num_Event"));
        PrixEC.setCellValueFactory(new PropertyValueFactory<>("Prix_P"));
        DdEC.setCellValueFactory(new PropertyValueFactory<>("Date_Debut"));
        DfEC.setCellValueFactory(new PropertyValueFactory<>("Date_Fin"));
        
        TableEC.setItems(list);
       
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
  /*  private double Prix_P;
    private String Date_Debut;
    private String Date_Fin;*/
  
     
      public ObservableList<evenement> getEvenement(){
        ObservableList<evenement> evList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM evenement";
        Statement st;
        ResultSet rs;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery(query);
            evenement EV;
            while(rs.next()){
                EV = new evenement(rs.getString("Nom_Event"),rs.getString("Adresse_Event"),rs.getInt("Num_Event"),rs.getDouble("Prix_P"),rs.getString("Date_Debut"),rs.getString("Date_Fin"));
          evList.add(EV);
            }
                
        }catch(SQLException ex){
        }
        return evList;
    }
     public void showEv(){
        ObservableList<evenement>  listev  = getEvenement();
        
     
        NomEC.setCellValueFactory(new PropertyValueFactory<evenement, String>("Nom_Event"));
        AdresseEC.setCellValueFactory(new PropertyValueFactory<evenement, String>("Adresse_Event"));
        NumEC.setCellValueFactory(new PropertyValueFactory<evenement, Integer>("Num_Event"));
        PrixEC.setCellValueFactory(new PropertyValueFactory<evenement, Double>("Prix_P"));
        DdEC.setCellValueFactory(new PropertyValueFactory<evenement, String>("Date_Debut"));
         DfEC.setCellValueFactory(new PropertyValueFactory<evenement, String>("Date_Fin"));
        
                TableEC.setItems(listev);
//recherche

         FilteredList<evenement> filteredData = new FilteredList<>(listev, b -> true);
		
		
		inputR.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(ev  -> {
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (ev.getNom_Event().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
                                
				} else if (ev.getAdresse_Event().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
				else if (String.valueOf(ev.getNum_Event()).indexOf(lowerCaseFilter)!=-1){
                                 return true;
                                
                                } 
                               
                                 
                                 else if (ev.getDate_Debut().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true;
				}
                                  else if (ev.getDate_Fin().toLowerCase().indexOf(lowerCaseFilter) != -1) 
					return true; 
				
				     
                                  else  
				    	 return false; // Does not match
                                
                        
                                
                                
                                
                                
			});
		});
SortedList<evenement> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(TableEC.comparatorProperty());
        TableEC.setItems(sortedData);
		
        
        
        
    
         
       
     
        
    }

     
    }
    

