package view;

import java.io.Serializable;

public enum Menu implements Serializable {
    ADD(1, "Add expenses"), LIST(2, "List of expenses"), REMOVE(3, "Remove expenses"), CATEGORY_REPORT(4,
            "Category_report"), TIME_REPORT(5,"Time_report"),
    SAVE(6, "Save"), LOAD(7, "Load"), EXIT(8, "Exit");


    //fields
    private int menuItem;
    private String action;

    Menu(int menuItem, String action) {
        this.menuItem = menuItem;
        this.action = action;
    }
    // метод, void - ничего не возвращает, он печатает
    public static void printMenu(){
        Menu[] menu = Menu.values(); // put enum items into array
        for (int i = 0; i < menu.length; i++) {
            System.out.print((menu[i].menuItem) + " - " + menu[i].action + " | ");
        }
        System.out.println(); // new line
    }
}
