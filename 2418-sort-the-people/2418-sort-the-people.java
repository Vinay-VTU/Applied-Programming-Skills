class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        
        // Sort indices by height descending
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        Arrays.sort(indices, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return heights[b] - heights[a]; // descending
            }
        });
        
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = names[indices[i]];
        }
        
        return result;
    }
}

