package org.arijit.typeaheadDS.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.arijit.core.trie.Trie;

public class TestTrie {

	public static void main(String args[]) throws IOException {
		Trie trie = Trie.create();
		trie.insert("Apple");
		trie.insert("Angle");
		trie.insert("Bat");
		trie.insert("Batman");
		trie.insert("Battle");
		String key = "Batman";
		System.out.println("is "+key+" present?"+trie.search(key));
		
		trie.searchAhead("Battle");
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(reader);
		   
		
		System.out.println("Type ");
		while(true) {
			String prefix = br.readLine();		
			if(prefix.equals("$exit"))
				System.exit(0);
			trie.searchAhead(prefix);
			
		}
		
		
	}
}
