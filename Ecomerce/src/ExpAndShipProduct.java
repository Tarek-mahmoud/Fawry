import java.util.Date;

public class ExpAndShipProduct extends Product implements Expirable, Shippable {
    private Date productionDate;
    private Date expiryDate;
    private double weight;

    public ExpAndShipProduct(String productName, Double productPrice, int productQuantity, Date productionDate, Date expiryDate, double weight) {
        super(productName, productPrice, productQuantity);
        this.productionDate = productionDate;
        this.expiryDate = expiryDate;
        this.weight = weight;
    }

    @Override
    public Date getProductionDate() {
        return productionDate;
    }

    @Override
    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    @Override
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        Date now = new Date();
        return expiryDate.before(now);
    }
}
