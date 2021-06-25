package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CorbaTarifi extends Yemek  {
	private String Cesit;
	
	 private ObservableList<CorbaTarifi> corbaList = FXCollections.observableArrayList();

	 public CorbaTarifi(String tarifAdi, String tarifDetayi, String malzemeListesi,String Cesit) {
			super(tarifAdi, tarifDetayi, malzemeListesi);
			this.Cesit = Cesit;
			
		}
	 public static ObservableList<CorbaTarifi> dosyadanCorbaTarifiGetir() {
	        ObservableList<CorbaTarifi> geciciList = FXCollections.observableArrayList();
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(new File("CorbaTarifi")));
	            String line;
	            String[] s;
	            while ((line = br.readLine()) != null) {
	                s = line.split("\t");
	              CorbaTarifi ct = new CorbaTarifi(s[0],s[1], s[2], s[3]);
	                geciciList.add(ct);
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
	
	 @Override
	    public String toString() {
	         return  getTarifAdi()+ "\t" + getTarifDetayi()+ "\t" +  getCesit()+ "\t"+getMalzemeListesi()+"t"; 
	    }


	
	public ObservableList<CorbaTarifi> getCorbaList() {
		return corbaList;
	}
	public void setCorbaList(ObservableList<CorbaTarifi> corbaList) {
		this.corbaList = corbaList;
	}
	
	

}


