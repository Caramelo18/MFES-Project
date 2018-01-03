
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class EventOrganizer extends Profile {
  public void cg_init_EventOrganizer_1(final String n) {

    name = n;
    return;
  }

  public EventOrganizer(final String n) {

    cg_init_EventOrganizer_1(n);
  }

  public EventOrganizer() {}

  public String toString() {

    return "EventOrganizer{"
    	+ "name := "
    	+  name + " }";
  }
}
