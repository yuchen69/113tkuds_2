import java.util.*;

public class MovingAverageStream {
    static class MovingAverage {
        int size;
        Deque<Integer> q=new ArrayDeque<>();
        long sum=0;
        PriorityQueue<Integer> lo=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> hi=new PriorityQueue<>();
        Map<Integer,Integer> delayed=new HashMap<>();
        int loSize=0, hiSize=0;
        public MovingAverage(int size){ this.size=size; }
        private void prune(PriorityQueue<Integer> h){
            while(!h.isEmpty()){
                int x=h.peek();
                if(delayed.getOrDefault(x,0)>0){
                    delayed.put(x,delayed.get(x)-1);
                    if(delayed.get(x)==0) delayed.remove(x);
                    h.poll();
                }else break;
            }
        }
        private void balance(){
            if(loSize>hiSize+1){ hi.offer(lo.poll()); loSize--; hiSize++; prune(lo); }
            else if(loSize<hiSize){ lo.offer(hi.poll()); loSize++; hiSize--; prune(hi); }
        }
        private void addNum(int x){
            if(lo.isEmpty()||x<=lo.peek()){ lo.offer(x); loSize++; }
            else { hi.offer(x); hiSize++; }
            balance();
        }
        private void removeNum(int x){
            delayed.put(x,delayed.getOrDefault(x,0)+1);
            if(!lo.isEmpty() && x<=lo.peek()){ loSize--; if(x==lo.peek()) prune(lo); }
            else { hiSize--; if(!hi.isEmpty() && x==hi.peek()) prune(hi); }
            balance();
        }
        public double next(int val){
            q.addLast(val); sum+=val; addNum(val);
            if(q.size()>size){
                int old=q.removeFirst(); sum-=old; removeNum(old);
            }
            return sum*1.0/Math.min(q.size(),size);
        }
        public double getMedian(){
            if(q.isEmpty()) return 0.0;
            if((loSize+hiSize)%2==1) return lo.peek();
            return ((long)lo.peek()+(long)hi.peek())/2.0;
        }
        public int getMin(){
            if(q.isEmpty()) throw new NoSuchElementException();
            PriorityQueue<Integer> all=new PriorityQueue<>();
            all.addAll(lo); all.addAll(hi);
            Map<Integer,Integer> cnt=new HashMap<>();
            for(int v:q) cnt.put(v,cnt.getOrDefault(v,0)+1);
            while(!all.isEmpty()){
                int x=all.poll();
                int c=cnt.getOrDefault(x,0);
                if(c>0){ cnt.put(x,c-1); return x; }
            }
            return 0;
        }
        public int getMax(){
            if(q.isEmpty()) throw new NoSuchElementException();
            PriorityQueue<Integer> all=new PriorityQueue<>(Collections.reverseOrder());
            all.addAll(lo); all.addAll(hi);
            Map<Integer,Integer> cnt=new HashMap<>();
            for(int v:q) cnt.put(v,cnt.getOrDefault(v,0)+1);
            while(!all.isEmpty()){
                int x=all.poll();
                int c=cnt.getOrDefault(x,0);
                if(c>0){ cnt.put(x,c-1); return x; }
            }
            return 0;
        }
    }
    public static void main(String[] args){
        MovingAverage ma=new MovingAverage(3);
        System.out.println(ma.next(1));
        System.out.println(ma.next(10));
        System.out.println(Math.round(ma.next(3)*100)/100.0);
        System.out.println(ma.next(5));
        System.out.println(ma.getMedian());
        System.out.println(ma.getMin());
        System.out.println(ma.getMax());
    }
}