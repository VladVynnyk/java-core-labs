package lab5;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
        Integer[] array1 = {1, 2, 3, 4};
        Integer[] array2 = {3, 4, 5, 6};

        Set<Integer> set1 = new Set<>(array1);
        Set<Integer> set2 = new Set<>(array2);

        Operation<Integer> operation = new Operation<>();

        // Об'єднання множин
        Integer[] union = operation.unionSets(set1, set2);
        System.out.println("Union: " + Arrays.toString(union));

        // Перетин множин
        Integer[] intersection = operation.intersectionSets(set1, set2);
        System.out.println("Intersection: " + Arrays.toString(intersection));

        // Різниця множин
        Integer[] difference = operation.differenceSets(set1, set2);
        System.out.println("Difference: " + Arrays.toString(difference));

        // Симетрична різниця
        Integer[] symmetricDiff = operation.symmetricDiffSets(set1, set2);
        System.out.println("Symmetric Difference: " + Arrays.toString(symmetricDiff));
    }
}
