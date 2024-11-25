package lab10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@FunctionalInterface
interface PartChecker {
    boolean check(Part part);
}

public class Main {
    public static void main(String[] args) {
        List<Part> parts = new ArrayList<>();
        parts.add(new Part("Brake Pad", 15.99, 50));
        parts.add(new Part("Oil Filter", 5.99, 30));
        parts.add(new Part("Battery", 70.00, 15));
        parts.add(new Part("Air Filter", 10.99, 20));

        // Сортування запчастин за ціною у зростаючому порядку
        parts.sort(Comparator.comparingDouble(Part::getPrice));
        System.out.println("Parts sorted by price:");
        parts.forEach(System.out::println);

        // Використання PartChecker для фільтрації запчастин
        PartChecker expensiveChecker = part -> part.getPrice() > 20.0;
        List<Part> expensiveParts = filterParts(parts, expensiveChecker);

        System.out.println("\nExpensive parts (price > 20):");
        expensiveParts.forEach(System.out::println);
    }

    // Метод для фільтрації списку запчастин за умовою, заданою PartChecker
    public static List<Part> filterParts(List<Part> parts, PartChecker checker) {
        return parts.stream()
                .filter(checker::check)
                .collect(Collectors.toList());
    }
}
