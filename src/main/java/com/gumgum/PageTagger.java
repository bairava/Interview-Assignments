package com.gumgum;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
/**
 * @author Bairava Raman
 * 
 * Module to perform text tagging from the entered URL
**/
public class PageTagger {
//Tagger Model used
static final String TAGGER_MODEL ="english-left3words-distsim.tagger";
MaxentTagger maxTagger = null;

public static void main(String[] args) {
		PageTagger pageTaggerObject = new PageTagger();
			String sample = "Testing the tagger module";
			System.out.println(pageTaggerObject.tagText(sample));
	}

/**
 * Method to tag the text
 * @param String
 * @return String
 **/
public String tagText(String inputText){
	maxTagger = new MaxentTagger(TAGGER_MODEL);
	String result = maxTagger.tagString(inputText);
	return result;
	} 
}