import java.util.*;

public class M11_HuffmanCoding {
    static class Node implements Comparable<Node>{
        char ch;int f;Node l,r;
        Node(char c,int f){this.ch=c;this.f=f;}
        Node(int f,Node l,Node r){this.ch=0;this.f=f;this.l=l;this.r=r;}
        public int compareTo(Node o){return this.f-o.f;}
    }
    static void dfs(Node n,String s,Map<Character,String> map){
        if(n.l==null&&n.r==null){map.put(n.ch,s);return;}
        dfs(n.l,s+"0",map);dfs(n.r,s+"1",map);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        PriorityQueue<Node> pq=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            char c=sc.next().charAt(0);
            int f=sc.nextInt();
            pq.add(new Node(c,f));
        }
        while(pq.size()>1){
            Node a=pq.poll(),b=pq.poll();
            pq.add(new Node(a.f+b.f,a,b));
        }
        Node root=pq.poll();
        Map<Character,String> map=new HashMap<>();
        dfs(root,"",map);
        for(char c:map.keySet()) System.out.println(c+" "+map.get(c));
    }
}
