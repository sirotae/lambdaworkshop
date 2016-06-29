package workshop.task_3_1;

/**
 * Created by olenasyrota on 6/29/16.
 */
public class ProductPrice {
    private String shopName;
    private double price;
    private double taxPercent;
    private double promoDiscount;
    private double finalPrice;

    public ProductPrice(String shopName, double price, double taxPercent, double promoDiscount) {
        this.shopName = shopName;
        this.price = price;
        this.taxPercent = taxPercent;
        this.promoDiscount = promoDiscount;
    }

    public String getShopName() {
        return shopName;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void calculateFinalPrice() {
        finalPrice = price - price * taxPercent + price * promoDiscount;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(shopName)
                .append(" price ").append(price)
                .append(" final price ").append(finalPrice);
        return sb.toString();
    }

}
