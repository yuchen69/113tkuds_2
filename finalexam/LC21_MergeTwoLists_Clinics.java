import java.util.*;
public class LC21_MergeTwoLists_Clinics {
    static class ListNode {
        int val; ListNode next;
        ListNode(int v){val=v;}
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        ListNode l1=null,l2=null,c=null;
        for(int i=0;i<n;i++){if(l1==null){l1=new ListNode(sc.nextInt());c=l1;}else{c.next=new ListNode(sc.nextInt());c=c.next;}}
        c=null;
        for(int i=0;i<m;i++){if(l2==null){l2=new ListNode(sc.nextInt());c=l2;}else{c.next=new ListNode(sc.nextInt());c=c.next;}}
        ListNode dummy=new ListNode(0),tail=dummy;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){tail.next=l1;l1=l1.next;}
            else{tail.next=l2;l2=l2.next;}
            tail=tail.next;
        }
        tail.next=(l1!=null?l1:l2);
        ListNode p=dummy.next;
        while(p!=null){System.out.print(p.val+(p.next==null?"":" "));p=p.next;}
    }
}
