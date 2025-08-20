import java.util.*;

public class M08_BSTRangedSum {
    static class Node{int v;Node l,r;Node(int x){v=x;}}
    static Node build(Integer[] arr,int i){
        if(i>=arr.length||arr[i]==null) return null;
        Node n=new Node(arr[i]);
        n.l=build(arr,2*i+1);
        n.r=build(arr,2*i+2);
        return n;
    }
    static int dfs(Node n,int L,int R){
        if(n==null) return 0;
        if(n.v<L) return dfs(n.r,L,R);
        if(n.v>R) return dfs(n.l,L,R);
        return n.v+dfs(n.l,L,R)+dfs(n.r,L,R);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++){int v=sc.nextInt();arr[i]=v==-1?null:v;}
        int L=sc.nextInt(), R=sc.nextInt();
        Node root=build(arr,0);
        System.out.println("Sum: "+dfs(root,L,R));
    }
}
