import java.util.*;
public class LC18_4Sum_Procurement {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),target=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        Arrays.sort(a);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0;i<n-3;i++){
            if(i>0&&a[i]==a[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1&&a[j]==a[j-1]) continue;
                int l=j+1,r=n-1;
                while(l<r){
                    long sum=(long)a[i]+a[j]+a[l]+a[r];
                    if(sum==target){
                        res.add(Arrays.asList(a[i],a[j],a[l],a[r]));
                        while(l<r&&a[l]==a[l+1]) l++;
                        while(l<r&&a[r]==a[r-1]) r--;
                        l++;r--;
                    }else if(sum<target) l++;
                    else r--;
                }
            }
        }
        for(List<Integer> t:res) System.out.println(t.get(0)+" "+t.get(1)+" "+t.get(2)+" "+t.get(3));
    }
}
