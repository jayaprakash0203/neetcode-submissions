public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int i : nums){
            count.put(i, count.getOrDefault(i,0)+1);
        }

        List<Integer> []arr = new List[nums.length+1];

        for(int i = 0; i < nums.length + 1; i++){
            arr[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            arr[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];

        int index = 0;

        for(int i = arr.length - 1; i>0 && index < k; i--){
            for(int n : arr[i]){
                res[index++] = n;
                

                if(index == k){
                    return res;
                }
            }
        }
        return res;
        
    }
}