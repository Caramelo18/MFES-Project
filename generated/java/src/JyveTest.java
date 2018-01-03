
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class JyveTest {
  private AdvertisingBoard ab = new AdvertisingBoard();

  private void assertTrue(final Boolean cond) {

    return;
  }

  private void assertFalse(final Boolean cond) {

    return;
  }

  private void assertEqual(final Object expected, final Object actual) {

    return;
  }

  private void testArtist() {

    Artist a1 = null;
    Boolean result = false;
    a1 = new Artist("Artist 1");
    assertEqual("Artist 1", a1.getName());
    a1.changeName("New Name");
    assertEqual("New Name", a1.getName());
    result = a1.playsInstrument(quotes.GuitarQuote.getInstance());
    assertFalse(result);
    a1.addInstrument(quotes.GuitarQuote.getInstance());
    result = a1.playsInstrument(quotes.GuitarQuote.getInstance());
    assertTrue(result);
    result = a1.playsInstrument(quotes.BagpipesQuote.getInstance());
    assertFalse(result);
    a1.addInstrument(quotes.BagpipesQuote.getInstance());
    result = a1.playsInstrument(quotes.BagpipesQuote.getInstance());
    assertTrue(result);
    result = a1.playsInstrument(quotes.GuitarQuote.getInstance());
    assertTrue(result);
    a1.deleteInstrument(quotes.GuitarQuote.getInstance());
    result = a1.playsInstrument(quotes.BagpipesQuote.getInstance());
    assertTrue(result);
    result = a1.playsInstrument(quotes.GuitarQuote.getInstance());
    assertFalse(result);
  }

  private void testPlaces() {

    Studio s = null;
    Venue v = null;
    PlaceOwner plo = null;
    assertEqual(SeqUtil.seq(), AdvertisingBoard.listPlaces());
    plo = new PlaceOwner("Place Owner");
    s = new Studio(plo, "Porto Portugal", 25L, false, true);
    assertEqual(SeqUtil.seq(s), AdvertisingBoard.listPlaces());
    v = new Venue(plo, "Feira Portugal", 75L, 2000L, "Ok", "Ok");
    assertEqual(SeqUtil.seq(s, v), AdvertisingBoard.listPlaces());
    assertEqual(SeqUtil.seq(v), AdvertisingBoard.listVenues());
  }

  private void testArtistOffer() {

    Artist a1 = null;
    Artist a2 = null;
    ArtistOffer ao1 = null;
    ArtistOffer ao2 = null;
    a1 = new Artist("Artist 1");
    a1.addInstrument(quotes.GuitarQuote.getInstance());
    ao1 = new ArtistOffer(a1);
    a2 = new Artist("Artist 2");
    a2.addInstrument(quotes.GuitarQuote.getInstance());
    a2.addInstrument(quotes.SaxophoneQuote.getInstance());
    ao2 = new ArtistOffer(a2);
    assertEqual(SetUtil.set(), ab.listArtistOffers());
    ab.addArtistOffer(ao1);
    ab.addArtistOffer(ao2);
    assertEqual(SetUtil.set(ao1, ao2), ab.listArtistOffers());
    assertEqual(SetUtil.set(), ab.listArtistOffers(quotes.BagpipesQuote.getInstance()));
    assertEqual(SetUtil.set(ao1, ao2), ab.listArtistOffers(quotes.GuitarQuote.getInstance()));
    assertEqual(SetUtil.set(ao2), ab.listArtistOffers(quotes.SaxophoneQuote.getInstance()));
    ab.deleteArtistOffer(ao1);
    assertEqual(SetUtil.set(ao2), ab.listArtistOffers());
    assertEqual(SetUtil.set(ao2), ab.listArtistOffers(quotes.GuitarQuote.getInstance()));
    assertEqual(SetUtil.set(ao2), ab.listArtistOffers(quotes.SaxophoneQuote.getInstance()));
  }

  private void testBand() {

    Band b1 = null;
    b1 = new Band("Band 1");
    assertEqual("Band 1", b1.getName());
    assertEqual(SetUtil.set(), b1.getGenres());
    b1.addGenre(quotes.RockQuote.getInstance());
    assertEqual(SetUtil.set(quotes.RockQuote.getInstance()), b1.getGenres());
    b1.addGenre(quotes.MetalQuote.getInstance());
    assertEqual(
        SetUtil.set(quotes.RockQuote.getInstance(), quotes.MetalQuote.getInstance()),
        b1.getGenres());
    b1.deleteGenre(quotes.RockQuote.getInstance());
    assertEqual(SetUtil.set(quotes.MetalQuote.getInstance()), b1.getGenres());
  }

  private void testBandRole() {

    Band b1 = null;
    Band b2 = null;
    BandRole br1 = null;
    BandRole br2 = null;
    BandRole br3 = null;
    b1 = new Band("Band 1");
    b2 = new Band("Band 2");
    br1 = new BandRole(b1, quotes.SaxophoneQuote.getInstance());
    br2 = new BandRole(b2, quotes.DrumsQuote.getInstance());
    br3 = new BandRole(b1, quotes.DJQuote.getInstance());
    assertEqual(SetUtil.set(), ab.listBandRoleOffers());
    assertEqual(SetUtil.set(), ab.listBandRoleOffers(quotes.DJQuote.getInstance()));
    ab.addBandRoleOffer(br1);
    ab.addBandRoleOffer(br2);
    ab.addBandRoleOffer(br3);
    assertEqual(SetUtil.set(br1, br2, br3), ab.listBandRoleOffers());
    assertEqual(SetUtil.set(br2), ab.listBandRoleOffers(quotes.DrumsQuote.getInstance()));
    assertEqual(SetUtil.set(br3), ab.listBandRoleOffers(quotes.DJQuote.getInstance()));
    assertEqual(SetUtil.set(), ab.listBandRoleOffers(quotes.XylophoneQuote.getInstance()));
    ab.deleteBandRoleOffer(br3);
    assertEqual(SetUtil.set(br1, br2), ab.listBandRoleOffers());
    assertEqual(SetUtil.set(), ab.listBandRoleOffers(quotes.DJQuote.getInstance()));
  }

  private void testGig() {

    Band b1 = null;
    Band b2 = null;
    PlaceOwner po = null;
    Venue v = null;
    JyveUtils.Date d1 = null;
    JyveUtils.Date d2 = null;
    Gig g1 = null;
    Gig g2 = null;
    Boolean result = false;
    b1 = new Band("Band 1");
    b2 = new Band("Band 2");
    po = new PlaceOwner("Place Owner");
    v = new Venue(po, "Montijo Portugal", 100L, 15000L, "Great", "Great");
    d1 = new JyveUtils.Date(2017L, 12L, 31L);
    d2 = new JyveUtils.Date(2018L, 2L, 20L);
    g1 = new Gig(v, Utils.copy(d1));
    g2 = new Gig(v, Utils.copy(d2));
    ab.addGig(g1);
    ab.addGig(g2);
    assertEqual(SetUtil.set(g1, g2), ab.listGigs());
    assertEqual(SetUtil.set(g1, g2), ab.listGigs(v));
    assertEqual(SetUtil.set(g1), ab.listGigs(Utils.copy(d1)));
    assertEqual(SetUtil.set(g2), ab.listGigs(Utils.copy(d2)));
    assertEqual(SetUtil.set(), b1.getGigs());
    assertEqual(SetUtil.set(), g1.getBands());
    result = g1.addBand(b1);
    assertEqual(SetUtil.set(g1), b1.getGigs());
    assertEqual(SetUtil.set(b1), g1.getBands());
    result = g2.addBand(b1);
    result = g2.addBand(b2);
    assertEqual(SetUtil.set(g1, g2), b1.getGigs());
    assertEqual(SetUtil.set(b1, b2), g2.getBands());
  }

  private void testHireBand() {

    EventOrganizer eo = null;
    HireBand hb1 = null;
    HireBand hb2 = null;
    eo = new EventOrganizer("Event Organizer");
    assertEqual("Event Organizer", eo.getName());
    hb1 = new HireBand(eo, "Montijo Portugal", new JyveUtils.Date(2017L, 12L, 31L));
    hb2 = new HireBand(eo, "Porto Portugal", new JyveUtils.Date(2018L, 4L, 15L));
    assertEqual(SetUtil.set(), ab.listHireBandOffers());
    ab.addHireBandOffer(hb1);
    ab.addHireBandOffer(hb2);
    assertEqual(SetUtil.set(hb1, hb2), ab.listHireBandOffers());
    ab.deleteHireBandOffer(hb1);
    assertEqual(SetUtil.set(hb2), ab.listHireBandOffers());
  }

  private void testPlaceOffer() {

    Venue p1 = null;
    Studio p2 = null;
    Studio p3 = null;
    PlaceOwner plo = null;
    PlaceOffer po1 = null;
    PlaceOffer po2 = null;
    PlaceOffer po3 = null;
    plo = new PlaceOwner("Place Owner");
    assertEqual("Place Owner", plo.getName());
    p1 = new Venue(plo, "Feira Portugal", 75L, 2000L, "Ok", "Ok");
    p2 = new Studio(plo, "Porto Portugal", 25L, false, true);
    p3 = new Studio(plo, "Porto Portugal", 25L, true, false);
    po1 = new PlaceOffer(p1);
    po2 = new PlaceOffer(p2);
    po3 = new PlaceOffer(p3);
    assertEqual(SetUtil.set(), ab.listPlaceOffers());
    ab.addPlaceOffer(po1);
    ab.addPlaceOffer(po2);
    ab.addPlaceOffer(po3);
    assertEqual(SetUtil.set(po1, po2, po3), ab.listPlaceOffers());
    assertEqual(SetUtil.set(po1), ab.listPlaceOffers(true, false, false));
    assertEqual(SetUtil.set(po2), ab.listPlaceOffers(false, false, true));
    assertEqual(SetUtil.set(po3), ab.listPlaceOffers(false, true, false));
    ab.deletePlaceOffer(po1);
    assertEqual(SetUtil.set(po2, po3), ab.listPlaceOffers());
    assertEqual(SetUtil.set(), ab.listPlaceOffers(true, false, false));
    assertEqual(SetUtil.set(po2), ab.listPlaceOffers(false, false, true));
    assertEqual(SetUtil.set(po3), ab.listPlaceOffers(false, true, false));
  }

  private void testRoadie() {

    Roadie r = null;
    r = new Roadie("Roadie 1", quotes.SecurityGuardQuote.getInstance());
    assertEqual(quotes.SecurityGuardQuote.getInstance(), ((Object) r.getTask()));
    r.setTask(quotes.ManagerQuote.getInstance());
    assertEqual(quotes.ManagerQuote.getInstance(), ((Object) r.getTask()));
  }

  private void testRoadieOffer() {

    Band b = null;
    RoadieOffer ro1 = null;
    RoadieOffer ro2 = null;
    RoadieOffer ro3 = null;
    b = new Band("Band 1");
    ro1 = new RoadieOffer(b, quotes.EngineerQuote.getInstance());
    ro2 = new RoadieOffer(b, quotes.InstrumentTechQuote.getInstance());
    ro3 = new RoadieOffer(b, quotes.EngineerQuote.getInstance());
    assertEqual(SetUtil.set(), ab.listRoadieOffers());
    ab.addRoadieOffer(ro1);
    ab.addRoadieOffer(ro2);
    assertEqual(SetUtil.set(ro1, ro2), ab.listRoadieOffers());
    ab.addRoadieOffer(ro3);
    assertEqual(SetUtil.set(ro1, ro2, ro3), ab.listRoadieOffers());
    assertEqual(SetUtil.set(ro1, ro3), ab.listRoadieOffers(quotes.EngineerQuote.getInstance()));
    ab.deleteRoadieOffer(ro1);
    assertEqual(SetUtil.set(ro2, ro3), ab.listRoadieOffers());
    assertEqual(SetUtil.set(ro3), ab.listRoadieOffers(quotes.EngineerQuote.getInstance()));
  }

  private void testStudio() {

    PlaceOwner plo = null;
    Studio p1 = null;
    plo = new PlaceOwner("Place Owner");
    p1 = new Studio(plo, "Porto Portugal", 25L, false, true);
    assertTrue(p1.isRecording());
    assertFalse(p1.isRehearsal());
    p1.setRehearsal();
    assertFalse(p1.isRecording());
    assertTrue(p1.isRehearsal());
    p1.setRecording();
    assertTrue(p1.isRecording());
    assertFalse(p1.isRehearsal());
  }

  private void testVenue() {

    PlaceOwner plo = null;
    Venue p1 = null;
    plo = new PlaceOwner("Place Owner");
    p1 = new Venue(plo, "Porto Portugal", 25L, 10000L, "Ok", "Good");
    assertEqual(25L, p1.getStageArea());
    p1.changeStageArea(50L);
    assertEqual(50L, p1.getStageArea());
    assertEqual(10000L, p1.getCapacity());
    p1.changeCapacity(5000L);
    assertEqual(5000L, p1.getCapacity());
    assertEqual("Ok", p1.getLighting());
    p1.changeLighting("Bad");
    assertEqual("Bad", p1.getLighting());
    assertEqual("Good", p1.getSound());
    p1.changeSound("Great");
    assertEqual("Great", p1.getSound());
  }

  private void testAvailableVenues() {

    PlaceOwner plo = null;
    Venue v1 = null;
    Venue v2 = null;
    PlaceOffer po1 = null;
    PlaceOffer po2 = null;
    JyveUtils.Date d = null;
    Gig g = null;
    plo = new PlaceOwner("Place Owner");
    v1 = new Venue(plo, "Porto Portugal", 25L, 10000L, "Ok", "Good");
    v2 = new Venue(plo, "Feira Portugal", 20L, 2000L, "Ok", "Ok");
    po1 = new PlaceOffer(v1);
    po2 = new PlaceOffer(v2);
    ab.addPlaceOffer(po1);
    ab.addPlaceOffer(po2);
    d = new JyveUtils.Date(2017L, 12L, 31L);
    assertEqual(SetUtil.set(po1, po2), ab.listAvailableVenues(Utils.copy(d)));
    g = new Gig(v2, new JyveUtils.Date(2017L, 12L, 31L));
    assertEqual(SetUtil.set(po1), ab.listAvailableVenues(Utils.copy(d)));
  }

  public static void main() {

    new JyveTest().testPlaces();
    new JyveTest().testArtist();
    new JyveTest().testArtistOffer();
    new JyveTest().testBand();
    new JyveTest().testBandRole();
    new JyveTest().testGig();
    new JyveTest().testHireBand();
    new JyveTest().testPlaceOffer();
    new JyveTest().testRoadie();
    new JyveTest().testRoadieOffer();
    new JyveTest().testStudio();
    new JyveTest().testVenue();
    new JyveTest().testAvailableVenues();
  }

  public JyveTest() {}

  public String toString() {

    return "JyveTest{" + "ab := " + Utils.toString(ab) + "}";
  }
}
