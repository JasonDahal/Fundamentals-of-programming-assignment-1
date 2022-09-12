import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

//import java.util.ArrayList;
public class AssignmentClass {  // This is the main class of assignment 1.

    public static String unitName(Scanner sc) { 
        return (sc.nextLine());
        

    }

    public static void printString(String sc) {
        System.out.println(sc);
        
        
    }


    public static ArrayList<Double> unitScore(Scanner sc) {
        ArrayList<Double> studentScores = new ArrayList<>();
        printString("Please enter the marks");
        do {
            Double numer = sc.nextDouble();
            if (numer > 0 && numer < 100) { //this will help to input number between 1-100.
                studentScores.add(numer);
            } else {
                printString("Sorry Invalid Number"); // Any number out of range from 1-100 will be invalid.
            }
        } while (studentScores.size() != 25); // illustrating the length of number that can be entered.

        return studentScores;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printString("Enter the unit name"); // This will help user to print unit name.

        String unitName = AssignmentClass.unitName(sc);
        ArrayList<Double> scores = unitScore(sc);
        printString("The name of the unit is: " + unitName);
        printString("---------------------------------------------------------------------------------------------\n");
        // Unit name entered by user will be displayed and will be allowed to print the student marks.
        printString("The numbers are: ");
        scores.forEach(x -> printString(String.valueOf(x)));
        printString("---------------------------------------------------------------------------------------------\n");


        printString("The highest mark is " + Collections.max(scores));// printing the highest mark
        printString("The lowest mark is " + Collections.min(scores)); // printing the lowest mark
        printString("---------------------------------------------------------------------------------------------\n");


        double mean = scores.stream().mapToDouble(x -> x).sum() / scores.size();
        printString("The mean is " + (mean)); // printing the mean of entered marks.
        printString("---------------------------------------------------------------------------------------------\n");

        double summation = 0.0;
        for (int i = 0; i < scores.size(); i++) {     //(x-mean)**2
            double intermediateValue = Math.pow((scores.get(i) - mean), 2);
            summation += intermediateValue;
        }
        int divisor = scores.size() - 1;     // N-1
        double nextIntermediateValue = summation / divisor;
        printString("The standard deviation is: " + Math.pow(nextIntermediateValue, 0.5)); // determining the standard deviation of the marks.
        printString("---------------------------------------------------------------------------------------------\n");


    }

}