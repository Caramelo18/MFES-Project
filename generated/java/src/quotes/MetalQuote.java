package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class MetalQuote {
  private static int hc = 0;
  private static MetalQuote instance = null;

  public MetalQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static MetalQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new MetalQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof MetalQuote;
  }

  public String toString() {

    return "<Metal>";
  }
}
