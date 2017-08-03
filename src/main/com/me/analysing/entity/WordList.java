package main.com.me.analysing.entity;

/**
 * This class is responsible of managing a list of word
 * @author bj
 *
 */
public class WordList implements AnalyserList {

  private Word[] wordList;
  private int index = 0;
  
  /**
   * Default constructor
   * @param countObject the initial size of the word list
   */
  public WordList(int countObject) {
    wordList = new Word[Math.max(countObject, 0)];    
  }
  
  /**
   * @see com.me.analysing.AnalyserList.isContaining
   */
  @Override 
  public final Object get (Object obj){
    if (! (obj instanceof Word)) {
      return null;
    }
    for (int iW=0 ; iW < wordList.length - 1 ; iW++) {
      if (wordList[iW] != null 
          && wordList[iW].getText().equals(((Word) obj).getText())) { 
        return wordList[iW];
      }
    }
    return null;
  };  
  
  /**
   * @see com.me.analysing.AnalyserList.order
   */
  @Override 
  public final void order() {
    Word[][] tempList = new Word[wordList.length + 1][wordList.length + 1];
    Word[] newList = new Word[wordList.length];
    int newIndex = 0;
    int[] indexes = new int[wordList.length + 1];
    Word temp;
    // order by count of words first
    for(int iW=0 ; iW < wordList.length - 1 ; iW++) {
      // if no word of this count exists
      if(wordList[iW] == null){
        continue;
      }
      // if not already initialized, we do it
      if(tempList[wordList[iW].getCount()] == null){
        tempList[wordList[iW].getCount()] = new Word[wordList.length + 1];
      }
      tempList[wordList[iW].getCount()][indexes[wordList[iW].getCount()]++] = wordList[iW];
    }

    // order by ascii code of the same word count
    for(int iGroupWord = 1; iGroupWord < tempList.length ; iGroupWord++) {
      // a group represent word of same count of letters 
      Word[] group = tempList[iGroupWord];
      if (group == null) {
        continue;
      }
      for (int j = 0; j < group.length; j++) {
        if(group[j] == null){
          break;
        }
        for (int i = j + 1; i < group.length ; i++) {
          if(group[i] == null){
            break;
          }
          if (group[i].getText().compareTo(group[j].getText()) < 1) {
            temp =     group[i];
            group[i] = group[j];
            group[j] = temp;
          }
        }
      }
      for (int j = 0; j < group.length; j++) {
        // it may have some count of letters for which no word exists
        if(group[j] == null){
          break;
        }
        newList[newIndex++] = group[j];
      }
    }    
    // we replace the old list by the one ordered
    wordList = newList;
  }

  /**
   * @see com.me.analysing.AnalyserList.add
   */
  @Override 
  public final void add(Object word){
    if (word == null) {
      return;
    }
    Word newWord = new Word((String) word);
    Word oldWord = (Word) get(newWord);
    if (oldWord != null) {
      oldWord.addOccur();
    } else {
      wordList[index++] = newWord;
    }
  }

  /**
   * @see com.me.analysing.AnalyserList.getReport
   */
  @Override 
  public String getReport(String carrierReturn) {
    if (carrierReturn == null) {
      carrierReturn = "\n";
    }
    StringBuilder report = new StringBuilder("");
    for(Word word : wordList){
      if (word != null) {
        report
          .append(word.getCount())
          .append(" ")
          .append(word.toString())
          .append(carrierReturn);
      }
    };
    return report.toString();
  }  
}
