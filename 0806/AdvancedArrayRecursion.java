import java.util.*;

public class AdvancedArrayRecursion {
    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int pivot = arr[right], i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
            }
        }
        int temp = arr[i + 1]; arr[i + 1] = arr[right]; arr[right] = temp;
        quickSort(arr, left, i);
        quickSort(arr, i + 2, right);
    }

    public static int[] merge(int[] a, int[] b) {
        if (a.length == 0) return b;
        if (b.length == 0) return a;
        if (a[0] < b[0]) return concat(new int[]{a[0]}, merge(Arrays.copyOfRange(a, 1, a.length), b));
        else return concat(new int[]{b[0]}, merge(a, Arrays.copyOfRange(b, 1, b.length)));
    }

    private static int[] concat(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        System.arraycopy(first, 0, result, 0, first.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    public static int kthSmallest(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    private static int quickSelect(int[] arr, int left, int right, int k) {
        if (left == right) return arr[left];
        int pivot = arr[right], i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i]; arr[i] = arr[right]; arr[right] = temp;
        if (k == i) return arr[i];
        else if (k < i) return quickSelect(arr, left, i - 1, k);
        else return quickSelect(arr, i + 1, right, k);
    }

    public static boolean hasSubsetSum(int[] arr, int target) {
        return hasSubsetSumHelper(arr, target, 0);
    }

    private static boolean hasSubsetSumHelper(int[] arr, int target, int index) {
        if (target == 0) return true;
        if (index == arr.length) return false;
        return hasSubsetSumHelper(arr, target - arr[index], index + 1) ||
               hasSubsetSumHelper(arr, target, index + 1);
    }
}