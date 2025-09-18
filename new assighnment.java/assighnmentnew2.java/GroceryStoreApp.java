import java.util.*;

// Sample Problem 2: Grocery Store Bill Generation Application
class Product {
    String name;
    double pricePerUnit;
    double quantity;
    Product(String name, double pricePerUnit, double quantity) {
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.quantity = quantity;
    }
    double getTotal() {
        return pricePerUnit * quantity;
    }
}

class Customer {
    String name;
    List<Product> products = new ArrayList<>();
    Customer(String name) {
        this.name = name;
    }
    void addProduct(Product p) {
        products.add(p);
    }
}

class BillGenerator {
    double generateBill(Customer c) {
        double total = 0;
        for (Product p : c.products) {
            total += p.getTotal();
        }
        return total;
    }
}

public class GroceryStoreApp {
    public static void main(String[] args) {
        Customer c1 = new Customer("Alice");
        c1.addProduct(new Product("Apples", 3.0, 2.0));
        c1.addProduct(new Product("Milk", 2.0, 1.0));

        BillGenerator bg = new BillGenerator();
        double total = bg.generateBill(c1);

        System.out.println("Customer: " + c1.name);
        for (Product p : c1.products) {
            System.out.println("Product: " + p.name + ", Qty: " + p.quantity + ", Price: $" + p.pricePerUnit + ", Subtotal: $" + p.getTotal());
        }
        System.out.println("Total Bill: $" + total);
    }
}

