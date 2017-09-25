package com.param.dictionary.bean;

import java.util.Set;

/**
 * 
 * POGO to hold the word information
 * 
 * @author kavin.m
 *
 */
/**
 * @author kavin.m
 *
 */
public class Word {

	/**
	 * Type of the word  - adverb,preposition,noun,Verb
	 */
	private String type;
	
	/**
	 * How the word is spelt
	 */
	private String spell;
	
	/**
	 * Meaning of the word
	 */
	private String synonyms;
	
	/**
	 * Opposite of the word
	 */
	private String antonyms;
	
	
	/**
	 * Phrase with the word
	 */
	private String phrase;

	/**
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 * 			Sets Type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return 
	 * 		the spell of word
	 */
	public String getSpell() {
		return spell;
	}

	/**
	 * @param spell
	 * 			Sets the Spell of the word.
	 */
	public void setSpell(String spell) {
		this.spell = spell;
	}

	/**
	 * @return
	 * 		get the meaning of the word.
	 */
	public String getSynonyms() {
		return synonyms;
	}

	/**
	 * @param synonyms
	 * 			Set the meaning of the word.
	 */
	public void setSynonyms(String synonyms) {
		this.synonyms = synonyms;
	}

	/**
	 * @return
	 * 		Opposite meaning of the word
	 */
	public String getAntonyms() {
		return antonyms;
	}

	/**
	 * 
	 * @param antonyms
	 * 			Sets the opposite meaning of the word.
	 */
	public void setAntonyms(String antonyms) {
		this.antonyms = antonyms;
	}

	/**
	 *To get the Phrase
	 * @return
	 * 	Phrase
	 */
	public String getPhrase() {
		return phrase;
	}
	
	
	/**
	 * Sets Phrase
	 * @param phrase
	 */
	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((antonyms == null) ? 0 : antonyms.hashCode());
		result = prime * result + ((spell == null) ? 0 : spell.hashCode());
		result = prime * result + ((synonyms == null) ? 0 : synonyms.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		if (antonyms == null) {
			if (other.antonyms != null)
				return false;
		} else if (!antonyms.equals(other.antonyms))
			return false;
		if (spell == null) {
			if (other.spell != null)
				return false;
		} else if (!spell.equals(other.spell))
			return false;
		if (synonyms == null) {
			if (other.synonyms != null)
				return false;
		} else if (!synonyms.equals(other.synonyms))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Word [type=" + type + ", spell=" + spell + ", synonyms=" + synonyms + ", antonyms=" + antonyms + "]";
	}

	
}
