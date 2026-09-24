class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int arrMax = 0;

        for(int i : piles){
            arrMax = Math.max(arrMax, i);
        }
        int min = Integer.MAX_VALUE;

        int l = 1;
        int r = arrMax;

        while(l <= r){
            int sum = 0;
            int k = l + (r - l) / 2;
            for(int i : piles){
                int indi = ((i % k) == 0 ) ? (i/k) : (i/k) + 1;
                sum += indi;
            }
            

            if(sum <= h){
                min = Math.min(min, k);
                r = k - 1;
            }
            else{
                l = k + 1;
            }
        }

        return min;
        
    }
}
