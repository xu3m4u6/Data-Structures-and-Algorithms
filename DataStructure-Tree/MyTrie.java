// Leetcode 208. Implement Trie (Prefix Tree)
// https://leetcode.com/problems/implement-trie-prefix-tree/

class MyTrie {

	public class TrieNode {
		boolean isWord;
		TrieNode[] children = new TrieNode[26];
	}

	private TrieNode root;
    /** Initialize your data structure here. */
    public MyTrie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++){
        	char c = word.charAt(i);

        	if(curr.children[c - 'a'] == null)
        		curr.children[c - 'a'] = new TrieNode();
        	curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return searchHelper(word, 1);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
    	return searchHelper(prefix, 2);
    }

    public boolean searchHelper(String word, int type) {
    	TrieNode curr = root;

    	for (int i = 0; i < word.length(); i++){
    		char c = word.charAt(i);
        	if(curr.children[c - 'a'] == null)
        		return false;
        	curr = curr.children[c - 'a'];
        }
        return type == 1 ? curr.isWord : true;
    }


    public static void main(String[] args) {

    	MyTrie trie = new MyTrie();

		trie.insert("apple");
		System.out.println(trie.search("apple"));   // returns true
		System.out.println(trie.search("app"));     // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");   
		System.out.println(trie.search("app"));     // returns true
    }
}
