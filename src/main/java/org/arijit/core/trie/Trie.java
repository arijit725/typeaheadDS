package org.arijit.core.trie;

/**
 * This Trie implementation specifically deals with String Trie where each character is a node.
 * @author ARIJIT
 *
 */
public class Trie {
	/*
	 * root is just a pointer. It would not contain any value.
	 */
	private TrieNode<Character,String> root ;
	
	private Trie() {
		root = TrieNode.create(null);		
	}
	
	public static Trie create() {
		Trie trie = new Trie();
		return trie;
	}
	
	/**
	 * Insert method will be used to insert new word into trie.
	 * @param word
	 */
	public void insert(String word) {
		TrieNode<Character,String> tmpRoot = this.root;
		TrieNode<Character,String> node = null;
		for(int i=0;i<word.length();i++) {
			char ch = word.charAt(i);
			if(!tmpRoot.hasChild(ch)) {
				// add child to root
				TrieNode<Character,String> child = tmpRoot.addChild(ch);
				if(i==(word.length()-1))
				{
					// this is the end of word.
					child.setEnd(true);
				}
				child.addTypeAhead(word);
				tmpRoot = child;
			}else {
				tmpRoot = tmpRoot.getChild(ch);
				tmpRoot.addTypeAhead(word);
			}
		}
	}
	
	/**
	 * This method will search for all typeAhead suggestion
	 * @param ch
	 */
	public void searchAhead(String prefix) {
		TrieNode<Character,String> tmpRoot = root;
		for(int i=0;i<prefix.length();i++) {
			char ch = prefix.charAt(i);
			TrieNode<Character, String> child =  tmpRoot.getChild(ch);
			if(child==null) {
				System.out.println("No Match Found with prefix : "+prefix);
				return;		
			}
			tmpRoot = child;
		}
		System.out.println("Suggestion for: "+ prefix+":  "+tmpRoot.getTypeAhead());
	}
	
	public boolean search(String word) {
		TrieNode<Character,String> tmpRoot = root;
		for(int i=0;i<word.length();i++) {
			char ch= word.charAt(i);
			if(!tmpRoot.hasChild(ch))
				return false;
			tmpRoot = tmpRoot.getChild(ch);
		}
		if(!tmpRoot.isEnd())
			return false;
		return true;
	}
}
