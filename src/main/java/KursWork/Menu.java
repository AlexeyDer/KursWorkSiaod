package KursWork;

import myMenu.Button;
import myMenu.InterfaceMenu;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Menu implements InterfaceMenu {
    private DataBase db;
    private List<People> sortList;
    private AVL avl;

    // Поля для меню
    private int menuIndex;
    private String[] menu;


    public Menu(int amountItems) {
        this.menu = new String[amountItems];
        this.menuIndex = 0;
    }

    public Menu() {
        this.menu = new String[menuSize];
        this.menuIndex = 0;
        avl = null;
        db = null;
        sortList = null;
    }


    public static void main(String[] args) throws IOException {
        // Создаем меню
        Menu mainMenu = new Menu();

        while (true) {
            // Выводим наше меню
            mainMenu.printMenu(mainMenu, templateMenu, menuSize);

            // Перемещаемся к нужному нам пункту
            Button button = new Button(System.in.read());
            System.in.read();

            button.pressMainMenu(mainMenu);
        }

    }

    public AVL getAvl() {
        return avl;
    }

    public void setAvl(AVL avl) {
        this.avl = avl;
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
