module javamodularity.easytext.algorithm.naivesyllablecounter { 
  requires javamodularity.easytext.algorithm.api;

  provides javamodularity.easytext.algorithm.api.SyllableCounter 
    with javamodularity.easytext.algorithm.naivesyllablecounter.NaiveSyllableCounter;
}
