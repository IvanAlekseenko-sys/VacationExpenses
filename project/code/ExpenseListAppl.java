import dao.ExpenseListImpl;
import model.Expense;
import view.Menu;

import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Scanner;

public class ExpenseListAppl {
    public static final String FILE_NAME = "expenses_list.dat";

    public static void main(String[] args) {
        // greeting
        System.out.println("Welcome to ExpensesList Application!");

        ExpenseListImpl expenseList = new ExpenseListImpl (); // object
        LocalDate now = LocalDate.now();
        Scanner scanner = new Scanner(System.in);


// Загрузка задач при запуске
        if (Files.exists(Path.of(FILE_NAME))) { // Проверяем, существует ли файл
            System.out.println("Loading existing Expense...");
            expenseList.loadExpenses(FILE_NAME);
        } else {
            System.out.println("No existing Expense found. Starting fresh.");
        }


        // начало цикла
        while (true) {
            Menu.printMenu(); // статический метод вызывается по имени класса
// ask choice
            System.out.print("Введите ваш выбор: ");
// Проверка на корректный ввод числа
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка: введите целое число для выбора.");
                scanner.next(); // пропустить некорректный ввод
                // continue;
            }

            int choice = scanner.nextInt();
            // execute
            switch (choice) {
                case 1: {
                    scanner.nextLine();
                    System.out.println("Input type: "); // добавить описание правильного написания типов затрат
                    String type = scanner.nextLine();
                    System.out.println("Input sum: ");
                    Double sum = scanner.nextDouble();

                    Expense e = new Expense(type,sum,now);

                    expenseList.addExpense(e);
                    break;
                }
                case 2: {
                    System.out.println("Your Expense: ");
                    expenseList.printExpenses();
                    break;
                }
                case 3: {
                    System.out.println("Input Expense number to remove: ");
                    int ExpenseNumber = scanner.nextInt();
                    expenseList.removeExpense(ExpenseNumber);
                    break;
                }
                case 4: {
                    System.out.println("Saving... ");
                    // call method
                    expenseList.saveExpenses(FILE_NAME);
                    break;
                }
                case 5:{
                    // call method
                    System.out.println("Loading... ");
                    expenseList.loadExpenses(FILE_NAME);
                    break;
                }
                case 6:
                    return;
                default: {
                    System.out.println("Wrong input.");
                }
            }
        }
    }
}
