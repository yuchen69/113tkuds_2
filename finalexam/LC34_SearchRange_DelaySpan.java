import java.util.*;
public class LC34_SearchRange_DelaySpan {
    static int lower(int[] a,int t){
        int l=0,r=a.length;
        while(l<r){
            int m=(l+r)/2;
            if(a[m]<t) l=m+1; else r=m;
        }
        return l;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),target=sc.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        int l=lower(a,target),r=lower(a,target+1)-1;
        if(l<n&&a[l]==target) System.out.println(l+" "+r);
        else System.out.println("-1 -1");
    }
}
