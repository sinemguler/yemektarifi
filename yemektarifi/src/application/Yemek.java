package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public abstract class Yemek {

	private String tarifAdi;
	private String tarifDetayi;
	private String malzemeListesi;
  
	public Yemek() {
	
	}

	public Yemek( String tarifAdi , String tarifDetayi, String malzemeListesi) {
        this.tarifAdi= tarifAdi;
        this.tarifDetayi = tarifDetayi;
        this.malzemeListesi = malzemeListesi;
      
    }

	public String getTarifAdi() {
		return tarifAdi;
	}

	public void setTarifAdi(String tarifAdi) {
		this.tarifAdi = tarifAdi;
	}

	public String getTarifDetayi() {
		return tarifDetayi;
	}

	public void setTarifDetayi(String tarifDetayi) {
		this.tarifDetayi = tarifDetayi;
	}

	public String getMalzemeListesi() {
		return malzemeListesi;
	}

	public void setMalzemeListesi(String malzemeListesi) {
		this.malzemeListesi = malzemeListesi;
	}


}

