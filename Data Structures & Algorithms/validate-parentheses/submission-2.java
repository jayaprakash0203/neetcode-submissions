class Solution {
    public boolean isValid(String s) {
        Stack<Character> sol = new Stack<>();

        for(char ch : s.toCharArray()){
            if((!sol.isEmpty()) && ((ch == '}') && (sol.peek() == '{') ||
               (ch == ']') && (sol.peek() == '[') ||
               (ch == ')') && (sol.peek() == '(')) 
            ){
                sol.pop();
            }
            else{
                sol.push(ch);
            }

        }
        return sol.isEmpty();

        
    }
}
