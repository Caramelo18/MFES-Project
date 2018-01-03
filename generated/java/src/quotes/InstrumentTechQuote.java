package quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class InstrumentTechQuote {
  private static int hc = 0;
  private static InstrumentTechQuote instance = null;

  public InstrumentTechQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static InstrumentTechQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new InstrumentTechQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof InstrumentTechQuote;
  }

  public String toString() {

    return "<InstrumentTech>";
  }
}
