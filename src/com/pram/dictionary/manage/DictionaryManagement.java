package com.pram.dictionary.manage;

import java.io.FileNotFoundException;
import java.util.Set;

import com.pram.dictionary.bean.Word;
import com.pram.dictionary.imanage.IBuildDictionary;
import com.pram.dictionary.imanage.ITree;

/**
 * 
 * 
 * Management which handle all the request from UI. 
 * 
 * ##TODO - The Implementation should be abstracted so UI will not depend on the implementation directly.
 * 
 * @author kavin.m
 *
 */
public class DictionaryManagement {

	
	/**
	 * In the management Injection of ITree is only done and it does not know what Implementation 
	 * it is working on. 
	 * 
	 * It can change from Trie to Binary Tree or other data structures in which the business logic will
	 * not change
	 */
	ITree treeDict;
	
	public DictionaryManagement(ITree treeDict) {
		this.treeDict = treeDict;
	}
	
	private DictionaryManagement() {
		
	}
	
	/**
	 * 
	 * Helps to load the data and store it in memory
	 * 
	 * For this case we are fetching the data fromt file. It may change accordingly to DB or other source.
	 * A Simple Factory is Implemented.
	 * @param type
	 * @throws FileNotFoundException
	 */
	public void loadData(String type) throws FileNotFoundException {
		IBuildDictionary buildDictionary = null;
		Set<Word> wordSet = null;
		if(type.equals("file")) {
			buildDictionary = new FileBuildDictionary();
			wordSet = buildDictionary.loadData("words.txt");
		}else if(type.equals("db")) {
			buildDictionary = new DBBuildDictionary();
			wordSet = buildDictionary.loadData("DB End Point");
		}
		for(Word word : wordSet) {
			treeDict.insert(word.getSpell(),word);
		}
	}

	
	/**
	 * 
	 * It implemets the search word from the Tree.
	 * @param word
	 * @return a word object
	 */
	public Word searchWord(String word) {
		return treeDict.search(word);
	}
	
	
}
