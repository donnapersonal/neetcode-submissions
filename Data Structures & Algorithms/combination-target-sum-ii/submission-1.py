class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res, track = [], []
        candidates.sort()

        def backtrack(target, start):
            if target == 0:
                res.append(track[:])
                return
            
            for i in range(start, len(candidates)):
                cur = candidates[i]
                if cur > target:
                    return
                
                if i > start and candidates[i-1] == cur:
                    continue

                track.append(cur)
                backtrack(target - cur, i+1)
                track.pop() 

        backtrack(target, 0)
        return res