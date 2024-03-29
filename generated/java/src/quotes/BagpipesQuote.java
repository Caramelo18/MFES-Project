package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class BagpipesQuote {
  private static int hc = 0;
  private static BagpipesQuote instance = null;

  public BagpipesQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static BagpipesQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new BagpipesQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof BagpipesQuote;
  }

  public String toString() {

    return "<Bagpipes>";
  }
}
