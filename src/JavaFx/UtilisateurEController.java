/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaFx;

import Entité.evenement;
import connexion.MaConnexion;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEvent;
import javax.swing.text.Document;
import service.EventService;
import static sun.java2d.cmm.ColorTransform.Out;

/**
 * FXML Controller class
 *
 * @author Advanceinfo
 */
public class UtilisateurEController implements Initializable {

      public Connection cnx;
     public PreparedStatement ste;

    @FXML
    private AnchorPane HomeE;
    @FXML
    private Pane PaneE;
    @FXML
    private Button AjouterE;
    @FXML
    private Button ModifierE;
    @FXML
    private Button RetourE;
    @FXML
    private TextField NomE;
    @FXML
    private TextField AdresseE;
    @FXML
    private TextField NumE;
    @FXML
    private TextField PrixE;
    @FXML
    private TextField DdE;
    @FXML
    private TextField DfE;
    @FXML
    private TableView<evenement> TableEU;
    @FXML
    private TableColumn<evenement, String> NomEU;
    @FXML
    private TableColumn<evenement, String> AdresseEU;
    @FXML
    private TableColumn<evenement, Integer> NumEU;
    @FXML
    private TableColumn<evenement, Double> PrixEU;
    @FXML
    private TableColumn<evenement, String> DdEU;
    @FXML
    private TableColumn<evenement, String> DfEU;
    @FXML
    private TextField IdEU;
         ObservableList<evenement> list  = getEvenement(); 

    /**
     * Initializes the controller class.
     */
        EventService Es = new EventService();
         
    ObservableList<evenement> data = FXCollections.observableArrayList();
    @FXML
    private Button ImprimerE;
    
    @Override
     public void initialize(URL url, ResourceBundle rb) {
            
            afficherEvent();
            
        System.out.println("afichina");
    }    



    @FXML
    private void SaveE(ActionEvent event) {
//  Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setTitle("Confirmation modification");
//        alert.setContentText("Etes vous sur de modifier ce article?");
//        Optional<ButtonType> result = alert.showAndWait();        
//        if (action.get() == ButtonType.OK) 
//                {
               String Nom_Event = NomE.getText();
        String Adresse_Event = AdresseE.getText();
        Integer Num_Event = Integer.parseInt(NumE.getText());
        double Prix_P = Double.parseDouble(PrixE.getText());
        String Date_Debut = DdE.getText();
         String Date_Fin = DfE.getText();
       evenement E1 = new evenement(Nom_Event, Adresse_Event, Num_Event, Prix_P, Date_Debut, Date_Fin);
        EventService Es = new EventService();
        
       
        
           Es.ajouterEvent(E1);
           System.out.println("evenement wtezd !");
//        }
//        else {
//            System.out.println("Cancel");
//        }
//        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
//        alersetTitle("Confirmation");
//        alert2.setHeat2.derext(null);
//        alert2.setContentText("ajouter avec succÃ¨s");
//        alert2.showAndWait();
//                
//        }}
    }
    @FXML
    private void ModifierE(ActionEvent event)  {
      
        
        
                  
          try {
              String sql ="UPDATE evenement SET Nom_Event = '"+ NomE.getText()
                      +"',Adresse_Event = '"+ AdresseE.getText()
                      +"',Num_Event = '"+ NumE.getText()
                      +"',Prix_P = '"+ PrixE.getText()
                      +"',Date_Debut = '"+ DdE.getText()
                      +"',Date_Fin = '"+ DfE.getText()
                      +"' WHERE ID_Event = "+ IdEU.getText()+"";
               afficherEvent();
               
               
              
             
              ste=cnx.prepareStatement(sql);
              ste.executeUpdate();
          } catch (SQLException ex) {
              Logger.getLogger(UtilisateurEController.class.getName()).log(Level.SEVERE, null, ex);
          }
        
   
         
    
    }

    @FXML
    private void RetourE(ActionEvent event) {
       }
         
    

   
       public Connection getConnection(){
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/maslag_db", "root","");
            return conn;
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
            return null;
        }}
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
                
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return evList;}
         private void afficherEvent() {
       EventService Es = new EventService();
        
       
        NomEU.setCellValueFactory(new PropertyValueFactory<evenement, String>("Nom_Event"));
        AdresseEU.setCellValueFactory(new PropertyValueFactory<evenement, String>("Adresse_Event"));
        NumEU.setCellValueFactory(new PropertyValueFactory<evenement, Integer>("Num_Event"));
        PrixEU.setCellValueFactory(new PropertyValueFactory<evenement, Double>("Prix_P"));
        DdEU.setCellValueFactory(new PropertyValueFactory<evenement, String>("Date_Debut"));
        DfEU.setCellValueFactory(new PropertyValueFactory<evenement, String>("Date_Fin"));
        
        TableEU.setItems(list);
       
    }
   
/*private int ID_Event ;
    private String Nom_Event;
    private String Adresse_Event;
    private int Num_Event ;
      private double Prix_P;
    private String Date_Debut;
    private String Date_Fin;

*/

    @FXML
    private void ImprimerE(ActionEvent event) {
        

     
        
    }

 
 
    
    
    
}  
