package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class DrumsQuote {
  private static int hc = 0;
  private static DrumsQuote instance = null;

  public DrumsQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static DrumsQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new DrumsQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof DrumsQuote;
  }

  public String toString() {

    return "<Drums>";
  }
}
