module javamodularity.easytext.algorithm.nextgensyllablecounter {
  requires javamodularity.easytext.algorithm.api;
  requires syllablecounter3;

  provides javamodularity.easytext.algorithm.api.SyllableCounter 
    with javamodularity.easytext.algorithm.nextgensyllablecounter.SyllableCounter3Wrapper;

}

