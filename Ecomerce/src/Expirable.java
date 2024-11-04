import java.util.Date;

public interface Expirable {
    Date getProductionDate();
    Date getExpiryDate();
    void setProductionDate(Date productionDate);
    void setExpiryDate(Date expiryDate);
    boolean isExpired();
}
