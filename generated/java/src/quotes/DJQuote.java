package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class DJQuote {
  private static int hc = 0;
  private static DJQuote instance = null;

  public DJQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static DJQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new DJQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof DJQuote;
  }

  public String toString() {

    return "<DJ>";
  }
}
