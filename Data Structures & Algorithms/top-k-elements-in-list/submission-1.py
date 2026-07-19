class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        n = len(nums)
        # This creates a hashmap (valToFreq) that maps each number to its frequency.
        # Counter(nums) automatically counts how many times each unique number appears.
        # Time complexity: O(n) where n is the length of nums.
        valToFreq = Counter(nums)
        # We create a list of empty lists, where index i will hold all numbers that appear exactly i times.
        # len(nums) + 1 ensures we can index all possible frequencies (from 1 up to n).
        # This is the bucket sort idea: group values by frequency directly.
        # Why len(nums) + 1? Because the maximum frequency any number can have is len(nums) (e.g., if all elements are the same).
        freqToVals = [[] for _ in range(n+1)]

        # For each number and its frequency:
        # Place the number into the corresponding frequency bucket.
        # This operation is O(n) in total since each element is processed once.
        for num, freq in valToFreq.items():
            freqToVals[freq].append(num)
        
        # Initialize the result list res.
        res = []

        # Start from the highest frequency (len(freqToVals) - 1) and move down to 1.
        # We skip index 0 because no number can occur zero times.
        for i in range(len(freqToVals) - 1, 0, -1):
            # For each value in the current frequency bucket:
            # Append it to the result list.
            # As soon as we have k elements, we return res.
            # 📌 Why break early? To avoid collecting more than k elements — this ensures we only gather the top k.
            for val in freqToVals[i]:
                res.append(val)
                if len(res) == k:
                    return res
        

        # This line is just a fallback return, though logically the return inside the loop should always trigger once k elements are gathered.
        return res
