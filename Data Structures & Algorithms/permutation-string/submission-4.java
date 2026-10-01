class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()){
            return false;
        }
        Map<Character, Integer> s1freq = new HashMap<>();

        Map<Character, Integer> wind = new HashMap<>();

        for(char ch : s1.toCharArray()){
            s1freq.put(ch, (s1freq.getOrDefault(ch , 0) + 1));
        } 

        int left = 0;
        for(int right = 0; right < s2.length(); right++){
            char ch = s2.charAt(right);

            wind.put(ch, wind.getOrDefault(ch,0)+1);

            if(right - left +1 > s1.length()){
                char leftChar = s2.charAt(left);

                wind.put(leftChar, wind.get(leftChar)-1);

                if (wind.get(leftChar) == 0) {
                    wind.remove(leftChar);
                }


                left++;
            }

            if(wind.equals(s1freq)){
                return true;
            }
        }

        return false;
        
        
    }
}
