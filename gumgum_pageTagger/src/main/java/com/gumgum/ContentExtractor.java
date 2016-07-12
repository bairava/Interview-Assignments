package com.gumgum;
import org.jsoup.nodes.Document;
/**
 * @author Bairava Raman
 * 
 * Module to extract content from Document
**/
public class ContentExtractor {
/**
* Method to extract the plain text contents
* @param Document
* @return String
**/
public String extractFromDocument(Document doc){
		doc.select("nav, .nav, .navbar, [class*=nav]").remove();
		doc.select("header, .header, .head, #header, #head").remove();
		doc.select("footer, .footer, #footer").remove();
		doc.select(".sidebar, #sidebar, [class^=sidebar], aside, [class^=aside]").remove();
		doc.select("[class*=social], [id*=social], [class*=shar], [id*=share]").remove();
		doc.select("[class*=breadcrumb], [id*=breadcrumb]").remove();
		doc.select("[href*=facebook], [href*=twitter], [href*=youtube], [href*=pintrest]").remove();
		doc.select("iframe, embed").remove();
		String text = doc.body().text();
		return text;
	}
}