import java.util.Calendar;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Product product1 = new Product("Mobile", 1200.0, 13);
        Product product2 = new ShippableProduct("TV", 3000.0, 43, 13.5);

        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.NOVEMBER, 12);
        Date productDate = cal.getTime();
        cal.set(2025, Calendar.OCTOBER, 23);
        Date expiryDate = cal.getTime();

        Product product3 = new ExpiredProduct("Chase", 12.0, 7, productDate, expiryDate);
        Customer customer = new Customer("Tarek", "123 Dark Street", "+123445667", "tarek@gmail.com", 18000);

        Cart cart = new Cart();
        cart.setCustomer(customer);

        cart.addProduct(product1, 3);
        cart.addProduct(product2, 3);
        cart.addProduct(product3, 3);
        cart.paymentProcess();

        System.out.println(cart.toString());
    }
}