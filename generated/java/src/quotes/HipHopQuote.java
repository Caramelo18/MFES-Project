package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class HipHopQuote {
  private static int hc = 0;
  private static HipHopQuote instance = null;

  public HipHopQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static HipHopQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new HipHopQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof HipHopQuote;
  }

  public String toString() {

    return "<HipHop>";
  }
}
