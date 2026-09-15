class Solution {
    public int maxArea(int[] heights) {

        int p1 = 0;
        int p2 = heights.length-1;
        int maxArea = 0;

        while(p1<p2){
            int length = p2 - p1;
            int breadth = Math.min(heights[p1], heights[p2]);
            int area = length * breadth;
            maxArea = Math.max(area, maxArea);
            if(heights[p1] < heights[p2]){
                p1++;
            }
            else{
                p2--;
            }
    
        }
        return maxArea;
        
    }
}
