package tuc.ece.cs102.RealEstate;

import tuc.ece.cs102.RealEstate.titles.PropertyTitle;
import tuc.ece.cs102.list.Item;

public class TitleItem extends Item {
	private PropertyTitle propertyTitle;
	
	/********************constructors**********************/

	public TitleItem(PropertyTitle itTitle) {
		this.propertyTitle = itTitle;
	}
	
/********************methods**********************/

	public boolean equals(Item k) {
		return key().equals(k.key());
	}
	
	public boolean less(Item k) {
		if (((Integer) key()).compareTo((Integer) k.key()) < 0)
			return true;
		return false;
	}
	
	public Object key() {
		return propertyTitle.getCode();
	}
	
	
	public void print() {
		propertyTitle.print();
	}
	
	
	public Object getData() {
		return this.propertyTitle;
	}
	public String toString() {
		return propertyTitle.toString();
	
	}



}
