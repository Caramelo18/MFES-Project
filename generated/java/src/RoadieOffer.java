
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class RoadieOffer implements Offer {
  private Band band;
  private Object task;

  public void cg_init_RoadieOffer_1(final Band b, final Object t) {

    band = b;
    task = t;
    return;
  }

  public RoadieOffer(final Band b, final Object t) {

    cg_init_RoadieOffer_1(b, t);
  }

  public Object getTask() {

    return task;
  }

  public RoadieOffer() {}

  public String toString() {

    return "RoadieOffer{"
        + "band := "
        + Utils.toString(band)
        + ", task := "
        + Utils.toString(task)
        + "}";
  }
}
