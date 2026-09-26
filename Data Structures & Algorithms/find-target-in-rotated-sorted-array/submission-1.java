class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target <= nums[mid]){

                    int l = left;
                    int r = mid;
                    return binarySearch(nums, l, r, target); 
                     
                }
                else{
                    left = mid + 1;
                }
            }
            else{
                if(target >= nums[mid] && target <= nums[right]){
                    int l = mid;
                    int r = right;
                    return binarySearch(nums, l, r, target); 
                }
                else{
                    right = mid - 1;
                }

            }
        }
        return -1;
    }
    public int binarySearch(int[] nums, int l, int r, int target){
        
        while(l <= r){
            int m = l + (r - l)/2;
            if(target == nums[m]){
                return m;
            }

            else if(target > nums[m]){
                l = m + 1;
            }
            else{
                r = m - 1;
            }

        }
        return -1;

    }
}
