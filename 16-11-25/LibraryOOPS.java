class Library {
    Book[] books = new Book[10];
    int count = 0;

    void addBook(Book b) {
        books[count] = b;
        count++;
    }

    void showAllBooks() {
        for (int i = 0; i < count; i++) {
            books[i].display();
        }
    }
}

class Book {
    private String title;
    private String author;
    private int price;

    Book(String t, String a, int p) {
        title = t;
        author = a;
        price = p;
    }

    void display() {
        System.out.println(title + " " + author + " " + price);
    }
}

class PrintedBook extends Book {
    int pages;

    PrintedBook(String t, String a, int p, int pages) {
        super(t, a, p);
        this.pages = pages;
    }

    @Override
    void display() {
        super.display();
        System.out.println(pages);
    }
}

class EBook extends Book {
    double fileSize;

    EBook(String t, String a, int p, double fileSize) {
        super(t, a, p);
        this.fileSize = fileSize;
    }

    @Override
    void display() {
        super.display();
        System.out.println(fileSize);
    }
}

public class LibraryOOPS {
    public static void main(String[] args) {
        Book b1 = new Book("Java", "Harsh", 299);
        b1.display();
        PrintedBook b2 = new PrintedBook("Maths", "Harsh K", 999, 325);
        b2.display();
        EBook b3 = new EBook("Maths 2", "Harsh K S", 699, 25);
        b3.display();
        Library L1 = new Library();
        L1.addBook(b1);
        L1.addBook(b2);
        L1.addBook(b3);
        L1.showAllBooks();
    }
}