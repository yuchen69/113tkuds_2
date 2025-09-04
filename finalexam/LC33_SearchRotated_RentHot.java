import java.util.*;
public class LC33_SearchRotated_RentHot {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),target=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        int l=0,r=n-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(arr[mid]==target){System.out.println(mid);return;}
            if(arr[l]<=arr[mid]){
                if(arr[l]<=target&&target<arr[mid]) r=mid-1;
                else l=mid+1;
            }else{
                if(arr[mid]<target&&target<=arr[r]) l=mid+1;
                else r=mid-1;
            }
        }
        System.out.println(-1);
    }
}
