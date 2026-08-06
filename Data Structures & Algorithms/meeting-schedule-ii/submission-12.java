/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

// class Solution {
//     public int minMeetingRooms(List<Interval> intervals) {
//         if (intervals == null || intervals.size() == 0) return 0;
//         intervals.sort((a, b) -> Integer.compare(a.start, b.start));
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//         int rooms = 0;
//         for (Interval interval : intervals) {
//             while (!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
//                 minHeap.poll();
//             }
//             minHeap.offer(interval.end);
//             rooms = Math.max(rooms, minHeap.size());
//         }
//         return rooms;
//     }
// }

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);
        int start = 0, end = 0;
        int rooms = 0;
        while (start < n) {
            if (starts[start] < ends[end]) {
                rooms++;
            } else {
                end++;
            }
            start++;
        }
        return rooms;
    }
}
