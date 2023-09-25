package tuc.ece.cs102.RealEstate.properties;


public class Monokatoikia extends Ktisma {
	private int highestFloor;
	private double poolArea;
	
/********************constructors**********************/
	public Monokatoikia(long code, String nomos, String dhmos, double area, double value, double zPrice, String adr, int conDate, XrhshKatoikias xrhsh, int hFloor, double pArea) {
		super(code, nomos, dhmos, area, value, zPrice, adr, conDate, xrhsh);
		this.highestFloor = hFloor;
		this.poolArea = pArea;
	}

/********************methods**********************/

	public int getHighestFloor() {
		return highestFloor;
	}
	
	public void setHighestFloor(int highestFloor) {
		this.highestFloor = highestFloor;
	}
	
	public double getPoolArea() {
		return poolArea;
	}
	
	public void setPoolArea(double poolArea) {
		this.poolArea = poolArea;
	}
	
	public void print() {
		System.out.println("Property : House "+this.toString());
		
	}
	
	public String toString() {
		return super.toString()+" Highest floor : "+highestFloor+" Pool area : "+poolArea;
	}
	
	public double getEnfiaAkinhtou() {
		double enfia = super.getEnfiaAkinhtou();
		enfia = enfia + poolArea * 10;
		return enfia;
	}
	
}
