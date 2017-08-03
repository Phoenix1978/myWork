package test;
import static org.junit.Assert.assertEquals;
import main.com.me.analysing.TextAnalyzer;

import org.junit.Test;

/**
 * This class is responsible to unit test the text analyser 
 * @author bj
 *
 */
public class WordListTester {

  @Test
  public void test() {
    String textToAnalyse = "The quick brown fox jumped over the lazy brown dog’s back";    
    String report = new TextAnalyzer().analyze(textToAnalyse, "\n");
    assertEquals(report, "1 The\n1 back\n1 dog’s\n1 fox\n1 jumped\n1 lazy\n1 over\n1 quick\n1 the\n2 brown\n");
    report = new TextAnalyzer().analyze(textToAnalyse, null);
    assertEquals(report, "1 The\n1 back\n1 dog’s\n1 fox\n1 jumped\n1 lazy\n1 over\n1 quick\n1 the\n2 brown\n");
    textToAnalyse = "un un un un un un un un un un ";
    report = new TextAnalyzer().analyze(textToAnalyse, "<br>");
    assertEquals(report, "10 un<br>");
    report = new TextAnalyzer().analyze("", null);
    assertEquals(report, "");
    report = new TextAnalyzer().analyze(new Object(), null);
    assertEquals(report, "");
  }

}
