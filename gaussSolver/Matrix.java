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

    public Matrix(double[][] data) {
        this.rows = data.length;
        this.cols = data[0].length;
        this.matrix = new double[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data[i], 0, this.matrix[i], 0, cols);
        }
    }

    public void setMatrix(int row, int col, double value) {
        matrix[row][col] = value;
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }

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
