import java.util.*;
public class LC15_3Sum_THSRStops {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        Arrays.sort(a);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<n-2;i++){
            if(i>0&&a[i]==a[i-1]) continue;
            int l=i+1,r=n-1;
            while(l<r){
                int sum=a[i]+a[l]+a[r];
                if(sum==0){
                    res.add(Arrays.asList(a[i],a[l],a[r]));
                    while(l<r&&a[l]==a[l+1]) l++;
                    while(l<r&&a[r]==a[r-1]) r--;
                    l++;r--;
                }else if(sum<0) l++;
                else r--;
            }
        }
        for(List<Integer> t:res) System.out.println(t.get(0)+" "+t.get(1)+" "+t.get(2));
    }
}
