package com.pram.dictionary.imanage;

import com.param.dictionary.bean.Word;

/**
 *
 * Interface for implementing the tree structure.
 * 
 * @author kavin.m
 *
 */
public interface ITree {

	/**
	 * 
	 * To insert a word into Tree.
	 * 
	 * @param word
	 */
	public void insert(String word,Word dictinoryWord);
	
	/**
	 * 
	 * To search a word in the tree.
	 * @param word
	 * @return
	 */
	public Word search(String word);
	
	/**
	 * 
	 * To remove a word from the tree.
	 * 
	 * @param word
	 */
	public void remove(String word);
	
}
