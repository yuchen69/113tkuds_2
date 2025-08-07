import java.util.*;

public class NumberArrayProcessor {
    public static int[] removeDuplicates(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr) set.add(num);
        return set.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] mergeSortedArrays(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) result[k++] = a[i++];
            else result[k++] = b[j++];
        }
        while (i < a.length) result[k++] = a[i++];
        while (j < b.length) result[k++] = b[j++];
        return result;
    }

    public static int mostFrequent(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : arr) count.put(num, count.getOrDefault(num, 0) + 1);
        int maxFreq = 0, result = arr[0];
        for (int key : count.keySet()) {
            if (count.get(key) > maxFreq) {
                maxFreq = count.get(key);
                result = key;
            }
        }
        return result;
    }

    public static int[][] splitBalanced(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int half = sum / 2, running = 0, idx = 0;
        while (idx < arr.length && running + arr[idx] <= half) {
            running += arr[idx];
            idx++;
        }
        return new int[][]{
            Arrays.copyOfRange(arr, 0, idx),
            Arrays.copyOfRange(arr, idx, arr.length)
        };
    }
}
