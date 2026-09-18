class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> ans = new Stack<>();


        for(String s : tokens){
            if(!ans.isEmpty() && s.equals("+")){
                int a = ans.pop();
                int b = ans.pop();
                ans.push(add(a,b));
            }
            else if(!ans.isEmpty() && s.equals("-")){
                int a = ans.pop();
                int b = ans.pop();
                ans.push(sub(b,a));
            }

            else if(!ans.isEmpty() && s.equals("*")){
                int a = ans.pop();
                int b = ans.pop();
                ans.push(mul(a,b));
            }
            else if(!ans.isEmpty() && s.equals("/")){
                int a = ans.pop();
                int b = ans.pop();
                ans.push(div(b,a));
            }
            else{
                ans.push(Integer.parseInt(s));
            }
        }

        return ans.peek();
        
    }
    public int add(int a, int b){
        return a+b;
    }

    public int sub(int a, int b){
        return a - b;
        
    }
    public int mul(int a, int b){
        return a*b;
    }
    public int div(int a, int b){
        return a/b;
    }

    
}
