package lab13;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створення списку студентів
        List<Student> students = new ArrayList<>();
        students.add(new Student("Ivan", "Ivanov", 95));
        students.add(new Student("Petro", "Petrov", 88));
        students.add(new Student("Olena", "Shevchenko", 92));
        students.add(new Student("Oksana", "Sydorenko", 85));
        students.add(new Student("Andriy", "Koval", 97));

        System.out.println("Students with grades above 90:");
        students.stream()
                .filter(student -> student.getGrade() > 90)
                .map(Student::getFirstName)
                .forEach(System.out::println);
    }
}

