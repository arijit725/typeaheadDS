package org.arijit.core.suggestion;

import java.util.LinkedList;
/**
 * LinkedUnweightedSuggestion is a simple LinkedList Based implementation, which does not consider any weightage.
 * It simply adds the probable suggestions into LikedList in an unbounded manner.
 * This is not a production level implementation.
 * 
 * @author ARIJIT
 *
 * @param <T>
 */
public class LinkedUnweightedSuggestion<T> implements ISuggestion<T> {

	private LinkedList<T> linkedSuggestion;
	
	public LinkedUnweightedSuggestion() {
		this.linkedSuggestion = new LinkedList<T>();
	}
	@Override
	public void addSuggestion(T typeAhead) {		
		linkedSuggestion.add(typeAhead);		
	}
	
	@Override
	public Object getSuggestions() {
		
		return linkedSuggestion;
	}
	
	

	
}
