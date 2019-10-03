import java.util.Comparator;

public class PeopleSumComparator implements Comparator<People> {

    public int compare(People a, People b) {
        if (a.getSum() > b.getSum())
            return 1;
        else if (a.getSum() < b.getSum())
            return -1;
        else
            return 0;
    }

}
