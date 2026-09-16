class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int total = 0;

        while (left < right){

            if(height[left] < height[right]){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                int sum = leftMax - height[left];
                
                total+=sum;
                
                
            }
            else{
                right--;
                rightMax = Math.max(rightMax, height[right]);
                int sum = rightMax - height[right];
                
                total+=sum;
                
                
            }
        }

        return total;

      

        
    }
}
