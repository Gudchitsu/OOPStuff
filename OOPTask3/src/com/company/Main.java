package com.company;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        cycle:
        while (true) {
            switch (TaskMenu.createMenu()) {
                case 1:
                    while (true) {
                        try {
                            Scanner in = new Scanner(System.in);
                            System.out.println("\nВведите количество городов");
                            int n = in.nextInt();
                            String[][] array = stringArrayCreator(n);
                            millionsRounding(array);
                            for (int i = 0; i < array.length; i++) {
                                System.out.println(array[i][0] + " " + array[i][1]);
                            }
                            break;
                        } catch (Exception exception) {
                            System.out.println("Ошибка: " + exception + ". Повторите ввод");
                            continue;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        try {
                            Scanner in = new Scanner(System.in);
                            System.out.println("\nВведите длину стороны");
                            int side = in.nextInt();
                            double[] array = otherSides(side);
                            System.out.println(array[0] + ", " + array[1]);
                            break;
                        } catch (Exception exception) {
                            System.out.println("Ошибка: " + exception + ". Повторите ввод");
                            continue;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        try {
                            Scanner in = new Scanner(System.in);
                            System.out.println("\nИгрок 1:");
                            String player1 = in.nextLine();
                            System.out.println("Игрок 2:");
                            String player2 = in.nextLine();
                            System.out.println(rps(player1, player2));
                            break;
                        } catch (Exception exception) {
                            System.out.println("Ошибка: " + exception + ". Повторите ввод");
                            continue;
                        }
                    }
                    break;
                case 4:
                    while (true) {
                        try {
                            System.out.println("\nВведите числа через пробел");
                            int[] array = intArrayCreator();
                            System.out.println(warOfNumbers(array));
                            break;
                        } catch (Exception exception) {
                            System.out.println("Ошибка: " + exception + ". Повторите ввод");
                            continue;
                        }
                    }
                    break;
                case 5:
                    while (true) {
                        try {
                            Scanner in = new Scanner(System.in);
                            System.out.println("\nВведите строку");
                            String string = in.nextLine();
                            System.out.println(reverseCase(string));
                            break;
                        } catch (Exception exception) {
                            System.out.println("Ошибка: " + exception + ". Повторите ввод");
                            continue;
                        }
                    }
                    break;
                case 6:
                    while (true) {
                        try {
                            Scanner in = new Scanner(System.in);
                            System.out.println("\nВведите строку");
                            String string = in.nextLine();
                            System.out.println(inatorInator(string));
                            break;
                        } catch (Exception exception) {
                            System.out.println("Ошибка: " + exception + ". Повторите ввод");
                            continue;
                        }
                    }
                    break;
                case 7:
                    while (true) {
                        try {
                            Scanner in = new Scanner(System.in);
                            System.out.println("\nВведите высоту кирпича");
                            int a = in.nextInt();
                            System.out.println("Введите ширину кирпича");
                            int b = in.nextInt();
                            System.out.println("Введите глубину кирпича");
                            int c = in.nextInt();
                            System.out.println("Введите ширину отверстия");
                            int w = in.nextInt();
                            System.out.println("Введите высоту отверстия");
                            int h = in.nextInt();
                            System.out.println(
                                    "Может ли кирпич поместиться в отверстие?" + "\n" + doesBrickFit(a, b, c, w, h));
                            break;
                        } catch (Exception exception) {
                            System.out.println("Ошибка: " + exception + ". Повторите ввод");
                            continue;
                        }
                    }
                    break;
                case 8:
                    while (true) {
                        try {
                            Scanner in = new Scanner(System.in);
                            System.out.println("\nВведите количество топлива");
                            double liters = in.nextDouble();
                            System.out.println("Введите расход топлива");
                            double baseConsumption = in.nextDouble();
                            System.out.println("Введите количество пассажиров");
                            int passengers = in.nextInt();
                            System.out.println("Кондиционер работает?");
                            boolean conditioner = in.nextBoolean();
                            System.out.println(
                                    "Максимальное расстояние, которое проедет авто = " + totalDistance(liters,
                                            baseConsumption, passengers, conditioner));
                            break;
                        } catch (Exception exception) {
                            System.out.println("Ошибка: " + exception + ". Повторите ввод");
                            continue;
                        }
                    }
                    break;
                case 9:
                    while (true) {
                        try {
                            System.out.println("\nВведите числа через пробел");
                            int[] array = intArrayCreator();
                            System.out.println("Среднее значение = " + mean(array));
                            break;
                        } catch (Exception exception) {
                            System.out.println("Ошибка: " + exception + ". Повторите ввод");
                            continue;
                        }
                    }
                    break;
                case 10:
                    while (true) {
                        try {
                            Scanner in = new Scanner(System.in);
                            System.out.println("\nВведите число");
                            int number = in.nextInt();
                            System.out.println(
                                    "Число и сумма его цифр имеют одинаковую четность?" + "\n" +
                                            parityAnalysis(number));

                            break;
                        } catch (Exception exception) {
                            System.out.println("Ошибка: " + exception + ". Повторите ввод");
                            continue;
                        }
                    }
                    break;
                case 0:
                    break cycle;
            }
        }
    }

    public static String[][] stringArrayCreator(int n) {
        Scanner input = new Scanner(System.in);
        String[][] array = new String[n][2];
        for (int i = 0; i < n; i++) {
            System.out.println("\nВведите название города");
            array[i][0] = input.nextLine();
            System.out.println("Введите количество населения");
            array[i][1] = input.nextLine();
        }
        return array;
    }

    public static int[] intArrayCreator() {
        Scanner input = new Scanner(System.in);
        String tmp = input.nextLine();
        int[] array; // Создаём массив
        array = Arrays.stream(tmp.split(" ")).mapToInt(Integer::parseInt).toArray();
        return array;
    }

    public static String[][] millionsRounding(String[][] data) {
        int population;
        int checker;
        int millions;
        for (int i = 0; i < data.length; i++) {
            population = Integer.parseInt(data[i][1]);
            millions = population / 1000000;
            checker = population / 100000;
            if (checker % 10 <= 4) {
                data[i][1] = Integer.toString(millions * 1000000);
            } else {
                data[i][1] = Integer.toString((millions + 1) * 1000000);
            }
        }
        return data;
    }

    public static double[] otherSides(int side) {
        double hypotenuse = side * 2;
        double otherSide = Math.sqrt(Math.pow(hypotenuse, 2) - Math.pow(side, 2));
        double[] array = new double[2];
        array[0] = hypotenuse;
        array[1] = BigDecimal.valueOf(otherSide).setScale(2, BigDecimal.ROUND_HALF_UP)
                .doubleValue();
        return array;
    }

    public static String rps(String player1, String player2) {
        if (player1.equals(player2)) {
            return "Tie";
        } else if ((player1.equals("rock") && player2.equals("scissors")) ||
                (player1.equals("paper") && player2.equals("rock")) ||
                (player1.equals("scissors") && player2.equals("paper"))) {
            return "Player 1 win";
        } else {
            return "Player 2 win";
        }
    }

    public static int warOfNumbers(int[] array) {
        int evenNumbers = 0;
        int oddNumbers = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenNumbers += array[i];
            } else if (array[i] % 2 == 1) {
                oddNumbers += array[i];
            }
        }
        return Math.abs(evenNumbers - oddNumbers);
    }

    public static String reverseCase(String string) {
        String replacementString = "";
        char[] s = string.toCharArray();
        for (int i = 0; i < s.length; i++) {
            replacementString +=
                    Character.isLowerCase(s[i]) ? Character.toUpperCase(s[i])
                            : Character.toLowerCase(s[i]);
        }
        return replacementString;
    }

    public static String inatorInator(String string) {
        String chars = "уеыаоэяиюУЕЫАОЭЯИЮ";
        Character lastChar = string.charAt(string.length() - 1);
        if (chars.contains(lastChar.toString())) {
            string = string + "-inator " + string.length();
            return string;
        } else {
            string = string + "inator " + string.length();
            return string;
        }
    }

    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return ((a <= w && b <= h) || (a <= w && c <= h) || (b <= w && a <= h) || (b <= w && c <= h)
                || (c <= w && a <= h) || (c <= w && b <= h));
    }

    public static BigDecimal totalDistance(double liters, double baseConsumption, int passengers,
                                           boolean conditioner) {
        double consumptionWithPassengers = baseConsumption + baseConsumption * passengers * 0.05;
        double consumptionWithConditioner = consumptionWithPassengers + consumptionWithPassengers * 0.1;
        if (conditioner) {
            return BigDecimal.valueOf(liters / consumptionWithConditioner * 100)
                    .setScale(2, BigDecimal.ROUND_HALF_UP);
        } else {
            return BigDecimal.valueOf(liters / consumptionWithPassengers * 100)
                    .setScale(2, BigDecimal.ROUND_HALF_UP);
        }
    }

    public static BigDecimal mean(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return BigDecimal.valueOf(sum / array.length).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static boolean parityAnalysis(int number) {
        String string = Integer.toString(number);
        int sum = 0;
        for (int i = 0; i < string.length(); i++) {
            sum += Integer.parseInt(Character.toString(string.charAt(i)));
        }
        return (sum % 2 == 0 && number % 2 == 0) || (sum % 2 == 1 && number % 2 == 1);
    }
}
