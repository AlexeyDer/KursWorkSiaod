import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        MergeSort mergeSort = new MergeSort();
        DataBase db = new DataBase();
        db.read("testBase3.dat");

        List<People> sortList = db.getPeoples();
        sortList = mergeSort.sort(sortList);
        db.print(sortList);

        System.out.print("\n\nПоиске по сумме:\n ");
        int c = scanner.nextInt();

        List<People> findList = db.binSearch(sortList, c);
        if (findList != null)
            db.print(findList);
        else
            System.out.println("Таких объекта нет");






       // db.print();
    }
}
