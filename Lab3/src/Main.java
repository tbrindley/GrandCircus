import java.util.Scanner;

/**
 * Created by Travis Brindley on 6/27/2017.
 * Creates a program that will display a table of powers
 * Specifics:  Prompts the user to enter an integer
 * Displays a table of squares and cubes from 1 to the value entered.
 * Asks the user if they wish to continue.
 */

public class Main {
    public static int squareIt(int i) {
        double x = Math.pow(i, 2);
        int squared = (int) x;
        return squared;
    }

    public static int cubeIt(int i) {
        double x = Math.pow(i, 3);
        int cubed = (int) x;
        return cubed;
    }

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        char cont;

        System.out.println("Lab 3 - Powers Table");

        do {
            System.out.print("Please enter an integer:  ");

            //verifies that the user entered an integer
            while (!scnr.hasNextInt()) {
                System.out.print("I'm sorry, that isn't a valid integer. Please enter an integer: ");
                scnr.next();
            }

            int number = scnr.nextInt();

            //sets counter to 1
            int i = 1;

            System.out.println("Number        Squared        Cubed");
            System.out.println("======        =======       =======");
            while (i <= number) {
                int squared = squareIt(i);
                int cubed = cubeIt(i);
                System.out.printf("%4d%14d%14d \n", i, squared, cubed);
                i += 1;
            }
            System.out.print("Continue? Y/N: ");
            cont = scnr.next().charAt(0);

        } while (cont == 'y' || cont == 'Y');

        System.out.println("Thanks!");

    }
}
