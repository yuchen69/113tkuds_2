import java.util.*;

public class PriorityQueueWithHeap {
    static class Task {
        String name; int priority; long time;
        Task(String n,int p,long t){name=n;priority=p;time=t;}
    }
    static class TaskQueue {
        private long clock=0;
        private PriorityQueue<Task> pq=new PriorityQueue<>((a,b)->{
            if(a.priority!=b.priority) return Integer.compare(b.priority,a.priority);
            return Long.compare(a.time,b.time);
        });
        public void addTask(String name,int priority){ pq.add(new Task(name,priority,clock++)); }
        public String executeNext(){ if(pq.isEmpty()) return null; return pq.poll().name; }
        public String peek(){ return pq.isEmpty()?null:pq.peek().name; }
        public void changePriority(String name,int newPriority){
            List<Task> tmp=new ArrayList<>();
            Task target=null;
            while(!pq.isEmpty()){
                Task t=pq.poll();
                if(target==null&&t.name.equals(name)) target=t; else tmp.add(t);
            }
            if(target!=null){ target.priority=newPriority; target.time=clock++; }
            if(target!=null) tmp.add(target);
            pq.addAll(tmp);
        }
    }
    public static void main(String[] args){
        TaskQueue q=new TaskQueue();
        q.addTask("備份",1);
        q.addTask("緊急修復",5);
        q.addTask("更新",3);
        ArrayList<String> order=new ArrayList<>();
        order.add(q.executeNext());
        order.add(q.executeNext());
        order.add(q.executeNext());
        System.out.println(order);
        q.addTask("A",2);
        q.addTask("B",2);
        q.changePriority("A",6);
        System.out.println(q.executeNext());
        System.out.println(q.peek());
    }
}