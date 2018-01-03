
import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Studio extends Place {
  private Boolean rehearsal;
  private Boolean recording;

  public void cg_init_Studio_1(
      final PlaceOwner po,
      final String loc,
      final Number sa,
      final Boolean reh,
      final Boolean rec) {

    placeOwner = po;
    location = loc;
    stageArea = sa;
    rehearsal = reh;
    recording = rec;
    AdvertisingBoard.addPlace(this);
    return;
  }

  public Studio(
      final PlaceOwner po,
      final String loc,
      final Number sa,
      final Boolean reh,
      final Boolean rec) {

    cg_init_Studio_1(po, loc, sa, reh, rec);
  }

  public void setRehearsal() {

    Boolean atomicTmp_5 = true;
    Boolean atomicTmp_6 = false;
    {
        /* Start of atomic statement */
      rehearsal = atomicTmp_5;
      recording = atomicTmp_6;
    } /* End of atomic statement */
  }

  public void setRecording() {

    Boolean atomicTmp_7 = false;
    Boolean atomicTmp_8 = true;
    {
        /* Start of atomic statement */
      rehearsal = atomicTmp_7;
      recording = atomicTmp_8;
    } /* End of atomic statement */
  }

  public Boolean isRehearsal() {

    return rehearsal;
  }

  public Boolean isRecording() {

    return recording;
  }

  public Studio() {}

  public String toString() {

    return "Studio{"
        + "rehearsal := "
        + Utils.toString(rehearsal)
        + ", recording := "
        + Utils.toString(recording)
        + "}";
  }
}
