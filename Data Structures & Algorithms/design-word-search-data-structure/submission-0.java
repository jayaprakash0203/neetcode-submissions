class WordDictionary {

    WordDictionary[] children;
    boolean isEnd;

    public WordDictionary() {
        children = new WordDictionary[27];
        isEnd = false;

    }

    public void addWord(String word) {

        WordDictionary current = this;

        for(char ch : word.toCharArray()){
            
            int index = ch - 'a';

            if(current.children[index] == null){
                current.children[index] = new WordDictionary();
            }
            current = current.children[index];

        }
        current.isEnd = true;

    }

    public boolean search(String word) {

        return dfs(word, 0, this);
    }

    public boolean dfs(String word, int index, WordDictionary node){
        if(index == word.length()){
            return node.isEnd;
        }

        char ch = word.charAt(index);

        if(ch == '.'){

            for(WordDictionary child: node.children ){
                if(child != null && dfs(word, index+1, child)){
                    return true;
                }
            }
            return false;
        }

        int currInd = ch - 'a';

        if(node.children[currInd] == null){
            return false;
        }

        return dfs(word, index+1, node.children[currInd]);
    }
}
