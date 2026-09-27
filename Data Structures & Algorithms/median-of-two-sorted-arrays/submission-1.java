class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int len = nums1.length + nums2.length;

        int leftSize = (len % 2 == 0) ? len / 2 : (len + 1) / 2;

        int left = 0;
        int m = nums1.length;
        int right = m;

        
        
        while(left <= right){
            int partionA = left + (right - left)/2;

            int partionB = leftSize - partionA;


            int aLeft = (partionA == 0) ? Integer.MIN_VALUE : nums1[partionA - 1];

            int aRight = (partionA == m) ? Integer.MAX_VALUE : nums1[partionA];

            int bLeft = (partionB == 0) ? Integer.MIN_VALUE : nums2[partionB - 1];

            int bRight = (partionB == nums2.length) ? Integer.MAX_VALUE : nums2[partionB];

            if((aLeft <= bRight) && (aRight >= bLeft)){

                double median = (len % 2 == 0) ? (Math.max(aLeft, bLeft) + Math.min(aRight, bRight))/2.0 : Math.max(aLeft, bLeft) ;

                return median;

            }
            else if(aLeft > bRight){
                right = partionA - 1;
            }
            else{
                left = partionA + 1;
            }

            

        }

        return 0.0;

        
    }
}
