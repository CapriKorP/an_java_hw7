import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static String[] products = {"Хлеб", "Яблоки", "Молоко"};
    static int[] prices = {100, 200, 300};
    static int[] quantity = new int[3];
    static int[] sumProducts = new int[3];


    public static void main(String[] args) {
        int sum = 0;

        System.out.println("Товары для покупки: ");

        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i] + " - " + prices[i] + " руб за шт/кг");
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Выберите товар и количество через пробел или введите `end` для завершения");

            String input = scanner.nextLine();

            if ("end".equals(input)) {
                System.out.println("Программа завершена!");
                break;

            }

            String[] pairNumbQuantity = input.split(" "); //Сплит

            int productNumb = Integer.parseInt(pairNumbQuantity[0]) - 1;
            int productQuantity = Integer.parseInt(pairNumbQuantity[1]);

            quantity[productNumb] = quantity[productNumb] + productQuantity;


            System.out.println("Ваша корзина");

            for (int i = 0; i < products.length; i++) {

                if (quantity[i] != 0) {
                    System.out.println(products[i] + " - " + quantity[i] + " шт." + " - " + (quantity[i] * prices[i]) + " руб");
                }
                sumProducts[i] = quantity[i] * prices[i];

                for (int y = 0; y < sumProducts.length; y++) {
                    sum = IntStream.of(sumProducts).sum(); //Суммирует элементы массива.
                }
            }
        }
        System.out.println("Итого: " + sum + " руб.");
    }
}
