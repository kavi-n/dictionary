package com.pram.dictionary.ui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *             	// TODO: Words from the Trie to be added after typing atleast three words in the
            	// Search Field
 * 
 * @author David
 * 
 * Lifted from Internet
 *
 */
public class Suggestions implements Runnable {

	private JTextField searchBox;
	
	private JFrame dictonaryFrame;
	
    public Suggestions(JFrame dictonaryFrame,JTextField searchBox) {
    	this.dictonaryFrame = dictonaryFrame;
    	this.searchBox = searchBox;
    }
    
    
    public void buildAutoSuggestor() {
    	AutoSuggestor autoSuggestor = new AutoSuggestor(searchBox, dictonaryFrame, null, Color.WHITE.brighter(), Color.BLUE, Color.RED, 0.75f) {
            @Override
            boolean wordTyped(String typedWord) {

            	// TODO: Words from the Trie to be added after typing atleast three words in the
            	// Search Field
            	ArrayList<String> words = new ArrayList<>();
                words.add("hello");
                words.add("heritage");
                words.add("happiness");
                words.add("goodbye");
                words.add("cruel");
                words.add("car");
                words.add("war");
                words.add("will");
                words.add("world has");
                words.add("wall");

                setDictionary(words);
                //addToDictionary("bye");//adds a single word

                return super.wordTyped(typedWord);//now call super to check for any matches against newest dictionary
            }
        };
    }
    
	@Override
	public void run() {
		buildAutoSuggestor();
	}

}
