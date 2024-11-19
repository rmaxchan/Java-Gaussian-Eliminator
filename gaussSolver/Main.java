package gaussSolver;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        //to-do: menu in terminal
        //  1. ask how many linear equations
        //  2. ask how many unknown variables
        //  3. print out a matrix with the given data
        printPretty("");
        printPretty("Welcome to the Gauss-Jordan Elimination processor!");
        printPretty("How many linear equations would you like to process?");
        printPretty("");
        int eqNum = kbd.nextInt();

        printPretty("");
        printPretty("Obtaining "+eqNum+" equations...");
        printPretty("How many variables does each equation have?");
        printPretty("");
        int varNum = kbd.nextInt();

        Matrix matrix = new Matrix(eqNum, varNum);

        printPretty("");
        printPretty(eqNum+" equations and "+varNum+" variables...");
        printPretty("");
        double value;
        for (int i = 0; i < eqNum; i++) {
            printPretty("Moving to equation no."+(i+1));
            for (int j = 0; j < varNum; j++) {
                printPretty("What is the coefficient for X"+(j+1));
                value = kbd.nextDouble();
                matrix.setMatrix(i, j, value);
            }
            printPretty("");
        }
        printPretty("The final matrix is:");
        printPretty("");

        System.out.println(matrix);
        printPretty("");
        printPretty("Its Reduced Row Echelon Form is:");
        printPretty("");
        matrix.toReducedRowEchelonForm();
        System.out.println(matrix);;

//        double[][] test = {
//                {1, 1, -1, -3},
//                {6, 2, 2, 2},
//                {-3, 4, 1, 1}
//        };
//
//        Matrix matrix = new Matrix(test);
//        System.out.println("Matrix:");
//        System.out.println(matrix);
//
//        matrix.toReducedRowEchelonForm();
//        System.out.println("New matrix:\n" + matrix);
    }

    private static void printPretty(String message) {
        final int WIDTH = 60;
        final String BORDER = "||";
        String padding = "=".repeat(WIDTH - 4);
        int spaces = WIDTH - message.length() - 4;
        int leftPad = spaces/2;
        int rightPad = spaces - leftPad;

        System.out.println(BORDER + " ".repeat(leftPad) + message + " ".repeat(rightPad) + BORDER);
    }
}
