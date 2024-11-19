package gaussSolver;

public class Matrix {
    private double[][] matrix;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.matrix = new double[rows][cols];
    }

    public Matrix(double[][] matrix) {
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        this.matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(matrix[i], 0, this.matrix[i], 0, cols);
        }
    }

    public void setMatrix(int row, int col, double value) {
        matrix[row][col] = value;
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }

    public void swapRows(int r1, int r2) {
        double[] temp = matrix[r1];
        matrix[r1] = matrix[r2];
        matrix[r2] = temp;
    }

    public void toReducedRowEchelonForm() {
        int currCol = 0;
        int currRow = 0;
        int tempRow = 0;
        int tempCol = 0;

        //check the elements
        for (currRow = 0; currRow < rows; currRow++) {
            if (currCol >= cols) return;

            //look for the row with the non-zero element
            tempRow = currRow;
            while (matrix[tempRow][currCol] == 0) {
                tempRow++;
                if (tempRow == rows) {
                    tempRow = currRow;
                    currCol++;
                    if (currCol == cols) return; //stops if all are zero elements
                }
            }

            //swap the current row with the tempRow that holds where the non-zero element is (if they are different)
            //Row Interchange
            if (tempRow != currRow) {
                swapRows(tempRow, currRow);
            }

            //process the non-zero elements into 1 by using Scalar Multiplication
            double pivot = matrix[currRow][currCol];
            for (tempCol = 0; tempCol < cols; tempCol++) {
                matrix[currRow][tempCol] /= pivot;
            }

            //process the other non-zero elements to comply with reduced Row Echelon standards
            for (tempRow = 0; tempRow < rows; tempRow++) {//fir each other row in matrix
                if (tempRow != currRow) {
                    double c = matrix[tempRow][currCol];//get the value of c as the factor
                    for (tempCol = 0; tempCol < cols; tempCol++) {
                        matrix[tempRow][tempCol] -= c * matrix[currRow][tempCol]; //apply Addition of Scalar Multiples (using 'c' as coefficient in Rn + cRm -> Rn)
                    }
                }
            }
            currCol++;//next column
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append("[ ");
            for (int j = 0; j < cols; j++) {
                sb.append(String.format("%.4f", matrix[i][j]));
                if (j < cols - 1) sb.append("\t");
            }
            sb.append(" ]\n");
        }
        return sb.toString();
    }
}
