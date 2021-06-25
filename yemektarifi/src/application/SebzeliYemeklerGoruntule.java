package application;

import java.io.BufferedReader;
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


public class SebzeliYemeklerGoruntule implements Initializable {

     ObservableList<SebzeliYemekler> sebzeList = FXCollections.observableArrayList();
    
    @FXML
    private AnchorPane panel;

    @FXML
    private Button menuyedon;

    @FXML
    private Button sebzeSil;
    
    @FXML
    private Button sebzeDuzenle;

    @FXML
    private TableView<SebzeliYemekler> sebzeliyemeklerListele;

    @FXML
    private TableColumn<SebzeliYemekler , String> tTarifAdi;

    @FXML
    private TableColumn<SebzeliYemekler , String> tTarifDetayi;
    
    @FXML
    private TableColumn<SebzeliYemekler , String> tCesit;
    
    @FXML
    private TableColumn<  PizzaTarifi, String> tMalzemeListesi;

    @FXML
    private TextField txtAramaYap;

  

    @FXML
    void menuyeDon(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("main.fxml"));
        panel.getChildren().setAll(pane);

    }

    
    public ObservableList<SebzeliYemekler> getSebzeliYemeklerFromFile() {
        try {
            BufferedReader br = DosyaIslemleri.dosyaGetir("SebzeliYemekler");
            String line;
            String[] s;
            while ((line = br.readLine()) != null) {
                s = line.split("\t");
                SebzeliYemekler sy= new SebzeliYemekler((s[0]), s[1], s[2], s[3]);
                sebzeList.add(sy);
            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return sebzeList;
    }

	
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        
	        //Tableview Eklemesi Yapar
		 tTarifAdi.setCellValueFactory(new PropertyValueFactory<>("tarifAdi"));
		 tTarifDetayi.setCellValueFactory(new PropertyValueFactory<>("tarifDetayi"));
		 tCesit.setCellValueFactory(new PropertyValueFactory<>("Cesit"));
		 tMalzemeListesi.setCellValueFactory(new PropertyValueFactory<>("MalzemeListesi"));
	        
		 
		 sebzeliyemeklerListele.setItems( getSebzeliYemeklerFromFile());
		 
		 
		 FilteredList<SebzeliYemekler> filteredSebzeliYemekler = new FilteredList<>(sebzeList,b->true);
	        
	        txtAramaYap.textProperty().addListener(((observable,oldValue,newValue) -> {
	            filteredSebzeliYemekler.setPredicate(sebzeliyemekler -> {
	                if(newValue == null || newValue.isEmpty()){
	                    return true;
	                }
	                
	                String lowerCaseFilter = newValue.toLowerCase();
	                
	                if(String.valueOf(sebzeliyemekler.getTarifAdi()).toLowerCase().indexOf(lowerCaseFilter)!= -1){
	                    return true;
	                }else if(sebzeliyemekler.getTarifDetayi().toLowerCase().indexOf(lowerCaseFilter) != -1){
	                    return true;
	                }else if(sebzeliyemekler.getCesit().toLowerCase().indexOf(lowerCaseFilter) != -1){
	                    return true;
	                }else if(sebzeliyemekler.getMalzemeListesi().toLowerCase().indexOf(lowerCaseFilter) != -1){
	                    return true;
	                }else{
	                    return false;
	                }
	            });
	            SortedList<SebzeliYemekler> sortedSebzeliYemekler= new SortedList<>(filteredSebzeliYemekler);
	        
	            sortedSebzeliYemekler.comparatorProperty().bind(sebzeliyemeklerListele.comparatorProperty());
	        
	           sebzeliyemeklerListele.setItems(sortedSebzeliYemekler);
	        }));
	 }
    @FXML
    void sebzeSil(ActionEvent event) {

       SebzeliYemekler seciliSebze = sebzeliyemeklerListele.getSelectionModel().getSelectedItem();
        sebzeliyemeklerListele.getItems().remove(seciliSebze);
        sebzeList.remove(seciliSebze);
        DosyaIslemleri.dosyayaYaz(sebzeList, "SebzeliYemekler");

    }

    @FXML
    private void sebzeDuzenle(ActionEvent event) {
        if(sebzeliyemeklerListele.getSelectionModel().getSelectedItem() == null) return;
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SebzeliYemeklerDuzenle.fxml"));
            Parent parent = loader.load();
            SebzeliYemeklerDuzenle sebzeDuzenle = loader.<SebzeliYemeklerDuzenle>getController();
            SebzeliYemekler sy = sebzeliyemeklerListele.getSelectionModel().getSelectedItem();
            loader.setController(sebzeDuzenle);
            sebzeDuzenle.degerGetir(sy);
            Stage duzenleStage = new Stage();
            Scene scene = new Scene(parent);
            duzenleStage.setTitle("SebzeliYemeklerDuzenle");
            sebzeDuzenle.setSebzeList(sebzeList);
            
            duzenleStage.initModality(Modality.APPLICATION_MODAL);
            duzenleStage.setScene(scene);
            duzenleStage.showAndWait();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	/*@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}*/

	
 
}



