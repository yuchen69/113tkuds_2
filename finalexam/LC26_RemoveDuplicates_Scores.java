import java.util.*;
public class LC26_RemoveDuplicates_Scores {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n==0){System.out.println(0);return;}
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        int w=1;
        for(int i=1;i<n;i++) if(arr[i]!=arr[w-1]) arr[w++]=arr[i];
        System.out.println(w);
        for(int i=0;i<w;i++) System.out.print(arr[i]+(i==w-1?"":" "));
    }
}
