class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for(int i = 0; i < heights.length + 1; i++){
            int currentHeight = (i == heights.length) ? 0 : heights[i];

            
            while(!stack.isEmpty() && 
                   currentHeight < heights[stack.peek()]){

                    int height = heights[stack.pop()];
                    int width;
                    if(stack.isEmpty()){
                        width = i;
                    }
                    else{
                        width = i - stack.peek() -1;
                    }

                    int area = width *height;

                    maxArea = Math.max(area, maxArea);        

            }
            stack.push(i);
        }
        return maxArea;
    }
}
