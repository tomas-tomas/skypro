import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    //Можно было посмотреть на сторону класса Calendar
    public static void checkYear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            System.out.printf("%d is a leap year\n", year);
        } else {
            System.out.printf("%d is not a leap year\n", year);
        }
    }

    //Нужно вынести реализацию для IOS и Android в приватные методы чтобы легче оптимизировать в дальнейшем
    public static void checkOS(int deviceYear, int clientOS) {
        int currentYear = LocalDate.now().getYear();
        if (clientOS == 1) {
            if (deviceYear < currentYear) {
                System.out.println("Install the lite-version for iOS at the link");
            } else if (deviceYear == currentYear) {
                System.out.println("Install the full-version for iOS at the link");
            } else {
                System.out.println("Incorrect input!");
            }
        } else if (clientOS == 0) {
            if (deviceYear < currentYear) {
                System.out.println("Install the lite-version for Android at the link");
            } else if (deviceYear == currentYear) {
                System.out.println("Install the full-version for Android at the link");
            } else {
                System.out.println("Incorrect input!");
            }
        } else {
            System.out.println("Incorrect input!");
        }
    }

    // Нужно сначала проверить длинную дистанцию и инкрементировать соответственно чтобы не проверять дважды
    public static int calcDeliveryTime(int deliveryDistance) {
        int deliveryTime = 1;
        if (deliveryDistance > 20) {
            deliveryTime++;
        }
        if (deliveryDistance > 60) {
            deliveryTime++;
        }
        if (deliveryDistance <= 0) {
            System.out.println("Incorrect input!");
            return 0;
        }
        return deliveryTime;
    }

    // Можно было использовать break чтобы дальше метод продолжал свою работу
    public static void checkDoubles(String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                System.out.printf("Duplicate character '%c' found.\n", str.charAt(i));
                return;
            }
        }
        System.out.println("Duplicate characters not found.");
    }

    // Можно было решить в двух строках
    public static void reverseArrayOrder(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int t = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = t;
        }
    }

    public static int[] generateRandomArray() {
        Random random = new Random();
        int[] arr = new int[30];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }

    // Не нужно было создавать две локальные переменные а сразу возвращать
    public static double getAverage(int[] arr) {
        double sum = getSum(arr);
        double averageValue = sum / arr.length;
        return averageValue;
    }

    // Нужно было использовать foreach
    public static double getSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        //task1
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int y = input.nextInt();
        checkYear(y);
        //task2
        System.out.print("Enter the year of manufacture of the device: ");
        int deviceYear = input.nextInt();
        System.out.print("Enter 0 if you have Android OS or 1 if iOS: ");
        int deviceOS = input.nextInt();
        checkOS(deviceYear, deviceOS);
        //task3
        System.out.print("Enter the distance: ");
        int dist = input.nextInt();
        System.out.printf("Delivery will take %d days.\n", calcDeliveryTime(dist));
        //task4
        System.out.print("Enter some line: ");
        String s = input.next();
        checkDoubles(s);
        input.close();
        //task5
        int[] array = {7, 4, 5, 8, 1};
        reverseArrayOrder(array);
        System.out.println("The reversed array looks like this: " + Arrays.toString(array));
        //task6
        int[] arr = generateRandomArray();
        double averageArr = getAverage(arr);
        System.out.printf("The average expenditure was %.2f rubles. \n", averageArr);
    }
}
