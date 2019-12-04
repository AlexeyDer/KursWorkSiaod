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
        while (true) {
            int c = scanner.nextInt();
            List<People> findList = db.binSearch(sortList, c);

            if (findList != null) {
                db.print(findList);

                AVL avl = new AVL();
                for (int i = 0; i < findList.size(); i++) {
                    avl.root = avl.insert(avl.root, findList.get(i));
                }

                System.in.read();
                System.out.println("Вывод дерева: ");
                avl.print(avl.root);

                System.out.println("Поиск в дереве, введите фио вкладчика: ");
                while (true) {
                    Vertex p = avl.search(avl.root, scanner.nextLine());

                    if (p == null){
                        System.out.println("Попробуйте еще раз!");
                    } else {
                        db.printOneElement(p);
                        break;
                    }
                }

                break;
            }
            else
                System.out.println("Таких объектов нет, попробуйте еще раз!");
        }









    }
}
