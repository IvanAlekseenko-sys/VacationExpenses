package dao;


import model.Expense;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.IntStream;


public class ExpenseListImpl implements ExpenseList {

    private List<Expense> expenses;  // Список расходов
    private int quantity;

    private LocalDate time;

    // Конструктор, который загружает данные при инициализации
    public ExpenseListImpl() {

        expenses = new ArrayList<>();
        this.expenses = new ArrayList<>();
        this.quantity = 0;

    }


    @Override
    public boolean addExpense(Expense expense) {
        if(expense == null || expenses.contains(expense)){
                    return false;
               }

        // Добавление расхода в список
        expenses.add(expense);
        quantity = expenses.size();
        return true;
    }

    @Override
    public Expense updateExpense(int expenseNumber, String newType, double newAmount) {
        if(expenseNumber >= 1 && expenseNumber <= quantity){
            Expense update = expenses.get(expenseNumber - 1);
            update.setType(newType);
            update.setAmount(newAmount);
            System.out.println("Затрата # " + expenseNumber + " была изменена:" + expenses.get(expenseNumber - 1).toString() );
            return update;
        }
        System.out.println("Неверный номер расхода.");//"Wrong number of Expense."
        return null;
    }

    @Override
    public Expense removeExpense(int expenseNumber) {
        if(expenseNumber >= 1 && expenseNumber <= quantity){
            Expense victim = expenses.get(expenseNumber - 1);
            expenses.remove(victim);
            System.out.println("Расход: " + victim.getType() + " удален.");//("Расход: " + victim.getType() + " удален.")("Expense: " + victim.getType() + " is removed.")
            quantity--;
            return victim;
        }
        System.out.println("Неверный номер расхода.");//"Wrong number of Expense."
        return null;
    }



    @Override
    public int quantity() {
        // Возвращаем количество расходов в списке
        return expenses.size();
    }

    @Override
    public void printExpenses() {
        // Проверяем, пуст ли список расходов
        if (expenses.isEmpty()) {
            System.out.println("Ваш список затрат пуст");
        } else {
            // Печать информации о расходе
            IntStream.range(0, expenses.size())
                    .forEach(i -> System.out.println((i + 1) + ". " + expenses.get(i)));
        }
    }


    @Override
    public double expensesByCategory(String type) {
        // Суммируем расходы по категории (типу)
        return expenses.stream()
                .filter(expense -> expense.getType().equalsIgnoreCase(type)) // Фильтруем по типу
                .mapToDouble(Expense::getAmount) // Извлекаем сумму расхода
                .sum(); // Суммируем
    }

    @Override
    public double expenseByDateRange(LocalDate from, LocalDate to) {
        // Суммируем расходы по диапазону дат
        return expenses.stream()
                .filter(expense -> !expense.getDate().isBefore(from) && !expense.getDate().isAfter(to)) // Фильтруем по датам
                .mapToDouble(Expense::getAmount) // Извлекаем сумму расхода
                .sum(); // Суммируем
    }

    @Override
    public void saveExpenses(String fileName) {
        // Сохранение списка расходов в файл с помощью сериализации
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(expenses); // Сохраняем список расходов
            System.out.println("Расходы успешно сохранены в файл: " + fileName);//"Expenses saved successfully to file: "
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении расходов в файл: " + e.getMessage());//"Error saving Expense to file: "
        }
    }

    @Override
    public void loadExpenses(String fileName) {
// Загрузка списка расходов из файла с помощью десериализации
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            expenses = (List<Expense>) in.readObject(); // Загружаем список расходов из файла
            System.out.println("Расходы успешно загружены из файла: " + fileName);//"Expenses loaded successfully from file: "
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при загрузке расходов из файла: " + e.getMessage());//"Error loading Expense from file: "
        }
        quantity = expenses.size();
    }

    @Override
    public Expense get(int index) {
        if (index >= 0 && index < expenses.size()) {
            return expenses.get(index);
        }
        return null; // Возвращаем null, если индекс вне диапазона
    }


}

