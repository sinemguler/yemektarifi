package application;
import java.util.ArrayList;

public class Tarif {
	
protected String tarifAdi;
protected String tarifDetayi;
protected ArrayList<Tarif>tarifList = new ArrayList<>();

public Tarif() {
	super();
}
	
	public Tarif (String tarifAdi,String tarifDetayi,ArrayList<Tarif> tarifList) {
		super();
		this.tarifAdi =  tarifAdi;
		this.tarifDetayi = tarifDetayi;
		   System.out.println("tarif listesi:" +this);
	   }
	


 
 public void tarifEkle(Tarif tarif) {
	 tarifList.add(tarif);
 }
 public void tarifGuncelle(String tarifAdi, String tarifDetayi) {
 }
 public void tarifSil(Tarif tarif) {
	 tarifList.remove(tarif);
	 
	 
 }
 public void tarifSil(Tarif tarif,String tarifAdi) {
if(tarif.getTarifAdi()== tarifDetayi) {
	 tarifList.remove(tarif);
	 System.out.println("Tarif Silme Metodu Çalýþtý.");
}
 }
 public void tarifListeleme() {
	 for (Tarif t: tarifList) {
		  System.out.println(t);
	 }
 }
 public String getTarifAdi() {
		return tarifAdi;
	}

	public void settarifAdi(String tarifAdi) {
		this.tarifAdi = tarifAdi;
	}

	public String gettarifDetayi() {
		return tarifDetayi;
	}

	public void settarifDetayi(String tarifDetayi) {
		this.tarifDetayi = tarifDetayi;
	}



	public ArrayList<Tarif> getTarifList() {
		return tarifList;
	}



	public void setTarifList(ArrayList<Tarif> tarifList) {
		this.tarifList = tarifList;
	}


	@Override
	 public String toString()  {
		return new String(tarifAdi +"" + tarifDetayi + "");
		}





}
