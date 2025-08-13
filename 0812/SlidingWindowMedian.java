import java.util.*;

public class SlidingWindowMedian {
    static class DualHeap {
        PriorityQueue<Integer> small=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> large=new PriorityQueue<>();
        Map<Integer,Integer> delayed=new HashMap<>();
        int k, smallSize=0, largeSize=0;
        DualHeap(int k){this.k=k;}
        void prune(PriorityQueue<Integer> heap){
            while(!heap.isEmpty()){
                int x=heap.peek();
                if(delayed.getOrDefault(x,0)>0){
                    delayed.put(x,delayed.get(x)-1);
                    if(delayed.get(x)==0) delayed.remove(x);
                    heap.poll();
                }else break;
            }
        }
        void makeBalance(){
            if(smallSize>largeSize+1){ large.offer(small.poll()); smallSize--; largeSize++; prune(small); }
            else if(smallSize<largeSize){ small.offer(large.poll()); smallSize++; largeSize--; prune(large); }
        }
        void addNum(int num){
            if(small.isEmpty()||num<=small.peek()){ small.offer(num); smallSize++; }
            else { large.offer(num); largeSize++; }
            makeBalance();
        }
        void removeNum(int num){
            delayed.put(num,delayed.getOrDefault(num,0)+1);
            if(!small.isEmpty() && num<=small.peek()){ smallSize--; if(num==small.peek()) prune(small); }
            else { largeSize--; if(!large.isEmpty() && num==large.peek()) prune(large); }
            makeBalance();
        }
        double getMedian(){
            if(k%2==1) return small.peek();
            return ((long)small.peek()+(long)large.peek())/2.0;
        }
    }
    public static double[] medianSlidingWindow(int[] nums,int k){
        DualHeap dh=new DualHeap(k);
        double[] ans=new double[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            dh.addNum(nums[i]);
            if(i>=k-1){
                ans[i-k+1]=dh.getMedian();
                dh.removeNum(nums[i-k+1]);
            }
        }
        return ans;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
        System.out.println(Arrays.toString(medianSlidingWindow(new int[]{1,2,3,4},2)));
    }
}