
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class AdvertisingBoard {
  private VDMSet artistOffers;
  private VDMMap bandRoleOffers;
  private VDMMap roadieOffers;
  private VDMSet placeOffers;
  private VDMSet hireBandOffers;
  private VDMSet gigs;
  private static VDMSeq places = SeqUtil.seq();

  public void cg_init_AdvertisingBoard_1() {

    artistOffers = SetUtil.set();
    bandRoleOffers =
        MapUtil.map(
            new Maplet(quotes.GuitarQuote.getInstance(), SetUtil.set()),
            new Maplet(quotes.BassQuote.getInstance(), SetUtil.set()),
            new Maplet(quotes.DrumsQuote.getInstance(), SetUtil.set()),
            new Maplet(quotes.PianoQuote.getInstance(), SetUtil.set()),
            new Maplet(quotes.VocalQuote.getInstance(), SetUtil.set()),
            new Maplet(quotes.DJQuote.getInstance(), SetUtil.set()),
            new Maplet(quotes.SaxophoneQuote.getInstance(), SetUtil.set()),
            new Maplet(quotes.ViolinQuote.getInstance(), SetUtil.set()),
            new Maplet(quotes.AccordeonQuote.getInstance(), SetUtil.set()),
            new Maplet(quotes.TubaQuote.getInstance(), SetUtil.set()),
            new Maplet(quotes.DoubleBassQuote.getInstance(), SetUtil.set()),
            new Maplet(quotes.ViolaQuote.getInstance(), SetUtil.set()),
            new Maplet(quotes.CelloQuote.getInstance(), SetUtil.set()),
            new Maplet(quotes.XylophoneQuote.getInstance(), SetUtil.set()),
            new Maplet(quotes.BagpipesQuote.getInstance(), SetUtil.set()));
    roadieOffers = MapUtil.map();
    placeOffers = SetUtil.set();
    hireBandOffers = SetUtil.set();
    gigs = SetUtil.set();
    return;
  }

  public AdvertisingBoard() {

    cg_init_AdvertisingBoard_1();
  }

  public VDMSet listArtistOffers() {

    return Utils.copy(artistOffers);
  }

  public VDMSet listArtistOffers(final Object i) {

    VDMSet list = SetUtil.set();
    for (Iterator iterator_4 = artistOffers.iterator(); iterator_4.hasNext(); ) {
      ArtistOffer artistOffer = (ArtistOffer) iterator_4.next();
      if (artistOffer.getArtist().playsInstrument(((Object) i))) {
        list = SetUtil.union(Utils.copy(list), SetUtil.set(artistOffer));
      }
    }
    return Utils.copy(list);
  }

  public VDMSet listBandRoleOffers() {

    VDMSet list = SetUtil.set();
    for (Iterator iterator_5 = MapUtil.rng(Utils.copy(bandRoleOffers)).iterator();
        iterator_5.hasNext();
        ) {
      VDMSet bro = (VDMSet) iterator_5.next();
      list = SetUtil.union(Utils.copy(list), Utils.copy(bro));
    }
    return Utils.copy(list);
  }

  public VDMSet listBandRoleOffers(final Object i) {

    return Utils.copy(((VDMSet) Utils.get(bandRoleOffers, i)));
  }

  public VDMSet listRoadieOffers() {

    VDMSet res = SetUtil.set();
    for (Iterator iterator_6 = MapUtil.rng(Utils.copy(roadieOffers)).iterator();
        iterator_6.hasNext();
        ) {
      VDMSet ro = (VDMSet) iterator_6.next();
      res = SetUtil.union(Utils.copy(res), Utils.copy(ro));
    }
    return Utils.copy(res);
  }

  public VDMSet listRoadieOffers(final Object task) {

    return Utils.copy(((VDMSet) Utils.get(roadieOffers, task)));
  }

  public VDMSet listPlaceOffers() {

    return Utils.copy(placeOffers);
  }

  public VDMSet listPlaceOffers(
      final Boolean venue, final Boolean rehearsal, final Boolean recording) {

    VDMSet list = SetUtil.set();
    for (Iterator iterator_7 = placeOffers.iterator(); iterator_7.hasNext(); ) {
      PlaceOffer placeOffer = (PlaceOffer) iterator_7.next();
      Boolean andResult_6 = false;

      if (venue) {
        if (placeOffer.getPlace() instanceof Venue) {
          andResult_6 = true;
        }
      }

      if (andResult_6) {
        list = SetUtil.union(Utils.copy(list), SetUtil.set(placeOffer));

      } else {
        Boolean andResult_7 = false;

        if (!(venue)) {
          if (placeOffer.getPlace() instanceof Studio) {
            andResult_7 = true;
          }
        }

        if (andResult_7) {
          Studio place = (Studio) placeOffer.getPlace();
          Boolean andResult_8 = false;

          if (place.isRehearsal()) {
            if (rehearsal) {
              andResult_8 = true;
            }
          }

          if (andResult_8) {
            list = SetUtil.union(Utils.copy(list), SetUtil.set(placeOffer));
          } else {
            Boolean andResult_9 = false;

            if (place.isRecording()) {
              if (recording) {
                andResult_9 = true;
              }
            }

            if (andResult_9) {
              list = SetUtil.union(Utils.copy(list), SetUtil.set(placeOffer));
            }
          }
        }
      }
    }
    return Utils.copy(list);
  }

  public VDMSet listAvailableVenues(final JyveUtils.Date date) {

    VDMSet list = SetUtil.set();
    for (Iterator iterator_8 = placeOffers.iterator(); iterator_8.hasNext(); ) {
      PlaceOffer placeOffer = (PlaceOffer) iterator_8.next();
      if (placeOffer.getPlace() instanceof Venue) {
        Venue venue = (Venue) placeOffer.getPlace();
        if (venue.isAvailable(Utils.copy(date))) {
          list = SetUtil.union(Utils.copy(list), SetUtil.set(placeOffer));
        }
      }
    }
    return Utils.copy(list);
  }

  public VDMSet listHireBandOffers() {

    return Utils.copy(hireBandOffers);
  }

  public VDMSet listGigs() {

    return Utils.copy(gigs);
  }

  public VDMSet listGigs(final Venue v) {

    VDMSet gs = SetUtil.set();
    for (Iterator iterator_9 = gigs.iterator(); iterator_9.hasNext(); ) {
      Gig g = (Gig) iterator_9.next();
      if (Utils.equals(g.getVenue(), v)) {
        gs = SetUtil.union(Utils.copy(gs), SetUtil.set(g));
      }
    }
    return Utils.copy(gs);
  }

  public VDMSet listGigs(final JyveUtils.Date d) {

    VDMSet gs = SetUtil.set();
    for (Iterator iterator_10 = gigs.iterator(); iterator_10.hasNext(); ) {
      Gig g = (Gig) iterator_10.next();
      if (Utils.equals(g.getDate(), d)) {
        gs = SetUtil.union(Utils.copy(gs), SetUtil.set(g));
      }
    }
    return Utils.copy(gs);
  }

  public static VDMSeq listPlaces() {

    return Utils.copy(AdvertisingBoard.places);
  }

  public static VDMSeq listVenues() {

    VDMSeq res = SeqUtil.seq();
    for (Iterator iterator_11 = SeqUtil.elems(Utils.copy(AdvertisingBoard.places)).iterator();
        iterator_11.hasNext();
        ) {
      Place p = (Place) iterator_11.next();
      if (p instanceof Venue) {
        res = SeqUtil.conc(Utils.copy(res), SeqUtil.seq(p));
      }
    }
    return Utils.copy(res);
  }

  public void addArtistOffer(final ArtistOffer ao) {

    artistOffers = SetUtil.union(Utils.copy(artistOffers), SetUtil.set(ao));
  }

  public void addBandRoleOffer(final BandRole br) {

    VDMSet newOffers = Utils.copy(((VDMSet) Utils.get(bandRoleOffers, br.getRole())));
    VDMMap newMap = null;
    newOffers = SetUtil.union(Utils.copy(newOffers), SetUtil.set(br));
    newMap = MapUtil.map(new Maplet(br.getRole(), Utils.copy(newOffers)));
    bandRoleOffers = MapUtil.override(Utils.copy(bandRoleOffers), Utils.copy(newMap));
  }

  public void addRoadieOffer(final RoadieOffer oo) {

    VDMSet newOffers = SetUtil.set();
    VDMMap newInMap = null;
    if (SetUtil.inSet(oo.getTask(), MapUtil.dom(Utils.copy(roadieOffers)))) {
      newOffers = Utils.copy(((VDMSet) Utils.get(roadieOffers, oo.getTask())));
    }

    newOffers = SetUtil.union(Utils.copy(newOffers), SetUtil.set(oo));
    newInMap = MapUtil.map(new Maplet(oo.getTask(), Utils.copy(newOffers)));
    roadieOffers = MapUtil.override(Utils.copy(roadieOffers), Utils.copy(newInMap));
  }

  public void addPlaceOffer(final PlaceOffer po) {

    placeOffers = SetUtil.union(Utils.copy(placeOffers), SetUtil.set(po));
  }

  public void addHireBandOffer(final HireBand hb) {

    hireBandOffers = SetUtil.union(Utils.copy(hireBandOffers), SetUtil.set(hb));
  }

  public void addGig(final Gig g) {

    gigs = SetUtil.union(Utils.copy(gigs), SetUtil.set(g));
  }

  public static void addPlace(final Place p) {

    places = SeqUtil.conc(Utils.copy(AdvertisingBoard.places), SeqUtil.seq(p));
  }

  public String toString() {

    return "AdvertisingBoard{"
        + "artistOffers := "
        + Utils.toString(artistOffers)
        + ", bandRoleOffers := "
        + Utils.toString(bandRoleOffers)
        + ", roadieOffers := "
        + Utils.toString(roadieOffers)
        + ", placeOffers := "
        + Utils.toString(placeOffers)
        + ", hireBandOffers := "
        + Utils.toString(hireBandOffers)
        + ", gigs := "
        + Utils.toString(gigs)
        + ", places := "
        + Utils.toString(places)
        + "}";
  }
}
