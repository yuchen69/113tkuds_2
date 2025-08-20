import java.util.*;

public class M10_RBPropertiesCheck {
    static class Node{
        int v;char c;Node l,r;
        Node(int v,char c){this.v=v;this.c=c;}
    }
    static Node build(int[] vals,char[] cols,int i){
        if(i>=vals.length||vals[i]==-1) return null;
        Node n=new Node(vals[i],cols[i]);
        n.l=build(vals,cols,2*i+1);
        n.r=build(vals,cols,2*i+2);
        return n;
    }
    static boolean[] flag=new boolean[1];
    static int dfs(Node n){
        if(n==null) return 1;
        int lh=dfs(n.l), rh=dfs(n.r);
        if(lh==-1||rh==-1||lh!=rh){flag[0]=true;return -1;}
        if(n.c=='R'){
            if((n.l!=null&&n.l.c=='R')||(n.r!=null&&n.r.c=='R')){
                throw new RuntimeException("RedRedViolation");
            }
        }
        return lh+(n.c=='B'?1:0);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] vals=new int[n]; char[] cols=new char[n];
        for(int i=0;i<n;i++){
            vals[i]=sc.nextInt();
            cols[i]=sc.next().charAt(0);
            if(vals[i]==-1) cols[i]='B';
        }
        Node root=build(vals,cols,0);
        if(root!=null&&root.c!='B'){System.out.println("RootNotBlack");return;}
        try{
            int h=dfs(root);
            if(flag[0]) System.out.println("BlackHeightMismatch");
            else System.out.println("RB Valid");
        }catch(RuntimeException e){
            System.out.println(e.getMessage()+" at index 0");
        }
    }
}
