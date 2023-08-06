package questions;

public class QuestionTwo {

    // implemente uma função que, dado uma matriz A e uma submatriz B
    // (dimensões menores que A), esta função retorne quantas vezes esta submatriz B
    // pode ser encontrada na matriz A.

    public static int countSubMatrixMatches(Object[][] matrix, Object[][] subMatrix) throws Exception {
        int count = 0;

        validateMatrices(matrix, subMatrix);

        int rowsMatrix = matrix.length;
        int columnsMatrix = matrix[0].length;
        int rowsSubMatrix = subMatrix.length;
        int columnsSubMatrix = subMatrix[0].length;

        for (int i = 0; i <= rowsMatrix - rowsSubMatrix; i++) {
            for (int j = 0; j <= columnsMatrix - columnsSubMatrix; j++) {
                if (isSubMatrixOf(matrix, subMatrix, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean isSubMatrixOf(Object[][] matrix, Object[][] subMatrix, int startRow, int startCol) {
        int subMatrixRows = subMatrix.length;
        int subMatrixColumns = subMatrix[0].length;

        for (int i = 0; i < subMatrixRows; i++) {
            for (int j = 0; j < subMatrixColumns; j++) {
                if (matrix[startRow + i][startCol + j] != subMatrix[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void validateMatrices(Object[][] matrix, Object[][] subMatrix) throws Exception {
        int rowsMatrix = matrix.length;

        if(rowsMatrix <= 1){
            throw new Exception("The matrix lines should be bigger than one.");
        }

        int columnsMatrix = matrix[0].length;

        if(columnsMatrix <= 1){
            throw new Exception("The matrix columns should be bigger than one.");
        }

        int rowsSubMatrix = subMatrix.length;

        if(rowsSubMatrix <= 0){
            throw new Exception("The sub matrix lines should be bigger than zero.");
        }

        int columnsSubMatrix = subMatrix[0].length;

        if(columnsSubMatrix <= 0){
            throw new Exception("The sub matrix columns should be bigger than zero.");
        }

        if(rowsSubMatrix > rowsMatrix || columnsSubMatrix > columnsMatrix){
            throw new Exception("The matrix should be bigger than sub matrix!");
        }

        if(rowsSubMatrix == rowsMatrix && columnsSubMatrix == columnsMatrix){
            throw new Exception("The matrix should be bigger than sub matrix!");
        }
    }

    public static void main(String[] args) throws Exception {
        Object[][] matrixOne = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        Object[][] subMatrixOne = {
                {1, 2},
                {4, 5},
                {7, 8}
        };

        int expectedResultOne = 1;
        int occurrencesOne = countSubMatrixMatches(matrixOne, subMatrixOne);

        Object[][] matrixTwo = {
                {1, 2, 3},
                {4, 1, 2},
                {1, 2, 9}
        };

        Object[][] subMatrixTwo = {
                {1, 2}
        };

        int expectedResultTwo = 3;
        int occurrencesTwo = countSubMatrixMatches(matrixTwo, subMatrixTwo);

        Object[][] matrixThree = {
                {"a", "b", "c", "d", "e"},
                {"f", "g", "a", "b", "e"},
                {"a", "b", "c", "d", "e"},
                {"f", "g", "a", "d", "e"}
        };

        Object[][] subMatrixThree = {
                {"b", "c"},
                {"g", "a"}
        };

        // sub matrix bigger than matrix
        Object[][] invalidSubMatrixOne = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12}
        };

        int expectedResultThree = 2;
        int occurrencesThree = countSubMatrixMatches(matrixThree, subMatrixThree);

        boolean firstAssertion = expectedResultOne == occurrencesOne;

        boolean secondAssertion = expectedResultTwo == occurrencesTwo;

        boolean thirdAssertion = expectedResultThree == occurrencesThree;

        if(!firstAssertion || !secondAssertion || !thirdAssertion){
            System.out.println("Something went wrong!!!");
        }

        // throws exception
        // countSubMatrixMatches(matrixOne, invalidSubMatrixOne);

    }
}
