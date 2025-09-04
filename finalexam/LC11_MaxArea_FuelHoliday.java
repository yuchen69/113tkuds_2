import java.util.*;
public class LC11_MaxArea_FuelHoliday {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] h=new int[n];
        for(int i=0;i<n;i++) h[i]=sc.nextInt();
        int l=0,r=n-1,res=0;
        while(l<r){
            res=Math.max(res,(r-l)*Math.min(h[l],h[r]));
            if(h[l]<h[r]) l++; else r--;
        }
        System.out.println(res);
    }
}
