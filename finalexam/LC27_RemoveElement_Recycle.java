import java.util.*;
public class LC27_RemoveElement_Recycle {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),val=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        int w=0;
        for(int i=0;i<n;i++) if(arr[i]!=val) arr[w++]=arr[i];
        System.out.println(w);
        for(int i=0;i<w;i++) System.out.print(arr[i]+(i==w-1?"":" "));
    }
}
