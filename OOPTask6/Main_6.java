package Practic_6;

import java.util.*;
import java.util.stream.Collectors;

public class Main_6 {

    public static String hiddenAnagram(String string, String substring) {
        string = string.toLowerCase().replaceAll("[^a-z]", ""); // Убираем все символы в строке кроме букв
        substring = substring.toLowerCase().replaceAll(" ", ""); // Убираем все пробелы
        // Проходим в течение разницы между длинами строк
        for (int i = 0; i < string.length() - substring.length() + 1; i++) {
            // Если i символ в первой строке присутствует во второй строке
            if (substring.indexOf(string.charAt(i)) > -1) {
                // Создаём подстроку от найденного символа до длины второй строки + i
                String subT = string.substring(i, i + substring.length());
                // Проверяем является ли полученная строка анаграмой
                if (isAnagram(subT, substring)) {
                    return subT;
                }
            }
        }
        return "noutfond";
    }

    private static Boolean isAnagram(String firstString, String secondString) {
        StringBuilder s = new StringBuilder(secondString); // Создаём объект класса StringBuilder из второй строки
        // Проходим по всем символам строки, которая может быть анаграммой
        for (int i = 0; i < firstString.length(); i++) {
            int in = s.indexOf(String.valueOf(firstString.charAt(i))); // Находим индекс i символа строки во второй строке
            // Если символ отсутствует во второй строке, значит это не анаграмма
            if (in == -1) {
                return false;
            }
            s.setCharAt(in, '-'); // Меняем символ на -
        }
        return true;
    }


    public static String[] collect(String string, int n) {
        // Если длина строки меньше, чем длина среза, возвращаем пустой массив
        if (string.length() < n) return new String[0];
        String[] w = collect(string.substring(n), n); // Вызываем метод с урезанной строкой
        String[] v = new String[w.length + 1]; // Создаём массив размером = кол-во слов
        v[0] = string.substring(0, n); // Вставляем первое слово в массив
        for (int i = 0; i < w.length; i++) v[i + 1] = w[i]; // Добавляем остальные слова
        Arrays.sort(v); // Сортируем полученный массив
        return v;
    }


    public static String nicoCipher(String string, String key) {
        int stringLength = string.length(); // Получаем длину строки
        int keyLength = key.length(); // Получем длину ключа
        int r = (stringLength - stringLength % keyLength) / keyLength; // Переменная для назначения номеров для букв сообщения
        if (stringLength % keyLength != 0) r++; // Увеличиваем на 1, в зависимости от чётности
        for (int i = stringLength; i < r * keyLength; i++)
            string += " ";
        char[][][] v = new char[r][keyLength][2]; // Создаём массив для хранения букв и номеров
        // Заполняем массив
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < keyLength; j++) {
                v[i][j][0] = string.charAt(i * keyLength + j);
                v[i][j][1] = key.charAt(j);
            }
            Arrays.sort(v[i], (a, b) -> (int) a[1] - (int) b[1]); // Сортируем полученный массив
        }
        String eMessage = "";
        for (int i = 0; i < r; i++)
            for (int j = 0; j < keyLength; j++)
                eMessage += v[i][j][0]; // Формируем строку
        return eMessage;
    }


    public static int[] twoProduct(int[] array, int product) {
        // Проходим по массиву
        for (int i = 1; i < array.length; i++) {
            // Проходим по массиву до i числа
            for (int j = 0; j < i; j++) {
                // Если произведение чисел равно необходимому числу
                if (array[j] * array[i] == product) {
                    // Заполняем массив соответствующими числами
                    int[] result = new int[2];
                    result[0] = array[j];
                    result[1] = array[i];
                    return result; // Возвращаем массив
                }
            }
        }
        // Если не нашли соответствие, возвращаем пустой массив
        int[] result = new int[1];
        return result;
    }


    public static int[] isExact(int n, int... f) {
        if (f.length < 2) return isExact(n, 1, 1);
        f[1] *= ++f[0];
        if (f[1] < n) {
            return isExact(n, f[0], f[1]);
        } else if (f[1] == n) {
            return new int[]{n, f[0]};
        } else {
            return new int[0];
        }
    }


    public static String fractions(String decimal) {
        long n1 = Long.parseLong(decimal.replaceAll("(.*)\\(.*", "$1").replace(".", ""));
        long n2 = Long.parseLong(decimal.replaceAll("[\\(\\)\\.]", ""));
        int exp1 = decimal.replaceAll("\\d+\\.(\\d*)\\(\\d+\\)", "$1").length();
        int exp2 = decimal.replaceAll("\\d+\\.(?=.*)", "").replaceAll("[\\(\\)]", "").length();
        long num = n2 - n1;
        long div = (long) Math.pow(10, exp2) - (long) Math.pow(10, exp1);
        long gcdiv = gcd(num, div);
        num = num / gcdiv;
        div = div / gcdiv;
        return String.format("%d/%d", num, div);
    }

    private static long gcd(long a, long b) {
        return (b == 0) ? a : gcd(b, a % b);
    }


    public static String pilishString(String string) {
        int[] pi = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 8, 9, 7, 9};
        int i = 0;
        String str = "";

        while (i < 15 && string.length() >= pi[i]) {
            str += string.substring(0, pi[i]) + " ";
            string = string.substring(pi[i]);
            i++;
        }
        return string.isEmpty() || i == 15 ? str.trim() : str + string + String.format("%0" + (pi[i] - string.length()) + "d", 0).replace('0', string.charAt(string.length() - 1));
    }


    public static String generateNonconsecutive(int n) {
        String ans = "";
        for (int i = 0; i < Math.pow(2, n); i++) {
            String b = Integer.toBinaryString(i);
            while (b.length() < n) b = "0" + b;
            if (b.indexOf("11") < 0) ans += " " + b;
        }
        return ans.substring(1);
    }


    public static String isValid(String string) {
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < string.length(); i++) {
            char key = string.charAt(i);
            if (map.get(key) != null)
                map.put(key, map.get(key) + 1);
            else
                map.put(key, 1);
        }
        ArrayList<Integer> mapValues = new ArrayList(map.values());
        int max = (int) Collections.max(mapValues);
        int min = (int) Collections.min(mapValues);
        if (max == min)
            return "YES";
        int minСount = 0, maxСount = 0;
        for (int i = 0; i < mapValues.size(); i++) {
            if (mapValues.get(i) == max)
                maxСount++;
            else if (mapValues.get(i) == min)
                minСount++;
        }
        return (minСount == 1 || (maxСount == 1 && max == min + 1)) ? "YES" : "NO";
    }


    public static int[][] sumsUp(int[] array) {
        int[][] tempResult = new int[array.length][2];
        int resultCounter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (array[i] + array[j] == 8 && array[i] != 8 && array[j] != 8) {
                    if (array[i] < array[j]) {
                        tempResult[resultCounter][0] = array[i];
                        tempResult[resultCounter][1] = array[j];
                    } else {
                        tempResult[resultCounter][0] = array[j];
                        tempResult[resultCounter][1] = array[i];
                    }
                    resultCounter++;
                }
            }
        }
        int[][] result = new int[resultCounter][2];
        for (int i = 0; i < resultCounter; i++) {
            result[i][0] = tempResult[i][0];
            result[i][1] = tempResult[i][1];
        }
        return result;
    }
}
