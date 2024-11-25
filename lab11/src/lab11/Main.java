package lab11;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class<Part> partServiceClass = Part.class;

        for (Method method : partServiceClass.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Auditable.class)) {
                System.out.println("Method " + method.getName() + " is annotated with @Auditable.");
            }

            if (method.isAnnotationPresent(Deprecated.class)) {
                System.out.println("Method " + method.getName() + " is annotated with @Deprecated. This method is deprecated and should not be used.");
            }
        }
    }
}
