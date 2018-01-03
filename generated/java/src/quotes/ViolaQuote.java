package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ViolaQuote {
  private static int hc = 0;
  private static ViolaQuote instance = null;

  public ViolaQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ViolaQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ViolaQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ViolaQuote;
  }

  public String toString() {

    return "<Viola>";
  }
}
