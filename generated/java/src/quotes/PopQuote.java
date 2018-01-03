package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PopQuote {
  private static int hc = 0;
  private static PopQuote instance = null;

  public PopQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static PopQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new PopQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof PopQuote;
  }

  public String toString() {

    return "<Pop>";
  }
}
