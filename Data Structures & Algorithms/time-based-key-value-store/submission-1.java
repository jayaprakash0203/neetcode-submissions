class TimeMap {

    class Entry{
        int timeStamp;
        String value;

        public Entry(int timeStamp, String value){
            this.timeStamp = timeStamp;
            this.value = value;
        }

    }
    

    Map<String , List<Entry>> ans;
    

    public TimeMap() {
        ans = new HashMap<>();
       
    }
    
    public void set(String key, String value, int timestamp) {
        ans.computeIfAbsent(key, k -> new ArrayList<>()).add(new Entry(timestamp, value));

        
        
    }
    
    public String get(String key, int timestamp) {

        List<Entry> res = ans.get(key);

        if (res == null) {
            return "";
        }

        int left = 0;
        int right = res.size() - 1;
        int answer = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if (res.get(mid).timeStamp == timestamp){
                return res.get(mid).value;
            }
            else if(res.get(mid).timeStamp < timestamp){
                left = mid + 1;
                answer = mid;
            }
            else{
                right = mid - 1;
            }
        }

        return answer == -1 ? "" : res.get(answer).value;


        
    }
}
