package Abstract;

abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private String borrowerName;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.borrowerName = "";
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

    public void setBorrowerName(String name) {
        this.borrowerName = name;
    }

    public String getBorrowerName() {
        return borrowerName;
    }

    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author;
    }

    public abstract int getLoanDuration();
}

interface Reservable {
    boolean checkAvailability();
    void reserveItem(String borrower);
}

class Book extends LibraryItem implements Reservable {
    private boolean isAvailable;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }

    public int getLoanDuration() {
        return 21;
    }

    public boolean checkAvailability() {
        return isAvailable;
    }

    public void reserveItem(String borrower) {
        if (isAvailable) {
            setBorrowerName(borrower);
            isAvailable = false;
        }
    }
}

class Magazine extends LibraryItem implements Reservable {
    private boolean isAvailable;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }

    public int getLoanDuration() {
        return 7;
    }

    public boolean checkAvailability() {
        return isAvailable;
    }

    public void reserveItem(String borrower) {
        if (isAvailable) {
            setBorrowerName(borrower);
            isAvailable = false;
        }
    }
}

class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
        this.isAvailable = true;
    }

    public int getLoanDuration() {
        return 14;
    }

    public boolean checkAvailability() {
        return isAvailable;
    }

    public void reserveItem(String borrower) {
        if (isAvailable) {
            setBorrowerName(borrower);
            isAvailable = false;
        }
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book("B001", "Java Basics", "Author A"),
            new Magazine("M101", "Tech Monthly", "Editor B"),
            new DVD("D501", "Sci-Fi Movie", "Director C")
        };

        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            Reservable reservable = (Reservable) item;
            System.out.println("Available: " + reservable.checkAvailability());
            reservable.reserveItem("John Doe");
            System.out.println("Borrower: " + item.getBorrowerName());
            System.out.println("Available After Reservation: " + reservable.checkAvailability());
            System.out.println();
        }
    }
}
