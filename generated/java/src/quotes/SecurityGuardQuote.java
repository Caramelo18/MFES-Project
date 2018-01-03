package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SecurityGuardQuote {
  private static int hc = 0;
  private static SecurityGuardQuote instance = null;

  public SecurityGuardQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static SecurityGuardQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new SecurityGuardQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof SecurityGuardQuote;
  }

  public String toString() {

    return "<SecurityGuard>";
  }
}
