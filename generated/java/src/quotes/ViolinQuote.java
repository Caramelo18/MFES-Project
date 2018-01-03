package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ViolinQuote {
  private static int hc = 0;
  private static ViolinQuote instance = null;

  public ViolinQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ViolinQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ViolinQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ViolinQuote;
  }

  public String toString() {

    return "<Violin>";
  }
}
