package AZStriverPlaylist.Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class NMeetingInOneRoom {
    static class Meeting {
        int start;
        int end;
        int position;

        public Meeting(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }
    }

    public static int maxMeetings(int[] start, int[] end) {
        int count = 0;
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meetings.add(new Meeting(start[i], end[i], i));
        }
        meetings.sort(Comparator.comparing((item) -> item.end));

        int lastEnd = -1;
        for (int i = 0; i < meetings.size(); i++) {
            if (meetings.get(i).start > lastEnd) {
                System.out.println("Meeting start : " + meetings.get(i).start + " end : " + meetings.get(i).end);
                lastEnd = meetings.get(i).end;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Meetings scheduled : ");
        maxMeetings(new int[]{1, 3, 0, 5, 8, 5}, new int[]{2, 4, 6, 7, 9, 9});
        System.out.println("---------------------------------------------------");
        System.out.println("Meetings scheduled : ");
        maxMeetings(new int[]{10, 12, 20}, new int[]{20, 25, 30});
    }
}
