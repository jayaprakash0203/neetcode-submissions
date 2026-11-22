class Solution {
    StringBuilder curr = new StringBuilder();
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        dfs(0,0,n);
        return res;
        
        
    }

    public void dfs(int open, int close, int n){

        if(open == n && close == n){
            
            res.add(curr.toString());
            return;
        }

        if(open < n){
            curr.append('(');
            dfs(open+1, close, n);
            curr.deleteCharAt(curr.length()-1);
            
        }

        if(close < open ){
            curr.append(')');
            dfs(open, close+1, n);
            curr.deleteCharAt(curr.length()-1);
           

        }
    }
}
