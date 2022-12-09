import java.util.Scanner;

public class Main {

    static Scanner scanner;
    static Calculator calculator;
    static int peoples = 0;
    static boolean isPeoplesSetCorrectly = true;
    static boolean isProductPurchased = false;
    static String stopProductPurchased = "Завершить";

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        // ваш код начнется здесь
        // вы не должны ограничиваться только классом Main и можете создавать свои классы по необходимости
        while (isPeoplesSetCorrectly) {
            System.out.println("На сколько человек делим счет?");

            try {
                peoples = scanner.nextInt();

                if (peoples == 1) {
                    showErrorMessage("Количество человек должно быть более 1.");
                }
                if (peoples < 1) {
                    showErrorMessage("Маловато будет. Это менее 1.");
                }
                if (peoples > 1) {
                    isPeoplesSetCorrectly = false;
                    isProductPurchased = true;
                }


            } catch (Exception e) {
                showErrorMessage(e.getMessage());
            }

        }

        calculator = new Calculator();
        calculator.setPeoples(peoples);

        while (isProductPurchased) {
            System.out.println("Ведите название товара.");
            String productName;
            double productPrice;
            productName = scanner.next();

            boolean isPriceSetCorrectly = false;
            while (!isPriceSetCorrectly) {

                System.out.println("Введите цену товара в формате <рубли.копейки>.");
                String stringProductPrice = scanner.next().trim();
                if (stringProductPrice.contains(",")) {
                    stringProductPrice = stringProductPrice.replace(",", ".");
                }

                try {
                    productPrice = Double.parseDouble(stringProductPrice);
                    if (productPrice <= 0.0) {
                        showErrorMessage("Цена товара слишком мала. " + productPrice);
                        break;
                    } else {
                        Product product = new Product(productName, productPrice);
                        System.out.println(calculator.addProduct(product));
                        isPriceSetCorrectly = true;
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    showErrorMessage("Цена должна быть указана в виде <xx.yy>." + e.getMessage());
                }
            }
            System.out.println("Желаете добавить еще товар? Для завершения наберите <Завершить>.");

            String buyerWantsBuy = scanner.next();
            if (buyerWantsBuy.trim().equalsIgnoreCase(stopProductPurchased)) {
                isProductPurchased = false;
            }
        }


        System.out.println(calculator.getAllProductNames());
        System.out.println(calculator.getFinalPrice());

        System.out.println(calculator.getPriceForOnePeople());

    }


    static void showErrorMessage(String errorString) {
        System.out.println("Ошибка! " + errorString);
    }

}
