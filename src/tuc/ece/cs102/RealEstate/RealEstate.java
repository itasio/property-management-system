package tuc.ece.cs102.RealEstate;

import java.time.*;

import tuc.ece.cs102.RealEstate.owners.*;
import tuc.ece.cs102.RealEstate.titles.*;
import tuc.ece.cs102.RealEstate.titles.PropertyTitle.TyposKyriothtas;
import tuc.ece.cs102.list.*;
import tuc.ece.cs102.RealEstate.properties.*;
import tuc.ece.cs102.RealEstate.properties.Ktisma.XrhshKatoikias;
import tuc.ece.cs102.RealEstate.properties.Oikopedo.TyposOikopedou;


public class RealEstate {
	private String name;
	private String url;
	private EnhancedSortedList titles;
	private EnhancedSortedList owners;
	private EnhancedSortedList estates;

	
	public RealEstate() {
		this.name = "Global Real Estate System";
		this.url = "www.GRES.com";
		this.titles = new EnhancedSortedList();
		this.estates = new EnhancedSortedList();
		this.owners = new EnhancedSortedList();
		
		FysikoProswpo f1 = new FysikoProswpo(123456789,"NIKOLAOS ARAMPATZHS" , "PAPAFLESSA 2", LocalDate.of(1978, 5, 12));
		owners.insert(new OwnerItem(f1));
		FysikoProswpo f2 = new FysikoProswpo(987456321,"GEWRGIOS MIXAHL" , "MANOU 10", LocalDate.of(1985, 1, 15));
		owners.insert(new OwnerItem(f2));
		FysikoProswpo f3 = new FysikoProswpo(741258963,"IOKASTH MANOU" , "KTISTAKH 1", LocalDate.of(1970, 11, 13));
		owners.insert(new OwnerItem(f3));
		FysikoProswpo f4 = new FysikoProswpo(236716384,"ANNA KATRAKH" , "TSOXA 7", LocalDate.of(1990, 7, 28));
		owners.insert(new OwnerItem(f4));
		Epixeirhsh e1 =  new Epixeirhsh(341345657,"INFORMIX" ,"PAPANASTASIOU 10", "ELENH DHMOU");
		owners.insert(new OwnerItem(e1));
		Epixeirhsh e2 = new Epixeirhsh(423451241,"SUPERFOOD" ,"SOUTSOU 20", "MARIA PAPPA");
		owners.insert(new OwnerItem(e2));
		
		
		Oikopedo ak1 = new Oikopedo(1000020010, "ATTIKHS", "ATHINAIWN", 800, 180000, 0.5, TyposOikopedou.OIKODOMISIMO, 600);
		estates.insert(new PropertyItem(ak1));
		Oikopedo ak2 = new Oikopedo(1000020011, "XANIWN", "XANIWN", 700, 1100000, 0.5, TyposOikopedou.OIKODOMISIMO, 400);
		estates.insert(new PropertyItem(ak2));
		Oikopedo ak3 = new Oikopedo(1000020012, "XANIWN", "AKRWTHRIOU", 1100, 500000, 0.4, TyposOikopedou.AGROTEMAXIO, 0);
		estates.insert(new PropertyItem(ak3));
		Diamerisma d1 = new Diamerisma(1000030030, "RETHYMNOU", "RETHYMNOU", 90, 170000, 2, "KOUNTOYRIWTOY 3", 1977, XrhshKatoikias.KATOIKIA, 2, 4);
		estates.insert(new PropertyItem(d1));
		Diamerisma d2 = new Diamerisma(1000030031, "ATTIKHS", "ATHINAIWN", 105, 180000, 2.5, "PANORMOU 20", 2015, XrhshKatoikias.KATOIKIA, 4, 5);
		estates.insert(new PropertyItem(d2));
		Diamerisma d3 = new Diamerisma(1000030032, "HRAKLEIOY", "HRAKLEIOY", 150, 250000, 1.5, "KNWSSOY 12", 1990, XrhshKatoikias.EPAGGELMATIKO, 0, 6);
		estates.insert(new PropertyItem(d3));
		Monokatoikia m1 = new Monokatoikia(1000040040, "LASITHIOY", "SHTEIAS", 80, 100000, 1.7, "4HS SEPTEMBRIOY 2", 1991, XrhshKatoikias.KATOIKIA, 1, 0);
		estates.insert(new PropertyItem(m1));
		Monokatoikia m2 = new Monokatoikia(1000040041, "XANIWN", "XANIWN", 600, 500000, 1.5, "PROFHTH HLIA 13", 2017, XrhshKatoikias.KATOIKIA, 2, 100);
		estates.insert(new PropertyItem(m2));
		Monokatoikia m3 = new Monokatoikia(1000040042, "ATTIKHS", "XALANDRIOU", 200, 300000, 1, "AGIOU GEWRGIOY 15", 1980, XrhshKatoikias.EPAGGELMATIKO, 1, 0);
		estates.insert(new PropertyItem(m3));

		
		TitleItem t1 = new TitleItem(new PropertyTitle(100, LocalDate.of(2000, 5, 12), ak1, f1, 50, TyposKyriothtas.PLHRHS));
		titles.insert(t1);
		f1.addTitlesOfOwner(t1);
		ak1.addTitlesOfProperty(t1);
		
		TitleItem t2 = new TitleItem(new PropertyTitle(101, LocalDate.of(2000, 5, 12), ak1, f2, 50, TyposKyriothtas.PLHRHS ));
		titles.insert(t2);
		f2.addTitlesOfOwner(t2);
		ak1.addTitlesOfProperty(t2);
		
		TitleItem t3 = new TitleItem(new PropertyTitle(102, LocalDate.of(2001, 6, 1), ak2, f1, 100, TyposKyriothtas.PLHRHS ));
		titles.insert(t3);
		f1.addTitlesOfOwner(t3);
		ak2.addTitlesOfProperty(t3);
		
		TitleItem t4 = new TitleItem(new PropertyTitle(103, LocalDate.of(2003, 9, 20), ak3, f3, 100, TyposKyriothtas.PLHRHS ));
		titles.insert(t4);
		f3.addTitlesOfOwner(t4);
		ak3.addTitlesOfProperty(t4);
		
		TitleItem t5 = new TitleItem(new PropertyTitle(104, LocalDate.of(2010, 11, 24), d1, f4, 100, TyposKyriothtas.PLHRHS ));
		titles.insert(t5);
		f4.addTitlesOfOwner(t5);
		d1.addTitlesOfProperty(t5);
		
		TitleItem t6 = new TitleItem(new PropertyTitle(105, LocalDate.of(2013, 8, 26), d2, f4, 100, TyposKyriothtas.PSILH ));
		titles.insert(t6);
		f4.addTitlesOfOwner(t6);
		d2.addTitlesOfProperty(t6);
		
		TitleItem t7 = new TitleItem(new PropertyTitle(106, LocalDate.of(2017, 4, 2), d3, e2, 100, TyposKyriothtas.PLHRHS ));
		titles.insert(t7);
		e2.addTitlesOfOwner(t7);
		d3.addTitlesOfProperty(t7);
		
		TitleItem t8 = new TitleItem(new PropertyTitle(107, LocalDate.of(2016, 7, 3), m1, f3, 100, TyposKyriothtas.PLHRHS ));
		titles.insert(t8);
		f3.addTitlesOfOwner(t8);
		m1.addTitlesOfProperty(t8);
		
		TitleItem t9 = new TitleItem(new PropertyTitle(108, LocalDate.of(2005, 3, 13), m2, f3, 100, TyposKyriothtas.EPIKARPIA ));
		titles.insert(t9);
		f3.addTitlesOfOwner(t9);
		m2.addTitlesOfProperty(t9);
		
		TitleItem t10 = new TitleItem(new PropertyTitle(109, LocalDate.of(2016, 7, 3), m3, e1, 100, TyposKyriothtas.PLHRHS ));
		titles.insert(t10);
		e1.addTitlesOfOwner(t10);
		m3.addTitlesOfProperty(t10);
		
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void printEstates() {
		estates.print();
	}
	
	public void printEstatesByCategory(String Classname) {
		estates.printItemsInHierarchy(Classname);
	}
	
	public void printTitlesByOwner(long afm) {
		Owner owner = searchForOwner(afm);
			if(owner != null) {
				owner.getTitlesOfOwner().print();
			}
			else
				System.out.println("This AFM does not match to any owner.");
	}
	
	public void printTitlesByEstate(long code) {
		Property property = searchForProperty(code);
		if(property !=null) {
			property.getTitlesOfProperty().print();
		}else
			System.out.println("This code does not match to any AFM.");
	}
	
	public Owner searchForOwner(long afm) {
		OwnerItem oItem =(OwnerItem)owners.search(afm);
		if (oItem !=null){		
			return (Owner)oItem.getData();
		}else{
			return null;
		}
	}
	
	public Property searchForProperty(long code) {
		PropertyItem pItem = (PropertyItem)estates.search(code);
		if (pItem!=null){		
			return (Property)pItem.getData();
		}else{
			return null;
		}
	}

	public void insertPropertyTitle(Owner owner, Property property, double pososto, TyposKyriothtas type) {
		LocalDate creationDate = LocalDate.now();
		int code = titles.getLength()+1;
		TitleItem tItem = new TitleItem(new PropertyTitle(code, creationDate, property, owner, pososto, type));
		titles.insert(tItem);
		owner.addTitlesOfOwner(tItem);
		property.addTitlesOfProperty(tItem);
	}
	
	public void insertOwner(long afm, String  name, String adress, LocalDate dateOfBirth) {
		OwnerItem oItem = new OwnerItem(new FysikoProswpo(afm, name, adress, dateOfBirth));
		owners.insert(oItem);
	}
	
	public void insertOwner(long afm, String  name, String headquarters, String legalRepres) {
		OwnerItem oItem = new OwnerItem(new Epixeirhsh(afm, name, headquarters, legalRepres));
		owners.insert(oItem);
	}
	
	public void insertProperty(long code, String nomos, String dhmos, double area, double value, double zPrice, TyposOikopedou type, double buildArea) {
		PropertyItem pItem = new PropertyItem(new Oikopedo(code, nomos, dhmos, area, value, zPrice, type, buildArea));
		estates.insert(pItem);
	}
	
	public void insertProperty(long code, String nomos, String dhmos, double area, double value, double zPrice, String adr, int conDate, XrhshKatoikias xrhsh, int floor, int rooms) {
		PropertyItem pItem = new PropertyItem(new Diamerisma(code, nomos, dhmos, area, value, zPrice, adr, conDate, xrhsh, floor, rooms));
		estates.insert(pItem);
	}
	
	public void insertProperty(long code, String nomos, String dhmos, double area, double value, double zPrice, String adr, int conDate, XrhshKatoikias xrhsh, int hFloor, double pArea) {
		PropertyItem pItem = new PropertyItem(new Monokatoikia(code, nomos, dhmos, area, value, zPrice, adr, conDate, xrhsh, hFloor, pArea));
		estates.insert(pItem);
	}
	
	public void printFortuneOwner(long afm) {
		Owner owner = searchForOwner(afm);
		if(owner != null) {
			EnhancedSortedList l = owner.getTitlesOfOwner();
			double fortune = getFortuneOfListTitle(l);
			System.out.println("The owner "+owner.getName()+" has fortune worth of "+fortune+" euros.");
		}else
			System.out.println("This AFM does not exist.");
	}
	
	public void printEnfiaOwner(long afm) {
		Owner owner = searchForOwner(afm);
		if(owner != null) {
			EnhancedSortedList l = owner.getTitlesOfOwner();
			double enfia = getEnfiaOfListTitle(l);
			System.out.println("The owner "+owner.getName()+" pays ENFIA worth of "+enfia+" euros.");
		}else
			System.out.println("This AFM does not exist.");
	}
	
	public double getEnfiaOfListTitle(EnhancedSortedList l) {
		Node tmp = l.getHead();
		double enfia = 0;
		try {
			while (tmp != null) {
				Item item = tmp.getValue();				
				if(Class.forName("tuc.ece.cs102.RealEstate.titles.PropertyTitle").isInstance(item.getData())) {
					enfia += ((PropertyTitle)item.getData()).getProperty().getEnfiaAkinhtou() * ((PropertyTitle)item.getData()).getPosostoIdioktisias()/100; //enfia of each title depends on the percentage of possesion 
				}
				tmp = tmp.getNext();
			}
			return enfia;
		}catch(ClassNotFoundException ex) {
			System.out.println("This kind of title does not exist.");
			return 0;
		}
	}
	
	public double getFortuneOfListTitle(EnhancedSortedList l) {
		Node tmp = l.getHead();
		double fortune = 0;
		try {
			while (tmp != null) {
				Item item = tmp.getValue();				
				if(Class.forName("tuc.ece.cs102.RealEstate.titles.PropertyTitle").isInstance(item.getData())) {
					fortune += ((PropertyTitle)item.getData()).getProperty().getObjValue() * ((PropertyTitle)item.getData()).getPosostoIdioktisias()/100; //value from each title depends on the percentage of possesion 
				}
				tmp = tmp.getNext();
			}
			return fortune;
		}catch(ClassNotFoundException ex) {
			System.out.println("This kind of title does not exist.");
			return 0;
		}
	}
	
}
