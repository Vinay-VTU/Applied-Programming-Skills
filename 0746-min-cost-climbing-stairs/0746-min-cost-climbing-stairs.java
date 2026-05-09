class Solution {
        public int minCostClimbingStairs(int[] cost) {
                int prev2 = 0;
                        int prev1 = 0;

                                for (int i = 2; i <= cost.length; i++) {
                                            int oneStep = prev1 + cost[i - 1];
                                                        int twoStep = prev2 + cost[i - 2];

                                                                    int current = Math.min(oneStep, twoStep);

                                                                                prev2 = prev1;
                                                                                            prev1 = current;
                                                                                                    }

                                                                                                            return prev1;
                                                                                                                }
                                                                                                                }
