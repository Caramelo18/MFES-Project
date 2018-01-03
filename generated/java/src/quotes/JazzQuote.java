package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class JazzQuote {
  private static int hc = 0;
  private static JazzQuote instance = null;

  public JazzQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static JazzQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new JazzQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof JazzQuote;
  }

  public String toString() {

    return "<Jazz>";
  }
}
