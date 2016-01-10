module javamodularity.easytext.algorithm.nextgensyllablecounter {
  requires javamodularity.easytext.algorithm.api;
  requires syllablecounter3; // Automatic module: name derived from library jar name

  provides javamodularity.easytext.algorithm.api.SyllableCounter 
    with javamodularity.easytext.algorithm.nextgensyllablecounter.SyllableCounter3Wrapper;

}

