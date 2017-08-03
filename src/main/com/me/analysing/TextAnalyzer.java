package main.com.me.analysing;

import main.com.me.analysing.entity.WordList;

/**
 * This class will analyse a text, giving a report on word statistics
 * @author bj
 *
 */
public class TextAnalyzer implements Analyzer {
    
  @Override 
  public String analyze(Object phrase, String carrierReturn){    
    // if the given object are not the right type 
    if (phrase == null 
        || !(phrase instanceof String) 
        || ((String) phrase).length() == 0) { 
      return "";
    }
    // Splitting and set of the word list
    String[] words = ((String) phrase).split(" ");
    WordList wordList = new WordList(words.length);    
    for (int iW = 0; iW < words.length ; iW++) {
      wordList.add(words[iW]);
    }    
    // Ordering and returning the report;
    wordList.order();    
    return wordList.getReport(carrierReturn);    
  }
  
  /**
   * Main function to be called out there
   * @param args the first args of this array must contains the phrase to be analysed
   */
  public static void main (String args[]){
    String textToAnalyse = "The quick brown fox jumped over the lazy brown dog’s back";
    if (args.length != 0) {
      textToAnalyse = args[0];
    }
    String report = new TextAnalyzer().analyze(textToAnalyse, "\n");
    System.out.println(report);    
  }  
}
