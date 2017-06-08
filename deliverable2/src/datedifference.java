/**
 * Created by Travis Brindley on 6/1/2017.
 * Assignment:  write a java console app to calculate the duration between two dates in years, months, and days.
 *              The user should enter two dates as inputs and the result should be the difference.
 */

import java.util.Scanner;
public class datedifference {
    // method verifies the string is 10 characters long
    public static String verifyDate(String x){
        Scanner date = new Scanner(System.in);

        //confirms the date is 10 characters long
        while(x.length() != 10){
            System.out.print("Incorrect date length.  Please enter your date in the following format: mm/dd/yyyy:  ");
            x = date.next();
        }
        return x;
    }

    // converts the date into an int array
    public static int[] convert(String x){

        //breaks up start date into month, day, and year
        String month = x.substring(0,2);
        String day = x.substring(3,5);
        String year = x.substring(6,10);

        //converts month, day, and year into int.
        int mm = Integer.parseInt(month);
        int dd = Integer.parseInt(day);
        int yy = Integer.parseInt(year);

        int[] newdate = {mm,dd,yy};

        return newdate;
    }

    //checks for leap year
    public static int leapYear(int[] endDate){

        // sets February's days to 29 if leap year
        boolean isLeapYear = ((endDate[2] % 4 == 0) && (endDate[2] % 100 != 0) || (endDate[2] % 400 == 0));
        int x = 28;
        if (isLeapYear) {
            x = 29;
        }
        return x;
    }

    //gets the month difference
    public static int get_Month_Dif(int[] startDate, int[] endDate){
        int x;
        if(endDate[0] < startDate[0]){
            x = 12 - (startDate[0] - endDate[0]);
        }
        else if(endDate[0] == startDate[0] && endDate[1] == startDate[1]){
            x = 0;
        }
        else if(endDate[0] == startDate[0] && endDate[1] < startDate[1]){
            x = 11;
        }
        else
            x = endDate[0] - startDate[0];

        return x;
    }

    //gets the day difference
    public static int get_Day_Dif(int[] startDate, int[] endDate, int[] daysInMonth){
        int x;
        if(startDate[0] > endDate[0]){
            int y = daysInMonth[endDate[0]] - endDate[1];
            x = startDate[1] + y;
        }
        else if(endDate[0] == startDate[0] & endDate[1] < startDate[1]){
            int z = endDate[0] - 1;
            int y = daysInMonth[z];
            x = y - (startDate[1] - endDate[1]);
        }

        else
            x = endDate[1] - startDate[1];
        return x;
    }

    //gets the year difference
    public static int get_Year_Dif(int[] startDate, int[] endDate){
        int x = endDate[2] - startDate[2];
        if(endDate[0] < startDate[0]){
            x -= 1;
        }
        else if(endDate[0] == startDate[0] && endDate[1] < startDate[1]){
            x -= 1;
        }
        return x;
    }

    //does some validates the finished material is correct
    public static boolean validate(int[] startDate, int[] endDate, int[] daysInMonth){
        Boolean x = false;
        Boolean loop = true;
        while (loop){
            // verifies the start date is before the end date
            if ((startDate[2] > endDate[2]) ||(startDate[2] == endDate[2] && startDate[0] > endDate[0]) || (startDate[2] == endDate[2] && startDate[0] == endDate[0] && startDate[1] > endDate[1])){
                System.out.println("your start date is after your end date.  Please enter the earliest date first");
                x = true;
                loop = false;
            }
            //verifies the start month is a correct value
            int mm = startDate[0];
            if(mm > 12){
                System.out.println("your start date is not valid, please enter a correct month");
                x = true;
                loop = false;
            }
            //verifies the end month is a correct value
            mm = endDate[0];
            if(mm > 12){
                System.out.println("your end date is not valid, please enter a correct month");
                x = true;
                loop = false;
            }
            //verifies the start day is within the month
            mm = startDate[0];
            mm = mm - 1;
            if(startDate[1] > daysInMonth[mm]){
                System.out.println("Your start date has too many days in the month, please enter a correct date.");
                x = true;
                loop = false;
            }
            //verifies the end day is within the month
            mm = endDate[0] - 1;
            mm = mm - 1;
            if(endDate[1] > daysInMonth[mm]){
                System.out.println("Your end date has too many days in the month, please enter a correct date.");
                x = true;
                loop = false;
            }
            loop = false;
        }

        return x;
    }


    public static void main(String[] args) {
        Scanner date = new Scanner(System.in);

        int [] startDate;
        startDate = new int[3];
        int [] endDate;
        endDate = new int[3];
        boolean qualityControl = true;
        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        while (qualityControl){
            for(int i = 0; i < 2; i++) {
                //input date as mm/dd/yyyy format as string
                if(i == 0) {
                    System.out.print("Please enter your first date: mm/dd/yyyy:  ");
                }
                else{
                    System.out.print("Please enter your second date: mm/dd/yyyy:  ");
                }
                String x = date.next();

                //verifies the date is 10 characters long
                x = verifyDate(x);
                int [] holder = convert(x);
                if(i == 0) {
                    startDate[0] = holder[0]; startDate[1] = holder[1]; startDate[2] = holder[2];
                }
                else{
                    endDate[0] = holder[0]; endDate[1] = holder[1]; endDate[2] = holder[2];
                }
            }
            //accounts for leap year
            daysInMonth[1] = leapYear(endDate);

            //verifies dates are in correct order, correct days in month, & a valid month
            qualityControl = validate(startDate,endDate,daysInMonth);
        }



        //gets difference in months from method
        int monthDif = get_Month_Dif(startDate,endDate);

        //gets difference in days from method
        int dayDif = get_Day_Dif(startDate,endDate, daysInMonth);

        //gets difference in years from method
        int yearDif = get_Year_Dif(startDate,endDate);
        System.out.printf("The total difference between the two dates is: \n %d Years \n %d Months \n %d Days",yearDif,monthDif,dayDif);
    }
}
