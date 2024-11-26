package view;

import java.io.Serializable;

public enum Menu implements Serializable {
    ADD(1, "Добавить расходы"), LIST(2, "Список расходов"), UPDATE(3, "Изменение расхода"), REMOVE(4, "Удаление " +
            "расхода"), CATEGORY_REPORT(5,
            "Отчет по категории"), TIME_REPORT(6,"Отчет по временному промежутку"),
    SAVE(7, "Сохранить"), LOAD(8, "Загрузить"), EXIT(9, "Выход");


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
