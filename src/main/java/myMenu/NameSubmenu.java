package myMenu;

import java.util.*;

public class NameSubmenu extends Menu {
    private List<String> names;

    public NameSubmenu(int amountItems) {
        Scanner sc = new Scanner(System.in);
        this.names = new ArrayList<>();
        for (int i = 0; i < amountItems; i++) {
            inputNameMenu(sc.next());
        }
    }

    public NameSubmenu() {
        super();
    }

    public void inputNameMenu(String str) {
        names.add(str);
    }


}
