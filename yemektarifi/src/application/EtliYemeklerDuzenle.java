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


public class EtliYemeklerDuzenle implements Initializable {

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
    
    
    private static ObservableList<EtliYemekler>etList;
    EtliYemekler secilenEt;

    public static void setEtList(ObservableList<EtliYemekler> etList) {
    	EtliYemeklerDuzenle.etList = etList;
    }
    void degerGetir (EtliYemekler etliyemekler) {
       secilenEt = etliyemekler;
       txtTarifAdi.setText(secilenEt.getTarifAdi());
       txtTarifDetayi.setText(secilenEt.getTarifDetayi());
       txtCesit.setText(secilenEt.getCesit());
       txtMalzemeListesi.setText(secilenEt.getMalzemeListesi());
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
        etList.remove(secilenEt);
        String TarifAdi = txtTarifAdi.getText().trim();
        String TarifDetayi = txtTarifDetayi.getText().trim();
        String Cesit = txtCesit.getText().trim();
        String MalzemeListesi = txtMalzemeListesi.getText().trim();
        
        EtliYemekler ey = new EtliYemekler(TarifAdi,TarifDetayi,Cesit,MalzemeListesi);
        etList.add(ey);
        DosyaIslemleri.dosyayaYaz(etList, "EtliYemekler");
        
        
        
        kapat(event);
    }

    
    private void kapat(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }


	}
    
    

