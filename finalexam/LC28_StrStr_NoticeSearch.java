import java.util.*;
public class LC28_StrStr_NoticeSearch {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String hay=sc.nextLine(),nee=sc.nextLine();
        if(nee.length()==0){System.out.println(0);return;}
        for(int i=0;i+nee.length()<=hay.length();i++){
            if(hay.substring(i,i+nee.length()).equals(nee)){System.out.println(i);return;}
        }
        System.out.println(-1);
    }
}
