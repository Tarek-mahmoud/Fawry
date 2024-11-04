public class Product {
    private String ProductName;
    private Double ProductPrice;
    private int ProductQuantity;

    public Product() {

    }

    public Product(String ProductName, Double ProductPrice, int ProductQuantity) {
        this.ProductName = ProductName;
        this.ProductPrice = ProductPrice;
        this.ProductQuantity = ProductQuantity;
    }

    public String getProductName() {
        return ProductName;
    }

    public Double getProductPrice() {
        return ProductPrice;
    }

    public int getProductQuantity() {
        return ProductQuantity;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public void setProductPrice(Double productPrice) {
        ProductPrice = productPrice;
    }

    public void setProductQuantity(int productQuantity) {
        ProductQuantity = productQuantity;
    }
}