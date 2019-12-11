package myMenu;

import java.io.IOException;

public class Menu implements InterfaceMenu {
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

        Menu mainMenu = new Menu();

        while (true) {
            mainMenu.printMenu(mainMenu, templateMenu, menuSize);
            Button button = new Button(System.in.read());
            System.in.read();
            button.pressMainMenu(mainMenu);
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
