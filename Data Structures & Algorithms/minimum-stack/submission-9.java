class MinStack {

    Stack<Integer> main;
    Stack<Integer> minStack;

    public MinStack() {
        main = new Stack();
        minStack = new Stack();
    }
    
    public void push(int val) {
        main.push(val);
        if(minStack.isEmpty()){
            minStack.push(val);
        }
        else if(val <= minStack.peek()){
            
            minStack.push(val);
        }
        
        return;
        
    }
    
    public void pop() {
        if(main.isEmpty()){
            return;
        }
        int top = main.pop();
        if(top == minStack.peek()){
            minStack.pop();
        }

        
        
    }
    
    public int top() {
        return main.peek();
        
    }
    
    public int getMin() {
        if(minStack.isEmpty()){
            return 0;
        }
        return minStack.peek();
        
    }
}
