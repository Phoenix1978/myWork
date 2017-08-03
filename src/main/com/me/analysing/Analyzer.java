package main.com.me.analysing;

/**
 * This interface will be use to subclass all analyzers
 * @author bj
 */
public interface Analyzer {
    
  /**
   * This function is able to analyse 
   * @param objectToAnalyse the object that we want to have the report
   * @param carrierReturn the character or set of characters to be used as carrier return in the report
   * @return a report that will show what's found 
   */
  public String analyze(Object objectToAnalyse, String carrierReturn) ;
  
}
