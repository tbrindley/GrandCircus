/**
 * Created by travis on 6/26/2017.
 */

import java.util.Scanner;

public class PerimeterCalc {
    //method to get area of numbers
    public static double getArea(double length, double width){
        double area = length * width;
        return area;
    }
    //method to get perimeter of area
    public static double getPerimeter(double length, double width){
        double perimeter = (length * 2) + (width * 2);
        return perimeter;
    }
    //method to get volume of area
    public static double getVolume(double length, double width, double height){
        double volume = length * height * width;
        return volume;
    }

    public static void main(String[] args){

        System.out.println("Welcome to Grand Circus' Room Detail Generator!");

        Scanner scnr = new Scanner(System.in);

        char keepLooping;
        do{
            //input length
            System.out.print("Enter Length: ");
            double length = scnr.nextDouble();

            //input width
            System.out.print("Enter the width: ");
            double width = scnr.nextDouble();

            //input height
            System.out.print("Enter the height: ");
            double height = scnr.nextDouble();

            //creates area
            double area = getArea(length,width);
            System.out.println("Area: " + area);

            // creates perimeter
            double perimeter = getPerimeter(length,width);
            System.out.println("Perimeter: " + perimeter);

            //creates volume
            double volume = getVolume(length,width,height);
            System.out.println("Volume: " + volume);
            //asks if user wants to continue;
            System.out.print("Continue? (y or n):  ");
            keepLooping = scnr.next().charAt(0);
            System.out.println(keepLooping);


        }while(keepLooping != 'n');

    }
}
