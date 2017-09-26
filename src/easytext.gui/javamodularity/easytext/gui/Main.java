package javamodularity.easytext.gui;

import java.lang.module.*;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

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
import javafx.stage.DirectoryChooser;

import javamodularity.easytext.algorithm.api.Analyzer;
import static javamodularity.easytext.algorithm.api.Preprocessing.toSentences;

public class Main extends Application {

    private static List<Analyzer> analyzers = new ArrayList<>();
    private static ComboBox<String> algorithm;
    private static TextArea input;
    private static Text output;
    private static String sampleText;

    public static void main(String[] args) {
        ServiceLoader.load(Analyzer.class).forEach(analyzers::add);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("EasyText");
        Button btn1 = new Button();
        btn1.setText("Calculate");
        btn1.setOnAction(event ->
          output.setText(analyze(input.getText(), (String) algorithm.getValue()))
        );

        Button btn2 = new Button();
        btn2.setText("Add analysis");
        btn2.setOnAction(event -> {
          File file = new DirectoryChooser().showDialog(primaryStage.getOwner());
          if (file != null) {
            ModuleLayer layer = loadAnalysisInLayer(file);
            ServiceLoader.load(layer, Analyzer.class).forEach(analyzers::add);
            updateAlgorithmsDropdown();
          }
        });


        VBox vbox = new VBox();
        vbox.setPadding(new Insets(3));
        vbox.setSpacing(3);
        Text title = new Text("Choose an algorithm:");
        algorithm = new ComboBox<>();
        updateAlgorithmsDropdown();

        vbox.getChildren().add(title);
        vbox.getChildren().add(algorithm);
        vbox.getChildren().add(btn1);
        vbox.getChildren().add(btn2);

        input = new TextArea();
        input.setText(sampleText);
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
                return algorithm + ": " + analyzer.analyze(toSentences(input));
            }
        }

        return "No analyzer found for " + algorithm;
    }

    private void updateAlgorithmsDropdown() {
      algorithm.getItems().clear();
      for(Analyzer analyzer: analyzers) {
          algorithm.getItems().add(analyzer.getName());
      }
    }

    private ModuleLayer loadAnalysisInLayer(File dir) {
      ModuleFinder finder = ModuleFinder.of(dir.toPath());

      ModuleLayer parent = ModuleLayer.boot();
      Configuration cf = parent.configuration()
        .resolveAndBind(finder, ModuleFinder.of(), Set.of());

      ClassLoader scl = ClassLoader.getSystemClassLoader();
      ModuleLayer layer = parent.defineModulesWithOneLoader(cf, scl);

      return layer;
    }

    static {
      try {
        sampleText = new String (java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("testinput.txt")));
      } catch (java.io.IOException ioe) {
        sampleText = "Paste text here";
      }
    }
}
