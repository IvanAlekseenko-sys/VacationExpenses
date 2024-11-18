package dao;


import model.Expense;

import java.time.LocalDate;

public interface ExpenseDao { //!!!ExpenseList

    // Добавление нового расхода
    boolean addExpense(Expense expense);

    // Удаление расхода по ID
    int removeExpense(int id); //(int expenseNumber)

    // Обновление расхода по ID
    Expense update(int id, Expense newExpense); //!!!(int expenseNumber, sum)

    // Получение количества расходов
    int quantity();

    // Печать информации о расходе
    void printExpense(Expense expense); //!!! void printExpenses()

    // Получение суммы расходов по категории
    double expensesByCategory(String type);

    // Получение суммы расходов в определенном диапазоне дат
    double expenseByDateRange(LocalDate from, LocalDate to);

    // Сохранение списка расходов в файл
    void saveTasks(String fileName);

    // Загрузка списка расходов из файла
    void loadTasks(String fileName);
}
