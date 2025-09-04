import java.util.*;
public class LC19_RemoveNth_Node_Clinic {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v){val=v;}
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ListNode dummy=new ListNode(0),cur=dummy;
        for(int i=0;i<n;i++){cur.next=new ListNode(sc.nextInt());cur=cur.next;}
        int k=sc.nextInt();
        ListNode fast=dummy,slow=dummy;
        for(int i=0;i<k;i++) fast=fast.next;
        while(fast.next!=null){fast=fast.next;slow=slow.next;}
        slow.next=slow.next.next;
        cur=dummy.next;
        while(cur!=null){System.out.print(cur.val+(cur.next==null?"":" "));cur=cur.next;}
    }
}
