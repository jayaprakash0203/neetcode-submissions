class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length() > s2.length()){
            return false;
        }

       int[] s1freq = new int[26];
       int[] s2freq = new int[26];

       for(int i = 0; i< s1.length(); i++){
            s1freq[s1.charAt(i) - 'a']++;
            s2freq[s2.charAt(i) - 'a']++;
       }

       int matches = 0;
       for(int i = 0; i<26; i++){
         if(s1freq[i] == s2freq[i]){
            matches++;
         }
       }

       int l = 0;
       for(int r = s1.length(); r < s2.length(); r++){
            if(matches == 26){
                return true;
            }

            int indexr = s2.charAt(r) - 'a';
            s2freq[indexr]++;

            if(s1freq[indexr] == s2freq[indexr]){
                matches++;
            }
            else if(s1freq[indexr]+1 == s2freq[indexr]){
                matches--;
            }

            int indexl = s2.charAt(l) - 'a';
            s2freq[indexl]--;

            if(s1freq[indexl] == s2freq[indexl]){
                matches++;
            }
            else if(s1freq[indexl]-1 == s2freq[indexl]){
                matches--;
            }
            l++;
       }

       return matches == 26;
      
    }
}
