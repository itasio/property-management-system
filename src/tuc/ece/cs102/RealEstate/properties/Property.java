package tuc.ece.cs102.RealEstate.properties;

import java.util.Arrays;

import tuc.ece.cs102.RealEstate.EnhancedSortedList;
import tuc.ece.cs102.RealEstate.TitleItem;
import tuc.ece.cs102.RealEstate.titles.PropertyTitle;
import tuc.ece.cs102.list.Item;
import tuc.ece.cs102.list.Node;

public abstract class Property {
	private long code;
	private String nomos;
	private String dhmos;
	private double area;
	private double objValue;
	private double zonePrice;
	private EnhancedSortedList titlesOfProperty;

	
/********************constructors**********************/
	public Property(long code, String nomos, String dhmos, double area, double value, double zPrice) {
		this.code = code;
		this.nomos = nomos;
		this.dhmos = dhmos;
		this.area = area;
		this.objValue = value;
		this.zonePrice = zPrice;
		titlesOfProperty = new EnhancedSortedList();
	}
/********************methods**********************/

	public long getCode() {
		return code;
	}
	
	public void setCode(long code) {
		this.code = code;
	}
	public String getNomos() {
		return nomos;
	}
	public void setNomos(String nomos) {
		this.nomos = nomos;
	}
	public String getDhmos() {
		return dhmos;
	}
	public void setDhmos(String dhmos) {
		this.dhmos = dhmos;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public double getObjValue() {
		return objValue;
	}
	public void setObjValue(double objValue) {
		this.objValue = objValue;
	}
	public double getZonePrice() {
		return zonePrice;
	}
	public void setZonePrice(double zonePrice) {
		this.zonePrice = zonePrice;
	}
	
	public abstract void print();
	
	public String toString() {
		return "Code : "+this.getCode()+" Nomos : "+this.getNomos()+" Dhmos : "+this.getDhmos()+" Area : "+this.getArea()+" Value : "+this.getObjValue()+" Zone price : "+this.getZonePrice()+" ENFIA: "+getEnfiaAkinhtou()+" Owners of property: "+getOwnerOfProperty();
	}
	
	public EnhancedSortedList getTitlesOfProperty() {
		return titlesOfProperty;
	}
	
	public void addTitlesOfProperty(TitleItem title) {
		this.titlesOfProperty.insert(title);
	}
	
	public abstract double getEnfiaAkinhtou();
	
	public String getOwnerOfProperty() {
		int i = 0;
		Node tmp = titlesOfProperty.getHead();
		String[] ownerNames = new String[titlesOfProperty.getLength()];
		try {
			while (tmp != null) {
				Item item = tmp.getValue();		
				if(Class.forName("tuc.ece.cs102.RealEstate.titles.PropertyTitle").isInstance(item.getData())) {
					ownerNames[i] = ((PropertyTitle)item.getData()).getOwner().getName();
					i += 1 ;
				}
				tmp = tmp.getNext();
			}
			return Arrays.toString(ownerNames);
		}catch(ClassNotFoundException ex) {
			System.out.println("This kind of title does not exist.");
			return "";
		}
	}
}
