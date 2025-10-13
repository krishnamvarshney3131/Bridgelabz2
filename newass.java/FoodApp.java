package Abstract;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity > 0) this.quantity = quantity;
    }

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity;
    }

    public abstract double calculateTotalPrice();
}

interface Discountable {
    void applyDiscount(double percent);
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    private double discountApplied;

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discountApplied = 0;
    }

    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) - discountApplied;
    }

    public void applyDiscount(double percent) {
        discountApplied = (getPrice() * getQuantity()) * (percent / 100);
    }

    public String getDiscountDetails() {
        return "Discount Applied: " + discountApplied;
    }
}

class NonVegItem extends FoodItem implements Discountable {
    private double discountApplied;
    private final double nonVegCharge = 30;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
        this.discountApplied = 0;
    }

    public double calculateTotalPrice() {
        double baseTotal = (getPrice() * getQuantity()) + nonVegCharge;
        return baseTotal - discountApplied;
    }

    public void applyDiscount(double percent) {
        double baseTotal = (getPrice() * getQuantity()) + nonVegCharge;
        discountApplied = baseTotal * (percent / 100);
    }

    public String getDiscountDetails() {
        return "Discount Applied: " + discountApplied;
    }
}

public class FoodApp {
    public static void main(String[] args) {
        FoodItem[] order = {
            new VegItem("Paneer Tikka", 200, 2),
            new NonVegItem("Chicken Biryani", 300, 1)
        };

        for (FoodItem item : order) {
            Discountable discountable = (Discountable) item;
            discountable.applyDiscount(10);
            System.out.println(item.getItemDetails());
            System.out.println(discountable.getDiscountDetails());
            System.out.println("Total Price: " + item.calculateTotalPrice());
            System.out.println();
        }
    }
}
