package dao;


import model.Expense;

import java.time.LocalDate;

public interface ExpenseList {


    // Добавление нового расхода
    boolean addExpense(Expense expense);

    // Изменения расхода
    Expense updateExpense( int expenseNumber, String newType, double newAmount);

    // Удаление расхода
    Expense removeExpense(int expenseNumber);

    // Получение количества расходов
    int quantity();

    // Печать информации о расходе
    void printExpenses(); //

    // Получение суммы расходов по категории
    double expensesByCategory(String type);

    // Получение суммы расходов в определенном диапазоне дат
    double expenseByDateRange(LocalDate from, LocalDate to);

    // Сохранение списка расходов в файл
    void saveExpenses(String fileName);

    // Загрузка списка расходов из файла
    void loadExpenses(String fileName);

    Expense get(int index);

}
