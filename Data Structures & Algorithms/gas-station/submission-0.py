class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        n = len(gas)
        curTank = 0
        total = 0
        start = 0
        for i in range(n):
            gain = gas[i] - cost[i];
            total += gain;
            curTank += gain;
            if curTank < 0:
                start = i + 1
                curTank = 0
        
        return start if total >= 0 else -1