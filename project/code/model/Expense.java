package model;



import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

    public class Expense implements Comparable <Expense>, Serializable {

        private int id;
        private String type;
        private double sum;
        private LocalDate date;

        public Expense(int id, String type, double sum, LocalDate date) {
            this.id = id;
            this.type = type;
            this.sum = sum;
            this.date = date;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public double getSum() {
            return sum;
        }

        public void setSum(double sum) {
            this.sum = sum;
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
            return id == expense.id && Objects.equals(date, expense.date);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, date);
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("Expense{");
            sb.append("id=").append(id);
            sb.append(", type='").append(type).append('\'');
            sb.append(", sum=").append(sum);
            sb.append(", date=").append(date);
            sb.append('}');
            return sb.toString();
        }

        @Override
        public int compareTo(Expense o) {

            return Integer.compare(this.id, o.id);
        }

    }



