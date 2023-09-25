package tuc.ece.cs102.RealEstate.properties;


public class Diamerisma extends Ktisma{
	private int floor;
	private int rooms;
	
/********************constructors**********************/
public Diamerisma(long code, String nomos, String dhmos, double area, double value, double zPrice, String adr, int conDate, XrhshKatoikias xrhsh, int floor, int rooms) {
	super(code, nomos, dhmos, area, value, zPrice, adr, conDate, xrhsh);
	this.floor = floor;
	this.rooms = rooms;
}

/********************methods**********************/

public int getFloor() {
	return floor;
}

public void setFloor(int floor) {
	this.floor = floor;
}

public int getRooms() {
	return rooms;
}

public void setRooms(int rooms) {
	this.rooms = rooms;
}


public void print() {
	System.out.println("Property : Flat "+this.toString());
	
}

public String toString() {
	return super.toString()+" Floor : "+floor+" Rooms : "+rooms;
}

public double getEnfiaAkinhtou() {
	double enfia = super.getEnfiaAkinhtou();
	enfia = enfia * (1 + floor * 0.05);
	return enfia;
}
}
