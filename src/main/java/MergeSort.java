import java.util.ArrayList;
import java.util.List;
import java.lang.String;

public class MergeSort {
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
        List<People> merge = new ArrayList<>();

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (
                    (left.get(leftIndex).getSum() < right.get(rightIndex).getSum()) )
//                            &&
//                            (left.get(leftIndex).getDate().compareTo(right.get(rightIndex).getDate()) < 0))
            {
                merge.add(left.get(leftIndex++));
            } else {
                merge.add(right.get(rightIndex++));
            }
        }

        merge.addAll(left.subList(leftIndex, left.size()));
        merge.addAll(right.subList(rightIndex, right.size()));
        return merge;
    }

}
