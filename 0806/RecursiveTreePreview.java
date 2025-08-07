import java.util.*;

public class RecursiveTreePreview {
    static class Folder {
        String name;
        List<Object> contents; // files (String) or subfolders (Folder)

        Folder(String name) {
            this.name = name;
            this.contents = new ArrayList<>();
        }
    }

    public static int countFiles(Folder folder) {
        int count = 0;
        for (Object o : folder.contents) {
            if (o instanceof String) count++;
            else if (o instanceof Folder) count += countFiles((Folder) o);
        }
        return count;
    }

    public static void printMenu(List<String> menu, int level) {
        for (String item : menu) {
            System.out.println("  ".repeat(level) + item);
            if (item.contains("->")) {
                List<String> sub = Arrays.asList(item.split("->"));
                printMenu(sub, level + 1);
            }
        }
    }

    public static List<Object> flatten(List<?> nested) {
        List<Object> flat = new ArrayList<>();
        for (Object o : nested) {
            if (o instanceof List<?>) flat.addAll(flatten((List<?>) o));
            else flat.add(o);
        }
        return flat;
    }

    public static int maxDepth(List<?> nested) {
        int max = 1;
        for (Object o : nested) {
            if (o instanceof List<?>) {
                max = Math.max(max, 1 + maxDepth((List<?>) o));
            }
        }
        return max;
    }
}
