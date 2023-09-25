package tuc.ece.cs102.RealEstate.owners;

import java.time.*;


public class FysikoProswpo extends Owner {
	private  String adress;
	private LocalDate dateOfBirth;
/********************constructors**********************/
public FysikoProswpo(long afm, String name, String adress, LocalDate birth) {
	super(afm, name);
	this.adress = adress;
	this.dateOfBirth = birth;
}

/********************methods**********************/
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void print() {
		System.out.println("Owner : Natural Person "+this.toString());
	}
	public String toString() {
		return "AFM: "+this.getAfm()+" Name: "+this.getName()+" Date of birth : "+getDateOfBirth()+" Adress : "+this.getAdress(); 
	}
	

}
