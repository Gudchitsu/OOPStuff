package com.company;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        cycle:
        while (true) {
            switch (TaskMenu.createMenu()) {
                case 1:
                    while (true) {
                        try {
                            Scanner in = new Scanner(System.in);
                            System.out.println("\nВведите номер дома");
                            int house = in.nextInt();
                            System.out.println("Введите длину улицы");
                            int length = in.nextInt();
                            System.out.println(
                                    "Номер дома на противоположной стороне: " + oppositeHouse(house, length));
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
                            System.out.println("\nВведите имя и фамилию");
                            String name = in.nextLine();
                            System.out.println(nameShuffle(name));
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
                            System.out.println("\nЗадание №3\nВведите исходную цену");
                            int price = in.nextInt();
                            System.out.println("Введите процент скидки");
                            int discountNumber = in.nextInt();
                            System.out.println("Конечная цена после скидки = " + discount(price, discountNumber));
                            break;
                        }

                        catch (Exception exception) {
                            System.out.println("Ошибка: " + exception + ". Повторите ввод");
                            continue;
                        }
                    }
                    break;

                case 4:
                    while (true) {
                        try {
                            Scanner in = new Scanner(System.in);
                            System.out.println("\nВведите числа через пробел");
                            int[] array = intArrayCreator();
                            System.out.println(
                                    "Разница между наибольшим и наименьшим числами = " + differenceMaxMin(array));
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
                            System.out.println("\nВведите первое число");
                            int a = in.nextInt();
                            System.out.println("Введите второе число");
                            int b = in.nextInt();
                            System.out.println("Введите третье число");
                            int c = in.nextInt();
                            System.out
                                    .println("Количество чисел, имеющих одинаковое значение = " + equal(a, b, c));
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
                            String s = in.nextLine();
                            System.out.println(reverseString(s));
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
                            System.out.println("\nЗадание №7\nВведите зарплату первого программиста");
                            int a = in.nextInt();
                            System.out.println("Введите зарплату второго программиста");
                            int b = in.nextInt();
                            System.out.println("Введите зарплату третьего программиста");
                            int c = in.nextInt();
                            System.out.println(
                                    "Разница между самым высокооплачиваемым программистом и самым низкооплачиваемым = "
                                            + programmers(a, b, c));
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
                            System.out.println("\nВведите строку");
                            String string = in.nextLine();
                            System.out.println("Одинаковое ли количество x и o? " + getXO(string));
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
                            Scanner in = new Scanner(System.in);
                            System.out.println("\nВведите строку");
                            String string = in.nextLine();
                            System.out.println(bomb(string));
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
                            System.out.println("\nВведите первую строку");
                            String firstString = in.nextLine();
                            System.out.println("Введите вторую  строку");
                            String secondString = in.nextLine();
                            System.out.println(sameAscii(firstString,secondString));
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


    public static int[] intArrayCreator() {
        Scanner input = new Scanner(System.in);
        String tmp = input.nextLine();
        int[] array; // Создаём массив
        array = Arrays.stream(tmp.split(" ")).mapToInt(Integer::parseInt).toArray();
        return array;
    }

    public static int oppositeHouse(int house, int length) {
        return length * 2 - house + 1;
    }

    public static String nameShuffle(String name) {
        String firstSubstring = name.substring(0, name.indexOf(' '));
        String secondSubstring = name.substring(name.indexOf(' ') + 1);
        String result = secondSubstring + " " + firstSubstring;
        return result;
    }

    public static double discount(int price, int discountNumber) {
        return price - (price * discountNumber * 0.01);
    }

    public static int differenceMaxMin(int[] array) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max - min;
    }

    public static int equal(int a, int b, int c) {
        int count = 0;
        if (a == b || a == c) {
            count++;
        }
        if (b == a || b == c) {
            count++;
        }
        if (c == a || c == b) {
            count++;
        }
        return count;
    }

    public static String reverseString(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }

    public static int programmers(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        return max - min;
    }

    public static boolean getXO(String string) {
        string = string.toLowerCase(Locale.ROOT);
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'x') {
                countX++;
            } else if (string.charAt(i) == 'o') {
                countO++;
            }
        }
        return (countX == countO);
    }

    public static String bomb(String string) {
        string = string.toLowerCase(Locale.ROOT);
        if (string.contains("bomb")) {
            return "DUCK!";
        } else {
            return "Relax, there is no bomb";
        }
    }

    public static boolean sameAscii(String firstString, String secondString) {
        int firstSum = 0;
        int secondSum = 0;
        for (int i = 0; i < firstString.length(); i++) {
            firstSum += (int) firstString.charAt(i);
        }
        for (int i = 0; i < secondString.length(); i++) {
            secondSum += (int) secondString.charAt(i);
        }
        return (firstSum == secondSum);

    }
}
