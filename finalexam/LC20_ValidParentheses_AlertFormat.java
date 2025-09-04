import java.util.*;
public class LC20_ValidParentheses_AlertFormat {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Stack<Character> st=new Stack<>();
        Map<Character,Character> map=new HashMap<>();
        map.put(')', '('); map.put(']', '['); map.put('}', '{');
        for(char c:s.toCharArray()){
            if(map.containsValue(c)) st.push(c);
            else{
                if(st.isEmpty()||st.pop()!=map.get(c)){System.out.println("false");return;}
            }
        }
        System.out.println(st.isEmpty()?"true":"false");
    }
}
