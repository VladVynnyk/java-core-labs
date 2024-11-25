package lab13;


public class Student {
    private String firstName;
    private String lastName;
    private int grade;

    public Student(String firstName, String lastName, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " - " + grade;
    }
}

