
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ArtistOffer implements Offer {
  private Artist artist;

  public void cg_init_ArtistOffer_1(final Artist a) {

    artist = a;
    return;
  }

  public ArtistOffer(final Artist a) {

    cg_init_ArtistOffer_1(a);
  }

  public Artist getArtist() {

    return artist;
  }

  public ArtistOffer() {}

  public String toString() {

    return "ArtistOffer{" + "artist := " + Utils.toString(artist) + "}";
  }
}
