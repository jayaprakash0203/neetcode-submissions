class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans = new int[nums.length - k + 1];

        int l = 0;
        int index = 0;
        for(int r = 0; r< nums.length; r++){

            if(r - l + 1 > k){
                if(nums[l] == nums[deque.peekFirst()]){
                    deque.removeFirst();
                }
                l++;
            }


            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[r]){
                deque.removeLast();
            }
            
            deque.add(r);

            if(r - l + 1 == k){
                ans[index] = nums[deque.peekFirst()];
                index++;
            }
            
        }

        return ans;
        
    }
}
