package Models;

import java.text.NumberFormat;

public class product {
    private String code;
    private String desc;
    private double price;

    public product() {
        code = "";
        desc = "";
        price = 0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getpriceFormat() {
        NumberFormat cformat = NumberFormat.getCurrencyInstance();
        return cformat.format(price);
    }
}
