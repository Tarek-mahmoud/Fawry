import java.util.Arrays;

public class Cart {
    private static final int DEFAULT_CART_CAPACITY = 10;
    private static int cartCounter;

    private int id;
    private int userId;
    private Product[] products;
    private double shippingCost;
    private double subtotal;
    private double paidAmount;
    private int indexToAddNewProduct;
    private Customer customer;
    private Product[] shippingProducts;
    private int shippingProductsCount;

    {
        cartCounter++;
        userId = 1;
        shippingCost = 0.0;
    }

    public Cart() {
        products = new Product[DEFAULT_CART_CAPACITY];
        shippingProducts = new Product[DEFAULT_CART_CAPACITY];
    }

    public Cart(int id, int userId) {
        this();
        this.id = id;
        this.userId = userId;
    }

    public void addProduct(Product product, int quantity) {
        if (product == null) throw new IllegalArgumentException("Product is out of stock or expired.");
        if (quantity > product.getProductQuantity()) {
            System.out.println("Product quantity exceeds maximum quantity");
            return;
        }
        if (products.length <= indexToAddNewProduct) products = Arrays.copyOf(products, products.length * 2);
        products[indexToAddNewProduct++] = product;

        if (product instanceof ShippableProduct || product instanceof ExpAndShipProduct) {
            if (shippingProducts.length <= shippingProductsCount) shippingProducts = Arrays.copyOf(shippingProducts, shippingProducts.length * 2);
            shippingProducts[shippingProductsCount++] = product;
        }
        calculateSubtotal();
        calculatePaidAmount();
    }

    private double calculateSubtotal() {
        subtotal = 0.0;
        for (int i = 0; i < indexToAddNewProduct; i++) subtotal += products[i].getProductPrice();
        return subtotal;
    }

    private double calculatePaidAmount() {
        paidAmount = subtotal + shippingCost;
        return paidAmount;
    }

    public int getId() { return id; }
    public void setId(int id) { if (id >= 0) this.id = id; }
    public int getUserId() { return userId; }
    public void setUserId(int userId) { if (userId >= 0) this.userId = userId; }
    public Product[] getProducts() { return Arrays.copyOf(products, indexToAddNewProduct); }
    public double getSubtotal() { return subtotal; }
    public double getPaidAmount() { return paidAmount; }
    public void setShippingCost(double shippingCost) { this.shippingCost = shippingCost; }
    public double getShippingCost() { return shippingCost; }
    public void setCustomer(Customer customer) { this.customer = customer; }
    public void paymentProcess() {
        if (customer.getBalance() < paidAmount) throw new InsufficientFundsException("Insufficient funds for shipping costs.");
        customer.setBalance(customer.getBalance() - paidAmount);
    }

    @Override
    public String toString() {
        if (indexToAddNewProduct == 0) throw new EmptyProductListException("Cart is empty");
        return "Subtotal = " + getSubtotal() + ", Shipping fees = " + getShippingCost() + ", Paid amount = " + getPaidAmount() +
                ", Current customer balance after payment = " + customer.getBalance();
    }
}