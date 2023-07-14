public class Vector extends Matrix {
    /**
     * Constructor which initializes the instance variables
     *
     * @param c number of columns
     */
    public Vector(int c) {
        super(1, c);
    }

    /**
     * Constructor which initializes the instance variables and populates the 2D data array
     *
     * @param c      number of columns
     * @param linArr 1D array to be mapped to data
     */
    public Vector(int c, double[] linArr) {
        super(1, c, linArr);
    }

    /**
     * Gets the element at a specific column
     *
     * @param c column index
     * @return data at row 0 and column c
     */
    public double getElement(int c) {
        return super.getElement(0, c);
    }
}
