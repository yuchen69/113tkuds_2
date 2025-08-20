import java.util.*;

public class M01_BuildHeap {
    static void heapify(int[] arr, int n, int i, boolean isMax) {
        int best = i;
        int l = 2 * i + 1, r = 2 * i + 2;
        if (l < n && (isMax ? arr[l] > arr[best] : arr[l] < arr[best])) best = l;
        if (r < n && (isMax ? arr[r] > arr[best] : arr[r] < arr[best])) best = r;
        if (best != i) {
            int tmp = arr[i]; arr[i] = arr[best]; arr[best] = tmp;
            heapify(arr, n, best, isMax);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String type = sc.next();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        boolean isMax = type.equals("max");
        for (int i = n/2 - 1; i >= 0; i--) heapify(arr, n, i, isMax);
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n-1) System.out.print(" ");
        }
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每個節點做 heapifyDown，成本與高度相關；總合 ≤ 2n。
 */
