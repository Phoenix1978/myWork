package main.com.me.analysing.entity;

/**
 * This class is the interface that will expose all functions about list that will suppose to be then 
 * analysed
 * @author bj
 *
 */
public interface AnalyserList {  

  /**
   * This function will return an object it it exist in the list
   * @param obj the object to be searched
   * @return an object it it exist in the list, null otherwise
   */
  public Object get (Object obj);
  
  /**
   * Will order a list 
   */
  public void order();

  /**
   * Will add an object to the list
   * This function will add the object only if not already present, otherwise, 
   * the object won't be add, and the count of this word will be increased
   * @param obj the object to be added
   */
  public void add(Object obj);
  
  /**
   * Will give a report of the current list of object analysed
   * @param carrierReturn which is the character to use has the carrier return (<br> \n \r\n ...)
   * @return a String that can then be used as a report
   */
  public String getReport(String carrierReturn);
  
}
