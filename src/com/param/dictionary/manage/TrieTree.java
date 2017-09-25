package com.param.dictionary.manage;

import java.util.HashSet;
import java.util.Set;

import com.param.dictionary.bean.TrieNode;
import com.param.dictionary.bean.Word;
import com.pram.dictionary.imanage.ITree;

/**
 * 
 * Implementation of Tree Interface with the Trie Structure
 * 
 * Reason for selecting this DS
 * 
 * https://www.toptal.com/java/the-trie-a-neglected-data-structure
 * 
 * @author kavin.m
 *
 */
public class TrieTree implements ITree

{
    private TrieNode root;
 
    
    /**
     * Default constructor to initialize the root node.
     */
    public TrieTree()
    {
        root = new TrieNode(' '); 
    }

    @Override
    public void insert(String word,Word dictinoryWord)
    {
        if (search(word) != null) 
            return;        
        TrieNode current = root; 
        for (char ch : word.toCharArray() )
        {
            TrieNode child = current.subNode(ch);
            if (child != null)
                current = child;
            else 
            {
                 current.getChildList().add(new TrieNode(ch));
                 current = current.subNode(ch);
            }
            current.setCount(current.getCount() + 1);
        }
        current.setEnd(true);
        current.setWord(dictinoryWord);
    }
    
    @Override
    public Word search(String word)
    {
        TrieNode current = root;  
        for (char ch : word.toCharArray() )
        {
            if (current.subNode(ch) == null)
                return null;
            else
                current = current.subNode(ch);
        }      
        if (current.isEnd() == true) 
            return current.getWord();
        return null;
    }

    @Override
    public void remove(String word)
    {
        if (search(word) == null)
        {
            System.out.println(word +" does not exist in trie\n");
            return;
        }             
        TrieNode current = root;
        for (char ch : word.toCharArray()) 
        { 
            TrieNode child = current.subNode(ch);
            if (child.getCount() == 1) 
            {
                current.getChildList().remove(child);
                return;
            } 
            else 
            {
                child.setCount(child.getCount() - 1);
                current = child;
            }
        }
        current.setEnd(false);
    }
}
