class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String value : strs) {
            encoded
                .append(value.length())
                .append('#')
                .append(value);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            int start = j+1;
            int end = start + length;
            decoded.add(str.substring(start, end));
            i = end;
        }
        return decoded;
    }
}
