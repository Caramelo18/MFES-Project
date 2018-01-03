
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PlaceOwner extends Profile {
  public void cg_init_PlaceOwner_1(final String n) {

    name = n;
    return;
  }

  public PlaceOwner(final String n) {

    cg_init_PlaceOwner_1(n);
  }

  public PlaceOwner() {}

  public String toString() {

    return "PlaceOwner{ name := " + name + " }";
  }
}
