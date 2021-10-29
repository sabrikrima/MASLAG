/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFxProjectMaslagVente;

import Entité.Produit;
import Entité.command;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author saidi
 */
public class FXMLConfirmComVController implements Initializable {

    @FXML
    private Label prixTotalQt_V;
    @FXML
    private Button btn_payement;
    @FXML
    private Label total_prix_avant_remise;
    @FXML
    private Label remise;
    @FXML
    private TableView<command> tableView3;
    @FXML
    private TableColumn<command, String> colNproduitV;
    @FXML
    private TableColumn<command, Double> colpricePV;
    @FXML
    private TableColumn<command, Integer> colquantitéPv;
    
    
    
ObservableList<command> commandList = FXCollections.observableArrayList();
    ObservableList<command>  list1  = getCommandList();
    @FXML
    private Button btn_Facture;
    @FXML
    private Button returnP2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        total_prix_avant_remise.setText("Total Prix :" +Double.toString(cal()));
        Double f = cal()-(cal()*5/100);
        prixTotalQt_V.setText("Total Prix :" +Double.toString(f));
        showProduit();
        System.out.println(list1);
       // System.out.println(calculPannier());
       //total_prix_avant_remise.setText(double.toString(calculPannier()));
        System.out.println(total_prix_avant_remise);
        
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


    @FXML
    private void payementPv(ActionEvent event) {
    }
    
    
    
     public void showProduit(){
        
       
        
        colNproduitV.setCellValueFactory(new PropertyValueFactory<command, String>("Nom_Produit"));
        colpricePV.setCellValueFactory(new PropertyValueFactory<command, Double>("Prix_Produit"));
        colquantitéPv.setCellValueFactory(new PropertyValueFactory<command, Integer>("quantite"));
     
         System.out.println(list1);
        
        
        tableView3.setItems(list1);
      
    
    
    
    
}
     
    @FXML
    private void btn_facture(ActionEvent event) throws IOException, DocumentException {
      Document doc = new Document() ;
        
         PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\saidi\\Documents\\NetBeansProjects\\pdfventeFacture.pdf"));
            doc.open();
         Font f = new Font(Font.FontFamily.TIMES_ROMAN,50.0f, Font.UNDERLINE );

            Paragraph p = new Paragraph("Votre facture ", f);
            p.setAlignment(Element.ALIGN_CENTER);
            doc.add(p);
            
            Font a = new Font(Font.FontFamily.TIMES_ROMAN,20f );


            Paragraph contenu = new Paragraph();
            doc.add(contenu) ;
            doc.close();

         Desktop.getDesktop().open(new File("C:\\Users\\saidi\\Documents\\NetBeansProjects\\pdfventeFacture.pdf"));
         
         
    }

    @FXML
    private void returnP2(ActionEvent event) throws IOException {
        
        
          returnP2.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLpannierVente.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
        
        
    }

   
public Double cal(){
        
        Double a =0.0;
          
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
         
               a=a+rs.getDouble("Prix_Produit");
               
          }
              
      }catch(Exception ex){
           ex.printStackTrace();
        }
        return a;
    }  
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
      
}
     
     
     
