class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        if not wordList or not endWord in wordList:
            return 0
        
        word_set = set(wordList)
        if beginWord in word_set:
            word_set.remove(beginWord)
        
        que = deque([(beginWord, 1)])
        while que:
            word, level = que.popleft()
            if word == endWord:
                return level
            
            for i in range(len(word)):
                for j in range(26):
                    new_word = word[:i] + chr(ord('a') + j) + word[i+1:]
                    if new_word in word_set:
                        word_set.remove(new_word)
                        que.append((new_word, level+1))
            
        return 0