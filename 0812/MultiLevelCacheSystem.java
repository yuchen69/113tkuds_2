import java.util.*;

class Entry {
    int key;
    String value;
    int freq;
    Entry(int key, String value, int freq) {
        this.key = key;
        this.value = value;
        this.freq = freq;
    }
}

public class MultiLevelCacheSystem {
    private final Map<Integer, Entry> L1 = new HashMap<>();
    private final Map<Integer, Entry> L2 = new HashMap<>();
    private final Map<Integer, Entry> L3 = new HashMap<>();

    private final PriorityQueue<Entry> pqL1 = new PriorityQueue<>(
        (a, b) -> {
            int cost = 1;
            int sa = a.freq == 0 ? Integer.MAX_VALUE / cost : cost / a.freq;
            int sb = b.freq == 0 ? Integer.MAX_VALUE / cost : cost / b.freq;
            return sa - sb;
        }
    );

    private final PriorityQueue<Entry> pqL2 = new PriorityQueue<>(
        (a, b) -> {
            int cost = 3;
            int sa = a.freq == 0 ? Integer.MAX_VALUE / cost : cost / a.freq;
            int sb = b.freq == 0 ? Integer.MAX_VALUE / cost : cost / b.freq;
            return sa - sb;
        }
    );

    private final PriorityQueue<Entry> pqL3 = new PriorityQueue<>(
        (a, b) -> {
            int cost = 10;
            int sa = a.freq == 0 ? Integer.MAX_VALUE / cost : cost / a.freq;
            int sb = b.freq == 0 ? Integer.MAX_VALUE / cost : cost / b.freq;
            return sa - sb;
        }
    );

    public void put(int level, int key, String value) {
        Entry e = new Entry(key, value, 1);
        if (level == 1) {
            L1.put(key, e);
            pqL1.add(e);
        } else if (level == 2) {
            L2.put(key, e);
            pqL2.add(e);
        } else {
            L3.put(key, e);
            pqL3.add(e);
        }
    }

    public String get(int key) {
        if (L1.containsKey(key)) {
            L1.get(key).freq++;
            return L1.get(key).value;
        }
        if (L2.containsKey(key)) {
            L2.get(key).freq++;
            return L2.get(key).value;
        }
        if (L3.containsKey(key)) {
            L3.get(key).freq++;
            return L3.get(key).value;
        }
        return null;
    }

    public static void main(String[] args) {
        MultiLevelCacheSystem cache = new MultiLevelCacheSystem();
        cache.put(1, 1, "A");
        cache.put(2, 2, "B");
        cache.put(3, 3, "C");

        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}
