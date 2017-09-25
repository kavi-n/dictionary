package com.pram.dictionary.bean;

import java.util.LinkedList;

/**
 * 
 * 
 * Holder Class which helps to build the Tire Data structure
 * 
 * @author kavin.m
 *
 */
/**
 * @author kavin.m
 *
 */
public class TrieNode 
{
    char content; 
    private boolean isEnd; 
    private int count;  
    private LinkedList<TrieNode> childList;
    /**
     * With the default Trie Implementation attaching the Word Object so once searched will also
     * also return the word object so show it in the UI
     */
    private Word word;
 
    /**
     * @param c
     */
    public TrieNode(char c)
    {
        setChildList(new LinkedList<TrieNode>());
        setEnd(false);
        content = c;
        setCount(0);
    }  
    
    
    
    public TrieNode subNode(char c)
    {
        if (getChildList() != null)
            for (TrieNode eachChild : getChildList())
                if (eachChild.content == c)
                    return eachChild;
        return null;
    }

	public LinkedList<TrieNode> getChildList() {
		return childList;
	}

	public void setChildList(LinkedList<TrieNode> childList) {
		this.childList = childList;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}


	public Word getWord() {
		return word;
	}


	public void setWord(Word word) {
		this.word = word;
	}


}
