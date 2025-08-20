import java.util.*;

public class M07_BinaryTreeLeftView {
    static class Node{int v;Node l,r;Node(int x){v=x;}}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n==0){System.out.println("LeftView:");return;}
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++){int v=sc.nextInt();arr[i]=v==-1?null:v;}
        Node root=build(arr,0);
        List<Integer> ans=new ArrayList<>();
        Queue<Node> q=new LinkedList<>();
        if(root!=null) q.add(root);
        while(!q.isEmpty()){
            int sz=q.size();
            for(int i=0;i<sz;i++){
                Node cur=q.poll();
                if(i==0) ans.add(cur.v);
                if(cur.l!=null) q.add(cur.l);
                if(cur.r!=null) q.add(cur.r);
            }
        }
        System.out.print("LeftView:");
        for(int x:ans) System.out.print(" "+x);
    }
    static Node build(Integer[] arr,int i){
        if(i>=arr.length||arr[i]==null) return null;
        Node n=new Node(arr[i]);
        n.l=build(arr,2*i+1);
        n.r=build(arr,2*i+2);
        return n;
    }
}
