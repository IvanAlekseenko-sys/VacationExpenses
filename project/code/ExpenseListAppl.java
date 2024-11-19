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
                case 4: {}
                scanner.nextLine(); // Очистка после считывания номера меню
                System.out.println("Введите категорию для необходимого отчета: ");
                String type = scanner.nextLine(); // Считываем категорию

                // Вызов метода для получения суммы расходов по категории
                double totalByCategory = expenseList.expensesByCategory(type);

                // Вывод отчета
                System.out.printf("Общие расходы по категории '%s' составляют: %.2f%n", type, totalByCategory);
                break;

                case 5: {}
                // Ввод промежутка времени
                scanner.nextLine(); // Очистка после ввода числа
                System.out.println("Отчет за промежуток времени. Введите дату от (в формате yyyy-MM-dd): ");
                String fromDateString = scanner.nextLine(); // Ввод строки для даты начала
                LocalDate from = LocalDate.parse(fromDateString); // Преобразование в LocalDate

                System.out.println("Введите дату до (в формате yyyy-MM-dd): ");
                String toDateString = scanner.nextLine(); // Ввод строки для даты конца
                LocalDate to = LocalDate.parse(toDateString); // Преобразование в LocalDate

                // Вызов метода для расчета затрат
                double totalExpenses = expenseList.expenseByDateRange(from, to);

                // Вывод отчета
                System.out.printf("Общие расходы с %s по %s составляют: %.2f%n", from, to, totalExpenses);
                break;

                case 6: {
                    System.out.println("Saving... ");
                    // call method
                    expenseList.saveExpenses(FILE_NAME);
                    break;
                }
                case 7:{
                    // call method
                    System.out.println("Loading... ");
                    expenseList.loadExpenses(FILE_NAME);
                    break;
                }
                case 8:
                    return;
                default: {
                    System.out.println("Wrong input.");
                }
            }
        }
    }
}
