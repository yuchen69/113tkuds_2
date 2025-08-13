import java.util.*;

public class BasicMinHeapPractice {
    static class MinHeap {
        private final ArrayList<Integer> heap = new ArrayList<>();
        public void insert(int val){ heap.add(val); heapifyUp(heap.size()-1); }
        public int extractMin(){ if(heap.isEmpty()) throw new NoSuchElementException(); int min=heap.get(0); int last=heap.remove(heap.size()-1); if(!heap.isEmpty()){ heap.set(0,last); heapifyDown(0);} return min; }
        public int getMin(){ if(heap.isEmpty()) throw new NoSuchElementException(); return heap.get(0); }
        public int size(){ return heap.size(); }
        public boolean isEmpty(){ return heap.isEmpty(); }
        private void heapifyUp(int i){ while(i>0){ int p=(i-1)/2; if(heap.get(p)<=heap.get(i)) break; swap(p,i); i=p; } }
        private void heapifyDown(int i){ int n=heap.size(); while(true){ int l=2*i+1,r=2*i+2,sm=i; if(l<n&&heap.get(l)<heap.get(sm)) sm=l; if(r<n&&heap.get(r)<heap.get(sm)) sm=r; if(sm==i) break; swap(sm,i); i=sm; } }
        private void swap(int i,int j){ int t=heap.get(i); heap.set(i,heap.get(j)); heap.set(j,t); }
    }
    public static void main(String[] args){
        MinHeap h=new MinHeap();
        int[] in={15,10,20,8,25,5};
        for(int v:in) h.insert(v);
        ArrayList<Integer> out=new ArrayList<>();
        while(!h.isEmpty()) out.add(h.extractMin());
        System.out.println(out.toString().replace(" ",""));
    }
}