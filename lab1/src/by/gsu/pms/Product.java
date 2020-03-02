package by.gsu.pms;
import java.util.Comparator;

public class Product implements Comparable<Product> {
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

    public int compareTo(Product compareProduct) {
        if (this.productPrice < compareProduct.getProductPrice()) {
            return -1;
        } else if (this.productPrice > compareProduct.getProductPrice()) {
            return 1;
        }
        return 0;
    }

    public static Comparator<Product> ProductNameComparator = new Comparator<Product>() {

        public int compare(Product product1, Product product2) {
            String productName1 = product1.getProductName().toUpperCase();
            String productName2 = product2.getProductName().toUpperCase();

            return productName1.compareTo(productName2);
        }
    };
}
