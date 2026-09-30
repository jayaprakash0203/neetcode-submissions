class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxFreq = 0;
        int ans = 0;

        Map<Character, Integer> freq = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            freq.put(ch, (freq.getOrDefault(ch , 0) + 1));
            maxFreq = Math.max(maxFreq, freq.get(ch));
            int reqRep = ((right - left)+1) - maxFreq;
            while(reqRep > k){
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar)-1);
                left++;
                maxFreq = Math.max(maxFreq, freq.get(leftChar));
                reqRep = ((right - left)+1) - maxFreq;

            }
            ans = Math.max(ans, (right - left)+1);
            right++;
        }

        return ans;

        
    }
}
