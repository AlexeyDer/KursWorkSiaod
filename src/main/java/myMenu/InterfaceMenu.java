package myMenu;

import KursWork.Menu;

public interface InterfaceMenu {
    public final int menuSize = 7;
    public final String templateMenu[] = {
            "Считывание базы данных", "Сортировка БД", "Просмотр базы данных", "Вывести отсортированную базу данных",
            "Поиск по сумме в БД", "Кодирование", "Завершить программу"
    };


    public final int choiceMenuSize = 5;
    public final String choiceMenu[] = {
            "Сделать поиск в БД", "Построить дерево", "Вывести дерево", "Поиск в дереве", "Вернутся назад"
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
