class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();

        for (String s : strs){
            encoded.append(s.length());
            encoded.append(",");
        }
        encoded.append("#");
        for (String s : strs){
            encoded.append(s);
        }
        return encoded.toString();

    }

    public List<String> decode(String str) {
        
        List<Integer> sizes = new ArrayList<>();
        List<String> res = new ArrayList<>();
        
        
        int i = 0;
        while(str.charAt(i)!= '#'){
            StringBuilder count = new StringBuilder();

            while(str.charAt(i) != ','){  
                count.append(str.charAt(i));
                
                i++;
            }
            sizes.add(Integer.parseInt(count.toString()));
            i++;
        }
        i++;

        for(Integer size : sizes){
            res.add(str.substring(i, i + size));
            i +=size;
        }
        return res;

        
    

    }
}
