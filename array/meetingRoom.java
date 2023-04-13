/*
Meeting Room I & II
I: Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
II: Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] find the minimum number of conference rooms required.
*/

/* Meeting room I: sort by start time */
public boolean canAttendMeetings(int[][] intervals) {
    Arrays.sort(intervals, new Comparator<int[]>(){
        @Override
        public int compare(int[] o1, int[] o2){
            return o1[0] - o2[0];
        }
    });

    for(int i=1; i<intervals.length; i++){
        // new meeting starts before preivous one ends
        if(intervals[i][0] < intervals[i-1][1])
            return false;
    }
    return true;
}

/* Meeting room II: sort by start time, queue by end time
 */
public int minMeetingRooms(int[][] intervals) {
    if(intervals.length == 0)
        return 0;

    Arrays.sort(intervals, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2){
            return o1[0] - o2[0];
        }
    });

    int ct = 0;
    PriorityQueue<Integer> endTimeQ = new PriorityQueue<Integer>();
    for(int i=0; i<intervals.length; i++){
        // new meetings starts while no existing one ends yet, need to add a new room
        if(endTimeQ.isEmpty() || intervals[i][0] < endTimeQ.peek()){
            ct++;
        }else{
            // a previous meeting has finished already, delete it and add new one
            //  note: we only delete it when a new one is coming
            endTimeQ.poll();
        }
        endTimeQ.offer(intervals[i][1]);
    }
    return ct; 
}

