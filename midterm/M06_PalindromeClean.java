import java.util.*;

public class M06_PalindromeClean {
    static boolean isPal(String s,int l,int r){
        if (l>=r) return true;
        if (s.charAt(l)!=s.charAt(r)) return false;
        return isPal(s,l+1,r-1);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine().toLowerCase();
        StringBuilder sb=new StringBuilder();
        for(char c:line.toCharArray())
            if(Character.isLetter(c)) sb.append(c);
        String s=sb.toString();
        System.out.println(isPal(s,0,s.length()-1)?"Yes":"No");
    }
}
