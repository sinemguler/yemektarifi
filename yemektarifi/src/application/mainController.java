package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class mainController implements  Initializable {

    @FXML
    private AnchorPane panel;
    @FXML
    private Button sebzeliyemekler;
    @FXML
    private Button pizzatarifi;
    @FXML
    private Button corbatarifi;
    @FXML
    private Button etliyemekler;
    @FXML
    private Button sebzeliyemeklerGoruntule;
    @FXML
    private Button pizzatarifiGoruntule;
    @FXML
    private Button corbatarifiGoruntule;
    @FXML
    private Button etliyemeklerGoruntule;
    
    @FXML
    void sebzeliyemekler(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("SebzeliYemekler.fxml"));
        panel.getChildren().setAll(pane);

    }

    @FXML
    void pizzatarifi(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("PizzaTarifi.fxml"));
        panel.getChildren().setAll(pane);

    }

    @FXML
    void corbatarifi(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("CorbaTarifi.fxml"));
        panel.getChildren().setAll(pane);

    }


    @FXML
    void etliyemekler(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("EtliYemekler.fxml"));
        panel.getChildren().setAll(pane);

    }

    @FXML
    void sebzeliyemeklerGoruntule(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("SebzeliYemeklerGoruntule.fxml"));
        panel.getChildren().setAll(pane);

    }
    @FXML
    void pizzatarifiGoruntule(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("PizzaTarifiGoruntule.fxml"));
        panel.getChildren().setAll(pane);

    }
    @FXML
    void corbatarifiGoruntule(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("CorbaTarifiGoruntule.fxml"));
        panel.getChildren().setAll(pane);

    }
    @FXML
    void etliyemeklerGoruntule(ActionEvent event) throws IOException {
        AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("EtliYemeklerGoruntule.fxml"));
        panel.getChildren().setAll(pane);

    }
    void initialize() {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

   
}
