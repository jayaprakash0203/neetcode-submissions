class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(Collections.reverseOrder());

        for(int i = 0; i < position.length; i++){
            sortedMap.put(position[i],speed[i]);
        }

        Stack<Double> ans = new Stack<>();

        for(Map.Entry<Integer, Integer> entry : sortedMap.entrySet()){
            double time = (double)(target - entry.getKey())/ entry.getValue();
            if(ans.isEmpty() || ans.peek() < time){
                ans.push(time);
            }
        }
        return ans.size();
        
    }
}
