import java.util.Scanner;

public class Main {

    public static int milk = 50;
    public static int bred = 14;
    public static int buckwheat = 95;
    public static int countProd = 3;
    public static int sumProducts = 0;

    public static void onePrintDelim(){
        System.out.println("============\n" +
                "Список возможных товаров для покупки\n" +
                "1. Молоко 50 руб/шт\n" +
                "2. Хлеб 14 руб/шт\n" +
                "3. Гречневая крупа 80 руб/шт\n" +
                "============");
    }

    public static void twoPrintDelim(){
        System.out.println("Выберите товар и количество (через пробел) или введите `end`");
    }

    public static void sumCalc(int[] products , int[] prices, String[] namesProduct) {
        System.out.println("============");
        int i = 0;
        if (products[i] > 0){
            System.out.printf("%s %11s %12s %5s%n", "Наименование товара",
                    "Количество", "Цена/за.ед", " Общая стоимость");
        } else {
            System.out.println("Вы ничего не выбрали!");
        }

        for (i = 0; i < products.length; i++) {
            if (products[i] > 0) {
                System.out.printf("%-15s %11s %12s %12s%n", namesProduct[i],
                        products[i], prices[i], products[i] * prices[i]);
                int sum = products[i] * prices[i];
                sumProducts += sum;
            }
        }
        System.out.printf("%42s %10s%n", "Итого ", sumProducts);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        onePrintDelim();

        String[] namesProduct = new String[] {"Молоко", "Хлеб" ,"Гречневая крупа"};
        int[] products = new int [countProd];
        int[] prices = {milk, bred, buckwheat};

        while (true) {
            twoPrintDelim();
            String line = scanner.nextLine();
            if (line.equals("end")) {
                sumCalc(products, prices, namesProduct);
                break;
            }

            String[] parts = line.split(" ");
            int productNumber = Integer.parseInt(parts[0]) - 1;
            int productCount = Integer.parseInt(parts[1]);
            products[productNumber] += productCount;
        }
    }
}