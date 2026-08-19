# class Solution:
#     def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
#         if not wordList or not endWord in wordList:
#             return 0
        
#         word_set = set(wordList)
#         if beginWord in word_set:
#             word_set.remove(beginWord)
        
#         que = deque([(beginWord, 1)])
#         while que:
#             word, level = que.popleft()
#             if word == endWord:
#                 return level
            
#             for i in range(len(word)):
#                 for j in range(26):
#                     new_word = word[:i] + chr(ord('a') + j) + word[i+1:]
#                     if new_word in word_set:
#                         word_set.remove(new_word)
#                         que.append((new_word, level+1))
            
#         return 0

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if not wordList or not endWord in wordList:
            return 0
        
        word_set = set(wordList)
        if beginWord in word_set:
            word_set.remove(beginWord)
        
        begin_set = set([beginWord])
        end_set = set([endWord])
        visited = set()
        level = 1

        while begin_set and end_set:
            if len(begin_set) < len(end_set):
                begin_set, end_set = end_set, begin_set
            
            next_level_set = set()
            for word in begin_set:
                for i in range(len(word)):
                    for c in 'abcdefghijklmnopqrstuvwxyz':
                        new_word = word[:i] + c + word[i+1:]
                        if new_word in end_set:
                            return level + 1
                        
                        if new_word in word_set and new_word not in visited:
                            visited.add(new_word)
                            next_level_set.add(new_word)
                
            begin_set = next_level_set
            level += 1
        
        return 0
                


