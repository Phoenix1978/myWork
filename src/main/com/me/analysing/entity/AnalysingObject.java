package main.com.me.analysing.entity;

/**
 * Main class of all object that will be analyzable
 * @author bj
 *
 */
public class AnalysingObject {

  /** the number of time this word has been found, can be used to sort this word in a list */
  private int count = 1;
  
  /**
   * Will be called when this word is found another time in a text
   */
  public synchronized final void addOccur(){
    this.count++;
  }

  /**
   * GETTER / SETTER
   */
  
  public synchronized int getCount() {
    return count;
  }
  
}
