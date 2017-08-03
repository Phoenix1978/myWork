package main.com.me.analysing.entity;

/**
 * This class will be instantiated to represent a word found in an analysis
 * @author bj
 *
 */
public class Word extends AnalysingObject{

  /** the text that represents the word itself */
  private String text;  
  
  /**
   * Default constructor
   * @param text the word itself
   */
  public Word(String text) {
    this.text = text;
  }
  
  public String toString(){
    return text;
  }

  /**
   * GETTER / SETTER
   */
  
  public synchronized String getText() {
    return text;
  };
  
}
