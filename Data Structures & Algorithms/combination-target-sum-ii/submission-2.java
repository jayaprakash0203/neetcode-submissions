class Solution {
    List<Integer> curr = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        dfs(candidates, 0, target, target);

       

        return res;
        
    }

    public void dfs(int[] candidates, int index, int target, int remainTarget){

        

        if(remainTarget == 0){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = index; i< candidates.length; i++){

            if(i > index && candidates[i-1] == candidates[i]){
                continue;
            }

            if(remainTarget < candidates[i]){
                break;
            }

            curr.add(candidates[i]);
            dfs(candidates, i+1, target, remainTarget - candidates[i]);

            curr.remove(curr.size() - 1);


        }
       
        

        

        
    }
}
