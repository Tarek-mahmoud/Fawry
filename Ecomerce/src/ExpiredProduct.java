import java.util.Date;

public class ExpiredProduct extends Product implements Expirable {
    private Date productionDate;
    private Date expiryDate;

    public ExpiredProduct(String productName, Double productPrice, int productQuantity, Date productionDate, Date expiryDate) {
        super(productName, productPrice, productQuantity);
        this.productionDate = productionDate;
        this.expiryDate = expiryDate;
    }

    @Override
    public Date getProductionDate() { return productionDate; }
    @Override
    public Date getExpiryDate() { return expiryDate; }
    @Override
    public void setProductionDate(Date productionDate) { this.productionDate = productionDate; }
    @Override
    public void setExpiryDate(Date expiryDate) { this.expiryDate = expiryDate; }
    @Override
    public boolean isExpired() {
        return expiryDate.before(new Date());
    }
}