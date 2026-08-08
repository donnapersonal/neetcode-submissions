class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize != 0:
            return False
        
        counts = Counter(hand)
        for start in sorted(counts.keys()):
            groups = counts[start]
            if groups == 0:
                continue
            
            for card in range(start, start + groupSize):
                if counts[card] < groups:
                    return False
                
                counts[card] -= groups
            
        return True