// class Solution {
//     public int canCompleteCircuit(int[] gas, int[] cost) {
//         int n = gas.length;
//         int curTank = 0;
//         int totalTank = 0;
//         int start = 0;
//         for (int i = 0; i < n; i++) {
//             int gain = gas[i] - cost[i];
//             totalTank += gain;
//             curTank += gain;
//             if (curTank < 0) {
//                 start = i + 1;
//                 curTank = 0;
//             }
//         }
//         return totalTank >= 0 ? start : -1;
//     }
// }

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int minSum = 0;
        int total = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            total += gas[i] - cost[i];
            if (total < minSum) {
                start = i + 1;
                minSum = total;
            }
        }
        return total >= 0 ? start : -1;
    }
}
