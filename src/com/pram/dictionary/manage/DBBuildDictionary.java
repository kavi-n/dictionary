package com.pram.dictionary.manage;

import java.util.Set;

import com.pram.dictionary.bean.Word;
import com.pram.dictionary.imanage.IBuildDictionary;

/**
 * 
 * Used to build the dictionary using DB data. 
 * 
 * @author kavin.m
 *
 */
public class DBBuildDictionary implements IBuildDictionary {

	@Override
	public Set<Word> loadData(String dataSource) {
		return null;
	}

	@Override
	public boolean clearData() {
		// TODO 
		return false;
	}


}
