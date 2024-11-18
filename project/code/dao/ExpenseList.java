package dao;


import model.Expense;

import java.time.LocalDate;

public interface ExpenseList {


    // Добавление нового расхода
    boolean addExpense(Expense expense);

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
    void SaveExpenses(String fileName);

    // Загрузка списка расходов из файла
    void LoadExpenses(String fileName);
}
