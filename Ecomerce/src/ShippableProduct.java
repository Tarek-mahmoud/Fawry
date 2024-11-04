public class ShippableProduct extends Product implements Shippable {
    private double weight;

    public ShippableProduct(String productName, Double productPrice, int productQuantity, double weight) {
        super(productName, productPrice, productQuantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }
}
