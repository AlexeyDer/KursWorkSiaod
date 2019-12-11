package myMenu;

import myMenu.Menu;

public interface InterfaceMenu {
    public final int menuSize = 5;
    public final String templateMenu[] = {
            "Считывание базы данных", "Сортировка БД", "Просмотр базы данных", "Поиск по сумме в БД", "Кодирование"
    };


    public final int choiceMenuSize = 3;
    public final String choiceMenu[] = {
            "Построить дерево", "Вывести дерево", "Вернутся назад"
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
