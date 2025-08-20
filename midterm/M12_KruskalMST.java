import java.util.*;

public class M12_KruskalMST {
    static class Edge implements Comparable<Edge>{
        int u,v,w;Edge(int u,int v,int w){this.u=u;this.v=v;this.w=w;}
        public int compareTo(Edge o){return this.w-o.w;}
    }
    static int find(int[] p,int x){return p[x]==x?x:(p[x]=find(p,p[x]));}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        List<Edge> es=new ArrayList<>();
        for(int i=0;i<m;i++) es.add(new Edge(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        Collections.sort(es);
        int[] p=new int[n+1];for(int i=1;i<=n;i++) p[i]=i;
        int cnt=0,sum=0;
        for(Edge e:es){
            int a=find(p,e.u),b=find(p,e.v);
            if(a!=b){p[a]=b;sum+=e.w;cnt++;if(cnt==n-1) break;}
        }
        System.out.println("MST Weight: "+sum);
    }
}
