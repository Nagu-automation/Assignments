package javaMarathon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * A sentence is a list of words that are separated by a single space with no
 * leading or trailing spaces.
 * 
 * You are given an array of strings sentences, where each sentences[i]
 * represents a single sentence.
 * 
 * Return the maximum number of words that appear in a single sentence.
 */

public class JavaProblem_13 {

	public static int maxCount(String[] input) {
		
		// Getting the array of sentences
		String[] sentences = input;
		List<String> wordsList = new ArrayList<String>();
		List<Integer> wordsCountList = new ArrayList<Integer>();
		int wordsCount = 0;
		String[] wordArray;

		// Iterating the loop to go over one by one sentence
		for (int i = 0; i < sentences.length; i++) {
			wordsList.add(sentences[i]);

		}

		// Splitting the words of the each sentence and storing the count in the list
		// variable
		for (String words : wordsList) {
			wordArray = words.split(" ");
			wordsCount = wordArray.length;
			wordsCountList.add(wordsCount);
		}

		// Sorting the list and getting the maximum count
		Collections.sort(wordsCountList);
		return wordsCountList.get(wordsCountList.size() - 1);
	}

	public static void main(String[] args) {

		String[] input = { "alice and bob love leetcode", "i think so too", "this is great thanks very much" };
		int output = maxCount(input);
		System.out.println("The maximum number of words that appear in a single sentence is: " + output);

	}

}
