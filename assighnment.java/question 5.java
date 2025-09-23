
import java.util.*;

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
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }
}

interface Discountable {
    double applyDiscount(double amount);
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount(double amount) {
        return amount * 0.90;
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount applied";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + 50;
    }

    @Override
    public double applyDiscount(double amount) {
        return amount * 0.95;
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount applied";
    }
}

public class OnlineFoodDeliverySystem {
    public static void processOrder(List<FoodItem> order) {
        for (FoodItem item : order) {
            item.getItemDetails();
            double total = item.calculateTotalPrice();
            if (item instanceof Discountable) {
                total = ((Discountable) item).applyDiscount(total);
                System.out.println(((Discountable) item).getDiscountDetails());
            }
            System.out.println("Final Price: " + total);
            System.out.println("------------------");
        }
    }

    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        order.add(new VegItem("Paneer Butter Masala", 200, 2));
        order.add(new NonVegItem("Chicken Biryani", 300, 1));
        processOrder(order);
    }
}
