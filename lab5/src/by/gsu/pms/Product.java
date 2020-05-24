package by.gsu.pms;
import java.io.Serializable;

public class Product implements Serializable {
    private String productName;
    private boolean isInStock;
    private double productPrice;

    public Product() {}

    public Product(String productName, boolean isInStock, double productPrice) {
        this.productName    = productName;
        this.isInStock      = isInStock;
        this.productPrice   = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public boolean getIsInStock() {
        return isInStock;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setInStock(boolean isInStock) {
        this.isInStock = isInStock;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return productName + ";" + isInStock + ";" + productPrice;
    }
}