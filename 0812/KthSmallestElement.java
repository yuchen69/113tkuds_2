import java.util.*;

public class KthSmallestElement {
    public static int kthByMaxHeap(int[] arr,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int v:arr){ pq.offer(v); if(pq.size()>k) pq.poll(); }
        return pq.peek();
    }
    public static int kthByMinHeap(int[] arr,int k){
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int v:arr) pq.offer(v);
        int x=0; for(int i=0;i<k;i++) x=pq.poll(); return x;
    }
    public static void main(String[] args){
        System.out.println(kthByMaxHeap(new int[]{7,10,4,3,20,15},3));
        System.out.println(kthByMinHeap(new int[]{7,10,4,3,20,15},3));
        System.out.println(kthByMaxHeap(new int[]{1},1));
        System.out.println(kthByMaxHeap(new int[]{3,1,4,1,5,9,2,6},4));
    }
}