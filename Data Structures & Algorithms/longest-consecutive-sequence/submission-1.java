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
            int i = 0;
            if(!(numArr.contains(n-1))){
                int length = 1;
                while(i<nums.length){
                    
                    if(numArr.contains(n+length)){
                        length++;
                    }
                    
                    i++;

                }
                maxCount = Math.max(maxCount, length);
            }
        }
        return maxCount;
        
    }
}
