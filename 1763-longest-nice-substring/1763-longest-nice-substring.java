class Solution {
    public String longestNiceSubstring(String s) {
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);

                if (isNice(sub) && sub.length() > ans.length()) {
                    ans = sub;
                }
            }
        }

        return ans;
    }

    private boolean isNice(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (Character.isLowerCase(ch)) {
                if (str.indexOf(Character.toUpperCase(ch)) == -1) {
                    return false;
                }
            } else {
                if (str.indexOf(Character.toLowerCase(ch)) == -1) {
                    return false;
                }
            }
        }

        return true;
    }
}