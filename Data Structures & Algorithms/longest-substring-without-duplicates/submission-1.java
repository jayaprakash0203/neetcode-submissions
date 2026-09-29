class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxSub = 0;
        StringBuilder str = new StringBuilder();
        int left = 0;

        
        
        for(int i = 0; i< s.length(); i++){
            char ch = s.charAt(i);
            while(str.indexOf(ch+"")!= -1){
                str.deleteCharAt(0);
                left++;
                
            }
            
            str.append(ch);
            
            
            maxSub = Math.max(maxSub, str.length());
            
        }

        return maxSub;

    }
}
