import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount;

    Product(String n, double p, double r, double d) {
        name = n; price = p; rating = r; discount = d;
    }

    public String toString() {
        return name + " (price=" + price + ", rating=" + rating + ", discount=" + discount + "%)";
    }
}

public class EcommerceSorting {
    public static void main(String[] args) {

        List<Product> list = Arrays.asList(
                new Product("Laptop", 75000, 4.5, 10),
                new Product("Phone", 45000, 4.3, 5),
                new Product("Headphones", 1500, 4.7, 20)
        );

        // Sort by price
        list.sort((a, b) -> Double.compare(a.price, b.price));
        System.out.println("Sorted by Price → " + list);

        // Sort by rating
        list.sort((a, b) -> Double.compare(b.rating, a.rating));
        System.out.println("Sorted by Rating → " + list);

        // Sort by discount
        list.sort((a, b) -> Double.compare(b.discount, a.discount));
        System.out.println("Sorted by Discount → " + list);
    }
}
