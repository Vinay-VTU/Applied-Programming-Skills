import java.util.*;

class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();

        for (String email : emails) {
            String[] parts = email.split("@");

            String local = parts[0];
            String domain = parts[1];

            StringBuilder clean = new StringBuilder();

            for (int i = 0; i < local.length(); i++) {
                char ch = local.charAt(i);

                if (ch == '+') {
                    break;
                }

                if (ch != '.') {
                    clean.append(ch);
                }
            }

            String finalEmail = clean.toString() + "@" + domain;
            set.add(finalEmail);
        }

        return set.size();
    }
}
