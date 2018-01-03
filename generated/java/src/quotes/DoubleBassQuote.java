package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class DoubleBassQuote {
  private static int hc = 0;
  private static DoubleBassQuote instance = null;

  public DoubleBassQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static DoubleBassQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new DoubleBassQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof DoubleBassQuote;
  }

  public String toString() {

    return "<DoubleBass>";
  }
}
