package tech.test;

import java.util.Arrays;

public class QuestionOne {

    // "implemente uma função que inverta as diagonais de uma matriz quadrada."

    public static void reverseDiagonals(Object[][] mat) throws Exception {
        validateMatrix(mat);

        int aux = 0;
        int halfLength = mat.length/2;

        for (int i = 0; i < halfLength; i++){
            if(mat.length != 2){
                switchValues(mat[i], i, halfLength - i + 1);
            }else{
                // 2x2 condition
                switchValues(mat[i], i, halfLength - i);
            }
        }

        for (int j = mat.length-1; j >= halfLength; j--){
            switchValues(mat[j], j, aux);
            aux++;
        }
    }

    private static Object[] switchValues(Object[] line, int a, int b){
        Object auxValue = line[b];
        line[b] = line[a];
        line[a] = auxValue;
        return line;
    }

    private static void validateMatrix(Object[][] mat) throws Exception {
        int lines = mat.length;
        if(lines == 0){
            throw new Exception("This matrix has empty line values. Please input a valid one!");
        }

        int columns = mat[0].length;
        if(columns == 0){
            throw new Exception("This matrix has empty column values. Please input a valid one!");
        }

        if(lines != columns || lines == 1){
            throw new Exception("This is not a square matrix. Please input a valid one!");
        }
    }


    public static void main(String[] args) throws Exception {
        Object[][] exampleOne = {
                { 1,  2,  3,  4},
                { 5,  6,  7,  8},
                { 9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        Object[][] expectedOutputOne = {
                { 4,  2,  3,  1},
                { 5,  7,  6,  8},
                { 9, 11, 10, 12},
                {16, 14, 15, 13}
        };

        Object[][] exampleTwo = {
                {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"}
        };

        Object[][] expectedOutputTwo = {
                {"c", "b", "a"},
                {"d", "e", "f"},
                {"i", "h", "g"}
        };

        Object[][] exampleThree = {
                {-4, -3},
                {-2, -1},
        };

        Object[][] expectedOutputThree = {
                {-3, -4},
                {-1, -2},
        };

        // not square
        Object[][] invalidExampleOne = {
                { 1,  2,  3,  4},
                { 5,  6,  7,  8},
        };

        // not populated
        Object[][] invalidExampleTwo = {};

        // one item only
        Object[][] invalidExampleThree = {
                {"a"},
        };

        reverseDiagonals(exampleOne);
        boolean firstAssertion = Arrays.deepEquals(expectedOutputOne, exampleOne);

        reverseDiagonals(exampleTwo);
        boolean secondAssertion = Arrays.deepEquals(expectedOutputTwo, exampleTwo);

        reverseDiagonals(exampleThree);
        boolean thirdAssertion = Arrays.deepEquals(expectedOutputThree, exampleThree);

        if(!firstAssertion || !secondAssertion || !thirdAssertion){
            System.out.println("Something goes wrong!!!");
        }

        // throws exception
        // reverseDiagonals(invalidExampleOne);
        // throws exception
        // reverseDiagonals(invalidExampleTwo);
        // throws exception
        // reverseDiagonals(invalidExampleThree);
    }
}

