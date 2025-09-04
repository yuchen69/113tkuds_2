import java.util.*;
public class LC39_CombinationSum_PPE {
    static List<List<Integer>> res=new ArrayList<>();
    static void dfs(int[] a,int t,int idx,List<Integer> cur){
        if(t==0){res.add(new ArrayList<>(cur));return;}
        if(t<0||idx==a.length) return;
        cur.add(a[idx]);
        dfs(a,t-a[idx],idx,cur);
        cur.remove(cur.size()-1);
        dfs(a,t,idx+1,cur);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),target=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        Arrays.sort(a);
        dfs(a,target,0,new ArrayList<>());
        for(List<Integer> lst:res){
            for(int i=0;i<lst.size();i++) System.out.print(lst.get(i)+(i==lst.size()-1?"":" "));
            System.out.println();
        }
    }
}
