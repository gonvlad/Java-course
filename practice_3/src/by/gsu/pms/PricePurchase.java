package by.gsu.pms;

public class PricePurchase extends Purchase {
    private int productDiscount;

    public PricePurchase() { }

    public PricePurchase(String productName, int productPrice, int numberOfProducts, int productDiscount) {
        super(productName, productPrice, numberOfProducts);
        this.productDiscount = productDiscount;
    }

    public int getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(int productDiscount) {
        this.productDiscount = productDiscount;
    }

    public int getTotalPrice() {
        return super.getTotalPrice() - (productDiscount * getNumberOfProducts());
    }

    @Override
    public String toString() {
        return super.toString() + "\nProduct discount: " + productDiscount;
    }
}
