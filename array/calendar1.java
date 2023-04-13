/*
Calendar I&II
I: Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.

lc 729
*/

/** Go through each node */
    ArrayList<int[]> cal;

    public MyCalendar() {
        cal = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        int[] item = new int[]{start, end};
        if(cal == null)
            cal.add(item);
        else{
            for(int i=0; i<cal.size(); i++){
                int[] cur = cal.get(i);
                //overlap:
                if(cur[0] < end && cur[1] > start)
                    return false;
            }
            cal.add(item);
        }
        return true;
    }


/** sort in tree map, sort by start  */
    // map<start, end>
    TreeMap<Integer, Integer> calendar;

    MyCalendar() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prevStart = calendar.floorKey(start);
        Integer nextStart = calendar.ceilingKey(start);
        if((prevStart == null || calendar.get(prevStart) <= start) &&
                (nextStart == null || end <= nextStart)) {
            calendar.put(start, end);
            return true;
        }
        else
            return false;
    }
