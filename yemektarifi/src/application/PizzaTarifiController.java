package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;



import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class PizzaTarifiController implements Initializable {
	
    @FXML
    private AnchorPane panel;

    @FXML
    private Button ekle;
    
    @FXML
    private Button menuyedon;

    @FXML
    private TextField txtTarifAdi;

    @FXML
    private TextField txtTarifDetayi;
    
    @FXML
    private TextField txtMalzemeListesi;
    

    @FXML
    private TextField txtCesit;

    private ObservableList<PizzaTarifi> pizzaList = FXCollections.observableArrayList();


 
    @FXML
    void ekle(ActionEvent event) throws IOException {
    	//ekleme iþlemi yapar
        pizzaList.remove(pizzaList);
        
        String TarifAdi = txtTarifAdi.getText().trim();
        String TarifDetayi = txtTarifDetayi.getText().trim();
        String Cesit = txtCesit.getText().trim();
        String MalzemeListesi = txtMalzemeListesi.getText().trim();
       
        
        PizzaTarifi pt = new PizzaTarifi(TarifAdi,TarifDetayi, Cesit, MalzemeListesi);
        pizzaList.addAll(PizzaTarifi.dosyadanPizzaTarifiGetir());
        pizzaList.add(pt);
        DosyaIslemleri.dosyayaYaz(pizzaList, "PizzaTarifi");
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("main.fxml"));
        panel.getChildren().setAll(pane);
    }
    
    @FXML
    void menuyeDon(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("main.fxml"));
        panel.getChildren().setAll(pane);

    }
    @FXML
    void initialize() {

    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

    }
	
}

