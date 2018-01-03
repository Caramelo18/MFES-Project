
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class JyveUtils {
  public JyveUtils() {}

  public static Number daysOfMonth(final Number month) {

    if (SetUtil.inSet(month, SetUtil.set(1L, 3L, 5L, 7L, 8L, 10L, 12L))) {
      return 31L;

    } else {
      if (Utils.equals(month, 2L)) {
        return 28L;

      } else {
        return 30L;
      }
    }
  }

  public String toString() {

    return "JyveUtils{}";
  }

  public static class Date implements Record {
    public Number year;
    public Number month;
    public Number day;

    public Date(final Number _year, final Number _month, final Number _day) {

      year = _year;
      month = _month;
      day = _day;
    }

    public boolean equals(final Object obj) {

      if (!(obj instanceof Date)) {
        return false;
      }

      Date other = ((Date) obj);

      return (Utils.equals(year, other.year))
          && (Utils.equals(month, other.month))
          && (Utils.equals(day, other.day));
    }

    public int hashCode() {

      return Utils.hashCode(year, month, day);
    }

    public Date copy() {

      return new Date(year, month, day);
    }

    public String toString() {

      return "mk_JyveUtils`Date" + Utils.formatFields(year, month, day);
    }
  }

  public static Boolean inv_Date(final Date d) {

    Boolean andResult_18 = false;

    if (d.year.longValue() <= 2050L) {
      Boolean andResult_19 = false;

      if (d.year.longValue() >= 2015L) {
        Boolean andResult_20 = false;

        if (d.month.longValue() <= 12L) {
          if (d.day.longValue() <= daysOfMonth(d.month).longValue()) {
            andResult_20 = true;
          }
        }

        if (andResult_20) {
          andResult_19 = true;
        }
      }

      if (andResult_19) {
        andResult_18 = true;
      }
    }

    return andResult_18;
  }
}
