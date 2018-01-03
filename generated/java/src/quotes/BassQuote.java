package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class BassQuote {
  private static int hc = 0;
  private static BassQuote instance = null;

  public BassQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static BassQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new BassQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof BassQuote;
  }

  public String toString() {

    return "<Bass>";
  }
}
