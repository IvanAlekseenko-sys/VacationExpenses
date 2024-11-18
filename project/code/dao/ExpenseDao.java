package dao;


import model.Expense;

import java.time.LocalDate;

public interface ExpenseDao {

    // Добавление нового расхода
    boolean addExpense(Expense expense);

    // Удаление расхода по ID
    int removeExpense(int id);

    // Обновление расхода по ID
    Expense update(int id, Expense newExpense);

    // Получение количества расходов
    int quantity();

    // Печать информации о расходе
    void printExpense(Expense expense);

    // Получение суммы расходов по категории
    double expensesByCategory(String type);

    // Получение суммы расходов в определенном диапазоне дат
    double expenseByDateRange(LocalDate from, LocalDate to);

    // Сохранение списка расходов в файл
    void saveTasks(String fileName);

    // Загрузка списка расходов из файла
    void loadTasks(String fileName);
}
