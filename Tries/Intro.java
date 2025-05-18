
class TrieNode {

    TrieNode[] children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[26];
        isEndOfWord = false;
    }
}

class Trie{
    private final TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode node = this.root;

        for(int i=0; i<word.length(); i++){
            char curr = word.charAt(i);
            int idx = curr - 'a';

            if(node.children[idx] == null)
                node.children[idx] = new TrieNode();
            
            //move to children
            node = node.children[idx];
        }

        node.isEndOfWord = true;
    }

    //search a word in the trie
    public boolean search(String word){
        TrieNode node = root;

        for(int i=0; i<word.length(); i++){
            char curr = word.charAt(i);
            int idx = curr - 'a';

            if(node.children[idx] == null)
                return false;
            
            node = node.children[idx];
        }

        return node.isEndOfWord;
    }

    //Check if there exists any word which starts with the given prefix
    public boolean prefixSearch(String prefix){
                TrieNode node = root;

        for(int i=0; i<prefix.length(); i++){
            char curr = prefix.charAt(i);
            int idx = curr - 'a';

            if(node.children[idx] == null)
                return false;
            
            node = node.children[idx];
        }

        return true;
    }

    public boolean delete(String word){
        return deleteHelper(word, root, 0);
    }

    private boolean deleteHelper(String word, TrieNode node, int depth){
        if(node == null)
            return false;

        if(depth == word.length()){
            //base case: if the current node is not end of the given word we cant delete it as it may be present in other word
            if(!node.isEndOfWord)
                return false;
            //else set it to false as now the current node does not represent the end of the word as the given word should be deleted
            node.isEndOfWord = false;

            //if node has no children, it can be delted
            return isEmpty(node);
        }

        int idx = word.charAt(depth) - 'a';

        if(deleteHelper(word, node.children[idx], depth+1)){
            node.children[idx] = null; //remove the reference

            //if current node is not the end of another word and has no children (then it can be deleted as well)
            return !node.isEndOfWord && isEmpty(node);
        }

        //if can't delete
        return false;
    }

    private boolean isEmpty(TrieNode node){
        for(int i=0; i< 26; i++){
            if(node.children[i] != null)
                return false;
        }

        return true;
    }
}

public class Intro {
public static void main(String[] args) {
    Trie trie = new Trie();
    trie.insert("and");
    trie.insert("ant");
    trie.search("ant");
    System.out.println("ant is present: "+ trie.search("ant"));
    trie.delete("ant");
    System.out.println("ant is present after deletion: "+ trie.search("ant"));
    System.out.println("prefix an is present: "+trie.prefixSearch("an"));
}
}
