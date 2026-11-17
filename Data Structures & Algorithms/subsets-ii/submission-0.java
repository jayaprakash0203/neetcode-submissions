class Solution {
    List<Integer> curr = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);

        dfs(nums,0);

        return res;
        
    }

    public void dfs(int[] nums, int index){
        
        res.add(new ArrayList<>(curr));
        

        for(int i = index; i< nums.length; i++){

            if(i>index && nums[i] == nums[i-1] ){
                continue;
            }

            curr.add(nums[i]);

            dfs(nums, i+1);

            curr.remove(curr.size() - 1);


        }
    }
}
