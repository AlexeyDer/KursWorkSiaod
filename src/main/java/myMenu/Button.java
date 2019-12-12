package myMenu;

import Coding.Crypto;
import Coding.ShanonCode;
import KursWork.*;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Button extends Menu {
    private char ch;
    private int code;
    private static boolean flag = false;


    public Button() {
        this.code = 0;
        this.ch = (char) code;
    }

    public Button(int code) throws IOException {
        this.code = code;
        this.ch = (char) code;
    }

    public void upOrDown(Menu mainMenu, char ch, int size) {
        if ('s' == ch) {
            if (mainMenu.getMenuIndex() < size - 1)
                mainMenu.setMenuIndex(mainMenu.getMenuIndex() + 1);
        }
        if ('w' == ch) {
            if (mainMenu.getMenuIndex() > 0)
                mainMenu.setMenuIndex(mainMenu.getMenuIndex() - 1);
        }
    }

    public boolean pressChoiceMenu(Menu menu, List<People> findList, AVL avl, DataBase db) throws IOException {
        Scanner scanner = new Scanner(System.in);
        upOrDown(menu, ch, choiceMenuSize);

        if ('q' == ch) {
            switch (menu.getMenuIndex()) {
                case 0:
                    //
                    if (avl.root == null) {
                        for (int i = 0; i < findList.size(); i++) {
                            avl.root = avl.insert(avl.root, findList.get(i));
                        }
                    }
                    avl.print(avl.root);
                    break;
                case 1:
                    if (avl.root != null) {
                        System.out.println("---------------------------------------");
                        System.out.println("Поиск в дереве, введите фио вкладчика: ");
                        while (true) {
                            Vertex p = avl.search(avl.root, scanner.nextLine());

                            if (p == null) {
                                System.out.println("Попробуйте еще раз!");
                                System.out.println("-------------------");
                            } else {
                                db.printOneElement(p);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Сначала постройте дерево!");
                        System.out.println("------------------------");
                    }
                    break;
                case 2:
                    return true;
            }

        }
        return false;
    }

    public List<People> pressMainMenu(Menu mainMenu, DataBase db, AVL avl, List<People> sortList) throws IOException {
        upOrDown(mainMenu, ch, menuSize);

        if ('q' == ch) {
            switch (mainMenu.getMenuIndex()) {
                case 0:
                    // Вывод база данных
                    db.print(sortList);
                    break;
                case 1:
                    // Сортируем нашу дб
                    MergeSort mergeSort = new MergeSort();
                    sortList = mergeSort.sort(db.getPeoples());
                    // Запоминаем что дб отсортированна
                    flag = true;
                    return sortList;
                case 2:
                    // BinSearch
                    if (flag) {
                        List<People> findList = null;
                        Scanner sc = new Scanner(System.in);

                        while (true) {
                            System.out.print("\n\nВведите сумму вклада, по которой будет выполнен поиск:\n ");
                            int c = sc.nextInt();

                            findList = db.binSearch(sortList, c);
                            if (findList != null) {
                                db.print(findList);
                                break;
                            } else {
                                System.out.println("Нет такой суммы, попробуйте еще раз!");
                                System.out.println("------------------------------------");
                            }
                        }

                        // Менюшка для дерева

                        Menu menuSettings = new Menu(choiceMenuSize);


                        while (true) {
                            menuSettings.printMenu(menuSettings, menuSettings.choiceMenu, menuSettings.choiceMenuSize);
                            Button button = new Button(System.in.read());
                            System.in.read();
                            if (button.pressChoiceMenu(menuSettings, findList, avl, db))
                                break;
                        }

                    } else {
                        System.out.println("Сначала отсортируйте базу данных!");
                        System.out.println("---------------------------------");
                    }
                    break;
                case 3:
                    // Кодирование
                    ShanonCode coding = new ShanonCode();
                    String text = "";
                    List<Crypto> cryptos = new LinkedList<>();

                    for (People i : db.getPeoples()) {
                        text += i.getFioVklad();
                        text += i.getSum() + " ";
                        text += i.getDate();
                        text += i.getFioAdv();
                    }
             //       text.toLowerCase((new Locale("ru")));
                    cryptos = coding.fillAlphabet(cryptos, text);
                    cryptos = coding.SelectSort(cryptos);
                    cryptos = coding.shennon(cryptos);

                    String finalCode = "";

                    for (int i = 0; i < text.length(); i++) {
                        for (int j = 1; j < cryptos.size(); j++) {
                            if (text.charAt(i) == cryptos.get(j).getCharacter()) {
                                finalCode += cryptos.get(j).getCodeCharacter();
                                break;
                            }
                        }
                    }

                    for (int i = 1; i < cryptos.size(); i++) {
                        System.out.println(cryptos.get(i).getCharacter() + " " + cryptos.get(i).getP() + " " +
                                cryptos.get(i).getCodeCharacter());
                    }

                    System.out.println("\n\n" + finalCode);



                    break;

                case 4:
                    System.exit(0);
            }
        }
        return sortList;
    }


}
