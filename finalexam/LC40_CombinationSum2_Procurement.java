import java.util.*;
public class LC40_CombinationSum2_Procurement {
    static List<List<Integer>> res=new ArrayList<>();
    static void dfs(int[] a,int t,int idx,List<Integer> cur){
        if(t==0){res.add(new ArrayList<>(cur));return;}
        for(int i=idx;i<a.length;i++){
            if(i>idx&&a[i]==a[i-1]) continue;
            if(a[i]>t) break;
            cur.add(a[i]);
            dfs(a,t-a[i],i+1,cur);
            cur.remove(cur.size()-1);
        }
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
