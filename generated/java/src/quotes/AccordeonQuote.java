package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class AccordeonQuote {
  private static int hc = 0;
  private static AccordeonQuote instance = null;

  public AccordeonQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static AccordeonQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new AccordeonQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof AccordeonQuote;
  }

  public String toString() {

    return "<Accordeon>";
  }
}
