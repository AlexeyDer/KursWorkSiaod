package myMenu;

import KursWork.Menu;

public interface InterfaceMenu {
    public final int menuSize = 6;
    public final String templateMenu[] = {
            "Просмотр базы данных", "Сортировка базы данных",
            "Бинарный поиск", "Вывести дерево поиска", "Кодирование", "Завершить программу"
    };


    public final int choiceMenuSize = 2;
    public final String choiceMenu[] = {
            "Поиcк по дереву", "Вернуться назад"
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
