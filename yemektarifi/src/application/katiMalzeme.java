package application;

import java.util.ArrayList;

public class katiMalzeme extends Malzeme {
	private String tozmalzeme;

	
	public katiMalzeme() {
		super();
		// TODO Auto-generated constructor stub
	}

	public katiMalzeme(String malzemeAdi, String malzemeTip, int olcuBirim, int malzemeMiktari,
			 String tozmalzeme) {
		super();
		this.tozmalzeme = tozmalzeme;
		this.malzemeAdi = malzemeAdi;
		this.malzemeTip = malzemeTip;
		this.olcuBirim = olcuBirim;
		this.malzemeMiktari = malzemeMiktari;
		
		System.out.println(" kati malzeme listesi:" + this);
	}

	public String getTozmalzeme() {
		return tozmalzeme;
	}

	public void setTozmalzeme(String tozmalzeme) {
		this.tozmalzeme = tozmalzeme;
	}
	
	@Override
	public String toString() {
		
		
		return new String(malzemeAdi + "" +  malzemeTip + "" + olcuBirim + "" +  malzemeMiktari + ""+ tozmalzeme + "");
		 // return getTozmalzeme() + "\t" +  getMalzemeAdi() + "\t" + getMalzemeTip() + "\t" + getOlcuBirim() + "\t" + getMalzemeMiktari();
	}


	
}
