/*
lc 731

II: Implement a MyCalendarTwo class to store your events. A new event can be added if adding the event will not cause a triple booking.
*/

List<int[]> calendar;
List<int[]> overlaps;

MyCalendarTwo() {
    calendar = new ArrayList();
    overlaps = new ArrayList<>();
}

public boolean book(int start, int end) {
    // overlap with existing overlap
    for (int[] ov: overlaps) {
        if (ov[0] < end && start < ov[1])
            return false;
    }

    for (int[] range : calendar) {
        // a new overlap
        if (range[0] < end && start < range[1])
            overlaps.add(new int[]{Math.max(start, range[0]), Math.min(end, range[1])});
    }
    calendar.add(new int[]{start, end});
    return true;
}

