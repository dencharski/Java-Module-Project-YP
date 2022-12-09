public class Calculator {
    private int peoples;
    private double finalPrice;
    private String allProductNames = "";

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

        return String.format("Продукт %s по цене %.2f добавлен.", product.productName, product.productPrice);
    }

    public String getAllProductNames() {
        return allProductNames;
    }

    public String getFinalPrice() {
        return ("Итоговая общая цена: " + convertPriceToString(finalPrice));
    }

    public String getPriceForOnePeople() {
        double priceForOnePeople = finalPrice / peoples;
        return ("Каждый человек должен заплатить: " + convertPriceToString(priceForOnePeople));
    }

    private String convertPriceToString(double price) {
        String stringPrice = String.format("%.2f", price);

        price = Math.floor(price);
        double remains = price % 100;

        if (11 <= remains && remains <= 14) {
            stringPrice = stringPrice + " рублей";
        } else {
            remains = remains % 10;
            if (remains == 1) {
                stringPrice = stringPrice + " рубль";
            }
            else if (2 <= remains && remains <= 4) {
                stringPrice = stringPrice + " рубля";
            } else {
                stringPrice = stringPrice + " рублей";
            }
        }

        return stringPrice;
    }
}
