import java.util.*;
public class LC25_ReverseKGroup_Shifts {
    static class ListNode{
        int val;ListNode next;
        ListNode(int v){val=v;}
    }
    static ListNode reverse(ListNode head,ListNode tail){
        ListNode prev=tail.next,p=head;
        while(prev!=tail){
            ListNode nxt=p.next;
            p.next=prev;
            prev=p;
            p=nxt;
        }
        return tail;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();sc.nextLine();
        String line=sc.hasNextLine()?sc.nextLine().trim():"";
        if(line.isEmpty()){return;}
        String[] arr=line.split(" ");
        ListNode dummy=new ListNode(0),c=dummy;
        for(String s:arr){c.next=new ListNode(Integer.parseInt(s));c=c.next;}
        ListNode pre=dummy;
        while(true){
            ListNode tail=pre;
            for(int i=0;i<k&&tail!=null;i++) tail=tail.next;
            if(tail==null) break;
            ListNode head=pre.next,nxt=tail.next;
            ListNode newHead=reverse(head,tail);
            pre.next=newHead;
            head.next=nxt;
            pre=head;
        }
        ListNode p=dummy.next;
        while(p!=null){System.out.print(p.val+(p.next==null?"":" "));p=p.next;}
    }
}
