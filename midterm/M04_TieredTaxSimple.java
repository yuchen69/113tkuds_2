import java.util.*;

public class M04_TieredTaxSimple {
    static int tax(int x) {
        int t=0;
        if (x>1000000) { t+=(x-1000000)*30/100; x=1000000; }
        if (x>500000) { t+=(x-500000)*20/100; x=500000; }
        if (x>120000) { t+=(x-120000)*12/100; x=120000; }
        t+=x*5/100;
        return t;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum=0;
        for (int i=0;i<n;i++) {
            int v=sc.nextInt();
            int t=tax(v);
            sum+=t;
            System.out.println("Tax: "+t);
        }
        System.out.println("Average: "+sum/n);
    }
}

/*
 * Time Complexity: O(n)
 * 說明：每個收入計算稅額為 O(1)，總共 n 筆輸入 → O(n)。
 */
