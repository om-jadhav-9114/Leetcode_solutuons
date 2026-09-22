class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Place every number in its correct position
        // number x should be at index x - 1
        for (int i = 0; i < n; i++) {
            while (nums[i] >= 1
                    && nums[i] <= n
                    && nums[nums[i] - 1] != nums[i]) {

                int correctIndex = nums[i] - 1;

                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }

        // Find the first position containing the wrong value
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // All values 1..n are present
        return n + 1;
    }
}