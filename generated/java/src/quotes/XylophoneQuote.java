package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class XylophoneQuote {
  private static int hc = 0;
  private static XylophoneQuote instance = null;

  public XylophoneQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static XylophoneQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new XylophoneQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof XylophoneQuote;
  }

  public String toString() {

    return "<Xylophone>";
  }
}
