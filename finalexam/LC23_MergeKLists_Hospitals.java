import java.util.*;
public class LC23_MergeKLists_Hospitals {
    static class ListNode{
        int val;ListNode next;
        ListNode(int v){val=v;}
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();sc.nextLine();
        List<ListNode> lists=new ArrayList<>();
        for(int i=0;i<k;i++){
            String[] arr=sc.nextLine().trim().split(" ");
            ListNode dummy=new ListNode(0),c=dummy;
            for(String s:arr){
                int v=Integer.parseInt(s);
                if(v==-1) break;
                c.next=new ListNode(v);c=c.next;
            }
            lists.add(dummy.next);
        }
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node:lists) if(node!=null) pq.add(node);
        ListNode dummy=new ListNode(0),tail=dummy;
        while(!pq.isEmpty()){
            ListNode min=pq.poll();
            tail.next=min;tail=tail.next;
            if(min.next!=null) pq.add(min.next);
        }
        ListNode p=dummy.next;
        while(p!=null){System.out.print(p.val+(p.next==null?"":" "));p=p.next;}
    }
}
