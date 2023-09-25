package tuc.ece.cs102.RealEstate.properties;

public class Oikopedo extends Property {
	public enum TyposOikopedou{
		OIKODOMISIMO,
		AGROTEMAXIO
	}
	
	private TyposOikopedou type;
	private double maxBuildArea;
	
	/********************constructors**********************/

	public Oikopedo(long code, String nomos, String dhmos, double area, double value, double zPrice, TyposOikopedou type, double buildArea) {
		super(code, nomos, dhmos, area, value, zPrice);
		this.type = type;
		this.maxBuildArea = buildArea;
	}

	/********************methods**********************/

	public TyposOikopedou getType() {
		return type;
	}

	public void setTyposOikopedou(TyposOikopedou type) {
		this.type = type;
	}

	public double getMaxBuildArea() {
		return maxBuildArea;
	}

	public void setMaxBuildArea(double maxBuildArea) {
		this.maxBuildArea = maxBuildArea;
	}

	public void print() {
		System.out.println("Property : Oikopedo "+this.toString());
	}

	public String toString() {
		return super.toString()+" Typos Oikopedou :"+type+" Max build area : "+maxBuildArea;
	}

	public double getEnfiaAkinhtou() {
		if(this.type.equals(TyposOikopedou.AGROTEMAXIO)) {
			return getZonePrice() * getArea();	
		}else {
			return getZonePrice() * getArea() + 0.15*getZonePrice()*maxBuildArea;
		}
	}
	
	
}
