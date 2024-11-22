package gaussSolver;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
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

        Matrix matrix = new Matrix(eqNum, varNum+1);

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
                if (j+1 == varNum) {
                    printPretty("What is the end constant?");
                    value = kbd.nextDouble();
                    matrix.setMatrix(i, j+1, value);
                }
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
        System.out.println(matrix);
        printPretty("");
        for (int i = 0; i < matrix.getRowsNum(); i++) {
            for (int j = 0; j < matrix.getColsNum(); j++) {
                if (j == (matrix.getColsNum() - 1)) {
                    printPretty("The value of X"+i+" is: "+matrix.getValue(i,j));
                }
            }
        }
        printPretty("");
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