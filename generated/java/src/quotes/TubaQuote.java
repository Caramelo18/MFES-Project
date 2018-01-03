package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class TubaQuote {
  private static int hc = 0;
  private static TubaQuote instance = null;

  public TubaQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static TubaQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new TubaQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof TubaQuote;
  }

  public String toString() {

    return "<Tuba>";
  }
}
