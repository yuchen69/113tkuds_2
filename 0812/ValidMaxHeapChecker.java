
public class ValidMaxHeapChecker {
    static class Result { boolean ok; int index; Result(boolean ok,int index){this.ok=ok;this.index=index;} }
    public static Result isValidMaxHeap(int[] a){
        int n=a.length;
        for(int i=(n-2)/2;i>=0;i--){
            int l=2*i+1,r=2*i+2;
            if(l<n&&a[i]<a[l]) return new Result(false,l);
            if(r<n&&a[i]<a[r]) return new Result(false,r);
        }
        return new Result(true,-1);
    }
    public static void main(String[] args){
        int[][] tests={{100,90,80,70,60,75,65},{100,90,80,95,60,75,65},{50},{}}; 
        for(int[] t:tests){
            Result r=isValidMaxHeap(t);
            if(r.ok) System.out.println("true"); else System.out.println("false "+r.index);
        }
    }
}
