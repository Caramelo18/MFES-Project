package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ManagerQuote {
  private static int hc = 0;
  private static ManagerQuote instance = null;

  public ManagerQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ManagerQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ManagerQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ManagerQuote;
  }

  public String toString() {

    return "<Manager>";
  }
}
