package javamodularity.easytext.algorithm.naivesyllablecounter;

import org.junit.Test;
import javamodularity.easytext.algorithm.api.SyllableCounter;

import static org.junit.Assert.assertEquals;

public class NaiveSyllableCounterTest {
   
   private SyllableCounter counter = new NaiveSyllableCounter();

   @Test
   public void testSyllableCounter() {
      assertEquals(2, counter.countSyllables("testing"));
   }

}