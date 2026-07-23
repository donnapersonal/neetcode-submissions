# class Solution:
#     def maxProfit(self, prices: List[int]) -> int:
#         minPrice = float('inf')
#         maxProfit = 0
#         for price in prices:
#             if price < minPrice:
#                 minPrice = price
#             elif price - minPrice > maxProfit:
#                 maxProfit = price - minPrice
        
#         return maxProfit

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        dp_i_0, dp_i_1 = 0, float('-inf')

        for i in range(n):
            dp_i_0 = max(dp_i_0, dp_i_1 + prices[i])
            dp_i_1 = max(dp_i_1, -prices[i])
        
        return dp_i_0
