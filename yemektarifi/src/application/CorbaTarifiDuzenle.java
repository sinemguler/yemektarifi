
package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class CorbaTarifiDuzenle implements Initializable {

	@FXML
    private AnchorPane panel;

    @FXML
    private TextField txtTarifAdi;
    @FXML
    private TextField txtTarifDetayi;
    @FXML
    private TextField txtCesit;
    @FXML
    private TextField txtMalzemeListesi;
   
    
    private static ObservableList<CorbaTarifi> corbaList;
    CorbaTarifi secilenCorba;

    public static void setCorbaList(ObservableList<CorbaTarifi> corbaList) {
    	CorbaTarifiDuzenle.corbaList = corbaList;
    }

    void degerGetir(CorbaTarifi corbatarifi) {
       secilenCorba = corbatarifi;
       txtTarifAdi.setText(secilenCorba.getTarifAdi());
       txtTarifDetayi.setText(secilenCorba.getTarifDetayi());
       txtCesit.setText(secilenCorba.getCesit());
       txtMalzemeListesi.setText(secilenCorba.getMalzemeListesi());
       
    }
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnDuzenleIptal(ActionEvent event) {
        kapat(event);
    }

    @FXML
    private void btnDuzenleKaydet(ActionEvent event) {
       corbaList.remove(secilenCorba);
        String TarifAdi = txtTarifAdi.getText().trim();
        String TarifDetayi = txtTarifDetayi.getText().trim();
        String Cesit = txtCesit.getText().trim();
        String MalzemeListesi = txtMalzemeListesi.getText().trim();
        
        
        CorbaTarifi ct= new CorbaTarifi(TarifAdi, TarifDetayi, Cesit,MalzemeListesi);
        corbaList.add(ct);
        DosyaIslemleri.dosyayaYaz(corbaList, "CorbaTarifi");
        
        
        kapat(event);
    }

    
    private void kapat(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
    
}



