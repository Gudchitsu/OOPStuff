package com.company;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Locale;


public class Main {

    public static void main(String[] args) {
        cycle:
        while (true) {
            switch (TaskMenu.createMenu()) {
                case 1:
                    while (true) {
                        try {
                            System.out.println("\nВведите числа через пробел");
                            int[] array = intArrayCreator();
                            System.out.println(sevenBoom(array));
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
                            System.out.println("\nВведите числа через пробел");
                            int[] array = intArrayCreator();
                            System.out.println(cons(array));
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
                            System.out.println("\nВведите строку");
                            String string = in.nextLine();
                            System.out.println(unmix(string));
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
                            Scanner in = new Scanner(System.in);
                            System.out.println("\nВведите строку");
                            String string = in.nextLine();
                            System.out.println(noYelling(string));
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
                            System.out.println(xPronounce(string));
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
                            System.out.println("\nВведите числа через пробел");
                            int[] array = intArrayCreator();
                            System.out.println("Самый большой разрыв в массиве: " + largestGap(array));
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
                            System.out.println("\nВведите число");
                            int number = in.nextInt();
                            System.out.println(trick(number));
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
                            System.out.println(commonLastVowel(string));
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
                            System.out.println("\nВведите первое число");
                            int firstNumber = in.nextInt();
                            System.out.println("\nВведите второе число");
                            int secondNumber = in.nextInt();
                            System.out.println(memeSum(firstNumber, secondNumber));
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
                            System.out.println("\nВведите строку");
                            String string = in.nextLine();
                            System.out.println(unrepeated(string));
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

    public static int[] bubbleSorter(int array[]) {
        boolean needIteration = true; // Переменная для проверки
        while (needIteration) {
            needIteration = false; // Допускаем, что массив отсортирован
            // Проходим по массиву
            for (int i = 1; i < array.length; i++) {
                // Если предыдущий элемент в массиве больше, чем текущий
                if (array[i] < array[i - 1]) {
                    int tmp = array[i]; // Запоминаем текущий элемент
                    array[i] = array[i - 1]; // На позицию текущего ставим предыдущий
                    array[i - 1] = tmp; // На позицию предыдущего ставим текущий
                    needIteration = true; // Меняем переменную
                }
            }
        }
        return array;
    }

    public static String sevenBoom(int array[]) {
        int count = 0; // Создаём счётчик
        // Проходим по всему массиву
        for (int i = 0; i < array.length; i++) {
            // Если число является 7
            if (String.valueOf(array[i]).contains("7")) {
                count = 1;
            }
        }
        // Если count изменилось
        if (count != 0) {
            return "Бум!";
        } else {
            return "В массиве нет 7";
        }
    }

    public static boolean cons(int array[]) {
        array = bubbleSorter(array); // Сортируем массив
        boolean isOkey = true; // Переменная для проверки
        // Проходим по массиву
        for (int i = 1; i < array.length; i++) {
            // Если предыдущий элемент в массиве отличен от текущего более чем на 1
            if (array[i] - 1 != array[i - 1]) {
                isOkey = false;
            }
        }
        return isOkey;
    }

    public static String unmix(String string) {
        String result = ""; // Создаём пустую строку
        // Проходим по всей строке
        for (int i = 0; i < string.length(); i++) {
            // Если i нечетное
            if (i % 2 == 1) {
                // Добавляем к строке i символ из строки и i-1 символ
                result += string.charAt(i) + "" + string.charAt(i - 1);
            }
        }
        // Если длина строки нечетная
        if (string.length() % 2 != 0) {
            // Добавляем последний символ
            result += string.charAt(string.length() - 1);
        }
        return result;
    }

    public static String noYelling(String string) {
        StringBuilder stringBuilder = new StringBuilder(string); // Создаём StringBuilder
        // Проходим по всей строке с конца
        for (int i = string.length() - 1; i > 0; i--) {
            // Если i символ не ? и не !
            if (string.charAt(i) != '?' && string.charAt(i) != '!') {
                // Если этот символ последний, значит в строке нет ! и нет ?
                if (i == string.length() - 1) {
                    break;
                }
                // Если после i символа стоит !
                else if (string.charAt(i + 1) == '!') {
                    // Заменяем в строке всё начиная от ! до конца строки одним !
                    string = stringBuilder.replace(i + 1, string.length(), "!").toString();
                    break;
                }
                // Если после i символа стоит ?
                else if (string.charAt(i + 1) == '?') {
                    // Заменяем в строке всё начиная от ? до конца строки одним ?
                    string = stringBuilder.replace(i + 1, string.length(), "?").toString();
                    break;
                }
            }
        }
        return string;
    }

    public static String xPronounce(String string) {
        String result = ""; // Создаём пустую строку
        // Проходим по все строке
        for (int i = 0; i < string.length(); i++) {
            // Если находим символ 'х'
            if (string.charAt(i) == 'x') {
                // Если до и после символа стоят пробелы, значит он одиночный
                if (string.charAt(i - 1) == ' ' && string.charAt(i + 1) == ' ') {
                    result += "ecks";
                    // Если до символа стоит пробел, а после нет, значит он находится в начале слова
                } else if (string.charAt(i - 1) == ' ' && string.charAt(i + 1) != ' ') {
                    result += 'z';
                    // Если он в конце или в середине слова
                } else {
                    result += "cks";
                }
                // Если не нашли символ 'x'
            } else {
                result += string.charAt(i);
            }
        }
        return result;
    }

    public static int largestGap(int array[]) {
        array = bubbleSorter(array); // Сортируем массив
        int gap = 0; // Создаём переменную для наибольшего разрыва
        int tmpGap = 0; // Создаём временную переменную
        // Проходим по всему массиву
        for (int i = 0; i < array.length - 1; i++) {
            tmpGap = array[i + 1] - array[i]; // Считаем разницу между i+1 и i элементами
            // Если разница больше, текущей максимальной
            if (gap < tmpGap) {
                gap = tmpGap; // Записываем в переменную полученную разницу
            }
        }
        return gap;
    }

    public static int trick(int number) {
        int tmpNumber = number;
        String tmp = Integer.toString(tmpNumber); // Создаём String для получения длины числа
        int[] intArray = new int[tmp.length()]; // Инициализируем int массив
        // Проходим по всему массиву символов
        for (int i = 0; tmpNumber > 0; tmpNumber /= 10) {
            intArray[i] = tmpNumber % 10; // Заполняем массив цифрами числа
            i++;
        }

        intArray = bubbleSorter(intArray); // Сортируем массив
        String sortedNumber = ""; // Создаём строку
        for (int i = 0; i < intArray.length; i++) {
            sortedNumber += intArray[i]; // Добавляем цифры в строку
        }
        // Возвращаем разницу между числом и его отсортированной копией
        return number - Integer.valueOf(sortedNumber);
    }

    public static String commonLastVowel(String string) {
        string = string.toLowerCase(Locale.ROOT); // Приводим строку к нижнему регистру
        // Массив из всех гласных букв
        Character[] characters = {'у', 'е', 'ы', 'а', 'о', 'э', 'я', 'и', 'ю',
                'e', 'y', 'u', 'i', 'o', 'a'};
        // Массив со счётчиком под каждую гласную
        int[] count = new int[15];

        // Проходим по каждой букве
        for (int i = 0; i < characters.length; i++) {
            // Проходим по всей строке
            for (int j = 0; j < string.length(); j++) {
                // Если символ в строке = букве
                if (string.charAt(j) == characters[i]) {
                    count[i] += 1; // Добавляем к счётчику этой буквы 1
                }
            }
        }

        int indexMax = -1; // Создаём переменную, чтобы запомнить индекс счётчика с макс. значением
        int max = 0; // Создаём переменную для макс. значения
        // Проходим по массиву со счётчиками
        for (int i = 0; i < count.length; i++) {
            // Если значение счётчика, больше чем максимальное
            if (count[i] > max) {
                max = count[i]; // Максимальному присваиваем текущее
                indexMax = i; // Запоминаем индекс
            }
        }
        // Если indexMax не изменилась, значит гласных нет
        if (indexMax == -1) {
            return "В предложении нет гласных";
        }
        return String.valueOf(characters[indexMax]);
    }

    public static int memeSum(int firstNumber, int secondNumber) {
        // Находим наибольшую длину числа
        int maxLength;
        if (String.valueOf(firstNumber).length() > String.valueOf(secondNumber).length()) {
            maxLength = String.valueOf(firstNumber).length();
        } else {
            maxLength = String.valueOf(secondNumber).length();
        }

        String result = ""; // Создаём строку для заполнения
        // Запускаем цикл, где кол-во итераций = длине числа с наибольшим кол-вом разрядов
        for (int i = 0; i < maxLength; i++) {
            int firstArg = firstNumber % 10; // Первый аргумент = последняя цифра первого числа
            int secondArg = secondNumber % 10; // Второй аргумент = последня цифра второго числа
            int sum = firstArg + secondArg; // Сумма аргументов
            result = sum + result; // Записываем в строку сумму аргументов + строку
            firstNumber /= 10; // Убираем последнюю цифру первого числа
            secondNumber /= 10; // Убираем последнюю цифру второго числа
        }
        return Integer.valueOf(result);
    }

    public static String unrepeated(String string) {
        // Проходим по каждому символу в строке
        for (int i = 0; i < string.length(); i++) {
            // Пока находим с конца строки такой же символ
            while (string.lastIndexOf(string.charAt(i)) != string.indexOf(string.charAt(i))) {
                int index = string.lastIndexOf(string.charAt(i)); // Запоминаем индекс символа в строке
                // Переписываем строку, добавляя в неё всё до символа и всё после него, не включая сам символ
                string = string.substring(0, index) + string.substring(index + 1);
            }
        }
        return string;
    }

    public static int[] intArrayCreator() {
        Scanner input = new Scanner(System.in);
        String tmp = input.nextLine();
        int[] array; // Создаём массив
        array = Arrays.stream(tmp.split(" ")).mapToInt(Integer::parseInt).toArray();
        return array;
    }

}