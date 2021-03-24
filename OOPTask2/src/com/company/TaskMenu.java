package com.company;
import java.util.Scanner;

    public class TaskMenu {

        public static int createMenu() {
            while (true) {
                int input = 0;
                System.out.println("\nЗадача №1 (1)"
                        + "\nЗадача №2 (2)"
                        + "\nЗадача №3 (3)"
                        + "\nЗадача №4 (4)"
                        + "\nЗадача №5 (5)"
                        + "\nЗадача №6 (6)"
                        + "\nЗадача №7 (7)"
                        + "\nЗадача №8 (8)"
                        + "\nЗадача №9 (9)"
                        + "\nЗадача №10 (10)"
                        + "\nВыход (0)");
                try {
                    Scanner in = new Scanner(System.in);
                    input = in.nextInt();
                } catch (Exception exception) {
                    System.out.println("Ошибка: " + exception + ". Повторите ввод");
                    continue;
                }
                if (input > 10 || input < 0) {
                    System.out.println("Ошибка: Недопустимое число. Повторите ввод");
                    continue;
                }
                return input;
            }
        }
    }

