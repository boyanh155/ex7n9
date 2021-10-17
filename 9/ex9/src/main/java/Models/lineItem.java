package Models;

import java.text.NumberFormat;

public class lineItem {
    private product product;
    private int qty;

    public lineItem() {
    }

    public product getProduct() {
        return product;
    }

    public void setProduct(product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return product.getPrice() * qty;
    }

    public String getpriceFormatTotal() {
        NumberFormat cformat = NumberFormat.getCurrencyInstance();
        return cformat.format(this.getTotal());
    }
}
