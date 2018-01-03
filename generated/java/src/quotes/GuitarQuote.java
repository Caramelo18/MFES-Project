package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class GuitarQuote {
  private static int hc = 0;
  private static GuitarQuote instance = null;

  public GuitarQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static GuitarQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new GuitarQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof GuitarQuote;
  }

  public String toString() {

    return "<Guitar>";
  }
}
