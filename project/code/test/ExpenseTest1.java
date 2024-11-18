package test;

import model.Expense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExpenseTest1 {

import model.Expense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static assertEquals;
import static assertTrue;

        public class ExpenseDAOImplTest {

                private Expense expense;

                @BeforeEach
                public void setUp() {
                        expense = new Expense();
                        expense.addExpense(new Expense(1, "Food", 50.0, LocalDate.of(2024, 1, 15)));
                        expense.addExpense(new Expense(2, "Transport", 20.0, LocalDate.of(2024, 1, 16)));
                        expense.addExpense(new Expense(3, "Entertainment", 100.0, LocalDate.of(2024, 1, 17)));
                }
                //Cоздаем новый объект Expence для категории "excursions" с суммой 200.0.
                @Test
                public void testAddExpense() {
                        Expense newExpense = new Expense(4, "excursions", 200.0, LocalDate.of(2024, 1, 18));
                        assertTrue(expense.addExpense(newExpense));
                        assertEquals(4, expense.quantity());
                }

                @Test
                public void testRemoveExpense() {
                        Expense expenseToRemove = new Expense(1, "Food", 50.0, LocalDate.of(2024, 1, 15));
                        assertTrue(expense.removeExpense(expenseToRemove));
                        assertEquals(2, expense.quantity());
                }

                @Test
                public void testUpdateExpense() {
                        assertTrue(expense.update(2, 25.0));
                        assertEquals(25.0, expenseByCategory("Entertainment"));
                }

                @Test
                public void testQuantity() {
                        assertEquals(3, expense.quantity());
                }

                @Test
                public void testPrintExpense() {
                        Expense expense = new Expense(1, "Food", 50.0, LocalDate.of(2024, 1, 15));
                        expense.printExpense(expense);
                }

                @Test
                public void testExpensesByCategory() {
                        assertEquals(50.0, expense.expensesByCategory("Food"));
                }

                @Test
                public void testExpensesByCategoryDateRange() {
                        LocalDate from = LocalDate.of(2024, 1, 15);
                        LocalDate to = LocalDate.of(2024, 1, 16);
                        assertEquals(70.0, expense.expensesByCategory(from, to));
                }

                @Test
                public void testSaveAndLoadTasks() {
                        expense.saveTasks("expenses.ser");
                        expense.loadTasks("expenses.ser");
                        assertEquals(3, expense.quantity());
                }

        }

}
