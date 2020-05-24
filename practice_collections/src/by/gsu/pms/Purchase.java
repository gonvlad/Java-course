package by.gsu.pms;

public class Purchase implements Comparable<Purchase> {
    private String productName;
    private int productPrice;
    private int numberOfProducts;

    public Purchase() { }

    public Purchase(String productName, int productPrice, int numberOfProducts) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.numberOfProducts = numberOfProducts;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getNumberOfProducts() {
        return numberOfProducts;
    }

    public void setNumberOfProducts(int numberOfProducts) {
        this.numberOfProducts = numberOfProducts;
    }

    public int getTotalPrice() {
        return productPrice * numberOfProducts;
    }

    @Override
    public String toString() {
        return "\nProduct name: " + productName +
                "\nProduct price: " + productPrice +
                "\nNumber of products: " + numberOfProducts;
    }

    @Override
    public int compareTo(Purchase purchase) {
        if (this.getProductPrice() < purchase.getProductPrice()) {
            return -1;
        } else if (this.getProductPrice() > purchase.getProductPrice()) {
            return 1;
        }
        return 0;
    }
}
