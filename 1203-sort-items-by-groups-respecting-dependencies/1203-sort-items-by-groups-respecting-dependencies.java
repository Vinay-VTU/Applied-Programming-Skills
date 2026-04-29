import java.util.*;

class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {

        // Give new group id to items with group -1
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        List<List<Integer>> itemGraph = new ArrayList<>();
        List<List<Integer>> groupGraph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            groupGraph.add(new ArrayList<>());
        }

        int[] itemIndegree = new int[n];
        int[] groupIndegree = new int[m];

        // Build graphs
        for (int i = 0; i < n; i++) {
            for (int prev : beforeItems.get(i)) {

                // item dependency: prev -> i
                itemGraph.get(prev).add(i);
                itemIndegree[i]++;

                // group dependency
                if (group[prev] != group[i]) {
                    groupGraph.get(group[prev]).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }

        List<Integer> itemOrder = topoSort(itemGraph, itemIndegree);
        List<Integer> groupOrder = topoSort(groupGraph, groupIndegree);

        if (itemOrder.size() != n || groupOrder.size() != m) {
            return new int[0];
        }

        List<List<Integer>> groupItems = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            groupItems.add(new ArrayList<>());
        }

        // Put items inside their group according to valid item order
        for (int item : itemOrder) {
            groupItems.get(group[item]).add(item);
        }

        int[] result = new int[n];
        int index = 0;

        // Add groups according to valid group order
        for (int g : groupOrder) {
            for (int item : groupItems.get(g)) {
                result[index++] = item;
            }
        }

        return result;
    }

    private List<Integer> topoSort(List<List<Integer>> graph, int[] indegree) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int current = q.poll();
            order.add(current);

            for (int next : graph.get(current)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        return order;
    }
}