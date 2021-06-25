package application;

//import java.util.ArrayList;

public class siviMalzeme extends Malzeme {

	private String soguksivi;
	private String sicaksivi;

	public siviMalzeme(String malzemeAdi, String malzemeTip, int olcuBirim, int malzemeMiktari, String soguksivi,
			String sicaksivi) {
		super();
		this.soguksivi = soguksivi;
		this.sicaksivi = sicaksivi;
		this.malzemeAdi = malzemeAdi;
		this.malzemeTip = malzemeTip;
		this.olcuBirim = olcuBirim;
		this.malzemeMiktari = malzemeMiktari;
		//this.malzemeList = malzemeList;
		//System.out.println(" sivi malzeme listesi:" + this);
	}

	public String getSoguksivi() {
		return soguksivi;
	}

	public void setSoguksivi(String soguksivi) {
		this.soguksivi = soguksivi;
	}

	public String getSicaksivi() {
		return sicaksivi;
	}

	public void setSicaksivi(String sicaksivi) {
		this.sicaksivi = sicaksivi;
	}
	
	@Override
	public String toString() {
		return new String(malzemeAdi + "" + malzemeTip + "" + olcuBirim + "" + malzemeMiktari + "" + sicaksivi + ""
				+ soguksivi + "");
		
	       // return getSoguksivi() + "\t" + getSicaksivi() + "\t" +  getMalzemeAdi() + "\t" + getMalzemeTip() + "\t" + getOlcuBirim() + "\t" + getMalzemeMiktari();
	    }


}
