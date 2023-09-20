package J1SP0074;

public class Matrix {

    private int rows;
    private int cols;
    private int[][] matrix;

    public Matrix() {
    }

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new int[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getValue(int row, int column) {
        if (row < 0 || row >= rows || column < 0 || column >= cols) {
            throw new IllegalArgumentException("Invalid row or column index.");
        }
        return matrix[row][column];
    }

    public void setValue(int row, int column, int value) {
        if (row < 0 || row >= rows || column < 0 || column >= cols) {
            throw new IllegalArgumentException("Invalid row or column index.");
        }
        matrix[row][column] = value;
    }

    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println("");
        }
    }

    public Matrix addMatrix(Matrix matrix2) {
        int rows2 = matrix2.getRows();
        int cols2 = matrix2.getCols();
        if (rows != rows2 || cols != cols2) {
            throw new IllegalArgumentException("Invalid rows/cols!");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setValue(i, j, this.getValue(i, j) + matrix2.getValue(i, j));
            }
        }
        return result;
    }

    public Matrix subMatrix(Matrix matrix2) {
        int rows2 = matrix2.getRows();
        int cols2 = matrix2.getCols();
        if (rows != rows2 || cols != cols2) {
            throw new IllegalArgumentException("Invalid rows/cols!");
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setValue(i, j, this.getValue(i, j) - matrix2.getValue(i, j));
            }
        }
        return result;
    }

    public Matrix mulMatrix(Matrix matrix2) {
        int rows2 = matrix2.getRows();
        int cols2 = matrix2.getCols();
        if (cols != rows2) {
            throw new IllegalArgumentException("Invalid rows/cols!");
        }
        Matrix result = new Matrix(rows, cols2);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols2; j++) {
                int sum = 0;
                for (int k = 0; k < cols; k++) {
                    sum += this.getValue(i, k) * matrix2.getValue(k, j);
                }
                result.setValue(i, j, sum);
            }
        }
        return result;
    }

}
