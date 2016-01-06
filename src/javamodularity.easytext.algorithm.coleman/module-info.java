module javamodularity.easytext.algorithm.coleman {

   requires javamodularity.easytext.algorithm.api;

   provides javamodularity.easytext.algorithm.api.Analyzer with javamodularity.easytext.algorithm.coleman.ColemanAnalyzer;

}