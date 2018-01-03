package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ReggaeQuote {
  private static int hc = 0;
  private static ReggaeQuote instance = null;

  public ReggaeQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ReggaeQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ReggaeQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ReggaeQuote;
  }

  public String toString() {

    return "<Reggae>";
  }
}
