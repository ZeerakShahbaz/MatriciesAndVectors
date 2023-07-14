/**
 * Matrix class to represent a matrix of double numbers
 */
public class Matrix {
    private int numRows;
    private int numCols;
    private double[][] data;

    /**
     * Constructor which initializes the instance variables numRows and numCols and initializes data to
     * have r rows and c columns
     *
     * @param r number of rows
     * @param c number of columns
     */
    public Matrix(int r, int c) {
        this.numRows = r;
        this.numCols = c;
        this.data = new double[r][c];
    }

    /**
     * Constructors which initializes the instance variables and populates the 2-dimensional array data with
     * the elements in linArr
     *
     * @param r      number of rows
     * @param c      number of columns
     * @param linArr 1-dimensional array to be mapped to data
     */
    public Matrix(int r, int c, double[] linArr) {
        this.numRows = r;
        this.numCols = c;
        this.data = new double[r][c];
        int k = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                this.data[i][j] = linArr[k++];
            }
        }
    }

    /**
     * Gets number of rows in the matrix
     *
     * @return number of rows
     */
    public int getNumRows() {
        return this.numRows;
    }

    /**
     * Gets number of columns in the matrix
     *
     * @return number of columns
     */
    public int getNumCols() {
        return this.numCols;
    }

    /**
     * Gets the 2D array data
     *
     * @return data
     */
    public double[][] getData() {
        return this.data;
    }

    /**
     * Gets the element at a specific row and column
     *
     * @param r row index
     * @param c column index
     * @return data at row r and column c
     */
    public double getElement(int r, int c) {
        return this.data[r][c];
    }

    /**
     * Stores a value at a specific row and column
     *
     * @param r     row index
     * @param c     column index
     * @param value value to be stored
     */
    public void setElement(int r, int c, double value) {
        this.data[r][c] = value;
    }

    /**
     * Transposes the matrix
     */
    public void transpose() {
        double[][] transposed = new double[numCols][numRows];
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                transposed[j][i] = data[i][j];
            }
        }
        int temp = numRows;
        numRows = numCols;
        numCols = temp;
        data = transposed;
    }

    /**
     * Multiplies matrix by a scalar
     *
     * @param scalar scalar value to multiply the matrix with
     * @return resultant matrix
     */
    public Matrix multiply(double scalar) {
        Matrix result = new Matrix(numRows, numCols);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                result.data[i][j] = scalar * data[i][j];
            }
        }
        return result;
    }

    /**
     * Multiplies matrix by another matrix
     *
     * @param other other matrix to multiply with
     * @return resultant matrix
     */
    public Matrix multiply(Matrix other) {
        if (numCols != other.numRows) return null;
        Matrix result = new Matrix(numRows, other.numCols);
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < other.numCols; j++) {
                double sum = 0;
                for (int k = 0; k < numCols; k++) {
                    sum += data[i][k] * other.data[k][j];
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }

    /**
     * String representation of the matrix
     *
     * @return string representation of the matrix
     */
    @Override
    public String toString() {
        if (data.length == 0) return "Empty matrix";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                sb.append(data[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
