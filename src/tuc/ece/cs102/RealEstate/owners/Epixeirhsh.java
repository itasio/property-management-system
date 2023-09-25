package tuc.ece.cs102.RealEstate.owners;

public class Epixeirhsh extends Owner {
	private String headquarters;
	private String legalRepres;
	
/********************constructors**********************/
public Epixeirhsh(long afm, String name, String headquarters, String repres) {
	super(afm, name);
	this.headquarters = headquarters;
	this.legalRepres = repres;
}

/********************methods**********************/
public String getHeadquarters() {
	return headquarters;
}

public void setHeadquarters(String headquarters) {
	this.headquarters = headquarters;
}

public String getLegalRepres() {
	return legalRepres;
}

public void setLegalRepres(String legalRepres) {
	this.legalRepres = legalRepres;
}

public void print() {
	System.out.println("Owner : Company "+this.toString());

}

@Override
public String toString() {
	return "AFM: "+this.getAfm()+" Name: "+this.getName()+ " Headquarters : "+this.getHeadquarters()+" Legal representative : "+this.getLegalRepres(); 

}


	
	
}
