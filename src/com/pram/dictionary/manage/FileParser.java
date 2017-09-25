package com.pram.dictionary.manage;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.pram.dictionary.bean.Word;

/**
 * 
 * Used to parse the input file - Naive Not tested Well
 * 
 * @author kavin.m
 *
 */
public class FileParser {

	public Set<Word> parseFile(String inputFile) {
		String[] inputFileArray = inputFile.split("#");
		Set<Word> wordSet = new HashSet<>();
		Word word = null;
		for(String value:inputFileArray) {
			if(value.contains("--")) {
			String[] mainString = value.split("--");
			String string = mainString[0];
			if(!string.isEmpty()) {
			string = string.replaceAll("\\[.*?\\] ?", "");
			string = string.replaceAll("^[\\s\\d]+", "");
			string = string.replaceAll("\\.", "").trim();
			if(!string.matches("\\s+")) {
				word = new Word();
				word.setSpell(string);
				word.setSynonyms(mainString[1]);
				word.setType(null);
				word.setPhrase(null);
				Pattern p = Pattern.compile("\"([^\"]*)\"");
				Matcher m = p.matcher(mainString[1]);
				while (m.find()) {
					word.setPhrase(m.group(1));
				}
			}
			}
			wordSet.add(word);
			}
		}
		return wordSet;
	}
	
}
