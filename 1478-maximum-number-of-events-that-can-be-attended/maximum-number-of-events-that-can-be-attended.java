class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events,(a,b) -> Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count=0;
        int lastday =0;
        for(int [] event : events){
            lastday = Math.max(lastday,event[1]);
        }
        int day = events[0][0];
        int i=0;
        for(int d= day;d<=lastday;d++){
            while(i<n && events[i][0]<=d){
                pq.offer(events[i][1]);
                i++;
            }
            while(!pq.isEmpty() && pq.peek()<d){
                pq.poll();
            }
            if(!pq.isEmpty()){
                pq.poll();
                count++;
                
            }
            if(i==n && pq.isEmpty()){
                break;
            }
        }
        return count;
        
    }
}