
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Roadie extends Profile {
  private Object task;

  public void cg_init_Roadie_1(final String n, final Object t) {

    name = n;
    task = t;
    return;
  }

  public Roadie(final String n, final Object t) {

    cg_init_Roadie_1(n, t);
  }

  public void setTask(final Object nt) {

    task = nt;
  }

  public Object getTask() {

    return task;
  }

  public Roadie() {}

  public String toString() {

    return "Roadie{" 
        	+ "name := "
        	+  name + " task := " + Utils.toString(task) + "}";
  }
}
