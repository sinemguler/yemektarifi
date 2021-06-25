package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PizzaTarifiGoruntule implements Initializable {

     ObservableList< PizzaTarifi> pizzaList = FXCollections.observableArrayList();
    
    @FXML
    private AnchorPane panel;

    @FXML
    private Button menuyedon;
    
    @FXML
    private Button pizzaSil;
    
    @FXML
    private Button pizzaDuzenle;

    @FXML
    private TableView<PizzaTarifi> pizzatarifiListele;

    @FXML
    private TableColumn<  PizzaTarifi, String> tTarifAdi;

    @FXML
    private TableColumn<  PizzaTarifi, String> tTarifDetayi;
    
    @FXML
    private TableColumn<  PizzaTarifi, String> tCesit;
    
    @FXML
    private TableColumn<  PizzaTarifi, String> tMalzemeListesi;

    @FXML
    private TextField txtAramaYap;
  

    @FXML
    void menuyeDon(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("main.fxml"));
        panel.getChildren().setAll(pane);

    }

    private ObservableList<PizzaTarifi> getPizzaTarifiFromFile() {
        try {
            BufferedReader br = DosyaIslemleri.dosyaGetir("PizzaTarifi");
            String line;
            String[] s;
            while ((line = br.readLine()) != null) {
                s = line.split("\t");
                PizzaTarifi pt = new   PizzaTarifi((s[0]), s[1], s[2], s[3]);
               pizzaList.add(pt);
            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return pizzaList;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Tableview Eklemesi Yapar
	 tTarifAdi.setCellValueFactory(new PropertyValueFactory<>("tarifAdi"));
	 tTarifDetayi.setCellValueFactory(new PropertyValueFactory<>("tarifDetayi"));
	 tCesit.setCellValueFactory(new PropertyValueFactory<>("Cesit"));
	 tMalzemeListesi.setCellValueFactory(new PropertyValueFactory<>("MalzemeListesi"));
       
	 pizzatarifiListele.setItems(getPizzaTarifiFromFile());
	 //aramak istenen deðerler aranýr
	 FilteredList<PizzaTarifi> filteredPizzaTarifi = new FilteredList<>(pizzaList,b->true);
     
     txtAramaYap.textProperty().addListener(((observable,oldValue,newValue) -> {
         filteredPizzaTarifi.setPredicate(pizzatarifi -> {
             if(newValue == null || newValue.isEmpty()){
                 return true;
             }
             
             String lowerCaseFilter = newValue.toLowerCase();
             
             if(String.valueOf(pizzatarifi.getTarifAdi()).toLowerCase().indexOf(lowerCaseFilter)!= -1){
                 return true;
             }else if(pizzatarifi.getTarifDetayi().toLowerCase().indexOf(lowerCaseFilter) != -1){
                 return true;
             }else if(pizzatarifi.getCesit().toLowerCase().indexOf(lowerCaseFilter) != -1){
                 return true;
             }else if(pizzatarifi.getMalzemeListesi().toLowerCase().indexOf(lowerCaseFilter) != -1){
                 return true;
             }else{
                 return false;
             }
         });
         SortedList<PizzaTarifi> sortedPizzaTarifi= new SortedList<>(filteredPizzaTarifi);
     
         sortedPizzaTarifi.comparatorProperty().bind(pizzatarifiListele.comparatorProperty());
     
       pizzatarifiListele.setItems(sortedPizzaTarifi);
     }));
 }
    
    @FXML
    void pizzaSil(ActionEvent event) {

        PizzaTarifi seciliPizza = pizzatarifiListele.getSelectionModel().getSelectedItem();
        pizzatarifiListele.getItems().remove(seciliPizza);
        pizzaList.remove(seciliPizza);
        DosyaIslemleri.dosyayaYaz(pizzaList, "PizzaTarifi");

    }
    
    @FXML
    private void pizzaDuzenle(ActionEvent event) {
    	//düzenlenecek deðerler gelir
        if(pizzatarifiListele.getSelectionModel().getSelectedItem() == null) return;
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PizzaTarifiDuzenle.fxml"));
            Parent parent = loader.load();
            PizzaTarifiDuzenle pizzaDuzenle = loader.<PizzaTarifiDuzenle>getController();
            PizzaTarifi pt = pizzatarifiListele.getSelectionModel().getSelectedItem();
            loader.setController(pizzaDuzenle);
            pizzaDuzenle.degerGetir(pt);
            Stage duzenleStage = new Stage();
            Scene scene = new Scene(parent);
            duzenleStage.setTitle("PizzaTarifiDuzenle");
            pizzaDuzenle.setPizzaList(pizzaList);
            
            duzenleStage.initModality(Modality.APPLICATION_MODAL);
            duzenleStage.setScene(scene);
            duzenleStage.showAndWait();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
	/*@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}*/
    
 




