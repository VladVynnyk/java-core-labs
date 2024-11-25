package lab5;
import java.util.Arrays;

public class Set<T> {
	private T[] elements;
	
	public Set(T[] elements) {
		this.elements = elements;
	}
	
	public void setSet(T[] elements) {
		this.elements = elements;
	}
	
	public T[] getSet() {
		return elements;
	}
	
	public void displaySet() {
		System.out.println("Set elements: " + Arrays.toString(elements));
	}
}
