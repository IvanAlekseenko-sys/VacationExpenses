package test;

import dao.ExpenseList;
import dao.ExpenseListImpl;
import model.Expense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ExpenseListImplTest {


    ExpenseList expenses;

    LocalDate now = LocalDate.now();

    @BeforeEach
    void setUp() {
        //ExpenseListImpl перед каждым тестом
        expenses = new ExpenseListImpl();



        // Создаем 5 расходов и добавляем их в список
        expenses.addExpense(new Expense( "Meals", 100.0,now.minusDays(30)));
        expenses.addExpense(new Expense( "Transfers", 50.0, now.minusDays(22)));
        expenses.addExpense(new Expense( "Entertainment", 200.0,now.minusDays(15)));
        expenses.addExpense(new Expense( "Meals", 150.0,now.minusDays(15)));
        expenses.addExpense(new Expense( "Excursions", 300.0, now.minusDays(25)));

    }

    @Test
    void testAddExpense() {
        // пытаемся добавить null
        assertFalse(expenses.addExpense(
                null));
        // Проверка на дубликаты
        assertFalse(expenses.addExpense(
                new Expense( "Meals", 150.0,now.minusDays(15)))); //добавили новый Expense
        // Проверяем, что расходы добавлены правильно
        assertEquals(6, expenses.quantity(), "Expense :  6");


    }

    @Test
    void testRemoveExpense() {
        //удаляем  расход м номером 1
        expenses.removeExpense(1);
        // сравниваем количество
        assertEquals(4,expenses.quantity());
        expenses.printExpenses();
    }



    @Test
    void testQuantity() {
        assertEquals(5,expenses.quantity());
    }

    @Test
    void testPrintExpenses() {
        expenses.printExpenses();
    }

    @Test
    void testExpensesByCategory() {
            assertEquals(250.0, expenses.expensesByCategory("Meals"));

    }

    @Test
    void testExpenseByDateRange() {

        LocalDate from = now.minusDays(20);
        LocalDate to = now.minusDays(14);
        // Assert that the sum of expenses in the date range is 350.0
        assertEquals(350.0, expenses.expenseByDateRange(from, to));
    }


    @Test
    public void testSaveAndLoad() {
        expenses.SaveExpenses("expensesTest.txt");
        expenses.LoadExpenses("expensesTest.txt");
        assertEquals(3, expenses.quantity());
    }


}