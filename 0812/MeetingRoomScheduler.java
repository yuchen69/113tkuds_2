import java.util.*;

public class MeetingRoomScheduler {
    public static int minRooms(int[][] intervals){
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int[] it:intervals){
            if(!pq.isEmpty() && pq.peek()<=it[0]) pq.poll();
            pq.offer(it[1]);
        }
        return pq.size();
    }
    public static List<int[]> scheduleMaxTotalTimeSingleRoom(int[][] intervals){
        Arrays.sort(intervals,(a,b)->a[1]==b[1]?Integer.compare(a[0],b[0]):Integer.compare(a[1],b[1]));
        List<int[]> res=new ArrayList<>();
        int end=-1;
        for(int[] it:intervals){
            if(it[0]>=end){ res.add(it); end=it[1]; }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(minRooms(new int[][]{{0,30},{5,10},{15,20}}));
        System.out.println(minRooms(new int[][]{{9,10},{4,9},{4,17}}));
        System.out.println(minRooms(new int[][]{{1,5},{8,9},{8,9}}));
        int[][] one={{1,4},{2,3},{4,6}};
        List<int[]> sch=scheduleMaxTotalTimeSingleRoom(one);
        int total=0; for(int[] it:sch) total+=it[1]-it[0];
        System.out.println(total);
    }
}
