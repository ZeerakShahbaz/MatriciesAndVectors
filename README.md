# MatriciesAndVectors

Java Implementation of Markov Chains Using Matrices and Vectors
This project involves implementing Markov Chains, a powerful probabilistic tool often used for predicting the future state of a system based on its current state and historic patterns.

Markov Chains assume the presence of a finite number of independent states that can transition to each other with known probabilities. This model can be represented using matrices and vectors, fundamental structures in linear algebra, with applications spanning computer science, mathematics and several other areas.

Core Structures
Matrix: A 2-dimensional table of numbers arranged in rows and columns, commonly used to represent data in a structured format. Matrix multiplication is a critical operation that finds use in various applications such as computer graphics, solving linear equations, data modelling, and more.

Vector: A special type of matrix with only 1 row or 1 column, essentially a 1-dimensional entity. Vectors, similar to arrays, and matrices, similar to 2-dimensional arrays, are used to represent states and transition probabilities in Markov Chains.

Classes to Implement
Three main classes form the backbone of this assignment:

Matrix: Represents a mathematical matrix, holding data and allowing operations such as multiplication.

Vector: Represents a mathematical vector, holding state data.

MarkovChain: Utilizes Matrix and Vector classes to implement a Markov Chain, enabling prediction of future states based on the current state and the transition probabilities.

Usage
The Markov Chain model can predict the state of a system after a given number of time units by raising the transition matrix to the power equivalent to the time units and then multiplying the resulting matrix with the current state vector.




