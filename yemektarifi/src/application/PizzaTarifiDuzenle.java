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


public class PizzaTarifiDuzenle implements Initializable {

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
   
    
    private static ObservableList<PizzaTarifi> pizzaList;
    PizzaTarifi secilenPizza;

    public static void setPizzaList(ObservableList<PizzaTarifi> pizzaList) {
    	PizzaTarifiDuzenle.pizzaList = pizzaList;
    }

    void degerGetir(PizzaTarifi pizzatarifi) {
    	//düzenlenecek deðerler gelir
       secilenPizza = pizzatarifi;
       txtTarifAdi.setText(secilenPizza.getTarifAdi());
       txtTarifDetayi.setText(secilenPizza.getTarifDetayi());
       txtCesit.setText(secilenPizza.getCesit());
       txtMalzemeListesi.setText(secilenPizza.getMalzemeListesi());
       
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
    	//düzenlenen deðerler kaydedilir
       pizzaList.remove(secilenPizza);
        String TarifAdi = txtTarifAdi.getText().trim();
        String TarifDetayi = txtTarifDetayi.getText().trim();
        String Cesit = txtCesit.getText().trim();
        String MalzemeListesi= txtMalzemeListesi.getText().trim();
        
        
        PizzaTarifi pt = new PizzaTarifi(TarifAdi, TarifDetayi, Cesit, MalzemeListesi);
        pizzaList.add(pt);
        DosyaIslemleri.dosyayaYaz(pizzaList, "PizzaTarifi");
        
        
        kapat(event);
    }

    
    private void kapat(ActionEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
    
}



