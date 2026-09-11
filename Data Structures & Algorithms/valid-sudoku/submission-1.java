class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> []rows = new HashSet[9];
        Set<Character> []columns = new HashSet[9];
        Set<Character> []boxes = new HashSet[9];

        for(int i = 0; i < 9; i++){
            rows[i] = new HashSet<>();
            columns[i] = new HashSet<>();
            boxes [i] = new HashSet<>();
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j< 9; j++){
                char val = board[i][j];
                if(val == '.'){
                    continue;
                }
                else{
                    int boxInd = (i/3)*3 + j/3 ;

                    if( rows[i].contains(val) || 
                        columns[j].contains(val) ||
                        boxes[boxInd].contains(val)
                    )
                    {
                        return false;
                    }
                    
                    
                    rows[i].add(val);
                    columns[j].add(val);
                    boxes[boxInd].add(val);

                    
                }
            }
        }
        return true;

        
    }
}
