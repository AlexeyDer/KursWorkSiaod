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
//        db.print(sortList);


        AVL avl = new AVL();
        for (int i = 0; i < sortList.size(); i++) {
            avl.root = avl.insert(avl.root, sortList.get(i));
        }

        avl.print(avl.root);


//        System.out.print("\n\nПоиске по сумме:\n ");
//        while (true) {
//            int c = scanner.nextInt();
//            List<People> findList = db.binSearch(sortList, c);
//
//            if (!findList.isEmpty()) {
//                db.print(findList);
//                break;
//            }
//            else
//                System.out.println("Таких объектов нет, попробуйте еще раз!");
//        }



       // db.print();
    }
}
