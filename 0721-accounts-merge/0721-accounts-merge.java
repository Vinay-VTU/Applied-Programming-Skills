import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parent = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        // Make parent for every email and union emails in same account
        for (List<String> account : accounts) {
            String name = account.get(0);

            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                parent.putIfAbsent(email, email);
                emailToName.put(email, name);

                union(parent, account.get(1), email);
            }
        }

        // Group emails by root parent
        Map<String, TreeSet<String>> groups = new HashMap<>();

        for (String email : parent.keySet()) {
            String root = find(parent, email);
            groups.putIfAbsent(root, new TreeSet<>());
            groups.get(root).add(email);
        }

        List<List<String>> result = new ArrayList<>();

        for (String root : groups.keySet()) {
            List<String> merged = new ArrayList<>();
            merged.add(emailToName.get(root));
            merged.addAll(groups.get(root));
            result.add(merged);
        }

        return result;
    }

    private String find(Map<String, String> parent, String email) {
        if (!parent.get(email).equals(email)) {
            parent.put(email, find(parent, parent.get(email)));
        }
        return parent.get(email);
    }

    private void union(Map<String, String> parent, String a, String b) {
        String rootA = find(parent, a);
        String rootB = find(parent, b);

        if (!rootA.equals(rootB)) {
            parent.put(rootB, rootA);
        }
    }
}