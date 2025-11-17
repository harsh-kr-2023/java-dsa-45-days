abstract class Course {
    String title;
    String instructor;
    double price;

    public Course(String title, String instructor, double price) {
        this.title = title;
        this.instructor = instructor;
        this.price = price;
    }

    abstract void showContent();

    void printDetails() {
        System.out.println("Title - " + title);
        System.out.println("Instructor - " + instructor);
        System.out.println("Price - " + price);
    }
}

class VideoCourse extends Course {
    int videoCount;
    double totalDuration;

    public VideoCourse(int videoCount, double totalDuration, String title, String instructor, double price) {
        super(title, instructor, price);
        this.videoCount = videoCount;
        this.totalDuration = totalDuration;
    }

    @Override
    void showContent() {
        System.out.println("Videos - " + videoCount + " Duration - " + totalDuration);
    }
}

class LiveCourse extends Course {
    String schedule;

    String meetingLink;

    public LiveCourse(String schedule, String meetingLink, String title, String instructor, double price) {
        super(title, instructor, price);
        this.schedule = schedule;
        this.meetingLink = meetingLink;
    }

    @Override
    void showContent() {
        System.out.println("Schedule - " + schedule + " Meeting Link - " + meetingLink);
    }
}

class Student {
    String name;
    int id;
    Course[] enrolledCourses = new Course[3];
    int count = 0;

    void enroll(Course c) {
        enrolledCourses[count] = c;
        count++;
    }

    void showEnrolledCourses() {
        for (int i = 0; i < count; i++) {
            enrolledCourses[i].printDetails();
        }
    }
}

class CoursePlatform {
    Course[] coursePlatform = new Course[3];
    int count = 0;

    void addCourse(Course c) {
        coursePlatform[count] = c;
        count++;
    }

    void showAllCourses() {
        for (int i = 0; i < count; i++) {
            coursePlatform[i].showContent();
            coursePlatform[i].printDetails();
        }
    }
}

public class CourseManagementOOPS {
    public static void main(String[] args) {
        Course c1 = new VideoCourse(5, 30, "Python Lec", "Rhucha", 3499);
        Course c2 = new LiveCourse("Monday", "abc.com", "Java Lec", "Harsh", 6499);

        Course[] arr = { c1, c2 };
        for (Course c : arr) {
            c.showContent();
        }
        CoursePlatform p = new CoursePlatform();
        p.addCourse(c1);
        p.addCourse(c2);
        p.showAllCourses();

        Student s = new Student();
        s.enroll(c1);
        s.enroll(c2);
        s.showEnrolledCourses();

    }
}
