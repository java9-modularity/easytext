package javamodularity.easytext.algorithm.nextgensyllablecounter;

import javamodularity.easytext.algorithm.api.SyllableCounter;

public class SyllableCounter3Wrapper implements SyllableCounter {

   @Override
   public int countSyllables(String word) {
      return 1;
   }
   
}