import java.util.*;

public class M09_AVLValidate {
    static class Node{int v;Node l,r;Node(int x){v=x;}}
    static Node build(Integer[] arr,int i){
        if(i>=arr.length||arr[i]==null) return null;
        Node n=new Node(arr[i]);
        n.l=build(arr,2*i+1);
        n.r=build(arr,2*i+2);
        return n;
    }
    static boolean isBST(Node n,long min,long max){
        if(n==null) return true;
        if(n.v<=min||n.v>=max) return false;
        return isBST(n.l,min,n.v)&&isBST(n.r,n.v,max);
    }
    static int checkAVL(Node n){
        if(n==null) return 0;
        int lh=checkAVL(n.l); if(lh==-1) return -1;
        int rh=checkAVL(n.r); if(rh==-1) return -1;
        if(Math.abs(lh-rh)>1) return -1;
        return Math.max(lh,rh)+1;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Integer[] arr=new Integer[n];
        for(int i=0;i<n;i++){int v=sc.nextInt();arr[i]=v==-1?null:v;}
        Node root=build(arr,0);
        if(!isBST(root,Long.MIN_VALUE,Long.MAX_VALUE)) System.out.println("Invalid BST");
        else if(checkAVL(root)==-1) System.out.println("Invalid AVL");
        else System.out.println("Valid");
    }
}

/*
 * Time Complexity: O(n)
 * 說明：BST 驗證與 AVL 高度檢查各為一次 DFS，每個節點訪問一次 → O(n)。
 */
