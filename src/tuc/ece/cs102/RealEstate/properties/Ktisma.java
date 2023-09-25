package tuc.ece.cs102.RealEstate.properties;

import java.time.*;

public abstract class Ktisma extends Property {
	
	public enum XrhshKatoikias{
		KATOIKIA,
		EPAGGELMATIKO
	}

	private String adress;
	private int constructionDate;
	private XrhshKatoikias xrhsh;

/********************constructors**********************/
	public Ktisma(long code, String nomos, String dhmos, double area, double value, double zPrice, String adr,int conDate, XrhshKatoikias xrhsh) {
		super(code, nomos, dhmos, area, value, zPrice);
		this.adress = adr;
		this.constructionDate = conDate;
		this.xrhsh = xrhsh;
	}

/********************methods**********************/
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public int getConstructionDate() {
		return constructionDate;
	}
	
	public void setConstructionDate(int constructionDate) {
		this.constructionDate = constructionDate;
	}
	
	public XrhshKatoikias getXrhsh() {
		return xrhsh;
	}
	
	public void setXrhsh(XrhshKatoikias xrhsh) {
		this.xrhsh = xrhsh;
	}
	
	public String toString() {
		return super.toString()+" Adress : "+adress+" Construction date : "+constructionDate+" Use : "+xrhsh;
	}
	
	public double getAgeFactor() {
		int nowYear = LocalDate.now().getYear();
		int diff = nowYear - constructionDate;
		if(diff >= 0 && diff<= 10) {
			return 1;
		}else if(diff >=11 && diff <= 20) {
			return 0.9;
		}else if(diff >= 21 && diff <=30) {
			return 0.8;
		}else {
			return 0.5;
		}
			
	}

	public double getEnfiaAkinhtou() {
		double ageFactor = getAgeFactor();
		double enfia = ageFactor * getZonePrice() * getArea();
		return enfia;
	}

}