import java.util.*;

public class M03_TopKConvenience {
    static class Item implements Comparable<Item> {
        String name; int qty;
        Item(String n, int q) { name=n; qty=q; }
        public int compareTo(Item o) {
            if (qty!=o.qty) return qty-o.qty;
            return name.compareTo(o.name);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        PriorityQueue<Item> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next(); int q = sc.nextInt();
            pq.offer(new Item(name,q));
            if (pq.size()>k) pq.poll();
        }
        List<Item> list = new ArrayList<>(pq);
        list.sort((a,b)-> b.qty!=a.qty? b.qty-a.qty : a.name.compareTo(b.name));
        for (Item it : list) System.out.println(it.name+" "+it.qty);
    }
}

/*
 * Time Complexity: O(n log k)
 * 說明：每次插入/彈出維護大小 k 堆，成本 O(log k)，總共 n 筆 → O(n log k)。
 */
