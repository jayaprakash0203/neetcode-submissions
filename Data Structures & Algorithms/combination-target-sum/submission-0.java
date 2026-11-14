class Solution {
    List<Integer> curr = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {

        dfs(nums,0,target);

        return res;
        


        
    }
    public void dfs(int[] nums, int index, int target){
        int sum = 0;
        
        for(int i : curr){
            sum = sum+i;
        }
        if(sum == target){
            res.add(new ArrayList<>(curr));
            return;
        }
        if(sum > target){
            return;
        }

        if(index == nums.length){
            return;
        }

        curr.add(nums[index]);
        dfs(nums, index, target);

        curr.remove(curr.size()-1);

        dfs(nums, index+1, target);
    }
}
