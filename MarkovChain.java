/**
 * This class represents a Markov Chain to produce a matrix of predicted future states using a state vector and a transition matrix.
 */
public class MarkovChain {
    /**
     * Private instance variable to store the state vector
     */
    private Vector stateVector;

    /**
     * Private instance variable to store the transition matrix
     */
    private Matrix transitionMatrix;

    /**
     * Constructor to initialize the instance variables with the given parameters
     *
     * @param sVector state vector
     * @param tMatrix transition matrix
     */
    public MarkovChain(Vector sVector, Matrix tMatrix) {
        stateVector = sVector;
        transitionMatrix = tMatrix;
    }

    /**
     * Checks if the instance variables are valid for a Markov chain problem
     *
     * @return true if the instance variables are valid, false otherwise
     */
    public boolean isValid() {
        int numCols = stateVector.getNumCols();
        int numRows = transitionMatrix.getNumRows();

        // Check if the transition matrix is square
        if (numRows != transitionMatrix.getNumCols()) {
            return false;
        }

        // Checks if the number of columns in the state vector match the number of rows in the transition matrix
        if (numCols != numRows) {
            return false;
        }

        // Checks if the sum of values in the state vector is close to 1.0
        double sum = 0.0;
        for (int i = 0; i < numCols; i++) {
            sum += stateVector.getElement(i);
        }
        if (sum < 0.99 || sum > 1.01) {
            return false;
        }

        // Checks if the sum of values in each row of the transition matrix is close to 1.0
        for (int i = 0; i < numRows; i++) {
            sum = 0.0;
            for (int j = 0; j < numCols; j++) {
                sum += transitionMatrix.getElement(i, j);
            }
            if (sum < 0.99 || sum > 1.01) {
                return false;
            }
        }

        return true;
    }

    /**
     * Computes the probability matrix of this Markov chain after the given number of steps
     *
     * @param numSteps number of steps to compute the probability matrix for
     * @return the probability matrix after the given number of steps, or null if the instance variables are not valid
     */
    public Matrix computeProbabilityMatrix(int numSteps) {
        if (!isValid()) {
            return null;
        }

        Matrix result = transitionMatrix;
        for (int i = 1; i < numSteps; i++) {
            result = result.multiply(transitionMatrix);
        }

        return stateVector.multiply(result);
    }
}
