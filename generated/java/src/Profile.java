
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Profile {
  protected String name;

  public void cg_init_Profile_1(final String n) {

    name = n;
    return;
  }

  public Profile(final String n) {

    cg_init_Profile_1(n);
  }

  public void changeName(final String nn) {

    name = nn;
  }

  public String getName() {

    return name;
  }

  public Profile() {}

  public String toString() {

    return "Profile{" + "name := " + Utils.toString(name) + "}";
  }
}
