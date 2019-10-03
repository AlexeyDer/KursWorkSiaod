import java.util.Comparator;

public class PeopleDataComparator implements Comparator<People> {

    public int compare(People a, People b) {
        if (a.getDate().compareTo(b.getDate())  < 0)
            return 1;
        else if (a.getDate().compareTo(b.getDate())  < 0)
            return -1;
        else
            return 0;
    }



}
