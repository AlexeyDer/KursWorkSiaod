import java.io.*;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        MergeSort mergeSort = new MergeSort();
        DataBase db = new DataBase();
        db.read("testBase3.dat");

        List<People> sortList = db.getPeoples();
        sortList = mergeSort.sort(sortList);
        db.print(sortList);


       // db.print();
    }
}
