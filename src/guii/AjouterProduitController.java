/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guii;


import java.awt.image.BufferedImage;
 import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import Entité.Produit;
import connexion.MaConnexion;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import Service.ProduitService;
import Service.ServicePDFp;
import com.itextpdf.text.DocumentException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import static java.util.Arrays.stream;
import static java.util.Arrays.stream;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author ahmed
 */
public class AjouterProduitController implements Initializable {
    
      public Connection cnx;
     public PreparedStatement ste;

    @FXML
    private ComboBox comb;
    @FXML
    private TextField NOMd;
    @FXML
    private TextField MARQUEd;
    @FXML
    private TextField CATEGORIEd;
    @FXML
    private TextField PRIXd;
    @FXML
    private TableView<Produit> table;
    @FXML
    private TableColumn<Produit, String> NOMT;
    @FXML
    private TableColumn<Produit, String> MARQUET;
    @FXML
    private TableColumn<Produit, String> CATEGORIET;
    @FXML
    private TableColumn<Produit, String> PRIXT;
    ObservableList<Produit>  ProduitList = FXCollections.observableArrayList();
    ObservableList<Produit>  ProduitList2 = FXCollections.observableArrayList();
    @FXML
    private TextField IDd;
    private TableColumn<?, ?> IDT;
    @FXML
    private TextField IDM;
    @FXML
    private TextField recherche;
    @FXML
    private Button rrrrrrrr;
    private ObservableList<Produit> ProduitList1;
    @FXML
    private TableColumn<Produit, String>quantitet;
    @FXML
    private TextField quantited;
    @FXML
    private TextField imaged;
    private TableColumn<Produit, String>imgt;
    @FXML
    private Button ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button supprimer;
    @FXML
    private Label NOMc;
    @FXML
    private Label MARQUEc;
    @FXML
    private Label CATEGORIEc;
    @FXML
    private Label PRIXc;
    @FXML
    private Button afficher;
    @FXML
    private Button pdf;
    @FXML
    private Button impor;
    @FXML
    private ImageView mmm;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> Listx = FXCollections.observableArrayList("jupes","maillots","sacs","collants","chaussures","ensembles","blousons","Elastoplast"," protège-bras","protège-jampes"," support de cheville","support de poignet","ceinture");
        comb.setItems(Listx);
        
        try {
        cnx = MaConnexion.getInstance().getconnection();
        ResultSet rs = cnx.createStatement().executeQuery("SELECT * FROM produit");
        while (rs.next()){
        Produit p = new Produit ();
        ProduitList.add(new Produit(
               // rs.getInt("Id_Produit"),
                rs.getString("Nom_Produit"),
        rs.getString("Marque_Produit"),
        rs.getString("Categorie_Produit"),
        rs.getDouble("Prix_Produit"),
        rs.getInt("quantite")
        //rs.getString("image")
        ));
        }
        table.setItems(ProduitList);
        } catch (SQLException ex) {
        Logger.getLogger(AjouterProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //imgt.setCellValueFactory(new PropertyValueFactory<>("image"));
        //IDT.setCellValueFactory(new PropertyValueFactory<>("Id_Produit"));
        NOMT.setCellValueFactory(new PropertyValueFactory<>("Nom_Produit"));
        MARQUET.setCellValueFactory(new PropertyValueFactory<>("Marque_Produit"));
        CATEGORIET.setCellValueFactory(new PropertyValueFactory<>("Categorie_Produit"));
        PRIXT.setCellValueFactory(new PropertyValueFactory<>("Prix_Produit"));
        quantitet.setCellValueFactory(new PropertyValueFactory<>("quantite"));
      
     
    }    

    @FXML
    private void ajouterP(ActionEvent event) {
        
        if(    "".equals(NOMd.getText()) ||  "".equals(MARQUEd.getText()) ||  "".equals(CATEGORIEd.getText()) || "".equals(PRIXd.getText()) || "".equals(quantited.getText()) || "".equals(imaged.getText()) ){ 
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setTitle("Confirmation");
        alert2.setHeaderText(null);
        alert2.setContentText("il faux remplire toute les cases");
        alert2.showAndWait();
        }else{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure to add ?");
        Optional<ButtonType> action = alert.showAndWait(); 
         
        if (action.get() == ButtonType.OK) {
        String rnom = NOMd.getText();
        String rmarque = MARQUEd.getText();
        String rcategorie = CATEGORIEd.getText();
        double rprix = Double.parseDouble(PRIXd.getText());
        int rquantite = Integer.parseInt(quantited.getText());
        String rimage = imaged.getText();
        Produit p1 = new Produit(rnom,rmarque,rcategorie,rprix,rquantite,rimage);
        ProduitService ps1 = new ProduitService();
        ps1.ajouterProduit(p1);
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setTitle("Confirmation");
        alert2.setHeaderText(null);
        alert2.setContentText("ajouter avec succès");
        alert2.showAndWait();
        } 
    }
    }
    @FXML
    private void modifierP(ActionEvent event) throws IOException, SQLException{
        
        
        
        if(    "".equals(NOMd.getText()) ||  "".equals(MARQUEd.getText()) ||  "".equals(CATEGORIEd.getText()) || "".equals(PRIXd.getText())|| "".equals(IDM.getText()) || "".equals(quantited.getText()) || "".equals(imaged.getText())){ 
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setTitle("Confirmation");
        alert2.setHeaderText(null);
        alert2.setContentText("il faux remplire toute les cases");
        alert2.showAndWait();
        }else{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure to modifier ?");
        Optional<ButtonType> action = alert.showAndWait(); 
         
        if (action.get() == ButtonType.OK) {
        String sql ="UPDATE produit SET Nom_Produit = '"+ NOMd.getText() +"', Marque_Produit = '"+ MARQUEd.getText() +"', Categorie_Produit = '"+ CATEGORIEd.getText() +"', Prix_Produit = '"+ PRIXd.getText() +"',quantite = '"+ quantited.getText() +"',image = '"+ imaged.getText() +"'   WHERE Id_Produit = "+ IDM.getText()+"";
        ste=cnx.prepareStatement(sql);
        ste.executeUpdate();
        
          
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setTitle("Confirmation");
        alert2.setHeaderText(null);
        alert2.setContentText("modifier avec succès");
        alert2.showAndWait();
        } 
    }

    }

    @FXML
    private void supprimerP(ActionEvent event) {
        
        if(    "".equals(IDd.getText())){ 
        Alert alert3 = new Alert(Alert.AlertType.INFORMATION);
        alert3.setTitle("Confirmation");
        alert3.setHeaderText(null);
        alert3.setContentText("il faux remplire la case");
        alert3.showAndWait();
        }else{Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText(null);
        alert.setContentText("Are you sure to delete ?");
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
        try {      
        String sql = "delete from produit where Id_Produit="+IDd.getText() + "";
        ste=cnx.prepareStatement(sql);
        ste.executeUpdate();
        } catch (SQLException ex) {
        Logger.getLogger(AjouterProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
        alert2.setTitle("Confirmation");
        alert2.setHeaderText(null);
        alert2.setContentText("Suppression avec succès");
        alert2.showAndWait();
        }
        }
 

    @FXML
    private void combaction(ActionEvent event) {
        String s = comb.getSelectionModel().getSelectedItem().toString();
        CATEGORIEd.setText(s);
        
    }

    @FXML
    private void affichert(ActionEvent event) { 
        table.getItems().clear();
        ObservableList<Produit> ProduitList = this.ProduitList;
 
        try {
        cnx = MaConnexion.getInstance().getconnection();
        ResultSet rs = cnx.createStatement().executeQuery("SELECT * FROM produit");
        while (rs.next()){
        Produit p = new Produit ();
        ProduitList.add(new Produit(
               // rs.getInt("Id_Produit"),
                rs.getString("Nom_Produit"),
        rs.getString("Marque_Produit"),
        rs.getString("Categorie_Produit"),
        rs.getDouble("Prix_Produit"),
        rs.getInt("quantite")
       // rs.getString("image")
        ));
        }
        table.setItems(ProduitList);
        } catch (SQLException ex) {
        Logger.getLogger(AjouterProduitController.class.getName()).log(Level.SEVERE, null, ex);
        }
       // imgt.setCellValueFactory(new PropertyValueFactory<>("image"));
       // IDT.setCellValueFactory(new PropertyValueFactory<>("Id_Produit"));
        NOMT.setCellValueFactory(new PropertyValueFactory<>("Nom_Produit"));
        MARQUET.setCellValueFactory(new PropertyValueFactory<>("Marque_Produit"));
        CATEGORIET.setCellValueFactory(new PropertyValueFactory<>("Categorie_Produit"));
        PRIXT.setCellValueFactory(new PropertyValueFactory<>("Prix_Produit"));
        quantitet.setCellValueFactory(new PropertyValueFactory<>("quantite"));
        //imgt.setCellValueFactory(new PropertyValueFactory<>("image"));
 }


    @FXML
    private void rrr(ActionEvent event) {
        Produit p = new Produit();
      
        ObservableList<Produit> ProduitList1 = this.ProduitList;
        
       // IDT.setCellValueFactory(new PropertyValueFactory<>("Id_Produit"));
        NOMT.setCellValueFactory(new PropertyValueFactory<>("Nom_Produit"));
        MARQUET.setCellValueFactory(new PropertyValueFactory<>("Marque_Produit"));
        CATEGORIET.setCellValueFactory(new PropertyValueFactory<>("Categorie_Produit"));
        PRIXT.setCellValueFactory(new PropertyValueFactory<>("Prix_Produit"));

        table.setItems(ProduitList1);
        FilteredList<Produit> filteredData = new FilteredList<>(ProduitList1, b -> true);
        recherche.textProperty().addListener((observable, oldValue, newValue) -> {
        
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
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }

    @FXML
    private void pdfAction(ActionEvent event) throws DocumentException, FileNotFoundException, SQLException {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de création du PDF");
        alert.setHeaderText("Etes vous sur de vouloir créer un PDF qui contient la liste des produit?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
        ServicePDFp sp= new ServicePDFp();
        sp.liste_ProduitPDF();

        }
        }

    @FXML
    private void imporimage(ActionEvent event) {
        
        InputStream stream = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Pick a banner file!");
        fileChooser.setInitialDirectory(new File("\\"));
        Stage stage = new Stage();
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("JPG", "*.jpg"),
        new FileChooser.ExtensionFilter("JPEG", "*.jpeg"),   
        new FileChooser.ExtensionFilter("PNG", "*.png")
        );
        File file = fileChooser.showOpenDialog(stage);
        try {
        BufferedImage bufferedImage = ImageIO.read(file);
        Image img = SwingFXUtils.toFXImage(bufferedImage, null);
        imaged.setText(file.getAbsolutePath());
        stream = new FileInputStream(file.getAbsolutePath());
            Image image = new Image(stream);
            mmm.setImage(image);
        } catch (IOException ex) {
        System.out.println("could not get the image");
        
     
        }
    }

    @FXML
    private void mmmm(MouseEvent event) {
    }
    }

