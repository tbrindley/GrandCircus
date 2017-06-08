/**
 * Created by Travis Brindley on 5/31/2017.
 * Assignment:  Create an application that allows a user to input an integer.  The program will then compare the cubed
 *              values of each number within the integer and compare it to the original number.  If the two numbers are
 *              equal, the program should return a true response, else it should return false.
 */
import java.util.Scanner;

public class cube {
    public static void main(String[] args){

        //inputs original number
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");

        //verifies the number is an integer
        while(!input.hasNextInt()) {
            System.out.print("I'm sorry, please enter an integer: ");
            input.next();
        }
        //stores input into variable
        int original = input.nextInt();

        //converts original number to string to breakdown length
        String num = String.valueOf(original);

        //loops through length of original number
        int newTotal = 0;
        for (int i = 0; i < num.length();i++){
            int digit = Character.digit(num.charAt(i),10);

            //cubes individual numbers as double
           double stored = Math.pow(digit,3);

            //adds cubed numbers together as int
            newTotal +=  stored;

            System.out.printf("%d cubed equals: %.0f \n", digit, stored);
        }
        //bonus output
        System.out.printf("Adding up the cubed integers equals: %d \n", newTotal);
        System.out.printf("The original number equaled: %d \n", original);

        //returns Boolean response using ternary
        boolean matching = (original == newTotal);

        System.out.printf("These numbers match? %b", matching);
    }
}
