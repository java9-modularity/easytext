package javamodularity.easytext.gui;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javamodularity.easytext.algorithm.api.Analyzer;
 
public class Main extends Application {

    private static Iterable<Analyzer> analyzers;
    private static ComboBox algorithm;
    private static TextArea input;
    private static Text output;

    public static void main(String[] args) {
        analyzers = ServiceLoader.load(Analyzer.class);
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("EasyText");
        Button btn = new Button();
        btn.setText("Calculate");
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                output.setText(analyze(input.getText(), (String) algorithm.getValue()));
            }
        });
        
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(3));
        vbox.setSpacing(3);
        Text title = new Text("Choose an algorithm:");
        algorithm = new ComboBox();
        for(Analyzer analyzer: analyzers) {
            algorithm.getItems().add(analyzer.getName());    
        }
        
        vbox.getChildren().add(title);
        vbox.getChildren().add(algorithm);
        vbox.getChildren().add(btn);
        
        input = new TextArea();
        output = new Text();
        BorderPane pane = new BorderPane();
        pane.setRight(vbox);
        pane.setCenter(input);
        pane.setBottom(output);
        primaryStage.setScene(new Scene(pane, 300, 250));
        primaryStage.show();
    }

    private String analyze(String input, String algorithm) {
        for(Analyzer analyzer: analyzers) {
            if(analyzer.getName().equals(algorithm)) {
                return algorithm + ": " + analyzer.analyze(preprocess(input));
            }
        }

        return "No analyzer found for " + algorithm;
    }

   public static List<List<String>> preprocess(String text) {
      String removedBreaks = text.replaceAll("\\r?\\n", " ");
      ArrayList<List<String>> sentences = new ArrayList<>();
      for(String rawSentence: removedBreaks.split("[\\.\\?\\!]")) {
         List<String> words = toWords(rawSentence);
         if(words.size() > 0) {
            sentences.add(words);
         }
      }
      
      return sentences;
   }
   
   public static List<String> toWords(String sentence) {
      String[] rawWords = sentence.split("\\s+");
      List<String> words = new ArrayList<>();
      for(String rawWord: rawWords) {
         String word = rawWord.replaceAll("\\W", "");
         if(word.length() > 0) {
            words.add(word);
         }
      }
      
      return words;
   }
}