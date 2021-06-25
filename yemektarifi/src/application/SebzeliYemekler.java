package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SebzeliYemekler extends Yemek {
	private String Cesit;
	
	 private ObservableList<SebzeliYemekler > sebzeList = FXCollections.observableArrayList();

	
	 public SebzeliYemekler(String tarifAdi, String tarifDetayi, String malzemeListesi, String Cesit) {
		super(tarifAdi, tarifDetayi, malzemeListesi);
		this.Cesit = Cesit;
	}

	public static ObservableList<SebzeliYemekler> dosyadanSebzeliYemeklerGetir() {
	        ObservableList<SebzeliYemekler> geciciList = FXCollections.observableArrayList();
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(new File("SebzeliYemekler")));
	            String line;
	            String[] s;
	            while ((line = br.readLine()) != null) {
	                s = line.split("\t");
	                SebzeliYemekler sy = new SebzeliYemekler(s[0], s[1], s[2],s[3]);
	                geciciList.add(sy);
	            }
	            br.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return geciciList;
	    }

	public String getCesit() {
		return Cesit;
	}


	public void setCesit(String cesit) {
		Cesit = cesit;
	}
	
	  public ObservableList<SebzeliYemekler> getSebzeList() {
		return sebzeList;
	}
	public void setSebzeList(ObservableList<SebzeliYemekler> sebzeList) {
		this.sebzeList = sebzeList;
	}
	
	@Override
	    public String toString() {
	         return  getTarifAdi()+ "\t" + getTarifDetayi()+ "\t" +  getCesit()+ "\t" + getMalzemeListesi() +"t"; 
	    }
	

}


