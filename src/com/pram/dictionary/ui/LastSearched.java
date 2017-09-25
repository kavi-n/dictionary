package com.pram.dictionary.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Queue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * 
 * This class gives last searched elements in the Dict 
 * 
 * @author kavin.m
 *
 */
public class LastSearched {

	/**
	 * Gives the JList to be attached to the panel
	 */
	private static JList lastSearchedList;
	
	/**
	 * This helps us update the List after the JList is binded with the panel
	 */
	private static DefaultListModel searchData;
	
    /**
     * Set to private so Object cannot be created with new keyword.
     */
    private LastSearched() {

    }


    /**
     * Only Initializes once and plays/modifies only the data.
     * 
     * TODO: Singleton design pattern can be implemented if we need to support concurrency 
     * 
     * @param searchDataList
     * @return JList with changed data
     */
    public static JList getLastSearchedList(Queue<String> searchDataList){
    	
    	if(lastSearchedList == null) {
    		initializeSearchList();
    	}
    	
    	searchData.removeAllElements();
    	if(searchDataList.size() > 5) {
    		searchDataList.remove();
    	}
    	for(String searchString : searchDataList) {
    		searchData.addElement(searchString);
    	}
    	
        return lastSearchedList;
    }


	/**
	 *
	 *Initializes the JList and sets a listener to it
	 * 
	 */
	private static void initializeSearchList() {
		searchData = new DefaultListModel();
		lastSearchedList = new JList(searchData);
		lastSearchedList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                // TODO - Once the value in the last searched item is clicked it should reload the search again.
            }
        });
		
	}
    
    
    
}
