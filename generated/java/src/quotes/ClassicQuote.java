package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ClassicQuote {
  private static int hc = 0;
  private static ClassicQuote instance = null;

  public ClassicQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ClassicQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ClassicQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ClassicQuote;
  }

  public String toString() {

    return "<Classic>";
  }
}
