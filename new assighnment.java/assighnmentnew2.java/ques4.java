import java.util.*;

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
        Customer customer1 = new Customer("Customer_Alice");
        customer1.addProduct(new Product("Product_Apples", 3.0, 2.0));
        customer1.addProduct(new Product("Product_Milk", 2.0, 1.0));

        BillGenerator billGenerator1 = new BillGenerator();
        double total = billGenerator1.generateBill(customer1);

        System.out.println("Customer: " + customer1.name);
        for (Product p : customer1.products) {
            System.out.println("Product: " + p.name + ", Qty: " + p.quantity + ", Price: $" + p.pricePerUnit + ", Subtotal: $" + p.getTotal());
        }
        System.out.println("Total Bill: $" + total);
    }
}

