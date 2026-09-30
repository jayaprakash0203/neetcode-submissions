class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxFreq = 0;
        int ans = 0;

        Map<Character, Integer> freq = new HashMap<>();

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            freq.put(ch, (freq.getOrDefault(ch , 0) + 1));
            maxFreq = Math.max(maxFreq, freq.get(ch));
            int reqRep = ((right - left)+1) - maxFreq;
            while(reqRep > k){
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar)-1);
                left++;
                reqRep = ((right - left)+1) - maxFreq;

            }
            ans = Math.max(ans, (right - left)+1);
        }

        return ans;

        
    }
}
