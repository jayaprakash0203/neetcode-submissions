class PrefixTree {

    PrefixTree[] children;
    boolean isEnd;

    public PrefixTree() {
        children = new PrefixTree[26];
        isEnd = false;

         
    }

    public void insert(String word) {

        PrefixTree current = this;
        
        for(char ch: word.toCharArray()){
            int index = ch - 'a';

            if(current.children[index] == null){
                current.children[index] = new PrefixTree();
            }
            current = current.children[index];
            
        }
        current.isEnd = true;

    }

    public boolean search(String word) {
        PrefixTree current = this;

        for(char ch: word.toCharArray()){
            int index = ch - 'a';

            if(current.children[index] == null){
                return false;
            }

            current = current.children[index];

        }

        return current.isEnd;

    }

    public boolean startsWith(String prefix) {

        PrefixTree current = this;

        for(char ch: prefix.toCharArray()){
            int index = ch - 'a';

            if(current.children[index] == null){
                return false;
            }

            current = current.children[index];

        }

        return true;

    }
}
