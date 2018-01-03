
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PlaceOffer implements Offer {
  private Place place;

  public void cg_init_PlaceOffer_1(final Place rp) {

    place = rp;
    return;
  }

  public PlaceOffer(final Place rp) {

    cg_init_PlaceOffer_1(rp);
  }

  public Place getPlace() {

    return place;
  }

  public PlaceOffer() {}

  public String toString() {

    return "PlaceOffer{" + "place := " + Utils.toString(place) + "}";
  }
}
