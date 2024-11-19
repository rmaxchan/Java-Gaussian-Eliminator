package gaussSolver;
public class Main {
    public static void main(String[] args) {
        double[][] test = {
                {1, 1, -1, -3},
                {6, 2, 2, 2},
                {-3, 4, 1, 1}
        };

        Matrix matrix = new Matrix(test);
        System.out.println("Matrix:");
        System.out.println(matrix);

        matrix.toReducedRowEchelonForm();
        System.out.println("New matrix:\n" + matrix);
    }
}
