package application;


import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
//import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.collections.transformation.FilteredList;
//import javafx.collections.transformation.SortedList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class CorbaTarifiGoruntule implements Initializable {

     ObservableList<CorbaTarifi> corbaList = FXCollections.observableArrayList();
    
    @FXML
    private AnchorPane panel;

    @FXML
    private Button menuyedon;
    
    @FXML
    private Button corbaSil;
    
    @FXML
    private Button corbaDuzenle;

    @FXML
    private TableView<CorbaTarifi> corbatarifiListele; //tabloya ve görüntü çerisindeki etiketlere eriþir

    @FXML
    private TableColumn< CorbaTarifi, String> tTarifAdi;

    @FXML
    private TableColumn< CorbaTarifi, String> tTarifDetayi;
    
    @FXML
    private TableColumn< CorbaTarifi, String> tCesit;
    
    @FXML
    private TableColumn< CorbaTarifi, String> tMalzemeListesi;
    
    @FXML
    private TextField txtAramaYap;


  

    @FXML
    void menuyeDon(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("main.fxml"));
        panel.getChildren().setAll(pane);

    }

    public ObservableList<CorbaTarifi> getCorbaTarifiFromFile() {
        try {
            BufferedReader br = DosyaIslemleri.dosyaGetir("CorbaTarifi");
            String line;
            String[] s;
            while ((line = br.readLine()) != null) {
                s = line.split("\t");
                CorbaTarifi ct= new CorbaTarifi((s[0]), s[1], s[2],s[3]);
                corbaList.add(ct);
            }
            br.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return corbaList;
    }

	
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        
	        //tabloya ekleme yapar
		 tTarifAdi.setCellValueFactory(new PropertyValueFactory<>("tarifAdi"));//kolonda gösterilecek veriyi modele baðlar
		 tTarifDetayi.setCellValueFactory(new PropertyValueFactory<>("tarifDetayi"));//tarif detayýný ekrana bastýrýr
		 tCesit.setCellValueFactory(new PropertyValueFactory<>("Cesit"));
		 tMalzemeListesi.setCellValueFactory(new PropertyValueFactory<>("MalzemeListesi"));
	        
		 corbatarifiListele.setItems( getCorbaTarifiFromFile());
		 //arama yapýlýr
		 FilteredList<CorbaTarifi> filteredCorbaTarifi = new FilteredList<>(corbaList,b->true);
	     
	     txtAramaYap.textProperty().addListener(((observable,oldValue,newValue) -> {
	         filteredCorbaTarifi.setPredicate(corbatarifi -> {
	             if(newValue == null || newValue.isEmpty()){
	                 return true;
	             }
	             
	             String lowerCaseFilter = newValue.toLowerCase();
	             
	             if(String.valueOf(corbatarifi.getTarifAdi()).toLowerCase().indexOf(lowerCaseFilter)!= -1){
	                 return true;
	             }else if(corbatarifi.getTarifDetayi().toLowerCase().indexOf(lowerCaseFilter) != -1){
	                 return true;
	             }else if(corbatarifi.getCesit().toLowerCase().indexOf(lowerCaseFilter) != -1){
	                 return true;
	             }else if(corbatarifi.getMalzemeListesi().toLowerCase().indexOf(lowerCaseFilter) != -1){//içindeki karakter stringi arar
	                 return true;
	             }else{
	                 return false;
	             }
	         });
	         SortedList<CorbaTarifi> sortedCorbaTarifi= new SortedList<>(filteredCorbaTarifi);
	     
	         sortedCorbaTarifi.comparatorProperty().bind(corbatarifiListele.comparatorProperty());
	     
	      corbatarifiListele.setItems(sortedCorbaTarifi);
	     }));
	 }

    @FXML
    void corbaSil(ActionEvent event) {

       CorbaTarifi seciliCorba = corbatarifiListele.getSelectionModel().getSelectedItem();
        corbatarifiListele.getItems().remove(seciliCorba);
        corbaList.remove(seciliCorba);
        DosyaIslemleri.dosyayaYaz(corbaList, "CorbaTarifi");

    }
    @FXML
    private void corbaDuzenle(ActionEvent event) {
        if(corbatarifiListele.getSelectionModel().getSelectedItem() == null) return;
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CorbaTarifiDuzenle.fxml"));
            Parent parent = loader.load();
            CorbaTarifiDuzenle corbaDuzenle = loader.<CorbaTarifiDuzenle>getController();
            CorbaTarifi ct = corbatarifiListele.getSelectionModel().getSelectedItem();
            loader.setController(corbaDuzenle);
            corbaDuzenle.degerGetir(ct);
            Stage duzenleStage = new Stage();
            Scene scene = new Scene(parent);
            duzenleStage.setTitle("CorbaTarifiDuzenle");
            corbaDuzenle.setCorbaList(corbaList);
            
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



