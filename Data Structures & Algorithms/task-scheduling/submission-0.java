class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for(char task : tasks){
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for(int count : freq){
            if(count > 0){
                maxHeap.offer(count);
            }      
        }

        Queue<int[]> queue = new LinkedList<>();
        int timer = 0;

        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            timer++;

            if(!queue.isEmpty() && queue.peek()[1] == timer){
                maxHeap.offer(queue.poll()[0]);
            }

            if(!maxHeap.isEmpty()){
                 int fre = maxHeap.poll() - 1;

                if(fre > 0){
                    queue.offer(new int[]{fre, (timer + n + 1)});
                }
            }

           
            

        }

        return timer;
        
    }
}
