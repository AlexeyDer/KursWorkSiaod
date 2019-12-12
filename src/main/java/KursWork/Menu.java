package KursWork;

import myMenu.Button;
import myMenu.InterfaceMenu;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu implements InterfaceMenu {
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
    }


    public static void main(String[] args) throws IOException {
        // Создаем меню
        Menu mainMenu = new Menu();

        //Считывание бд
        DataBase db = new DataBase();
        AVL avl = new AVL();
        try {
            db.read("testBase3.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<People> sortList = db.getPeoples();

        while (true) {
            // Выводим наше меню
            mainMenu.printMenu(mainMenu, templateMenu, menuSize);

            // Перемещаемся к нужному нам пункту
            Button button = new Button(System.in.read());
            System.in.read();

            sortList = button.pressMainMenu(mainMenu, db, avl, sortList);
        }

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
