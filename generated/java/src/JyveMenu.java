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
		System.out.println(" 0. Back\n");
		
		 
		System.out.println("Option: ");
		String op = reader.nextLine();
		 
		
		switch (op) {
		case "1":
			createVenue();
			venuesMenu();
			break;
		case "0":
			placeMenu();
			break;
		default:
			venuesMenu();
			break;
		}
	}

	private static Venue createVenue() {
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
			return createVenue();
		}	
		sa = reader.nextInt();
		reader.nextLine();
		
		System.out.println("Venue's Capacity: ");
		if(!reader.hasNextInt()) {
			return createVenue();
		}
		cap = reader.nextInt();
		reader.nextLine();
		
		System.out.println("Venue's Lighting(Brief Descripton): ");
		lig = reader.nextLine();
		
		System.out.println("Venue's Sound(Brief Descripton): ");
		s = reader.nextLine();
		
		Venue v = new Venue(po, loc, sa, cap, lig, s);
		
		System.out.println("Venue " + v.toString() + " created with success");
		return v;
	}

	private static void studiosMenu() {
		 
		System.out.println("Studios Menu\n");
		System.out.println(" 1. Create Studio");
		System.out.println(" 0. Back\n");
		
		 
		System.out.println("Option: ");
		String op = reader.nextLine();
		 
		
		switch (op) {
		case "1":
			createStudio();
			studiosMenu();
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
		reader.nextLine();
	
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
		System.out.println(" 1. Create Gig");
		System.out.println(" 2. List all");
		System.out.println(" 3. List by Venue");
		System.out.println(" 4. List by Date");
		System.out.println(" 0. Back\n");
		
		 
		System.out.println("Option: ");
		String op = reader.nextLine();
		 
		
		switch (op) {
		case "1":
			createGig();
			GigsMenu();
			break;
		case "2":
			listAllGigs();
			GigsMenu();
			break;
		case "3":
			listGigsByVenue();
			GigsMenu();
			break;
		case "4":
			listGigsByDate();
			GigsMenu();
			break;
		case "0":
			advertisingBoard();
			break;
		default:
			GigsMenu();
			break;
		}
	}

	private static void createGig() {
		System.out.println("Create Gig\n");
		
		Venue v;
		JyveUtils.Date d;
		Gig g;
		
		v = createVenue();
		d = createDate();
		
		g = new Gig(v, d);
		
		while(true) {
			System.out.println("Add band to Gig? ");
			System.out.println(" 1. Yes");
			System.out.println(" 2. No");
			
			String op = reader.nextLine();
			if(!op.equals("1"))
				break;
			
			Band b = createBand();
			
			g.addBand(b);
		}
		ab.addGig(g);
		
		System.out.println("Gig " + g + " created with success");
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
		reader.nextLine();
		Venue v = (Venue) AdvertisingBoard.listVenues().get(op);
		
		listGigWithVenue(v);
	}

	@SuppressWarnings("rawtypes")
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

	@SuppressWarnings("rawtypes")
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

	@SuppressWarnings("rawtypes")
	private static void listAllGigs() {
		VDMSet offers = ab.listGigs();
		Iterator iterator = offers.iterator();
		
		printGig(iterator);
	}

	@SuppressWarnings("rawtypes")
	private static void listGigsByDate() {
		System.out.println("Gigs by date: \n");
		JyveUtils.Date date = null;
		
		while(date == null)
			date = createDate();
		
		VDMSet offers = ab.listGigs(date);
		Iterator iterator = offers.iterator();
		
		printGig(iterator);
	}

	@SuppressWarnings("rawtypes")
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
			HireBandOffersMenu();
			break;
		case "2":
			listHireBandOffer();
			HireBandOffersMenu();
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
		
		System.out.println("Create Hire Band Offer");
		System.out.println("Studio Owner's Name: ");
		name = reader.nextLine();
		eo = new EventOrganizer(name);
		
		System.out.println("Studio's Location: ");
		loc = reader.nextLine();
		
		date = createDate();
		
		HireBand hb = new HireBand(eo, loc, date);
		ab.addHireBandOffer(hb);
		
		System.out.println("Offer " + hb + " created with success");
	}

	@SuppressWarnings("rawtypes")
	private static void listHireBandOffer() {
		VDMSet offers = ab.listHireBandOffers();
		Iterator iterator = offers.iterator();
		printHireBandOffer(iterator);
	}

	@SuppressWarnings("rawtypes")
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
			AvailableVenuesMenu();
			break;
		case "0":
			advertisingBoard();
			break;
		default:
			AvailableVenuesMenu();
			break;
		}
	}

	@SuppressWarnings("rawtypes")
	private static void listAllAvaibleVenues() {
		System.out.println("Available Venues: \n");
		JyveUtils.Date date = null;
		
		while(date == null)
			date = createDate();
		
		VDMSet offers = ab.listAvailableVenues(date);
		Iterator iterator = offers.iterator();
		printAvailableVenues(iterator);
	}

	@SuppressWarnings("rawtypes")
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
			PlaceOffersMenu();
			break;
		case "2":
			listAllPlaceOffers();
			PlaceOffersMenu();
			break;
		case "3":
			listPlaceOfferByCategory();
			PlaceOffersMenu();
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
		String name, loc;
		int sa;
		PlaceOwner po;
		
		System.out.println("Create Place Offer\n");
		System.out.println("Place Owner's Name: ");
		name = reader.nextLine();
		po = new PlaceOwner(name);
		
		System.out.println("Place's Location: ");
		loc = reader.nextLine();
		
		System.out.println("Place's Stage Area(m2): ");
		if(!reader.hasNextInt()) {
			createPlaceOffer();
			return;
		}	
		sa = reader.nextInt();
		reader.nextLine();
		
		Place p = new Place(po, loc, sa);
		PlaceOffer placeO = new PlaceOffer(p);
		ab.addPlaceOffer(placeO);
		
		System.out.println("Place Offer for " + placeO + " created with success");
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

	@SuppressWarnings("rawtypes")
	private static void listAllPlaceOffers(boolean venue, boolean rehearsal, boolean recording) {
		VDMSet offers = ab.listPlaceOffers(venue, rehearsal, recording);
		Iterator iterator = offers.iterator();
		printPlaceOffer(iterator);
	}

	@SuppressWarnings("rawtypes")
	private static void listAllPlaceOffers() {
		VDMSet offers = ab.listPlaceOffers();
		Iterator iterator = offers.iterator();
		printPlaceOffer(iterator);
	}

	@SuppressWarnings("rawtypes")
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
			RoadieOffersMenu();
			break;
		case "2":
			listAllRoadies();
			RoadieOffersMenu();
			break;
		case "3":
			listRoadiesByCategory();
			RoadieOffersMenu();
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
		Band b;
		Object task;

		System.out.println("Create Place Offer\n");
		b = createBand();
		task = defineTask();
		
		RoadieOffer ro = new RoadieOffer(b, task);
		ab.addRoadieOffer(ro);
		
		System.out.println("Rpadie Offer for " + ro + " created with success");
	}

	private static Object defineTask() {
		Object t;
		
		System.out.println("Pick a Task: ");
		System.out.println(" 1. Manager");
		System.out.println(" 2. Engineer");
		System.out.println(" 3. Security Guard");
		System.out.println(" 4. Instrument Tech\n");

		System.out.println("Option: ");
		String op = reader.nextLine();
				
		switch(op) {
		case "1":
			t = new ManagerQuote();
			break;
		case "2":
			t = new EngineerQuote();
			break;
		case "3":
			t = new SecurityGuardQuote();
			break;
		case "4":
			t = new InstrumentTechQuote();
			break;
		default:
			t = defineTask();
			break;
		}
		
		return t;
	}

	private static Band createBand() {
		Band b;
		String name;
		System.out.println("Band's Name: ");
		name = reader.nextLine();
		
		b = new Band(name);
		
		getGenres(b);
		
		return b;
	}

	private static void getGenres(Band b) {
		System.out.println("Band's Genres: \n");
		String op = "";
		
		System.out.println("Pick a Genre: ");
		System.out.println(" 1. Rock");
		System.out.println(" 2. Metal");
		System.out.println(" 3. Pop");
		System.out.println(" 4. HipHop");
		System.out.println(" 5. Jazz");
		System.out.println(" 6. Electronic");
		System.out.println(" 7. Reggae");
		System.out.println(" 8. Classic");
		System.out.println(" 9. Alternative");
		System.out.println(" 0. End\n");
		
		while(true){
			System.out.println("Option: ");
			op = reader.nextLine();
			if(op.equals("0"))
				break;
			
			switch(op) {
			case "1":
				RockQuote rock = new RockQuote();
				b.addGenre(rock);
				break;
			case "2":
				MetalQuote metal = new MetalQuote();
				b.addGenre(metal);
				break;
			case "3":
				PopQuote pop = new PopQuote();
				b.addGenre(pop);
				break;
			case "4":
				HipHopQuote hiphop = new HipHopQuote();
				b.addGenre(hiphop);
				break;
			case "5":
				JazzQuote jazz = new JazzQuote();
				b.addGenre(jazz);
				break;
			case "6":
				ElectronicQuote electronic = new ElectronicQuote();
				b.addGenre(electronic);
				break;
			case "7":
				ReggaeQuote reggae = new ReggaeQuote();
				b.addGenre(reggae);
				break;
			case "8":
				ClassicQuote classic = new ClassicQuote();
				b.addGenre(classic);
				break;
			case "9":
				AlternativeQuote alternative = new AlternativeQuote();
				b.addGenre(alternative);
				break;
			default:
				break;
			}
		}

		System.out.println("All Genres added to Band\n");
		
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

	@SuppressWarnings("rawtypes")
	private static void listRoadieOfferWithObject(Object o) {
		VDMSet offers = ab.listRoadieOffers(o);
		Iterator iterator = offers.iterator();
		printRoadieOffer(iterator);
	}

	@SuppressWarnings("rawtypes")
	private static void listAllRoadies() {
		VDMSet offers = ab.listRoadieOffers();
		Iterator iterator = offers.iterator();
		printRoadieOffer(iterator);
	}

	@SuppressWarnings("rawtypes")
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
			BandRoleOffersMenu();
			break;
		case "2":
			listAllBandRoleOffer();
			BandRoleOffersMenu();
			break;
		case "3":
			listBandRoleOfferByCategory();
			BandRoleOffersMenu();
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
		Band b;
		Object desiredRole;
		
		b = createBand();
		desiredRole = pickInstrument();
		
		BandRole br = new BandRole(b, desiredRole);
		ab.addBandRoleOffer(br);
		
		System.out.println("Band Role " + br + " created with success");
	}

	private static Object pickInstrument() {
		Object instrument;
		
		System.out.println("Pick an instrument: \n");
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
			instrument = new GuitarQuote();
			break;
		case "2":
			instrument = new BassQuote();
			break;
		case "3":
			instrument = new DrumsQuote();
			break;
		case "4":
			instrument = new PianoQuote();
			break;
		case "5":
			instrument = new VocalQuote();
			break;
		case "6":
			instrument = new DJQuote();
			break;
		case "7":
			instrument = new SaxophoneQuote();
			break;
		case "8":
			instrument = new ViolinQuote();
			break;
		case "9":
			instrument = new AccordeonQuote();
			break;
		case "10":
			instrument = new TubaQuote();
			break;
		case "11":
			instrument = new DoubleBassQuote();
			break;
		case "12":
			instrument = new ViolaQuote();
			break;
		case "13":
			instrument = new CelloQuote();
			break;
		case "14":
			instrument = new XylophoneQuote();
			break;
		case "15":
			instrument = new BagpipesQuote();
			break;
		default:
			instrument = pickInstrument();
			break;
		}
		
		return instrument;
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

	@SuppressWarnings("rawtypes")	
	private static void listBandRoleOfferWithObject(Object o) {
		VDMSet offers = ab.listBandRoleOffers(o);
		Iterator iterator = offers.iterator();
		printBandRoleOffer(iterator);
	}

	@SuppressWarnings("rawtypes")
	private static void listAllBandRoleOffer() {
		VDMSet offers = ab.listBandRoleOffers();
		Iterator iterator = offers.iterator();
		printBandRoleOffer(iterator);
	}
	
	@SuppressWarnings("rawtypes")
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
			artistOffersMenu();
			break;
		case "2":
			listAllArtistOffer();
			artistOffersMenu();
			break;
		case "3":
			ListArtistOfferByCategory();
			artistOffersMenu();
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
		Artist a;
		a = createArtist();
		
		ArtistOffer ao = new ArtistOffer(a);
		ab.addArtistOffer(ao);
		System.out.println("Artist Offer " + ao + " created with success");
	}

	private static Artist createArtist() {
		Artist a;
		String name;
		
		System.out.println("Artist's Name: ");
		name = reader.nextLine();
		a = new Artist(name);
		
		setInstruments(a);
		
		return a;
	}

	private static void setInstruments(Artist a) {
		String op;
		
		System.out.println("Add Instruments to Artist: \n");
		System.out.println("Instruments: ");
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
		System.out.println(" 15. Bagpipes");
		System.out.println(" 0. End\n");
		
		while(true){
			System.out.println("Option: ");
			op = reader.nextLine();
			if(op.equals("0"))
				break;
			
			switch(op) {
			case "1":
				GuitarQuote guitar = new GuitarQuote();
				a.addInstrument(guitar);
				break;
			case "2":
				BassQuote bass = new BassQuote();
				a.addInstrument(bass);
				break;
			case "3":
				DrumsQuote drums = new DrumsQuote();
				a.addInstrument(drums);
				break;
			case "4":
				PianoQuote piano = new PianoQuote();
				a.addInstrument(piano);
				break;
			case "5":
				VocalQuote vocal = new VocalQuote();
				a.addInstrument(vocal);
				break;
			case "6":
				DJQuote dj = new DJQuote();
				a.addInstrument(dj);
				break;
			case "7":
				SaxophoneQuote saxophone = new SaxophoneQuote();
				a.addInstrument(saxophone);
				break;
			case "8":
				ViolinQuote violin = new ViolinQuote();
				a.addInstrument(violin);
				break;
			case "9":
				AccordeonQuote accordeon = new AccordeonQuote();
				a.addInstrument(accordeon);
				break;
			case "10":
				TubaQuote tuba = new TubaQuote();
				a.addInstrument(tuba);
				break;
			case "11":
				DoubleBassQuote doubleBass = new DoubleBassQuote();
				a.addInstrument(doubleBass);
				break;
			case "12":
				ViolaQuote viola = new ViolaQuote();
				a.addInstrument(viola);
				break;
			case "13":
				CelloQuote cello = new CelloQuote();
				a.addInstrument(cello);
				break;
			case "14":
				XylophoneQuote xylophone = new XylophoneQuote();
				a.addInstrument(xylophone);
				break;
			case "15":
				BagpipesQuote bagpipes = new BagpipesQuote();
				a.addInstrument(bagpipes);
				break;
			default:
				break;
			}
		}

		System.out.println("All Instruments added to Artist\n");
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
	

	@SuppressWarnings("rawtypes")
	private static void listArtistOfferWithObject(Object o) {
		VDMSet offers = ab.listArtistOffers(o);
		Iterator iterator = offers.iterator();
		printArtistOffer(iterator);
	}


	@SuppressWarnings("rawtypes")
	private static void listAllArtistOffer() {
		VDMSet offers = ab.listArtistOffers();
		Iterator iterator = offers.iterator();
		printArtistOffer(iterator);
	}
	

	@SuppressWarnings("rawtypes")
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
		if(reader.hasNextInt()) {
			day = reader.nextInt();
			reader.nextLine();
		}
		else {
			listAllAvaibleVenues();
			return null;
		}
		System.out.println(" 2. Month: ");
		if(reader.hasNextInt()) {
			month = reader.nextInt();
			reader.nextLine();
		}
		else {
			listAllAvaibleVenues();
			return null;
		}
		System.out.println(" 3. Year: ");
		if(reader.hasNextInt()) {
			year = reader.nextInt();
			reader.nextLine();
		}
		else {
			listAllAvaibleVenues();
			return null;
		}
		

		return new JyveUtils.Date(day, month, year);
	}
}
