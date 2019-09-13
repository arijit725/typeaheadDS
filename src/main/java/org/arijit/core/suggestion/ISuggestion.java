package org.arijit.core.suggestion;

/**
 * Any suggestion class should extend this ISuggestion interface
 * 
 * @author ARIJIT
 *
 * @param <T>
 */
public interface ISuggestion<T extends Object> {

	public void addSuggestion(T typeAhead);
	
	public  Object getSuggestions();
}
