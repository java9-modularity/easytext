module javamodularity.easytext.gui { 
   // JavaFX needs to instantiate our Main Application class
   exports javamodularity.easytext.gui to javafx.graphics; 

   requires javafx.graphics;
   requires javafx.controls;
   requires javamodularity.easytext.algorithm.api;

   uses javamodularity.easytext.algorithm.api.Analyzer;
}
