import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CommonSwitch {

    public CommonSwitch() {
        this.set = new HashSet<Integer>();
        this.isTurnedOn = true;
    }

    Set<Integer> set = new HashSet<Integer>();
    static boolean isTurnedOn = true;

    public boolean isTurnedOn() {
        return isTurnedOn;
    }

    public void setIsTurnedOff() {
        isTurnedOn = false;
    }

}