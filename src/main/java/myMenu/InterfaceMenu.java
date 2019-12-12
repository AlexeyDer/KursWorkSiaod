package myMenu;

import KursWork.Menu;

public interface InterfaceMenu {
    public final int menuSize = 5;
    public final String templateMenu[] = {
            "Просмотр базы данных", "Сортировка базы данных",
            "Бинарный поиск", "Кодирование", "Завершить программу"
    };


    public final int choiceMenuSize = 3;
    public final String choiceMenu[] = {
            "Вывести дерево поиска", "Поиcк по дереву", "Вернуться назад"
    };

    public default void printMenu(Menu menu, String[] notes, int size) {
        for (int i = 0; i < size; i++) {
            if (i == menu.getMenuIndex())
                System.out.printf("=> ");
            else
                System.out.printf("%d ", i + 1);

            System.out.println(notes[i]);
        }
    }

}
