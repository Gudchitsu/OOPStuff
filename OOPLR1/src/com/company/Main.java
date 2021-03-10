package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        boolean isReady = true;
        while (isReady){
            System.out.println("\nВыберите вариант:");
            System.out.println("1. Первое Задание");
            System.out.println("2. Второе Задание");
            System.out.println("3. Выход");
            byte zd = scan.nextByte();
            switch(zd){
                case 1:
                    System.out.print("Простые числа от 0 до 100: ");
                    for (int i=2;i<=100;i++) {
                        if(isPrime(i)) {
                            System.out.print(i + ", ");
                        }
                    }
                    break;


                case 2:
                    Scanner newscan =new Scanner (System.in);
                    System.out.println("Введите исходную сроку: ");
                    if(newscan.hasNextLine()){
                        String entStr = newscan.nextLine();
                        System.out.println("Обратная строка: "+reverseString(entStr));
                        boolean iPln= isPalindrome(reverseString(entStr),entStr);
                        if (iPln)
                        {
                            System.out.println("Введенная строка является палиндромом");
                        }
                        else System.out.println("Введенная строка не является палиндромом");
                    }
                    break;


                case 3:
                    isReady = false;
                    break;
            }
        }
    }

    public static boolean isPrime (int n){
        for (int i =2; i<n;i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static String reverseString (String enterStr)
    {
        String revStr = "";
        for (int i = enterStr.length()-1;i>=0;i--){
            revStr+=enterStr.charAt(i);
        }
        return revStr;
    }

    public static boolean isPalindrome (String revStr, String origStr){
        return origStr.equals(revStr);
    }

}
