package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CelloQuote {
  private static int hc = 0;
  private static CelloQuote instance = null;

  public CelloQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static CelloQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new CelloQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof CelloQuote;
  }

  public String toString() {

    return "<Cello>";
  }
}
