
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Artist extends Profile {
  private VDMSet instruments;

  public void cg_init_Artist_1(final String n) {

    name = n;
    instruments = SetUtil.set();
    return;
  }

  public Artist(final String n) {

    cg_init_Artist_1(n);
  }

  public void addInstrument(final Object i) {

    instruments = SetUtil.union(Utils.copy(instruments), SetUtil.set(i));
  }

  public void deleteInstrument(final Object i) {

    instruments = SetUtil.diff(Utils.copy(instruments), SetUtil.set(i));
  }

  public Boolean playsInstrument(final Object i) {

    return SetUtil.inSet(i, instruments);
  }

  public Artist() {}

  public String toString() {

    return "Artist{ name := " + name  + ", instruments := " + Utils.toString(instruments) + "}";
  }
}
