class Solution {
    List<Integer> curr = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        dfs(nums,0,target,target);

        return res;
        


        
    }
    public void dfs(int[] nums, int index, int target, int remainTarget){
        
        if(remainTarget == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(remainTarget < 0){
            return;
        }

        if(index == nums.length){
            return;
        }

        curr.add(nums[index]);
        
        dfs(nums, index, target, remainTarget - nums[index]);

        curr.remove(curr.size()-1);

        dfs(nums, index+1, target, remainTarget);
    }
}
