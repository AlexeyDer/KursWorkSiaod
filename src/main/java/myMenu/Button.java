package myMenu;

import KursWork.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Button extends Menu {
    private char ch;
    private int code;

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

    public boolean pressChoiceMenu(Menu menu) throws IOException {
        Scanner scanner = new Scanner(System.in);
        upOrDown(menu, ch, choiceMenuSize);

        if ('q' == ch) {
            switch (menu.getMenuIndex()) {
                case 0:
                    if (getDb() != null) {
                        List<People> findList = null;

                        while (true) {
                            System.out.print("\n\nВведите сумму вклада:\n ");
                            int c = scanner.nextInt();

                            findList = getDb().binSearch(getSortList(), c);
                            if (findList != null) {
                                getDb().print(findList);
                                break;
                            } else
                                System.out.println("Нет такой суммы, попробуйте еще раз!");

                        }
                    } else {
                        System.out.println("База данных пуста!");
                        System.out.println("------------------");
                    }

                    return false;
                case 1:
                    // Строим АВЛ дерево

                    if (getDb() != null) {
                        List<People> findList = null;

                        while (true) {
                            System.out.print("\n\nВведите сумму вклада:\n ");
                            int c = scanner.nextInt();

                            findList = getDb().binSearch(getSortList(), c);
                            if (findList != null)
                                break;
                            else {
                                System.out.println("Нет такой суммы, попробуйте еще раз!");
                                System.out.println("------------------------------------");
                            }
                        }

                        setAvl(new AVL());
                        for (int i = 0; i < findList.size(); i++) {
                            getAvl().root = getAvl().insert(getAvl().root, findList.get(i));
                        }
                    } else {
                        System.out.println("База данных пуста!");
                        System.out.println("-------------------");
                    }
                    return false;
                case 2:
                    // Выводим дерево
                    if (getAvl() != null) {
                        System.out.println("Вывод дерева: ");
                        getAvl().print(getAvl().root);
                    } else {
                        System.out.println("Сначала постройте дерево");
                        System.out.println("------------------------");
                    }
                    return false;
                case 3:
                    if (getAvl() != null) {
                        System.out.println("Поиск в дереве, введите фио вкладчика: ");
                        while (true) {
                            Vertex p = getAvl().search(getAvl().root, scanner.nextLine());

                            if (p == null) {
                                System.out.println("Попробуйте еще раз!");
                                System.out.println("-------------------");
                            } else {
                                getDb().printOneElement(p);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Сначала постройти дерево!");
                        System.out.println("-------------------------");
                    }
                    return false;

                case 4:
                    // Выход назад

                    return true;
            }

        }
        return false;
    }

    public void pressMainMenu(Menu mainMenu) throws IOException {
        upOrDown(mainMenu, ch, menuSize);

        if ('q' == ch) {
            switch (mainMenu.getMenuIndex()) {
                case 0:
                    //Считывание бд
                    if (getDb() == null) {
                        System.out.println("База считалась");
                        setDb(new DataBase());
                        getDb().read("testBase3.dat");
                    } else {
                        System.out.println("База данных уже была считанна!");
                        System.out.println("-----------------------------");
                    }
                    break;
                case 1:
                    // Сортируем нашу дб
                    MergeSort mergeSort = new MergeSort();

                    if (getDb() != null) {
                        setSortList(mergeSort.sort(getDb().getPeoples()));
                    } else {
                        System.out.println("База данных пуста");
                        System.out.println("------------------");
                    }
                    break;
                case 2:
                    //Вывод БД
                    try {
                        getDb().print(getDb().getPeoples());
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("База данных пуста");
                        System.out.println("------------------");
                    }
                    break;

                case 3:
                    //Вывод отсортированную БД
                    if (getSortList() == null) {
                        System.out.println("База данных не отсортированна!");
                        System.out.println("------------------------------");
                        break;
                    }
                    getDb().print(getSortList());
                    break;

                case 4:
                    // Поиск по сумме вклада
                    Menu menuSettings = new Menu(choiceMenuSize);

                    while (true) {
                        menuSettings.printMenu(menuSettings, menuSettings.choiceMenu, menuSettings.choiceMenuSize);
                        Button button = new Button(System.in.read());
                        System.in.read();
                        if (button.pressChoiceMenu(menuSettings))
                            break;
                    }

                    break;

                case 5:
                    //Кодирование

                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
