package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here

        Point3D PointA = null;
        Point3D PointB = null;
        Point3D PointC = null;

        String[] inputs=GetInput();
        if(inputs!=null){
            PointA=new Point3D(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]));

            System.out.println(String.format("Создана точка с координатами: {%.2f; %.2f; %.2f}",
                    PointA.getPointX(), PointA.getPointY(), PointA.getPointZ() ));
        }

        inputs=GetInput();
        if(inputs!=null){
            PointB=new Point3D(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]));

            System.out.println(String.format("Создана точка с координатами: {%.2f; %.2f; %.2f}",
                    PointB.getPointX(), PointB.getPointY(), PointB.getPointZ() ));
        }

        inputs=GetInput();
        if(inputs!=null){
            PointC=new Point3D(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), Integer.parseInt(inputs[2]));

            System.out.println(String.format("Создана точка с координатами: {%.2f; %.2f; %.2f}",
                    PointC.getPointX(), PointC.getPointY(), PointC.getPointZ() ));
        }

        System.out.println(String.format("Площадь треугольника равна: %.2f", computeArea(PointA, PointB, PointC)));

    }



    public static String[] GetInput() /* Метод обработки ввода с клавиатуры */ {
        Scanner scanner=new Scanner(System.in);
        String[] inputs=null;
        System.out.println("Введите координаты точки в пространстве: ");

        if(scanner.hasNextLine()) {
            String tmp = scanner.nextLine();
            inputs=tmp.split(" ");
        }
        return inputs;
        }


    public static double computeArea(Point3D firstPoint, Point3D secondPoint, Point3D thirdPoint) {
        double cadetA =firstPoint.distanceTo(secondPoint);
        double cadetB =secondPoint.distanceTo(thirdPoint);
        double hypotenuse =thirdPoint.distanceTo(firstPoint);
        double halfPerimeter=(cadetA + cadetB + hypotenuse)/2;
        return Math.sqrt(halfPerimeter * (halfPerimeter-cadetA) * (halfPerimeter-cadetB) * (halfPerimeter-hypotenuse));
        }

}
