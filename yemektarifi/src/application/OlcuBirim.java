package application;

import java.util.ArrayList;

public class OlcuBirim {
	
	private double gram;
	private String paket;
	private String adet;
	private double kg;
	private double ml;
	private String subardak;
	private String caybardak;
	private String tatlikasik;
	private String yemekkasik;
	private String caykasik;
	private String olcuAdi;
	private ArrayList<OlcuBirim> birimList = new ArrayList<>();
	
	
	public void birimEkle(OlcuBirim olcubirim) {
		birimList.add(olcubirim);
	}
	
	public void birimListeleme() {
		for (OlcuBirim ob : birimList) {
			System.out.println(ob);
		}
	}
	
	public void birimSil(OlcuBirim olcubirim) {
		birimList.remove(olcubirim);
	}
	
	public void birimSil(OlcuBirim olcubirim, String olcuAdi) {
		if(olcubirim.getOlcuAdi()== olcuAdi) {
			birimList.remove(olcubirim);
			System.out.println("Ölçü Birim Silme Metodu Çalýþtý.");
		}
	}

	public void birimGuncelle(double gram, String paket,String adet,double kg, double ml,String subardak ,String caybardak ,String tatlikasik,String yemekkasik,String caykasik,String olcuAdi) {
		
	}

	public double getGram() {
		return gram;
	}

	public void setGram(double gram) {
		this.gram = gram;
	}

	public String getPaket() {
		return paket;
	}

	public void setPaket(String paket) {
		this.paket = paket;
	}

	public String getAdet() {
		return adet;
	}

	public void setAdet(String adet) {
		this.adet = adet;
	}

	public double getKg() {
		return kg;
	}

	public void setKg(double kg) {
		this.kg = kg;
	}

	public double getMl() {
		return ml;
	}

	public void setMl(double ml) {
		this.ml = ml;
	}

	public String getSubardak() {
		return subardak;
	}

	public void setSubardak(String subardak) {
		this.subardak = subardak;
	}

	public String getCaybardak() {
		return caybardak;
	}

	public void setCaybardak(String caybardak) {
		this.caybardak = caybardak;
	}

	public String getTatlikasik() {
		return tatlikasik;
	}

	public void setTatlikasik(String tatlikasik) {
		this.tatlikasik = tatlikasik;
	}

	public String getYemekkasik() {
		return yemekkasik;
	}

	public void setYemekkasik(String yemekkasik) {
		this.yemekkasik = yemekkasik;
	}

	public String getCaykasik() {
		return caykasik;
	}

	public void setCaykasik(String caykasik) {
		this.caykasik = caykasik;
	}

	public String getOlcuAdi() {
		return olcuAdi;
	}

	public void setOlcuAdi(String olcuAdi) {
		this.olcuAdi = olcuAdi;
	}

	public ArrayList<OlcuBirim> getBirimList() {
		return birimList;
	}

	public void setBirimList(ArrayList<OlcuBirim> birimList) {
		this.birimList = birimList;
	}

	@Override
	public String toString() {
		return "OlcuBirim [gram=" + gram + ", paket=" + paket + ", adet=" + adet + ", kg=" + kg + ", ml=" + ml
				+ ", subardak=" + subardak + ", caybardak=" + caybardak + ", tatlikasik=" + tatlikasik + ", yemekkasik="
				+ yemekkasik + ", caykasik=" + caykasik + ", olcuAdi=" + olcuAdi + ", birimList=" + birimList + "]";
	}
	
	
}
