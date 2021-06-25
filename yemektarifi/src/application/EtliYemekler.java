package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EtliYemekler extends Yemek {
	private String Cesit;

	private ObservableList<EtliYemekler> etList = FXCollections.observableArrayList();

	public EtliYemekler(String tarifAdi, String tarifDetayi, String Cesit, String malzemeListesi) {
		super(tarifAdi, tarifDetayi, malzemeListesi);
		this.Cesit = Cesit;

	}

	public static ObservableList<EtliYemekler> dosyadanEtliYemeklerGetir() {
		ObservableList<EtliYemekler> geciciList = FXCollections.observableArrayList();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("EtliYemekler")));
			String line;
			String[] s;
			while ((line = br.readLine()) != null) {
				s = line.split("\t");
				EtliYemekler ey = new EtliYemekler(s[0],s[1], s[2], s[3]);
				geciciList.add(ey);
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

	public ObservableList<EtliYemekler> getEtList() {
		return etList;
	}

	public void setEtList(ObservableList<EtliYemekler> etList) {
		this.etList = etList;
	}

}
