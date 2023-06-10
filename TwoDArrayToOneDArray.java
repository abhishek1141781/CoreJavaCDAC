//how to convert a two dimenstion array to one diamnestion arrray 

public class TwoDArrayToOneDArray {
    public static void main(String[] args) {
        int[][] twoDArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println("Original 2D Array:");
        printTwoDArray(twoDArray);

        int[] oneDArray = convertToOneDArray(twoDArray);

        System.out.println("One-Dimensional Array:");
        printOneDArray(oneDArray);
    }

    public static int[] convertToOneDArray(int[][] twoDArray) {
        int rows = twoDArray.length;
        int cols = twoDArray[0].length;

        int[] oneDArray = new int[rows * cols];
        int index = 0;

        for (int[] row : twoDArray) {
            for (int element : row) {
                oneDArray[index] = element;
                index++;
            }
        }

        return oneDArray;
    }

    public static void printTwoDArray(int[][] twoDArray) {
        for (int[] row : twoDArray) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void printOneDArray(int[] oneDArray) {
        for (int element : oneDArray) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
