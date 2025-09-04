import java.util.*;
public class LC17_PhoneCombos_CSShift {
    static String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static List<String> res=new ArrayList<>();
    static void dfs(String d,int idx,StringBuilder sb){
        if(idx==d.length()){res.add(sb.toString());return;}
        String letters=map[d.charAt(idx)-'0'];
        for(char c:letters.toCharArray()){
            sb.append(c);
            dfs(d,idx+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String d=sc.nextLine();
        if(d.isEmpty()){return;}
        dfs(d,0,new StringBuilder());
        for(String s:res) System.out.println(s);
    }
}

