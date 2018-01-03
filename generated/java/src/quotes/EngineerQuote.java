package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class EngineerQuote {
  private static int hc = 0;
  private static EngineerQuote instance = null;

  public EngineerQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static EngineerQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new EngineerQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof EngineerQuote;
  }

  public String toString() {

    return "<Engineer>";
  }
}
