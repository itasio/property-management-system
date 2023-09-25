package tuc.ece.cs102.RealEstate;

import java.time.LocalDate;
import java.util.Scanner;

import tuc.ece.cs102.RealEstate.owners.Owner;
import tuc.ece.cs102.RealEstate.properties.Ktisma.XrhshKatoikias;
import tuc.ece.cs102.RealEstate.properties.Oikopedo.TyposOikopedou;
import tuc.ece.cs102.RealEstate.properties.Property;
import tuc.ece.cs102.RealEstate.titles.PropertyTitle.TyposKyriothtas;
import tuc.ece.cs102.util.StandardInputRead;

public class Main_console {
	private RealEstate estateSystem;
	
	public RealEstate getRealEstate() {
		return estateSystem;
	}
	
	public void setRealEstate(RealEstate estateSystem) {
		this.estateSystem = estateSystem;
	}
	
	private StandardInputRead reader;
	private int userOption;
	
	public Main_console() {
		estateSystem = new RealEstate();
		reader = new StandardInputRead();
		userOption=0;
	}
	
	public static void main(String[] args) {
		Main_console console = new Main_console();
		int userOption = 0;
		StandardInputRead reader = new StandardInputRead();
		while (userOption != 5) {
			console.printMenu();
	         String userInput = reader.readString("What would you like to do? ");
	         if (userInput == null) {
	                continue;
	            } else {
	                try {
	                    userOption = Integer.parseInt(userInput);
	                } catch (NumberFormatException ex) {
	                    userOption = 0;
	                }
	            }	            
	            switch (userOption) {
	            	case 0:
	            		continue;
	            	case 1:// Search
	            		console.makeNewSearch();
	                    reader.readString("Press any key to continue...");
	                    break;
	            	case 2:// Insert new item
	            		console.makeNewRegistration();
	            		reader.readString("Press any key to continue...");
	                    break;
	            	case 3:// enfia
	            		console.computeEnfia();
	            		reader.readString("Press any key to continue...");
	                    break;
	            	case 4:// fortune
	            		console.computeFortune();
	            		reader.readString("Press any key to continue...");
	                    break;
	            	case 5:// Exit
	                	System.out.println("Thanks for using Global Real Estate System.");
	                    break;
	                default:	                    
	                    System.out.println("User option " + userOption + " ignored...");
	                    continue;
	            }
		}
	}

	public void printMenu(){		
		System.out.println("----------------------Menu------------------------");
		System.out.println("--------------------------------------------------");		
		System.out.println("1)Make new search---------------------------------");
		System.out.println("2)Insert Estate / Owner / Title------------------ ");
		System.out.println("3)Compute owner's ENFIA---------------------------");
		System.out.println("4)Compute owner's fortune-------------------------");
		System.out.println("5)Exit--------------------------------------------");
	}
	
	public void computeEnfia() {
		Scanner input = new Scanner(System.in);  
        System.out.print("Enter the owner's AFM:");  
        long afm = input.nextLong();
        estateSystem.printEnfiaOwner(afm);
	}
	
	public void computeFortune() {
		Scanner input = new Scanner(System.in);  
        System.out.print("Enter the owner's AFM:"); 
        long afm = input.nextLong();
        estateSystem.printFortuneOwner(afm);
	}
	
	public void makeNewRegistration() {
		userOption = 0;
		while(userOption > 4 || userOption < 1) {
			System.out.println("What do you want to insert ?");
			System.out.println("1) Insert new owner---------------------------");
			System.out.println("2) Insert new estate--------------------------");
			System.out.println("3) Insert new title---------------------------");
			System.out.println("4) Cancel / Return to main menu---------------");
			userOption= reader.readPositiveInt(":");
			switch (userOption){		
			case 1:
				addOwner();
				break;
			case 2:
				addEstate();
				break;
			case 3:
				System.out.println("Important info:");
				System.out.println("You can create new title only for registered estate and owner.");
				System.out.println("If you want to continue with title creation type: 'Yes'");
				System.out.println("If you do not want to proceed with title creation type: 'No'");
				String Yes = "Yes";
				String No = "No";
				Scanner in = new Scanner(System.in);
				String opt = in.next();
				if(opt.equalsIgnoreCase(Yes)) {
					System.out.println("Insert owner's AFM:");
					long afm = in.nextLong();
					Owner owner = estateSystem.searchForOwner(afm);
					if(owner != null) {
						System.out.println("Insert estate's code:");
						long estateCode = in.nextLong();
						Property property = estateSystem.searchForProperty(estateCode);
						if(property != null) {
							System.out.println("Insert percentage of possesion:");
							double percentage = in.nextDouble();
							String typos = (reader.readString("Insert type of possesion in capital letters(PLHRHS / PSILH / EPIKARPIA):")).toUpperCase();
							TyposKyriothtas type = TyposKyriothtas.valueOf(typos);
							estateSystem.insertPropertyTitle(owner, property, percentage, type);
							System.out.println("Title has been added.");
						}else {
							System.out.println("This code does not match to any estate.");
							continue;
						}						
					}else {
						System.out.println("This AFM does not match to any owner.");
						continue;
					}				
				}else if(opt.equalsIgnoreCase(No)) {
					continue;
				}else {
					System.out.println("Choice" + opt + " ignored.");
					System.out.println("Only 'Yes' or 'No' accepted. ");
					continue;
				}	
			case 4:
				break;
		}
	}
}
	
	public void addOwner() {
		Scanner in = new Scanner(System.in);
		userOption=0;
		while(userOption>3 || userOption<1){
			System.out.println("What kind of owner you want to insert ?");
			System.out.println("1) Fysiko proswpo");
			System.out.println("2) Epixirhsh");
			System.out.println("3) Cancel");
			userOption= reader.readPositiveInt(":");
		}
		long afm;
		String name, adress;
		switch (userOption){		
		case 1 :
			name =  reader.readString("Owner's name:");
			System.out.println("Owner's AFM:");
			afm = in.nextLong();
			adress = reader.readString("Home adress:");
			String birth = reader.readString("Enter owner's date of birth in the form: yyyy-mm-dd");
			LocalDate dateOfBirth = LocalDate.parse(birth);
			estateSystem.insertOwner(afm, name, adress, dateOfBirth);
			System.out.println("Owner added.");
			break;
		case 2:
			name =  reader.readString("Company's name:");
			System.out.println("Company's AFM:");
			afm = in.nextLong();
			adress = reader.readString("Headquarters adress:");
			String legalRepres = reader.readString("Enter the name of company's legal representative:");
			estateSystem.insertOwner(afm, name, adress, legalRepres);
			System.out.println("Owner added.");
			break;
		case 3:
			break;
		}
		
	}
	public void addEstate() {
		Scanner in = new Scanner(System.in);
		userOption=0;
		while(userOption>4 || userOption<1){
			System.out.println("What kind of estate you want to insert ?");
			System.out.println("1) Oikopedo");
			System.out.println("2) Monokatoikia");
			System.out.println("3) Diamerisma");
			System.out.println("4) Cancel");
			userOption= reader.readPositiveInt(":");
		}
		long code;
		String nomos, dhmos;
		double area, objValue, zonePrice;
		switch (userOption){
		case 1:
			System.out.println("Insert the code of oikopedo:");
			code = in.nextLong();
			nomos = reader.readString("Insert the nomos of oikopedo:");
			dhmos = reader.readString("Insert the dhmos of oikopedo:");
			System.out.println("Insert the area of oikopedo:");
			area = in.nextDouble();
			System.out.println("Insert the objective value of oikopedo:");
			objValue = in.nextDouble();
			System.out.println("Insert the zone price of oikopedo:");
			zonePrice = in.nextDouble();
			String typos = (reader.readString("Insert type of oikpedo in capital letters(OIKODOMISIMO / AGROTEMAXIO):")).toUpperCase();
			TyposOikopedou type = TyposOikopedou.valueOf(typos); 
			System.out.println("Insert the maximum build area of oikopedo:");
			double maxBuildArea = in.nextDouble();
			estateSystem.insertProperty(code, nomos, dhmos, area, objValue, zonePrice, type, maxBuildArea);
			System.out.println("Estate added.");
			break;
		case 2:
			System.out.println("Insert the code of monokatoikia:");
			code = in.nextLong();
			nomos = reader.readString("Insert the nomos of monokatoikia:");
			dhmos = reader.readString("Insert the dhmos of monokatoikia:");
			System.out.println("Insert the area of monokatoikia:");
			area = in.nextDouble();
			System.out.println("Insert the objective value of monokatoikia:");
			objValue = in.nextDouble();
			System.out.println("Insert the zone price of monokatoikia:");
			zonePrice = in.nextDouble();
			String mAdress = reader.readString("Insert the adress of monokatoikia:");
			int mConDate = reader.readPositiveInt("Insert year of construction:");
			String xrhsh = (reader.readString("Insert type of use of monokatoikia in capital letters(KATOIKIA / EPAGGELMATIKO):")).toUpperCase();
			XrhshKatoikias mXrhshKatoikias = XrhshKatoikias.valueOf(xrhsh); 
			int hFloor = reader.readPositiveInt("Insert the highest floor of monokatoikia:");
			System.out.println("Insert the pool area of monokatoikia(If there is no pool, type 0):");
			double poolArea = in.nextDouble();
			estateSystem.insertProperty(code, nomos, dhmos, area, objValue, zonePrice, mAdress, mConDate, mXrhshKatoikias, hFloor, poolArea);
			System.out.println("Estate added.");
			break;
		case 3:
			System.out.println("Insert the code of diamerisma:");
			code = in.nextLong();
			nomos = reader.readString("Insert the nomos of diamerisma:");
			dhmos = reader.readString("Insert the dhmos of diamerisma:");
			System.out.println("Insert the area of diamerisma:");
			area = in.nextDouble();
			System.out.println("Insert the objective value of diamerisma:");
			objValue = in.nextDouble();
			System.out.println("Insert the zone price of diamerisma:");
			zonePrice = in.nextDouble();
			String adress = reader.readString("Insert the adress of diamerisma:");
			int conDate = reader.readPositiveInt("Insert year of construction:");
			String dXrhsh = (reader.readString("Insert type of use of diamerisma in capital letters(KATOIKIA / EPAGGELMATIKO):")).toUpperCase();
			XrhshKatoikias dXrhshKatoikias = XrhshKatoikias.valueOf(dXrhsh); 
			int floor = reader.readPositiveInt("Insert the floor of diamerisma:");
			int rooms = reader.readPositiveInt("Insert the rooms of diamerisma:");
			estateSystem.insertProperty(code, nomos, dhmos, area, objValue, zonePrice, adress, conDate, dXrhshKatoikias, floor, rooms);
			System.out.println("Estate added.");
			break;
		case 4:
			break;
		}
	}
	
	public void makeNewSearch() {
		Scanner in = new Scanner(System.in);
		userOption = 0;
		while(userOption > 4 || userOption < 1) {
			System.out.println("What are you looking for ?");
			System.out.println("1) Search for Owner---------------------------");
			System.out.println("2) Search for Estate--------------------------");
			System.out.println("3) Search for Title---------------------------");
			System.out.println("4) Cancel / Return to main menu---------------");
			userOption= reader.readPositiveInt(":");
		}
			switch (userOption){	
				case 1:
					System.out.println("Insert the owner's AFM:");
					long afm = in.nextLong();
					Owner owner = estateSystem.searchForOwner(afm);
					if (owner != null) {
						owner.print();
						break;
					}else
						System.out.println("Owner not found");
						break;
				case 2:
					searchForAkinhto();
					break;
				case 3:
					searchForTitle();
					break;
				case 4:
					break;
			}
	}

	public void searchForAkinhto() {
		Scanner in = new Scanner(System.in);
		userOption = 0;
		while(userOption > 4 || userOption < 1) {
			System.out.println("------------- Estate Search-------------------");
			System.out.println("1) Search for Estate by code------------------");
			System.out.println("2) Search for Estate by category -------------");
			System.out.println("3) Print all registered estates---------------");
			System.out.println("4) Cancel / Return to main menu---------------");
			userOption= reader.readPositiveInt(":");
		}
		switch (userOption){
			case 1:
				System.out.println("Insert the code of estate:");
				long code = in.nextLong();
				Property property = estateSystem.searchForProperty(code);
				if (property != null) {
					property.print();
					break;
				}else {
					System.out.println("Estate not found.");
					break;
				}
			case 2:
				String category = "tuc.ece.cs102.RealEstate.properties."+reader.readString("What category of estates you want to see?(Diamerisma / Monokatoikia / Oikopedo / Ktisma)");
				estateSystem.printEstatesByCategory(category);
				break;
			case 3:
				estateSystem.printEstates();
				break;
			case 4:
				break;
		}
	}
	
	public void searchForTitle() {
		Scanner in = new Scanner(System.in);
		userOption = 0;
		while(userOption > 3 || userOption < 1) {
			System.out.println("-------------- Title Search-------------------");
			System.out.println("1) Search for Titles by Estate code-----------");
			System.out.println("2) Search for Titles by Owner's AFM ----------");
			System.out.println("3) Cancel / Return to main menu---------------");
			userOption= reader.readPositiveInt(":");
		}
		switch (userOption){
			case 1:
				System.out.println("Insert the code of estate:");
				long code = in.nextLong();
				estateSystem.printTitlesByEstate(code);
				break;
			case 2:
				System.out.println("Insert the owner's afm:");
				long afm = in.nextLong();
				estateSystem.printTitlesByOwner(afm);
				break;
			case 3:
				break;
		}
	}

}