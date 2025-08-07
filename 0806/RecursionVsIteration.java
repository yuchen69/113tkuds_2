public class RecursionVsIteration {
    public static int combinationRecursive(int n, int k) {
        if (k == 0 || k == n) return 1;
        return combinationRecursive(n - 1, k - 1) + combinationRecursive(n - 1, k);
    }

    public static int combinationIterative(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {
                if (j == 0 || j == i) dp[i][j] = 1;
                else dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        return dp[n][k];
    }

    public static int productRecursive(int[] arr, int i) {
        if (i == arr.length) return 1;
        return arr[i] * productRecursive(arr, i + 1);
    }

    public static int productIterative(int[] arr) {
        int result = 1;
        for (int num : arr) result *= num;
        return result;
    }

    public static int countVowelsRecursive(String s) {
        if (s.isEmpty()) return 0;
        char c = Character.toLowerCase(s.charAt(0));
        int count = "aeiou".indexOf(c) >= 0 ? 1 : 0;
        return count + countVowelsRecursive(s.substring(1));
    }

    public static int countVowelsIterative(String s) {
        int count = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) count++;
        }
        return count;
    }

    public static boolean isBalancedRecursive(String s) {
        return checkBalance(s, 0, 0);
    }

    private static boolean checkBalance(String s, int index, int open) {
        if (index == s.length()) return open == 0;
        if (open < 0) return false;
        char c = s.charAt(index);
        if (c == '(') return checkBalance(s, index + 1, open + 1);
        else if (c == ')') return checkBalance(s, index + 1, open - 1);
        else return checkBalance(s, index + 1, open);
    }

    public static boolean isBalancedIterative(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}