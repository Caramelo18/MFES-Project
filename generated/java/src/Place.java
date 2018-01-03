
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Place {
  protected PlaceOwner placeOwner;
  protected String location;
  protected Number stageArea;

  public void cg_init_Place_1(final PlaceOwner po, final String l, final Number sa) {

    placeOwner = po;
    location = l;
    stageArea = sa;
    return;
  }

  public Place(final PlaceOwner po, final String l, final Number sa) {

    cg_init_Place_1(po, l, sa);
  }

  public void changeStageArea(final Number nsa) {

    stageArea = nsa;
  }

  public Number getStageArea() {

    return stageArea;
  }

  public Place() {}

  public String toString() {

    return "Place{"
        + "placeOwner := "
        + Utils.toString(placeOwner)
        + ", location := "
        + Utils.toString(location)
        + ", stageArea := "
        + Utils.toString(stageArea)
        + "}";
  }
}
