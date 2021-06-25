package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
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


public class EtliYemeklerGoruntule implements Initializable {

     ObservableList< EtliYemekler> etList = FXCollections.observableArrayList();
    
    @FXML
    private AnchorPane panel;

    @FXML
    private Button menuyedon;

    @FXML
    private Button etSil;
    
    @FXML
    private Button etDuzenle;
    
    @FXML
    private TableView<EtliYemekler>  etliyemeklerListele;

    @FXML
    private TableColumn<EtliYemekler, String> tTarifAdi;

    @FXML
    private TableColumn<EtliYemekler, String> tTarifDetayi;

    @FXML
    private TableColumn<EtliYemekler, String> tCesit;
    
    @FXML
    private TableColumn< CorbaTarifi, String> tMalzemeListesi;
    
    
    @FXML
    private TextField txtAramaYap;

  

    @FXML
    void menuyeDon(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("main.fxml"));
        panel.getChildren().setAll(pane);

    }

	private ObservableList<EtliYemekler> getEtliYemeklerListele() {
      
		try {
            BufferedReader br = DosyaIslemleri.dosyaGetir("EtliYemekler");
            String line;
            String[] s;
            while ((line = br.readLine()) != null) {
                s = line.split("\t");
                EtliYemekler ey = new   EtliYemekler((s[0]), s[1], s[2],s[3]);
                etList.add(ey);
            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return etList;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Tableview Eklemesi Yapar
	 tTarifAdi.setCellValueFactory(new PropertyValueFactory<>("tarifAdi"));
	 tTarifDetayi.setCellValueFactory(new PropertyValueFactory<>("tarifDetayi"));
	 tCesit.setCellValueFactory(new PropertyValueFactory<>("Cesit"));
	 tMalzemeListesi.setCellValueFactory(new PropertyValueFactory<>("MalzemeListesi"));
       
	 etliyemeklerListele.setItems(getEtliYemeklerListele());
	 
	 FilteredList<EtliYemekler> filteredEtliYemekler = new FilteredList<>(etList,b->true);
     
     txtAramaYap.textProperty().addListener(((observable,oldValue,newValue) -> {
         filteredEtliYemekler.setPredicate(etliyemekler -> {
             if(newValue == null || newValue.isEmpty()){
                 return true;
             }
             
             String lowerCaseFilter = newValue.toLowerCase();
             
             if(String.valueOf(etliyemekler.getTarifAdi()).toLowerCase().indexOf(lowerCaseFilter)!= -1){
                 return true;
             }else if(etliyemekler.getTarifDetayi().toLowerCase().indexOf(lowerCaseFilter) != -1){
                 return true;
             }else if(etliyemekler.getCesit().toLowerCase().indexOf(lowerCaseFilter) != -1){
            	 return true;
             }else if(etliyemekler.getMalzemeListesi().toLowerCase().indexOf(lowerCaseFilter) != -1){
                 return true;
             }else{
                 return false;
             }
         });
         SortedList<EtliYemekler> sortedEtliYemekler= new SortedList<>(filteredEtliYemekler);
     
         sortedEtliYemekler.comparatorProperty().bind(etliyemeklerListele.comparatorProperty());
     
      etliyemeklerListele.setItems(sortedEtliYemekler);
     }));
 }
    
    @FXML
    void etSil(ActionEvent event) {

       EtliYemekler seciliEt = etliyemeklerListele.getSelectionModel().getSelectedItem();
        etliyemeklerListele.getItems().remove(seciliEt);
        etList.remove(seciliEt);
        DosyaIslemleri.dosyayaYaz(etList, "EtliYemekler");

    }
    
    @FXML
    private void etDuzenle(ActionEvent event)  {
    	if (etliyemeklerListele.getSelectionModel().getSelectedItem() == null) return;
    	try {
    	FXMLLoader loader =  new FXMLLoader(getClass().getResource("EtliYemeklerDuzenle.fxml"));
    	Parent parent = loader.load();
    	EtliYemeklerDuzenle etDuzenle  = loader.<EtliYemeklerDuzenle>getController();
    	EtliYemekler ey =etliyemeklerListele.getSelectionModel().getSelectedItem();
    	loader.setController(etDuzenle);
    	etDuzenle.degerGetir(ey);
    	Stage duzenleStage = new Stage();
    	Scene scene  = new Scene(parent);
    	duzenleStage.setTitle("EtliYemeklerDuzenle");
		etDuzenle.setEtList(etList);
    	
    	 
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

	public TableView<EtliYemekler> getEtliyemeklerListele() {
		return etliyemeklerListele;
	}

	public void setEtliyemeklerListele(TableView<EtliYemekler> etliyemeklerListele) {
		this.etliyemeklerListele = etliyemeklerListele;
	}
    
 
}



