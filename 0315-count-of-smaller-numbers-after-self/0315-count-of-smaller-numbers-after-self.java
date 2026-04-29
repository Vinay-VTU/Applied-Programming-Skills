import java.util.*;

class Solution {
    int[] tree;
    int offset = 10001;

    public List<Integer> countSmaller(int[] nums) {
        tree = new int[20005];
        Integer[] ans = new Integer[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            int index = nums[i] + offset;

            ans[i] = query(index - 1); // count numbers smaller than nums[i]
            update(index);
        }

        return Arrays.asList(ans);
    }

    private void update(int index) {
        while (index < tree.length) {
            tree[index]++;
            index += index & -index;
        }
    }

    private int query(int index) {
        int sum = 0;

        while (index > 0) {
            sum += tree[index];
            index -= index & -index;
        }

        return sum;
    }
}