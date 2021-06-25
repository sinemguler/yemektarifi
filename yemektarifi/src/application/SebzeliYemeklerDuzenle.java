
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


public class SebzeliYemeklerDuzenle implements Initializable {

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
   
    
    private static ObservableList<SebzeliYemekler> sebzeList;
    SebzeliYemekler secilenSebze;

    public static void setSebzeList(ObservableList<SebzeliYemekler> sebzeList) {
    	SebzeliYemeklerDuzenle.sebzeList = sebzeList;
    }

    void degerGetir(SebzeliYemekler sebzeliyemekler) {
       secilenSebze = sebzeliyemekler;
       txtTarifAdi.setText(secilenSebze.getTarifAdi());
       txtTarifDetayi.setText(secilenSebze.getTarifDetayi());
       txtCesit.setText(secilenSebze.getCesit());
       txtMalzemeListesi.setText(secilenSebze.getMalzemeListesi());
       
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
       sebzeList.remove(secilenSebze);
        String TarifAdi = txtTarifAdi.getText().trim();
        String TarifDetayi = txtTarifDetayi.getText().trim();
        String Cesit = txtCesit.getText().trim();
        String MalzemeListesi= txtMalzemeListesi.getText().trim();
        
        
        SebzeliYemekler sy = new SebzeliYemekler(TarifAdi, TarifDetayi, Cesit, MalzemeListesi);
        sebzeList.add(sy);
        DosyaIslemleri.dosyayaYaz(sebzeList, "SebzeliYemekler");
        
        
        kapat(event);
    }

    
    private void kapat(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
    
}


