package KursWork;

import myMenu.Button;
import myMenu.InterfaceMenu;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Menu implements InterfaceMenu {
    private DataBase db;
    private List<People> sortList;

    // Поля для меню
    private int menuIndex;
    private String[] menu;

    {
        db = null;
        sortList = null;
    }

    public Menu(int amountItems) {
        this.menu = new String[amountItems];
        this.menuIndex = 0;
    }

    public Menu() {
        this.menu = new String[menuSize];
        this.menuIndex = 0;
    }


    public static void main(String[] args) throws IOException {
        // Создаем меню
        Menu mainMenu = new Menu();

        // И нужные нам классы
        Scanner scanner = new Scanner(System.in);



        while (true) {
            // Выводим наше меню
            mainMenu.printMenu(mainMenu, templateMenu, menuSize);

            // Перемещаемся к нужно нам пункту
            Button button = new Button(System.in.read());
            System.in.read();
            button.pressMainMenu(mainMenu);
        }


//
//        System.out.print("\n\nПоиске по сумме:\n ");
//        while (true) {
//            int c = scanner.nextInt();
//            List<People> findList = db.binSearch(sortList, c);
//
//            if (findList != null) {
//                db.print(findList);
//
//                AVL avl = new AVL();
//                for (int i = 0; i < findList.size(); i++) {
//                    avl.root = avl.insert(avl.root, findList.get(i));
//                }
//
//                System.in.read();
//                System.out.println("Вывод дерева: ");
//                avl.print(avl.root);
//
//                System.out.println("Поиск в дереве, введите фио вкладчика: ");
//                while (true) {
//                    Vertex p = avl.search(avl.root, scanner.nextLine());
//
//                    if (p == null){
//                        System.out.println("Попробуйте еще раз!");
//                    } else {
//                        db.printOneElement(p);
//                        break;
//                    }
//                }
//
//                break;
//            }
//            else
//                System.out.println("Таких объектов нет, попробуйте еще раз!");
//        }
    }

    public DataBase getDb() {
        return db;
    }

    public void setDb(DataBase db) {
        this.db = db;
    }

    public List<People> getSortList() {
        return sortList;
    }

    public void setSortList(List<People> sortList) {
        this.sortList = sortList;
    }

    public String[] getMenu() {
        return menu;
    }

    public void setMenu(String[] menu) {
        this.menu = menu;
    }

    public int getMenuIndex() {
        return menuIndex;
    }

    public void setMenuIndex(int menuIndex) {
        this.menuIndex = menuIndex;
    }
}
