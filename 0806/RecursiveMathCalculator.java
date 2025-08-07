public class RecursiveMathCalculator {
    public static int combination(int n, int k) {
        if (k == 0 || k == n) return 1;
        return combination(n - 1, k - 1) + combination(n - 1, k);
    }

    public static int catalan(int n) {
        if (n <= 1) return 1;
        int res = 0;
        for (int i = 0; i < n; i++)
            res += catalan(i) * catalan(n - 1 - i);
        return res;
    }

    public static int hanoi(int n) {
        if (n == 1) return 1;
        return 2 * hanoi(n - 1) + 1;
    }

    public static boolean isPalindrome(int num) {
        return isPalindromeHelper(String.valueOf(num));
    }

    private static boolean isPalindromeHelper(String s) {
        if (s.length() <= 1) return true;
        if (s.charAt(0) != s.charAt(s.length() - 1)) return false;
        return isPalindromeHelper(s.substring(1, s.length() - 1));
    }
}