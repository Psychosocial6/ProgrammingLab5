package comparators;

import java.util.Comparator;

public class EnginePowerComparator implements Comparator<Long> {
    @Override
    public int compare(Long o1, Long o2) {
        return o1.compareTo(o2);
    }
}
