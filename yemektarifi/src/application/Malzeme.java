package application;

import java.util.ArrayList;

public class Malzeme {
	protected String malzemeAdi;
	protected String malzemeTip;
	protected int olcuBirim;
	protected int malzemeMiktari;
	protected ArrayList<Malzeme> malzemeList = new ArrayList<>();
	
	
	
	public Malzeme() {
		super();
	}

	public Malzeme(String malzemeAdi, String malzemeTip, int olcuBirim, int malzemeMiktari,
			ArrayList<Malzeme> malzemeList) {
		super();
		this.malzemeAdi = malzemeAdi;
		this.malzemeTip = malzemeTip;
		this.olcuBirim = olcuBirim;
		this.malzemeMiktari = malzemeMiktari;
		this.malzemeList = malzemeList;
		System.out.println("malzeme listesi:" + this);
	}

	public void malzemeEkle(Malzeme malzeme) {
		malzemeList.add(malzeme);
	}
	
	public void malzemeListeleme() {
		for (Malzeme m : malzemeList) {
			System.out.println(m);
		}
	}
	
	public void malzemeSil(Malzeme malzeme) {
		malzemeList.remove(malzeme);
	}
	
	public void malzemeSil(Malzeme malzeme, String malzemeAdi) {
		if(malzeme.getMalzemeAdi()== malzemeAdi) {
			malzemeList.remove(malzeme);
			System.out.println("Malzeme Silme Metodu Çalýþtý.");
		}
	}

	public void malzemeGuncelle(String malzemeAdi, String malzemeTip, int olcuBirim, int malzemeMiktari) {
		
	}
	public String getMalzemeAdi() {
		return malzemeAdi;
	}

	public void setMalzemeAdi(String malzemeAdi) {
		this.malzemeAdi = malzemeAdi;
	}

	public String getMalzemeTip() {
		return malzemeTip;
	}

	public void setMalzemeTip(String malzemeTip) {
		this.malzemeTip = malzemeTip;
	}

	public int getOlcuBirim() {
		return olcuBirim;
	}

	public void setOlcuBirim(int olcuBirim) {
		this.olcuBirim = olcuBirim;
	}

	public int getMalzemeMiktari() {
		return malzemeMiktari;
	}

	public void setMalzemeMiktari(int malzemeMiktari) {
		this.malzemeMiktari = malzemeMiktari;
	}

	public ArrayList<Malzeme> getMalzemeList() {
		return malzemeList;
	}

	public void setMalzemeList(ArrayList<Malzeme> malzemeList) {
		this.malzemeList = malzemeList;
	}

	public void ekle(Malzeme malzeme) {
		// TODO Auto-generated method stub
		
	}

	public void listele() {
		// TODO Auto-generated method stub
		
	}

	void sil(Malzeme malzeme) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return new String(malzemeAdi + "" +  malzemeTip + "" + olcuBirim + "" +  malzemeMiktari + "");
		 // return getMalzemeAdi() + "\t" + getMalzemeTip() + "\t" + getOlcuBirim() + "\t" + getMalzemeMiktari();
	}

	public void add() {
		System.out.println("malzeme eklendi");
	}
	
	
}
	