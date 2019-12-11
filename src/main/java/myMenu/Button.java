package myMenu;

import java.io.IOException;

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

    public boolean pressChoiceMenu(Menu menu) {
        upOrDown(menu, ch, choiceMenuSize);

        if ('q' == ch) {
            switch (menu.getMenuIndex()) {
                case 0:
                    System.out.println(0);
                    return true;
                case 1:
                    System.out.println(1);
                    return true;
                case 2:
                    System.out.println(2);
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
                    System.out.println("Вы в добавлении!");
                    break;
                case 1:
                    System.out.println("Вы в удалении!");
                    break;
                case 2:
                    System.out.println("Вы в печати");
                    break;
                case 3:
                    System.out.println("Вы в настройках!");

                    Menu menuSettings = new Menu(choiceMenuSize);

                    while (true) {
                        System.out.println("-------------------------------");
                        System.out.println("Сделать что-то ?");

                        menuSettings.printMenu(menuSettings, menuSettings.choiceMenu, menuSettings.choiceMenuSize);
                        Button button = new Button(System.in.read());

                        if (button.pressChoiceMenu(menuSettings))
                            break;
                        System.out.println("Упс, давайте еще раз!");
                    }


                    break;
                case 4:
                    System.exit(0);
            }
        }
    }
}
