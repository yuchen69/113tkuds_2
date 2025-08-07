import java.util.*;

public class SelectionSortImplementation {
    public static void selectionSort(int[] arr) {
        int n = arr.length, comp = 0, swap = 0;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                comp++;
                if (arr[j] < arr[min]) min = j;
            }
            if (i != min) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
                swap++;
            }
            System.out.println("Round " + (i + 1) + ": " + Arrays.toString(arr));
        }
        System.out.println("Comparisons: " + comp + ", Swaps: " + swap);
    }
} 