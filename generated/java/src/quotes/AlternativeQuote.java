package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class AlternativeQuote {
  private static int hc = 0;
  private static AlternativeQuote instance = null;

  public AlternativeQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static AlternativeQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new AlternativeQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof AlternativeQuote;
  }

  public String toString() {

    return "<Alternative>";
  }
}
