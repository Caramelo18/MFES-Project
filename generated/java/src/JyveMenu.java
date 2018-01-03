import java.util.Iterator;
import java.util.Scanner;

import org.overture.codegen.runtime.SeqUtil;
import org.overture.codegen.runtime.VDMSeq;
import org.overture.codegen.runtime.VDMSet;

import quotes.*;

public class JyveMenu {
	static AdvertisingBoard ab;
	static Scanner reader = new Scanner(System.in);
	public static void main(String [] args) {
		ab = new AdvertisingBoard();
		mainMenu();
	}

	private static void mainMenu() {
		 
		System.out.println("Jyve\n");
		System.out.println(" 1. Advertising Board Menu");
		System.out.println(" 2. Place Menu");
		System.out.println(" 0. Exit\n");
		
		System.out.println("Option: ");
		String op = reader.nextLine();
		 
		
		switch (op) {
		case "1":
			advertisingBoard();
			break;
		case "2":
			placeMenu();
			break;
		case "0":
			return;
		default:
			mainMenu();
			break;
		}
	}

	private static void placeMenu() {
		 
		System.out.println("Place Menu\n");
		System.out.println(" 1. Studios");
		System.out.println(" 2. Venues");
		System.out.println(" 0. Back\n");
		
		 
		System.out.println("Option: ");
		String op = reader.nextLine();
		 
		
		switch (op) {
		case "1":
			studiosMenu();
			break;
		case "2":
			venuesMenu();
			break;
		case "0":
			mainMenu();
			break;
		default:
			placeMenu();
			break;
		}
	}

	private static void venuesMenu() {
		 
		System.out.println("Venues Menu\n");
		System.out.println(" 1. Create Venue");
		System.out.println(" 2. Edit Venue");
		System.out.println(" 0. Back\n");
		
		 
		System.out.println("Option: ");
		String op = reader.nextLine();
		 
		
		switch (op) {
		case "1":
			createVenue();
			break;
		case "2":
			//editVenue();
			break;
		case "0":
			placeMenu();
			break;
		default:
			venuesMenu();
			break;
		}
	}

	private static void createVenue() {
		String name, loc, lig, s;
		int sa, cap;
		PlaceOwner po;
		System.out.println("Create Venue\n");
		System.out.println("Owner's Name: ");
		name = reader.nextLine();
		po = new PlaceOwner(name);
		
		System.out.println("Venue's Location: ");
		loc = reader.nextLine();
		
		System.out.println("Venue's Stage Area(m2): ");
		if(!reader.hasNextInt()) {
			createVenue();
			return;
		}	
		sa = reader.nextInt();
		
		System.out.println("Venue's Capacity: ");
		if(!reader.hasNextInt()) {
			createVenue();
			return;
		}
		cap = reader.nextInt();
		
		System.out.println("Venue's Lighting(Brief Descripton): ");
		lig = reader.nextLine();
		
		System.out.println("Venue's Sound(Brief Descripton): ");
		s = reader.nextLine();
		
		Venue v = new Venue(po, loc, sa, cap, lig, s);
		
		System.out.println("Venue " + v.toString() + " created with success");
		
		venuesMenu();
	}

	private static void studiosMenu() {
		 
		System.out.println("Studios Menu\n");
		System.out.println(" 1. Create Studio");
		System.out.println(" 2. Edit Studio");
		System.out.println(" 0. Back\n");
		
		 
		System.out.println("Option: ");
		String op = reader.nextLine();
		 
		
		switch (op) {
		case "1":
			createStudio();
			break;
		case "2":
			//editStudio();
			break;
		case "0":
			placeMenu();
			break;
		default:
			studiosMenu();
			break;
		}
	}

	private static void createStudio() {
		String name, loc;
		int sa;
		PlaceOwner po;
		boolean rehearsal, recording;
		
		System.out.println("Create Studio\n");
		System.out.println("Owner's Name: ");
		name = reader.nextLine();
		po = new PlaceOwner(name);
		
		System.out.println("Studio's Location: ");
		loc = reader.nextLine();
		
		System.out.println("Studio's Stage Area(m2): ");
		if(!reader.hasNextInt()) {
			createVenue();
			return;
		}	
		sa = reader.nextInt();
	
		System.out.println("Rehearsal: ");
		System.out.println(" 1. Yes");
		System.out.println(" 2. No\n");
		
		System.out.println("Option: ");
		String op = reader.nextLine();
		
		switch(op) {
		case "1":
			rehearsal = true;
			break;
		case "2":
			rehearsal = false;
			break;
		default:
			rehearsal = false;
			break;
		}
		
		System.out.println("Recording: ");
		System.out.println(" 1. Yes");
		System.out.println(" 2. No\n");
		
		System.out.println("Option: ");
		op = reader.nextLine();
		
		switch(op) {
		case "1":
			recording = true;
			break;
		case "2":
			recording = false;
			break;
		default:
			recording = false;
			break;
		}
		
		Studio s = new Studio(po, loc, sa, rehearsal, recording);
		System.out.println("Studio " + s.toString() + " created with success");
	}

//	private static void profileMenu() {
//		 
//		System.out.println("Profile Menu\n");
//		System.out.println(" 1. Artists");
//		System.out.println(" 2. Bands");
//		System.out.println(" 3. Roadies");
//		System.out.println(" 4. Place Owners");
//		System.out.println(" 0. Back\n");
//		
//		 
//		System.out.println("Option: ");
//		String op = reader.nextLine();
//		 
//		
//		switch (op) {
//		case "1":
//			artistsMenu();
//			break;
//		case "2":
//			bandsMenu();
//			break;
//		case "3":
//			roadiesMenu();
//			break;
//		case "4":
//			placeOwnersMenu();
//			break;
//		case "0":
//			mainMenu();
//			break;
//		default:
//			profileMenu();
//			break;
//		}
//	}
//
//	private static void placeOwnersMenu() {
//		 
//		System.out.println("Place Owners Menu\n");
//		System.out.println(" 1. Create Place Owner");
//		System.out.println(" 0. Back\n");
//		
//		 
//		System.out.println("Option: ");
//		String op = reader.nextLine();
//		 
//		
//		switch (op) {
//		case "1":
//			//createPlaceOwner();
//			break;
//		case "0":
//			profileMenu();
//			break;
//		default:
//			placeOwnersMenu();
//			break;
//		}		
//	}
//
//	private static void roadiesMenu() {
//		 
//		System.out.println("Roadies Menu\n");
//		System.out.println(" 1. Create Roadie");
//		System.out.println(" 2. Edit Roadie");
//		System.out.println(" 0. Back\n");
//		
//		 
//		System.out.println("Option: ");
//		String op = reader.nextLine();
//		 
//		
//		switch (op) {
//		case "1":
//			//createRoadie();
//			break;
//		case "2":
//			//editRoadie();
//			break;
//		case "0":
//			profileMenu();
//			break;
//		default:
//			roadiesMenu();
//			break;
//		}	
//	}
//
//	private static void bandsMenu() {
//		 
//		System.out.println("Bands Menu\n");
//		System.out.println(" 1. Create Band");
//		System.out.println(" 2. Edit Band");
//		System.out.println(" 0. Back\n");
//		
//		 
//		System.out.println("Option: ");
//		String op = reader.nextLine();
//		 
//		
//		switch (op) {
//		case "1":
//			//createBand();
//			break;
//		case "2":
//			//editBand();
//			break;
//		case "0":
//			profileMenu();
//			break;
//		default:
//			bandsMenu();
//			break;
//		}	
//	}
//
//	private static void artistsMenu() {
//		 
//		System.out.println("Artists Menu\n");
//		System.out.println(" 1. Create Artist");
//		System.out.println(" 2. Edit Artist");
//		System.out.println(" 0. Back\n");
//		
//		 
//		System.out.println("Option: ");
//		String op = reader.nextLine();
//		 
//		
//		switch (op) {
//		case "1":
//			//createArtist();
//			break;
//		case "2":
//			//editRoadie();
//			break;
//		case "0":
//			profileMenu();
//			break;
//		default:
//			artistsMenu();
//			break;
//		}	
//	}

	private static void advertisingBoard() {
		 
		System.out.println("Advertising Board\n");
		System.out.println(" 1. Artist Offers");
		System.out.println(" 2. Band Role Offers");
		System.out.println(" 3. Roadie Offers");
		System.out.println(" 4. Place Offers");
		System.out.println(" 5. Available Venues");
		System.out.println(" 6. Hire Band Offers");
		System.out.println(" 7. Gigs");
		System.out.println(" 0. Back\n");
		

		 
		System.out.println("Option: ");
		String op = reader.nextLine();
		 
		
		switch (op) {
		case "1":
			artistOffersMenu();
			break;
		case "2":
			BandRoleOffersMenu();
			break;
		case "3":
			RoadieOffersMenu();
			break;
		case "4":
			PlaceOffersMenu();
			break;
		case "5":
			AvailableVenuesMenu();
			break;
		case "6":
			HireBandOffersMenu();
			break;
		case "7":
			GigsMenu();
			break;
		case "0":
			mainMenu();
			break;
		default:
			advertisingBoard();
			break;
		}
	}

	private static void GigsMenu() {
		 
		System.out.println("Gigs Menu\n");
		System.out.println(" 1. List all");
		System.out.println(" 2. List by Venue");
		System.out.println(" 3. List by Date");
		System.out.println(" 0. Back\n");
		
		 
		System.out.println("Option: ");
		String op = reader.nextLine();
		 
		
		switch (op) {
		case "1":
			listAllGigs();
			break;
		case "2":
			listGigsByVenue();
			break;
		case "3":
			listGigsByDate();
			break;
		case "0":
			advertisingBoard();
			break;
		default:
			GigsMenu();
			break;
		}
	}

	private static void listGigsByVenue() {
		System.out.println("Gigs by Venue: \n");
		listAllVenues();
		
		System.out.println("\nChoose a Venue: ");
		if(!reader.hasNextInt()) {
			listGigsByVenue();
			return;
		}
		int op = reader.nextInt() - 1;
		Venue v = (Venue) AdvertisingBoard.listVenues().get(op);
		
		listGigWithVenue(v);
	}

	private static void listGigWithVenue(Venue v) {
		System.out.println("Gigs from Venue " + v + "\n");
		VDMSet gigs = ab.listGigs(v);
		Iterator iterator = gigs.iterator();
		
		int i = 1;
		while(iterator.hasNext()){
			Gig ao = (Gig) iterator.next();
			System.out.println(" " + i + ": " + ao.toString());
			i++;
		}
	}

	private static void listAllVenues() {
		System.out.println("Venues");
		VDMSeq venues = AdvertisingBoard.listVenues();
		Iterator iterator = SeqUtil.elems(venues).iterator();
		
		int i = 1;
		while(iterator.hasNext()){
			Venue ao = (Venue) iterator.next();
			System.out.println(" " + i + ": " + ao.toString());
			i++;
		}
	}

	private static void listAllGigs() {
		VDMSet offers = ab.listGigs();
		Iterator iterator = offers.iterator();
		
		printGig(iterator);
	}
	
	private static void listGigsByDate() {
		System.out.println("Gigs by date: \n");
		JyveUtils.Date date = null;
		
		while(date.equals(null))
			date = createDate();
		
		VDMSet offers = ab.listGigs(date);
		Iterator iterator = offers.iterator();
		
		printGig(iterator);
	}
	
	private static void printGig(Iterator iterator) {
		System.out.println("Gigs\n");
		int i = 1;
		while(iterator.hasNext()){
			Gig ao = (Gig) iterator.next();
			System.out.println(" " + i + ": " + ao.toString());
			i++;
		}
	}

	private static void HireBandOffersMenu() {
		 
		System.out.println("Hire Band Menu\n");
		System.out.println(" 1. Create an offer");
		System.out.println(" 2. List all");
		System.out.println(" 0. Back\n");
		
		 
		System.out.println("Option: ");
		String op = reader.nextLine();
		 
		
		switch (op) {
		case "1":
			createHireBandOffer();
			break;
		case "2":
			listHireBandOffer();
			break;
		case "0":
			advertisingBoard();
			break;
		default:
			HireBandOffersMenu();
			break;
		}
	}

	private static void createHireBandOffer() {
		String name, loc;
		EventOrganizer eo;
		JyveUtils.Date date;
		
		System.out.println("Create Band Offer");
		System.out.println("Owner's Name: ");
		name = reader.nextLine();
		eo = new EventOrganizer(name);
		
		System.out.println("Studio's Location: ");
		loc = reader.nextLine();
		
		date = createDate();
		
		HireBand hb = new HireBand(eo, loc, date);
		
		System.out.println("Offer " + hb + " created with success");
		HireBandOffersMenu();
	}

	private static void listHireBandOffer() {
		VDMSet offers = ab.listHireBandOffers();
		Iterator iterator = offers.iterator();
		printHireBandOffer(iterator);
	}

	private static void printHireBandOffer(Iterator iterator) {
		System.out.println("Hire Bands Offers\n");
		int i = 1;
		while(iterator.hasNext()){
			HireBand ao = (HireBand) iterator.next();
			System.out.println(" " + i + ": " + ao.toString());
			i++;
		}
	}

	private static void AvailableVenuesMenu() {
		 
		System.out.println("Available Venues Menu\n");
		System.out.println(" 1. List");
		System.out.println(" 0. Back\n");
		
		 
		System.out.println("Option: ");
		String op = reader.nextLine();
		 
		
		switch (op) {
		case "1":
			listAllAvaibleVenues();
			break;
		case "0":
			advertisingBoard();
			break;
		default:
			AvailableVenuesMenu();
			break;
		}
	}

	private static void listAllAvaibleVenues() {
		System.out.println("Available Venues: \n");
		JyveUtils.Date date = null;
		
		while(date == null)
			date = createDate();
		
		VDMSet offers = ab.listAvailableVenues(date);
		Iterator iterator = offers.iterator();
		printAvailableVenues(iterator);
	}
	
	private static void printAvailableVenues(Iterator iterator) {
		System.out.println("Avaiable Venues\n");
		
		int i = 1;
		while(iterator.hasNext()){
			Venue ao = (Venue) iterator.next();
			System.out.println(" " + i + ": " + ao.toString());
			i++;
		}
	}

	private static void PlaceOffersMenu() {
		 
		System.out.println("Place Offers Menu\n");
		System.out.println(" 1. Create an offer");
		System.out.println(" 2. List all");
		System.out.println(" 3. List by category");
		System.out.println(" 0. Back\n");
		
		 
		System.out.println("Option: ");
		String op = reader.nextLine();
		 
		
		switch (op) {
		case "1":
			createPlaceOffer();
			break;
		case "2":
			listAllPlaceOffers();
			break;
		case "3":
			listPlaceOfferByCategory();
			break;
		case "0":
			advertisingBoard();
			break;
		default:
			PlaceOffersMenu();
			break;
		}
	}
	
	private static void createPlaceOffer() {
		// TODO Auto-generated method stub
		
	}

	private static void listPlaceOfferByCategory() {
		boolean venue = false, rehearsal = false, recording = false;
		
		System.out.println("Place Offers by Categories: \n");
		System.out.println("Venue or Studio: ");
		System.out.println(" 1. Venue");
		System.out.println(" 2. Studio\n");
		
		System.out.println("Option: ");
		String op = reader.nextLine();
		
		switch(op) {
		case "1":
			venue = true;
			break;
		case "2":
			venue = false;
			break;
		default:
			venue = false;
			break;
		}
		
		if(!venue) {
			System.out.println("Rehearsal: ");
			System.out.println(" 1. Yes");
			System.out.println(" 2. No\n");
			
			System.out.println("Option: ");
			op = reader.nextLine();
			
			switch(op) {
			case "1":
				rehearsal = true;
				break;
			case "2":
				rehearsal = false;
				break;
			default:
				rehearsal = false;
				break;
			}
			
			System.out.println("Recording: ");
			System.out.println(" 1. Yes");
			System.out.println(" 2. No\n");
			
			System.out.println("Option: ");
			op = reader.nextLine();
			
			switch(op) {
			case "1":
				recording = true;
				break;
			case "2":
				recording = false;
				break;
			default:
				recording = false;
				break;
			}
		}
		
		listAllPlaceOffers(venue, rehearsal, recording);
	}

	private static void listAllPlaceOffers(boolean venue, boolean rehearsal, boolean recording) {
		VDMSet offers = ab.listPlaceOffers(venue, rehearsal, recording);
		Iterator iterator = offers.iterator();
		printPlaceOffer(iterator);
	}
	
	private static void listAllPlaceOffers() {
		VDMSet offers = ab.listPlaceOffers();
		Iterator iterator = offers.iterator();
		printPlaceOffer(iterator);
	}

	private static void printPlaceOffer(Iterator iterator) {
		System.out.println("Place Offers\n");
		int i = 1;
		while(iterator.hasNext()){
			PlaceOffer ao = (PlaceOffer) iterator.next();
			System.out.println(" " + i + ": " + ao.toString());
			i++;
		}
	}

	private static void RoadieOffersMenu() {
		 
		System.out.println("Roadie Offers Menu\n");
		System.out.println(" 1. Create an offer");
		System.out.println(" 2. List all");
		System.out.println(" 3. List by category");
		System.out.println(" 0. Back\n");
		
		 
		System.out.println("Option: ");
		String op = reader.nextLine();
		 
		
		switch (op) {
		case "1":
			createRoadieOffer();
			break;
		case "2":
			listAllRoadies();
			break;
		case "3":
			listRoadiesByCategory();
			break;
		case "0":
			advertisingBoard();
			break;
		default:
			RoadieOffersMenu();
			break;
		}
	}
	
	private static void createRoadieOffer() {
		// TODO Auto-generated method stub
		
	}

	private static void listRoadiesByCategory() {
		System.out.println("Roadie Offers by Categories: \n");
		System.out.println("Pick a task: ");
		System.out.println(" 1. Manager");
		System.out.println(" 2. Engineer");
		System.out.println(" 3. Security Guard");
		System.out.println(" 4. Instrument Tech\n");
		
		System.out.println("Option: ");
		String op = reader.nextLine();
		
		switch(op) {
		case "1":
			ManagerQuote manager = new ManagerQuote();
			listRoadieOfferWithObject(manager);
			break;
		case "2":
			EngineerQuote engineer = new EngineerQuote();
			listRoadieOfferWithObject(engineer);
			break;
		case "3":
			SecurityGuardQuote securityGuard = new SecurityGuardQuote();
			listRoadieOfferWithObject(securityGuard);
			break;
		case "4":
			InstrumentTechQuote instrumentTech = new InstrumentTechQuote();
			listRoadieOfferWithObject(instrumentTech);
			break;
		default:
			listRoadiesByCategory();
			return;
		}
	}

	private static void listRoadieOfferWithObject(Object o) {
		VDMSet offers = ab.listRoadieOffers(o);
		Iterator iterator = offers.iterator();
		printRoadieOffer(iterator);
	}

	private static void listAllRoadies() {
		VDMSet offers = ab.listRoadieOffers();
		Iterator iterator = offers.iterator();
		printRoadieOffer(iterator);
	}

	private static void printRoadieOffer(Iterator iterator) {
		System.out.println("Roadie Offers\n");
		int i = 1;
		while(iterator.hasNext()){
			BandRole ao = (BandRole) iterator.next();
			System.out.println(" " + i + ": " + ao.toString());
			i++;
		}
	}

	private static void BandRoleOffersMenu() {
		 
		System.out.println("Band Role Menu\n");
		System.out.println(" 1. Create an offer");
		System.out.println(" 2. List all");
		System.out.println(" 3. List by category");
		System.out.println(" 0. Back\n");
		
		 
		System.out.println("Option: ");
		String op = reader.nextLine();
		 
		
		switch (op) {
		case "1":
			createBandRoleOffer();
			break;
		case "2":
			listAllBandRoleOffer();
			break;
		case "3":
			listBandRoleOfferByCategory();
			break;
		case "0":
			advertisingBoard();
			break;
		default:
			BandRoleOffersMenu();
			break;
		}
	}

	private static void createBandRoleOffer() {
		// TODO Auto-generated method stub
		
	}

	private static void listBandRoleOfferByCategory() {
		System.out.println("Band Roles by Categories: \n");
		System.out.println("Pick an instrument: ");
		System.out.println(" 1. Guitar");
		System.out.println(" 2. Bass");
		System.out.println(" 3. Drums");
		System.out.println(" 4. Piano");
		System.out.println(" 5. Vocal");
		System.out.println(" 6. DJ");
		System.out.println(" 7. Saxophone");
		System.out.println(" 8. Violin");
		System.out.println(" 9. Accordeon");
		System.out.println(" 10. Tuba");
		System.out.println(" 11. DoubleBass");
		System.out.println(" 12. Viola");
		System.out.println(" 13. Cello");
		System.out.println(" 14. Xylophone");
		System.out.println(" 15. Bagpipes\n");
		
		System.out.println("Option: ");
		String op = reader.nextLine();
		
		switch(op) {
		case "1":
			GuitarQuote guitar = new GuitarQuote();
			listBandRoleOfferWithObject(guitar);
			break;
		case "2":
			BassQuote bass = new BassQuote();
			listBandRoleOfferWithObject(bass);
			break;
		case "3":
			DrumsQuote drums = new DrumsQuote();
			listBandRoleOfferWithObject(drums);
			break;
		case "4":
			PianoQuote piano = new PianoQuote();
			listBandRoleOfferWithObject(piano);
			break;
		case "5":
			VocalQuote vocal = new VocalQuote();
			listBandRoleOfferWithObject(vocal);
			break;
		case "6":
			DJQuote dj = new DJQuote();
			listBandRoleOfferWithObject(dj);
			break;
		case "7":
			SaxophoneQuote saxophone = new SaxophoneQuote();
			listBandRoleOfferWithObject(saxophone);
			break;
		case "8":
			ViolinQuote violin = new ViolinQuote();
			listBandRoleOfferWithObject(violin);
			break;
		case "9":
			AccordeonQuote accordeon = new AccordeonQuote();
			listBandRoleOfferWithObject(accordeon);
			break;
		case "10":
			TubaQuote tuba = new TubaQuote();
			listBandRoleOfferWithObject(tuba);
			break;
		case "11":
			DoubleBassQuote doubleBass = new DoubleBassQuote();
			listBandRoleOfferWithObject(doubleBass);
			break;
		case "12":
			ViolaQuote viola = new ViolaQuote();
			listBandRoleOfferWithObject(viola);
			break;
		case "13":
			CelloQuote cello = new CelloQuote();
			listBandRoleOfferWithObject(cello);
			break;
		case "14":
			XylophoneQuote xylophone = new XylophoneQuote();
			listBandRoleOfferWithObject(xylophone);
			break;
		case "15":
			BagpipesQuote bagpipes = new BagpipesQuote();
			listBandRoleOfferWithObject(bagpipes);
			break;
		default:
			listBandRoleOfferByCategory();
			return;
		}
	}
	
	private static void listBandRoleOfferWithObject(Object o) {
		VDMSet offers = ab.listBandRoleOffers(o);
		Iterator iterator = offers.iterator();
		printBandRoleOffer(iterator);
	}

	private static void listAllBandRoleOffer() {
		VDMSet offers = ab.listBandRoleOffers();
		Iterator iterator = offers.iterator();
		printBandRoleOffer(iterator);
	}
	
	private static void printBandRoleOffer(Iterator iterator) {
		System.out.println("Band Roles\n");
		int i = 1;
		while(iterator.hasNext()){
			BandRole ao = (BandRole) iterator.next();
			System.out.println(" " + i + ": " + ao.toString());
			i++;
		}
	}

	private static void artistOffersMenu() {
		 
		System.out.println("Atrist Offers Menu\n");
		System.out.println(" 1. Create an offer");
		System.out.println(" 2. List all");
		System.out.println(" 3. List by category");
		System.out.println(" 0. Back\n");
		
		System.out.println("Option: ");
		String op = reader.nextLine();
		 
		
		switch (op) {
		case "1":
			createArtistOffer();
			break;
		case "2":
			listAllArtistOffer();
			break;
		case "3":
			ListArtistOfferByCategory();
			break;
		case "0":
			advertisingBoard();
			break;
		default:
			artistOffersMenu();
			break;
		}
	}

	private static void createArtistOffer() {
		// TODO Auto-generated method stub
		
	}

	private static void ListArtistOfferByCategory() {
		System.out.println("Artists by Categories: \n");
		System.out.println("Pick an instrument: ");
		System.out.println(" 1. Guitar");
		System.out.println(" 2. Bass");
		System.out.println(" 3. Drums");
		System.out.println(" 4. Piano");
		System.out.println(" 5. Vocal");
		System.out.println(" 6. DJ");
		System.out.println(" 7. Saxophone");
		System.out.println(" 8. Violin");
		System.out.println(" 9. Accordeon");
		System.out.println(" 10. Tuba");
		System.out.println(" 11. DoubleBass");
		System.out.println(" 12. Viola");
		System.out.println(" 13. Cello");
		System.out.println(" 14. Xylophone");
		System.out.println(" 15. Bagpipes\n");
		
		System.out.println("Option: ");
		String op = reader.nextLine();
		
		switch(op) {
		case "1":
			GuitarQuote guitar = new GuitarQuote();
			listArtistOfferWithObject(guitar);
			break;
		case "2":
			BassQuote bass = new BassQuote();
			listArtistOfferWithObject(bass);
			break;
		case "3":
			DrumsQuote drums = new DrumsQuote();
			listArtistOfferWithObject(drums);
			break;
		case "4":
			PianoQuote piano = new PianoQuote();
			listArtistOfferWithObject(piano);
			break;
		case "5":
			VocalQuote vocal = new VocalQuote();
			listArtistOfferWithObject(vocal);
			break;
		case "6":
			DJQuote dj = new DJQuote();
			listArtistOfferWithObject(dj);
			break;
		case "7":
			SaxophoneQuote saxophone = new SaxophoneQuote();
			listArtistOfferWithObject(saxophone);
			break;
		case "8":
			ViolinQuote violin = new ViolinQuote();
			listArtistOfferWithObject(violin);
			break;
		case "9":
			AccordeonQuote accordeon = new AccordeonQuote();
			listArtistOfferWithObject(accordeon);
			break;
		case "10":
			TubaQuote tuba = new TubaQuote();
			listArtistOfferWithObject(tuba);
			break;
		case "11":
			DoubleBassQuote doubleBass = new DoubleBassQuote();
			listArtistOfferWithObject(doubleBass);
			break;
		case "12":
			ViolaQuote viola = new ViolaQuote();
			listArtistOfferWithObject(viola);
			break;
		case "13":
			CelloQuote cello = new CelloQuote();
			listArtistOfferWithObject(cello);
			break;
		case "14":
			XylophoneQuote xylophone = new XylophoneQuote();
			listArtistOfferWithObject(xylophone);
			break;
		case "15":
			BagpipesQuote bagpipes = new BagpipesQuote();
			listArtistOfferWithObject(bagpipes);
			break;
		default:
			ListArtistOfferByCategory();
			return;
		}
	}
	
	private static void listArtistOfferWithObject(Object o) {
		VDMSet offers = ab.listArtistOffers(o);
		Iterator iterator = offers.iterator();
		printArtistOffer(iterator);
	}

	private static void listAllArtistOffer() {
		VDMSet offers = ab.listArtistOffers();
		Iterator iterator = offers.iterator();
		printArtistOffer(iterator);
		
	}
	
	private static void printArtistOffer(Iterator iterator) {
		System.out.println("Artist Offers\n");
		int i = 1;
		while(iterator.hasNext()){
			ArtistOffer ao = (ArtistOffer) iterator.next();
			System.out.println(" " + i + ": " + ao.toString());
			i++;
		}
	}

	private static JyveUtils.Date createDate(){
		int day, month, year;
		
		System.out.println("Date: ");
		System.out.println(" 1. Day: ");
		if(reader.hasNextInt())
			day = reader.nextInt();
		else {
			listAllAvaibleVenues();
			return null;
		}
		System.out.println(" 2. Month: ");
		if(reader.hasNextInt())
			month = reader.nextInt();
		else {
			listAllAvaibleVenues();
			return null;
		}
		System.out.println(" 3. Year: ");
		if(reader.hasNextInt())
			year = reader.nextInt();
		else {
			listAllAvaibleVenues();
			return null;
		}
		

		return new JyveUtils.Date(day, month, year);
	}
}
