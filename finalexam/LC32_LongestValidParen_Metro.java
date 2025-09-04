import java.util.*;
public class LC32_LongestValidParen_Metro {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        int res=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') st.push(i);
            else{
                st.pop();
                if(st.isEmpty()) st.push(i);
                else res=Math.max(res,i-st.peek());
            }
        }
        System.out.println(res);
    }
}
