package com.pram.dictionary.imanage;

import java.io.FileNotFoundException;
import java.util.Set;

import com.param.dictionary.bean.Word;

/**
 * 
 * Interface which helps build the dict
 * 
 * @author kavin.m
 *
 */
public interface IBuildDictionary { 
	
	
	/**
	 * 
	 * Loads data from external source to a file
	 *
	 * @param dataSource
	 * 			End point from the sources are loaded
	 * @return Set of Words
	 * @throws FileNotFoundException 
	 * 
	 */
	Set<Word> loadData(String dataSource) throws FileNotFoundException;
	
	/**
	 * 
	 * Helps clear the in-memory data loaded through load data 
	 * 
	 * @return True if the data cleared is successful
	 */
	boolean clearData();
	
	
}
