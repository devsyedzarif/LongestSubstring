public class LongestSubstringFinder {
    public int longestSubstring(String s) {
        if (s.length() < 1) {
            return s.length();
        } else {
            int max = 0;
            int count = 0;
            int i = 0;

            while (i < s.length()) {
                char currentChar = s.charAt(i);
                int index = getIndex(s, currentChar, count, i);
                if (index != -1) {
                    count = index + 1;
                }
                max = Math.max(max, i - count + 1);
                i++;
            }

            return max;
        }
    }

    private int getIndex(String s, char target, int count, int end) {
        for (int j = count; j < end; j++) {
            if (s.charAt(j) == target) {
                return j;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LongestSubstringFinder finder = new LongestSubstringFinder();

        System.out.println("abcabcbb: " + finder.longestSubstring("abcabcbb"));
        System.out.println("bbbbb: " + finder.longestSubstring("bbbbb"));
        System.out.println("pwwkew: " + finder.longestSubstring("pwwkew"));
        System.out.println("null string: " + finder.longestSubstring(""));
        System.out.println("one space: " + finder.longestSubstring(" "));
        System.out.println("two spaces: " + finder.longestSubstring("  "));
    }
}
