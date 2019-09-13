package org.arijit.core.token;

/**
 * 
 * @author ARIJIT
 *
 */
public class TokenWord {

	private String word;
	private int weight;
	
	private TokenWord(String word) {
		this.word = word;
	}
	
	private TokenWord(String word, int weight) {
		this.word = word;
		this.weight = weight;
	}
	/**
	 * LinkAhead List will be sorted using this weight.
	 * @param word
	 * @param weight
	 */
	public static void createWeightedTokenWord(String word, int weight) {
		
	}
}
