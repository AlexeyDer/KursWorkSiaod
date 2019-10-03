import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.lang.String;

public class MergeSort {
    private Comparator<People> pdc = new PeopleDataComparator().thenComparing(new PeopleSumComparator());

    public static List<People> sort(List<People> peoples) {
        if (peoples.size() < 2) {
            return peoples;
        }
        int mid = peoples.size() / 2;

        return merge(
                sort(peoples.subList(0, mid)),
                sort(peoples.subList(mid, peoples.size()))
        );

    }


    private static List<People> merge(List<People> left, List<People> right) {
        int leftIndex = 0;
        int rightIndex = 0;
        List <People> merge = new ArrayList<>();

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if  (compareSum(left.get(leftIndex), right.get(rightIndex)) < 0)
                    merge.add(left.get(leftIndex++));
            else {
                 if (compareSum(left.get(leftIndex), right.get(rightIndex)) > 0)
                    merge.add(right.get(rightIndex++));
                 else if (compareData(left.get(leftIndex), right.get(rightIndex)) < 0)
                     merge.add(left.get(leftIndex++));
                        else
                            merge.add(right.get(rightIndex++));
            }
        }

        merge.addAll(left.subList(leftIndex, left.size()));
        merge.addAll(right.subList(rightIndex, right.size()));
        return merge;
    }

    public static int compareSum(People a, People b) {
        if (a.getSum() > b.getSum())
            return 1;
        else if (a.getSum() < b.getSum())
            return -1;
        else
            return 0;
    }

    public static int compareData(People a, People b) {
        if (a.getDate().compareTo(b.getDate())  < 0)
            return 1;
        else if (a.getDate().compareTo(b.getDate())  < 0)
            return -1;
        else
            return 0;
    }

}
