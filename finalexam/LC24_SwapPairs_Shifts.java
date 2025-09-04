import java.util.*;
public class LC24_SwapPairs_Shifts {
    static class ListNode{
        int val;ListNode next;
        ListNode(int v){val=v;}
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String line=sc.hasNextLine()?sc.nextLine().trim():"";
        if(line.isEmpty()){return;}
        String[] arr=line.split(" ");
        ListNode dummy=new ListNode(0),c=dummy;
        for(String s:arr){c.next=new ListNode(Integer.parseInt(s));c=c.next;}
        ListNode prev=dummy;
        while(prev.next!=null&&prev.next.next!=null){
            ListNode a=prev.next,b=a.next;
            a.next=b.next;b.next=a;prev.next=b;prev=a;
        }
        ListNode p=dummy.next;
        while(p!=null){System.out.print(p.val+(p.next==null?"":" "));p=p.next;}
    }
}
