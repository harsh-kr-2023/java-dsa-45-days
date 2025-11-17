class Student {

    private String name;
    private int rollNumber;
    private int m1;
    private int m2;
    private int m3;

    public Student(String name, int rollNumber, int m1, int m2, int m3) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
    }

    public double calculateAverage() {
        return (m1 + m2 + m3) / 3.0;
    }

    public String getGrade() {
        double average = calculateAverage();

        if (average >= 90)
            return "A";
        else if (average >= 75)
            return "B";
        else if (average >= 60)
            return "C";
        else if (average >= 40)
            return "D";
        else
            return "F";
    }

    public void printDetails() {
        System.out.println("Name : " + name);
        System.out.println("Roll Number : " + rollNumber);
        System.out.println("Marks : " + m1 + " " + m2 + " " + m3);
        double Average = calculateAverage();
        System.out.println("Average : " + Average);
        System.out.println("Grade : " + getGrade());
    }
}

public class StudentClassOOPS {
    public static void main(String[] args) {
        Student S1 = new Student("Harsh", 1, 50, 60, 70);
        S1.printDetails();
    }
}
