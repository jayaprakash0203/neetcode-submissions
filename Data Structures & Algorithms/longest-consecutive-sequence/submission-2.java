class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length < 1){
            return 0;
        }
        Set<Integer>  numArr = new HashSet<>();
        
        
        int maxCount = 1;
        for(int num : nums){
            numArr.add(num);
        }
        
        for(int n : nums){
            
            if(!(numArr.contains(n-1))){
                int length = 1;
                while(numArr.contains(n+length)){
                 
                    length++;
                }
                maxCount = Math.max(maxCount, length);
            }
        }
        return maxCount;
        
    }
}
