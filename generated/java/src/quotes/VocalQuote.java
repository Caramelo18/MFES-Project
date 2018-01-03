package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class VocalQuote {
  private static int hc = 0;
  private static VocalQuote instance = null;

  public VocalQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static VocalQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new VocalQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof VocalQuote;
  }

  public String toString() {

    return "<Vocal>";
  }
}
