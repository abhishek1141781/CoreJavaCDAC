//how to perform left circrcular rotation of an array 

public class LeftCircularRotation {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int rotations = 2;

        System.out.println("Original Array: ");
        printArray(array);

        leftCircularRotate(array, rotations);

        System.out.println("Array after left circular rotation: ");
        printArray(array);
    }

    public static void leftCircularRotate(int[] arr, int rotations) {
        int length = arr.length;

        int[] temp = new int[rotations];
        for (int i = 0; i < rotations; i++) {
            temp[i] = arr[i];
        }

        for (int i = rotations; i < length; i++) {
            arr[i - rotations] = arr[i];
        }

        int j = 0;
        for (int i = length - rotations; i < length; i++) {
            arr[i] = temp[j];
            j++;
        }
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
