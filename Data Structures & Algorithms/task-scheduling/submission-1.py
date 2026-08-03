# class Solution:
#     def leastInterval(self, tasks: List[str], n: int) -> int:
#         task_count = Counter(tasks)
#         max_count = max(task_count.values())
#         max_count_task = sum(1 for count in task_count.values() if count == max_count)
#         min_time = (max_count - 1) * (n+1) + max_count_task
#         return max(min_time, len(tasks))

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        task_count = [0] * 26
        for task in tasks:
            index = ord(task) - ord('A')
            task_count[index] += 1
        
        max_count = max(task_count)
        max_count_task = 0
        for freq in task_count:
            if freq == max_count:
                max_count_task += 1
        
        min_time = (max_count - 1) * (n+1) + max_count_task
        return max(min_time, len(tasks))
