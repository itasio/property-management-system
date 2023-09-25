package tuc.ece.cs102.RealEstate;

import tuc.ece.cs102.RealEstate.owners.Owner;
import tuc.ece.cs102.list.Item;

public class OwnerItem extends Item {
	private Owner owner;

/********************constructors**********************/
	public OwnerItem (Owner itOwner) {
		this.owner = itOwner;
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
		return owner.getAfm();
	}
	
	
	public void print() {
		owner.print();
	}
	
	
	public Object getData() {
		return this.owner;
	}
	public String toString() {
		return owner.toString();
	
	}

}
