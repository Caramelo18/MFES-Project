package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SaxophoneQuote {
  private static int hc = 0;
  private static SaxophoneQuote instance = null;

  public SaxophoneQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static SaxophoneQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new SaxophoneQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof SaxophoneQuote;
  }

  public String toString() {

    return "<Saxophone>";
  }
}
