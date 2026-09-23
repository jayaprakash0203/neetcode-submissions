class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int leftM = 0;
        int rightM = matrix.length-1;

        while(leftM <= rightM){

            int midM = leftM + (rightM - leftM)/2;
            int[] ans = matrix[midM];

            boolean targetM = (target >= ans[0] && target <= ans[ans.length - 1])? true : false;
             
            if(targetM){
                int l = 0;
                int r = ans.length - 1;

                while(l <= r){
                    int m = l + (r - l)/2;

                    if(target == ans[m]){
                        return true;
                    }
                    else if(target > ans[m]){
                        l = m + 1;
                    }
                    else{
                        r = m - 1;
                    }
                }
                return false;

            }
            else if(target < ans[0]){
                rightM = midM - 1;
            }
            else{
                leftM = midM + 1;
            }



        }
        return false;
        
    }
}
