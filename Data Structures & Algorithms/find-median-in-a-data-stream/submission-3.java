class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        
        if(left.isEmpty() || num <= left.peek()){
            left.offer(num);
        }
        else{
            right.offer(num);
        }

        if(left.size() > right.size() + 1){
            right.offer(left.poll());
            
        }
        else if(right.size() > left.size() + 1){
            left.offer(right.poll());
        }

        if(!left.isEmpty() && !right.isEmpty() && left.peek() > right.peek()){

            int leftval = left.poll();
            int rightval = right.poll();

            left.offer(rightval);
            right.offer(leftval);
        }



        
         
    }
    
    public double findMedian() {
        
        if(left.size() > right.size()){
            return left.peek();
        }
        else if(right.size() > left.size()){
            return right.peek();
        }
        else{
            double ans = (left.peek() + right.peek())/2.0;
            return ans;
        }
        
    }
}
