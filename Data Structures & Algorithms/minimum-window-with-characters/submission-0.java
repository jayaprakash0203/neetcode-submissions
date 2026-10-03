class Solution {
    public String minWindow(String s, String t) {
        int l = 0;
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> wind = new HashMap<>();
        

        for(int i = 0; i< t.length(); i++){
            char ch = t.charAt(i);
            need.put(ch, need.getOrDefault(ch, 0) + 1);
            
        }
        
        int have = 0;
        int needcount = t.length();
        int minval = Integer.MAX_VALUE;
        int minStart = 0;
        for(int r = 0; r < s.length(); r++){
            char ch = s.charAt(r);
            wind.put(ch, wind.getOrDefault(ch, 0) + 1);
            if(need.containsKey(ch) &&
                wind.get(ch) <= need.get(ch)){
                have++;
            }
            

            while(have == needcount){

                if(r - l + 1 < minval){
                    minval = r - l + 1;
                    minStart = l;
                }

                char leftch = s.charAt(l);
                wind.put(leftch, wind.get(leftch) - 1);

                if(need.containsKey(leftch) &&
                wind.get(leftch) < need.get(leftch)){
                    have--;
                }

                

                l++;
               

            }
            

        }

        if(minval == Integer.MAX_VALUE){
            return "";
        }

        return s.substring(minStart, minStart + minval);
        
    }
}
