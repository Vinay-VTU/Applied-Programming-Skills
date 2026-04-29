import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Do not take current number
        backtrack(nums, index + 1, current, result);

        // Take current number
        current.add(nums[index]);
        backtrack(nums, index + 1, current, result);

        // Remove for backtracking
        current.remove(current.size() - 1);
    }
}