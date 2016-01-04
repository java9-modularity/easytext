package javamodularity.easytext.algorithm.kincaid;

import java.util.List;

import javamodularity.easytext.algorithm.api.Analyzer;

public class KincaidAnalyzer implements Analyzer {
   
   public String getName() {
      return "Flesh-Kincaid";
   }

   public double analyze(List<List<String>> sentences) {
      float totalsentences = sentences.size();
      float totalwords = sentences.stream().mapToInt(sentence -> sentence.size()).sum();
      float totalsyllables = sentences.stream().flatMapToInt(sentence -> sentence.stream().mapToInt(word -> toSyllables(word))).sum();
      return 206.835 - 1.015 * (totalwords / totalsentences) - 84.6 * (totalsyllables / totalwords);
   }

   public static int toSyllables(String word) {
      int syllables = 0;
      boolean prevNonVowel = false;
      for(int i = 0; i < word.length(); i++) {
         boolean isVowel = isVowel(word.toLowerCase().charAt(i));
         if(prevNonVowel && isVowel && i != word.length() - 1) {
            syllables++;
         }
         prevNonVowel = !isVowel;   
      }
      syllables = syllables == 0 ? 1 : syllables;
      return syllables;
   }

   private static boolean isVowel(char letter) {
      return letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
   }

}