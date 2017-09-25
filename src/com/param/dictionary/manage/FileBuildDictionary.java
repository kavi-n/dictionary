package com.param.dictionary.manage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import com.param.dictionary.bean.Word;
import com.pram.dictionary.imanage.IBuildDictionary;


/**
 * Implementation of Build dictionary - for INPUT File
 * 
 * @author kavin.m
 *
 */
public class FileBuildDictionary implements IBuildDictionary {

	@Override
	public Set<Word> loadData(String dataSource)  {
		File file = getFileResource(dataSource);
		FileParser fileParser = new FileParser();
		FileInputStream fis;
		byte[] data = null;
		String inputFile = null;
		try {
			fis = new FileInputStream(file);
			data = new byte[(int) file.length()];
			fis.read(data);
			fis.close();
			inputFile = new String(data, "UTF-8");
			return fileParser.parseFile(inputFile);
		} catch (IOException e) {
			// Execption should be throwed. A custom exception to be written which will throw same kind of error
			// on both FileBuildDictionary & DBBuildDictionary
			System.out.println("Error finding the file "+e);
		}
		return null; 
	}


	@Override
	public boolean clearData() {
		// TODO Auto-generated method stub
		return false;
	}

	
	/**
	 * 
	 * To get the file resource 
	 * @param dataSource File Name
	 * @return File Object
	 */
	private File getFileResource(String dataSource) {
		String absPath = new File("").getAbsolutePath()+"/src/";
		File file = new File(absPath+dataSource);
		return file;
	}

}
