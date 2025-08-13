import java.util.*;

public class StockMaximizer {
    public static int maxProfitK(int[] prices,int K){
        if(prices.length==0||K==0) return 0;
        if(K>=prices.length/2){
            int g=0; for(int i=1;i<prices.length;i++) if(prices[i]>prices[i-1]) g+=prices[i]-prices[i-1]; return g;
        }
        int n=prices.length;
        int[] buy=new int[K+1];
        int[] sell=new int[K+1];
        Arrays.fill(buy,Integer.MIN_VALUE/2);
        for(int p:prices){
            for(int k=1;k<=K;k++){
                buy[k]=Math.max(buy[k],sell[k-1]-p);
                sell[k]=Math.max(sell[k],buy[k]+p);
            }
        }
        return sell[K];
    }
    public static void main(String[] args){
        System.out.println(maxProfitK(new int[]{2,4,1},2));
        System.out.println(maxProfitK(new int[]{3,2,6,5,0,3},2));
        System.out.println(maxProfitK(new int[]{1,2,3,4,5},2));
    }
}