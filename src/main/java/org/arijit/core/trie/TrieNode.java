package org.arijit.core.trie;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.arijit.core.suggestion.ISuggestion;
import org.arijit.core.suggestion.LinkedUnweightedSuggestion;

public class TrieNode<T extends Object, K extends Object> {
	private T value;
	private boolean isEnd;
	private Map<T, TrieNode<T, K>> childMap;
	/**
	 * <pre>
	 * typeAheadLinks will contain the actual suggested words. There can be multiple
	 * way to generate typeAheadLinks. 
	 * The simple way to put all the suggestion words into typeAheadLinks without any weightage. 
	 * But this will run out of memory in case of practical implementation. 
	 * Another approach would be to:
	 * implement a AVL tree where the tokenwords will be sorted based on their
	 * weightage. This approach also will have memory issue in practical
	 * implementation.
	 * Better Approach:
	 * Maintain K number of suggestion for each TrieNode. 
	 * This K number of suggestion will be stored in a K size array sorted as per weightage in descending order.
	 * Whenever any new token word with higher frequency will come, all we need to do is just to put it in this array.
	 * Now when all K slot in array will be filled , replace the new token with existing loweset weighted token T only if 
	 * new token is having higher weightage than token T.
	 *  
	 * </pre>
	 * 
	 */
//	private LinkedList<K> typeAheadLinks;
	private ISuggestion<K> typeAheadSuggestions;

	public TrieNode(T value) {
		this.value = value;
	}

	public static <T, K> TrieNode<T, K> create(T value) {
		TrieNode<T, K> node = new TrieNode<T, K>(value);
		return node;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	public void addTypeAhead(K typeAhead) {
		if (typeAheadSuggestions == null) {
			typeAheadSuggestions = new LinkedUnweightedSuggestion<K>();
		}
		typeAheadSuggestions.addSuggestion(typeAhead);
	}

	public Object getTypeAhead() {
		return  typeAheadSuggestions.getSuggestions();
	}

	public boolean hasChild(T t) {
		if (childMap == null || childMap.isEmpty())
			return false;
		return childMap.containsKey(t);
	}

	public TrieNode<T, K> getChild(T t) {
		if (this.childMap == null)
			return null;
		return this.childMap.get(t);
	}

	public TrieNode<T, K> addChild(T t) {
		if (this.childMap == null)
			this.childMap = new HashMap<T, TrieNode<T, K>>();
		TrieNode<T, K> node = new TrieNode<T, K>(t);
		this.childMap.put(t, node);
		return node;
	}

	@Override
	public String toString() {
		return "TrieNode [value=" + value + ", isEnd=" + isEnd + "]";
	}

}
