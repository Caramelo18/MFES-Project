package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PianoQuote {
  private static int hc = 0;
  private static PianoQuote instance = null;

  public PianoQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static PianoQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new PianoQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof PianoQuote;
  }

  public String toString() {

    return "<Piano>";
  }
}
