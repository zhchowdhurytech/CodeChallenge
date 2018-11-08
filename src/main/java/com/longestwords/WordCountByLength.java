package com.longestwords;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashSet;
import java.util.Set;

/**
 * The WordCountByLength program will be print the largest word(s) in a sentence
 * and the length of the word(s).
 *
 * @author Chowdhury
 * @version 1.0
 */
public class WordCountByLength {

	private static final Logger LOGGER = LogManager.getLogger("MaximumLenthyWordCounter");

	// This is a CountWordlength class
	public static class CountWordlength {
		public Set getLengthyWordsSet() {
			return longestWordsSet;
		}

		public int getMaximumWordLength() {
			return maximumLength;
		}

		// this variable will hold the set of lengthy words
		private Set longestWordsSet;
		// this variable will hold the length of longest words
		private int maximumLength;

		public CountWordlength(Set wordsSet, int length) {
			longestWordsSet = wordsSet;
			maximumLength = length;
		}
	}

	/**
	 * This method will determine longest word in a sentence
	 * 
	 * @param inputString input will be print
	 * @return longest word and lenght
	 */
	public static CountWordlength maximumLengthWord(String inputString) {

		if ("".equals(inputString)) {
			LOGGER.info("Read input. Please enter a valid sentence input");
			return new CountWordlength(null, 0);
		}
		if (inputString == null) {
			LOGGER.info("Null input. Please enter a valid sentence input");
			return new CountWordlength(null, 0);
		}

		int maxLength = 0;

		String[] words = sentenceToArrayConverter(inputString);

		// this will be make sure only unique words are returned as answer
		Set<String> longWords = new HashSet<>();
		longWords.clear();

		// For loop will return length and each word
		// word(s)
		for (String word : words) {
			if (word.length() > maxLength) {
				longWords.clear();
				longWords.add(word);
				maxLength = word.length();
			} else if (word.length() == maxLength) {
				longWords.add(word);
			}
		}

		LOGGER.info("Maxmiumlength: " + maxLength + " Long word(s): " + longWords);
		return new CountWordlength(longWords, maxLength);
	}

	/**
	 *
	 * This method is used to split an input string into words. The split is based
	 * on a regular expression. A word consists of alphabets, digits hyphens and
	 * paranthesis.
	 * 
	 * @param inputString This is the input string to be analyzed
	 * @return String[] This is an array of all the words
	 */
	private static String[] sentenceToArrayConverter(String inputString) {
		// convert to lowercase
		String trimmedInput = inputString.trim().toLowerCase();

		// convert string in to array of words
		String[] inputWords = trimmedInput.split("[^a-zA-Z'0-9-()]+");
		LOGGER.info("Total Words: " + inputWords.length);
		for (String s : inputWords) {
			LOGGER.info(s);
		}

		return inputWords;
	}
}
