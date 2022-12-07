public class Calculator {
    private int peoples;
    private double finalPrice;
    private String allProductNames = "";
    private Double priceForOnePeople;

    public void setPeoples(int peoples) {
        this.peoples = peoples;
    }

    public String addProduct(Product product) {

        finalPrice = finalPrice + product.productPrice;
        if (allProductNames.isEmpty()) {
            allProductNames = product.productName;
        } else {
            allProductNames = allProductNames + ", \n" + product.productName;
        }
        priceForOnePeople = finalPrice / peoples;

        return ("Продукт " + product.productName + " по цене " + product.productPrice + " добавлен.");

    }

    public String getAllProductNames() {

        return allProductNames;
    }

    public String getFinalPrice() {

        return ("Итоговая общая цена: " + convertPriceToString(finalPrice));
    }

    public String getPriceForOnePeople() {

        return ("Каждый человек должен заплатить: " + convertPriceToString(priceForOnePeople));
    }

    private String convertPriceToString(double price) {
        String stringPrice = String.format("%.2f", price);
        String zeroEnd = "0";
        if (stringPrice.endsWith(zeroEnd)) {
            stringPrice = stringPrice + " рубля";
        } else {
            stringPrice = stringPrice + " рубль";
        }
        return stringPrice;
    }
}
