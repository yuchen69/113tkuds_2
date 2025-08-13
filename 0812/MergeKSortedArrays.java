import java.util.*;

public class MergeKSortedArrays {
    static class Node {
        int val, ai, bi;
        Node(int v,int a,int b){val=v;ai=a;bi=b;}
    }
    public static int[] merge(List<int[]> arrays){
        int total=0; for(int[] a:arrays) total+=a.length;
        PriorityQueue<Node> pq=new PriorityQueue<>(Comparator.comparingInt(n->n.val));
        for(int i=0;i<arrays.size();i++) if(arrays.get(i).length>0) pq.add(new Node(arrays.get(i)[0],i,0));
        int[] res=new int[total]; int idx=0;
        while(!pq.isEmpty()){
            Node cur=pq.poll();
            res[idx++]=cur.val;
            int ni=cur.bi+1;
            if(ni<arrays.get(cur.ai).length) pq.add(new Node(arrays.get(cur.ai)[ni],cur.ai,ni));
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(merge(Arrays.asList(new int[]{1,4,5}, new int[]{1,3,4}, new int[]{2,6}))));
        System.out.println(Arrays.toString(merge(Arrays.asList(new int[]{1,2,3}, new int[]{4,5,6}, new int[]{7,8,9}))));
        System.out.println(Arrays.toString(merge(Arrays.asList(new int[]{1}, new int[]{0}))));
    }
}