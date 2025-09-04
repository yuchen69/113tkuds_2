import java.util.*;
public class LC04_Median_QuakeFeeds {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(), m=sc.nextInt();
        double[] A=new double[n], B=new double[m];
        for(int i=0;i<n;i++) A[i]=sc.nextDouble();
        for(int j=0;j<m;j++) B[j]=sc.nextDouble();
        if(n>m){double[] tmp=A;A=B;B=tmp;int t=n;n=m;m=t;}
        int imin=0,imax=n,half=(n+m+1)/2;
        while(imin<=imax){
            int i=(imin+imax)/2,j=half-i;
            if(i<n&&B[j-1]>A[i]) imin=i+1;
            else if(i>0&&A[i-1]>B[j]) imax=i-1;
            else{
                double maxLeft=0;
                if(i==0) maxLeft=B[j-1];
                else if(j==0) maxLeft=A[i-1];
                else maxLeft=Math.max(A[i-1],B[j-1]);
                if((n+m)%2==1){System.out.printf("%.1f\n",maxLeft);return;}
                double minRight=0;
                if(i==n) minRight=B[j];
                else if(j==m) minRight=A[i];
                else minRight=Math.min(A[i],B[j]);
                System.out.printf("%.1f\n",(maxLeft+minRight)/2.0);
                return;
            }
        }
    }
}

