package lab11;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)
@interface Auditable {
}

public class Part {

    @Auditable
    public void addPart(String partName) {
        System.out.println("Adding part: " + partName);
    }

    @Deprecated
    public void removePart(String partName) {
        System.out.println("Removing part: " + partName);
    }

    public void updatePart(String partName) {
        System.out.println("Updating part: " + partName);
    }
}

