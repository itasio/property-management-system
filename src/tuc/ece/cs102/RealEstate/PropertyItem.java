package tuc.ece.cs102.RealEstate;

import tuc.ece.cs102.list.Item;
import tuc.ece.cs102.RealEstate.properties.Property;

public class PropertyItem extends Item {
	private Property property;
	
/********************constructors**********************/

	public PropertyItem(Property itProperty) {
		this.property = itProperty;
	}

/********************methods**********************/

	public boolean equals(Item k) {
		return key().equals(k.key());
	}
	
	public boolean less(Item k) {
		if (((Long) key()).compareTo((Long) k.key()) < 0)
			return true;
		return false;
	}
	
	public Object key() {
		return property.getCode();
	}
	
	
	public void print() {
		property.print();
	}
	
	
	public Object getData() {
		return this.property;
	}
	public String toString() {
		return property.toString();
	
	}

	
}
