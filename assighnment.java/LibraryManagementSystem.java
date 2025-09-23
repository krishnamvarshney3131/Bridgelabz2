import java.util.*;

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }
}

interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

class Book extends LibraryItem implements Reservable {
    private boolean isAvailable = true;
    private String borrower;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 21;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable) {
            isAvailable = false;
            borrower = borrowerName;
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

class Magazine extends LibraryItem implements Reservable {
    private boolean isAvailable = true;
    private String borrower;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable) {
            isAvailable = false;
            borrower = borrowerName;
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable = true;
    private String borrower;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (isAvailable) {
            isAvailable = false;
            borrower = borrowerName;
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("B101", "Java Programming", "James Gosling"));
        items.add(new Magazine("M202", "Tech Monthly", "Various"));
        items.add(new DVD("D303", "Inception", "Christopher Nolan"));

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                Reservable r = (Reservable) item;
                System.out.println("Available: " + r.checkAvailability());
                r.reserveItem("John Doe");
                System.out.println("Available after reservation: " + r.checkAvailability());
            }
            System.out.println("---------------------");
        }
    }
}

