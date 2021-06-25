package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PizzaTarifi extends Yemek {
	private String Cesit;
	
	 private ObservableList<PizzaTarifi> pizzaList = FXCollections.observableArrayList();

	
	 public PizzaTarifi(String tarifAdi, String tarifDetayi, String malzemeListesi, String Cesit) {
		super(tarifAdi, tarifDetayi, malzemeListesi);
		this.Cesit = Cesit;
	}

	public static ObservableList< PizzaTarifi> dosyadanPizzaTarifiGetir() {
	        ObservableList< PizzaTarifi> geciciList = FXCollections.observableArrayList();
	        try {
	            BufferedReader br = new BufferedReader(new FileReader(new File("PizzaTarifi")));
	            String line;
	            String[] s;
	            while ((line = br.readLine()) != null) {
	                s = line.split("\t");
	                PizzaTarifi pt = new  PizzaTarifi(s[0], s[1], s[2],s[3]);
	                geciciList.add(pt);
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
	         return  getTarifAdi()+ "\t" + getTarifDetayi()+ "\t" +  getCesit()+ "\t" + getMalzemeListesi() +"t"; 
	    }

	public ObservableList<PizzaTarifi> getPizzaList() {
		return pizzaList;
	}

	public void setPizzaList(ObservableList<PizzaTarifi> pizzaList) {
		this.pizzaList = pizzaList;
	}


	
}