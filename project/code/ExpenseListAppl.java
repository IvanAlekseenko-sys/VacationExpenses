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
        System.out.println("Добро пожаловать в приложение для учета расходов!");

        ExpenseListImpl expenseList = new ExpenseListImpl (); // object
        LocalDate now = LocalDate.now();
        Scanner scanner = new Scanner(System.in);


// Загрузка задач при запуске
        if (Files.exists(Path.of(FILE_NAME))) { // Проверяем, существует ли файл
            System.out.println("Загрузка существующих расходов...");
            expenseList.loadExpenses(FILE_NAME);
        } else {
            System.out.println("Не найдено существующих расходов. Начинаем с чистого листа");
        }


        // начало цикла
        while (true) {
            System.out.println();
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
                    System.out.println("Выберите тип ваших затрат:");
                    System.out.println("1 - Трансферы");
                    System.out.println("2 - Питание");
                    System.out.println("3 - Развлечения");
                    System.out.println("4 - Экскурсии");

                    int expenseTypeChoice;
                    while (true) {
                        System.out.print("Введите номер: ");
                        if (scanner.hasNextInt()) {
                            expenseTypeChoice = scanner.nextInt();
                            if (expenseTypeChoice >= 1 && expenseTypeChoice <= 4) {
                                break; // корректный выбор
                            }
                        }
                        System.out.println("Ошибка: введите число от 1 до 4.");
                        scanner.nextLine(); // очистить ввод
                    }

                    String type;
                    switch (expenseTypeChoice) {
                        case 1 -> type = "Трансферы";
                        case 2 -> type = "Питание";
                        case 3 -> type = "Развлечения";
                        case 4 -> type = "Экскурсии";
                        default -> throw new IllegalStateException("Unexpected value: " + expenseTypeChoice);
                    }

                    System.out.println("Введите сумму: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Ошибка: введите корректное значение суммы.");
                        scanner.next(); // пропустить некорректный ввод
                    }
                    double sum = scanner.nextDouble();

                    Expense e = new Expense(type, sum, now);
                    expenseList.addExpense(e);
                    break;
                }

                case 2: {
                    System.out.println();
                    expenseList.printExpenses();
                    break;
                }
                case 3: {
                    System.out.println("Введите номер расхода для удаления: ");
                    int ExpenseNumber = scanner.nextInt();
                    expenseList.removeExpense(ExpenseNumber);
                    break;
                }
                case 4: {

                    System.out.println("Выберите категорию для отчета:");
                    System.out.println("1 - Трансферы");
                    System.out.println("2 - Питание");
                    System.out.println("3 - Развлечения");
                    System.out.println("4 - Экскурсии");

                    int reportCategoryChoice;
                    while (true) {
                        System.out.print("Введите номер: ");
                        if (scanner.hasNextInt()) {
                            reportCategoryChoice = scanner.nextInt();
                            if (reportCategoryChoice >= 1 && reportCategoryChoice <= 4) {
                                break; // корректный выбор
                            }
                        }
                        System.out.println("Ошибка: введите число от 1 до 4.");
                        scanner.nextLine(); // очистить ввод
                    }

                    String type;
                    switch (reportCategoryChoice) {
                        case 1 -> type = "Трансферы";
                        case 2 -> type = "Питание";
                        case 3 -> type = "Развлечения";
                        case 4 -> type = "Экскурсии";
                        default -> throw new IllegalStateException("Unexpected value: " + reportCategoryChoice);
                    }

                    // Вызов метода для получения суммы расходов по категории
                    double totalByCategory = expenseList.expensesByCategory(type);

                    // Вывод отчета
                    System.out.printf("Общие расходы по категории '%s' составляют: %.2f%n", type, totalByCategory);
                    break;
                }

                case 5: {
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
                }

                case 6: {
                    System.out.println("Сохранение... ");
                    // call method
                    expenseList.saveExpenses(FILE_NAME);
                    break;
                }
                case 7:{
                    // call method
                    System.out.println("Загрузка... ");
                    expenseList.loadExpenses(FILE_NAME);
                    break;
                }
                case 8:
                    return;
                default: {
                    System.out.println("Неверный ввод");
                }
            }
        }
    }
}
