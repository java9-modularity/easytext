module javamodularity.easytext.gui { 
   exports javamodularity.easytext.gui to javafx.graphics; // Workaround for Application class usage

   requires javafx.graphics;
   requires javafx.controls;
   requires javamodularity.easytext.algorithm.api;

   uses javamodularity.easytext.algorithm.api.Analyzer;
}
