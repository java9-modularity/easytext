module javamodularity.easytext.algorithm.kincaid {

   requires javamodularity.easytext.algorithm.api;

   provides javamodularity.easytext.algorithm.api.Analyzer with javamodularity.easytext.algorithm.kincaid.KincaidAnalyzer;
   
   uses javamodularity.easytext.algorithm.api.SyllableCounter;
}