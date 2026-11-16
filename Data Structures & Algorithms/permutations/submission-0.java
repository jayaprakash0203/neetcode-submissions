class Solution {
    List <Integer> curr = new ArrayList<>();
    List <List <Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        Boolean[] used = new Boolean[nums.length];

        for(int i = 0; i< nums.length; i++){
            used[i] = false;
        }

        dfs(nums, 0, used);

        return res;

        
    }

    public void dfs(int[] nums, int index, Boolean[] used){

        if(index == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i< nums.length; i++){

            if(used[i] == true){
                continue;
            }

            curr.add(nums[i]);
            used[i] = true;
            
            dfs(nums, index+1, used);

            curr.remove(curr.size()-1);

            used[i] = false;
            
            


        }
    }
}
