
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Band extends Profile {
  private VDMSet genres;
  public VDMSet gigs;

  public void cg_init_Band_1(final String n) {

    name = n;
    genres = SetUtil.set();
    gigs = SetUtil.set();
    return;
  }

  public Band(final String n) {

    cg_init_Band_1(n);
  }

  public VDMSet getGenres() {

    return Utils.copy(genres);
  }

  public void addGenre(final Object g) {

    genres = SetUtil.union(Utils.copy(genres), SetUtil.set(g));
  }

  public void deleteGenre(final Object g) {

    genres = SetUtil.diff(Utils.copy(genres), SetUtil.set(g));
  }

  public VDMSet getGigs() {

    return Utils.copy(gigs);
  }

  public Boolean setGigs(final VDMSet g) {

    gigs = Utils.copy(g);
    return true;
  }

  public Band() {}

  public String toString() {

    return "Band{"
    	+ "name := "
    	+  name
        + " genres := "
        + Utils.toString(genres)
        + "}";
  }
}
