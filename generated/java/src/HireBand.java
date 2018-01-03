
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class HireBand implements Offer {
  private EventOrganizer eventOrganizer;
  private String location;
  private JyveUtils.Date date;

  public void cg_init_HireBand_1(final EventOrganizer e, final String l, final JyveUtils.Date d) {

    eventOrganizer = e;
    location = l;
    date = Utils.copy(d);
    return;
  }

  public HireBand(final EventOrganizer e, final String l, final JyveUtils.Date d) {

    cg_init_HireBand_1(e, l, Utils.copy(d));
  }

  public HireBand() {}

  public String toString() {

    return "HireBand{"
        + "eventOrganizer := "
        + Utils.toString(eventOrganizer)
        + ", location := "
        + Utils.toString(location)
        + ", date := "
        + Utils.toString(date)
        + "}";
  }
}
