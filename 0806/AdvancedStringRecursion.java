
public class AdvancedStringRecursion {
    public static void permutations(String str) {
        permute(str, "");
    }

    private static void permute(String str, String prefix) {
        if (str.isEmpty()) {
            System.out.println(prefix);
        } else {
            for (int i = 0; i < str.length(); i++) {
                permute(str.substring(0, i) + str.substring(i + 1), prefix + str.charAt(i));
            }
        }
    }

    public static boolean match(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();
        boolean firstMatch = !text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.');
        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return match(text, pattern.substring(2)) || (firstMatch && match(text.substring(1), pattern));
        } else {
            return firstMatch && match(text.substring(1), pattern.substring(1));
        }
    }

    public static String removeDuplicates(String str) {
        if (str.length() <= 1) return str;
        if (str.charAt(0) == str.charAt(1)) return removeDuplicates(str.substring(1));
        return str.charAt(0) + removeDuplicates(str.substring(1));
    }

    public static void substrings(String str) {
        substringHelper(str, "");
    }

    private static void substringHelper(String str, String prefix) {
        if (!prefix.isEmpty()) System.out.println(prefix);
        for (int i = 0; i < str.length(); i++) {
            substringHelper(str.substring(i + 1), prefix + str.charAt(i));
        }
    }
}