
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class BandRole implements Offer {
  private Band band_role_offer;
  private Object desired_role;

  public void cg_init_BandRole_1(final Band b, final Object d) {

    band_role_offer = b;
    desired_role = d;
    return;
  }

  public BandRole(final Band b, final Object d) {

    cg_init_BandRole_1(b, d);
  }

  public Object getRole() {

    return desired_role;
  }

  public BandRole() {}

  public String toString() {

    return "BandRole{"
        + "band_role_offer := "
        + Utils.toString(band_role_offer)
        + ", desired_role := "
        + Utils.toString(desired_role)
        + "}";
  }
}
