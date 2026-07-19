// class Solution {
//     public List<List<String>> groupAnagrams(String[] strs) {
//         List<List<String>> res = new LinkedList<>();
//         HashMap<String, List<String>> groups = new HashMap<>();
//         for (String word : strs) {
//             String code = encode(word);
//             groups.putIfAbsent(code, new LinkedList<>());
//             groups.get(code).add(word);
//         } 
//         for(List<String> group : groups.values()) {
//             res.add(group);
//         }
//         return res;
//     }

//     String encode(String s) {
//         char[] count = new char[26];
//         for(char ch : s.toCharArray()) {
//             int delta = ch - 'a';
//             count[delta]++;
//         }
//         return new String(count);
//     }
// }

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String word : strs) {
            int[] count = new int[26];
            for (char ch : word.toCharArray()) {
                count[ch - 'a']++;
            }
            String key = Arrays.toString(count);
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(word);

        } 
        
        return new ArrayList<>(groups.values());
    }
}
