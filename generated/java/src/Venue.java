
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Venue extends Place {
  private Number capacity;
  private String lighting;
  private String sound;
  public VDMSet gigs;

  public void cg_init_Venue_1(
      final PlaceOwner po,
      final String loc,
      final Number sa,
      final Number cap,
      final String lig,
      final String s) {

    placeOwner = po;
    location = loc;
    stageArea = sa;
    capacity = cap;
    lighting = lig;
    sound = s;
    gigs = SetUtil.set();
    AdvertisingBoard.addPlace(this);
    return;
  }

  public Venue(
      final PlaceOwner po,
      final String loc,
      final Number sa,
      final Number cap,
      final String lig,
      final String s) {

    cg_init_Venue_1(po, loc, sa, cap, lig, s);
  }

  public Boolean setGigs(final VDMSet g) {

    gigs = Utils.copy(g);
    return true;
  }

  public void changeCapacity(final Number nc) {

    capacity = nc;
  }

  public void changeLighting(final String nl) {

    lighting = nl;
  }

  public void changeSound(final String ns) {

    sound = ns;
  }

  public Number getCapacity() {

    return capacity;
  }

  public String getLighting() {

    return lighting;
  }

  public String getSound() {

    return sound;
  }

  public Boolean isAvailable(final JyveUtils.Date date) {

    for (Iterator iterator_12 = gigs.iterator(); iterator_12.hasNext(); ) {
      Gig gig = (Gig) iterator_12.next();
      if (Utils.equals(gig.getDate(), date)) {
        return false;
      }
    }
    return true;
  }

  public Venue() {}

  public String toString() {

    return "Venue{"
        + "capacity := "
        + Utils.toString(capacity)
        + ", lighting := "
        + Utils.toString(lighting)
        + ", sound := "
        + Utils.toString(sound)
        + ", gigs := "
        + Utils.toString(gigs)
        + "}";
  }
}
