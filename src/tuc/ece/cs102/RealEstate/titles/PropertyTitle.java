package tuc.ece.cs102.RealEstate.titles;

import java.time.LocalDate;

import tuc.ece.cs102.RealEstate.owners.Owner;
import tuc.ece.cs102.RealEstate.properties.Property;

public class PropertyTitle {
	public enum TyposKyriothtas{
		PLHRHS,
		PSILH,
		EPIKARPIA
	}
	private int code;
	private LocalDate DateOfCreation;
	private Property property;
	private Owner owner;
	private double posostoIdioktisias;
	private TyposKyriothtas type;

/********************constructors**********************/
public PropertyTitle(int code, LocalDate creationDate, Property pr, Owner owner, double pososto, TyposKyriothtas type) {
	this.code = code;
	this.DateOfCreation = creationDate;
	this.property = pr;	
	this.owner = owner;
	this.posostoIdioktisias = pososto;
	this.type = type;
}
	
/********************methods**********************/

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public LocalDate getDateOfCreation() {
		return DateOfCreation;
	}
	public void setDateOfCreation(LocalDate dateOfCreation) {
		DateOfCreation = dateOfCreation;
	}
	public Property getProperty() {
		return property;
	}
	public void setAkinhto(Property property) {
		this.property = property;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	public double getPosostoIdioktisias() {
		return posostoIdioktisias;
	}
	public void setPosostoIdioktisias(double posostoIdioktisias) {
		this.posostoIdioktisias = posostoIdioktisias;
	}
	public TyposKyriothtas getType() {
		return type;
	}
	public void setType(TyposKyriothtas type) {
		this.type = type;
	}
	public void print() {
		System.out.println("Title: "+this.toString());
	}
	public String toString() {
		return "Code : "+code+" Date of creation : "+DateOfCreation+" Code of property : "+property.getCode()+" Owner's AFM : "+owner.getAfm()+" Percentage of possesion : "+posostoIdioktisias+"%"+" Type of possesion : "+type+" ENFIA of title: "+property.getEnfiaAkinhtou()*posostoIdioktisias/100;
	}
	
}
