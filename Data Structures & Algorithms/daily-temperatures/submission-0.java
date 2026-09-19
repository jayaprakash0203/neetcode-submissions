class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int [] sol = new int[temperatures.length];

        Stack<Integer> ind = new Stack<>();  
        for(int i = 0; i < temperatures.length; i++){
            
            while(!ind.isEmpty() && 
            temperatures[i] > temperatures[ind.peek()]){
                    sol[ind.peek()] = i-ind.peek();
                    ind.pop();  
            }

            ind.push(i);
            

        }
        return sol;
        
    }
}
