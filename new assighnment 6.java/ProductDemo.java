
class Product {
    
    private static double discount = 10.0;  

    
    private String productName;
    private double price;
    private int quantity;

    
    public Product(String productName, double price, int quantity) {
        this.productName = productName;  
        this.price = price;
        this.quantity = quantity;
    }

    
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Discount updated to: " + discount + "%");
    }

    
    public double calculateFinalPrice() {
        double totalPrice = price * quantity;
        double discountAmount = (discount / 100) * totalPrice;
        return totalPrice - discountAmount;
    }

    
    public void displayProduct() {
        System.out.println("Product Name : " + productName);
        System.out.println("Price        : " + price);
        System.out.println("Quantity     : " + quantity);
        System.out.println("Discount     : " + discount + "%");
        System.out.println("Final Price  : " + calculateFinalPrice());
    }
}


public class ProductDemo {
    public static void main(String[] args) {
        
        Product p1 = new Product("Laptop", 50000, 1);
        Product p2 = new Product("Headphones", 2000, 2);

        
        p1.displayProduct();
        System.out.println("------------------");
        p2.displayProduct();

        System.out.println("==================");

        
        Product.updateDiscount(20);

        
        p1.displayProduct();
        System.out.println("------------------");
        p2.displayProduct();
    }
}

