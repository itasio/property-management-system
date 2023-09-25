package tuc.ece.cs102.RealEstate.owners;

import tuc.ece.cs102.RealEstate.EnhancedSortedList;
import tuc.ece.cs102.RealEstate.TitleItem;

public abstract class Owner {
	private long afm;
	private String name;
	private EnhancedSortedList titlesOfOwner;
	
/********************constructors**********************/
	public Owner(long afm, String name) {
		this.afm = afm;
		this.name = name;
		titlesOfOwner = new EnhancedSortedList();
	}
	
	
/********************methods**********************/
	public long getAfm() {
		return afm;
	}
	public void setAfm(long afm) {
		this.afm = afm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public abstract void print();
	
	public abstract String toString();


	public EnhancedSortedList getTitlesOfOwner() {
		return titlesOfOwner;
	}

	public void addTitlesOfOwner(TitleItem title) {
		this.titlesOfOwner.insert(title);
	}
}
