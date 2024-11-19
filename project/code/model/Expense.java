package model;



import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

    public class  Expense implements Comparable <Expense>, Serializable {


        private String type;
        private double amount;
        private LocalDate date;

        public Expense(String type, double amount, LocalDate date) {
            this.type = type;
            this.amount = amount;
            this.date = date;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public LocalDate getDate() {
            return date;
        }

        public void setDate(LocalDate date) {
            this.date = date;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Expense expense)) return false;
            return Double.compare(amount, expense.amount) == 0 && Objects.equals(type, expense.type) && Objects.equals(date, expense.date);
        }

        @Override
        public int hashCode() {
            return Objects.hash(type, amount, date);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("Категория: '").append(type).append('\'');
            sb.append(", сумма затрат ").append(amount);
            sb.append(", дата ").append(date);

            return sb.toString();
        }
        @Override
        public int compareTo(Expense o) {
            return this.date.compareTo(o.date);
        }
// test
    }