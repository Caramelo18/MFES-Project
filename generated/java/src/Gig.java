
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Gig {
  private VDMSet performingBands;
  private Venue venue;
  private JyveUtils.Date date;

  public void cg_init_Gig_1(final Venue v, final JyveUtils.Date d) {

    Boolean result = false;
    VDMSet venueGigs = v.gigs;
    venueGigs = SetUtil.union(Utils.copy(venueGigs), SetUtil.set(this));
    performingBands = SetUtil.set();
    date = Utils.copy(d);
    Venue atomicTmp_1 = v;
    Boolean atomicTmp_2 = v.setGigs(Utils.copy(venueGigs));
    {
        /* Start of atomic statement */
      venue = atomicTmp_1;
      result = atomicTmp_2;
    } /* End of atomic statement */

    return;
  }

  public Gig(final Venue v, final JyveUtils.Date d) {

    cg_init_Gig_1(v, Utils.copy(d));
  }

  public Boolean addBand(final Band b) {

    Boolean complete = false;
    VDMSet bandGigs = b.gigs;
    bandGigs = SetUtil.union(Utils.copy(bandGigs), SetUtil.set(this));
    VDMSet atomicTmp_3 = SetUtil.union(Utils.copy(performingBands), SetUtil.set(b));
    Boolean atomicTmp_4 = b.setGigs(Utils.copy(bandGigs));
    {
        /* Start of atomic statement */
      performingBands = Utils.copy(atomicTmp_3);
      complete = atomicTmp_4;
    } /* End of atomic statement */

    return complete;
  }

  public JyveUtils.Date getDate() {

    return Utils.copy(date);
  }

  public Venue getVenue() {

    return venue;
  }

  public VDMSet getBands() {

    return Utils.copy(performingBands);
  }

  private Boolean bandIsConsistent() {

    Boolean forAllExpResult_3 = true;
    VDMSet set_3 = Utils.copy(performingBands);
    for (Iterator iterator_3 = set_3.iterator(); iterator_3.hasNext() && forAllExpResult_3; ) {
      Band pb = ((Band) iterator_3.next());
      forAllExpResult_3 = SetUtil.inSet(this, pb.gigs);
    }
    return forAllExpResult_3;
  }

  private Boolean venueIsConsistent() {

    return SetUtil.inSet(this, venue.gigs);
  }

  public Gig() {}

  public String toString() {

    return "Gig{"
        + "performingBands := "
        + Utils.toString(performingBands)
        + ", venue := "
        + Utils.toString(venue)
        + ", date := "
        + Utils.toString(date)
        + "}";
  }
}
