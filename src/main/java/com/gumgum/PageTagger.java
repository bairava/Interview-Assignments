package com.gumgum;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
/**
 * @author Bairava Raman
 * 
 * Module to perform text tagging from the entered URL
**/
public class PageTagger {

static final String TAGGER_MODEL ="english-left3words-distsim.tagger";
MaxentTagger maxTagger = null;
private Document htmlDocument;
/**
 * Main method
 * @param The URL String passed as argument
 * @return void
 **/
public static void main(String[] args) throws MalformedURLException {
		PageTagger pageTaggerObject = new PageTagger();
		URL input = null;
		try {
			input = new URL(args[0]);
			String sample = pageTaggerObject.getText(input);
			PrintWriter printWriter = new PrintWriter("Tagged_Output.txt");
			printWriter.write(pageTaggerObject.tagText(sample));
			printWriter.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
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
/**
 * Method to retrieve the plain text from given URL
 * @param URL
 * @return String
 **/
public String getText(URL inputURL) throws IOException{
	Connection connection = Jsoup.connect(inputURL.toString()).maxBodySize(Integer.MAX_VALUE).userAgent("Chrome/13.0.782.112");
	htmlDocument = connection.get();
	ContentExtractor extractor = new ContentExtractor();
	StringBuilder text= new StringBuilder(extractor.extractFromDocument(htmlDocument));
	String response = text.toString();
	return response;
	}
}