package com.company;
import java.util.Scanner;

public class Main {

    static void convert(int m) {
        m *= 60;
        System.out.println("Секунд: "+m);
    }

    static void points (int n,int m) {
        int score;
        score = n*2 + m*3;
        System.out.println("Окончательные очки: " +score);
    }

    static void footballPoints (int win,int draw, int lose){
        int result = win*3 + draw;
        System.out.println("Окончательные очки: " +result);
    }

 static boolean divisibleByFive(int number){
        return number % 5 == 0;
    }

    static boolean and(boolean first, boolean second) {
        return first && second;
    }

    static void howManyWalls(int n,int w,int h) {
        int rez = 0;
        for (int nn =n;nn>w*h;nn=nn-w*h) {
            rez++;
        }
        System.out.println("Количество стен, которые можно покрасить: "+rez);
    }

    public static class Challenge {
        public static int squared(int b) {
            return b * b;
        }
    }

    static boolean profitableGamble(double prob,int prize,int pay){
        return prob*prize-pay>0;
    }

    static int frames(int min,int FPS){
        return min*60*FPS;
    }

    static int mod(int first,int second){
        return first-first/second*second;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

	// write your code here
        System.out.println("Введите минуты: ");
        int min = in.nextInt();
        convert(min);


        System.out.println("Введите количество голов в 1-м тайме: ");
        int score1 = in.nextInt();
        System.out.println("Введите количество голов во 2-м тайме: ");
        int score2 = in.nextInt();
        points(score1,score2);


        System.out.println("Введите количество побед: ");
        int win = in.nextInt();
        System.out.println("Введите количество ничьих: ");
        int draw = in.nextInt();
        System.out.println("Введите количество поражений: ");
        int lose = in.nextInt();
        footballPoints(win,draw,lose);


        System.out.println("Введите число: ");
        int number = in.nextInt();
        if (divisibleByFive(number)){
            System.out.println("Число равномерно делится на 5");
        }
        else {
            System.out.println("Число не равномерно делится на 5");
        }


        System.out.println("Первое значение true/false?");
        boolean first = in.nextBoolean();
        System.out.println("Второе значение true/false?");
        boolean second = in.nextBoolean();
        if (and(first,second)){
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }

        System.out.println("Введите количество краски: ");
        int paint = in.nextInt();
        System.out.println("Введите высоту стен: ");
        int h = in.nextInt();
        System.out.println("Введите ширину стен: ");
        int w = in.nextInt();
        howManyWalls(paint,h,w);


        System.out.println("Введите число: ");
        int num = in.nextInt();
        System.out.println("Вывод: "+Challenge.squared(num));


        System.out.println("Введите prob: ");
        double prob = in.nextDouble();
        System.out.println("Введите prize: ");
        int prize = in.nextInt();
        System.out.println("Введите pay: ");
        int pay = in.nextInt();
        System.out.println(profitableGamble(prob,prize,pay));


        System.out.println("Введите количество минут: ");
        int minute = in.nextInt();
        System.out.println("Введите количество FPS в секунду: ");
        int FPS = in.nextInt();
        System.out.println("Количество кадров за "+minute+" минут:" +frames(minute,FPS));


        System.out.println("Введите превое значение:");
        int f = in.nextInt();
        System.out.println("Введите второе значение:");
        int s = in.nextInt();
        System.out.println("Остаток от деления "+f+" на "+ s + ": " +mod(f,s));




    }
}
