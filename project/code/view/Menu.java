package view;

import java.io.Serializable;

public enum Menu implements Serializable {
    ADD(1, "Добавить расходы"), LIST(2, "Список расходов"), REMOVE(3, "Удаление расхода"), CATEGORY_REPORT(4,
            "Отчет по категории"), TIME_REPORT(5,"Отчет по временному промежутку"),
    SAVE(6, "Сохранить"), LOAD(7, "Загрузить"), EXIT(8, "Выход");


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
