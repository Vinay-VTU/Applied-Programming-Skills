import java.util.*;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
            int n = nums.length;
                    Integer[] ans = new Integer[n];

                            int offset = 10001;
                                    int size = 20002;

                                            FenwickTree tree = new FenwickTree(size);

                                                    for (int i = n - 1; i >= 0; i--) {
                                                                int index = nums[i] + offset;

                                                                            ans[i] = tree.query(index - 1);

                                                                                        tree.update(index, 1);
                                                                                                }

                                                                                                        return Arrays.asList(ans);
                                                                                                            }
                                                                                                            }

                                                                                                            class FenwickTree {
                                                                                                                int[] tree;

                                                                                                                    FenwickTree(int size) {
                                                                                                                            tree = new int[size + 1];
                                                                                                                                }

                                                                                                                                    void update(int index, int value) {
                                                                                                                                            index++;

                                                                                                                                                    while (index < tree.length) {
                                                                                                                                                                tree[index] += value;
                                                                                                                                                                            index += index & -index;
                                                                                                                                                                                    }
                                                                                                                                                                                        }

                                                                                                                                                                                            int query(int index) {
                                                                                                                                                                                                    index++;

                                                                                                                                                                                                            int sum = 0;

                                                                                                                                                                                                                    while (index > 0) {
                                                                                                                                                                                                                                sum += tree[index];
                                                                                                                                                                                                                                            index -= index & -index;
                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                            return sum;
                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                }